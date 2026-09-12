package DbPeru.Posm.Interfaces;

import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Respuesta.ResponseStockArticulo;
import DbPeru.Posm.Solicitudes.RequestArticulo;
import java.util.List;

public interface IArticulo {
   List ListarArticuloDmk();

   List ListarArticuloUndDmk(String var1, String var2);

   ResponseStockArticulo VerificarStockArticulo(List var1);

   ResponseDMK InsArticuloDmk(RequestArticulo var1);

   ResponseDMK InsArticulosDmk(List var1);
}
