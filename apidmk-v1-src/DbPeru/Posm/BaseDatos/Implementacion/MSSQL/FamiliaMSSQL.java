package DbPeru.Posm.BaseDatos.Implementacion.MSSQL;

import DbPeru.Posm.Interfaces.IFamilia;
import DbPeru.Posm.Modelo.Familia;
import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Solicitudes.RequestFamilia;
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
public class FamiliaMSSQL implements IFamilia {
   private static Log log = LogFactory.getLog(FamiliaMSSQL.class);
   @Autowired
   @Qualifier("SQLSERVER")
   private DataSource con;

   public List ListaFamilia() {
      List<Familia> ListaFamilia = new ArrayList();
      String SQL = "{ call pr_wsposm_dmk (?,?,?) }";

      try {
         Throwable var3 = null;
         Object var4 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setInt("@opc", 4);
                  pstmt.setString("@CodListaPrecio", "0");
                  pstmt.setString("@Codalmacen", "0");
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

   public ResponseDMK InsUpdFamilias(List familias) {
      return null;
   }

   public ResponseDMK InsUpFamilia(RequestFamilia familia) {
      return null;
   }
}
