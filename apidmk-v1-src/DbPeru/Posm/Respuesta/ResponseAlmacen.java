package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.DatosAlmacen;
import java.util.List;

public class ResponseAlmacen extends ResponseGREDMK {
   List Almacenes;

   public List getAlmacenes() {
      return this.Almacenes;
   }

   public void setAlmacenes(List almacenes) {
      this.Almacenes = almacenes;
   }
}
