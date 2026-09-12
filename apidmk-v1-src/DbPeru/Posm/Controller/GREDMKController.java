package DbPeru.Posm.Controller;

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
import DbPeru.Posm.Service.GREDMKService;
import DbPeru.Posm.Solicitudes.RequestChoferes;
import DbPeru.Posm.Solicitudes.RequestProveedores;
import DbPeru.Posm.Solicitudes.RequestUbigeo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(
   tags = {"GREDMK"}
)
@SwaggerDefinition(
   tags = {@Tag(
   name = "tipo",
   description = "ControladoR de Guia Remision DMK"
)}
)
@Controller
public class GREDMKController {
   @Autowired
   private GREDMKService SGREDMK;

   @ApiOperation("Listar Almacenes")
   @RequestMapping(
      value = {"/GREDMK/ObtenerAlmacenes"},
      method = {RequestMethod.GET}
   )
   @ResponseBody
   public ResponseAlmacen ObtenerAlmacenes() {
      return this.SGREDMK.ObtenerAlmacenes();
   }

   @ApiOperation("Listar operaciones activas")
   @RequestMapping(
      value = {"/GREDMK/ObtenerOperacion"},
      method = {RequestMethod.GET}
   )
   @ResponseBody
   public ResponseOperaciones ObtenerOperacion() {
      return this.SGREDMK.ObtenerOperacion();
   }

   @ApiOperation("Listar Choferes")
   @RequestMapping(
      value = {"/GREDMK/ObtenerChoferes"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseChoferes ObtenerChoferes(@RequestBody RequestChoferes Datos) {
      return this.SGREDMK.ObtenerChoferes(Datos);
   }

   @ApiOperation("Listar Listas de Precios")
   @RequestMapping(
      value = {"/GREDMK/ObtenerSucursalPrecio"},
      method = {RequestMethod.GET}
   )
   @ResponseBody
   public ResponseListaPrecio ObtenerSucursalPrecio() {
      return this.SGREDMK.ObtenerSucursalPrecio();
   }

   @ApiOperation("Listar Proveedores")
   @RequestMapping(
      value = {"/GREDMK/ObtenerProveedores"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseProveedores ObtenerProveedores(@RequestBody RequestProveedores reqproveedor) {
      return this.SGREDMK.ObtenerProveedores(reqproveedor);
   }

   @ApiOperation("Listar Para Obtener Transportistas")
   @RequestMapping(
      value = {"/GREDMK/ObtenerTransportista"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseTransportista ObtenerTransportista(@RequestBody RequestProveedores reqtransportista) {
      return this.SGREDMK.ObtenerTransportista(reqtransportista);
   }

   @ApiOperation("Listar Para Obtener Vehiculos")
   @RequestMapping(
      value = {"/GREDMK/ObtenerVehiculo"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseVehiculo ObtenerVehiculo(@RequestBody RequestProveedores reqvehiculo) {
      return this.SGREDMK.ObtenerVehiculo(reqvehiculo);
   }

   @ApiOperation("Listar series y numeros de Guias")
   @RequestMapping(
      value = {"/GREDMK/obtenerSeriesNumerosGuia"},
      method = {RequestMethod.GET}
   )
   @ResponseBody
   public ResponseSerieNumero obtenerSeriesNumerosGuia() {
      return this.SGREDMK.obtenerSeriesNumerosGuia();
   }

   @ApiOperation("Listar Formas de Pago")
   @RequestMapping(
      value = {"/GREDMK/ObtenerFormasPago"},
      method = {RequestMethod.GET}
   )
   @ResponseBody
   public ResponseFormasPago ObtenerFormasPago() {
      return this.SGREDMK.ObtenerFormasPago();
   }

   @ApiOperation("Listar Trabajadores")
   @RequestMapping(
      value = {"/GREDMK/ObtenerTrabajador"},
      method = {RequestMethod.GET}
   )
   @ResponseBody
   public ResponseTrabajador ObtenerTrabajador(int CodigoTrabajador) {
      return this.SGREDMK.ObtenerTrabajador(CodigoTrabajador);
   }

   @ApiOperation("Listar Articulos")
   @RequestMapping(
      value = {"/GREDMK/ObtenerArticulo"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseArticulo ObtenerArticulo(@RequestBody DatosReqArticulo reqArticulo) {
      return this.SGREDMK.ObtenerArticulo(reqArticulo);
   }

   @ApiOperation("Listar tipoCambio")
   @RequestMapping(
      value = {"/GREDMK/obtenerTipoCambio"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseTipoCambio obtenerTipoCambio(@RequestBody DatosReqTipoCambio reqTipoCambio) {
      return this.SGREDMK.obtenerTipoCambio(reqTipoCambio);
   }

   @ApiOperation("Listar Clientes")
   @RequestMapping(
      value = {"/GREDMK/obtenerCliente"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseCliente obtenerCliente(@RequestBody DatosReqCliente reqCliente) {
      return this.SGREDMK.obtenerCliente(reqCliente);
   }

   @ApiOperation("Insertar Guia Remision en DMK")
   @RequestMapping(
      value = {"/GREDMK/InsertGuiaDMK"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseGREDMK InsertGuiaDMK(@RequestBody DatosGuiaRem GuiaRem) {
      return this.SGREDMK.InsertGuiaDMK(GuiaRem);
   }

   @ApiOperation("Lista Datos Ubigeo")
   @RequestMapping(
      value = {"/GREDMK/ObtieneUbigeos"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseDatosUbigeo ObtieneUbigeos(@RequestBody RequestUbigeo reqUbigeo) {
      return this.SGREDMK.ObtieneUbigeos(reqUbigeo);
   }
}
