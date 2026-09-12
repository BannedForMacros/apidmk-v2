package DbPeru.Posm.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyConnection {
   private Connection conn = null;
   private Statement sttm = null;
   StringBuilder sql;

   public Connection AccederBD(String RutaBaseDatos) {
      try {
         try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }

         this.conn = DriverManager.getConnection(RutaBaseDatos);
         if (this.conn != null) {
            System.out.println("Base de Datos Ya Leida Correctamente");
            this.AgregarCamposBD(this.agregarcampos(), RutaBaseDatos);
            System.out.println("campos creados");
         }
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         this.CrearBD(this.TableVenta(), RutaBaseDatos);
         this.CrearBD(this.DetalleVentas(), RutaBaseDatos);
         this.CrearBD(this.ventaformapago(), RutaBaseDatos);
      }

      return this.conn;
   }

   public Connection CrearBD(String query, String RutaBaseDatos) {
      try {
         try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }

         String UbicacionDatabase = RutaBaseDatos + ";create=true";
         this.conn = DriverManager.getConnection(UbicacionDatabase);
         if (this.conn != null) {
            System.out.println("BASE DE DATOS INICIADA");

            try {
               PreparedStatement pstm = this.conn.prepareStatement(query);
               pstm.execute();
               pstm.close();
               System.out.println("SENTENCIA SQL EFECTUADA CORRECTAMENTE");
            } catch (SQLException ex) {
               System.out.println("***ERROR AL CREAR BD*****" + ex.getMessage());
            }
         }
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         System.out.println("PRIMER ERROR AL CREAR BD" + e.getMessage());
      }

      return this.conn;
   }

   public Connection AgregarCamposBD(String query, String RutaBaseDatos) {
      try {
         try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }

         String UbicacionDatabase = RutaBaseDatos + ";create=true";
         this.conn = DriverManager.getConnection(UbicacionDatabase);
         if (this.conn != null) {
            System.out.println("BASE DE DATOS INICIADA");
            String str = query.toString();
            String[] arrOfStr = str.split(";", 0);

            for(String linea : arrOfStr) {
               try {
                  PreparedStatement pstm = this.conn.prepareStatement(linea);
                  pstm.execute();
                  pstm.close();
                  System.out.println("SENTENCIA SQL EFECTUADA CORRECTAMENTE");
               } catch (SQLException ex) {
                  System.out.println("***ERROR AL CREAR NUEVOS CAMPOS*****" + ex.getMessage());
               }
            }
         }
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         System.out.println("PRIMER ERROR AL CREAR BD" + e.getMessage());
      }

      return this.conn;
   }

   public String TableVenta() {
      this.sql = new StringBuilder();
      this.sql.append("CREATE TABLE APP.ventas ");
      this.sql.append("(COD_DOCUMENTO\tvarchar(2),SERI_VENTA varchar(20) ");
      this.sql.append(",NUME_VENTA varchar(20),ID_CLIENTE INT,COD_DOCUMENTOI varchar(50)");
      this.sql.append(",FEMI_VENTA varchar(50),TNETO_VENTA DECIMAL(14,2),TDES_VENTA DECIMAL(14,2)");
      this.sql.append(",IMPU_VENTA DECIMAL(14,2),TOTAL_VENTA DECIMAL(14,2),TEXON_VENTA DECIMAL(14,2)");
      this.sql.append(",TINA_VENTA\tDECIMAL(14,2),TDEG_VENTA DECIMAL(14,2) ");
      this.sql.append(",TDEM_VENTA DECIMAL(14,2),BAR_VENTA varchar(50),REDO_VENTA varchar(50),FREG_VENTA varchar(50)");
      this.sql.append(",TCAMB_VENTA\tDECIMAL(14,2),VUEL_VENTA DECIMAL(14,2),ESTA_VENTA INT ,NUM_DRELACIONADO varchar(50)");
      this.sql.append(",SERI_DRELACIONADO varchar(50),FEC_CREA varchar(50),FEC_MOD varchar(50),CREA_USUARIO varchar(50)");
      this.sql.append(",MOD_USUARIO varchar(50),cierre_caja varchar(50),estadows varchar(50),ESTADOENVIOSUNAT varchar(50)");
      this.sql.append(",CODIGOHASH varchar(50),PDF varchar(50),DOC_RELA_VALE varchar(50),DOC_RELA_NC varchar(50),TIPO_DOC_RELA_NC varchar(50)");
      this.sql.append(",TIPO_NC varchar(50),MOTIVO_NC varchar(50),COMENTARIO varchar(100),IDFEC varchar(50),SINCRONIZACIONDMK char(1)");
      this.sql.append(",RUCEMPRESA varchar(11),RAZONSOCIAL varchar(150),DIRECCION varchar(150),DISTRITO varchar(150),PROVINCIA varchar(150)");
      this.sql.append(",DEPARTAMENTO\tvarchar(150),HORAEMISION varchar(15),LEYENDA varchar(150),TIPODOCUMENTOCLI varchar(20),RAZONSOCIALCLI varchar(150)");
      this.sql.append(",NUMERODOCUMENTOCLI varchar(150),DIRECCIONCLI\tvarchar(150),CORREOCLI\tvarchar(150)");
      this.sql.append(",CODIGOSUCURSAL\tvarchar(150),NOMBRESUCURSAL\tvarchar(150),DIRECCIONSUCURSAL\tvarchar(150)");
      this.sql.append(",DEPARTAMENTOSUCURSAL\tvarchar(150),PROVINCIASUCURSAL\tvarchar(150),DISTRITOSUCURSAL varchar(150)");
      this.sql.append(",UBIGEOSUCURSAL\tvarchar(150),CODIGOTERMINAL\tchar(3)\t,NUMEROITEMS varchar(10),TIPOTARJETA varchar(10),MONTOICBPER DECIMAL(14,2),FECHASINCRONIZACIONDMK timestamp,MENSAJEERROR varchar(100))");
      return this.sql.toString();
   }

   public String DetalleVentas() {
      this.sql = new StringBuilder();
      this.sql.append("CREATE TABLE APP.ventasdetalle ");
      this.sql.append("( COD_DOCUMENTO\tvarchar(50),SERI_VENTA varchar(50),NUME_VENTA varchar(50)");
      this.sql.append(",ID_VENTASD INT,COD_ARTICULO varchar(50) ,COD_UNIDADM varchar(50) ");
      this.sql.append(",CANT_VENTASD DECIMAL(14,2),PUNI_VENTASD DECIMAL(14,2) ,IMPU_VENTASD DECIMAL(14,2)");
      this.sql.append(",TNETO_VENTASD DECIMAL(14,2) ,TDESC_VENTASD DECIMAL(14,2) ,TIMP_VENTASD DECIMAL(14,2)");
      this.sql.append(",ESTA_VENTASD varchar(50),NC_VENTAD INT,CANTNC_VENTAD DECIMAL(14,2),NCRELACIONADO_VENTAD varchar(50)");
      this.sql.append(",FEC_CREA varchar(50),FEC_MOD varchar(50),CREA_USUARIO varchar(50),MOD_USUARIO varchar(50) ,TIP_IGV INT");
      this.sql.append(",TASA_IMP DECIMAL(14,2) ,TDESC_PORC_VENTASD DECIMAL(14,2),CODIGOARTIINTERNO varchar(50),UNIDADMEDIDA varchar(20)");
      this.sql.append(",CODSUCURSAL varchar(20),CODIGOSUNAT varchar(20),TIPOAFECTACION varchar(20) , TIPOPRECIOVENTA varchar(20),MONTOICBPER DECIMAL(14,2) )");
      return this.sql.toString();
   }

   public String ventaformapago() {
      this.sql = new StringBuilder();
      this.sql.append("CREATE TABLE APP.ventaformapago ");
      this.sql.append("( NUME_VENTAS\tvarchar(50),COD_DOCUMENTO varchar(50),SERI_VENTA varchar(50)");
      this.sql.append(",ID_FPAGO varchar(50),TMONT_FORMAP DECIMAL(14,2) ,NUM_FORMAP varchar(50) ");
      this.sql.append(",SER_FORMAP varchar(50),TCAMB_FORMAP DECIMAL(14,2) ,TMOC_FORMAP DECIMAL(14,2)");
      this.sql.append(",ESTA_FORMAP INT ,REFE_FORMAP INT ,FEC_CREA varchar(50)");
      this.sql.append(",FEC_MOD varchar(50),CREA_USUARIO varchar(50),MOD_USUARIO varchar(50),CODTARJETA varchar(50) , CODSUCURSAL varchar(50) )");
      return this.sql.toString();
   }

   public String agregarcampos() {
      this.sql = new StringBuilder();
      this.sql.append("ALTER TABLE APP.ventas ADD MONTOICBPER DECIMAL(14,2);");
      this.sql.append("ALTER TABLE APP.ventasdetalle  ADD MONTOICBPER DECIMAL(14,2);");
      this.sql.append("ALTER TABLE APP.ventas ADD FECHASINCRONIZACIONDMK timestamp;");
      this.sql.append("ALTER TABLE APP.ventas ADD MENSAJEERROR varchar(100);");
      this.sql.append("ALTER TABLE APP.ventas ADD CODALMACEN varchar(10);");
      return this.sql.toString();
   }
}
