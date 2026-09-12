package DbPeru.Posm.Service;

import DbPeru.Posm.BaseDatos.Implementacion.MSSQL.GREDMKMSSQL;
import DbPeru.Posm.Interfaces.IGREDMK;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GREDMKService implements IGREDMK {
   @Autowired
   private GREDMKMSSQL gredmkMSSQL;

   public ResponseAlmacen ObtenerAlmacenes() {
      return this.gredmkMSSQL.ObtenerAlmacenes();
   }

   public ResponseOperaciones ObtenerOperacion() {
      return this.gredmkMSSQL.ObtenerOperacion();
   }

   public ResponseChoferes ObtenerChoferes(RequestChoferes nombrechofer) {
      return this.gredmkMSSQL.ObtenerChoferes(nombrechofer);
   }

   public ResponseListaPrecio ObtenerSucursalPrecio() {
      return this.gredmkMSSQL.ObtenerSucursalPrecio();
   }

   public ResponseProveedores ObtenerProveedores(RequestProveedores reqproveedor) {
      return this.gredmkMSSQL.ObtenerProveedores(reqproveedor);
   }

   public ResponseTransportista ObtenerTransportista(RequestProveedores reqtransportista) {
      return this.gredmkMSSQL.ObtenerTransportista(reqtransportista);
   }

   public ResponseVehiculo ObtenerVehiculo(RequestProveedores reqvehiculo) {
      return this.gredmkMSSQL.ObtenerVehiculo(reqvehiculo);
   }

   public ResponseSerieNumero obtenerSeriesNumerosGuia() {
      return this.gredmkMSSQL.obtenerSeriesNumerosGuia();
   }

   public ResponseFormasPago ObtenerFormasPago() {
      return this.gredmkMSSQL.ObtenerFormasPago();
   }

   public ResponseTrabajador ObtenerTrabajador(int codigoTrabajador) {
      return this.gredmkMSSQL.ObtenerTrabajador(codigoTrabajador);
   }

   public ResponseArticulo ObtenerArticulo(DatosReqArticulo reqArticulo) {
      return this.gredmkMSSQL.ObtenerArticulo(reqArticulo);
   }

   public ResponseTipoCambio obtenerTipoCambio(DatosReqTipoCambio reqTipoCambio) {
      return this.gredmkMSSQL.obtenerTipoCambio(reqTipoCambio);
   }

   public ResponseCliente obtenerCliente(DatosReqCliente reqCliente) {
      return this.gredmkMSSQL.obtenerCliente(reqCliente);
   }

   public ResponseGREDMK InsertGuiaDMK(DatosGuiaRem guiaRem) {
      return this.gredmkMSSQL.InsertGuiaDMK(guiaRem);
   }

   public ResponseDatosUbigeo ObtieneUbigeos(RequestUbigeo reqUbigeo) {
      return this.gredmkMSSQL.ObtieneUbigeos(reqUbigeo);
   }
}
