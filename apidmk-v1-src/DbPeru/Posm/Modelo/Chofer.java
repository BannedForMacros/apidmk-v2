package DbPeru.Posm.Modelo;

public class Chofer {
   String BreveteChofer;
   String NombreChofer;
   String DniChofer;
   String Telefono;
   String Estado;

   public String getBreveteChofer() {
      return this.BreveteChofer;
   }

   public void setBreveteChofer(String breveteChofer) {
      this.BreveteChofer = breveteChofer;
   }

   public String getNombreChofer() {
      return this.NombreChofer;
   }

   public void setNombreChofer(String nombreChofer) {
      this.NombreChofer = nombreChofer;
   }

   public String getDniChofer() {
      return this.DniChofer;
   }

   public void setDniChofer(String dniChofer) {
      this.DniChofer = dniChofer;
   }

   public String getTelefono() {
      return this.Telefono;
   }

   public void setTelefono(String telefono) {
      this.Telefono = telefono;
   }

   public String getEstado() {
      return this.Estado;
   }

   public void setEstado(String estado) {
      this.Estado = estado;
   }
}
