package DbPeru.Posm.BaseDatos.Implementacion.MYSQL;

import DbPeru.Posm.Interfaces.IArticulo;
import DbPeru.Posm.Modelo.Articulo;
import DbPeru.Posm.Respuesta.ResponseArticuloUndDmk;
import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Respuesta.ResponseStock;
import DbPeru.Posm.Respuesta.ResponseStockArticulo;
import DbPeru.Posm.Solicitudes.RequestArticulo;
import DbPeru.Posm.Solicitudes.RequestStockArticulo;
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
public class ArticuloMYSQL implements IArticulo {
   @Autowired
   @Qualifier("MYSQL")
   private DataSource con;
   private static Log log = LogFactory.getLog(ArticuloMYSQL.class);

   public List ListarArticuloDmk() {
      List<Articulo> ListaArticulo = new ArrayList();
      String SQL = "call sp_GetArticulos()";

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
                     Articulo ObjArticulo = new Articulo();
                     ObjArticulo.setCodArticulo(rs.getString(1));
                     ObjArticulo.setCodFamilia(rs.getString(2));
                     ObjArticulo.setCodSubFamilia(rs.getString(3));
                     ObjArticulo.setDescArticulo(rs.getString(4));
                     ObjArticulo.setTipoIgv(rs.getString(8));
                     ObjArticulo.setImgArticulo(rs.getString(10));
                     ObjArticulo.setCodSunat(rs.getString(11));
                     ObjArticulo.setIcbper(rs.getBoolean(12));
                     ObjArticulo.setMontoIcbper(rs.getString(13));
                     ObjArticulo.setControlPeso(rs.getString(14));
                     ObjArticulo.setCodArtNue(rs.getString(15));
                     ListaArticulo.add(ObjArticulo);
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

      return ListaArticulo;
   }

   public List ListarArticuloUndDmk(String listaPrecio, String codalmacen) {
      List<ResponseArticuloUndDmk> ListaArticulo = new ArrayList();
      String SQL = "call sp_GetPrecioUnidades()";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     ResponseArticuloUndDmk ObjArticulo = new ResponseArticuloUndDmk();
                     ObjArticulo.setCodArticulo(rs.getString(1));
                     ObjArticulo.setCodUnidadM(rs.getString(2));
                     ObjArticulo.setPrecio(rs.getDouble(4));
                     ObjArticulo.setCbarArtiUni(rs.getString(5));
                     ObjArticulo.setStock(rs.getDouble(6));
                     ObjArticulo.setDescuento(rs.getDouble(7));
                     ListaArticulo.add(ObjArticulo);
                  }
               } finally {
                  if (pstmt != null) {
                     pstmt.close();
                  }

               }
            } catch (Throwable var24) {
               if (var5 == null) {
                  var5 = var24;
               } else if (var5 != var24) {
                  var5.addSuppressed(var24);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var5;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var25) {
            if (var5 == null) {
               var5 = var25;
            } else if (var5 != var25) {
               var5.addSuppressed(var25);
            }

            throw var5;
         }
      } catch (SQLException e) {
         e.printStackTrace();
         log.error(e.getMessage().toString());
      }

      return ListaArticulo;
   }

   public ResponseStockArticulo VerificarStockArticulo(List articulo) {
      ResponseStockArticulo responsearticulo = new ResponseStockArticulo();
      Boolean EncontradoFalso = true;
      Integer ControlarStock = 0;
      String SQL = "call sp_wsposm_ObtenerStockArticulo(?)";
      List<ResponseStock> listadostockarticulo = new ArrayList();

      try {
         Throwable var7 = null;
         Object var8 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  XStream ConvertirAxml = new XStream();
                  System.out.println("xxx" + ConvertirAxml.toXML(articulo));

                  ResponseStock ObjArticulo;
                  for(ResultSet rs = pstmt.executeQuery(); rs.next(); listadostockarticulo.add(ObjArticulo)) {
                     ObjArticulo = new ResponseStock();
                     ObjArticulo.setCodArticulo(rs.getString("codarticulo"));
                     ObjArticulo.setStock(rs.getDouble("stockdmk"));
                     ObjArticulo.setStockSolicitado(rs.getDouble("stocksolicitado"));
                     ObjArticulo.setEstado(rs.getInt("estado"));
                     ObjArticulo.setNombreArticulo(rs.getString("nombrearticulo"));
                     ControlarStock = rs.getInt("strStock");
                     if (ObjArticulo.getEstado() == 0) {
                        EncontradoFalso = false;
                     }
                  }

                  responsearticulo.setStrStock(ControlarStock);
                  responsearticulo.setExito(EncontradoFalso);
                  responsearticulo.setArticuloStock(listadostockarticulo);
               } finally {
                  if (pstmt != null) {
                     pstmt.close();
                  }

               }
            } catch (Throwable var27) {
               if (var7 == null) {
                  var7 = var27;
               } else if (var7 != var27) {
                  var7.addSuppressed(var27);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var7;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var28) {
            if (var7 == null) {
               var7 = var28;
            } else if (var7 != var28) {
               var7.addSuppressed(var28);
            }

            throw var7;
         }
      } catch (SQLException e) {
         e.printStackTrace();
         log.error(e.getMessage().toString());
      }

      return responsearticulo;
   }

   public ResponseDMK InsArticuloDmk(RequestArticulo articulo) {
      ResponseDMK respuesta = new ResponseDMK();
      String SQL = "call sp_InsArticulo(?)";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  XStream ConvertirAxml = new XStream();
                  pstmt.setString(1, ConvertirAxml.toXML(articulo));
                  System.out.println("xxx" + ConvertirAxml.toXML(articulo));
                  log.info("xxx" + ConvertirAxml.toXML(articulo));
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

   public ResponseDMK InsArticulosDmk(List articulos) {
      ResponseDMK respuesta = new ResponseDMK();
      String SQL = "call sp_InsArticulos(?)";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  XStream ConvertirAxml = new XStream();
                  pstmt.setString(1, ConvertirAxml.toXML(articulos));
                  System.out.println("xxx" + ConvertirAxml.toXML(articulos));
                  log.info("xxx" + ConvertirAxml.toXML(articulos));
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
