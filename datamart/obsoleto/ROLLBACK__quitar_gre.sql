/* Revierte por completo la instalacion del esquema [gre].
   Solo elimina objetos creados por V001/V002/V003. No toca nada de [dbo]. */
SET NOCOUNT ON;
GO
IF OBJECT_ID('gre.sp_ReconciliarConsignados','P') IS NOT NULL DROP PROCEDURE gre.sp_ReconciliarConsignados;
IF OBJECT_ID('gre.sp_RegistrarVersion','P')      IS NOT NULL DROP PROCEDURE gre.sp_RegistrarVersion;
IF OBJECT_ID('gre.vw_Capacidades','V')           IS NOT NULL DROP VIEW      gre.vw_Capacidades;
GO
-- primero las que tienen FK hacia gre.Guia
IF OBJECT_ID('gre.GuiaDetalle','U')    IS NOT NULL DROP TABLE gre.GuiaDetalle;
IF OBJECT_ID('gre.GuiaSync','U')       IS NOT NULL DROP TABLE gre.GuiaSync;
IF OBJECT_ID('gre.SyncEvento','U')     IS NOT NULL DROP TABLE gre.SyncEvento;
IF OBJECT_ID('gre.LineaRechazada','U') IS NOT NULL DROP TABLE gre.LineaRechazada;
IF OBJECT_ID('gre.Guia','U')           IS NOT NULL DROP TABLE gre.Guia;
IF OBJECT_ID('gre.Config','U')         IS NOT NULL DROP TABLE gre.Config;
IF OBJECT_ID('gre.SchemaVersion','U')  IS NOT NULL DROP TABLE gre.SchemaVersion;
GO
IF EXISTS (SELECT 1 FROM sys.schemas WHERE name='gre') DROP SCHEMA gre;
GO
PRINT 'ROLLBACK OK - esquema [gre] eliminado por completo';
GO
