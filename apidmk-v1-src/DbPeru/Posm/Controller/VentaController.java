package DbPeru.Posm.Controller;

import DbPeru.Posm.Modelo.Venta;
import DbPeru.Posm.Respuesta.Response;
import DbPeru.Posm.Respuesta.ResponseHash;
import DbPeru.Posm.Service.VentaService;
import DbPeru.Posm.Solicitudes.RequestActualizaHash;
import DbPeru.Posm.Solicitudes.RequestVenta;
import DbPeru.Posm.Solicitudes.RequestVentaDMK;
import DbPeru.Posm.Solicitudes.RequestVentasSinHash;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(
   tags = {"VENTA"}
)
@SwaggerDefinition(
   tags = {@Tag(
   name = "tipo",
   description = "Lista"
)}
)
@Controller
public class VentaController {
   @Autowired
   private VentaService SVenta;

   @ApiOperation("Registrar Venta de Checkout")
   @RequestMapping(
      value = {"/"},
      method = {RequestMethod.GET}
   )
   public String PaginaInicio() {
      return "Index";
   }

   @ApiOperation("Registrar Venta de Checkout")
   @RequestMapping(
      value = {"/Venta/RegistroVenta"},
      method = {RequestMethod.POST},
      consumes = {"application/json"}
   )
   @ResponseBody
   public Response InsertarVenta(@RequestBody Venta venta) {
      return this.SVenta.InsertarVenta(venta);
   }

   @ApiOperation("Actualiza Hash Venta ")
   @RequestMapping(
      value = {"/Venta/ActualizaHash"},
      method = {RequestMethod.POST},
      consumes = {"application/json"}
   )
   @ResponseBody
   public Response ActualizaHash(@RequestBody RequestActualizaHash venta) {
      return this.SVenta.ActualizaHash(venta);
   }

   @ApiOperation("Consulta Hash de Venta")
   @RequestMapping(
      value = {"/Venta/ConsultaHash"},
      method = {RequestMethod.POST},
      consumes = {"application/json"}
   )
   @ResponseBody
   public ResponseHash ListaVenta(@RequestBody RequestVenta venta) {
      return this.SVenta.ListaHash(venta);
   }

   @ApiOperation("Actualizar Estado Sincronizacion Con Dmk")
   @RequestMapping(
      value = {"/Venta/ConfirmarSincronizacionDmk"},
      method = {RequestMethod.POST},
      consumes = {"application/json"}
   )
   @ResponseBody
   public Response ActualizarEstadoSincronizacionDmk(@RequestBody RequestVenta venta) {
      return this.SVenta.ActualizarEstadoSincronizacionVenta(venta);
   }

   @ApiOperation("Listar Ventas")
   @RequestMapping(
      value = {"/Venta/ListarVentas"},
      method = {RequestMethod.POST},
      consumes = {"application/json"}
   )
   @ResponseBody
   public List ListarVenta(@RequestBody RequestVentaDMK venta) {
      return this.SVenta.ListarVenta(venta);
   }

   @ApiOperation("Verifica Ventas sin Codigo Hash")
   @RequestMapping(
      value = {"/Venta/ListarVentasSinCodigoHash"},
      method = {RequestMethod.POST},
      consumes = {"application/json"}
   )
   @ResponseBody
   public List ListarVentaSinCodigoHash(@RequestBody RequestVentasSinHash venta) {
      return this.SVenta.ListaVentasSinHash(venta);
   }
}
