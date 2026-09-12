package DbPeru.Posm.Modelo;

public class TiposFpago {
   private String codfpago;
   private String descrifpago;
   private int estadoFpago;
   private int fpagoDefault;
   private int usaTcambio;

   public String getCodfpago() {
      return this.codfpago;
   }

   public void setCodfpago(String codfpago) {
      this.codfpago = codfpago;
   }

   public String getDescrifpago() {
      return this.descrifpago;
   }

   public void setDescrifpago(String descrifpago) {
      this.descrifpago = descrifpago;
   }

   public int getEstadoFpago() {
      return this.estadoFpago;
   }

   public void setEstadoFpago(int estadoFpago) {
      this.estadoFpago = estadoFpago;
   }

   public int getFpagoDefault() {
      return this.fpagoDefault;
   }

   public void setFpagoDefault(int fpagoDefault) {
      this.fpagoDefault = fpagoDefault;
   }

   public int getUsaTcambio() {
      return this.usaTcambio;
   }

   public void setUsaTcambio(int usaTcambio) {
      this.usaTcambio = usaTcambio;
   }
}
