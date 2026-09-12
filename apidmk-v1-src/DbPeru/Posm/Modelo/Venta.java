package DbPeru.Posm.Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Venta {
   private String codDocumento;
   private String codDocumentoi;
   private String codigohash;
   private String docRelaNc;
   private String docRelaVale;
   private String femiVenta;
   private BigDecimal impuVenta;
   private String motivoNc;
   private String numeVenta;
   private String redoVenta;
   private String seriVenta;
   private BigDecimal tcambVenta;
   private BigDecimal texonVenta;
   private BigDecimal tinaVenta;
   private String tipoDocRelaNc;
   private String tipoNc;
   private BigDecimal tnetoVenta;
   private BigDecimal totalVenta;
   private BigDecimal vuelVenta;
   private String rucEmpresa;
   private String razonSocial;
   private String horaEmision;
   private String razonSocialCli;
   private String numeroDocumentoCli;
   private String direccionCli;
   private String correoCli;
   private String codigoSucursal;
   private String numeroItems;
   private String codAlmacen;
   private BigDecimal montoIcbper;
   private List Ventaformapago;
   private List Ventasdetalle;
   private String codTerminal;

   public String getCodTerminal() {
      return this.codTerminal;
   }

   public void setCodTerminal(String codTerminal) {
      this.codTerminal = codTerminal;
   }

   public String getCodAlmacen() {
      return this.codAlmacen;
   }

   public void setCodAlmacen(String codAlmacen) {
      this.codAlmacen = codAlmacen;
   }

   public BigDecimal getMontoIcbper() {
      return this.montoIcbper;
   }

   public void setMontoIcbper(BigDecimal montoIcbper) {
      this.montoIcbper = montoIcbper;
   }

   public String getRucEmpresa() {
      return this.rucEmpresa;
   }

   public void setRucEmpresa(String rucEmpresa) {
      this.rucEmpresa = rucEmpresa;
   }

   public String getRazonSocial() {
      return this.razonSocial;
   }

   public void setRazonSocial(String razonSocial) {
      this.razonSocial = razonSocial;
   }

   public String getHoraEmision() {
      return this.horaEmision;
   }

   public void setHoraEmision(String horaEmision) {
      this.horaEmision = horaEmision;
   }

   public String getRazonSocialCli() {
      return this.razonSocialCli;
   }

   public void setRazonSocialCli(String razonSocialCli) {
      this.razonSocialCli = razonSocialCli;
   }

   public String getNumeroDocumentoCli() {
      return this.numeroDocumentoCli;
   }

   public void setNumeroDocumentoCli(String numeroDocumentoCli) {
      this.numeroDocumentoCli = numeroDocumentoCli;
   }

   public String getDireccionCli() {
      return this.direccionCli;
   }

   public void setDireccionCli(String direccionCli) {
      this.direccionCli = direccionCli;
   }

   public String getCorreoCli() {
      return this.correoCli;
   }

   public void setCorreoCli(String correoCli) {
      this.correoCli = correoCli;
   }

   public String getCodigoSucursal() {
      return this.codigoSucursal;
   }

   public void setCodigoSucursal(String codigoSucursal) {
      this.codigoSucursal = codigoSucursal;
   }

   public String getNumeroItems() {
      return this.numeroItems;
   }

   public void setNumeroItems(String numeroItems) {
      this.numeroItems = numeroItems;
   }

   public List getVentaformapago() {
      return this.Ventaformapago;
   }

   public void setVentaformapago(List ventaformapago) {
      this.Ventaformapago = ventaformapago;
   }

   public List getVentasdetalle() {
      return this.Ventasdetalle;
   }

   public void setVentasdetalle(List ventasdetalle) {
      this.Ventasdetalle = ventasdetalle;
   }

   public String getCodDocumento() {
      return this.codDocumento;
   }

   public void setCodDocumento(String codDocumento) {
      this.codDocumento = codDocumento;
   }

   public String getCodDocumentoi() {
      return this.codDocumentoi;
   }

   public void setCodDocumentoi(String codDocumentoi) {
      this.codDocumentoi = codDocumentoi;
   }

   public String getCodigohash() {
      return this.codigohash;
   }

   public void setCodigohash(String codigohash) {
      this.codigohash = codigohash;
   }

   public String getDocRelaNc() {
      return this.docRelaNc;
   }

   public void setDocRelaNc(String docRelaNc) {
      this.docRelaNc = docRelaNc;
   }

   public String getDocRelaVale() {
      return this.docRelaVale;
   }

   public void setDocRelaVale(String docRelaVale) {
      this.docRelaVale = docRelaVale;
   }

   public String getFemiVenta() {
      return this.femiVenta;
   }

   public void setFemiVenta(String femiVenta) {
      this.femiVenta = femiVenta;
   }

   public BigDecimal getImpuVenta() {
      return this.impuVenta;
   }

   public void setImpuVenta(BigDecimal impuVenta) {
      this.impuVenta = impuVenta;
   }

   public String getMotivoNc() {
      return this.motivoNc;
   }

   public void setMotivoNc(String motivoNc) {
      this.motivoNc = motivoNc;
   }

   public String getNumeVenta() {
      return this.numeVenta;
   }

   public void setNumeVenta(String numeVenta) {
      this.numeVenta = numeVenta;
   }

   public String getRedoVenta() {
      return this.redoVenta;
   }

   public void setRedoVenta(String redoVenta) {
      this.redoVenta = redoVenta;
   }

   public String getSeriVenta() {
      return this.seriVenta;
   }

   public void setSeriVenta(String seriVenta) {
      this.seriVenta = seriVenta;
   }

   public BigDecimal getTcambVenta() {
      return this.tcambVenta;
   }

   public void setTcambVenta(BigDecimal tcambVenta) {
      this.tcambVenta = tcambVenta;
   }

   public BigDecimal getTexonVenta() {
      return this.texonVenta;
   }

   public void setTexonVenta(BigDecimal texonVenta) {
      this.texonVenta = texonVenta;
   }

   public BigDecimal getTinaVenta() {
      return this.tinaVenta;
   }

   public void setTinaVenta(BigDecimal tinaVenta) {
      this.tinaVenta = tinaVenta;
   }

   public String getTipoDocRelaNc() {
      return this.tipoDocRelaNc;
   }

   public void setTipoDocRelaNc(String tipoDocRelaNc) {
      this.tipoDocRelaNc = tipoDocRelaNc;
   }

   public String getTipoNc() {
      return this.tipoNc;
   }

   public void setTipoNc(String tipoNc) {
      this.tipoNc = tipoNc;
   }

   public BigDecimal getTnetoVenta() {
      return this.tnetoVenta;
   }

   public void setTnetoVenta(BigDecimal tnetoVenta) {
      this.tnetoVenta = tnetoVenta;
   }

   public BigDecimal getTotalVenta() {
      return this.totalVenta;
   }

   public void setTotalVenta(BigDecimal totalVenta) {
      this.totalVenta = totalVenta;
   }

   public BigDecimal getVuelVenta() {
      return this.vuelVenta;
   }

   public void setVuelVenta(BigDecimal vuelVenta) {
      this.vuelVenta = vuelVenta;
   }
}
