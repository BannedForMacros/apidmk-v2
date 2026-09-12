package DbPeru.Posm.Modelo;

public class ListaPrecio {
   int CodEstacion;
   String RazonSocial;
   String Precio;
   int CodListaPrecio;

   public int getCodEstacion() {
      return this.CodEstacion;
   }

   public void setCodEstacion(int codEstacion) {
      this.CodEstacion = codEstacion;
   }

   public String getRazonSocial() {
      return this.RazonSocial;
   }

   public void setRazonSocial(String razonSocial) {
      this.RazonSocial = razonSocial;
   }

   public String getPrecio() {
      return this.Precio;
   }

   public void setPrecio(String precio) {
      this.Precio = precio;
   }

   public int getCodListaPrecio() {
      return this.CodListaPrecio;
   }

   public void setCodListaPrecio(int codListaPrecio) {
      this.CodListaPrecio = codListaPrecio;
   }
}
