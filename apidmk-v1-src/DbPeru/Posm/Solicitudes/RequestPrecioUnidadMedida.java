package DbPeru.Posm.Solicitudes;

public class RequestPrecioUnidadMedida {
   private int codarticulo;
   private int codunidad;
   private int pordefecto;
   private double preciopublico;
   private String codbarra;
   private double stock;
   private double descuento;

   public int getCodarticulo() {
      return this.codarticulo;
   }

   public void setCodarticulo(int codarticulo) {
      this.codarticulo = codarticulo;
   }

   public int getCodunidad() {
      return this.codunidad;
   }

   public void setCodunidad(int codunidad) {
      this.codunidad = codunidad;
   }

   public int getPordefecto() {
      return this.pordefecto;
   }

   public void setPordefecto(int pordefecto) {
      this.pordefecto = pordefecto;
   }

   public double getPreciopublico() {
      return this.preciopublico;
   }

   public void setPreciopublico(double preciopublico) {
      this.preciopublico = preciopublico;
   }

   public String getCodbarra() {
      return this.codbarra;
   }

   public void setCodbarra(String codbarra) {
      this.codbarra = codbarra;
   }

   public double getStock() {
      return this.stock;
   }

   public void setStock(double stock) {
      this.stock = stock;
   }

   public double getDescuento() {
      return this.descuento;
   }

   public void setDescuento(double descuento) {
      this.descuento = descuento;
   }
}
