package DbPeru.Posm.Respuesta;

public class ResponseVentasSinHash {
   String TipoDocumento;
   String SeriVenta;
   String NumeVenta;

   public String getTipoDocumento() {
      return this.TipoDocumento;
   }

   public void setTipoDocumento(String tipoDocumento) {
      this.TipoDocumento = tipoDocumento;
   }

   public String getSeriVenta() {
      return this.SeriVenta;
   }

   public void setSeriVenta(String seriVenta) {
      this.SeriVenta = seriVenta;
   }

   public String getNumeVenta() {
      return this.NumeVenta;
   }

   public void setNumeVenta(String numeVenta) {
      this.NumeVenta = numeVenta;
   }
}
