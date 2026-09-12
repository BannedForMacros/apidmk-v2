package DbPeru.Posm.BaseDatos.Implementacion.MSSQL;

import DbPeru.Posm.Interfaces.IGREDMK;
import DbPeru.Posm.Modelo.Chofer;
import DbPeru.Posm.Modelo.DatosAlmacen;
import DbPeru.Posm.Modelo.DatosCliente;
import DbPeru.Posm.Modelo.DatosFormasPago;
import DbPeru.Posm.Modelo.DatosGuiaRem;
import DbPeru.Posm.Modelo.DatosProvedor;
import DbPeru.Posm.Modelo.DatosReqArticulo;
import DbPeru.Posm.Modelo.DatosReqCliente;
import DbPeru.Posm.Modelo.DatosReqTipoCambio;
import DbPeru.Posm.Modelo.DatosRespArticulo;
import DbPeru.Posm.Modelo.DatosRespTipoCambio;
import DbPeru.Posm.Modelo.DatosSerieNumero;
import DbPeru.Posm.Modelo.DatosTrabajador;
import DbPeru.Posm.Modelo.DatosTransportista;
import DbPeru.Posm.Modelo.DatosUbigeo;
import DbPeru.Posm.Modelo.DatosVehiculo;
import DbPeru.Posm.Modelo.ListaPrecio;
import DbPeru.Posm.Modelo.Operacion;
import DbPeru.Posm.Respuesta.Response;
import DbPeru.Posm.Respuesta.ResponseAlmacen;
import DbPeru.Posm.Respuesta.ResponseArticulo;
import DbPeru.Posm.Respuesta.ResponseChoferes;
import DbPeru.Posm.Respuesta.ResponseCliente;
import DbPeru.Posm.Respuesta.ResponseDatosUbigeo;
import DbPeru.Posm.Respuesta.ResponseFormasPago;
import DbPeru.Posm.Respuesta.ResponseGREDMK;
import DbPeru.Posm.Respuesta.ResponseListaPrecio;
import DbPeru.Posm.Respuesta.ResponseOperaciones;
import DbPeru.Posm.Respuesta.ResponseProveedores;
import DbPeru.Posm.Respuesta.ResponseSerieNumero;
import DbPeru.Posm.Respuesta.ResponseTipoCambio;
import DbPeru.Posm.Respuesta.ResponseTrabajador;
import DbPeru.Posm.Respuesta.ResponseTransportista;
import DbPeru.Posm.Respuesta.ResponseVehiculo;
import DbPeru.Posm.Solicitudes.RequestChoferes;
import DbPeru.Posm.Solicitudes.RequestProveedores;
import DbPeru.Posm.Solicitudes.RequestUbigeo;
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
public class GREDMKMSSQL implements IGREDMK {
   @Autowired
   @Qualifier("SQLSERVER")
   private DataSource con;
   private static Log log = LogFactory.getLog(GREDMKMSSQL.class);

   public ResponseAlmacen ObtenerAlmacenes() {
      ResponseAlmacen rpt = new ResponseAlmacen();
      List<DatosAlmacen> ListaArticulo = new ArrayList();
      String SQL = "{ call GetMaestroalmacenByEstado (?) }";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setString("@Estado", "1");
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     DatosAlmacen ObjArticulo = new DatosAlmacen();
                     ObjArticulo.setCodAlmacen(rs.getInt("CodAlmacen"));
                     ObjArticulo.setDescripcion(rs.getString("Descripcion"));
                     ObjArticulo.setCodEstacion(rs.getInt("CodEstacion"));
                     ObjArticulo.setEstado(rs.getString("Estado"));
                     ObjArticulo.setCodInterno(rs.getString("CodInterno"));
                     ObjArticulo.setEstadoProduccion(rs.getBoolean("EstadoProduccion"));
                     ObjArticulo.setKardex(rs.getBoolean("Kardex"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.isExito();
                  }

                  rpt.setAlmacenes(ListaArticulo);
                  rpt.setMsgerror("");
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
         e.printStackTrace();
         log.error(e.getMessage().toString());
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseOperaciones ObtenerOperacion() {
      ResponseOperaciones rpt = new ResponseOperaciones();
      List<Operacion> ListaArticulo = new ArrayList();
      String SQL = "{ call GetMaestroOperacionByEstado (?) }";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setString("@Estado", "1");
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     Operacion ObjArticulo = new Operacion();
                     ObjArticulo.setTipoOperacion(rs.getInt("TipoOperacion"));
                     ObjArticulo.setDescripcion(rs.getString("Descripcion"));
                     ObjArticulo.setIngresoSalida(rs.getString("IngresoSalida"));
                     ObjArticulo.setCodigoSunat(rs.getString("CodigoSunat"));
                     ObjArticulo.setMotivotraslado(rs.getString("motivotraslado"));
                     ObjArticulo.setDescriMotivotraslado(rs.getString("descripmotivotraslado"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setOperaciones(ListaArticulo);
                  rpt.setMsgerror("");
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
         e.printStackTrace();
         log.error(e.getMessage().toString());
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseChoferes ObtenerChoferes(RequestChoferes nombrechofer) {
      ResponseChoferes rpt = new ResponseChoferes();
      List<Chofer> ListaArticulo = new ArrayList();
      String SQL = "{ call GetGuiaRemisionLikeForTipo (?,?) }";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setString("@Tipo", "7");
                  pstmt.setString("@Campo", nombrechofer.getNombrechofer());
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     Chofer ObjArticulo = new Chofer();
                     ObjArticulo.setBreveteChofer(rs.getString("BreveteChofer"));
                     ObjArticulo.setNombreChofer(rs.getString("NombreChofer"));
                     ObjArticulo.setDniChofer(rs.getString("DniChofer"));
                     ObjArticulo.setTelefono(rs.getString("Telefono"));
                     ObjArticulo.setEstado(rs.getString("Estado"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setChoferes(ListaArticulo);
                  rpt.setMsgerror("");
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
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseListaPrecio ObtenerSucursalPrecio() {
      ResponseListaPrecio rpt = new ResponseListaPrecio();
      List<ListaPrecio> ListaArticulo = new ArrayList();
      String SQL = "{ call GetSucursalPrecio }";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     ListaPrecio ObjArticulo = new ListaPrecio();
                     ObjArticulo.setCodEstacion(rs.getInt("CodEstacion"));
                     ObjArticulo.setRazonSocial(rs.getString("RazonSocial"));
                     ObjArticulo.setPrecio(rs.getString("Precio"));
                     ObjArticulo.setCodListaPrecio(rs.getInt("CodListaPrecio"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setListasPrecio(ListaArticulo);
                  rpt.setMsgerror("");
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
         e.printStackTrace();
         log.error(e.getMessage().toString());
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseProveedores ObtenerProveedores(RequestProveedores reqproveedor) {
      ResponseProveedores rpt = new ResponseProveedores();
      List<DatosProvedor> ListaArticulo = new ArrayList();
      String SQL = "";
      if (reqproveedor.getTipo() == 1) {
         SQL = "{ call GetMaestroproveedoresByCodproveedor(?) }";
      } else if (reqproveedor.getTipo() == 2) {
         SQL = "{ call GetMaestroproveedoresByRuc (?)}";
      } else {
         SQL = "{ call pr_consultaProveedorlikeRazonsocial (?)}";
      }

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  if (reqproveedor.getTipo() == 1) {
                     pstmt.setInt("@CodProveedor", Integer.parseInt(reqproveedor.getValor()));
                  } else if (reqproveedor.getTipo() == 2) {
                     pstmt.setString("@RUC", reqproveedor.getValor());
                  } else {
                     pstmt.setString("@RazonSocial", reqproveedor.getValor());
                  }

                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     DatosProvedor ObjArticulo = new DatosProvedor();
                     ObjArticulo.setCodProveedor(rs.getInt("CodProveedor"));
                     ObjArticulo.setNombreproveedor(rs.getString("NombreProveedor"));
                     ObjArticulo.setCuentacon(rs.getInt("CuentaCon"));
                     ObjArticulo.setCodEstacion(rs.getInt("CodEstacion"));
                     ObjArticulo.setCodDireccion(rs.getInt("CodDireccion"));
                     ObjArticulo.setDireccion(rs.getString("Direccion"));
                     ObjArticulo.setTelefono(rs.getString("Telefono"));
                     ObjArticulo.setRUC(rs.getString("RUC"));
                     ObjArticulo.setCodFormaPago(rs.getInt("CodFormaPago"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setProveedores(ListaArticulo);
                  rpt.setMsgerror("");
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
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseTransportista ObtenerTransportista(RequestProveedores reqtransportista) {
      ResponseTransportista rpt = new ResponseTransportista();
      List<DatosTransportista> ListaArticulo = new ArrayList();
      String SQL = "";
      SQL = "{ call GetGuiaRemisionLikeForTipo(?,?) }";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setInt("@Tipo", reqtransportista.getTipo());
                  pstmt.setString("@Campo", reqtransportista.getValor());
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     DatosTransportista ObjArticulo = new DatosTransportista();
                     ObjArticulo.setCodTransportista(rs.getInt("CodTransportista"));
                     ObjArticulo.setNombreTransportista(rs.getString("NombreTransportista"));
                     ObjArticulo.setDireccionTransportista(rs.getString("DireccionTransportista"));
                     ObjArticulo.setRucTransportista(rs.getString("RucTransportista"));
                     ObjArticulo.setTeléfonoTransportista(rs.getString("TelefonoTransportista"));
                     ObjArticulo.setEmailTransportista(rs.getString("EmailTransportista"));
                     ObjArticulo.setEstado(rs.getString("Estado"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setTransportistas(ListaArticulo);
                  rpt.setMsgerror("");
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
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseVehiculo ObtenerVehiculo(RequestProveedores reqvehiculo) {
      ResponseVehiculo rpt = new ResponseVehiculo();
      List<DatosVehiculo> ListaArticulo = new ArrayList();
      String SQL = "";
      SQL = "{ call GetGuiaRemisionLikeForTipo(?,?) }";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setInt("@Tipo", reqvehiculo.getTipo());
                  pstmt.setString("@Campo", reqvehiculo.getValor());
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     DatosVehiculo ObjArticulo = new DatosVehiculo();
                     ObjArticulo.setPlacaVehiculo(rs.getString("PlacaVehiculo"));
                     ObjArticulo.setMarcaVehiculo(rs.getString("MarcaVehiculo"));
                     ObjArticulo.setCodTransportista(rs.getInt("CodTransportista"));
                     ObjArticulo.setEstado(rs.getString("Estado"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setVehiculos(ListaArticulo);
                  rpt.setMsgerror("");
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
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseSerieNumero obtenerSeriesNumerosGuia() {
      ResponseSerieNumero rpt = new ResponseSerieNumero();
      List<DatosSerieNumero> ListaArticulo = new ArrayList();
      String SQL = "";
      SQL = "{ call GetMaestrodocumentoserieByTipodocumento(?) }";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setInt("@TipoDocumento", 12);
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     DatosSerieNumero ObjArticulo = new DatosSerieNumero();
                     ObjArticulo.setTipodocumento(rs.getInt("TipoDocumento"));
                     ObjArticulo.setNumserie(rs.getInt("NumSerie"));
                     ObjArticulo.setUtlimovalor(rs.getInt("UltimoValor"));
                     ObjArticulo.setUltimoValormarket(rs.getInt("UltimoValorMarket"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setSerienumeros(ListaArticulo);
                  rpt.setMsgerror("");
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
         e.printStackTrace();
         log.error(e.getMessage().toString());
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseFormasPago ObtenerFormasPago() {
      ResponseFormasPago rpt = new ResponseFormasPago();
      List<DatosFormasPago> ListaArticulo = new ArrayList();
      String SQL = "";
      SQL = "{ call GetMaestroformadepagoAll }";

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     DatosFormasPago ObjArticulo = new DatosFormasPago();
                     ObjArticulo.setCodFormaPago(rs.getInt("CodFormaPago"));
                     ObjArticulo.setDescripcion(rs.getString("Descripcion"));
                     ObjArticulo.setTipoMoneda(rs.getInt("TipoMoneda"));
                     ObjArticulo.setMoneda(rs.getString("Moneda"));
                     ObjArticulo.setDiasPago(rs.getInt("DiasPago"));
                     ObjArticulo.setDiasPago(rs.getInt("TarjetaCredito"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setFormasdePago(ListaArticulo);
                  rpt.setMsgerror("");
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
         e.printStackTrace();
         log.error(e.getMessage().toString());
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseTrabajador ObtenerTrabajador(int codigoTrabajador) {
      ResponseTrabajador rpt = new ResponseTrabajador();
      List<DatosTrabajador> ListaArticulo = new ArrayList();
      String SQL = "";
      SQL = "{ call GetMaestrotrabajadorByCodtrabajador(?) }";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setInt("@CodTrabajador", codigoTrabajador);
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     DatosTrabajador ObjArticulo = new DatosTrabajador();
                     ObjArticulo.setCodTrabajador(rs.getInt("CodTrabajador"));
                     ObjArticulo.setNombres(rs.getString("Nombres"));
                     ObjArticulo.setApellidos(rs.getString("Apellidos"));
                     ObjArticulo.setDNI(rs.getString("DNI"));
                     ObjArticulo.setCargo(rs.getString("Cargo"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setTrabajador(ListaArticulo);
                  rpt.setMsgerror("");
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
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseArticulo ObtenerArticulo(DatosReqArticulo reqArticulo) {
      ResponseArticulo rpt = new ResponseArticulo();
      List<DatosRespArticulo> ListaArticulo = new ArrayList();
      String SQL = "";
      SQL = "{ call GetMultiAlmacenGuiaIngMaestroarticuloByCodarticulo(?,?,?,?,?,?,?) }";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setInt("@TipoConsulta", reqArticulo.getTipoconsulta());
                  if (reqArticulo.getTipoconsulta() == 2) {
                     pstmt.setInt("@Codigo", Integer.parseInt(reqArticulo.getValor()));
                     pstmt.setString("@Descripcion", "");
                  } else {
                     pstmt.setInt("@Codigo", 0);
                     pstmt.setString("@Descripcion", reqArticulo.getValor());
                  }

                  pstmt.setInt("@CodEstacion", reqArticulo.getCodestacion());
                  pstmt.setInt("@CodAlmacen", reqArticulo.getCodalmacen());
                  pstmt.setInt("@CodListaPrecio", reqArticulo.getCodlistaprecio());
                  pstmt.setString("@Estado", "1");
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     DatosRespArticulo ObjArticulo = new DatosRespArticulo();
                     ObjArticulo.setCodArticulo(rs.getInt("Codigo"));
                     ObjArticulo.setNombreArticulo(rs.getString("NombreArticulo"));
                     ObjArticulo.setCodEstacion(rs.getInt("CodEstacion"));
                     ObjArticulo.setCodFamilia(rs.getInt("CodFamilia"));
                     ObjArticulo.setCodUnidad(rs.getInt("CodUnidad"));
                     ObjArticulo.setTipoMoneda(rs.getInt("TipoMoneda"));
                     ObjArticulo.setPrecioPublico(rs.getBigDecimal("PrecioPublico"));
                     ObjArticulo.setPrecioSinIGV(rs.getBigDecimal("PrecioSinIGV"));
                     ObjArticulo.setCostoArticulo(rs.getBigDecimal("CostoArticulo"));
                     ObjArticulo.setISC(rs.getBigDecimal("ISC"));
                     ObjArticulo.setIGV(rs.getBigDecimal("IGV"));
                     ObjArticulo.setStockMinimo(rs.getBigDecimal("StockMinimo"));
                     ObjArticulo.setStockMaximo(rs.getBigDecimal("StockMaximo"));
                     ObjArticulo.setCodBarra(rs.getString("CodBarra"));
                     ObjArticulo.setStock(rs.getBigDecimal("Stock"));
                     ObjArticulo.setCodBarraAd(rs.getString("CodBarraAd"));
                     ObjArticulo.setCodSubFamilia(rs.getInt("CodSubFamilia"));
                     ObjArticulo.setControlStock(rs.getString("ControlStock"));
                     ObjArticulo.setTipoKit(rs.getString("TipoKit"));
                     ObjArticulo.setCodArtNue(rs.getString("CodArtNue"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setArticulos(ListaArticulo);
                  rpt.setMsgerror("");
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
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseTipoCambio obtenerTipoCambio(DatosReqTipoCambio reqTipoCambio) {
      ResponseTipoCambio rpt = new ResponseTipoCambio();
      List<DatosRespTipoCambio> ListaArticulo = new ArrayList();
      String SQL = "";
      SQL = "{ call GetMaestrotipocambioByFechatipocambio(?,?) }";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setString("@FechaInicio", reqTipoCambio.getFechaInicio());
                  pstmt.setString("@FechaFin", reqTipoCambio.getFechaFin());
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     DatosRespTipoCambio ObjArticulo = new DatosRespTipoCambio();
                     ObjArticulo.setFecha(rs.getString("FechaTipoCambio"));
                     ObjArticulo.setVenta(rs.getBigDecimal("Venta"));
                     ObjArticulo.setCompra(rs.getBigDecimal("Compra"));
                     ObjArticulo.setTcEstacion(rs.getBigDecimal("TcEstacion"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setTipoCambio(ListaArticulo);
                  rpt.setMsgerror("");
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
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseCliente obtenerCliente(DatosReqCliente reqCliente) {
      ResponseCliente rpt = new ResponseCliente();
      List<DatosCliente> ListaArticulo = new ArrayList();
      String SQL = "";
      SQL = "{ call GetDatosClientexTipo(?,?) }";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setInt("@Tipoconsulta", reqCliente.getTipo());
                  pstmt.setString("@Valor", reqCliente.getValor());
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     DatosCliente ObjArticulo = new DatosCliente();
                     ObjArticulo.setRazonSocial(rs.getString("RazonSocial"));
                     ObjArticulo.setNombres(rs.getString("Nombres"));
                     ObjArticulo.setDireccion(rs.getString("Direccion"));
                     ObjArticulo.setCodZip(rs.getString("CodZip"));
                     ObjArticulo.setCodCliente(rs.getInt("CodCliente"));
                     ObjArticulo.setRucCliente(rs.getString("RucCliente"));
                     ObjArticulo.setDNI(rs.getString("DNI"));
                     ObjArticulo.setTelefono(rs.getString("Telefono"));
                     ObjArticulo.setTipoDocumentoIdentidad(rs.getString("TipoDocumentoIdentidad"));
                     ObjArticulo.setCodPostalEntrega(rs.getString("CodPostalEntrega"));
                     ObjArticulo.setDireccionEntrega(rs.getString("DireccionEntrega"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setCliente(ListaArticulo);
                  rpt.setMsgerror("");
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
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseGREDMK InsertGuiaDMK(DatosGuiaRem guiaRem) {
      ResponseGREDMK rpt = new ResponseGREDMK();
      XStream ConvertirAxml = new XStream();
      new Response();
      String SQL = "{ call prc_InsertGuiaDMKWeb(?) }";

      try {
         Throwable var6 = null;
         Object var7 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  String a = "Guia: " + ConvertirAxml.toXML(guiaRem);
                  pstmt.setString("@Guia", ConvertirAxml.toXML(guiaRem));
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     if (rs.getInt("CODIGO") == 1) {
                        rpt.setExito(true);
                        rpt.setMsgerror(rs.getString("MENSAJE"));
                        log.info(rs.getString("MENSAJE"));
                     } else {
                        rpt.setExito(false);
                        rpt.setMsgerror(rs.getString("MENSAJE"));
                        log.error(rs.getString("MENSAJE"));
                     }
                  }
               } finally {
                  if (pstmt != null) {
                     pstmt.close();
                  }

               }
            } catch (Throwable var25) {
               if (var6 == null) {
                  var6 = var25;
               } else if (var6 != var25) {
                  var6.addSuppressed(var25);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var6;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var26) {
            if (var6 == null) {
               var6 = var26;
            } else if (var6 != var26) {
               var6.addSuppressed(var26);
            }

            throw var6;
         }
      } catch (SQLException e) {
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage());
         log.error(e.getMessage().toString());
      }

      return rpt;
   }

   public ResponseDatosUbigeo ObtieneUbigeos(RequestUbigeo reqUbigeo) {
      ResponseDatosUbigeo rpt = new ResponseDatosUbigeo();
      List<DatosUbigeo> ListaArticulo = new ArrayList();
      String SQL = "";
      SQL = "{ call pr_ObtieneUbigeo(?,?) }";

      try {
         Throwable var5 = null;
         Object var6 = null;

         try {
            Connection conn = this.con.getConnection();

            try {
               CallableStatement pstmt = conn.prepareCall(SQL);

               try {
                  pstmt.setInt("@tipo", reqUbigeo.getTipoConsulta());
                  pstmt.setString("@ubigeo", reqUbigeo.getCodigoUbigeo());
                  ResultSet rs = pstmt.executeQuery();

                  while(rs.next()) {
                     DatosUbigeo ObjArticulo = new DatosUbigeo();
                     ObjArticulo.setCodUbigeo(rs.getString("ubigeo"));
                     ObjArticulo.setTipo(rs.getString("Tipo"));
                     ObjArticulo.setDescripcion(rs.getString("descripcion"));
                     ListaArticulo.add(ObjArticulo);
                     rpt.setExito(true);
                  }

                  rpt.setUbigeos(ListaArticulo);
                  rpt.setMsgerror("");
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
         rpt.setExito(false);
         rpt.setMsgerror(e.getMessage().toString());
      }

      return rpt;
   }
}
