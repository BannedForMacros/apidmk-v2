package DbPeru.Posm.Controller;

import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Service.UnidadMedidaService;
import DbPeru.Posm.Solicitudes.RequestUnidadMedida;
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
   tags = {"UNIDAD MEDIDA"}
)
@SwaggerDefinition(
   tags = {@Tag(
   name = "tipo",
   description = "Lista"
)}
)
@Controller
public class UnidadMedidaController {
   @Autowired
   private UnidadMedidaService SUnidadMedida;

   @ApiOperation("Listar Unidades de Medida Posm")
   @RequestMapping(
      value = {"/UnidadMedida/listaUniMedDMK"},
      method = {RequestMethod.GET}
   )
   @ResponseBody
   public List ListaUnidadesMedidaDmk() {
      return this.SUnidadMedida.ListaUnidadMedida();
   }

   @ApiOperation("Guardar Unidad desde DMK")
   @RequestMapping(
      value = {"/UnidadMedida/InsUpdUnidad"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseDMK InsUpdUnidad(@RequestBody RequestUnidadMedida unidad) {
      return this.SUnidadMedida.InsUnidadMedida(unidad);
   }

   @ApiOperation("Guardar Unidades desde DMK")
   @RequestMapping(
      value = {"/UnidadMedida/InsUpdUnidades"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseDMK InsUpdUnidades(@RequestBody List unidads) {
      return this.SUnidadMedida.InsUnidadMedidas(unidads);
   }
}
