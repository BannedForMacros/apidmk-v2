package DbPeru.Posm.Modelo;

public class DatosVehiculo {
   String PlacaVehiculo;
   String MarcaVehiculo;
   int CodTransportista;
   String Estado;

   public String getPlacaVehiculo() {
      return this.PlacaVehiculo;
   }

   public void setPlacaVehiculo(String placaVehiculo) {
      this.PlacaVehiculo = placaVehiculo;
   }

   public String getMarcaVehiculo() {
      return this.MarcaVehiculo;
   }

   public void setMarcaVehiculo(String marcaVehiculo) {
      this.MarcaVehiculo = marcaVehiculo;
   }

   public int getCodTransportista() {
      return this.CodTransportista;
   }

   public void setCodTransportista(int codTransportista) {
      this.CodTransportista = codTransportista;
   }

   public String getEstado() {
      return this.Estado;
   }

   public void setEstado(String estado) {
      this.Estado = estado;
   }
}
