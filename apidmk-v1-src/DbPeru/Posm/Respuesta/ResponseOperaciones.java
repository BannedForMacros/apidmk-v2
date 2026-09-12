package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.Operacion;
import java.util.List;

public class ResponseOperaciones extends ResponseGREDMK {
   List Operaciones;

   public List getOperaciones() {
      return this.Operaciones;
   }

   public void setOperaciones(List operaciones) {
      this.Operaciones = operaciones;
   }
}
