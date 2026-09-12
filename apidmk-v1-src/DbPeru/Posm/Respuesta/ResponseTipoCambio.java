package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.DatosRespTipoCambio;
import java.util.List;

public class ResponseTipoCambio extends ResponseGREDMK {
   List TipoCambio;

   public List getTipoCambio() {
      return this.TipoCambio;
   }

   public void setTipoCambio(List tipoCambio) {
      this.TipoCambio = tipoCambio;
   }
}
