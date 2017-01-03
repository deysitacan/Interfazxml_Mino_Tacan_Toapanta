#Creacion de la base de datos para la ORGANIZADOR DE FACTURAS
create database Organizador_Facturas;
use Organizador_Facturas;

#CREAMOS LAS TABLAS DE LA BASE DE DATOS-------------------

-- Tabla Proveedor
Create table Proveedor (
	RUC_Proveedor Varchar(13) NOT NULL,
	Nombre_Proveedor Text NOT NULL,
	Direccion Text NOT NULL,
	Telefono varchar(10) NOT NULL,
 Primary Key (RUC_Proveedor)) ENGINE = MyISAM;
-- Tabla Comprador
Create table Comprador (
	RUCoCI_Comprador Varchar(13) NOT NULL,
	Nombre_Comprador Text NOT NULL,
	Email Text NOT NULL,
 Primary Key (RUCoCI_Comprador)) ENGINE = MyISAM;
 -- Tabla Tipo_Gasto
Create table Tipo_Gasto(
	Cod_Tipo_Gasto int NOT NULL AUTO_INCREMENT,
	Nombre_Tipo_Gasto text NOT NULL,
 Primary Key (Cod_Tipo_Gasto)) ENGINE = MyISAM;
-- Tabla Factura
Create table Factura (
	Cod_Factura Varchar(17) NOT NULL,
	Fecha_Factura date NOT NULL,
    Valor_Sin_IVA double NOT NULL,
    IVA float NOT NULL,
    Valor_Con_IVA double NOT NULL,
    RUC_Proveedor Varchar(13) NOT NULL,
    RUCoCI_Comprador Varchar(13) NOT NULL,
	Cod_Tipo_Gasto int NOT NULL,
 Primary Key (Cod_Factura,RUC_Proveedor)) ENGINE = MyISAM;
 
 -- /////////////////////////////////////////////////////// --
 -- Dependencia Foreign Key
 
 Alter table Factura add Foreign Key (RUC_Proveedor) 
 references Proveedor (RUC_Proveedor) on delete  restrict on update restrict;
 Alter table Factura add Foreign Key (RUCoCI_Comprador) 
 references Comprador (RUCoCI_Comprador) on delete  restrict on update restrict;
 Alter table Factura add Foreign Key (Cod_Tipo_Gasto) 
 references Tipo_Gasto (Cod_Tipo_Gasto) on delete  restrict on update restrict;
 
 


