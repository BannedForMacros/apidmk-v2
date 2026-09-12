package DbPeru.Posm.Solicitudes;

public class RequestVentaDMK {
   private String rucEmpresa;
   private String codSucursal;

   public String getCodSucursal() {
      return this.codSucursal;
   }

   public void setCodSucursal(String codSucursal) {
      this.codSucursal = codSucursal;
   }

   public String getRucEmpresa() {
      return this.rucEmpresa;
   }

   public void setRucEmpresa(String rucEmpresa) {
      this.rucEmpresa = rucEmpresa;
   }
}
