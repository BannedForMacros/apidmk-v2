package DbPeru.Posm.Modelo;

public class DatosProvedor {
   int CodProveedor;
   String Nombreproveedor;
   int Cuentacon;
   int CodEstacion;
   int CodDireccion;
   String Direccion;
   String Telefono;
   String RUC;
   int CodFormaPago;
   String TipoMoneda;
   String Email;
   String zona_exonerada;

   public int getCodProveedor() {
      return this.CodProveedor;
   }

   public void setCodProveedor(int codProveedor) {
      this.CodProveedor = codProveedor;
   }

   public String getNombreproveedor() {
      return this.Nombreproveedor;
   }

   public void setNombreproveedor(String nombreproveedor) {
      this.Nombreproveedor = nombreproveedor;
   }

   public int getCuentacon() {
      return this.Cuentacon;
   }

   public void setCuentacon(int cuentacon) {
      this.Cuentacon = cuentacon;
   }

   public int getCodEstacion() {
      return this.CodEstacion;
   }

   public void setCodEstacion(int codEstacion) {
      this.CodEstacion = codEstacion;
   }

   public int getCodDireccion() {
      return this.CodDireccion;
   }

   public void setCodDireccion(int codDireccion) {
      this.CodDireccion = codDireccion;
   }

   public String getDireccion() {
      return this.Direccion;
   }

   public void setDireccion(String direccion) {
      this.Direccion = direccion;
   }

   public String getTelefono() {
      return this.Telefono;
   }

   public void setTelefono(String telefono) {
      this.Telefono = telefono;
   }

   public String getRUC() {
      return this.RUC;
   }

   public void setRUC(String rUC) {
      this.RUC = rUC;
   }

   public int getCodFormaPago() {
      return this.CodFormaPago;
   }

   public void setCodFormaPago(int codFormaPago) {
      this.CodFormaPago = codFormaPago;
   }

   public String getTipoMoneda() {
      return this.TipoMoneda;
   }

   public void setTipoMoneda(String tipoMoneda) {
      this.TipoMoneda = tipoMoneda;
   }

   public String getEmail() {
      return this.Email;
   }

   public void setEmail(String email) {
      this.Email = email;
   }

   public String getZona_exonerada() {
      return this.zona_exonerada;
   }

   public void setZona_exonerada(String zona_exonerada) {
      this.zona_exonerada = zona_exonerada;
   }
}
