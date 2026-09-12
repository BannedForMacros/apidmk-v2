package DbPeru.Posm.Interfaces;

import DbPeru.Posm.Modelo.Preventa;
import DbPeru.Posm.Respuesta.Response;
import DbPeru.Posm.Respuesta.ResponsePreventaDMK;
import DbPeru.Posm.Solicitudes.RequestPreventaDMK;

public interface IPreventa {
   Response InsertarPreventa(Preventa var1);

   ResponsePreventaDMK ListaPreventaNumero(RequestPreventaDMK var1);
}
