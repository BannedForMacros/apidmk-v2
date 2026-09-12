# ApiDMK v1 → v2 · mapa de cobertura

## Endpoints

| v1 (`/ApiDMK/GREDMK/…`) | v2 (`/api/v1/…`) | Stored procedure |
|---|---|---|
| `GET  ObtenerAlmacenes` | `GET /almacenes` | `GetMaestroalmacenByEstado` |
| `GET  ObtenerOperacion` | `GET /operaciones` | `GetMaestroOperacionByEstado` |
| `GET  ObtenerFormasPago` | `GET /formas-pago` | `GetMaestroformadepagoAll` |
| `GET  ObtenerSucursalPrecio` | `GET /listas-precio` | `GetSucursalPrecio` |
| `GET  obtenerSeriesNumerosGuia` | `GET /series-guia` | `GetMaestrodocumentoserieByTipodocumento` |
| `GET  ObtenerTrabajador` | `GET /trabajadores` | `GetMaestrotrabajadorByCodtrabajador` |
| `POST obtenerTipoCambio` | `GET /tipo-cambio` | `GetMaestrotipocambioByFechatipocambio` |
| `POST ObtenerArticulo` | `POST /articulos/buscar` | `GetMultiAlmacenGuiaIngMaestroarticuloByCodarticulo` |
| `POST obtenerCliente` | `POST /clientes/buscar` | `GetDatosClientexTipo` |
| `POST ObtenerProveedores` | `POST /proveedores/buscar` | `GetMaestroproveedoresByRuc` · `ByCodproveedor` · `pr_consultaProveedorlikeRazonsocial` |
| `POST ObtenerTransportista` | `POST /transportistas/buscar` | `GetGuiaRemisionLikeForTipo` |
| `POST ObtenerVehiculo` | `POST /vehiculos/buscar` | `GetGuiaRemisionLikeForTipo` |
| `POST ObtenerChoferes` | `POST /choferes/buscar` | `GetGuiaRemisionLikeForTipo` |
| `POST ObtieneUbigeos` | `POST /ubigeos` | `pr_ObtieneUbigeo` |
| `POST InsertGuiaDMK` | `POST /guias` | `prc_InsertGuiaDMKWeb` → `InsertarGuiasOdooDmk` |
| `POST EliminaGuiaDMK` ⚠️ | `DELETE /guias/{anio}/{tipo}/{serie}/{numero}` | `proc_anulaGuiaDMK` · `proc_eliminaGuiaDMK` |

⚠️ `EliminaGuiaDMK` lo llama Laravel (`GuiaIngresoController.php:1340`) pero **no existe en el WAR
dockerizado**. Los SPs sí están en `db_travel`. Producción corre otro build.

**Cobertura: 16/16.** Nada del v1 se pierde.

### Nuevos en v2
| Endpoint | Para qué |
|---|---|
| `GET /health` | Monitoreo on-premise: estado de SQL Server y del facturador central |
| `GET /capabilities` | Laravel se adapta al cliente sin condicionales en el código |
| `POST /guias/…/sunat` | Emitir ante SUNAT (fachada a GestionDbFact) |
| `GET  /guias/…/sunat` | Consultar estado |
| `GET  /guias/…/pdf` · `/xml` | Descargar comprobante |

---

## Qué se elimina de Laravel

| Se borra | Dónde está hoy | Reemplazo |
|---|---|---|
| Conexión `sqlsrv` | `config/database.php` + 6 vars del `.env` | — (ya no existe) |
| `actualizarConsignadosDirecto()` ×2 | `GuiaIngresoController:1496`, `GuiaSalidaController:1523` | campo `esConsignado` del detalle |
| `sincronizarConsignadoEnDetalle()` | `GuiaIngresoController:1564,1575` | idem |
| `'db_travel.dbo.DetalleGuiaRemision'` | `GuiaIngresoController:1574,1585` | — |
| IGV `1.18` / `0.18` ×14 | PHP, JS, Blade | `capabilities.igv.tasa` |
| `"modalidadTransporte" => "18"` ×3 | ambos controllers | `traslado.modalidadTransporte` |
| `Parametro::find(1,7,8,9)` (credencial y URLs del PSE) | `GuiaSalidaController` | config del servidor ApiDMK |
| flag `CONSIGNADOS_ENABLED` | `config/consignados.php` + `.env` | `GET /capabilities` |
| Mapeo `A`/`B`/`O` → ids locales | `GuiaSalidaController:97` | `EstadoSunat.estado` normalizado |

---

## Defectos que el contrato cierra

1. **Líneas perdidas en silencio.** `InsertarGuiasOdooDmk` hace
   `INNER JOIN MaestroArticulo`; si el artículo no está replicado, la línea
   desaparece sin aviso. Es la causa real del *"de 20 solo entraron 15"*.
   → `GuiaResponse.lineasRechazadas` las reporta explícitamente.

2. **Detalle duplicado al reintentar.** El dedupe del SP compara
   `@codproveedor = dt.codproveedor`; si llega `NULL`, nunca hace match y
   reinserta. → `Idempotency-Key` obligatorio en `POST /guias`.

3. **Carrera entre el UPDATE de consignados y el SP.** `esconsignado` se copia
   de `MaestroArticulo.consignacion` **dentro** del insert, así que el orden
   importaba — y Ingreso lo hacía después, Salida antes.
   → un solo campo, una sola transacción.

4. **`item` siempre 1.** Ambos controllers mandan `"item" => 1` en todas las
   líneas. → `item` requerido y correlativo.

5. **Sin autenticación.** Cualquiera con acceso al puerto 8181 puede insertar
   guías. → `X-Api-Key`.

6. **`tipoIgv` inutilizable.** El SP lo lee del XML pero el DTO v1 no lo envía;
   Laravel lo lee con `?? 0`, así que siempre vale 0. → campo del detalle.

---

## Cambios necesarios en SQL Server

Van como migraciones versionadas (Flyway) contra el DataMart del cliente, no a mano.

| Cambio | Motivo |
|---|---|
| Unificar `GetMultiAlmacenGuiaIngMaestroarticuloByCodarticulo` con su fork `_ApiDMK` | Hoy son dos SPs con contratos distintos y ya desincronizados |
| Normalizar `MaestroArticulo.consignacion` y `DetalleGuiaRemision.esconsignado` | `char(1)` en travel vs `bit` en emmel |
| Instalar `prc_InsertGuiaDMKWeb`, `InsertarGuiasOdooDmk`, `proc_anulaGuiaDMK` y las tablas `*_Odoo` donde falten | No existen en clientes tipo emmel |
| `INNER JOIN` → `LEFT JOIN` + reporte en `InsertarGuiasOdooDmk` | Defecto 1 |
| Guarda contra división entre cero en `round((descuento/(Cantidad*Precio))*100,2)` | Revienta la guía completa si cantidad o precio es 0 |
| `TMPGuiaTransferencia_Odoo` y `TMPGuiaRemision_Odoo`: tablas físicas → temporales | Dos guías concurrentes se pisan; el `DROP TABLE` al entrar destruye la corrida ajena |
