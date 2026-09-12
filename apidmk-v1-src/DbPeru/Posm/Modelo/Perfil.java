package DbPeru.Posm.Modelo;

public class Perfil {
   private int estado;
   private String fechaactualiza;
   private String fecharegistro;
   private int idperfil;
   private String modocobro;
   private String perfil;
   private int solicitacomentario;

   public int getEstado() {
      return this.estado;
   }

   public void setEstado(int estado) {
      this.estado = estado;
   }

   public String getFechaactualiza() {
      return this.fechaactualiza;
   }

   public void setFechaactualiza(String fechaactualiza) {
      this.fechaactualiza = fechaactualiza;
   }

   public String getFecharegistro() {
      return this.fecharegistro;
   }

   public void setFecharegistro(String fecharegistro) {
      this.fecharegistro = fecharegistro;
   }

   public int getIdperfil() {
      return this.idperfil;
   }

   public void setIdperfil(int idperfil) {
      this.idperfil = idperfil;
   }

   public String getModocobro() {
      return this.modocobro;
   }

   public void setModocobro(String modocobro) {
      this.modocobro = modocobro;
   }

   public String getPerfil() {
      return this.perfil;
   }

   public void setPerfil(String perfil) {
      this.perfil = perfil;
   }

   public int getSolicitacomentario() {
      return this.solicitacomentario;
   }

   public void setSolicitacomentario(int solicitacomentario) {
      this.solicitacomentario = solicitacomentario;
   }
}
