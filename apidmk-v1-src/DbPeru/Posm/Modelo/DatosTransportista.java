package DbPeru.Posm.Modelo;

public class DatosTransportista {
   int codTransportista;
   String NombreTransportista;
   String DireccionTransportista;
   String RucTransportista;
   String TeléfonoTransportista;
   String EmailTransportista;
   String Estado;

   public int getCodTransportista() {
      return this.codTransportista;
   }

   public void setCodTransportista(int codTransportista) {
      this.codTransportista = codTransportista;
   }

   public String getNombreTransportista() {
      return this.NombreTransportista;
   }

   public void setNombreTransportista(String nombreTransportista) {
      this.NombreTransportista = nombreTransportista;
   }

   public String getDireccionTransportista() {
      return this.DireccionTransportista;
   }

   public void setDireccionTransportista(String direccionTransportista) {
      this.DireccionTransportista = direccionTransportista;
   }

   public String getRucTransportista() {
      return this.RucTransportista;
   }

   public void setRucTransportista(String rucTransportista) {
      this.RucTransportista = rucTransportista;
   }

   public String getTeléfonoTransportista() {
      return this.TeléfonoTransportista;
   }

   public void setTeléfonoTransportista(String teléfonoTransportista) {
      this.TeléfonoTransportista = teléfonoTransportista;
   }

   public String getEmailTransportista() {
      return this.EmailTransportista;
   }

   public void setEmailTransportista(String emailTransportista) {
      this.EmailTransportista = emailTransportista;
   }

   public String getEstado() {
      return this.Estado;
   }

   public void setEstado(String estado) {
      this.Estado = estado;
   }
}
