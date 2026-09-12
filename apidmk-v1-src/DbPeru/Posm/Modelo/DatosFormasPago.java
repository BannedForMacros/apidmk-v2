package DbPeru.Posm.Modelo;

public class DatosFormasPago {
   int CodFormaPago;
   String Descripcion;
   int TipoMoneda;
   String Moneda;
   int DiasPago;
   int TarjetaCredito;

   public int getCodFormaPago() {
      return this.CodFormaPago;
   }

   public void setCodFormaPago(int codFormaPago) {
      this.CodFormaPago = codFormaPago;
   }

   public String getDescripcion() {
      return this.Descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.Descripcion = descripcion;
   }

   public int getTipoMoneda() {
      return this.TipoMoneda;
   }

   public void setTipoMoneda(int tipoMoneda) {
      this.TipoMoneda = tipoMoneda;
   }

   public String getMoneda() {
      return this.Moneda;
   }

   public void setMoneda(String moneda) {
      this.Moneda = moneda;
   }

   public int getDiasPago() {
      return this.DiasPago;
   }

   public void setDiasPago(int diasPago) {
      this.DiasPago = diasPago;
   }

   public int getTarjetaCredito() {
      return this.TarjetaCredito;
   }

   public void setTarjetaCredito(int tarjetaCredito) {
      this.TarjetaCredito = tarjetaCredito;
   }
}
