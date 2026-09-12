package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.DatosRespArticulo;
import java.util.List;

public class ResponseArticulo extends ResponseGREDMK {
   List Articulos;

   public List getArticulos() {
      return this.Articulos;
   }

   public void setArticulos(List articulos) {
      this.Articulos = articulos;
   }
}
