package DbPeru.Posm.Respuesta;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ResponseStockArticulo {
   List ArticuloStock;
   boolean Exito;
   Integer StrStock;

   @JsonProperty("strstock")
   public Integer getStrStock() {
      return this.StrStock;
   }

   public void setStrStock(Integer strStock) {
      this.StrStock = strStock;
   }

   @JsonProperty("articulostock")
   public List getArticuloStock() {
      return this.ArticuloStock;
   }

   public void setArticuloStock(List articuloStock) {
      this.ArticuloStock = articuloStock;
   }

   @JsonProperty("exito")
   public boolean isExito() {
      return this.Exito;
   }

   public void setExito(boolean exito) {
      this.Exito = exito;
   }
}
