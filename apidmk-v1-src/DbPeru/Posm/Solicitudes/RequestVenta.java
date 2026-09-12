package DbPeru.Posm.Solicitudes;

public class RequestVenta {
   String TipoDocumento;
   String SeriVenta;
   String NumeVenta;
   String CodSucursal;
   String RucEmpresa;

   public String getTipoDocumento() {
      return this.TipoDocumento;
   }

   public void setTipoDocumento(String tipoDocumento) {
      this.TipoDocumento = tipoDocumento;
   }

   public String getRucEmpresa() {
      return this.RucEmpresa;
   }

   public void setRucEmpresa(String rucEmpresa) {
      this.RucEmpresa = rucEmpresa;
   }

   public String getCodSucursal() {
      return this.CodSucursal;
   }

   public void setCodSucursal(String codSucursal) {
      this.CodSucursal = codSucursal;
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
