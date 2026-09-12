package DbPeru.Posm.Modelo;

public class Seriedocumento {
   private String codDocumento;
   private String correlativo;
   private String creaUsuario;
   private int estaSeri;
   private String fecCrea;
   private String fecMod;
   private String modUsuario;
   private String serieDoc;

   public String getCodDocumento() {
      return this.codDocumento;
   }

   public void setCodDocumento(String codDocumento) {
      this.codDocumento = codDocumento;
   }

   public String getCorrelativo() {
      return this.correlativo;
   }

   public void setCorrelativo(String correlativo) {
      this.correlativo = correlativo;
   }

   public String getCreaUsuario() {
      return this.creaUsuario;
   }

   public void setCreaUsuario(String creaUsuario) {
      this.creaUsuario = creaUsuario;
   }

   public int getEstaSeri() {
      return this.estaSeri;
   }

   public void setEstaSeri(int estaSeri) {
      this.estaSeri = estaSeri;
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

   public String getModUsuario() {
      return this.modUsuario;
   }

   public void setModUsuario(String modUsuario) {
      this.modUsuario = modUsuario;
   }

   public String getSerieDoc() {
      return this.serieDoc;
   }

   public void setSerieDoc(String serieDoc) {
      this.serieDoc = serieDoc;
   }
}
