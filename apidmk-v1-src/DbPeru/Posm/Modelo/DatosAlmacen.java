package DbPeru.Posm.Modelo;

public class DatosAlmacen {
   int CodAlmacen;
   String Descripcion;
   int CodEstacion;
   String Estado;
   String CodigoLap;
   String CodInterno;
   boolean EstadoProduccion;
   boolean Kardex;

   public int getCodAlmacen() {
      return this.CodAlmacen;
   }

   public void setCodAlmacen(int codAlmacen) {
      this.CodAlmacen = codAlmacen;
   }

   public String getDescripcion() {
      return this.Descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.Descripcion = descripcion;
   }

   public int getCodEstacion() {
      return this.CodEstacion;
   }

   public void setCodEstacion(int codEstacion) {
      this.CodEstacion = codEstacion;
   }

   public String getEstado() {
      return this.Estado;
   }

   public void setEstado(String estado) {
      this.Estado = estado;
   }

   public String getCodigoLap() {
      return this.CodigoLap;
   }

   public void setCodigoLap(String codigoLap) {
      this.CodigoLap = codigoLap;
   }

   public String getCodInterno() {
      return this.CodInterno;
   }

   public void setCodInterno(String codInterno) {
      this.CodInterno = codInterno;
   }

   public boolean isEstadoProduccion() {
      return this.EstadoProduccion;
   }

   public void setEstadoProduccion(boolean estadoProduccion) {
      this.EstadoProduccion = estadoProduccion;
   }

   public boolean isKardex() {
      return this.Kardex;
   }

   public void setKardex(boolean kardex) {
      this.Kardex = kardex;
   }
}
