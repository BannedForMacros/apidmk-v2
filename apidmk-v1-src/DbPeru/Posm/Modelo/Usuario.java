package DbPeru.Posm.Modelo;

public class Usuario {
   private String aliaUsuario;
   private String codUsuario;
   private int estaUsuario;
   private int idPersona;
   private int idperfil;
   private String passUsuario;

   public String getAliaUsuario() {
      return this.aliaUsuario;
   }

   public void setAliaUsuario(String aliaUsuario) {
      this.aliaUsuario = aliaUsuario;
   }

   public String getCodUsuario() {
      return this.codUsuario;
   }

   public void setCodUsuario(String codUsuario) {
      this.codUsuario = codUsuario;
   }

   public int getEstaUsuario() {
      return this.estaUsuario;
   }

   public void setEstaUsuario(int estaUsuario) {
      this.estaUsuario = estaUsuario;
   }

   public int getIdPersona() {
      return this.idPersona;
   }

   public void setIdPersona(int idPersona) {
      this.idPersona = idPersona;
   }

   public int getIdperfil() {
      return this.idperfil;
   }

   public void setIdperfil(int idperfil) {
      this.idperfil = idperfil;
   }

   public String getPassUsuario() {
      return this.passUsuario;
   }

   public void setPassUsuario(String passUsuario) {
      this.passUsuario = passUsuario;
   }
}
