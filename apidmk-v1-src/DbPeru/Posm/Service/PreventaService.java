package DbPeru.Posm.Service;

import DbPeru.Posm.BaseDatos.Implementacion.MSSQL.PreventaMSSQL;
import DbPeru.Posm.Interfaces.IPreventa;
import DbPeru.Posm.Modelo.Preventa;
import DbPeru.Posm.Respuesta.Response;
import DbPeru.Posm.Respuesta.ResponsePreventaDMK;
import DbPeru.Posm.Solicitudes.RequestPreventaDMK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreventaService implements IPreventa {
   @Autowired
   private PreventaMSSQL DaoPreventa;

   public Response InsertarPreventa(Preventa preventa) {
      return this.DaoPreventa.InsertarPreventa(preventa);
   }

   public ResponsePreventaDMK ListaPreventaNumero(RequestPreventaDMK preventa) {
      return this.DaoPreventa.ListaPreventaNumero(preventa);
   }
}
