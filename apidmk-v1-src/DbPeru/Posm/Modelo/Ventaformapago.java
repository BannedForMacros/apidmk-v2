package DbPeru.Posm.Modelo;

import java.math.BigDecimal;

public class Ventaformapago {
   private String idFpago;
   private int refeFormap;
   private BigDecimal tmontFormap;

   public String getIdFpago() {
      return this.idFpago;
   }

   public void setIdFpago(String idFpago) {
      this.idFpago = idFpago;
   }

   public int getRefeFormap() {
      return this.refeFormap;
   }

   public void setRefeFormap(int refeFormap) {
      this.refeFormap = refeFormap;
   }

   public BigDecimal getTmontFormap() {
      return this.tmontFormap;
   }

   public void setTmontFormap(BigDecimal tmontFormap) {
      this.tmontFormap = tmontFormap;
   }
}
