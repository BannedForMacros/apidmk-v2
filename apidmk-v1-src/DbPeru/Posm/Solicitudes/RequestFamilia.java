package DbPeru.Posm.Solicitudes;

public class RequestFamilia {
   private String codfamilia;
   private String familia;
   private String subfamilia;
   private int estado;

   public String getCodfamilia() {
      return this.codfamilia;
   }

   public void setCodfamilia(String codfamilia) {
      this.codfamilia = codfamilia;
   }

   public String getFamilia() {
      return this.familia;
   }

   public void setFamilia(String familia) {
      this.familia = familia;
   }

   public String getSubfamilia() {
      return this.subfamilia;
   }

   public void setSubfamilia(String subfamilia) {
      this.subfamilia = subfamilia;
   }

   public int getEstado() {
      return this.estado;
   }

   public void setEstado(int estado) {
      this.estado = estado;
   }
}
