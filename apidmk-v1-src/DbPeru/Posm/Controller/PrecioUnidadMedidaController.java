package DbPeru.Posm.Controller;

import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Service.PrecioUnidadMedidaService;
import DbPeru.Posm.Solicitudes.RequestPrecioUnidadMedida;
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
   tags = {"PRECIO UNIDAD MEDIDA"}
)
@SwaggerDefinition(
   tags = {@Tag(
   name = "tipo",
   description = "Lista"
)}
)
@Controller
public class PrecioUnidadMedidaController {
   @Autowired
   private PrecioUnidadMedidaService SPrecioUnidadMedida;

   @ApiOperation("Guardar Precio desde DMK")
   @RequestMapping(
      value = {"/UnidadMedida/InsUpdPrecioUnidad"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseDMK InsUpdUnidad(@RequestBody RequestPrecioUnidadMedida unidad) {
      return this.SPrecioUnidadMedida.InsPrecioUnidadMedida(unidad);
   }

   @ApiOperation("Guardar Precios desde DMK")
   @RequestMapping(
      value = {"/UnidadMedida/InsUpdPrecioUnidades"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseDMK InsUpdUnidades(@RequestBody List unidads) {
      return this.SPrecioUnidadMedida.InsPrecioUnidadMedidas(unidads);
   }
}
