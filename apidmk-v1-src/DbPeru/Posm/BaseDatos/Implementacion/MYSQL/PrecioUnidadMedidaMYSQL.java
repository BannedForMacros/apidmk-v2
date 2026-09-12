package DbPeru.Posm.BaseDatos.Implementacion.MYSQL;

import DbPeru.Posm.Interfaces.IPrecioUnidadMedida;
import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Solicitudes.RequestPrecioUnidadMedida;
import com.thoughtworks.xstream.XStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PrecioUnidadMedidaMYSQL implements IPrecioUnidadMedida {
   private static Log log = LogFactory.getLog(UnidadMedidaMYSQL.class);
   @Autowired
   @Qualifier("MYSQL")
   private DataSource con;

   public ResponseDMK InsPrecioUnidadMedida(RequestPrecioUnidadMedida unidadMedida) {
      ResponseDMK respuesta = new ResponseDMK();
      String SQL = "call sp_InsUpdPrecioUnidadMedida(?)";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  XStream ConvertirAxml = new XStream();
                  pstmt.setString(1, ConvertirAxml.toXML(unidadMedida));
                  System.out.println("xxx" + ConvertirAxml.toXML(unidadMedida));
                  log.info("xxx" + ConvertirAxml.toXML(unidadMedida));
                  ResultSet rs = pstmt.executeQuery();
                  if (rs.next()) {
                     if (rs.getInt("CODIGO") == 1) {
                        respuesta.setExito(true);
                        respuesta.setMensaje(rs.getString("MENSAJE"));
                        log.info(rs.getString("MENSAJE"));
                     } else {
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
               if (var4 == null) {
                  var4 = var23;
               } else if (var4 != var23) {
                  var4.addSuppressed(var23);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var4;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var24) {
            if (var4 == null) {
               var4 = var24;
            } else if (var4 != var24) {
               var4.addSuppressed(var24);
            }

            throw var4;
         }
      } catch (SQLException e) {
         respuesta.setExito(false);
         respuesta.setMensaje(e.getMessage());
         log.error(e.getMessage().toString());
      }

      return respuesta;
   }

   public ResponseDMK InsPrecioUnidadMedidas(List unidadMedidas) {
      ResponseDMK respuesta = new ResponseDMK();
      String SQL = "call sp_InsUpdPrecioUnidadMedidas(?)";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  XStream ConvertirAxml = new XStream();
                  pstmt.setString(1, ConvertirAxml.toXML(unidadMedidas));
                  System.out.println("xxx" + ConvertirAxml.toXML(unidadMedidas));
                  log.info("xxx" + ConvertirAxml.toXML(unidadMedidas));
                  ResultSet rs = pstmt.executeQuery();
                  if (rs.next()) {
                     if (rs.getInt("CODIGO") == 1) {
                        respuesta.setExito(true);
                        respuesta.setMensaje(rs.getString("MENSAJE"));
                        log.info(rs.getString("MENSAJE"));
                     } else {
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
               if (var4 == null) {
                  var4 = var23;
               } else if (var4 != var23) {
                  var4.addSuppressed(var23);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var4;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var24) {
            if (var4 == null) {
               var4 = var24;
            } else if (var4 != var24) {
               var4.addSuppressed(var24);
            }

            throw var4;
         }
      } catch (SQLException e) {
         respuesta.setExito(false);
         respuesta.setMensaje(e.getMessage());
         log.error(e.getMessage().toString());
      }

      return respuesta;
   }
}
