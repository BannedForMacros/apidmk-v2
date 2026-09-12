package DbPeru.Posm.Modelo;

import java.math.BigDecimal;

public class VentaRequest {
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
   private String codTerminal;

   public String toString() {
      return "VentaRequest{codDocumento=" + this.codDocumento + ", codDocumentoi=" + this.codDocumentoi + ", codigohash=" + this.codigohash + ", docRelaNc=" + this.docRelaNc + ", docRelaVale=" + this.docRelaVale + ", femiVenta=" + this.femiVenta + ", impuVenta=" + this.impuVenta + ", motivoNc=" + this.motivoNc + ", numeVenta=" + this.numeVenta + ", redoVenta=" + this.redoVenta + ", seriVenta=" + this.seriVenta + ", tcambVenta=" + this.tcambVenta + ", texonVenta=" + this.texonVenta + ", tinaVenta=" + this.tinaVenta + ", tipoDocRelaNc=" + this.tipoDocRelaNc + ", tipoNc=" + this.tipoNc + ", tnetoVenta=" + this.tnetoVenta + ", totalVenta=" + this.totalVenta + ", vuelVenta=" + this.vuelVenta + ", rucEmpresa=" + this.rucEmpresa + ", razonSocial=" + this.razonSocial + ", horaEmision=" + this.horaEmision + ", razonSocialCli=" + this.razonSocialCli + ", numeroDocumentoCli=" + this.numeroDocumentoCli + ", direccionCli=" + this.direccionCli + ", correoCli=" + this.correoCli + ", codigoSucursal=" + this.codigoSucursal + ", numeroItems=" + this.numeroItems + ", codAlmacen=" + this.codAlmacen + ", montoIcbper=" + this.montoIcbper + ", codTerminal=" + this.codTerminal + '}';
   }

   public VentaRequest(String codDocumento, String codDocumentoi, String codigohash, String docRelaNc, String docRelaVale, String femiVenta, BigDecimal impuVenta, String motivoNc, String numeVenta, String redoVenta, String seriVenta, BigDecimal tcambVenta, BigDecimal texonVenta, BigDecimal tinaVenta, String tipoDocRelaNc, String tipoNc, BigDecimal tnetoVenta, BigDecimal totalVenta, BigDecimal vuelVenta, String rucEmpresa, String razonSocial, String horaEmision, String razonSocialCli, String numeroDocumentoCli, String direccionCli, String correoCli, String codigoSucursal, String numeroItems, String codAlmacen, BigDecimal montoIcbper, String codTerminal) {
      this.codDocumento = codDocumento;
      this.codDocumentoi = codDocumentoi;
      this.codigohash = codigohash;
      this.docRelaNc = docRelaNc;
      this.docRelaVale = docRelaVale;
      this.femiVenta = femiVenta;
      this.impuVenta = impuVenta;
      this.motivoNc = motivoNc;
      this.numeVenta = numeVenta;
      this.redoVenta = redoVenta;
      this.seriVenta = seriVenta;
      this.tcambVenta = tcambVenta;
      this.texonVenta = texonVenta;
      this.tinaVenta = tinaVenta;
      this.tipoDocRelaNc = tipoDocRelaNc;
      this.tipoNc = tipoNc;
      this.tnetoVenta = tnetoVenta;
      this.totalVenta = totalVenta;
      this.vuelVenta = vuelVenta;
      this.rucEmpresa = rucEmpresa;
      this.razonSocial = razonSocial;
      this.horaEmision = horaEmision;
      this.razonSocialCli = razonSocialCli;
      this.numeroDocumentoCli = numeroDocumentoCli;
      this.direccionCli = direccionCli;
      this.correoCli = correoCli;
      this.codigoSucursal = codigoSucursal;
      this.numeroItems = numeroItems;
      this.codAlmacen = codAlmacen;
      this.montoIcbper = montoIcbper;
      this.codTerminal = codTerminal;
   }

   public VentaRequest(Venta venta) {
      this.codDocumento = venta.getCodDocumento();
      this.codDocumentoi = venta.getCodDocumentoi();
      this.codigohash = venta.getCodigohash();
      this.docRelaNc = venta.getDocRelaNc();
      this.docRelaVale = venta.getDocRelaVale();
      this.femiVenta = venta.getFemiVenta();
      this.impuVenta = venta.getImpuVenta();
      this.motivoNc = venta.getMotivoNc();
      this.numeVenta = venta.getNumeVenta();
      this.redoVenta = venta.getRedoVenta();
      this.seriVenta = venta.getSeriVenta();
      this.tcambVenta = venta.getTcambVenta();
      this.texonVenta = venta.getTexonVenta();
      this.tinaVenta = venta.getTinaVenta();
      this.tipoDocRelaNc = venta.getTipoDocRelaNc();
      this.tipoNc = venta.getTipoNc();
      this.tnetoVenta = venta.getTnetoVenta();
      this.totalVenta = venta.getTotalVenta();
      this.vuelVenta = venta.getVuelVenta();
      this.rucEmpresa = venta.getRucEmpresa();
      this.razonSocial = venta.getRazonSocial();
      this.horaEmision = venta.getHoraEmision();
      this.razonSocialCli = venta.getRazonSocialCli();
      this.numeroDocumentoCli = venta.getNumeroDocumentoCli();
      this.direccionCli = venta.getDireccionCli();
      this.correoCli = venta.getCorreoCli();
      this.codigoSucursal = venta.getCodigoSucursal();
      this.numeroItems = venta.getNumeroItems();
      this.codAlmacen = venta.getCodAlmacen();
      this.montoIcbper = venta.getMontoIcbper();
      this.codTerminal = venta.getCodTerminal();
   }

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
