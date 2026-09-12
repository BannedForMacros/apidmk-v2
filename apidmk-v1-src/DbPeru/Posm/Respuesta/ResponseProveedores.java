package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.DatosProvedor;
import java.util.List;

public class ResponseProveedores extends ResponseGREDMK {
   List Proveedores;

   public List getProveedores() {
      return this.Proveedores;
   }

   public void setProveedores(List proveedores) {
      this.Proveedores = proveedores;
   }
}
