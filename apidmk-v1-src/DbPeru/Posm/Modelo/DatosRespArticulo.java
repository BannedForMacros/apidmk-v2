package DbPeru.Posm.Modelo;

import java.math.BigDecimal;

public class DatosRespArticulo {
   int CodArticulo;
   String NombreArticulo;
   int CodEstacion;
   int CodFamilia;
   int CodUnidad;
   int TipoMoneda;
   BigDecimal PrecioPublico;
   BigDecimal PrecioSinIGV;
   BigDecimal CostoArticulo;
   BigDecimal ISC;
   BigDecimal IGV;
   BigDecimal StockMinimo;
   BigDecimal StockMaximo;
   String CodBarra;
   BigDecimal Stock;
   String CodBarraAd;
   int CodSubFamilia;
   String ControlStock;
   String TipoKit;
   String CodArtNue;
   int CodAlmacen;
   String Marca;
   int TipoIgv;

   public int getCodArticulo() {
      return this.CodArticulo;
   }

   public void setCodArticulo(int codArticulo) {
      this.CodArticulo = codArticulo;
   }

   public String getNombreArticulo() {
      return this.NombreArticulo;
   }

   public void setNombreArticulo(String nombreArticulo) {
      this.NombreArticulo = nombreArticulo;
   }

   public int getCodEstacion() {
      return this.CodEstacion;
   }

   public void setCodEstacion(int codEstacion) {
      this.CodEstacion = codEstacion;
   }

   public int getCodFamilia() {
      return this.CodFamilia;
   }

   public void setCodFamilia(int codFamilia) {
      this.CodFamilia = codFamilia;
   }

   public int getCodUnidad() {
      return this.CodUnidad;
   }

   public void setCodUnidad(int codUnidad) {
      this.CodUnidad = codUnidad;
   }

   public int getTipoMoneda() {
      return this.TipoMoneda;
   }

   public void setTipoMoneda(int tipoMoneda) {
      this.TipoMoneda = tipoMoneda;
   }

   public BigDecimal getPrecioPublico() {
      return this.PrecioPublico;
   }

   public void setPrecioPublico(BigDecimal precioPublico) {
      this.PrecioPublico = precioPublico;
   }

   public BigDecimal getPrecioSinIGV() {
      return this.PrecioSinIGV;
   }

   public void setPrecioSinIGV(BigDecimal precioSinIGV) {
      this.PrecioSinIGV = precioSinIGV;
   }

   public BigDecimal getCostoArticulo() {
      return this.CostoArticulo;
   }

   public void setCostoArticulo(BigDecimal costoArticulo) {
      this.CostoArticulo = costoArticulo;
   }

   public BigDecimal getISC() {
      return this.ISC;
   }

   public void setISC(BigDecimal iSC) {
      this.ISC = iSC;
   }

   public BigDecimal getIGV() {
      return this.IGV;
   }

   public void setIGV(BigDecimal iGV) {
      this.IGV = iGV;
   }

   public BigDecimal getStockMinimo() {
      return this.StockMinimo;
   }

   public void setStockMinimo(BigDecimal stockMinimo) {
      this.StockMinimo = stockMinimo;
   }

   public BigDecimal getStockMaximo() {
      return this.StockMaximo;
   }

   public void setStockMaximo(BigDecimal stockMaximo) {
      this.StockMaximo = stockMaximo;
   }

   public String getCodBarra() {
      return this.CodBarra;
   }

   public void setCodBarra(String codBarra) {
      this.CodBarra = codBarra;
   }

   public BigDecimal getStock() {
      return this.Stock;
   }

   public void setStock(BigDecimal stock) {
      this.Stock = stock;
   }

   public String getCodBarraAd() {
      return this.CodBarraAd;
   }

   public void setCodBarraAd(String codBarraAd) {
      this.CodBarraAd = codBarraAd;
   }

   public int getCodSubFamilia() {
      return this.CodSubFamilia;
   }

   public void setCodSubFamilia(int codSubFamilia) {
      this.CodSubFamilia = codSubFamilia;
   }

   public String getControlStock() {
      return this.ControlStock;
   }

   public void setControlStock(String controlStock) {
      this.ControlStock = controlStock;
   }

   public String getTipoKit() {
      return this.TipoKit;
   }

   public void setTipoKit(String tipoKit) {
      this.TipoKit = tipoKit;
   }

   public String getCodArtNue() {
      return this.CodArtNue;
   }

   public void setCodArtNue(String codArtNue) {
      this.CodArtNue = codArtNue;
   }

   public int getCodAlmacen() {
      return this.CodAlmacen;
   }

   public void setCodAlmacen(int codAlmacen) {
      this.CodAlmacen = codAlmacen;
   }

   public String getMarca() {
      return this.Marca;
   }

   public void setMarca(String marca) {
      this.Marca = marca;
   }

   public int getTipoIgv() {
      return this.TipoIgv;
   }

   public void setTipoIgv(int tipoIgv) {
      this.TipoIgv = tipoIgv;
   }
}
