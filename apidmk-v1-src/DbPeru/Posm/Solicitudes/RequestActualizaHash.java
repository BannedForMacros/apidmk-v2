package DbPeru.Posm.Solicitudes;

public class RequestActualizaHash extends RequestVenta {
   String CodigoHash;
   String Mensaje;

   public String getCodigoHash() {
      return this.CodigoHash;
   }

   public void setCodigoHash(String codigoHash) {
      this.CodigoHash = codigoHash;
   }

   public String getMensaje() {
      return this.Mensaje;
   }

   public void setMensaje(String mensaje) {
      this.Mensaje = mensaje;
   }
}
