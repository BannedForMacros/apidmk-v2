package DbPeru.Posm.Modelo;

import java.math.BigDecimal;

public class TmpFpago {
   private String codfpag;
   private String descripcion;
   private BigDecimal monto;

   public String getCodfpag() {
      return this.codfpag;
   }

   public void setCodfpag(String codfpag) {
      this.codfpag = codfpag;
   }

   public String getDescripcion() {
      return this.descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   public BigDecimal getMonto() {
      return this.monto;
   }

   public void setMonto(BigDecimal monto) {
      this.monto = monto;
   }
}
