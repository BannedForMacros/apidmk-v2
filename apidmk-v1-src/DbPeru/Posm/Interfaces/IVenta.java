package DbPeru.Posm.Interfaces;

import DbPeru.Posm.Modelo.Venta;
import DbPeru.Posm.Respuesta.Response;
import DbPeru.Posm.Respuesta.ResponseHash;
import DbPeru.Posm.Solicitudes.RequestActualizaHash;
import DbPeru.Posm.Solicitudes.RequestVenta;
import DbPeru.Posm.Solicitudes.RequestVentaDMK;
import DbPeru.Posm.Solicitudes.RequestVentasSinHash;
import java.util.List;

public interface IVenta {
   Response InsertarVenta(Venta var1);

   List ListarVenta(RequestVentaDMK var1);

   Response ActualizarEstadoSincronizacionVenta(RequestVenta var1);

   Response ActualizaHash(RequestActualizaHash var1);

   ResponseHash ListaHash(RequestVenta var1);

   List ListaVentasSinHash(RequestVentasSinHash var1);
}
