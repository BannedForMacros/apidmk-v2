package DbPeru.Posm.Modelo;

import java.math.BigDecimal;

public class DatosRespTipoCambio {
   String Fecha;
   BigDecimal Venta;
   BigDecimal Compra;
   BigDecimal TcEstacion;

   public String getFecha() {
      return this.Fecha;
   }

   public void setFecha(String fecha) {
      this.Fecha = fecha;
   }

   public BigDecimal getVenta() {
      return this.Venta;
   }

   public void setVenta(BigDecimal venta) {
      this.Venta = venta;
   }

   public BigDecimal getCompra() {
      return this.Compra;
   }

   public void setCompra(BigDecimal compra) {
      this.Compra = compra;
   }

   public BigDecimal getTcEstacion() {
      return this.TcEstacion;
   }

   public void setTcEstacion(BigDecimal tcEstacion) {
      this.TcEstacion = tcEstacion;
   }
}
