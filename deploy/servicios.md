# Arranque perpetuo · los 4 componentes como servicios de Windows

Hoy Laragon se abre a mano y sirve desde `public/`. Eso implica que **alguien
tiene que iniciar sesión** para que el sistema levante. Si el servidor se
reinicia de noche, el cliente amanece sin sistema.

La corrección: los cuatro componentes se instalan como servicios con arranque
automático y con dependencias declaradas.

## 1. SQL Server — ya es servicio
Nada que hacer, viene así. Solo verificar arranque automático:

    sc config MSSQLSERVER start= auto

## 2. MySQL — instalar como servicio
Laragon lo corre en modo portable. Se convierte a servicio:

    C:\dbperu\mysql\bin\mysqld.exe --install DBPeruMySQL --defaults-file=C:\dbperu\mysql\my.ini
    sc config DBPeruMySQL start= auto
    net start DBPeruMySQL

## 3. Apache + PHP 7.4 — instalar como servicio

    C:\dbperu\apache\bin\httpd.exe -k install -n "DBPeruApache"
    sc config DBPeruApache start= auto depend= DBPeruMySQL
    net start DBPeruApache

El VirtualHost apunta a `public/` de Laravel, igual que hoy con Laragon:

    DocumentRoot "C:/dbperu/guias/public"
    <Directory "C:/dbperu/guias/public">
        AllowOverride All
        Require all granted
    </Directory>

## 4. ApiDMK v2 — WinSW
Ver `apidmk-service.xml`. Depende de `MSSQLSERVER`.

    apidmk-service.exe install
    apidmk-service.exe start

## Orden de arranque resultante

    SQL Server ──> ApiDMK v2
    MySQL      ──> Apache/PHP ──> Laravel

Declarado con `depend=`, así Windows respeta el orden solo. Sin sesión iniciada,
sin tareas programadas, sin que nadie toque nada.

## Verificación post-instalación

    sc query MSSQLSERVER
    sc query DBPeruMySQL
    sc query DBPeruApache
    sc query DBPeruApiDMK

    curl http://localhost:8181/api/v1/health
    curl http://localhost/

Prueba real: **reiniciar el servidor y no iniciar sesión.** Desde otra máquina de
la red, abrir `http://<ip-servidor>/`. Si carga, quedó bien.
