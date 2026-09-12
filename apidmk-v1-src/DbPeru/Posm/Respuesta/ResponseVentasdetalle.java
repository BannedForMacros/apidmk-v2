package DbPeru.Posm.Respuesta;

import java.math.BigDecimal;

public class ResponseVentasdetalle {
   private int item;
   private String codArticulo;
   private String codUnidadMedida;
   private String unidadMedida;
   private BigDecimal cantidad;
   private BigDecimal precio;
   private BigDecimal total;
   private String codigoSunat;
   private int tipoIgv;
   private int tipoAfectacion;
   private BigDecimal montoDescuento;
   private BigDecimal montoDescuentoPorcentaje;
   private BigDecimal igv;

   public String getCodArticulo() {
      return this.codArticulo;
   }

   public void setCodArticulo(String codArticulo) {
      this.codArticulo = codArticulo;
   }

   public int getItem() {
      return this.item;
   }

   public void setItem(int item) {
      this.item = item;
   }

   public String getCodUnidadMedida() {
      return this.codUnidadMedida;
   }

   public void setCodUnidadMedida(String codUnidadMedida) {
      this.codUnidadMedida = codUnidadMedida;
   }

   public String getUnidadMedida() {
      return this.unidadMedida;
   }

   public void setUnidadMedida(String unidadMedida) {
      this.unidadMedida = unidadMedida;
   }

   public BigDecimal getCantidad() {
      return this.cantidad;
   }

   public void setCantidad(BigDecimal cantidad) {
      this.cantidad = cantidad;
   }

   public BigDecimal getPrecio() {
      return this.precio;
   }

   public void setPrecio(BigDecimal precio) {
      this.precio = precio;
   }

   public BigDecimal getTotal() {
      return this.total;
   }

   public void setTotal(BigDecimal total) {
      this.total = total;
   }

   public String getCodigoSunat() {
      return this.codigoSunat;
   }

   public void setCodigoSunat(String codigoSunat) {
      this.codigoSunat = codigoSunat;
   }

   public int getTipoIgv() {
      return this.tipoIgv;
   }

   public void setTipoIgv(int tipoIgv) {
      this.tipoIgv = tipoIgv;
   }

   public int getTipoAfectacion() {
      return this.tipoAfectacion;
   }

   public void setTipoAfectacion(int tipoAfectacion) {
      this.tipoAfectacion = tipoAfectacion;
   }

   public BigDecimal getMontoDescuento() {
      return this.montoDescuento;
   }

   public void setMontoDescuento(BigDecimal montoDescuento) {
      this.montoDescuento = montoDescuento;
   }

   public BigDecimal getMontoDescuentoPorcentaje() {
      return this.montoDescuentoPorcentaje;
   }

   public void setMontoDescuentoPorcentaje(BigDecimal montoDescuentoPorcentaje) {
      this.montoDescuentoPorcentaje = montoDescuentoPorcentaje;
   }

   public BigDecimal getIgv() {
      return this.igv;
   }

   public void setIgv(BigDecimal igv) {
      this.igv = igv;
   }
}
