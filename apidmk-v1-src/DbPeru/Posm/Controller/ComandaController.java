package DbPeru.Posm.Controller;

import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Service.ArticuloService;
import DbPeru.Posm.Solicitudes.RequestArticulo;
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
   tags = {"Comanda"}
)
@SwaggerDefinition(
   tags = {@Tag(
   name = "tipo",
   description = "Lista"
)}
)
@Controller
public class ComandaController {
   @Autowired
   private ArticuloService SArticulo;

   @ApiOperation("Registrar Comanda hacia DMK")
   @RequestMapping(
      value = {"/Comanda/RegistraComanda"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseDMK InsUpdArticulo(@RequestBody List articulo) {
      return this.SArticulo.InsArticulosDmk(articulo);
   }
}
