package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.DatosUbigeo;
import java.util.List;

public class ResponseDatosUbigeo extends ResponseGREDMK {
   List Ubigeos;

   public List getUbigeos() {
      return this.Ubigeos;
   }

   public void setUbigeos(List ubigeos) {
      this.Ubigeos = ubigeos;
   }
}
