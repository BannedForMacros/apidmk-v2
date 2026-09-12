package DbPeru.Posm.Modelo;

import java.math.BigDecimal;

public class PersonaCredito {
   private String codMonto;
   private String creaUsuario;
   private int estaMonto;
   private String fecCrea;
   private String fecMod;
   private int idPago;
   private int idPersona;
   private String modUsuario;
   private BigDecimal monto;

   public String getCodMonto() {
      return this.codMonto;
   }

   public void setCodMonto(String codMonto) {
      this.codMonto = codMonto;
   }

   public String getCreaUsuario() {
      return this.creaUsuario;
   }

   public void setCreaUsuario(String creaUsuario) {
      this.creaUsuario = creaUsuario;
   }

   public int getEstaMonto() {
      return this.estaMonto;
   }

   public void setEstaMonto(int estaMonto) {
      this.estaMonto = estaMonto;
   }

   public String getFecCrea() {
      return this.fecCrea;
   }

   public void setFecCrea(String fecCrea) {
      this.fecCrea = fecCrea;
   }

   public String getFecMod() {
      return this.fecMod;
   }

   public void setFecMod(String fecMod) {
      this.fecMod = fecMod;
   }

   public int getIdPago() {
      return this.idPago;
   }

   public void setIdPago(int idPago) {
      this.idPago = idPago;
   }

   public int getIdPersona() {
      return this.idPersona;
   }

   public void setIdPersona(int idPersona) {
      this.idPersona = idPersona;
   }

   public String getModUsuario() {
      return this.modUsuario;
   }

   public void setModUsuario(String modUsuario) {
      this.modUsuario = modUsuario;
   }

   public BigDecimal getMonto() {
      return this.monto;
   }

   public void setMonto(BigDecimal monto) {
      this.monto = monto;
   }
}
