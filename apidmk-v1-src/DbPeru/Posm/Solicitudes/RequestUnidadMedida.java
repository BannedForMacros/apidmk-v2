package DbPeru.Posm.Solicitudes;

public class RequestUnidadMedida {
   private int codunidad;
   private String unidad;
   private double cantidad;
   private String siglasunat;
   private String fecha;
   private String usuario;
   private String siglaunidadDMK;

   public int getCodunidad() {
      return this.codunidad;
   }

   public void setCodunidad(int codunidad) {
      this.codunidad = codunidad;
   }

   public String getUnidad() {
      return this.unidad;
   }

   public void setUnidad(String unidad) {
      this.unidad = unidad;
   }

   public double getCantidad() {
      return this.cantidad;
   }

   public void setCantidad(double cantidad) {
      this.cantidad = cantidad;
   }

   public String getSiglasunat() {
      return this.siglasunat;
   }

   public void setSiglasunat(String siglasunat) {
      this.siglasunat = siglasunat;
   }

   public String getFecha() {
      return this.fecha;
   }

   public void setFecha(String fecha) {
      this.fecha = fecha;
   }

   public String getUsuario() {
      return this.usuario;
   }

   public void setUsuario(String usuario) {
      this.usuario = usuario;
   }

   public String getSiglaunidadDMK() {
      return this.siglaunidadDMK;
   }

   public void setSiglaunidadDMK(String siglaunidadDMK) {
      this.siglaunidadDMK = siglaunidadDMK;
   }
}
