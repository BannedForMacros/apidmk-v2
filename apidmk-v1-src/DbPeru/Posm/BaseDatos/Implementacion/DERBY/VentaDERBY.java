package DbPeru.Posm.BaseDatos.Implementacion.DERBY;

import DbPeru.Posm.Interfaces.IVenta;
import DbPeru.Posm.Modelo.Venta;
import DbPeru.Posm.Modelo.Ventaformapago;
import DbPeru.Posm.Modelo.Ventasdetalle;
import DbPeru.Posm.Respuesta.Response;
import DbPeru.Posm.Respuesta.ResponseHash;
import DbPeru.Posm.Respuesta.ResponseVenta;
import DbPeru.Posm.Respuesta.ResponseVentaformapago;
import DbPeru.Posm.Respuesta.ResponseVentasSinHash;
import DbPeru.Posm.Respuesta.ResponseVentasdetalle;
import DbPeru.Posm.Solicitudes.RequestActualizaHash;
import DbPeru.Posm.Solicitudes.RequestVenta;
import DbPeru.Posm.Solicitudes.RequestVentaDMK;
import DbPeru.Posm.Solicitudes.RequestVentasSinHash;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Repository
@Transactional
public class VentaDERBY implements IVenta {
   private static Log log = LogFactory.getLog(VentaDERBY.class);
   @Autowired
   @Qualifier("JDBCTEMPLATE")
   private JdbcTemplate getJdbcTemplate;
   @Autowired
   @Qualifier("transactiones")
   private PlatformTransactionManager platformTransactionManager;
   @Autowired
   @Qualifier("DERBY")
   private DriverManagerDataSource derbyconnection;

   @Transactional
   public Response InsertarVenta(Venta venta) {
      DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
      TransactionStatus status = this.platformTransactionManager.getTransaction(paramTransactionDefinition);
      Response respuesta = new Response();
      StringBuilder sql = new StringBuilder();

      try {
         if (venta.getVentasdetalle().size() > 0) {
            sql.append("INSERT INTO APP.VENTAS (rucempresa,razonsocial,cod_documento,seri_Venta,nume_Venta,COD_DOCUMENTOI,RAZONSOCIALCLI,NUMERODOCUMENTOCLI,").append("direccioncli,CORREOCLI,CodigoHash,codigoSucursal,femi_Venta,horaEmision,IMPU_VENTA,doc_Rela_Nc,").append("tipo_Doc_Rela_NC,tipo_NC,motivo_Nc,numeroItems,redo_Venta,tcamb_Venta,tneto_Venta,").append("texon_Venta,tina_Venta,total_Venta,vuel_Venta,SINCRONIZACIONDMK,MONTOICBPER,CODALMACEN,CODIGOTERMINAL)");
            String SQLQUERY = sql.toString();
            String SQLPARAM = "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            this.getJdbcTemplate.update(SQLQUERY + " " + SQLPARAM, new Object[]{venta.getRucEmpresa(), venta.getRazonSocial(), venta.getCodDocumento(), venta.getSeriVenta(), venta.getNumeVenta(), venta.getCodDocumentoi(), venta.getRazonSocialCli(), venta.getNumeroDocumentoCli(), venta.getDireccionCli(), venta.getCorreoCli(), venta.getCodigohash(), venta.getCodigoSucursal(), venta.getFemiVenta(), venta.getHoraEmision(), venta.getImpuVenta(), venta.getDocRelaNc(), venta.getTipoDocRelaNc(), venta.getTipoNc(), venta.getMotivoNc(), venta.getNumeroItems(), venta.getRedoVenta(), venta.getTcambVenta(), venta.getTnetoVenta(), venta.getTexonVenta(), venta.getTinaVenta(), venta.getTotalVenta(), venta.getVuelVenta(), 0, venta.getMontoIcbper(), venta.getCodAlmacen(), venta.getCodTerminal()});

            for(Ventasdetalle objdetalleventa : venta.getVentasdetalle()) {
               sql = new StringBuilder();
               sql.append("insert into APP.ventasdetalle (COD_DOCUMENTO,SERI_VENTA,NUME_VENTA,ID_VENTASD,Cant_Ventasd ,COD_ARTICULO");
               sql.append(",COD_UNIDADM ,UnidadMedida,codigoSunat , puni_Ventasd ,impu_Ventasd");
               sql.append(",tasa_Imp ,tdesc_Porc_Ventasd ,tdesc_Ventasd ,timp_Ventasd ,tip_Igv,TNETO_VENTASD,MONTOICBPER )");
               String SQLQUERYDETALLE = sql.toString();
               String SQLPARAMDETALLE = " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
               this.getJdbcTemplate.update(SQLQUERYDETALLE + " " + SQLPARAMDETALLE, new Object[]{venta.getCodDocumento(), venta.getSeriVenta(), venta.getNumeVenta(), objdetalleventa.getIdVentasd(), objdetalleventa.getCantVentasd(), objdetalleventa.getCodArticulo(), objdetalleventa.getCodUnidadm(), objdetalleventa.getUnidadMedida(), objdetalleventa.getCodigoSunat(), objdetalleventa.getPuniVentasd(), objdetalleventa.getImpuVentasd(), objdetalleventa.getTasaImp(), objdetalleventa.getTdescPorcVentasd(), objdetalleventa.getTdescVentasd(), objdetalleventa.getTimpVentasd(), objdetalleventa.getTipIgv(), objdetalleventa.getTnetoVentasd(), objdetalleventa.getMontoIcbper()});
            }

            for(Ventaformapago objformapago : venta.getVentaformapago()) {
               int codtarjeta = 0;
               if (Integer.parseInt(objformapago.getIdFpago()) >= 2 && Integer.parseInt(objformapago.getIdFpago()) <= 3) {
                  objformapago.setIdFpago("3");
               }

               if (Integer.parseInt(objformapago.getIdFpago()) == 2) {
                  codtarjeta = 1;
               }

               if (Integer.parseInt(objformapago.getIdFpago()) == 3) {
                  codtarjeta = 2;
               }

               if (Integer.parseInt(objformapago.getIdFpago()) == 4) {
                  objformapago.setIdFpago("6");
                  codtarjeta = 0;
               }

               sql = new StringBuilder();
               sql.append("insert into APP.ventaformapago (COD_DOCUMENTO,SERI_VENTA,NUME_VENTAS,ID_FPAGO,TMONT_FORMAP,CODTARJETA,REFE_FORMAP)");
               String SQLQUERYFORMAPAGO = sql.toString();
               String SQLPARAMFORMAPAGO = " VALUES (?,?,?,?,?,?,?)";
               this.getJdbcTemplate.update(SQLQUERYFORMAPAGO + " " + SQLPARAMFORMAPAGO, new Object[]{venta.getCodDocumento(), venta.getSeriVenta(), venta.getNumeVenta(), objformapago.getIdFpago(), objformapago.getTmontFormap(), codtarjeta, objformapago.getRefeFormap()});
            }

            this.platformTransactionManager.commit(status);
         }

         log.info("DOCUMENTO " + venta.getCodDocumento().toString() + " - " + venta.getSeriVenta().toString() + " - " + venta.getNumeVenta().toString() + " Registrado Correctamente ");
         respuesta.setCodigo("1");
         respuesta.setExito(true);
         respuesta.setMensaje("Documento registrada correctamente");
         return respuesta;
      } catch (InvalidResultSetAccessException e) {
         respuesta.setCodigo("0");
         respuesta.setExito(false);
         respuesta.setMensaje(e.getMessage().toString());
         this.platformTransactionManager.rollback(status);
         log.error(e.getMessage());
         throw new RuntimeException(e);
      } catch (DataAccessException e) {
         respuesta.setCodigo("0");
         respuesta.setExito(false);
         respuesta.setMensaje(e.getMessage().toString());
         this.platformTransactionManager.rollback(status);
         log.error(e.getMessage());
         throw new RuntimeException(e);
      }
   }

   public List ListarVenta(RequestVentaDMK venta) {
      ResultSet rs = null;
      Connection conn = null;
      Statement sttm = null;
      List<ResponseVenta> listaventa = new ArrayList();
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT  ");
      sql.append("SERI_VENTA as numserie ,NUME_VENTA as numdocumento , COD_DOCUMENTO as tipodocumento,");
      sql.append("FEMI_VENTA as fechaemision ,HORAEMISION as horaemision, TNETO_VENTA as totalgravadas,");
      sql.append("TINA_VENTA as totalinafectos ,TEXON_VENTA as totalexonerados,IMPU_VENTA as totaligv,");
      sql.append("TDES_VENTA as totaldescuento ,TOTAL_VENTA as totalventa, COD_DOCUMENTOI as tipodocumentocli,");
      sql.append("RAZONSOCIALCLI as razonsocialcli ,NUMERODOCUMENTOCLI as numerodocumentocli,");
      sql.append("DIRECCIONCLI as direccioncli ,CORREOCLI as correocli, CODIGOTERMINAL as codigoterminal,");
      sql.append("NUMEROITEMS as numeroitems ,CODIGOSUCURSAL as codigosucursal,TCAMB_VENTA as tipocambio,");
      sql.append("CODIGOHASH as codigohash, ");
      sql.append("SUBSTR(DOC_RELA_NC,1,4) AS numserieref , SUBSTR(DOC_RELA_NC,6) as numdocumentoref , TIPO_DOC_RELA_NC as tipodocumentoref,");
      sql.append("TIPO_NC as codigomotivonc, MOTIVO_NC as sustentonc , TDES_VENTA as descuentototalventa ,CODALMACEN as codalmacen  from APP.ventas ");
      sql.append(" WHERE  RUCEMPRESA='" + venta.getRucEmpresa() + "' and SINCRONIZACIONDMK= '0'  and CODIGOSUCURSAL='" + venta.getCodSucursal() + "' fetch first 100 rows only ");

      try {
         conn = this.derbyconnection.getConnection();
         sttm = conn.createStatement();
         rs = sttm.executeQuery(sql.toString());
         new ResponseVenta();

         while(rs.next()) {
            ResponseVenta ObjVenta = new ResponseVenta();
            ObjVenta.setNumSerie(rs.getString("numserie"));
            ObjVenta.setNumDocumento(rs.getString("numdocumento"));
            ObjVenta.setTipoDocumento(rs.getString("tipodocumento"));
            ObjVenta.setFechaEmision(rs.getString("fechaemision"));
            ObjVenta.setHoraEmision(rs.getString("horaemision"));
            ObjVenta.setTotalGravadas(rs.getBigDecimal("totalgravadas"));
            ObjVenta.setTotalInafectos(rs.getBigDecimal("totalinafectos"));
            ObjVenta.setTotalExonerados(rs.getBigDecimal("totalexonerados"));
            ObjVenta.setTotalVenta(rs.getBigDecimal("totalventa"));
            ObjVenta.setTipoDocumentoCli(rs.getInt("tipodocumentocli"));
            ObjVenta.setRazonSocialCli(rs.getString("razonsocialcli"));
            ObjVenta.setNumeroDocumentoCli(rs.getString("numerodocumentocli"));
            ObjVenta.setDireccionCli(rs.getString("direccioncli"));
            ObjVenta.setCorreoCli(rs.getString("correocli"));
            ObjVenta.setNumeroItems(rs.getInt("numeroitems"));
            ObjVenta.setCodigoSucursal(rs.getString("codigosucursal"));
            ObjVenta.setTipoCambio(rs.getString("tipocambio"));
            ObjVenta.setCodigoHash(rs.getString("codigohash"));
            ObjVenta.setNumSerieRef(rs.getString("numserieref"));
            ObjVenta.setNumSerieRef(rs.getString("numserieref"));
            ObjVenta.setNumDocumentoRef(rs.getString("numdocumentoref"));
            ObjVenta.setTipoDocumentoRef(rs.getString("tipodocumentoref"));
            ObjVenta.setTotalIgv(rs.getBigDecimal("totaligv"));
            ObjVenta.setTotalDescuento(rs.getBigDecimal("descuentototalventa"));
            ObjVenta.setCodAlmacen(rs.getString("codalmacen"));
            ObjVenta.setCodigoTerminal(rs.getString("codigoterminal"));
            new StringBuilder();
            StringBuilder sqldeta = new StringBuilder();
            sqldeta.append("select ID_VENTASD as item, COD_ARTICULO as codigoarticulo ,COD_UNIDADM as codunidadmedida,");
            sqldeta.append("UNIDADMEDIDA as unidadmedida , CANT_VENTASD as cantidad ,PUNI_VENTASD as precio , TIMP_VENTASD as total , CODIGOSUNAT as codigosunat ,");
            sqldeta.append("TIP_IGV as tipoigv , case WHEN tip_igv=1 then 10 WHEN  tip_igv=2 THEN 20 WHEN  tip_igv=3 THEN 30     ELSE 0 END as tipoafectacion ,");
            sqldeta.append(" TDESC_VENTASD as montodescuento , TDESC_PORC_VENTASD as porcentajedescuento ,TASA_IMP as igv ");
            sqldeta.append("from APP.ventasdetalle");
            sqldeta.append(" WHERE ");
            sqldeta.append("SERI_VENTA= '" + ObjVenta.getNumSerie() + "'  and  NUME_VENTA='" + ObjVenta.getNumDocumento() + "' and COD_DOCUMENTO='" + ObjVenta.getTipoDocumento() + "' ");
            ResultSet rss = null;
            Statement sttmm = null;
            List<ResponseVentasdetalle> Listadetalleventa = new ArrayList();
            sttmm = conn.createStatement();
            rss = sttmm.executeQuery(sqldeta.toString());
            new ResponseVentasdetalle();

            while(rss.next()) {
               ResponseVentasdetalle ObjVentaDetalle = new ResponseVentasdetalle();
               ObjVentaDetalle.setItem(rss.getInt("item"));
               ObjVentaDetalle.setCodArticulo(rss.getString("codigoarticulo"));
               ObjVentaDetalle.setCodUnidadMedida(rss.getString("codunidadmedida"));
               ObjVentaDetalle.setUnidadMedida(rss.getString("unidadmedida"));
               ObjVentaDetalle.setCantidad(rss.getBigDecimal("cantidad"));
               ObjVentaDetalle.setPrecio(rss.getBigDecimal("precio"));
               ObjVentaDetalle.setTotal(rss.getBigDecimal("total"));
               ObjVentaDetalle.setCodigoSunat(rss.getString("codigosunat"));
               ObjVentaDetalle.setTipoIgv(rss.getInt("tipoigv"));
               ObjVentaDetalle.setTipoAfectacion(rss.getInt("tipoafectacion"));
               ObjVentaDetalle.setMontoDescuento(rss.getBigDecimal("montodescuento"));
               ObjVentaDetalle.setMontoDescuentoPorcentaje(rss.getBigDecimal("porcentajedescuento"));
               ObjVentaDetalle.setIgv(rss.getBigDecimal("igv"));
               Listadetalleventa.add(ObjVentaDetalle);
            }

            ObjVenta.setResponseVentaDetalle(Listadetalleventa);
            StringBuilder sqlfpagoa = new StringBuilder();
            sqlfpagoa.append("SELECT  ");
            sqlfpagoa.append("COD_DOCUMENTO  as tipodocumento,SERI_VENTA,NUME_VENTAS as numerodocumento,ID_FPAGO as codformapago, CODTARJETA, ");
            sqlfpagoa.append("TMONT_FORMAP as importepago  , TCAMB_FORMAP as tipocambio,");
            sqlfpagoa.append("CODSUCURSAL,  REFE_FORMAP as numtarjeta from APP.ventaformapago");
            sqlfpagoa.append(" WHERE ");
            sqlfpagoa.append("SERI_VENTA='" + ObjVenta.getNumSerie() + "' and  NUME_VENTAS='" + ObjVenta.getNumDocumento() + "' and COD_DOCUMENTO='" + ObjVenta.getTipoDocumento() + "'  ");
            ResultSet rsss = null;
            Statement sttmmm = null;
            List<ResponseVentaformapago> ListaFormaPago = new ArrayList();
            sttmmm = conn.createStatement();
            rsss = sttmm.executeQuery(sqlfpagoa.toString());
            new ResponseVentaformapago();

            while(rsss.next()) {
               ResponseVentaformapago ObjVentaFormaPago = new ResponseVentaformapago();
               ObjVentaFormaPago.setCodFormaPago(rsss.getInt("codformapago"));
               ObjVentaFormaPago.setCodTarjeta(rsss.getInt("CODTARJETA"));
               ObjVentaFormaPago.setImportePago(rsss.getBigDecimal("importepago"));
               ObjVentaFormaPago.setNumTarjeta(rsss.getString("numtarjeta"));
               ListaFormaPago.add(ObjVentaFormaPago);
            }

            ObjVenta.setResponseVentaFormapago(ListaFormaPago);
            listaventa.add(ObjVenta);
         }
      } catch (Exception e) {
         log.error(e.getMessage().toString());
      }

      return listaventa;
   }

   @Transactional
   public Response ActualizarEstadoSincronizacionVenta(RequestVenta venta) {
      Response respuesta = new Response();
      DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
      TransactionStatus status = this.platformTransactionManager.getTransaction(paramTransactionDefinition);

      try {
         this.getJdbcTemplate.update("UPDATE APP.ventas SET SINCRONIZACIONDMK='1' where COD_DOCUMENTO= ? and SERI_VENTA= ? and NUME_VENTA= ? and CODIGOSUCURSAL=? and RUCEMPRESA=?", new Object[]{venta.getTipoDocumento(), venta.getSeriVenta(), venta.getNumeVenta(), venta.getCodSucursal(), venta.getRucEmpresa()});
         this.platformTransactionManager.commit(status);
         log.info("DOCUMENTO " + venta.getTipoDocumento().toString() + " - " + venta.getSeriVenta().toString() + " - " + venta.getNumeVenta().toString() + " Sincronizado");
         respuesta.setCodigo("1");
         respuesta.setExito(true);
         respuesta.setMensaje("Sincronizado Correctamente");
         return respuesta;
      } catch (InvalidResultSetAccessException e) {
         respuesta.setCodigo("0");
         respuesta.setExito(false);
         respuesta.setMensaje(e.getMessage().toString());
         this.platformTransactionManager.rollback(status);
         log.error(e.getMessage().toString());
         throw new RuntimeException(e);
      } catch (DataAccessException e) {
         respuesta.setCodigo("0");
         respuesta.setExito(false);
         respuesta.setMensaje(e.getMessage().toString());
         this.platformTransactionManager.rollback(status);
         log.error(e.getMessage().toString());
         throw new RuntimeException(e);
      }
   }

   public Response ActualizaHash(RequestActualizaHash venta) {
      Response respuesta = new Response();
      DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
      TransactionStatus status = this.platformTransactionManager.getTransaction(paramTransactionDefinition);
      Timestamp fechaactual = new Timestamp(System.currentTimeMillis());

      try {
         this.getJdbcTemplate.update("UPDATE APP.ventas SET CODIGOHASH=? ,MENSAJEERROR=? , SINCRONIZACIONDMK='1' ,FECHASINCRONIZACIONDMK=? where COD_DOCUMENTO=? and SERI_VENTA=? and NUME_VENTA=? and CODIGOSUCURSAL=?  and RUCEMPRESA=?", new Object[]{venta.getCodigoHash(), venta.getMensaje(), fechaactual, venta.getTipoDocumento(), venta.getSeriVenta(), venta.getNumeVenta(), venta.getCodSucursal(), venta.getRucEmpresa()});
         this.platformTransactionManager.commit(status);
         log.info("DOCUMENTO " + venta.getTipoDocumento().toString() + " - " + venta.getSeriVenta().toString() + " - " + venta.getNumeVenta().toString() + " Hash Actualizado");
         respuesta.setCodigo("1");
         respuesta.setExito(true);
         respuesta.setMensaje("Hash Actualizado Correctamente");
         return respuesta;
      } catch (InvalidResultSetAccessException e) {
         respuesta.setCodigo("0");
         respuesta.setExito(false);
         respuesta.setMensaje(e.getMessage().toString());
         this.platformTransactionManager.rollback(status);
         log.error(e.getMessage().toString());
         throw new RuntimeException(e);
      } catch (DataAccessException e) {
         respuesta.setCodigo("0");
         respuesta.setExito(false);
         respuesta.setMensaje(e.getMessage().toString());
         this.platformTransactionManager.rollback(status);
         log.error(e.getMessage().toString());
         throw new RuntimeException(e);
      }
   }

   public ResponseHash ListaHash(RequestVenta venta) {
      ResultSet rs = null;
      Connection conn = null;
      Statement sttm = null;
      StringBuilder sql = new StringBuilder();
      ResponseHash Rpthash = new ResponseHash();
      sql.append("SELECT  ");
      sql.append("SERI_VENTA as numserie,NUME_VENTA as numdocumento, COD_DOCUMENTO as tipodocumento, ");
      sql.append("FEMI_VENTA as fechaemision,HORAEMISION  as horaemision , TNETO_VENTA as totalgravadas,");
      sql.append("TINA_VENTA as totalinafectos,TEXON_VENTA as totalexonerados,IMPU_VENTA as totaligv,");
      sql.append("TDES_VENTA as totaldescuento ,TOTAL_VENTA as totalventa, COD_DOCUMENTOI as tipodocumentocli,");
      sql.append("RAZONSOCIALCLI as razonsocialcli ,NUMERODOCUMENTOCLI as numerodocumentocli,");
      sql.append("DIRECCIONCLI as direccioncli,CORREOCLI as correocli, CODIGOTERMINAL as codigoterminal,");
      sql.append("NUMEROITEMS as numeroitems,CODIGOSUCURSAL as codigosucursal,TCAMB_VENTA as tipocambio,");
      sql.append("NULLIF(CODIGOHASH,'') as codigohash,");
      sql.append("SUBSTR(DOC_RELA_NC,1,4) AS numserieref , SUBSTR(DOC_RELA_NC,6) as numdocumentoref , TIPO_DOC_RELA_NC as tipodocumentoref,");
      sql.append("TIPO_NC as codigomotivonc, MOTIVO_NC as sustentonc , TDES_VENTA  as descuentototalventa, nullif(MENSAJEERROR,'') as MENSAJEERROR from APP.ventas");
      sql.append(" WHERE  RUCEMPRESA='" + venta.getRucEmpresa() + "'and CODIGOSUCURSAL='" + venta.getCodSucursal() + "'and  SERI_VENTA ='" + venta.getSeriVenta() + "' and NUME_VENTA = '" + venta.getNumeVenta() + "' and COD_DOCUMENTO = '" + venta.getTipoDocumento() + "'");
      sql.append("order by COD_DOCUMENTO");

      try {
         conn = this.derbyconnection.getConnection();
         sttm = conn.createStatement();
         rs = sttm.executeQuery(sql.toString());
         new ResponseVenta();

         while(rs.next()) {
            ResponseVenta ObjVenta = new ResponseVenta();
            ObjVenta.setCodigoHash(rs.getString("codigohash"));
            if (ObjVenta.getCodigoHash().isEmpty() && ObjVenta.getCodigoHash().toString().trim().equals("")) {
               Rpthash.setExito(false);
               Rpthash.setCodigo("0");
               Rpthash.setCodigoHash("");
               Rpthash.setMensaje("Hash Vacio");
            } else {
               Rpthash.setExito(true);
               Rpthash.setCodigo("1");
               Rpthash.setCodigoHash(ObjVenta.getCodigoHash().toString());
               Rpthash.setMensaje("Hash Encontrado");
            }
         }
      } catch (Exception e) {
         log.error(e.getMessage().toString());
      }

      return Rpthash;
   }

   public List ListaVentasSinHash(RequestVentasSinHash venta) {
      ResultSet rs = null;
      Connection conn = null;
      Statement sttm = null;
      List<ResponseVentasSinHash> listaventa = new ArrayList();
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT ");
      sql.append("SERI_VENTA as numserie ,NUME_VENTA as numdocumento , COD_DOCUMENTO as tipodocumento from APP.ventas");
      sql.append(" WHERE  RUCEMPRESA='" + venta.getRucEmpresa() + "' and SINCRONIZACIONDMK= '0'  and CODIGOHASH='' and CODIGOSUCURSAL='" + venta.getCodSucursal() + "' ");

      try {
         conn = this.derbyconnection.getConnection();
         sttm = conn.createStatement();
         rs = sttm.executeQuery(sql.toString());
         new ResponseVentasSinHash();

         while(rs.next()) {
            ResponseVentasSinHash ObjVenta = new ResponseVentasSinHash();
            ObjVenta.setSeriVenta(rs.getString("numserie"));
            ObjVenta.setNumeVenta(rs.getString("numdocumento"));
            ObjVenta.setTipoDocumento(rs.getString("tipodocumento"));
            listaventa.add(ObjVenta);
         }
      } catch (Exception e) {
         log.error(e.getMessage().toString());
      }

      return listaventa;
   }
}
