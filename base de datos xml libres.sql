#Creacion de la base de datos para la ORGANIZADOR DE FACTURAS
create database Organizador_Facturas;
use Organizador_Facturas;

#CREAMOS LAS TABLAS DE LA BASE DE DATOS-------------------

-- Tabla Proveedor
Create table Proveedor (
	RUC_Proveedor Varchar(13) NOT NULL,
	Nombre_Proveedor Text NOT NULL,
 Primary Key (RUC_Proveedor)) ENGINE = MyISAM;
-- Tabla Comprador
Create table Comprador (
	RUCoCI_Comprador Varchar(13) NOT NULL,
	Nombre_Comprador Text NOT NULL,
    Direccion_Comprador Text NOT NULL,
    Telefono_Comprador Varchar(10) NOT NULL,
 Primary Key (RUCoCI_Comprador)) ENGINE = MyISAM;
-- Tabla Factura
Create table Factura (
	Cod_Factura Varchar(17) NOT NULL,
	Fecha_Factura date NOT NULL,
    Valor_Sin_IVA double NOT NULL,
    IVA float NOT NULL,
    Valor_Con_IVA double NOT NULL,
    RUC_Proveedor Varchar(13) NOT NULL,
    RUCoCI_Comprador Varchar(13) NOT NULL,
 Primary Key (Cod_Factura,RUC_Proveedor)) ENGINE = MyISAM;
 -- Tabla Producto
Create table Producto (
	Cod_Producto Varchar(17) NOT NULL,
	Nombre_Producto text NOT NULL,
 Primary Key (Cod_Producto)) ENGINE = MyISAM;
 -- Tabla Detalle
Create table Detalle (
	Detalle_Factura text not null,
    Cantidad_Comprada float not null,
    Precio_Unitario double not null,
    Valor_Producto double not  null,
    Cod_Factura Varchar(17) NOT NULL,
    RUC_Proveedor Varchar(13) NOT NULL,
    Cod_Producto Varchar(17) NOT NULL,
 Primary Key (Cod_Factura,RUC_Proveedor,Cod_Producto)) ENGINE = MyISAM;
 
 -- /////////////////////////////////////////////////////// --
 -- Dependencia Foreign Key 
 
 Alter table Factura add Foreign Key (RUC_Proveedor) 
 references Proveedor (RUC_Proveedor) on delete  restrict on update restrict;
 Alter table Factura add Foreign Key (RUCoCI_Comprador) 
 references Comprador (RUCoCI_Comprador) on delete  restrict on update restrict;
 Alter table Detalle add Foreign Key (Cod_Factura,RUC_Proveedor) 
 references Factura (Cod_Factura,RUC_Proveedor) on delete  restrict on update restrict;
 Alter table Detalle add Foreign Key (Cod_Producto) 
 references Producto (Cod_Producto) on delete  restrict on update restrict;
 
 


