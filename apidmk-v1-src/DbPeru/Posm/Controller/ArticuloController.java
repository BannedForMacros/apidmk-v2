package DbPeru.Posm.Controller;

import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Respuesta.ResponseStockArticulo;
import DbPeru.Posm.Service.ArticuloService;
import DbPeru.Posm.Solicitudes.RequestArticulo;
import DbPeru.Posm.Solicitudes.RequestStockArticulo;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(
   tags = {"ARTICULO"}
)
@SwaggerDefinition(
   tags = {@Tag(
   name = "tipo",
   description = "Lista"
)}
)
@Controller
public class ArticuloController {
   @Autowired
   private ArticuloService SArticulo;

   @ApiOperation("Listar Articulos Checkout")
   @RequestMapping(
      value = {"/Articulo/listaarticulosdmk"},
      method = {RequestMethod.GET}
   )
   @ResponseBody
   public List ListaArticuloDmk() {
      return this.SArticulo.ListarArticuloDmk();
   }

   @ApiOperation("Listar Articulo con unidades de medida Checkout")
   @RequestMapping(
      value = {"/Articulo/listaarticulosUMdmk"},
      method = {RequestMethod.GET}
   )
   @ResponseBody
   public List lista_UMArticuloDMK(@RequestParam("lp") String listaPrecio, @RequestParam("alm") String codalmacen) {
      return this.SArticulo.ListarArticuloUndDmk(listaPrecio, codalmacen);
   }

   @ApiOperation("Verificar stock Dmk")
   @RequestMapping(
      value = {"/Articulo/VerificarStock"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseStockArticulo VerificarStockArticulo(@RequestBody List articulo) {
      return this.SArticulo.VerificarStockArticulo(articulo);
   }

   @ApiOperation("Registrar Articulo desde DMK")
   @RequestMapping(
      value = {"/Articulo/InsUpdArticulo"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseDMK InsUpdArticulo(@RequestBody RequestArticulo articulo) {
      return this.SArticulo.InsArticuloDmk(articulo);
   }

   @ApiOperation("Registrar Articulos desde DMK")
   @RequestMapping(
      value = {"/Articulo/InsUpdArticulos"},
      method = {RequestMethod.POST}
   )
   @ResponseBody
   public ResponseDMK InsUpdArticulo(@RequestBody List articulo) {
      return this.SArticulo.InsArticulosDmk(articulo);
   }
}
