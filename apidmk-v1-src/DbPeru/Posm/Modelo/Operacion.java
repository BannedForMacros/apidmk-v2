package DbPeru.Posm.Modelo;

public class Operacion {
   int TipoOperacion;
   String Descripcion;
   String IngresoSalida;
   String CodigoSunat;
   String Motivotraslado;
   String DescriMotivotraslado;

   public String getDescriMotivotraslado() {
      return this.DescriMotivotraslado;
   }

   public void setDescriMotivotraslado(String descriMotivotraslado) {
      this.DescriMotivotraslado = descriMotivotraslado;
   }

   public int getTipoOperacion() {
      return this.TipoOperacion;
   }

   public void setTipoOperacion(int tipoOperacion) {
      this.TipoOperacion = tipoOperacion;
   }

   public String getDescripcion() {
      return this.Descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.Descripcion = descripcion;
   }

   public String getIngresoSalida() {
      return this.IngresoSalida;
   }

   public void setIngresoSalida(String ingresoSalida) {
      this.IngresoSalida = ingresoSalida;
   }

   public String getCodigoSunat() {
      return this.CodigoSunat;
   }

   public void setCodigoSunat(String codigoSunat) {
      this.CodigoSunat = codigoSunat;
   }

   public String getMotivotraslado() {
      return this.Motivotraslado;
   }

   public void setMotivotraslado(String motivotraslado) {
      this.Motivotraslado = motivotraslado;
   }
}
