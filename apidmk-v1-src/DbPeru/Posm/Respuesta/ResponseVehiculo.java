package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.DatosVehiculo;
import java.util.List;

public class ResponseVehiculo extends ResponseGREDMK {
   List Vehiculos;

   public List getVehiculos() {
      return this.Vehiculos;
   }

   public void setVehiculos(List vehiculos) {
      this.Vehiculos = vehiculos;
   }
}
