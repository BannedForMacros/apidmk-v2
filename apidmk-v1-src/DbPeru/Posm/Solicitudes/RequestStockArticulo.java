package DbPeru.Posm.Solicitudes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestStockArticulo {
   String CodArticulo;
   Integer CodUnidad;
   Integer CodAlmacen;
   Double Cantidad;
   Integer Estado;

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

   @JsonProperty("codunidad")
   public Integer getCodUnidad() {
      return this.CodUnidad;
   }

   public void setCodUnidad(Integer codUnidad) {
      this.CodUnidad = codUnidad;
   }

   @JsonProperty("codalmacen")
   public Integer getCodAlmacen() {
      return this.CodAlmacen;
   }

   public void setCodAlmacen(Integer codAlmacen) {
      this.CodAlmacen = codAlmacen;
   }

   @JsonProperty("cantidad")
   public Double getCantidad() {
      return this.Cantidad;
   }

   public void setCantidad(Double cantidad) {
      this.Cantidad = cantidad;
   }
}
