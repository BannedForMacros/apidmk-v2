package DbPeru.Posm.BaseDatos.Implementacion.MSSQL;

import DbPeru.Posm.Interfaces.IPreventa;
import DbPeru.Posm.Modelo.Preventa;
import DbPeru.Posm.Respuesta.Response;
import DbPeru.Posm.Respuesta.ResponsePreventaDMK;
import DbPeru.Posm.Solicitudes.RequestPreventaDMK;
import com.thoughtworks.xstream.XStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PreventaMSSQL implements IPreventa {
   private static Log log = LogFactory.getLog(PreventaMSSQL.class);
   @Autowired
   @Qualifier("SQLSERVER")
   private DataSource con;

   public Response InsertarPreventa(Preventa preventa) {
      XStream ConvertirAxml = new XStream();
      Response respuesta = new Response();
      String SQL = "{ call PR_registrarPreventa (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setInt("@tipodocu", preventa.getTipoDocumento());
                  pstmt.setInt("@numserie", preventa.getNumSerie());
                  pstmt.setInt("@numerodocumento", preventa.getNumDocumento());
                  pstmt.setInt("@codestacion", preventa.getCodEstacion());
                  pstmt.setDouble("@valorneto", preventa.getValorNeto());
                  pstmt.setDouble("@importedescuento", preventa.getImporteDescuento());
                  pstmt.setDouble("@valorventa", preventa.getValorVenta());
                  pstmt.setDouble("@igv", preventa.getIgv());
                  pstmt.setDouble("@importetotal", preventa.getImporteTotal());
                  pstmt.setString("@tipomoneda", preventa.getTipoMoneda());
                  pstmt.setString("@estado", preventa.getEstado());
                  pstmt.setInt("@codtrabajador", preventa.getCodTrabajador());
                  pstmt.setInt("@codvendedor", preventa.getCodVendedor());
                  pstmt.setString("@estadodocumento", preventa.getEstadoDocumento());
                  pstmt.setInt("@codalmacen", preventa.getCodAlmacen());
                  pstmt.setString("@comentario", preventa.getComentario());
                  pstmt.setString("@fecemi", preventa.getFechaEmi());
                  pstmt.setString("@XMLDETALLEVENTAPREVENTA", ConvertirAxml.toXML(preventa.listaPreventa));
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     if (rs.getInt("CODIGO") == 1) {
                        respuesta.setCodigo("1");
                        respuesta.setExito(true);
                        respuesta.setMensaje(rs.getString("MENSAJE"));
                     } else {
                        respuesta.setCodigo("0");
                        respuesta.setExito(false);
                        respuesta.setMensaje(rs.getString("MENSAJE"));
                        log.error(rs.getString("MENSAJE"));
                     }
                  }
               } finally {
                  if (pstmt != null) {
                     pstmt.close();
                  }

               }
            } catch (Throwable var23) {
               if (var5 == null) {
                  var5 = var23;
               } else if (var5 != var23) {
                  var5.addSuppressed(var23);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var5;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var24) {
            if (var5 == null) {
               var5 = var24;
            } else if (var5 != var24) {
               var5.addSuppressed(var24);
            }

            throw var5;
         }
      } catch (SQLException e) {
         respuesta.setCodigo("0");
         respuesta.setExito(false);
         respuesta.setMensaje(e.getMessage());
         log.error(e.getMessage().toString());
      }

      return respuesta;
   }

   public ResponsePreventaDMK ListaPreventaNumero(RequestPreventaDMK preventa) {
      int Codigo = 0;
      ResponsePreventaDMK pre = new ResponsePreventaDMK();
      String SQL = "{ call pr_consulta_prevDMK (?,?) }";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setInt("@serie", preventa.getSerie());
                  pstmt.setInt("@numero", preventa.getNumero());

                  for(ResultSet rs = pstmt.executeQuery(); rs.next(); Codigo = rs.getInt(1)) {
                  }

                  pre.setDocTransaccion(Codigo);
               } finally {
                  if (pstmt != null) {
                     pstmt.close();
                  }

               }
            } catch (Throwable var23) {
               if (var5 == null) {
                  var5 = var23;
               } else if (var5 != var23) {
                  var5.addSuppressed(var23);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var5;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var24) {
            if (var5 == null) {
               var5 = var24;
            } else if (var5 != var24) {
               var5.addSuppressed(var24);
            }

            throw var5;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return pre;
   }
}
