package DbPeru.Posm.Modelo;

public class DatosCliente {
   String RazonSocial;
   String Nombres;
   String Direccion;
   String CodZip;
   int CodCliente;
   String RucCliente;
   String DNI;
   String Telefono;
   String TipoDocumentoIdentidad;
   String CodPostalEntrega;
   String DireccionEntrega;

   public String getRazonSocial() {
      return this.RazonSocial;
   }

   public void setRazonSocial(String razonSocial) {
      this.RazonSocial = razonSocial;
   }

   public String getNombres() {
      return this.Nombres;
   }

   public void setNombres(String nombres) {
      this.Nombres = nombres;
   }

   public String getDireccion() {
      return this.Direccion;
   }

   public void setDireccion(String direccion) {
      this.Direccion = direccion;
   }

   public String getCodZip() {
      return this.CodZip;
   }

   public void setCodZip(String codZip) {
      this.CodZip = codZip;
   }

   public int getCodCliente() {
      return this.CodCliente;
   }

   public void setCodCliente(int codCliente) {
      this.CodCliente = codCliente;
   }

   public String getRucCliente() {
      return this.RucCliente;
   }

   public void setRucCliente(String rucCliente) {
      this.RucCliente = rucCliente;
   }

   public String getDNI() {
      return this.DNI;
   }

   public void setDNI(String dNI) {
      this.DNI = dNI;
   }

   public String getTelefono() {
      return this.Telefono;
   }

   public void setTelefono(String telefono) {
      this.Telefono = telefono;
   }

   public String getTipoDocumentoIdentidad() {
      return this.TipoDocumentoIdentidad;
   }

   public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad) {
      this.TipoDocumentoIdentidad = tipoDocumentoIdentidad;
   }

   public String getCodPostalEntrega() {
      return this.CodPostalEntrega;
   }

   public void setCodPostalEntrega(String codPostalEntrega) {
      this.CodPostalEntrega = codPostalEntrega;
   }

   public String getDireccionEntrega() {
      return this.DireccionEntrega;
   }

   public void setDireccionEntrega(String direccionEntrega) {
      this.DireccionEntrega = direccionEntrega;
   }
}
