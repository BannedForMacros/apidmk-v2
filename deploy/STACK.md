# Stack fijado · instalación on-premise

Todo se instala en el servidor del cliente. Nada se descarga en tiempo de instalación:
el paquete lleva las versiones exactas adentro.

## Matriz de versiones (PINNED — no "la última")

| Componente | Versión fijada | Puerto | Por qué esa |
|---|---|---|---|
| **PHP** | **7.4.33** (NTS/TS x64, VC15) | — | Última que soporta Windows 7. PHP 8.x exige Win8+. |
| **Laravel** | **8.83.x** | — | Techo de PHP 7.4. Laravel 9 exige PHP 8.0. |
| **Apache** | 2.4.x (VC15) | **80** | El que trae Laragon. Sirve `public/`. |
| **MySQL** | 5.7.x | **3306** | 8.0 pide Win Server 2012+ para algunos builds. |
| **Java** | **8u202** (JRE x64) | — | Última con soporte real en Win7/XP. Java 11+ deja fuera Win7. |
| **ApiDMK v2** | fat JAR + Tomcat embebido | **8181** | Un archivo. Sin instalar Tomcat. |
| **Spring Boot** | 2.7.18 | — | Última rama que corre en Java 8. Boot 3 exige Java 17. |
| **SQL Server** | 2008 R2 o superior | **1433** | Es del cliente. `compatibility_level 100`. |

> **Windows XP queda fuera.** PHP 7.4 requiere Vista o superior; en XP el techo real
> es PHP 5.6 → Laravel 5.4. Un cliente en XP no puede correr esta versión.
> Mínimo soportado: **Windows 7 SP1 x64 / Windows Server 2008 R2**.

## Regla de versionado del paquete

    dbperu-guias-<AÑO>.<MES>.<PATCH>.zip
    ejemplo: dbperu-guias-2026.09.1.zip

Un solo zip contiene: Laravel, JRE 8, ApiDMK.jar, Apache+PHP, migraciones MySQL
y los dos procedimientos de SQL Server que sí se usan (`datamart/sp/SP01__prc_InsertGuiaDMKWeb.sql`
y `SP02__InsertarGuiasOdooDmk.sql`). No lleva ningún esquema `gre`: esos scripts
(`datamart/obsoleto/V001..V003`) se descartaron y no deben ejecutarse; ver
`datamart/obsoleto/LEEME.md`. El instalador es idempotente: correrlo dos veces no
rompe nada.

`GET /api/v1/health` devuelve la versión instalada y la versión de esquema aplicada,
para saber en qué está cada cliente sin entrar a mirar.
