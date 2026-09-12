package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.DatosSerieNumero;
import java.util.List;

public class ResponseSerieNumero extends ResponseGREDMK {
   List Serienumeros;

   public List getSerienumeros() {
      return this.Serienumeros;
   }

   public void setSerienumeros(List serienumeros) {
      this.Serienumeros = serienumeros;
   }
}
