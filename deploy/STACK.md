# Stack fijado · instalación on-premise

Todo se instala en el servidor del cliente. Nada se descarga en tiempo de instalación:
el paquete lleva las versiones exactas adentro.

## Matriz de versiones (PINNED — no "la última")

Las versiones reales las fija `instalador/runtime.lock` en el repositorio
`guias-electronicas-unificado`, verificadas por SHA-256 al armar el paquete.
Esta tabla las repite: si las dos no coinciden, manda `runtime.lock`.

| Componente | Versión fijada | Puerto | Por qué esa |
|---|---|---|---|
| **PHP** | **7.4.33** (x64, VC15) | — | Última rama que declara soportar Windows 7 / Server 2008 R2. |
| **Laravel** | **8.83.x** | — | Techo de PHP 7.4. Laravel 9 exige PHP 8.0. |
| **Apache** | **2.4.66** Win64 **VS17** | **80** | La VS18 dice textualmente que no corre en 7 SP1. Sirve `public/`. |
| **Visual C++** | **14.44.35211** (x64) | — | Lo que piden Apache VS17, PHP y MySQL 5.7.40+. |
| **MySQL** | **5.7.44** (x64) | **3306** | Última de la rama 5.7 (25 oct 2023). |
| **Java** | **Temurin 8u504-b01** (JRE x64) | — | Boot 2.7 exige Java 8. Ver la nota de abajo: no es 8u202. |
| **ApiDMK v2** | fat JAR + Tomcat embebido | **8181** | Un archivo. Sin instalar Tomcat. |
| **Spring Boot** | 2.7.18 | — | Última rama que corre en Java 8. Boot 3 exige Java 17. |
| **SQL Server** | 2008 R2 o superior | **1433** | Es del cliente. `compatibility_level 100`. |

## Sistemas operativos: lo PROBADO y lo DECLARADO

No son lo mismo y antes se mezclaban. El detalle completo, componente por
componente y con las fuentes de cada proveedor, está en
`guias-electronicas-unificado/docs/COMPATIBILIDAD.md`.

- **PROBADO — Windows 11 Pro ARM64**, el 11 de septiembre de 2026: instalación,
  reinstalación, actualización, reversión y recorrido completo del sistema
  (22/23 pasos). Es el único sistema donde este paquete se instaló de verdad.
- **PLAUSIBLE, sin verificar — Windows 10 x64, Windows 11 x64, Server 2016 /
  2019 / 2022 / 2025.** Los cinco componentes declaran soportarlos y no hay
  contradicción entre proveedores. Falta instalarlo una vez.
- **NO FUNCIONA — Windows XP, Vista, Server 2003, Server 2008 anterior a R2, y
  cualquier Windows de 32 bits.** Apache Lounge: "The binaries do not run on XP
  and 2003". PHP no soporta Vista ni 2008 desde 7.2.0. Todos los runtimes son x64.

> **Windows 7 SP1 ya no se declara soportado.** Nunca se instaló ahí. Solo PHP
> 7.4 sostiene la promesa con claridad: Apache VS17 dice "Runs on: 7 SP1" pero
> exige un Visual C++ (14.50) que Microsoft solo soporta en Windows 10+, y
> Microsoft, Oracle y Adoptium ya no publican soporte de Windows 7 para el
> Visual C++ 14.44, MySQL 5.7 ni Temurin 8 que lleva el paquete. Windows 7 está
> sin parches desde enero de 2023 (fin del ESU), no trae PowerShell 5.1 ni TLS
> 1.2 activo, y sin KB4474419 rechaza los instaladores firmados con SHA-2.
>
> Mínimo que se puede afirmar hoy: **Windows 10 x64 / Server 2016**. Instalar en
> Windows 7 SP1 no está prohibido —el instalador avisa y deja seguir—, pero es
> territorio no probado y debe tratarse cliente por cliente.
>
> **Para sostener Windows 7 de verdad** habría que bajar Apache a la rama VS16
> (sin actualizar desde 2023), MySQL a 5.7.37 o anterior, Java a una compilación
> más vieja de Temurin 8 u Oracle 8u202, y fijar un Visual C++ 14.3x que sí
> instale ahí; y luego **probarlo en un Windows 7 SP1 real**. Se pierden parches
> en cuatro de los cinco componentes. Es una decisión de negocio, no una línea
> heredada en un documento.

**Nota sobre Java:** este documento decía "8u202, última con soporte real en
Win7". El paquete no instala 8u202: instala **Temurin 8u504-b01**, publicado el
25 de agosto de 2026. Oracle sí listó Windows 7 SP1 para Java 8, pero hoy lo
marca como "Previously supported Operating System. No longer supported by the
Vendor."

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
