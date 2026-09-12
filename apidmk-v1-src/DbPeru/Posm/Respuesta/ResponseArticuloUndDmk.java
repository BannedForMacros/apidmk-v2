package DbPeru.Posm.Respuesta;

public class ResponseArticuloUndDmk {
   public String codArticulo;
   public String CodUnidadM;
   public Double precio;
   public String cbarArtiUni;
   public Double stock;
   public Double descuento;

   public Double getDescuento() {
      return this.descuento;
   }

   public void setDescuento(Double descuento) {
      this.descuento = descuento;
   }

   public Double getStock() {
      return this.stock;
   }

   public void setStock(Double stock) {
      this.stock = stock;
   }

   public String getCodArticulo() {
      return this.codArticulo;
   }

   public void setCodArticulo(String codArticulo) {
      this.codArticulo = codArticulo;
   }

   public String getCodUnidadM() {
      return this.CodUnidadM;
   }

   public void setCodUnidadM(String codUnidadM) {
      this.CodUnidadM = codUnidadM;
   }

   public Double getPrecio() {
      return this.precio;
   }

   public void setPrecio(Double precio) {
      this.precio = precio;
   }

   public String getCbarArtiUni() {
      return this.cbarArtiUni;
   }

   public void setCbarArtiUni(String cbarArtiUni) {
      this.cbarArtiUni = cbarArtiUni;
   }
}
