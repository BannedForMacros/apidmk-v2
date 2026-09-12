package DbPeru.Posm.Modelo;

import java.math.BigDecimal;

public class TmpDetalleventa {
   private BigDecimal cantidad;
   private String codarticulo;
   private String codunimed;
   private String descriarti;
   private String descriunid;
   private BigDecimal descuento;
   private BigDecimal descuentoporcentaje;
   private BigDecimal imptotal;
   private BigDecimal impuventa;
   private BigDecimal precio;
   private int seleccionado;
   private BigDecimal tasaimpu;
   private int tipIgv;

   public BigDecimal getCantidad() {
      return this.cantidad;
   }

   public void setCantidad(BigDecimal cantidad) {
      this.cantidad = cantidad;
   }

   public String getCodarticulo() {
      return this.codarticulo;
   }

   public void setCodarticulo(String codarticulo) {
      this.codarticulo = codarticulo;
   }

   public String getCodunimed() {
      return this.codunimed;
   }

   public void setCodunimed(String codunimed) {
      this.codunimed = codunimed;
   }

   public String getDescriarti() {
      return this.descriarti;
   }

   public void setDescriarti(String descriarti) {
      this.descriarti = descriarti;
   }

   public String getDescriunid() {
      return this.descriunid;
   }

   public void setDescriunid(String descriunid) {
      this.descriunid = descriunid;
   }

   public BigDecimal getDescuento() {
      return this.descuento;
   }

   public void setDescuento(BigDecimal descuento) {
      this.descuento = descuento;
   }

   public BigDecimal getDescuentoporcentaje() {
      return this.descuentoporcentaje;
   }

   public void setDescuentoporcentaje(BigDecimal descuentoporcentaje) {
      this.descuentoporcentaje = descuentoporcentaje;
   }

   public BigDecimal getImptotal() {
      return this.imptotal;
   }

   public void setImptotal(BigDecimal imptotal) {
      this.imptotal = imptotal;
   }

   public BigDecimal getImpuventa() {
      return this.impuventa;
   }

   public void setImpuventa(BigDecimal impuventa) {
      this.impuventa = impuventa;
   }

   public BigDecimal getPrecio() {
      return this.precio;
   }

   public void setPrecio(BigDecimal precio) {
      this.precio = precio;
   }

   public int getSeleccionado() {
      return this.seleccionado;
   }

   public void setSeleccionado(int seleccionado) {
      this.seleccionado = seleccionado;
   }

   public BigDecimal getTasaimpu() {
      return this.tasaimpu;
   }

   public void setTasaimpu(BigDecimal tasaimpu) {
      this.tasaimpu = tasaimpu;
   }

   public int getTipIgv() {
      return this.tipIgv;
   }

   public void setTipIgv(int tipIgv) {
      this.tipIgv = tipIgv;
   }
}
