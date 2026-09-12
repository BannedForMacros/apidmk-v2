package DbPeru.Posm.Respuesta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseStock {
   String CodArticulo;
   Double Stock;
   Double StockSolicitado;
   Integer Estado;
   String NombreArticulo;

   @JsonProperty("nombrearticulo")
   public String getNombreArticulo() {
      return this.NombreArticulo;
   }

   public void setNombreArticulo(String nombreArticulo) {
      this.NombreArticulo = nombreArticulo;
   }

   @JsonProperty("stock")
   public Double getStock() {
      return this.Stock;
   }

   public void setStock(Double stock) {
      this.Stock = stock;
   }

   @JsonProperty("stocksolicitado")
   public Double getStockSolicitado() {
      return this.StockSolicitado;
   }

   public void setStockSolicitado(Double stockSolicitado) {
      this.StockSolicitado = stockSolicitado;
   }

   @JsonProperty("estado")
   public Integer getEstado() {
      return this.Estado;
   }

   public void setEstado(Integer estado) {
      this.Estado = estado;
   }

   @JsonProperty("codarticulo")
   public String getCodArticulo() {
      return this.CodArticulo;
   }

   public void setCodArticulo(String codArticulo) {
      this.CodArticulo = codArticulo;
   }
}
