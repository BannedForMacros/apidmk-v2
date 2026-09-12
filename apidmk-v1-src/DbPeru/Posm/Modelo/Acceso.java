package DbPeru.Posm.Modelo;

public class Acceso {
   private String acceso;
   private int estado;
   private String fechaactualiza;
   private String fecharegistro;
   private int idacceso;

   public String getAcceso() {
      return this.acceso;
   }

   public void setAcceso(String acceso) {
      this.acceso = acceso;
   }

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

   public int getIdacceso() {
      return this.idacceso;
   }

   public void setIdacceso(int idacceso) {
      this.idacceso = idacceso;
   }
}
