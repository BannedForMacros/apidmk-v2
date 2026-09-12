/* ============================================================================
   V001 · Esquema propio de Guías de Remisión  ·  schema [gre]
   ----------------------------------------------------------------------------
   OBJETIVO
     Sacar el flujo de guías de las manos de los stored procedures del ERP.
     La guía se guarda AQUÍ primero y siempre. El envío al DataMart del ERP
     pasa a ser un paso posterior, reintentable, que si falla NO pierde la guía.

   POR QUÉ
     Evidencia medida sobre db_travel (2026-06-24):
       · 45 guías marcadas estadoproceso=1, solo 38 llegaron a GuiaRemision.
         8 se dieron por exitosas y nunca se guardaron.
       · audit_InsertarGuiasOdooDmk registra 3x
         "Invalid object name 'TMPGuiaTransferencia_Odoo'".
       · InsertarGuiasOdooDmk crea TMPGuia*_Odoo como tablas FÍSICAS en dbo
         pero su limpieza final las busca en tempdb -> nunca las borra ->
         dos guías concurrentes se pisan.
       · El detalle depende de INNER JOIN MaestroArticulo: si el artículo no
         está replicado, la línea se descarta sin aviso.

   COMPATIBILIDAD
     SQL Server 2008 (compatibility_level 100). Sin THROW, sin SEQUENCE,
     sin OFFSET/FETCH, sin STRING_AGG. TRY/CATCH y MERGE sí están disponibles.

   PROPIEDAD
     Todo lo que vive en [gre] es nuestro. Ningún objeto del ERP se modifica.
     Si el cliente actualiza su DMK/POSM, esto sigue funcionando.
   ========================================================================== */

SET NOCOUNT ON;
GO

IF NOT EXISTS (SELECT 1 FROM sys.schemas WHERE name = 'gre')
    EXEC('CREATE SCHEMA gre');
GO

/* ---------------------------------------------------------------------------
   gre.Guia  ·  cabecera. FUENTE DE VERDAD.
   Se escribe antes de tocar un solo objeto del ERP.
   --------------------------------------------------------------------------- */
IF OBJECT_ID('gre.Guia','U') IS NULL
BEGIN
CREATE TABLE gre.Guia (
    GuiaId              bigint           IDENTITY(1,1) NOT NULL,
    IdempotencyKey      uniqueidentifier NOT NULL,

    -- identidad del documento
    AnioGuia            smallint         NOT NULL,
    TipoGuia            char(1)          NOT NULL,   -- N = ingreso, A = salida
    NumSerie            int              NOT NULL,
    NumeroGuia          bigint           NOT NULL,

    FechaEmision        datetime         NOT NULL,
    FechaInicioTraslado datetime         NULL,       -- fallback a FechaEmision en la lectura

    -- contexto
    CodEstacion         int              NULL,
    CodAlmacen          int              NULL,
    CodAlmacenOrigen    int              NULL,
    CodAlmacenDestino   int              NULL,
    CodListaPrecio      int              NULL,
    TipoOperacion       int              NOT NULL,
    CodTrabajador       int              NULL,
    CodProveedor        int              NULL,
    CodCliente          int              NULL,
    FormaPago           int              NULL,
    TipoMoneda          int              NOT NULL CONSTRAINT DF_gre_Guia_Moneda DEFAULT (1),
    Comentario          varchar(500)     NULL,

    -- traslado (solo salida)
    ModalidadTransporte varchar(2)       NULL,
    DireccionPartida    varchar(200)     NULL,
    UbigeoPartida       varchar(10)      NULL,
    DireccionLlegada    varchar(200)     NULL,
    UbigeoLlegada       varchar(10)      NULL,
    PlacaVehiculo       varchar(12)      NULL,
    NombreChofer        varchar(100)     NULL,
    DniChofer           varchar(15)      NULL,
    BreveteChofer       varchar(20)      NULL,
    RucTransportista    varchar(15)      NULL,
    NombreTransportista varchar(150)     NULL,

    -- importes. SIEMPRE calculados aquí, nunca recibidos del cliente.
    TasaIgv             decimal(9,6)     NOT NULL,
    Descuento           decimal(18,6)    NOT NULL CONSTRAINT DF_gre_Guia_Desc DEFAULT (0),
    ValorVenta          decimal(18,6)    NOT NULL CONSTRAINT DF_gre_Guia_VV   DEFAULT (0),
    Igv                 decimal(18,6)    NOT NULL CONSTRAINT DF_gre_Guia_Igv  DEFAULT (0),
    TotalVenta          decimal(18,6)    NOT NULL CONSTRAINT DF_gre_Guia_TV   DEFAULT (0),

    Estado              varchar(20)      NOT NULL CONSTRAINT DF_gre_Guia_Est  DEFAULT ('REGISTRADA'),
    CreadoEn            datetime         NOT NULL CONSTRAINT DF_gre_Guia_CE   DEFAULT (GETDATE()),
    CreadoPor           varchar(60)      NULL,
    ModificadoEn        datetime         NULL,

    CONSTRAINT PK_gre_Guia          PRIMARY KEY CLUSTERED (GuiaId),
    CONSTRAINT UQ_gre_Guia_Doc      UNIQUE (AnioGuia, TipoGuia, NumSerie, NumeroGuia),
    CONSTRAINT UQ_gre_Guia_Idem     UNIQUE (IdempotencyKey),
    CONSTRAINT CK_gre_Guia_Tipo     CHECK (TipoGuia IN ('N','A')),
    CONSTRAINT CK_gre_Guia_Estado   CHECK (Estado IN ('REGISTRADA','ANULADA'))
);
END
GO

/* ---------------------------------------------------------------------------
   gre.GuiaDetalle  ·  líneas.
   EsConsignado vive AQUÍ, como dato de la guía. Ya no se deduce de
   MaestroArticulo.consignacion dentro del insert del ERP, que era lo que
   obligaba a marcar el maestro antes del SP y generaba la carrera.
   --------------------------------------------------------------------------- */
IF OBJECT_ID('gre.GuiaDetalle','U') IS NULL
BEGIN
CREATE TABLE gre.GuiaDetalle (
    GuiaDetalleId   bigint        IDENTITY(1,1) NOT NULL,
    GuiaId          bigint        NOT NULL,
    Item            int           NOT NULL,      -- correlativo real, no 1 en todas
    CodArticulo     int           NOT NULL,
    Descripcion     varchar(200)  NULL,          -- congelada al emitir
    CodBarra        varchar(50)   NULL,
    Cantidad        decimal(18,6) NOT NULL,
    PrecioSinIgv    decimal(18,6) NOT NULL,
    Descuento       decimal(18,6) NOT NULL CONSTRAINT DF_gre_Det_Desc DEFAULT (0),
    UnidadMedida    int           NOT NULL,
    CodUnece        varchar(10)   NULL,
    TipoIgv         int           NOT NULL CONSTRAINT DF_gre_Det_TipoIgv DEFAULT (1),
    EsConsignado    bit           NOT NULL CONSTRAINT DF_gre_Det_Consig  DEFAULT (0),
    ImporteSinIgv   decimal(18,6) NOT NULL,
    ImporteIgv      decimal(18,6) NOT NULL CONSTRAINT DF_gre_Det_Igv DEFAULT (0),

    CONSTRAINT PK_gre_GuiaDetalle PRIMARY KEY CLUSTERED (GuiaDetalleId),
    CONSTRAINT FK_gre_Det_Guia    FOREIGN KEY (GuiaId)
        REFERENCES gre.Guia (GuiaId) ON DELETE CASCADE,
    CONSTRAINT UQ_gre_Det_Item    UNIQUE (GuiaId, Item),
    CONSTRAINT CK_gre_Det_Cant    CHECK (Cantidad > 0)      -- evita la división entre cero del ERP
);
CREATE INDEX IX_gre_Det_Articulo ON gre.GuiaDetalle (CodArticulo);
END
GO

/* ---------------------------------------------------------------------------
   gre.GuiaSync  ·  el outbox.
   Una fila por guía y por destino. Aquí vive el estado del envío al ERP y a
   SUNAT, con el ERROR REAL. Reemplaza al estadoproceso del ERP, que mentía.
   --------------------------------------------------------------------------- */
IF OBJECT_ID('gre.GuiaSync','U') IS NULL
BEGIN
CREATE TABLE gre.GuiaSync (
    GuiaSyncId      bigint       IDENTITY(1,1) NOT NULL,
    GuiaId          bigint       NOT NULL,
    Destino         varchar(20)  NOT NULL,   -- 'DMK' | 'SUNAT'
    Estado          varchar(20)  NOT NULL CONSTRAINT DF_gre_Sync_Est DEFAULT ('PENDIENTE'),
    Intentos        int          NOT NULL CONSTRAINT DF_gre_Sync_Int DEFAULT (0),
    ProximoIntento  datetime     NULL,       -- backoff exponencial
    UltimoError     varchar(2000) NULL,      -- ERROR_MESSAGE() textual, no un genérico
    UltimoErrorSp   varchar(200) NULL,       -- ERROR_PROCEDURE() + ERROR_LINE()
    SincronizadoEn  datetime     NULL,
    ActualizadoEn   datetime     NOT NULL CONSTRAINT DF_gre_Sync_Act DEFAULT (GETDATE()),

    CONSTRAINT PK_gre_GuiaSync    PRIMARY KEY CLUSTERED (GuiaSyncId),
    CONSTRAINT FK_gre_Sync_Guia   FOREIGN KEY (GuiaId)
        REFERENCES gre.Guia (GuiaId) ON DELETE CASCADE,
    CONSTRAINT UQ_gre_Sync        UNIQUE (GuiaId, Destino),
    CONSTRAINT CK_gre_Sync_Est    CHECK (Estado IN ('PENDIENTE','ENVIANDO','ENVIADA','ERROR','OMITIDA')),
    CONSTRAINT CK_gre_Sync_Dest   CHECK (Destino IN ('DMK','SUNAT'))
);
-- índice del worker: qué está pendiente y ya toca reintentar
CREATE INDEX IX_gre_Sync_Cola ON gre.GuiaSync (Estado, ProximoIntento) INCLUDE (GuiaId, Destino);
END
GO

/* ---------------------------------------------------------------------------
   gre.SyncEvento  ·  bitácora de cada intento.
   Es lo que hoy no existe: por qué falló, cuándo, con qué mensaje.
   --------------------------------------------------------------------------- */
IF OBJECT_ID('gre.SyncEvento','U') IS NULL
BEGIN
CREATE TABLE gre.SyncEvento (
    EventoId    bigint        IDENTITY(1,1) NOT NULL,
    GuiaId      bigint        NOT NULL,
    Destino     varchar(20)   NOT NULL,
    Resultado   varchar(20)   NOT NULL,   -- OK | ERROR | RECHAZO
    Mensaje     varchar(2000) NULL,
    DetalleTec  varchar(4000) NULL,       -- SP + línea + número de error
    OcurridoEn  datetime      NOT NULL CONSTRAINT DF_gre_Ev_Fecha DEFAULT (GETDATE()),
    CONSTRAINT PK_gre_SyncEvento PRIMARY KEY CLUSTERED (EventoId)
);
CREATE INDEX IX_gre_Ev_Guia ON gre.SyncEvento (GuiaId, OcurridoEn);
END
GO

/* ---------------------------------------------------------------------------
   gre.LineaRechazada  ·  lo que el ERP descartó y hoy desaparece en silencio.
   Alimentada al sincronizar: artículos que no existen en MaestroArticulo.
   Esta tabla es la respuesta al "de 20 solo entraron 15".
   --------------------------------------------------------------------------- */
IF OBJECT_ID('gre.LineaRechazada','U') IS NULL
BEGIN
CREATE TABLE gre.LineaRechazada (
    RechazoId   bigint       IDENTITY(1,1) NOT NULL,
    GuiaId      bigint       NOT NULL,
    Item        int          NOT NULL,
    CodArticulo int          NOT NULL,
    Motivo      varchar(300) NOT NULL,
    DetectadoEn datetime     NOT NULL CONSTRAINT DF_gre_Rech_Fecha DEFAULT (GETDATE()),
    CONSTRAINT PK_gre_LineaRechazada PRIMARY KEY CLUSTERED (RechazoId)
);
CREATE INDEX IX_gre_Rech_Guia ON gre.LineaRechazada (GuiaId);
END
GO

/* ---------------------------------------------------------------------------
   gre.Config  ·  parámetros por instalación.
   Aquí vive la tasa de IGV: UN solo lugar, en vez de los 14 sitios donde hoy
   está cableado el 1.18 entre PHP, JS, Blade y los propios stored procedures.
   --------------------------------------------------------------------------- */
IF OBJECT_ID('gre.Config','U') IS NULL
BEGIN
CREATE TABLE gre.Config (
    Clave       varchar(60)  NOT NULL,
    Valor       varchar(200) NOT NULL,
    Descripcion varchar(300) NULL,
    CONSTRAINT PK_gre_Config PRIMARY KEY CLUSTERED (Clave)
);

INSERT INTO gre.Config (Clave, Valor, Descripcion) VALUES
 ('igv.tasa',              '0.18', 'Tasa de IGV vigente. Única fuente de verdad.'),
 ('sync.max_intentos',     '5',    'Reintentos antes de marcar ERROR definitivo.'),
 ('sync.backoff_segundos', '60',   'Base del backoff exponencial entre reintentos.'),
 ('dmk.habilitado',        '1',    'Empujar guías al DataMart del ERP.'),
 ('consignados.habilitado','0',    'Se activa solo si el DataMart tiene las columnas.');
END
GO

PRINT 'V001 OK · schema [gre] instalado';
GO
