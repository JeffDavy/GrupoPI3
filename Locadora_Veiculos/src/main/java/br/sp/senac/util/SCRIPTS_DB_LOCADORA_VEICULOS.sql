CREATE DATABASE locadora_veiculos;

USE locadora_veiculos;

CREATE TABLE Logins (
  codLogin INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  usuario VARCHAR(10) NOT NULL UNIQUE,
  senha VARCHAR(15) NOT NULL,
  tipo VARCHAR(1) NOT NULL,
  statusLogin TINYINT UNSIGNED NOT NULL DEFAULT 1,
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
  revisao TINYINT UNSIGNED NOT NULL,
  valorVeiculo DOUBLE NOT NULL,
  statusVeiculo TINYINT UNSIGNED NOT NULL DEFAULT 1,
  PRIMARY KEY(codVeiculo)
);

CREATE TABLE Funcionarios (
  codFuncionario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Logins_codLogin INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(20) NOT NULL,
  email VARCHAR(30) NOT NULL,
  tipo VARCHAR(1) NULL,
  statusFuncionario TINYINT UNSIGNED NOT NULL DEFAULT 1,
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
  cpf VARCHAR(11) NOT NULL UNIQUE,
  dataNascimento DATE NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  email VARCHAR(30) NOT NULL,
  contato1 VARCHAR(11) NOT NULL,
  contato2 VARCHAR(11) NULL,
  statusClientes TINYINT UNSIGNED NOT NULL DEFAULT 1,
  rua VARCHAR(20) NULL,
  numero INTEGER UNSIGNED NULL,
  bairro VARCHAR(20) NULL,
  cidade VARCHAR(20) NULL,
  estado VARCHAR(2) NULL,
  complemento VARCHAR(40) NULL,
  PRIMARY KEY(codCliente),
  FOREIGN KEY(Logins_codLogin)
    REFERENCES Logins(codLogin)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

select * from Funcionarios;

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
  Funcionarios_codFuncionario INTEGER UNSIGNED NOT NULL,
  Clientes_codCliente INTEGER UNSIGNED NOT NULL,
  dataLocacao DATE NOT NULL,
  valorTotal DOUBLE NOT NULL,
  dataDevolucao DATE NOT NULL,
  nomeResponsavel VARCHAR(20) NOT NULL,
  cpfResponsavel VARCHAR(11) NOT NULL,
  dataNascimento DATE NOT NULL,
  PRIMARY KEY(codLocacao),
  FOREIGN KEY(Clientes_codCliente)
    REFERENCES Clientes(codCliente)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Funcionarios_codFuncionario)
    REFERENCES Funcionarios(codFuncionario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Devolucoes (
  codDevolucao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Clientes_codCliente INTEGER UNSIGNED NOT NULL,
  dataDevolucao DATE NOT NULL,
  observacoesCarro VARCHAR(50) NOT NULL,
  multas DOUBLE NULL,
  valorCobranca DOUBLE NOT NULL,
  PRIMARY KEY(codDevolucao),
  FOREIGN KEY(Clientes_codCliente)
    REFERENCES Clientes(codCliente)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Item_Locacao (
  codItem_Locacao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Veiculos_codVeiculo INTEGER UNSIGNED NOT NULL,
  Locacoes_codLocacao INTEGER UNSIGNED NOT NULL,
  valorVeiculo DOUBLE NOT NULL,
  marcaVeiculo VARCHAR(10) NOT NULL,
  modeloVeiculo VARCHAR(10) NOT NULL,
  placaVeiculo VARCHAR(7) NOT NULL,
  PRIMARY KEY(codItem_Locacao),
  FOREIGN KEY(Locacoes_codLocacao)
    REFERENCES Locacoes(codLocacao)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Veiculos_codVeiculo)
    REFERENCES Veiculos(codVeiculo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

