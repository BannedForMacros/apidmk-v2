package DbPeru.Posm.Interfaces;

import DbPeru.Posm.Modelo.DatosGuiaRem;
import DbPeru.Posm.Modelo.DatosReqArticulo;
import DbPeru.Posm.Modelo.DatosReqCliente;
import DbPeru.Posm.Modelo.DatosReqTipoCambio;
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

public interface IGREDMK {
   ResponseAlmacen ObtenerAlmacenes();

   ResponseOperaciones ObtenerOperacion();

   ResponseChoferes ObtenerChoferes(RequestChoferes var1);

   ResponseListaPrecio ObtenerSucursalPrecio();

   ResponseProveedores ObtenerProveedores(RequestProveedores var1);

   ResponseTransportista ObtenerTransportista(RequestProveedores var1);

   ResponseVehiculo ObtenerVehiculo(RequestProveedores var1);

   ResponseSerieNumero obtenerSeriesNumerosGuia();

   ResponseFormasPago ObtenerFormasPago();

   ResponseTrabajador ObtenerTrabajador(int var1);

   ResponseArticulo ObtenerArticulo(DatosReqArticulo var1);

   ResponseTipoCambio obtenerTipoCambio(DatosReqTipoCambio var1);

   ResponseCliente obtenerCliente(DatosReqCliente var1);

   ResponseGREDMK InsertGuiaDMK(DatosGuiaRem var1);

   ResponseDatosUbigeo ObtieneUbigeos(RequestUbigeo var1);
}
