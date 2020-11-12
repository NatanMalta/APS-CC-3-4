/**
 *
 * @author Murillo122
 */

create table TB_Endereco(
    ID_Endereco int primary key identity(1,1),
    Nm_Rua varchar (150),
    Nr_casa numeric(4),
    Nm_Bairro varchar (150),
    Nr_Cep varchar (9),
    Nm_Cidade varchar (150),
    Nm_Estado varchar (50),
    Us_Estado varchar (2),
    Nr_Lat varchar (12),
    Nr_Lon varchar (12)
);

create table TB_Cliente(
    ID_Cliente int primary key identity(1,1),
    Nm_Cliente varchar(150),
    Nr_Rg varchar (9),
    Nr_Cpf varchar(11),
    Nr_Tel varchar(11),
    Dt_Nascimento date,
    ID_Endereco int,
    foreign key (ID_Endereco) references TB_Endereco(ID_Endereco)

);


/*
create table TB_Empresa(
    ID_Empresa int primary key identity(1,1),
    Nm_Empresa varchar(150),
    Nr_Cnpj varchar(14),
    Nr_Tel varchar(11),
    ID_Endereco int,
    foreign key (ID_Endereco) references TB_Endereco(ID_Endereco)
);
*/

create table TB_Pedido(
    ID_Pedido int primary key identity(1000001,1),
    ID_Cliente int,
    --ID_Empresa int,
    foreign key (ID_Cliente) references TB_Cliente(ID_Cliente),
    --foreign key (ID_Empresa) references TB_Empresa(ID_Empresa)
);
