package DbPeru.Posm.Interfaces;

import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Solicitudes.RequestFamilia;
import java.util.List;

public interface IFamilia {
   List ListaFamilia();

   ResponseDMK InsUpFamilia(RequestFamilia var1);

   ResponseDMK InsUpdFamilias(List var1);
}
