package DbPeru.Posm.Respuesta;

import java.math.BigDecimal;
import java.util.List;

public class ResponseVenta {
   private String numSerie;
   private String numDocumento;
   private String tipoDocumento;
   private String fechaEmision;
   private String horaEmision;
   private BigDecimal totalGravadas;
   private BigDecimal totalInafectos;
   private BigDecimal totalExonerados;
   private BigDecimal totalIgv;
   private BigDecimal totalDescuento;
   private BigDecimal totalVenta;
   private int tipoDocumentoCli;
   private String razonSocialCli;
   private String numeroDocumentoCli;
   private String direccionCli;
   private String correoCli;
   private String codigoTerminal;
   private int numeroItems;
   private String codigoSucursal;
   private String tipoCambio;
   private String codigoHash;
   private String numSerieRef;
   private String numDocumentoRef;
   private String tipoDocumentoRef;
   private int codigoMotivoNc;
   private String sustentoNc;
   private String codAlmacen;
   private List ResponseVentaDetalle;
   private List ResponseVentaFormapago;

   public String getCodigoTerminal() {
      return this.codigoTerminal;
   }

   public void setCodigoTerminal(String codigoTerminal) {
      this.codigoTerminal = codigoTerminal;
   }

   public String getCodAlmacen() {
      return this.codAlmacen;
   }

   public void setCodAlmacen(String codAlmacen) {
      this.codAlmacen = codAlmacen;
   }

   public String getNumSerie() {
      return this.numSerie;
   }

   public void setNumSerie(String numSerie) {
      this.numSerie = numSerie;
   }

   public String getNumDocumento() {
      return this.numDocumento;
   }

   public void setNumDocumento(String numDocumento) {
      this.numDocumento = numDocumento;
   }

   public String getTipoDocumento() {
      return this.tipoDocumento;
   }

   public void setTipoDocumento(String tipoDocumento) {
      this.tipoDocumento = tipoDocumento;
   }

   public String getFechaEmision() {
      return this.fechaEmision;
   }

   public void setFechaEmision(String fechaEmision) {
      this.fechaEmision = fechaEmision;
   }

   public String getHoraEmision() {
      return this.horaEmision;
   }

   public void setHoraEmision(String horaEmision) {
      this.horaEmision = horaEmision;
   }

   public BigDecimal getTotalGravadas() {
      return this.totalGravadas;
   }

   public void setTotalGravadas(BigDecimal totalGravadas) {
      this.totalGravadas = totalGravadas;
   }

   public BigDecimal getTotalInafectos() {
      return this.totalInafectos;
   }

   public void setTotalInafectos(BigDecimal totalInafectos) {
      this.totalInafectos = totalInafectos;
   }

   public BigDecimal getTotalExonerados() {
      return this.totalExonerados;
   }

   public void setTotalExonerados(BigDecimal totalExonerados) {
      this.totalExonerados = totalExonerados;
   }

   public BigDecimal getTotalIgv() {
      return this.totalIgv;
   }

   public void setTotalIgv(BigDecimal totalIgv) {
      this.totalIgv = totalIgv;
   }

   public BigDecimal getTotalDescuento() {
      return this.totalDescuento;
   }

   public void setTotalDescuento(BigDecimal totalDescuento) {
      this.totalDescuento = totalDescuento;
   }

   public BigDecimal getTotalVenta() {
      return this.totalVenta;
   }

   public void setTotalVenta(BigDecimal totalVenta) {
      this.totalVenta = totalVenta;
   }

   public int getTipoDocumentoCli() {
      return this.tipoDocumentoCli;
   }

   public void setTipoDocumentoCli(int tipoDocumentoCli) {
      this.tipoDocumentoCli = tipoDocumentoCli;
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

   public int getNumeroItems() {
      return this.numeroItems;
   }

   public void setNumeroItems(int numeroItems) {
      this.numeroItems = numeroItems;
   }

   public String getCodigoSucursal() {
      return this.codigoSucursal;
   }

   public void setCodigoSucursal(String codigoSucursal) {
      this.codigoSucursal = codigoSucursal;
   }

   public String getTipoCambio() {
      return this.tipoCambio;
   }

   public void setTipoCambio(String tipoCambio) {
      this.tipoCambio = tipoCambio;
   }

   public String getCodigoHash() {
      return this.codigoHash;
   }

   public void setCodigoHash(String codigoHash) {
      this.codigoHash = codigoHash;
   }

   public String getNumSerieRef() {
      return this.numSerieRef;
   }

   public void setNumSerieRef(String numSerieRef) {
      this.numSerieRef = numSerieRef;
   }

   public String getNumDocumentoRef() {
      return this.numDocumentoRef;
   }

   public void setNumDocumentoRef(String numDocumentoRef) {
      this.numDocumentoRef = numDocumentoRef;
   }

   public String getTipoDocumentoRef() {
      return this.tipoDocumentoRef;
   }

   public void setTipoDocumentoRef(String tipoDocumentoRef) {
      this.tipoDocumentoRef = tipoDocumentoRef;
   }

   public int getCodigoMotivoNc() {
      return this.codigoMotivoNc;
   }

   public void setCodigoMotivoNc(int codigoMotivoNc) {
      this.codigoMotivoNc = codigoMotivoNc;
   }

   public String getSustentoNc() {
      return this.sustentoNc;
   }

   public void setSustentoNc(String sustentoNc) {
      this.sustentoNc = sustentoNc;
   }

   public List getResponseVentaDetalle() {
      return this.ResponseVentaDetalle;
   }

   public void setResponseVentaDetalle(List responseVentaDetalle) {
      this.ResponseVentaDetalle = responseVentaDetalle;
   }

   public List getResponseVentaFormapago() {
      return this.ResponseVentaFormapago;
   }

   public void setResponseVentaFormapago(List responseVentaFormapago) {
      this.ResponseVentaFormapago = responseVentaFormapago;
   }
}
