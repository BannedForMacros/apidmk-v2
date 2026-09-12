package DbPeru.Posm.Modelo;

import java.math.BigDecimal;

public class Ventasdetalle {
   private int idVentasd;
   private String codArticulo;
   private String codUnidadm;
   private BigDecimal cantVentasd;
   private BigDecimal puniVentasd;
   private BigDecimal impuVentasd;
   private BigDecimal tnetoVentasd;
   private BigDecimal tdescVentasd;
   private BigDecimal timpVentasd;
   private int tipIgv;
   private BigDecimal tasaImp;
   private BigDecimal tdescPorcVentasd;
   private String unidadMedida;
   private String codigoSunat;
   private BigDecimal montoIcbper;

   public BigDecimal getMontoIcbper() {
      return this.montoIcbper;
   }

   public void setMontoIcbper(BigDecimal montoIcbper) {
      this.montoIcbper = montoIcbper;
   }

   public String getUnidadMedida() {
      return this.unidadMedida;
   }

   public void setUnidadMedida(String unidadMedida) {
      this.unidadMedida = unidadMedida;
   }

   public String getCodigoSunat() {
      return this.codigoSunat;
   }

   public void setCodigoSunat(String codigoSunat) {
      this.codigoSunat = codigoSunat;
   }

   public BigDecimal getCantVentasd() {
      return this.cantVentasd;
   }

   public void setCantVentasd(BigDecimal cantVentasd) {
      this.cantVentasd = cantVentasd;
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

   public int getIdVentasd() {
      return this.idVentasd;
   }

   public void setIdVentasd(int idVentasd) {
      this.idVentasd = idVentasd;
   }

   public BigDecimal getImpuVentasd() {
      return this.impuVentasd;
   }

   public void setImpuVentasd(BigDecimal impuVentasd) {
      this.impuVentasd = impuVentasd;
   }

   public BigDecimal getPuniVentasd() {
      return this.puniVentasd;
   }

   public void setPuniVentasd(BigDecimal puniVentasd) {
      this.puniVentasd = puniVentasd;
   }

   public BigDecimal getTasaImp() {
      return this.tasaImp;
   }

   public void setTasaImp(BigDecimal tasaImp) {
      this.tasaImp = tasaImp;
   }

   public BigDecimal getTdescPorcVentasd() {
      return this.tdescPorcVentasd;
   }

   public void setTdescPorcVentasd(BigDecimal tdescPorcVentasd) {
      this.tdescPorcVentasd = tdescPorcVentasd;
   }

   public BigDecimal getTdescVentasd() {
      return this.tdescVentasd;
   }

   public void setTdescVentasd(BigDecimal tdescVentasd) {
      this.tdescVentasd = tdescVentasd;
   }

   public BigDecimal getTimpVentasd() {
      return this.timpVentasd;
   }

   public void setTimpVentasd(BigDecimal timpVentasd) {
      this.timpVentasd = timpVentasd;
   }

   public int getTipIgv() {
      return this.tipIgv;
   }

   public void setTipIgv(int tipIgv) {
      this.tipIgv = tipIgv;
   }

   public BigDecimal getTnetoVentasd() {
      return this.tnetoVentasd;
   }

   public void setTnetoVentasd(BigDecimal tnetoVentasd) {
      this.tnetoVentasd = tnetoVentasd;
   }
}
