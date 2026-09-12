/* ============================================================================
   V002 · Control de versiones del DataMart  +  detección de capacidades
   ----------------------------------------------------------------------------
   PROBLEMA QUE RESUELVE
     Hoy no hay forma de saber en qué estado está el SQL Server de cada cliente.
     Para probar consignados hay que "colarle la columna" a mano, y al querer
     actualizar algo hay que rehacer todo desde cero.

     Esto convierte el SQL Server del cliente en algo versionado, como las
     migraciones de Laravel: cada script se aplica UNA vez, queda registrado,
     y el sistema sabe decir en qué versión está.

   COMPATIBILIDAD: SQL Server 2008 (compat 100).
   ========================================================================== */
SET NOCOUNT ON;
GO

/* ---------------------------------------------------------------------------
   gre.SchemaVersion · qué migraciones se aplicaron y cuándo
   --------------------------------------------------------------------------- */
IF OBJECT_ID('gre.SchemaVersion','U') IS NULL
BEGIN
CREATE TABLE gre.SchemaVersion (
    Version      varchar(20)   NOT NULL,   -- 'V001', 'V002', ...
    Descripcion  varchar(200)  NOT NULL,
    Checksum     varchar(64)   NULL,       -- para detectar scripts editados a mano
    AplicadoEn   datetime      NOT NULL CONSTRAINT DF_gre_SV_Fecha DEFAULT (GETDATE()),
    AplicadoPor  varchar(100)  NOT NULL CONSTRAINT DF_gre_SV_User  DEFAULT (SUSER_SNAME()),
    DuracionMs   int           NULL,
    CONSTRAINT PK_gre_SchemaVersion PRIMARY KEY CLUSTERED (Version)
);
END
GO

/* ---------------------------------------------------------------------------
   gre.sp_RegistrarVersion · idempotencia. Correr un script 2 veces no rompe.
   --------------------------------------------------------------------------- */
IF OBJECT_ID('gre.sp_RegistrarVersion','P') IS NOT NULL
    DROP PROCEDURE gre.sp_RegistrarVersion;
GO
CREATE PROCEDURE gre.sp_RegistrarVersion
    @Version     varchar(20),
    @Descripcion varchar(200)
AS
BEGIN
    SET NOCOUNT ON;
    IF NOT EXISTS (SELECT 1 FROM gre.SchemaVersion WHERE Version = @Version)
        INSERT INTO gre.SchemaVersion (Version, Descripcion) VALUES (@Version, @Descripcion);
END
GO

/* ---------------------------------------------------------------------------
   gre.vw_Capacidades · QUÉ SOPORTA REALMENTE ESTA INSTALACIÓN

   No es un flag en un .env que puede mentir. Inspecciona el SQL Server real:
   ¿existe la columna? ¿existe el SP? Y lo cruza con lo que el cliente CONTRATÓ
   (gre.Config). Una capacidad está activa solo si ambas cosas son ciertas.

   Es lo que consume GET /api/v1/capabilities, y con eso Laravel pinta o no
   pinta el check de consignados. Sin condicionales por cliente en el código.
   --------------------------------------------------------------------------- */
IF OBJECT_ID('gre.vw_Capacidades','V') IS NOT NULL
    DROP VIEW gre.vw_Capacidades;
GO
CREATE VIEW gre.vw_Capacidades
AS
SELECT
    -- ¿el DataMart tiene la infraestructura de consignados?
    CAST(CASE WHEN EXISTS (SELECT 1 FROM sys.columns c
                           WHERE c.object_id = OBJECT_ID('dbo.MaestroArticulo')
                             AND c.name = 'consignacion')
              AND  EXISTS (SELECT 1 FROM sys.columns c
                           WHERE c.object_id = OBJECT_ID('dbo.DetalleGuiaRemision')
                             AND c.name = 'esconsignado')
         THEN 1 ELSE 0 END AS bit)                                AS ConsignadosInstalado,

    -- ¿el cliente lo tiene contratado / activado?
    CAST(ISNULL((SELECT TOP 1 Valor FROM gre.Config
                 WHERE Clave = 'consignados.habilitado'),'0') AS bit) AS ConsignadosHabilitado,

    -- ¿existe el SP de inserción del ERP?
    CAST(CASE WHEN OBJECT_ID('dbo.prc_InsertGuiaDMKWeb','P') IS NOT NULL
         THEN 1 ELSE 0 END AS bit)                                AS InsertGuiaDisponible,

    -- ¿existe el SP de anulación?
    CAST(CASE WHEN OBJECT_ID('dbo.proc_anulaGuiaDMK','P') IS NOT NULL
           OR  OBJECT_ID('dbo.proc_eliminaGuiaDMK','P') IS NOT NULL
         THEN 1 ELSE 0 END AS bit)                                AS AnulacionDisponible,

    -- tipo real de la columna: char(1) en unos clientes, bit en otros
    ISNULL((SELECT TOP 1 t.name FROM sys.columns c
            JOIN sys.types t ON t.user_type_id = c.user_type_id
            WHERE c.object_id = OBJECT_ID('dbo.MaestroArticulo')
              AND c.name = 'consignacion'), 'AUSENTE')            AS TipoColumnaConsignacion,

    CAST(ISNULL((SELECT TOP 1 Valor FROM gre.Config
                 WHERE Clave = 'igv.tasa'),'0.18') AS decimal(9,6)) AS TasaIgv,

    ISNULL((SELECT TOP 1 Version FROM gre.SchemaVersion
            ORDER BY Version DESC),'ninguna')                     AS VersionEsquema,

    DB_NAME()                                                     AS BaseDatos;
GO

EXEC gre.sp_RegistrarVersion 'V001', 'Esquema gre: Guia, GuiaDetalle, GuiaSync, SyncEvento, LineaRechazada, Config';
EXEC gre.sp_RegistrarVersion 'V002', 'Control de versiones + vista de capacidades';
GO

PRINT 'V002 OK - control de versiones instalado';
GO
