package DbPeru.Posm.Modelo;

public class DatosTrabajador {
   int CodTrabajador;
   String Apellidos;
   String Nombres;
   String DNI;
   String Cargo;

   public int getCodTrabajador() {
      return this.CodTrabajador;
   }

   public void setCodTrabajador(int codTrabajador) {
      this.CodTrabajador = codTrabajador;
   }

   public String getApellidos() {
      return this.Apellidos;
   }

   public void setApellidos(String apellidos) {
      this.Apellidos = apellidos;
   }

   public String getNombres() {
      return this.Nombres;
   }

   public void setNombres(String nombres) {
      this.Nombres = nombres;
   }

   public String getDNI() {
      return this.DNI;
   }

   public void setDNI(String dNI) {
      this.DNI = dNI;
   }

   public String getCargo() {
      return this.Cargo;
   }

   public void setCargo(String cargo) {
      this.Cargo = cargo;
   }
}
