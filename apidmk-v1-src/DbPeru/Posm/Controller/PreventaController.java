package DbPeru.Posm.Controller;

import DbPeru.Posm.Modelo.Preventa;
import DbPeru.Posm.Respuesta.Response;
import DbPeru.Posm.Respuesta.ResponsePreventaDMK;
import DbPeru.Posm.Service.PreventaService;
import DbPeru.Posm.Solicitudes.RequestPreventaDMK;
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
   tags = {"PREVENTA"}
)
@SwaggerDefinition(
   tags = {@Tag(
   name = "tipo",
   description = "Lista"
)}
)
@Controller
public class PreventaController {
   @Autowired
   private PreventaService SPreventa;

   @ApiOperation("Registrar Preventa de Posm")
   @RequestMapping(
      value = {"/Preventa/RegistroPreventa"},
      method = {RequestMethod.POST},
      consumes = {"application/json"}
   )
   @ResponseBody
   public Response InsertarPreventa(@RequestBody Preventa preventa) {
      return this.SPreventa.InsertarPreventa(preventa);
   }

   @ApiOperation("Listar Correlativo Preventa Posm")
   @RequestMapping(
      value = {"/Preventa/listapreventanumero"},
      method = {RequestMethod.POST},
      consumes = {"application/json"}
   )
   @ResponseBody
   public ResponsePreventaDMK listapreventanumero(@RequestBody RequestPreventaDMK preventa) {
      return this.SPreventa.ListaPreventaNumero(preventa);
   }
}
