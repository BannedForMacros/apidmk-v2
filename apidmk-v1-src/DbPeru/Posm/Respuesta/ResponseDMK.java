package DbPeru.Posm.Respuesta;

public class ResponseDMK {
   String Mensaje;
   boolean Exito;

   public String getMensaje() {
      return this.Mensaje;
   }

   public void setMensaje(String mensaje) {
      this.Mensaje = mensaje;
   }

   public boolean isExito() {
      return this.Exito;
   }

   public void setExito(boolean exito) {
      this.Exito = exito;
   }
}
