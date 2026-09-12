package DbPeru.Posm.BaseDatos.Implementacion.MYSQL;

import DbPeru.Posm.Interfaces.IVenta;
import DbPeru.Posm.Modelo.Venta;
import DbPeru.Posm.Modelo.VentaRequest;
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
public class VentaMYSQL implements IVenta {
   private static Log log = LogFactory.getLog(VentaMYSQL.class);
   @Autowired
   @Qualifier("MYSQL")
   private DataSource con;

   public Response InsertarVenta(Venta venta) {
      XStream ConvertirAxml = new XStream();
      Response respuesta = new Response();
      String SQL = "call InsDocumentoVenta2(?,?,?)";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  VentaRequest ventaTmp = new VentaRequest(venta);
                  String a = "Venta: " + ConvertirAxml.toXML(ventaTmp);
                  String vb = "VentaDetalle: " + ConvertirAxml.toXML(venta.getVentasdetalle());
                  String c = "FormaPago" + ConvertirAxml.toXML(venta.getVentaformapago());
                  pstmt.setString(1, ConvertirAxml.toXML(ventaTmp));
                  pstmt.setString(2, ConvertirAxml.toXML(venta.getVentasdetalle()));
                  pstmt.setString(3, ConvertirAxml.toXML(venta.getVentaformapago()));
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     if (rs.getInt("CODIGO") == 1) {
                        respuesta.setCodigo("1");
                        respuesta.setExito(true);
                        respuesta.setMensaje(rs.getString("MENSAJE"));
                        log.info(rs.getString("MENSAJE"));
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
            } catch (Throwable var27) {
               if (var5 == null) {
                  var5 = var27;
               } else if (var5 != var27) {
                  var5.addSuppressed(var27);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var5;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var28) {
            if (var5 == null) {
               var5 = var28;
            } else if (var5 != var28) {
               var5.addSuppressed(var28);
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

   public List ListarVenta(RequestVentaDMK venta) {
      List<ResponseVenta> ListaVenta = new ArrayList();
      new ResponseVenta();
      String SQL = "call GetListaVentaXEmpresa(?,?)";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setString(1, venta.getRucEmpresa());
                  pstmt.setString(2, venta.getCodSucursal());
                  ResultSet rs = pstmt.executeQuery();

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
                     ObjVenta.setCodigoTerminal(rs.getString("codigoterminal"));
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
                     List<ResponseVentasdetalle> ListaVentasDetalle = new ArrayList();
                     String SQLDETALLE = "call GetListaDetalleVentaXDocumento(?,?,?,?)";

                     try {
                        Throwable var12 = null;
                        String var13 = null;

                        try {
                           CallableStatement pstmtt = conn.prepareCall(SQLDETALLE);

                           try {
                              pstmtt.setString(1, ObjVenta.getTipoDocumento());
                              pstmtt.setString(2, ObjVenta.getNumSerie());
                              pstmtt.setString(3, ObjVenta.getNumDocumento());
                              pstmtt.setString(4, ObjVenta.getCodigoSucursal());
                              ResultSet rss = pstmtt.executeQuery();
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
                                 ListaVentasDetalle.add(ObjVentaDetalle);
                              }

                              ObjVenta.setResponseVentaDetalle(ListaVentasDetalle);
                           } finally {
                              if (pstmtt != null) {
                                 pstmtt.close();
                              }

                           }
                        } catch (Throwable var93) {
                           if (var12 == null) {
                              var12 = var93;
                           } else if (var12 != var93) {
                              var12.addSuppressed(var93);
                           }

                           throw var12;
                        }
                     } catch (SQLException e) {
                        log.error(e.getMessage().toString());
                     }

                     List<ResponseVentaformapago> ListaVentaFormapago = new ArrayList();
                     String SQLFORMAPAGO = "call GetListaFormaPagoVentaxDocumento(?,?,?,?)";

                     try {
                        Throwable e = null;
                        ResultSet var102 = null;

                        try {
                           CallableStatement pstmttt = conn.prepareCall(SQLFORMAPAGO);

                           try {
                              pstmttt.setString(1, ObjVenta.getTipoDocumento());
                              pstmttt.setString(2, ObjVenta.getNumSerie());
                              pstmttt.setString(3, ObjVenta.getNumDocumento());
                              pstmttt.setString(4, ObjVenta.getCodigoSucursal());
                              ResultSet rsss = pstmttt.executeQuery();
                              new ResponseVentaformapago();

                              while(rsss.next()) {
                                 ResponseVentaformapago ObjVentaFormaPago = new ResponseVentaformapago();
                                 ObjVentaFormaPago.setCodFormaPago(rsss.getInt("codformapago"));
                                 ObjVentaFormaPago.setCodTarjeta(rsss.getInt("CODTARJETA"));
                                 ObjVentaFormaPago.setImportePago(rsss.getBigDecimal("importepago"));
                                 ObjVentaFormaPago.setNumTarjeta(rsss.getString("numtarjeta"));
                                 ListaVentaFormapago.add(ObjVentaFormaPago);
                              }
                           } finally {
                              if (pstmttt != null) {
                                 pstmttt.close();
                              }

                           }
                        } catch (Throwable var90) {
                           if (e == null) {
                              e = var90;
                           } else if (e != var90) {
                              e.addSuppressed(var90);
                           }

                           throw e;
                        }
                     } catch (SQLException e) {
                        log.error(e.getMessage().toString());
                     }

                     ObjVenta.setResponseVentaFormapago(ListaVentaFormapago);
                     ListaVenta.add(ObjVenta);
                  }
               } finally {
                  if (pstmt != null) {
                     pstmt.close();
                  }

               }
            } catch (Throwable var96) {
               if (var5 == null) {
                  var5 = var96;
               } else if (var5 != var96) {
                  var5.addSuppressed(var96);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var5;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var97) {
            if (var5 == null) {
               var5 = var97;
            } else if (var5 != var97) {
               var5.addSuppressed(var97);
            }

            throw var5;
         }
      } catch (SQLException e) {
         log.error(e.getMessage().toString());
      }

      return ListaVenta;
   }

   public ResponseHash ListaHash(RequestVenta venta) {
      ResponseHash Rpthash = new ResponseHash();
      new ResponseVenta();
      String SQL = "call GetVentaXEmpresa(?,?,?,?,?)";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setString(1, venta.getTipoDocumento());
                  pstmt.setString(2, venta.getSeriVenta());
                  pstmt.setString(3, venta.getNumeVenta());
                  pstmt.setString(4, venta.getCodSucursal());
                  pstmt.setString(5, venta.getRucEmpresa());
                  ResultSet rs = pstmt.executeQuery();
                  boolean records = false;

                  while(rs.next()) {
                     records = true;
                     ResponseVenta ObjVenta = new ResponseVenta();
                     ObjVenta.setCodigoHash(rs.getString("codigohash"));
                     Rpthash.setMensaje(rs.getString("MENSAJEERROR"));
                     if (ObjVenta.getCodigoHash().isEmpty() && ObjVenta.getCodigoHash().toString().trim().equals("")) {
                        Rpthash.setExito(false);
                        Rpthash.setCodigo("0");
                        Rpthash.setCodigoHash("");
                        Rpthash.setMensaje("Hash Vacio");
                     } else {
                        Rpthash.setExito(true);
                        Rpthash.setCodigo("1");
                        Rpthash.setCodigoHash(ObjVenta.getCodigoHash().toString());
                     }
                  }

                  if (!records) {
                     Rpthash.setExito(false);
                     Rpthash.setCodigo("0");
                     Rpthash.setCodigoHash("");
                     Rpthash.setMensaje("No se Encontro Registros");
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
         Rpthash.setExito(false);
         Rpthash.setCodigoHash("");
         Rpthash.setMensaje(e.getMessage().toString());
         log.error(e.getMessage().toString());
      }

      return Rpthash;
   }

   public Response ActualizarEstadoSincronizacionVenta(RequestVenta venta) {
      Response respuesta = new Response();
      String SQL = "call UpdEstadoSincronizacionDmk(?,?,?,?,?)";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setString(1, venta.getTipoDocumento());
                  pstmt.setString(2, venta.getSeriVenta());
                  pstmt.setString(3, venta.getNumeVenta());
                  pstmt.setString(4, venta.getCodSucursal());
                  pstmt.setString(5, venta.getRucEmpresa());
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     if (rs.getInt("CODIGO") == 1) {
                        respuesta.setCodigo("1");
                        respuesta.setExito(true);
                        respuesta.setMensaje(rs.getString("MENSAJE"));
                        log.info(rs.getString("MENSAJE"));
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
            } catch (Throwable var22) {
               if (var4 == null) {
                  var4 = var22;
               } else if (var4 != var22) {
                  var4.addSuppressed(var22);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var4;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var23) {
            if (var4 == null) {
               var4 = var23;
            } else if (var4 != var23) {
               var4.addSuppressed(var23);
            }

            throw var4;
         }
      } catch (SQLException e) {
         respuesta.setCodigo("0");
         respuesta.setExito(false);
         respuesta.setMensaje(e.getMessage());
         log.error(e.getMessage().toString());
      }

      return respuesta;
   }

   public Response ActualizaHash(RequestActualizaHash venta) {
      Response respuesta = new Response();
      String SQL = "call UpdCodigoHash(?,?,?,?,?,?,?)";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setString(1, venta.getTipoDocumento());
                  pstmt.setString(2, venta.getSeriVenta());
                  pstmt.setString(3, venta.getNumeVenta());
                  pstmt.setString(4, venta.getCodSucursal());
                  pstmt.setString(5, venta.getRucEmpresa());
                  pstmt.setString(6, venta.getCodigoHash());
                  pstmt.setString(7, venta.getMensaje());
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     if (rs.getInt("CODIGO") == 1) {
                        respuesta.setCodigo("1");
                        respuesta.setExito(true);
                        respuesta.setMensaje(rs.getString("MENSAJE"));
                        log.info(rs.getString("MENSAJE"));
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
            } catch (Throwable var22) {
               if (var4 == null) {
                  var4 = var22;
               } else if (var4 != var22) {
                  var4.addSuppressed(var22);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var4;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var23) {
            if (var4 == null) {
               var4 = var23;
            } else if (var4 != var23) {
               var4.addSuppressed(var23);
            }

            throw var4;
         }
      } catch (SQLException e) {
         respuesta.setCodigo("0");
         respuesta.setExito(false);
         respuesta.setMensaje(e.getMessage());
         log.error(e.getMessage().toString());
      }

      return respuesta;
   }

   public List ListaVentasSinHash(RequestVentasSinHash venta) {
      new ResponseVentasSinHash();
      List<ResponseVentasSinHash> Listaventa = new ArrayList();
      String SQL = "call GetListaVentasSinHash(?,?)";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setString(1, venta.getCodSucursal());
                  pstmt.setString(2, venta.getRucEmpresa());
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     ResponseVentasSinHash ObjVenta = new ResponseVentasSinHash();
                     ObjVenta.setTipoDocumento(rs.getString("tipodocumento"));
                     ObjVenta.setSeriVenta(rs.getString("seriventa"));
                     ObjVenta.setNumeVenta(rs.getString("numeventa"));
                     Listaventa.add(ObjVenta);
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
         Listaventa = null;
         log.error(e.getMessage().toString());
      }

      return Listaventa;
   }
}
