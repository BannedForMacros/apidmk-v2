
CREATE PROCEDURE [dbo].[InsertarGuiasOdooDmk]              
              
as              
              
DECLARE @AnioGuiaRemision int, @NumSerie bigint ,@NumeroGuia bigint, @Tipoguia char(1), @tipodocumento int, @tipooperacion int, @error varchar(500),      
@registramovporventa bit      
-- verifica configuracion si no debe registrar movimiento para casos de Guias por Venta      
set @registramovporventa = 0      
select @registramovporventa = ValorBooleano from ConfiguracionMarket where CodConfiguracionMarket = 'BOGRNOSTK'      
              
IF OBJECT_ID('dbo.TMPGuiaTransferencia_Odoo', 'U') IS NOT NULL    DROP TABLE dbo.TMPGuiaTransferencia_Odoo;  
    
IF OBJECT_ID('dbo.TMPGuiaRemision_Odoo', 'U') IS NOT NULL    DROP TABLE dbo.TMPGuiaRemision_Odoo;  
    
  
CREATE TABLE [dbo].[TMPGuiaTransferencia_Odoo](id bigint identity(1,1),[AnioGuiaRemision] [smallint],[NumSerie] [smallint],[NumeroGuia] [bigint],              
    [TipoGuia] [char](1),[TipoOperacion] [smallint],[Tipomovimiento] [char](1),[CodAlmacen] [int], [codproveedor] [int])  -- <jravelo 20260413> se agrega el codigo de proveedor en la tabla temporal            
              
CREATE TABLE [dbo].[TMPGuiaRemision_Odoo](              
id bigint identity(1,1),              
[AnioGuiaRemision] [smallint] ,              
[NumSerie] [smallint] ,              
[NumeroGuia] [bigint],              
[TipoGuia] [char](1),              
[TipoOperacion] [smallint], [codproveedor] [int]) -- <jravelo 20260413> se agrega el codigo de proveedor en la tabla temporal              
              
--INSERTAMOS REGISTROS A TABLA TEMPORAL               
insert into TMPGuiaRemision_Odoo (AnioGuiaRemision,NumSerie,NumeroGuia,TipoGuia,TipoOperacion,CodProveedor  )              
select AnioGuiaRemision,NumSerie,NumeroGuia,TipoGuia,TipoOperacion,CodProveedor              
from GuiaRemision_odoo where estadoproceso=0              
              
-- INICIAMOS CURSOR               
declare @idguia int , @codproveedor int               
declare guia cursor LOCAL STATIC for       
              
select id from TMPGuiaRemision_Odoo              
              
open guia                  
fetch next from guia                  
into @idguia              
    while @@fetch_status = 0                  
    begin                
                
  select @AnioGuiaRemision = AnioGuiaRemision , @NumSerie = NumSerie,  @NumeroGuia = NumeroGuia, @Tipoguia = tipoguia, @tipooperacion = TipoOperacion ,
  @codproveedor = codproveedor
  from TMPGuiaRemision_Odoo where id=@idguia                    
                
  IF (select count(*) from GuiaRemision_odoo a inner join DetalleGuiaRemision_Odoo b on a.AnioGuiaRemision=b.AnioGuiaRemision and a.NumSerie=b.NumSerie and              
  a.NumeroGuia=b.NumeroGuia and a.tipoguia=b.tipoguia              
  where a.AnioGuiaRemision=@AnioGuiaRemision and a.NumSerie=@NumSerie and a.NumeroGuia=@NumeroGuia and a.tipoguia = @Tipoguia)>0              
                
  BEGIN                 
   --VALIDO SI LA EXISTE EN LA BASE DE DATOS              
   IF (select count(*) from GuiaRemision_odoo a inner join GuiaRemision b on a.AnioGuiaRemision=b.AnioGuiaRemision and a.NumSerie=b.NumSerie and              
   a.NumeroGuia=b.NumeroGuia and a.tipoguia=b.tipoguia and a.CodProveedor = b.CodProveedor             
   where a.AnioGuiaRemision=@AnioGuiaRemision and a.NumSerie=@NumSerie and a.NumeroGuia=@NumeroGuia and a.tipoguia = @Tipoguia and a.CodProveedor = @codproveedor)>0              
              
   BEGIN              
    INSERT INTO audit_InsertarGuiasOdooDmk (tipodocumento,anioguia,numserie,numeroguia,msg_error,fecharegistro)               
    values(@tipodocumento,@AnioGuiaRemision,@numserie,@NumeroGuia,'Documento ya esta registrado',GETDATE())              
   END              
   ELSE              
   BEGIN --INSERTAMOS REGISTROS CORRECTOS              
              
 BEGIN TRY               
 BEGIN TRANSACTION;              
               
    /*select @codproveedor = isnull(CodProveedor,0) from GuiaRemision_odoo a               
   where a.AnioGuiaRemision=@AnioGuiaRemision and a.NumSerie=@NumSerie and a.NumeroGuia=@NumeroGuia and a.tipoguia = @Tipoguia              */
                 
    insert into GuiaRemision  --INSERTAMOS CABECERA              
    (              
     AnioGuiaRemision,NumSerie,NumeroGuia,CodProveedor,TipoGuia,CodEstacion,NombreTransportista,FechaEmision,CodTrabajador,RUC,Estado,              
     TipoMoneda,UsuarioCreador,FechaCreacion,UsuarioModificador,FechaModificacion,TipoCalculo,TipoOperacion,Percepcion,Redondeo,Contacto,              
     Condiciones,FormaPago,MontoBruto,Descuento,ValorVenta,Igv,TotalVenta,EstadoGuia,Comentario,CodCliente,CodDireccion,SerieFactura,NumeroFactura,              
     CodAlmacenOrigen,CodAlmacenDestino,CodAlmacen,TipoTraslado,Partida,Destinatario,Transportista,UndTransporte,Llegada,CmpPago,PlacaVehiculo,CodTransportista,              
  BreveteChofer,TipoVenta,FechaVcmt,UbicaAnio,UbicaMes,UbicaCorrelativo,Flete,CodListaPrecio,TipoGuiaPedido,Consignacion,              
     PedidoInterno,Percepcion2,MOntoPercepcion,Tipodocumento,Valorada,agrupar,TipoDocumentoPedido,ClienteEventual,peso_Adicional,EstadoEnvioWS,              
     GuiaElectronica,NumeroSerieGE,CodigoRespuestaGE,EstadoEnvioGE,CodModalidadTransporte,ErrorGE,ImagenQR )              
    select               
     AnioGuiaRemision,NumSerie,NumeroGuia,isnull(a.CodProveedor,0),TipoGuia,a.CodEstacion,a.NombreTransportista,FechaEmision,codtrabajador,p.RUC,1,tipomonda,              
     'GUIAEXT',GETDATE(),'GUIAEXT',GETDATE(),mo.ingresosalida,a.TipoOperacion,0,0,0,0,formapago,ValorVenta as Montobruto,descuento,ValorVenta,Igv,              
     TotalVenta,1,Comentario,case when CodCliente = 0 then null else CodCliente end ,null,Seriefactura,NumeroFactura,isnull(CodAlmacenOrigen,0),isnull(CodAlmacenDestino,0),isnull(CodAlmacen,0),              
     0,direccionpartida,direccionllegada,'','','','',placavehiculo,t.codtransportista,BreveteChofer,'',FechaEmision,YEAR([FechaEmision]),              
     MONTH([FechaEmision]),NULL,0,isnull([CodListaPrecio],0),0,0,0,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL              
    
--Modificcion jravelo 20241213 si el codigo clientes es 0, se debe grabar en null              
                        
    from GuiaRemision_odoo a left join MaestroProveedores p              
     on a.codproveedor = p.CodProveedor              
     left join Transportista t on a.nombreTransportista = t.NombreTransportista              
     left join maestrooperacion  mo on a.TipoOperacion = mo.tipooperacion              
    where AnioGuiaRemision=@AnioGuiaRemision and NumSerie=@NumSerie and NumeroGuia=@NumeroGuia and tipoguia = @Tipoguia and a.CodProveedor = @codproveedor             
              
                  
    insert into DetalleGuiaRemision --INSERTAMOS DETALLE              
    (              
     AnioGuiaRemision,NumSerie,NumeroGuia,CodProveedor,TipoGuia,Descripcion,CodArticulo,Cantidad,Precio,              
     Descuento,Estado,UsuarioCreador,FechaCreacion,UsuarioModificador,FechaModificacion,tanque,Temperatura,Api,UnidadMedida,Propiedad1,              
     Propiedad2,Propiedad3,UndMinMed,CodArtNue,Igv,Isc,factor,Perecible,Caducidad,CodBarra,Item,PedidoInterno,montoflete,PrecioSimFlete,              
     SubCodigo,CantidadEntregada,Lote,FechaVencimiento,MontoDescuento,ImporteDetalle,Utilidad , esconsignado                  
    )              
    select               
     AnioGuiaRemision,NumSerie,NumeroGuia,@codproveedor,TipoGuia,b.NombreArticulo,a.CodArticulo,Cantidad,Precio,            
     round((a.descuento/(a.Cantidad*a.Precio))*100,2) as descuen,1,'GUIAEXT',GETDATE(),'GUIAEXT',              
     GETDATE(),0,0,null,UnidadMedida,0,0,0,1,b.CodArtNue,case when b.tipoigv <>1 then 0 else 0.18 end,null,0,0,null,b.CodBarra,Item,0,0,0,0,0,'',null,0,ImporteDetalle,0              
    , b.consignacion  
    from  DetalleGuiaRemision_Odoo a               
    inner join MaestroArticulo b on a.CodArticulo=b.CodArticulo                  
    where AnioGuiaRemision=@AnioGuiaRemision and NumSerie=@NumSerie and NumeroGuia=@NumeroGuia and tipoguia = @Tipoguia and a.codproveedor =  @codproveedor            
              
    --INSERTAR MOVIMIENTOS                  
              
    IF @tipooperacion <> 12              
    BEGIN              
     DECLARE  @idtranferencia int              
  declare @tipo char(1)            
 select @tipo  = IngresoSalida from MaestroOperacion where TipoOperacion = @tipooperacion            
      select @tipo = case when @tipooperacion = 15 then 'I' else @tipo end      
            
      if @tipooperacion = 8  and @registramovporventa =1      
  begin       
    select @tipo =  @tipo      
  end         
      else      
  begin      
    insert into TMPGuiaTransferencia_Odoo                
    select AnioGuiaRemision,NumSerie,NumeroGuia,TipoGuia,TipoOperacion,@tipo, --'I',                   
    /*insert into TMPGuiaTransferencia_Odoo              
    select AnioGuiaRemision,NumSerie,NumeroGuia,TipoGuia,TipoOperacion,'I',  */            
    CodAlmacen, CodProveedor from GuiaRemision_odoo              
    --where AnioGuiaRemision=2023 and NumSerie=9 and NumeroGuia=99 and TipoGuia='N'              
    where AnioGuiaRemision=@AnioGuiaRemision and NumSerie=@NumSerie and NumeroGuia=@NumeroGuia and tipoguia = @Tipoguia  
		and CodProveedor = @codproveedor
                
    set @idtranferencia = (select id from TMPGuiaTransferencia_Odoo)              
                
    exec InsertaMovimientoGuiaRemision_Transformacion @idtranferencia              
    delete from  [TMPGuiaTransferencia_Odoo]              
        end      
    END              
    ELSE               
    BEGIN                 
     insert into TMPGuiaTransferencia_Odoo              
     select AnioGuiaRemision,NumSerie,NumeroGuia,TipoGuia,TipoOperacion,'S' as 'Tipomovimiento',              
     codalmacenorigen as 'CodAlmacen', CodProveedor from GuiaRemision_odoo              
     where AnioGuiaRemision=@AnioGuiaRemision and NumSerie=@NumSerie and NumeroGuia=@NumeroGuia and tipoguia = @Tipoguia
	  and CodProveedor = @codproveedor
     UNION ALL              
     select AnioGuiaRemision,NumSerie,NumeroGuia,TipoGuia,'5' as TipoOperacion,'I' as 'Tipomovimiento',              
     codalmacendestino as 'CodAlmacen', CodProveedor from GuiaRemision_odoo              
     where AnioGuiaRemision=@AnioGuiaRemision and NumSerie=@NumSerie and NumeroGuia=@NumeroGuia and tipoguia = @Tipoguia
		and CodProveedor = @codproveedor
              
                   
              
     --Cursor Detalle                
     declare @idtranferencia1 int                
     declare mov1 cursor LOCAL STATIC for                
     select id from TMPGuiaTransferencia_Odoo                   
     open mov1                  
     fetch next from mov1                  
     into @idtranferencia1              
     while @@fetch_status = 0                  
      begin                
      --select * from TMPGuiaTransferencia_Odoo where id=@idtranferencia1               
                      exec InsertaMovimientoGuiaRemision_Transformacion @idtranferencia1              
       --              
              
       fetch next from mov1 into                 
       @idtranferencia1                
      end                 
     close mov1                  
     deallocate mov1                
                    
     delete from [TMPGuiaTransferencia_Odoo]                   
    END --FIN INSERTAR MOVIMIENTOS                          
                
  --UPDATE DE REGISTROS YA PROCESADOS              
  update GuiaRemision_odoo set estadoproceso=1 where AnioGuiaRemision=@AnioGuiaRemision and NumSerie=@NumSerie and NumeroGuia=@NumeroGuia and tipoguia = @Tipoguia              
  update detalleGuiaRemision_odoo set estadoproceso=1 where AnioGuiaRemision=@AnioGuiaRemision and NumSerie=@NumSerie and NumeroGuia=@NumeroGuia and tipoguia = @Tipoguia                     
  if @Tipoguia = 'A'              
   begin              
    update MaestroDocumentoSerie set ultimovalormarket = @NumeroGuia where tipodocumento = 12 and numserie = @NumSerie              
   end              
  --exec InsertarGuiasOdooDmk              
                
 COMMIT TRANSACTION;              
 END TRY              
BEGIN CATCH  
    -- 1. Capturamos el mensaje del error REAL  
    DECLARE @MsgError NVARCHAR(4000) = ERROR_MESSAGE();  
  
    -- 2. Hacemos Rollback solo si es necesario (Evita el error de mismatch)  
    IF @@TRANCOUNT > 0  
        ROLLBACK TRANSACTION;  
  
    -- 3. ¡Lanzamos el error a la pantalla!  
    -- Esto hará que en la web salga el motivo real (ej: "División entre cero")  
    RAISERROR(@MsgError, 16, 1);  
END CATCH;             
              
   END -- FIN DE REGISTRO COMPLETO                  
  END --IF VALIDA SI REGISTROS ESTA COMPLETO              
  ELSE              
  BEGIN              
   INSERT INTO audit_InsertarGuiasOdooDmk (tipodocumento,anioguia,numserie,numeroguia,msg_error,fecharegistro)               
   values(@tipodocumento,@AnioGuiaRemision,@numserie,@NumeroGuia,'Documento incompleto',GETDATE())              
  END                
                              
         fetch next from guia into                 
         @idguia                
    end                 
close guia                  
deallocate guia                  
              
              
--REGISTRAMOS EL ERROR               
INSERT INTO audit_InsertarGuiasOdooDmk (tipodocumento,anioguia,numserie,numeroguia,msg_error,fecharegistro)               
values(@tipodocumento,@AnioGuiaRemision,@numserie,@NumeroGuia,@error,GETDATE())              
              
--ELIMINAMOS TEMPORAL                   
IF OBJECT_ID('tempdb..TMPGuiaRemision_Odoo') IS NOT NULL      DROP TABLE TMPGuiaRemision_Odoo;  IF OBJECT_ID('tempdb..TMPGuiaTransferencia_Odoo') IS NOT NULL      DROP TABLE TMPGuiaTransferencia_Odoo;  
  
  

