package DbPeru.Posm.Service;

import DbPeru.Posm.BaseDatos.Implementacion.MSSQL.FamiliaMSSQL;
import DbPeru.Posm.BaseDatos.Implementacion.MYSQL.FamiliaMYSQL;
import DbPeru.Posm.Interfaces.IFamilia;
import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Solicitudes.RequestFamilia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliaService implements IFamilia {
   @Autowired
   private FamiliaMSSQL sql;
   @Autowired
   private FamiliaMYSQL mysql;

   public List ListaFamilia() {
      return this.mysql.ListaFamilia();
   }

   public ResponseDMK InsUpFamilia(RequestFamilia familia) {
      return this.mysql.InsUpFamilia(familia);
   }

   public ResponseDMK InsUpdFamilias(List familias) {
      return this.mysql.InsUpdFamilias(familias);
   }
}
