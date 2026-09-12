package DbPeru.Posm.Interfaces;

import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Solicitudes.RequestUnidadMedida;
import java.util.List;

public interface IUnidadMedida {
   List ListaUnidadMedida();

   ResponseDMK InsUnidadMedida(RequestUnidadMedida var1);

   ResponseDMK InsUnidadMedidas(List var1);
}
