package DbPeru.Posm.Modelo;

public class DatosReqArticulo {
   int tipoconsulta;
   String valor;
   int codestacion;
   int codalmacen;
   int codlistaprecio;

   public int getTipoconsulta() {
      return this.tipoconsulta;
   }

   public void setTipoconsulta(int tipoconsulta) {
      this.tipoconsulta = tipoconsulta;
   }

   public String getValor() {
      return this.valor;
   }

   public void setValor(String valor) {
      this.valor = valor;
   }

   public int getCodestacion() {
      return this.codestacion;
   }

   public void setCodestacion(int codestacion) {
      this.codestacion = codestacion;
   }

   public int getCodalmacen() {
      return this.codalmacen;
   }

   public void setCodalmacen(int codalmacen) {
      this.codalmacen = codalmacen;
   }

   public int getCodlistaprecio() {
      return this.codlistaprecio;
   }

   public void setCodlistaprecio(int codlistaprecio) {
      this.codlistaprecio = codlistaprecio;
   }
}
