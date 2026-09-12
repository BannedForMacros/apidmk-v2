package DbPeru.Posm.Modelo;

public class PreventaDetalle {
   public int tipoDocumento;
   public int numSerie;
   public int numDocumento;
   public int correlativo;
   public Double cantidad;
   public int codUnidad;
   public Double precioUnitario;
   public Double valorNeto;
   public Double importeDescuento;
   public Double valorVenta;
   public Double igv;
   public Double importeTotal;
   public int codArticulo;
   public String tipoMoneda;
   public String estado;
   public String usuarioCreador;
   public String codBarra;
   public int codAlmacen;

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

   public int getCorrelativo() {
      return this.correlativo;
   }

   public void setCorrelativo(int correlativo) {
      this.correlativo = correlativo;
   }

   public Double getCantidad() {
      return this.cantidad;
   }

   public void setCantidad(Double cantidad) {
      this.cantidad = cantidad;
   }

   public int getCodUnidad() {
      return this.codUnidad;
   }

   public void setCodUnidad(int codUnidad) {
      this.codUnidad = codUnidad;
   }

   public Double getPrecioUnitario() {
      return this.precioUnitario;
   }

   public void setPrecioUnitario(Double precioUnitario) {
      this.precioUnitario = precioUnitario;
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

   public int getCodArticulo() {
      return this.codArticulo;
   }

   public void setCodArticulo(int codArticulo) {
      this.codArticulo = codArticulo;
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

   public String getUsuarioCreador() {
      return this.usuarioCreador;
   }

   public void setUsuarioCreador(String usuarioCreador) {
      this.usuarioCreador = usuarioCreador;
   }

   public String getCodBarra() {
      return this.codBarra;
   }

   public void setCodBarra(String codBarra) {
      this.codBarra = codBarra;
   }

   public int getCodAlmacen() {
      return this.codAlmacen;
   }

   public void setCodAlmacen(int codAlmacen) {
      this.codAlmacen = codAlmacen;
   }
}
