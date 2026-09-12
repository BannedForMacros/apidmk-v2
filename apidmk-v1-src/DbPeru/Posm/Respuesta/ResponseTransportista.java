package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.DatosTransportista;
import java.util.List;

public class ResponseTransportista extends ResponseGREDMK {
   List Transportistas;

   public List getTransportistas() {
      return this.Transportistas;
   }

   public void setTransportistas(List transportistas) {
      this.Transportistas = transportistas;
   }
}
