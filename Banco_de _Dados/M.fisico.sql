create database proj;
use proj;
CREATE TABLE Cliente (
    id_cliente int primary key not null auto_increment,
	Nome VARCHAR(50),
    Telefone VARCHAR(50),
	Email VARCHAR(50)
);
CREATE TABLE Destino (
    id_destino int primary key not null auto_increment,
    Nome VARCHAR(50),
    imagem longblob,
    valor decimal(10,2)
);

CREATE TABLE Pacote (
    id_pacote int primary key not null auto_increment,
    Nome VARCHAR(50),
    valor decimal(10,2)
);

CREATE TABLE Reserva (
	id_reserva int primary key not null auto_increment,
    id_cliente int,
    id_destino int,
    id_pacote int,
    data_reserva date,
    valor decimal(10,2)
);

alter table Reserva add foreign key(id_cliente) references Cliente(id_cliente);
alter table Reserva add foreign key(id_destino) references Destino(id_destino);
alter table Reserva add foreign key(id_pacote) references Pacote(id_pacote);


INSERT INTO cliente(Nome,Telefone, Email) VALUES ("Diego", "(55)1234-5678", "Diego@email");
INSERT INTO cliente(Nome,Telefone, Email) VALUES ("Ana", "(52)****-****", "Ana@email");
INSERT INTO cliente(Nome,Telefone, Email) VALUES ("Bia", "(00)9876-5432", "Bia@email");

INSERT INTO destino(Nome,valor) VALUES ("João Pessoa", "1000.00");
INSERT INTO destino(Nome, valor) VALUES ("Paris", "32000.00");
INSERT INTO destino(Nome, valor) VALUES ("parnaiba", "1000.00");
INSERT INTO destino(Nome, valor) VALUES ("Salvador", "3200.00");

INSERT INTO Pacote(nome, valor) VALUES ("VIP", 1500.23);
INSERT INTO Pacote(nome, valor) VALUES ("ECONOMICA", 450.25);
INSERT INTO Pacote(nome, valor) VALUES ("Ouro", 1500.23);
INSERT INTO Pacote(nome, valor) VALUES ("classe media", 450.25);

INSERT INTO reserva (id_cliente,id_destino,id_pacote,data_reserva,Valor ) values (1,2,2,'2023-02-25',339.01);

select * from reserva ;
select * from cliente ;
select * from destino ;
select * from pacote ;

