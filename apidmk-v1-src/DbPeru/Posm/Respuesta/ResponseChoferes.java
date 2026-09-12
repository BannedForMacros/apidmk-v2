package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.Chofer;
import java.util.List;

public class ResponseChoferes extends ResponseGREDMK {
   List Choferes;

   public List getChoferes() {
      return this.Choferes;
   }

   public void setChoferes(List choferes) {
      this.Choferes = choferes;
   }
}
