package DbPeru.Posm.Respuesta;

import java.math.BigDecimal;

public class ResponseVentaformapago {
   private int codFormaPago;
   private int codTarjeta;
   private BigDecimal importePago;
   private String numTarjeta;

   public int getCodFormaPago() {
      return this.codFormaPago;
   }

   public void setCodFormaPago(int codFormaPago) {
      this.codFormaPago = codFormaPago;
   }

   public int getCodTarjeta() {
      return this.codTarjeta;
   }

   public void setCodTarjeta(int codTarjeta) {
      this.codTarjeta = codTarjeta;
   }

   public BigDecimal getImportePago() {
      return this.importePago;
   }

   public void setImportePago(BigDecimal importePago) {
      this.importePago = importePago;
   }

   public String getNumTarjeta() {
      return this.numTarjeta;
   }

   public void setNumTarjeta(String numTarjeta) {
      this.numTarjeta = numTarjeta;
   }
}
