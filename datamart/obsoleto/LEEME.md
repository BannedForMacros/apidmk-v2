# Esquema `gre` — descartado

Estos scripts creaban un esquema `gre` en SQL Server con un patron de bandeja
de salida (outbox) propio, para reemplazar la cadena de tablas `_Odoo` del ERP.

**No se usan. No los ejecutes.**

Se descartaron por decision del cliente: la cadena actual
(`GuiaRemision_Odoo` -> `InsertarGuiasOdooDmk` -> `GuiaRemision`) ya esta
instalada y funcionando en varios clientes en produccion, y meter un esquema
nuevo significaba alborotar instalaciones que hoy no dan problemas. El riesgo
no compensaba.

`ROLLBACK__quitar_gre.sql` fue lo que se ejecuto para deshacerlo. Ya se
comprobo que quedo limpio: 0 objetos en el esquema `gre`, el esquema no
existe, y `dbo` quedo intacto.

Se guardan aqui, y no se borran, por si alguna vez se retoma la idea: el
diseno del outbox y el control de versiones estan resueltos y documentados.

Lo que SI se usa esta en `../sp/`:

- `SP01__prc_InsertGuiaDMKWeb.sql`
- `SP02__InsertarGuiasOdooDmk.sql`

Esos son idempotentes y se pueden correr sobre un cliente existente.
