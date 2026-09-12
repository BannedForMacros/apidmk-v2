package DbPeru.Posm.Modelo;

import java.math.BigDecimal;

public class TipoIgv {
   private String codigosunat;
   private int codIgv;
   private String descripcion;
   private String estado;
   private String fechaCreacion;
   private String fechaModificacion;
   private BigDecimal tasa;
   private String usuarioCreador;
   private String usuarioModificador;

   public String getCodigosunat() {
      return this.codigosunat;
   }

   public void setCodigosunat(String codigosunat) {
      this.codigosunat = codigosunat;
   }

   public int getCodIgv() {
      return this.codIgv;
   }

   public void setCodIgv(int codIgv) {
      this.codIgv = codIgv;
   }

   public String getDescripcion() {
      return this.descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   public String getEstado() {
      return this.estado;
   }

   public void setEstado(String estado) {
      this.estado = estado;
   }

   public String getFechaCreacion() {
      return this.fechaCreacion;
   }

   public void setFechaCreacion(String fechaCreacion) {
      this.fechaCreacion = fechaCreacion;
   }

   public String getFechaModificacion() {
      return this.fechaModificacion;
   }

   public void setFechaModificacion(String fechaModificacion) {
      this.fechaModificacion = fechaModificacion;
   }

   public BigDecimal getTasa() {
      return this.tasa;
   }

   public void setTasa(BigDecimal tasa) {
      this.tasa = tasa;
   }

   public String getUsuarioCreador() {
      return this.usuarioCreador;
   }

   public void setUsuarioCreador(String usuarioCreador) {
      this.usuarioCreador = usuarioCreador;
   }

   public String getUsuarioModificador() {
      return this.usuarioModificador;
   }

   public void setUsuarioModificador(String usuarioModificador) {
      this.usuarioModificador = usuarioModificador;
   }
}
