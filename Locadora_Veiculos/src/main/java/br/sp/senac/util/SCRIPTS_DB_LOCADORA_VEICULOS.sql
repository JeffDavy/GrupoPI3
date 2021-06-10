CREATE DATABASE locadora_veiculos;

USE locadora_veiculos;

CREATE TABLE Logins (
  codLogin INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  usuario VARCHAR(10) NOT NULL,
  senha VARCHAR(15) NOT NULL,
  tipo VARCHAR(1) NOT NULL,
  PRIMARY KEY(codLogin)
);

CREATE TABLE Veiculos (
  codVeiculo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  marca VARCHAR(10) NOT NULL,
  modelo VARCHAR(10) NOT NULL,
  ano INT NOT NULL,
  placa VARCHAR(7) NOT NULL,
  cor VARCHAR(10) NOT NULL,
  quilometragem BIGINT NOT NULL,
  valorVeiculo DOUBLE NOT NULL,
  PRIMARY KEY(codVeiculo)
);

CREATE TABLE Funcionarios (
  codFuncionario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Logins_codLogin INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(20) NOT NULL,
  email VARCHAR(30) NOT NULL,
  tipo VARCHAR(1) NOT NULL,
  estatus VARCHAR(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY(codFuncionario),
  FOREIGN KEY(Logins_codLogin)
    REFERENCES Logins(codLogin)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Clientes (
  codCliente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Logins_codLogin INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(20) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  dataNascimento VARCHAR(8) NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  email VARCHAR(30) NOT NULL,
  contato1 VARCHAR(11) NOT NULL,
  contato2 VARCHAR(11) NULL,
  rua VARCHAR(20) NOT NULL,
  numero INTEGER UNSIGNED NOT NULL,
  bairro VARCHAR(20) NOT NULL,
  cidade VARCHAR(20) NOT NULL,
  estado VARCHAR(2) NOT NULL,
  complemento VARCHAR(40) NULL,
  estatus varchar(1) not null default 'A',
  PRIMARY KEY(codCliente),
  FOREIGN KEY(Logins_codLogin)
    REFERENCES Logins(codLogin)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Financeiro (
  codFinanceiro INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Clientes_codCliente INTEGER UNSIGNED NOT NULL,
  valorPendente DOUBLE NOT NULL,
  valorPago DOUBLE NOT NULL,
  observacoes VARCHAR(50) NULL,
  PRIMARY KEY(codFinanceiro),
  FOREIGN KEY(Clientes_codCliente)
    REFERENCES Clientes(codCliente)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Locacoes (
  codLocacao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Veiculos_codVeiculo INTEGER UNSIGNED NOT NULL,
  Clientes_codCliente INTEGER UNSIGNED NOT NULL,
  Funcionarios_codFuncionario INTEGER UNSIGNED NOT NULL,
  filial VARCHAR(30) NOT NULL DEFAULT 'Matriz',
  marcaVeiculo VARCHAR(15) NOT NULL,
  modeloVeiculo VARCHAR(20) NOT NULL,
  anoVeiculo INTEGER UNSIGNED NOT NULL,
  placaVeiculo VARCHAR(7) NOT NULL,
  valorVeiculo DOUBLE NOT NULL,
  dataLocacao DATE NOT NULL,
  PRIMARY KEY(codLocacao),
  FOREIGN KEY(Clientes_codCliente)
    REFERENCES Clientes(codCliente)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Funcionarios_codFuncionario)
    REFERENCES Funcionarios(codFuncionario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Veiculos_codVeiculo)
    REFERENCES Veiculos(codVeiculo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Devolucoes (
  codDevolucao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Locacoes_codLocacao INTEGER UNSIGNED NOT NULL,
  Clientes_codCliente INTEGER UNSIGNED NOT NULL,
  dataDevolucao DATE NOT NULL,
  observacoesCarro VARCHAR(50) NOT NULL,
  multas DOUBLE NULL,
  valorCobranca DOUBLE NOT NULL,
  PRIMARY KEY(codDevolucao),
  FOREIGN KEY(Clientes_codCliente)
    REFERENCES Clientes(codCliente)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Locacoes_codLocacao)
    REFERENCES Locacoes(codLocacao)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

select * from Locacoes;
select * from Devolucoes;
select * from Logins;
select * from Clientes;

select * from Funcionarios;
select * from Veiculos;



insert into Logins (usuario, senha, perfil) values ("Cleber", "1234", "GERENTE");

select * from Logins where usuario = "Cleber";


alter table Logins add column filial varchar(35);

alter table Logins modify column senha varchar(200);

ALTER TABLE Logins
CHANGE tipo perfil VARCHAR(20);

update Logins set senha= '$2a$12$zHJb/aPSbMxCyoDn8l1AQ.yTKJKgEbXiZ3y25PmvU0OrNropd45wy';