package DbPeru.Posm.Service;

import DbPeru.Posm.BaseDatos.Implementacion.MSSQL.ArticuloMSSQL;
import DbPeru.Posm.BaseDatos.Implementacion.MYSQL.ArticuloMYSQL;
import DbPeru.Posm.Interfaces.IArticulo;
import DbPeru.Posm.Respuesta.ResponseDMK;
import DbPeru.Posm.Respuesta.ResponseStockArticulo;
import DbPeru.Posm.Solicitudes.RequestArticulo;
import DbPeru.Posm.Solicitudes.RequestStockArticulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloService implements IArticulo {
   @Autowired
   private ArticuloMSSQL articuloMSSQL;
   @Autowired
   private ArticuloMYSQL articuloMYSQL;

   public List ListarArticuloDmk() {
      return this.articuloMYSQL.ListarArticuloDmk();
   }

   public List ListarArticuloUndDmk(String listaPrecio, String codalmacen) {
      return this.articuloMYSQL.ListarArticuloUndDmk(listaPrecio, codalmacen);
   }

   public ResponseStockArticulo VerificarStockArticulo(List articulo) {
      return this.articuloMYSQL.VerificarStockArticulo(articulo);
   }

   public ResponseDMK InsArticuloDmk(RequestArticulo articulo) {
      return this.articuloMYSQL.InsArticuloDmk(articulo);
   }

   public ResponseDMK InsArticulosDmk(List articulos) {
      return this.articuloMYSQL.InsArticulosDmk(articulos);
   }
}
