package DbPeru.Posm.Modelo;

import java.math.BigDecimal;

public class MovimientoArticulo {
   private BigDecimal cantIngreso;
   private String codArticulo;
   private String codUnidadm;
   private String fecReg;
   private int idingreso;
   private BigDecimal stockAnt;
   private BigDecimal stockNue;

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

   public int getIdingreso() {
      return this.idingreso;
   }

   public void setIdingreso(int idingreso) {
      this.idingreso = idingreso;
   }

   public BigDecimal getStockAnt() {
      return this.stockAnt;
   }

   public void setStockAnt(BigDecimal stockAnt) {
      this.stockAnt = stockAnt;
   }

   public BigDecimal getStockNue() {
      return this.stockNue;
   }

   public void setStockNue(BigDecimal stockNue) {
      this.stockNue = stockNue;
   }
}
