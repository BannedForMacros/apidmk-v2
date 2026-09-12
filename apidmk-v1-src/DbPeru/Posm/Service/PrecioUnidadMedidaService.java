package DbPeru.Posm.Service;

import DbPeru.Posm.BaseDatos.Implementacion.MYSQL.PrecioUnidadMedidaMYSQL;
import DbPeru.Posm.Interfaces.IPrecioUnidadMedida;
import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Solicitudes.RequestPrecioUnidadMedida;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrecioUnidadMedidaService implements IPrecioUnidadMedida {
   @Autowired
   private PrecioUnidadMedidaMYSQL mysql;

   public ResponseDMK InsPrecioUnidadMedida(RequestPrecioUnidadMedida unidadMedida) {
      return this.mysql.InsPrecioUnidadMedida(unidadMedida);
   }

   public ResponseDMK InsPrecioUnidadMedidas(List unidadMedidas) {
      return this.mysql.InsPrecioUnidadMedidas(unidadMedidas);
   }
}
