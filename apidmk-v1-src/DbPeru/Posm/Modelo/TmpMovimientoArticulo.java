package DbPeru.Posm.Modelo;

import java.math.BigDecimal;

public class TmpMovimientoArticulo {
   private BigDecimal cantIngreso;
   private String codArticulo;
   private String codUnidadm;
   private String fecReg;

   public BigDecimal getCantIngreso() {
      return this.cantIngreso;
   }

   public void setCantIngreso(BigDecimal cantIngreso) {
      this.cantIngreso = cantIngreso;
   }

   public String getCodArticulo() {
      return this.codArticulo;
   }

   public void setCodArticulo(String codArticulo) {
      this.codArticulo = codArticulo;
   }

   public String getCodUnidadm() {
      return this.codUnidadm;
   }

   public void setCodUnidadm(String codUnidadm) {
      this.codUnidadm = codUnidadm;
   }

   public String getFecReg() {
      return this.fecReg;
   }

   public void setFecReg(String fecReg) {
      this.fecReg = fecReg;
   }
}
