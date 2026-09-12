package DbPeru.Posm.Respuesta;

import DbPeru.Posm.Modelo.ListaPrecio;
import java.util.List;

public class ResponseListaPrecio extends ResponseGREDMK {
   List ListasPrecio;

   public List getListasPrecio() {
      return this.ListasPrecio;
   }

   public void setListasPrecio(List listasPrecio) {
      this.ListasPrecio = listasPrecio;
   }
}
