package DbPeru.Posm.Service;

import DbPeru.Posm.BaseDatos.Implementacion.DERBY.VentaDERBY;
import DbPeru.Posm.BaseDatos.Implementacion.MYSQL.VentaMYSQL;
import DbPeru.Posm.Interfaces.IVenta;
import DbPeru.Posm.Modelo.Venta;
import DbPeru.Posm.Respuesta.Response;
import DbPeru.Posm.Respuesta.ResponseHash;
import DbPeru.Posm.Respuesta.ResponseVenta;
import DbPeru.Posm.Respuesta.ResponseVentasSinHash;
import DbPeru.Posm.Solicitudes.RequestActualizaHash;
import DbPeru.Posm.Solicitudes.RequestVenta;
import DbPeru.Posm.Solicitudes.RequestVentaDMK;
import DbPeru.Posm.Solicitudes.RequestVentasSinHash;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVenta {
   @Autowired
   private Environment environment;
   @Autowired
   private VentaMYSQL DaoVentaMYSQL;
   @Autowired
   private VentaDERBY DaoVentaDERBY;
   String modalidad = "";

   public Response InsertarVenta(Venta venta) {
      this.modalidad = this.environment.getRequiredProperty("spring.modalidad");
      Response Dao = null;
      if (this.modalidad.equalsIgnoreCase("SERVER")) {
         Dao = this.DaoVentaMYSQL.InsertarVenta(venta);
      } else if (this.modalidad.equalsIgnoreCase("LOCAL")) {
         Dao = this.DaoVentaDERBY.InsertarVenta(venta);
      }

      return Dao;
   }

   public Response ActualizaHash(RequestActualizaHash venta) {
      this.modalidad = this.environment.getRequiredProperty("spring.modalidad");
      Response Dao = null;
      if (this.modalidad.equalsIgnoreCase("SERVER")) {
         Dao = this.DaoVentaMYSQL.ActualizaHash(venta);
      } else if (this.modalidad.equalsIgnoreCase("LOCAL")) {
         Dao = this.DaoVentaDERBY.ActualizaHash(venta);
      }

      return Dao;
   }

   public List ListarVenta(RequestVentaDMK venta) {
      this.modalidad = this.environment.getRequiredProperty("spring.modalidad");
      List<ResponseVenta> Dao = new ArrayList();
      if (this.modalidad.equalsIgnoreCase("SERVER")) {
         Dao = this.DaoVentaMYSQL.ListarVenta(venta);
      } else if (this.modalidad.equalsIgnoreCase("LOCAL")) {
         Dao = this.DaoVentaDERBY.ListarVenta(venta);
      }

      return Dao;
   }

   public ResponseHash ListaHash(RequestVenta venta) {
      this.modalidad = this.environment.getRequiredProperty("spring.modalidad");
      ResponseHash Dao = new ResponseHash();
      if (this.modalidad.equalsIgnoreCase("SERVER")) {
         Dao = this.DaoVentaMYSQL.ListaHash(venta);
      } else if (this.modalidad.equalsIgnoreCase("LOCAL")) {
         Dao = this.DaoVentaDERBY.ListaHash(venta);
      }

      return Dao;
   }

   public Response ActualizarEstadoSincronizacionVenta(RequestVenta venta) {
      this.modalidad = this.environment.getRequiredProperty("spring.modalidad");
      Response Dao = null;
      if (this.modalidad.equalsIgnoreCase("SERVER")) {
         Dao = this.DaoVentaMYSQL.ActualizarEstadoSincronizacionVenta(venta);
      } else if (this.modalidad.equalsIgnoreCase("LOCAL")) {
         Dao = this.DaoVentaDERBY.ActualizarEstadoSincronizacionVenta(venta);
      }

      return Dao;
   }

   public List ListaVentasSinHash(RequestVentasSinHash venta) {
      this.modalidad = this.environment.getRequiredProperty("spring.modalidad");
      List<ResponseVentasSinHash> Dao = new ArrayList();
      if (this.modalidad.equalsIgnoreCase("SERVER")) {
         Dao = this.DaoVentaMYSQL.ListaVentasSinHash(venta);
      } else if (this.modalidad.equalsIgnoreCase("LOCAL")) {
         Dao = this.DaoVentaDERBY.ListaVentasSinHash(venta);
      }

      return Dao;
   }
}
