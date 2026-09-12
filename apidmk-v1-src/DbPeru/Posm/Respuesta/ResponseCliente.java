package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.DatosCliente;
import java.util.List;

public class ResponseCliente extends ResponseGREDMK {
   List Cliente;

   public List getCliente() {
      return this.Cliente;
   }

   public void setCliente(List cliente) {
      this.Cliente = cliente;
   }
}
