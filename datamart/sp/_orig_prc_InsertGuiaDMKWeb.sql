
CREATE procedure [dbo].[prc_InsertGuiaDMKWeb] @Guia varchar(max)           
as      
  declare @XMLGuia xml    , @codproveedor int 
  set @XMLGuia = convert(XML, @Guia)    
set dateformat ymd          
begin          
            
 BEGIN TRY          
 BEGIN TRAN          
           
 IF OBJECT_ID('tempdb..#TempguiaGRE') IS NOT NULL              
  BEGIN              
   DROP TABLE #TempguiGRE          
  END            
      
   IF OBJECT_ID('tempdb..#TempguiaGREDET') IS NOT NULL              
  BEGIN              
   DROP TABLE #TempguiaGREDET          
  END        
      
 SET @XMLGuia = replace(CONVERT(VARCHAR(MAX), @XMLGuia), '<?xml version="1.0" encoding="utf-16" ?>', '')        
      
 SET @XMLGuia = replace(CONVERT(VARCHAR(MAX), @XMLGuia), 'DbPeru.Posm.Modelo.DatosGuiaRem', 'DatosGuiaRem')        
 SET @XMLGuia = replace(CONVERT(VARCHAR(MAX), @XMLGuia), 'DbPeru.Posm.Modelo.DatosDetaGuiaRem', 'DatosDetaGuiaRem')        
       
SELECT                 
    CD.DETA.value('(AnioGuiaRemision)[1]', 'int') as AnioGuiaRemision,           
  CD.DETA.value('(NumSerie)[1]', 'int') as NumSerie,           
  CD.DETA.value('(NumeroGuia)[1]', 'bigint') as NumeroGuia,             
  CD.DETA.value('(CodProveedor)[1]', 'int') as CodProveedor,           
  CD.DETA.value('(CodCliente)[1]', 'int') as CodCliente,           
  CD.DETA.value('(NombreTransportista)[1]', 'varchar(25)') as NombreTransportista,           
  CD.DETA.value('(RucTransportista)[1]', 'varchar(1)') as RucTransportista,           
  CD.DETA.value('(TipoGuia)[1]', 'char(1)') as TipoGuia,           
  CD.DETA.value('(CodEstacion)[1]', 'int') as CodEstacion,           
  CD.DETA.value('(FechaEmision)[1]', 'varchar(20)') as FechaEmision,           
  CD.DETA.value('(TipoOperacion)[1]', 'int') as TipoOperacion,           
  CD.DETA.value('(ValorVenta)[1]', 'decimal(12,4)') as ValorVenta,           
  CD.DETA.value('(IGV)[1]', 'decimal(12,4)') as IGV,           
  CD.DETA.value('(TotalVenta)[1]', 'decimal(12,4)') as TotalVenta,           
  CD.DETA.value('(Comentario)[1]', 'varchar(max)') as Comentario,           
  CD.DETA.value('(CodAlmacenOrigen)[1]', 'int') as CodAlmacenOrigen,           
  CD.DETA.value('(CodAlmacenDestino)[1]', 'int') as CodAlmacenDestino,           
  CD.DETA.value('(CodAlmacen)[1]', 'int') as CodAlmacen,           
  CD.DETA.value('(CodListaPrecio)[1]', 'int') as CodListaPrecio,           
  CD.DETA.value('(EstadoProceso)[1]', 'char(1)') as EstadoProceso,           
  CD.DETA.value('(Seriefactura)[1]', 'int') as Seriefactura,           
  CD.DETA.value('(NumeroFactura)[1]', 'int') as NumeroFactura,           
  CD.DETA.value('(direccionpartida)[1]', 'varchar(50)') as direccionpartida,           
  CD.DETA.value('(direccionllegada)[1]', 'varchar(50)') as direccionllegada,           
  CD.DETA.value('(ubigeopartida)[1]', 'varchar(10)') as ubigeopartida,           
  CD.DETA.value('(ubigeollegada)[1]', 'varchar(10)') as ubigeollegada,           
  CD.DETA.value('(placavehiculo)[1]', 'varchar(12)') as placavehiculo,           
  CD.DETA.value('(BreveteChofer)[1]', 'varchar(12)') as BreveteChofer,           
  CD.DETA.value('(Nombrechofer)[1]', 'varchar(50)') as Nombrechofer,           
  CD.DETA.value('(DNIChofer)[1]', 'varchar(15)') as DNIChofer,           
  CD.DETA.value('(modalidadTransporte)[1]', 'varchar(2)') as modalidadTransporte,           
  CD.DETA.value('(codtrabajador)[1]', 'int') as codtrabajador,           
  CD.DETA.value('(tipomonda)[1]', 'int') as tipomonda,           
  CD.DETA.value('(formapago)[1]', 'int') as formapago,           
  CD.DETA.value('(descuento)[1]', 'decimal(6,2)') as descuento           
        
 INTO #TempguiaGRE          
 FROM @XMLGuia.nodes ('/DatosGuiaRem') AS CD(DETA)          
      
      select top 1 @codproveedor= CodProveedor from #TempguiaGRE -- <jravelo 20260413> se extrae el codigo de proveedor
 SELECT                 
    CD.DETA.value('(AnioGuiaRemision)[1]', 'int') as AnioGuiaRemision,           
  CD.DETA.value('(NumSerie)[1]', 'int') as NumSerie,           
  CD.DETA.value('(NumeroGuia)[1]', 'bigint') as NumeroGuia,           
  CD.DETA.value('(TipoGuia)[1]', 'char(1)') as TipoGuia,      
  CD.DETA.value('(CodArticulo)[1]', 'int') as CodArticulo,           
  CD.DETA.value('(Cantidad)[1]', 'decimal(12,4)') as Cantidad,           CD.DETA.value('(Precio)[1]', 'decimal(12,4)') as Precio,           
  CD.DETA.value('(UnidadMedida)[1]', 'int') as UnidadMedida,           
  CD.DETA.value('(ImporteDetalle)[1]', 'decimal(12,4)') as ImporteDetalle,           
  CD.DETA.value('(Item)[1]', 'int') as Item,           
  CD.DETA.value('(Descuento)[1]', 'decimal(6,2)') as descu,           
  CD.DETA.value('(EstadoProceso)[1]', 'char(1)') as EstadoProceso,                
  CD.DETA.value('(tipoigv)[1]', 'char(1)') as tipoigv                
 INTO #TempguiaGREDET          
 FROM @XMLGuia.nodes ('/DatosGuiaRem/Detalle/DatosDetaGuiaRem') AS CD(DETA)          
      
      
 select t.AnioGuiaRemision,t.NumSerie,t.NumeroGuia,t.CodProveedor,CodCliente,NombreTransportista,RucTransportista,t.TipoGuia,      
CodEstacion,FechaEmision,TipoOperacion,ValorVenta,Igv,TotalVenta,Comentario,CodAlmacenOrigen,CodAlmacenDestino,CodAlmacen,CodListaPrecio,      
EstadoProceso,Seriefactura,NumeroFactura,direccionpartida,direccionllegada,ubigeopartida,ubigeollegada,placavehiculo,BreveteChofer,Nombrechofer,      
DNIChofer,modalidadTransporte,codtrabajador,tipomonda,formapago,descuento into #cab      
from  #TempguiaGRE t left join (select AnioGuiaRemision,NumSerie,NumeroGuia, CodProveedor, TipoGuia from GuiaRemision_odoo ) g       
 on t.AnioGuiaRemision = g.AnioGuiaRemision and t.NumSerie = g.NumSerie and t.NumeroGuia = g.NumeroGuia 
	and t.CodProveedor = g.CodProveedor and t.TipoGuia = g.TipoGuia
where g.AnioGuiaRemision is null      
      
if exists(select 1 from #cab)       
 begin      
   insert into GuiaRemision_odoo(AnioGuiaRemision,NumSerie,NumeroGuia,CodProveedor,CodCliente,NombreTransportista,RucTransportista,TipoGuia,      
  CodEstacion,FechaEmision,TipoOperacion,ValorVenta,Igv,TotalVenta,Comentario,CodAlmacenOrigen,CodAlmacenDestino,CodAlmacen,CodListaPrecio,      
  EstadoProceso,Seriefactura,NumeroFactura,direccionpartida,direccionllegada,ubigeopartida,ubigeollegada,placavehiculo,BreveteChofer,Nombrechofer,      
  DNIChofer,modalidadTransporte,codtrabajador,tipomonda,formapago,descuento)      
  select AnioGuiaRemision,NumSerie,NumeroGuia,CodProveedor,CodCliente,NombreTransportista,RucTransportista,TipoGuia,      
  CodEstacion,FechaEmision,TipoOperacion,ValorVenta,Igv,TotalVenta,Comentario,CodAlmacenOrigen,CodAlmacenDestino,CodAlmacen,CodListaPrecio,      
  '0',Seriefactura,NumeroFactura,direccionpartida,direccionllegada,ubigeopartida,ubigeollegada,placavehiculo,BreveteChofer,Nombrechofer,      
  DNIChofer,modalidadTransporte,codtrabajador,tipomonda,formapago,descuento      
  from  #cab t       
 end       
       
  select t.AnioGuiaRemision,t.NumSerie,t.NumeroGuia,t.TipoGuia,CodArticulo,Cantidad,Precio,UnidadMedida,ImporteDetalle,Item,EstadoProceso,descu, tipoigv      
  into #det      
  from #TempguiaGREDET t left join (select AnioGuiaRemision,NumSerie,NumeroGuia, codproveedor, TipoGuia from DetalleGuiaRemision_Odoo) dt      
  on t.AnioGuiaRemision = dt.AnioGuiaRemision and t.NumSerie = dt.NumSerie and t.NumeroGuia = dt.NumeroGuia and @codproveedor = dt.codproveedor      
	and t.TipoGuia = dt.tipoguia
 where dt.AnioGuiaRemision is null      
      
if exists(select 1 from #det)       
 begin      
        
  insert into DetalleGuiaRemision_Odoo(AnioGuiaRemision,NumSerie,NumeroGuia,TipoGuia,CodArticulo,Cantidad,Precio,UnidadMedida,ImporteDetalle,Item,EstadoProceso,descuento,tipoigv, codproveedor)      
  select AnioGuiaRemision,NumSerie,NumeroGuia,TipoGuia,CodArticulo,Cantidad,Precio,UnidadMedida,ImporteDetalle,Item,'0',descu,tipoigv , @codproveedor     
  from #det      
 end       
      
   exec InsertarGuiasOdooDmk    
      
 SELECT          
    1 AS CODIGO          
    ,'Registro Exitoso en DMK' AS MENSAJE        
      
 end try          
   BEGIN CATCH          
              
    SELECT          
    -1 AS CODIGO          
    ,ERROR_MESSAGE() AS MENSAJE          
              
    ROLLBACK          
   END CATCH          
   IF @@TRANCOUNT >0          
    COMMIT;          
               
end     
    

