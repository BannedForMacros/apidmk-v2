/* ============================================================================
   V003 · Consignados — instalación NORMALIZADA y opcional
   ----------------------------------------------------------------------------
   PROBLEMA QUE RESUELVE
     "Si pruebo consignados en un cliente, falla porque tengo que colarle la
      columna a mano." Y hay clientes que NO usan consignados.

     Este script se puede correr en TODOS los clientes sin miedo:
       · Si el cliente NO tiene consignados habilitado -> no toca nada.
       · Si SÍ -> crea lo que falte, respetando el tipo que ya exista.
       · Correrlo 10 veces = mismo resultado que correrlo 1 vez.

     Activar consignados en un cliente pasa a ser:
         UPDATE gre.Config SET Valor='1' WHERE Clave='consignados.habilitado';
         :r V003__consignados.sql
     En vez de un ALTER TABLE a mano y rezar.

   OJO CON EL TIPO
     db_travel     -> MaestroArticulo.consignacion  char(1)   ('0'/'1'/NULL)
     db_fsm_emmel  -> MaestroArticulo.consignacion  bit
     Si la columna YA existe, respetamos su tipo. Si hay que crearla, usamos
     char(1) que es lo que usa el cliente más avanzado y tolera NULL.

   COMPATIBILIDAD: SQL Server 2008 (compat 100).
   ========================================================================== */
SET NOCOUNT ON;
GO

DECLARE @habilitado bit;
SELECT @habilitado = CAST(ISNULL((SELECT TOP 1 Valor FROM gre.Config
                                  WHERE Clave='consignados.habilitado'),'0') AS bit);

IF @habilitado = 0
BEGIN
    PRINT 'V003 OMITIDO - consignados.habilitado = 0 en gre.Config. Nada que hacer.';
END
ELSE
BEGIN
    PRINT 'V003 - consignados HABILITADO. Verificando infraestructura...';

    /* ---- 1. MaestroArticulo.consignacion ---- */
    IF NOT EXISTS (SELECT 1 FROM sys.columns
                   WHERE object_id = OBJECT_ID('dbo.MaestroArticulo') AND name = 'consignacion')
    BEGIN
        ALTER TABLE dbo.MaestroArticulo ADD consignacion char(1) NULL;
        PRINT '  + MaestroArticulo.consignacion char(1) creada';
    END
    ELSE
        PRINT '  = MaestroArticulo.consignacion ya existe, se respeta su tipo';

    /* ---- 2. DetalleGuiaRemision.esconsignado ---- */
    IF NOT EXISTS (SELECT 1 FROM sys.columns
                   WHERE object_id = OBJECT_ID('dbo.DetalleGuiaRemision') AND name = 'esconsignado')
    BEGIN
        ALTER TABLE dbo.DetalleGuiaRemision ADD esconsignado char(1) NULL;
        PRINT '  + DetalleGuiaRemision.esconsignado char(1) creada';
    END
    ELSE
        PRINT '  = DetalleGuiaRemision.esconsignado ya existe';

    /* ---- 3. DetalleGuiaRemision_Odoo.esconsignado (la cola del ERP) ---- */
    IF OBJECT_ID('dbo.DetalleGuiaRemision_Odoo','U') IS NOT NULL
       AND NOT EXISTS (SELECT 1 FROM sys.columns
                       WHERE object_id = OBJECT_ID('dbo.DetalleGuiaRemision_Odoo') AND name = 'esconsignado')
    BEGIN
        ALTER TABLE dbo.DetalleGuiaRemision_Odoo ADD esconsignado char(1) NULL;
        PRINT '  + DetalleGuiaRemision_Odoo.esconsignado creada';
    END

    /* ---- 4. índice para la reconciliación (evita scan del maestro completo) ---- */
    IF NOT EXISTS (SELECT 1 FROM sys.indexes
                   WHERE object_id = OBJECT_ID('dbo.MaestroArticulo') AND name = 'IX_MaestroArticulo_consignacion')
    BEGIN
        CREATE INDEX IX_MaestroArticulo_consignacion
            ON dbo.MaestroArticulo (consignacion) INCLUDE (CodArticulo);
        PRINT '  + índice IX_MaestroArticulo_consignacion creado';
    END

    PRINT 'V003 OK - consignados instalado';
END
GO

/* ---------------------------------------------------------------------------
   gre.sp_ReconciliarConsignados

   Cierra el hueco de "a veces no se pintan los consignados".

   Causa: el ERP copia esconsignado desde MaestroArticulo.consignacion DENTRO
   del insert. Si el artículo aún no está replicado en el maestro, no se marca.
   El detalle de la guía sí sabe la verdad -> se usa como fuente y se corrige
   el maestro, no al revés.

   Tolera que la columna sea char(1) o bit: compara con CAST a varchar.
   --------------------------------------------------------------------------- */
IF OBJECT_ID('gre.sp_ReconciliarConsignados','P') IS NOT NULL
    DROP PROCEDURE gre.sp_ReconciliarConsignados;
GO
CREATE PROCEDURE gre.sp_ReconciliarConsignados
    @GuiaId bigint = NULL   -- NULL = reconciliar todo lo pendiente
AS
BEGIN
    SET NOCOUNT ON;

    IF NOT EXISTS (SELECT 1 FROM gre.vw_Capacidades
                   WHERE ConsignadosInstalado = 1 AND ConsignadosHabilitado = 1)
    BEGIN
        PRINT 'Consignados no habilitado en esta instalacion. Sin accion.';
        RETURN;
    END

    DECLARE @marcados int = 0;

    -- artículos que la guía declara consignados y el maestro aún no refleja
    UPDATE m
       SET m.consignacion = '1'
      FROM dbo.MaestroArticulo m
     WHERE EXISTS (
              SELECT 1
                FROM gre.GuiaDetalle d
                JOIN gre.Guia g ON g.GuiaId = d.GuiaId
               WHERE d.CodArticulo  = m.CodArticulo
                 AND d.EsConsignado = 1
                 AND g.Estado       = 'REGISTRADA'
                 AND (@GuiaId IS NULL OR g.GuiaId = @GuiaId)
           )
       AND ISNULL(CAST(m.consignacion AS varchar(5)),'0') NOT IN ('1','True');

    SET @marcados = @@ROWCOUNT;

    INSERT INTO gre.SyncEvento (GuiaId, Destino, Resultado, Mensaje)
    SELECT ISNULL(@GuiaId,0), 'DMK', 'OK',
           'Reconciliacion de consignados: ' + CAST(@marcados AS varchar) + ' articulos marcados en MaestroArticulo';

    SELECT @marcados AS ArticulosMarcados;
END
GO

EXEC gre.sp_RegistrarVersion 'V003', 'Consignados opcional + reconciliacion desde el detalle';
GO
