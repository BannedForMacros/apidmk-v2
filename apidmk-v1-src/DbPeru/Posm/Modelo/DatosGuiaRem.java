package DbPeru.Posm.Modelo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class DatosGuiaRem {
   int AnioGuiaRemision;
   int NumSerie;
   BigInteger NumeroGuia;
   int CodProveedor;
   int CodCliente;
   String NombreTransportista;
   String RucTransportista;
   String TipoGuia;
   int CodEstacion;
   String FechaEmision;
   int TipoOperacion;
   BigDecimal ValorVenta;
   BigDecimal IGV;
   BigDecimal TotalVenta;
   String Comentario;
   int CodAlmacenOrigen;
   int CodAlmacenDestino;
   int CodAlmacen;
   int CodListaPrecio;
   String EstadoProceso;
   int Seriefactura;
   int NumeroFactura;
   String direccionpartida;
   String direccionllegada;
   String ubigeopartida;
   String ubigeollegada;
   String placavehiculo;
   String BreveteChofer;
   String Nombrechofer;
   String DNIChofer;
   String modalidadTransporte;
   int codtrabajador;
   int tipomonda;
   int formapago;
   BigDecimal descuento;
   List Detalle;

   public int getCodtrabajador() {
      return this.codtrabajador;
   }

   public void setCodtrabajador(int codtrabajador) {
      this.codtrabajador = codtrabajador;
   }

   public int getTipomonda() {
      return this.tipomonda;
   }

   public void setTipomonda(int tipomonda) {
      this.tipomonda = tipomonda;
   }

   public int getFormapago() {
      return this.formapago;
   }

   public void setFormapago(int formapago) {
      this.formapago = formapago;
   }

   public BigDecimal getDescuento() {
      return this.descuento;
   }

   public void setDescuento(BigDecimal descuento) {
      this.descuento = descuento;
   }

   public int getNumSerie() {
      return this.NumSerie;
   }

   public void setNumSerie(int numSerie) {
      this.NumSerie = numSerie;
   }

   public BigInteger getNumeroGuia() {
      return this.NumeroGuia;
   }

   public void setNumeroGuia(BigInteger numeroGuia) {
      this.NumeroGuia = numeroGuia;
   }

   public int getCodProveedor() {
      return this.CodProveedor;
   }

   public void setCodProveedor(int codProveedor) {
      this.CodProveedor = codProveedor;
   }

   public int getCodCliente() {
      return this.CodCliente;
   }

   public void setCodCliente(int codCliente) {
      this.CodCliente = codCliente;
   }

   public String getNombreTransportista() {
      return this.NombreTransportista;
   }

   public void setNombreTransportista(String nombreTransportista) {
      this.NombreTransportista = nombreTransportista;
   }

   public String getRucTransportista() {
      return this.RucTransportista;
   }

   public void setRucTransportista(String rucTransportista) {
      this.RucTransportista = rucTransportista;
   }

   public String getTipoGuia() {
      return this.TipoGuia;
   }

   public void setTipoGuia(String tipoGuia) {
      this.TipoGuia = tipoGuia;
   }

   public int getCodEstacion() {
      return this.CodEstacion;
   }

   public void setCodEstacion(int codEstacion) {
      this.CodEstacion = codEstacion;
   }

   public String getFechaEmision() {
      return this.FechaEmision;
   }

   public void setFechaEmision(String fechaEmision) {
      this.FechaEmision = fechaEmision;
   }

   public int getTipoOperacion() {
      return this.TipoOperacion;
   }

   public void setTipoOperacion(int tipoOperacion) {
      this.TipoOperacion = tipoOperacion;
   }

   public BigDecimal getValorVenta() {
      return this.ValorVenta;
   }

   public void setValorVenta(BigDecimal valorVenta) {
      this.ValorVenta = valorVenta;
   }

   public BigDecimal getIGV() {
      return this.IGV;
   }

   public void setIGV(BigDecimal iGV) {
      this.IGV = iGV;
   }

   public BigDecimal getTotalVenta() {
      return this.TotalVenta;
   }

   public void setTotalVenta(BigDecimal totalVenta) {
      this.TotalVenta = totalVenta;
   }

   public String getComentario() {
      return this.Comentario;
   }

   public void setComentario(String comentario) {
      this.Comentario = comentario;
   }

   public int getCodAlmacenOrigen() {
      return this.CodAlmacenOrigen;
   }

   public void setCodAlmacenOrigen(int codAlmacenOrigen) {
      this.CodAlmacenOrigen = codAlmacenOrigen;
   }

   public int getCodAlmacenDestino() {
      return this.CodAlmacenDestino;
   }

   public void setCodAlmacenDestino(int codAlmacenDestino) {
      this.CodAlmacenDestino = codAlmacenDestino;
   }

   public int getCodAlmacen() {
      return this.CodAlmacen;
   }

   public void setCodAlmacen(int codAlmacen) {
      this.CodAlmacen = codAlmacen;
   }

   public int getCodListaPrecio() {
      return this.CodListaPrecio;
   }

   public void setCodListaPrecio(int codListaPrecio) {
      this.CodListaPrecio = codListaPrecio;
   }

   public String getEstadoProceso() {
      return this.EstadoProceso;
   }

   public void setEstadoProceso(String estadoProceso) {
      this.EstadoProceso = estadoProceso;
   }

   public int getNumeroFactura() {
      return this.NumeroFactura;
   }

   public void setNumeroFactura(int numeroFactura) {
      this.NumeroFactura = numeroFactura;
   }

   public String getBreveteChofer() {
      return this.BreveteChofer;
   }

   public void setBreveteChofer(String breveteChofer) {
      this.BreveteChofer = breveteChofer;
   }

   public int getAnioGuiaRemision() {
      return this.AnioGuiaRemision;
   }

   public void setAnioGuiaRemision(int anioGuiaRemision) {
      this.AnioGuiaRemision = anioGuiaRemision;
   }

   public int getSeriefactura() {
      return this.Seriefactura;
   }

   public void setSeriefactura(int seriefactura) {
      this.Seriefactura = seriefactura;
   }

   public String getDireccionpartida() {
      return this.direccionpartida;
   }

   public void setDireccionpartida(String direccionpartida) {
      this.direccionpartida = direccionpartida;
   }

   public String getDireccionllegada() {
      return this.direccionllegada;
   }

   public void setDireccionllegada(String direccionllegada) {
      this.direccionllegada = direccionllegada;
   }

   public String getUbigeopartida() {
      return this.ubigeopartida;
   }

   public void setUbigeopartida(String ubigeopartida) {
      this.ubigeopartida = ubigeopartida;
   }

   public String getUbigeollegada() {
      return this.ubigeollegada;
   }

   public void setUbigeollegada(String ubigeollegada) {
      this.ubigeollegada = ubigeollegada;
   }

   public String getPlacavehiculo() {
      return this.placavehiculo;
   }

   public void setPlacavehiculo(String placavehiculo) {
      this.placavehiculo = placavehiculo;
   }

   public String getNombrechofer() {
      return this.Nombrechofer;
   }

   public void setNombrechofer(String nombrechofer) {
      this.Nombrechofer = nombrechofer;
   }

   public String getModalidadTransporte() {
      return this.modalidadTransporte;
   }

   public void setModalidadTransporte(String modalidadTransporte) {
      this.modalidadTransporte = modalidadTransporte;
   }

   public String getDNIChofer() {
      return this.DNIChofer;
   }

   public void setDNIChofer(String dNIChofer) {
      this.DNIChofer = dNIChofer;
   }

   public List getDetalle() {
      return this.Detalle;
   }

   public void setDetalle(List detalle) {
      this.Detalle = detalle;
   }
}
