package DbPeru.Posm.Service;

import DbPeru.Posm.BaseDatos.Implementacion.MSSQL.UnidadMedidaMSSQL;
import DbPeru.Posm.BaseDatos.Implementacion.MYSQL.UnidadMedidaMYSQL;
import DbPeru.Posm.Interfaces.IUnidadMedida;
import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Solicitudes.RequestUnidadMedida;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaService implements IUnidadMedida {
   @Autowired
   private UnidadMedidaMSSQL sql;
   @Autowired
   private UnidadMedidaMYSQL mysql;

   public List ListaUnidadMedida() {
      return this.mysql.ListaUnidadMedida();
   }

   public ResponseDMK InsUnidadMedida(RequestUnidadMedida unidadMedida) {
      return this.mysql.InsUnidadMedida(unidadMedida);
   }

   public ResponseDMK InsUnidadMedidas(List unidadMedidas) {
      return this.mysql.InsUnidadMedidas(unidadMedidas);
   }
}
