package DbPeru.Posm.Controller;

import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Service.FamiliaService;
import DbPeru.Posm.Solicitudes.RequestFamilia;
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
   tags = {"FAMILIA "}
)
@SwaggerDefinition(
   tags = {@Tag(
   name = "tipo",
   description = "Lista"
)}
)
@Controller
public class FamiliaController {
   @Autowired
   private FamiliaService SFamilia;

   @ApiOperation("Listar Familias")
   @RequestMapping(
      value = {"/Familia/Listafamiliassubf_dmk"},
      method = {RequestMethod.GET}
   )
   @ResponseBody
   public List ListaFamilia() {
      return this.SFamilia.ListaFamilia();
   }

   @ApiOperation("Guardar Familia desde DMK")
   @RequestMapping(
      value = {"/Familia/InsUpdFamilia"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseDMK InsUpdFamilia(@RequestBody RequestFamilia familia) {
      return this.SFamilia.InsUpFamilia(familia);
   }

   @ApiOperation("Guardar Familias desde DMK")
   @RequestMapping(
      value = {"/Familia/InsUpdFamilias"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseDMK InsUpdFamilia(@RequestBody List familias) {
      return this.SFamilia.InsUpdFamilias(familias);
   }
}
