package DbPeru.Posm.Respuesta;

public class Response {
   String Codigo;
   String Mensaje;
   boolean Exito;

   public String getCodigo() {
      return this.Codigo;
   }

   public void setCodigo(String codigo) {
      this.Codigo = codigo;
   }

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
