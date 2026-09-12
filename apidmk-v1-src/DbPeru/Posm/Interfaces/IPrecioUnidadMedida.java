package DbPeru.Posm.Interfaces;

import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Solicitudes.RequestPrecioUnidadMedida;
import java.util.List;

public interface IPrecioUnidadMedida {
   ResponseDMK InsPrecioUnidadMedida(RequestPrecioUnidadMedida var1);

   ResponseDMK InsPrecioUnidadMedidas(List var1);
}
