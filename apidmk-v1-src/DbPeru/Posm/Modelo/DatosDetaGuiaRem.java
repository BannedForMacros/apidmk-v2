package DbPeru.Posm.Modelo;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DatosDetaGuiaRem {
   int AnioGuiaRemision;
   int NumSerie;
   BigInteger NumeroGuia;
   String TipoGuia;
   int CodArticulo;
   BigDecimal Cantidad;
   BigDecimal Precio;
   int UnidadMedida;
   BigDecimal ImporteDetalle;
   int Item;
   String EstadoProceso;

   public int getAnioGuia() {
      return this.AnioGuiaRemision;
   }

   public void setAnioGuia(int anioGuia) {
      this.AnioGuiaRemision = anioGuia;
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

   public String getTipoGuia() {
      return this.TipoGuia;
   }

   public void setTipoGuia(String tipoGuia) {
      this.TipoGuia = tipoGuia;
   }

   public int getCodArticulo() {
      return this.CodArticulo;
   }

   public void setCodArticulo(int codArticulo) {
      this.CodArticulo = codArticulo;
   }

   public BigDecimal getCantidad() {
      return this.Cantidad;
   }

   public void setCantidad(BigDecimal cantidad) {
      this.Cantidad = cantidad;
   }

   public BigDecimal getPrecio() {
      return this.Precio;
   }

   public void setPrecio(BigDecimal precio) {
      this.Precio = precio;
   }

   public int getUnidadMedida() {
      return this.UnidadMedida;
   }

   public void setUnidadMedida(int unidadMedida) {
      this.UnidadMedida = unidadMedida;
   }

   public BigDecimal getImporteDetalle() {
      return this.ImporteDetalle;
   }

   public void setImporteDetalle(BigDecimal importeDetalle) {
      this.ImporteDetalle = importeDetalle;
   }

   public int getItem() {
      return this.Item;
   }

   public void setItem(int item) {
      this.Item = item;
   }

   public String getEstadoProceso() {
      return this.EstadoProceso;
   }

   public void setEstadoProceso(String estadoProceso) {
      this.EstadoProceso = estadoProceso;
   }
}
