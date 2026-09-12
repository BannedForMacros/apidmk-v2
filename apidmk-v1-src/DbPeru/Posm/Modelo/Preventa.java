package DbPeru.Posm.Modelo;

import java.util.List;

public class Preventa {
   public int tipoDocumento;
   public int numSerie;
   public int numDocumento;
   public String fechaEmi;
   public int codEstacion;
   public Double valorNeto;
   public Double importeDescuento;
   public Double valorVenta;
   public Double igv;
   public Double importeTotal;
   public String tipoMoneda;
   public String estado;
   public int codTrabajador;
   public int codVendedor;
   public int codTerminal;
   public String estadoDocumento;
   public int codAlmacen;
   public String comentario;
   public List listaPreventa;

   public List getListaPreventa() {
      return this.listaPreventa;
   }

   public void setListaPreventa(List listaPreventa) {
      this.listaPreventa = listaPreventa;
   }

   public int getTipoDocumento() {
      return this.tipoDocumento;
   }

   public void setTipoDocumento(int tipoDocumento) {
      this.tipoDocumento = tipoDocumento;
   }

   public int getNumSerie() {
      return this.numSerie;
   }

   public void setNumSerie(int numSerie) {
      this.numSerie = numSerie;
   }

   public int getNumDocumento() {
      return this.numDocumento;
   }

   public void setNumDocumento(int numDocumento) {
      this.numDocumento = numDocumento;
   }

   public String getFechaEmi() {
      return this.fechaEmi;
   }

   public void setFechaEmi(String fechaEmi) {
      this.fechaEmi = fechaEmi;
   }

   public int getCodEstacion() {
      return this.codEstacion;
   }

   public void setCodEstacion(int codEstacion) {
      this.codEstacion = codEstacion;
   }

   public Double getValorNeto() {
      return this.valorNeto;
   }

   public void setValorNeto(Double valorNeto) {
      this.valorNeto = valorNeto;
   }

   public Double getImporteDescuento() {
      return this.importeDescuento;
   }

   public void setImporteDescuento(Double importeDescuento) {
      this.importeDescuento = importeDescuento;
   }

   public Double getValorVenta() {
      return this.valorVenta;
   }

   public void setValorVenta(Double valorVenta) {
      this.valorVenta = valorVenta;
   }

   public Double getIgv() {
      return this.igv;
   }

   public void setIgv(Double igv) {
      this.igv = igv;
   }

   public Double getImporteTotal() {
      return this.importeTotal;
   }

   public void setImporteTotal(Double importeTotal) {
      this.importeTotal = importeTotal;
   }

   public String getTipoMoneda() {
      return this.tipoMoneda;
   }

   public void setTipoMoneda(String tipoMoneda) {
      this.tipoMoneda = tipoMoneda;
   }

   public String getEstado() {
      return this.estado;
   }

   public void setEstado(String estado) {
      this.estado = estado;
   }

   public int getCodTrabajador() {
      return this.codTrabajador;
   }

   public void setCodTrabajador(int codTrabajador) {
      this.codTrabajador = codTrabajador;
   }

   public int getCodVendedor() {
      return this.codVendedor;
   }

   public void setCodVendedor(int codVendedor) {
      this.codVendedor = codVendedor;
   }

   public int getCodTerminal() {
      return this.codTerminal;
   }

   public void setCodTerminal(int codTerminal) {
      this.codTerminal = codTerminal;
   }

   public String getEstadoDocumento() {
      return this.estadoDocumento;
   }

   public void setEstadoDocumento(String estadoDocumento) {
      this.estadoDocumento = estadoDocumento;
   }

   public int getCodAlmacen() {
      return this.codAlmacen;
   }

   public void setCodAlmacen(int codAlmacen) {
      this.codAlmacen = codAlmacen;
   }

   public String getComentario() {
      return this.comentario;
   }

   public void setComentario(String comentario) {
      this.comentario = comentario;
   }
}
