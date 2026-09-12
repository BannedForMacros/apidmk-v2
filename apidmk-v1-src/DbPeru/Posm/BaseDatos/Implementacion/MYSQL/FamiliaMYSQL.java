package DbPeru.Posm.BaseDatos.Implementacion.MYSQL;

import DbPeru.Posm.Interfaces.IFamilia;
import DbPeru.Posm.Modelo.Familia;
import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Solicitudes.RequestFamilia;
import com.thoughtworks.xstream.XStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class FamiliaMYSQL implements IFamilia {
   private static Log log = LogFactory.getLog(FamiliaMYSQL.class);
   @Autowired
   @Qualifier("MYSQL")
   private DataSource con;

   public List ListaFamilia() {
      List<Familia> ListaFamilia = new ArrayList();
      String SQL = "call sp_GetFamilias()";

      try {
         Throwable var3 = null;
         Object var4 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     Familia ObjFamilia = new Familia();
                     ObjFamilia.setCodFamilia(rs.getString(1));
                     ObjFamilia.setDescFam(rs.getString(2));
                     ObjFamilia.setSubfDes(rs.getString(3));
                     ObjFamilia.setEstaFamilia(rs.getInt(4));
                     ListaFamilia.add(ObjFamilia);
                  }
               } finally {
                  if (pstmt != null) {
                     pstmt.close();
                  }

               }
            } catch (Throwable var22) {
               if (var3 == null) {
                  var3 = var22;
               } else if (var3 != var22) {
                  var3.addSuppressed(var22);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var3;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var23) {
            if (var3 == null) {
               var3 = var23;
            } else if (var3 != var23) {
               var3.addSuppressed(var23);
            }

            throw var3;
         }
      } catch (SQLException e) {
         e.printStackTrace();
         log.error(e.getMessage().toString());
      }

      return ListaFamilia;
   }

   public ResponseDMK InsUpFamilia(RequestFamilia familia) {
      ResponseDMK respuesta = new ResponseDMK();
      String SQL = "call sp_InsUpdFamilia(?)";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  XStream ConvertirAxml = new XStream();
                  pstmt.setString(1, ConvertirAxml.toXML(familia));
                  System.out.println("xxx" + ConvertirAxml.toXML(familia));
                  log.info("xxx" + ConvertirAxml.toXML(familia));
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

   public ResponseDMK InsUpdFamilias(List familias) {
      ResponseDMK respuesta = new ResponseDMK();
      String SQL = "call sp_InsUpdFamilia(?)";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  XStream ConvertirAxml = new XStream();
                  pstmt.setString("1", ConvertirAxml.toXML(familias));
                  System.out.println("xxx" + ConvertirAxml.toXML(familias));
                  log.info("xxx" + ConvertirAxml.toXML(familias));
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
