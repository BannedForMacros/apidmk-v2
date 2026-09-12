package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.DatosFormasPago;
import java.util.List;

public class ResponseFormasPago extends ResponseGREDMK {
   List FormasdePago;

   public List getFormasdePago() {
      return this.FormasdePago;
   }

   public void setFormasdePago(List formasdePago) {
      this.FormasdePago = formasdePago;
   }
}
