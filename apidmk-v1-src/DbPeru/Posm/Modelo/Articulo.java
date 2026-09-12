package DbPeru.Posm.Modelo;

public class Articulo {
   public String codArticulo;
   public String descArticulo;
   public String codFamilia;
   public String codSubFamilia;
   public int pesoArticulo;
   public String imgArticulo;
   public String tipoIgv;
   public String codSunat;
   public Boolean icbper;
   public String montoIcbper;
   public String controlPeso;
   public String codArtNue;

   public String getCodArtNue() {
      return this.codArtNue;
   }

   public void setCodArtNue(String codArtNue) {
      this.codArtNue = codArtNue;
   }

   public String getControlPeso() {
      return this.controlPeso;
   }

   public void setControlPeso(String controlPeso) {
      this.controlPeso = controlPeso;
   }

   public Boolean getIcbper() {
      return this.icbper;
   }

   public void setIcbper(Boolean icbper) {
      this.icbper = icbper;
   }

   public String getMontoIcbper() {
      return this.montoIcbper;
   }

   public void setMontoIcbper(String montoIcbper) {
      this.montoIcbper = montoIcbper;
   }

   public String getCodSunat() {
      return this.codSunat;
   }

   public void setCodSunat(String codSunat) {
      this.codSunat = codSunat;
   }

   public String getCodArticulo() {
      return this.codArticulo;
   }

   public void setCodArticulo(String codArticulo) {
      this.codArticulo = codArticulo;
   }

   public String getDescArticulo() {
      return this.descArticulo;
   }

   public void setDescArticulo(String descArticulo) {
      this.descArticulo = descArticulo;
   }

   public String getCodFamilia() {
      return this.codFamilia;
   }

   public void setCodFamilia(String codFamilia) {
      this.codFamilia = codFamilia;
   }

   public String getCodSubFamilia() {
      return this.codSubFamilia;
   }

   public void setCodSubFamilia(String codSubFamilia) {
      this.codSubFamilia = codSubFamilia;
   }

   public int getPesoArticulo() {
      return this.pesoArticulo;
   }

   public void setPesoArticulo(int pesoArticulo) {
      this.pesoArticulo = pesoArticulo;
   }

   public String getImgArticulo() {
      return this.imgArticulo;
   }

   public void setImgArticulo(String imgArticulo) {
      this.imgArticulo = imgArticulo;
   }

   public String getTipoIgv() {
      return this.tipoIgv;
   }

   public void setTipoIgv(String tipoIgv) {
      this.tipoIgv = tipoIgv;
   }
}
