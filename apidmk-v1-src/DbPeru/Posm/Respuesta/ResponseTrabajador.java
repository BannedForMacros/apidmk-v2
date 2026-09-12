package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.DatosTrabajador;
import java.util.List;

public class ResponseTrabajador extends ResponseGREDMK {
   List Trabajador;

   public List getTrabajador() {
      return this.Trabajador;
   }

   public void setTrabajador(List trabajador) {
      this.Trabajador = trabajador;
   }
}
