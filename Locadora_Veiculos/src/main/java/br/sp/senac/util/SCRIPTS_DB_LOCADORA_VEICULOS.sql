CREATE DATABASE locadora_veiculos;

USE locadora_veiculos;

CREATE TABLE Enderecos (
  codEndereco INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  rua VARCHAR(15) NOT NULL,
  numero INTEGER UNSIGNED NOT NULL,
  bairro VARCHAR(15) NOT NULL,
  cidade VARCHAR(15) NOT NULL,
  estado VARCHAR(2) NOT NULL,
  complmento VARCHAR(30) NULL,
  PRIMARY KEY(codEndereco)
);

CREATE TABLE Logins (
  codLogin INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  usuario VARCHAR(10) NOT NULL,
  senha VARCHAR(15) NOT NULL,
  statusLogin TINYINT UNSIGNED NOT NULL,
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

select * from Veiculos where codVeiculo = 1;


CREATE TABLE Funcionarios (
  codFuncionario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Logins_codLogin INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(20) NOT NULL,
  email VARCHAR(30) NOT NULL,
  statusFuncionario TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY(codFuncionario),
  FOREIGN KEY(Logins_codLogin)
    REFERENCES Logins(codLogin)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Clientes (
  codClientes INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Enderecos_codEndereco INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(20) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  dataNascimento DATE NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  email VARCHAR(30) NOT NULL,
  contato1 VARCHAR(11) NOT NULL,
  contato2 VARCHAR(11) NULL,
  statusClientes TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY(codClientes),
  FOREIGN KEY(Enderecos_codEndereco)
    REFERENCES Enderecos(codEndereco)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Financeiro (
  codFinanceiro INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Clientes_codClientes INTEGER UNSIGNED NOT NULL,
  valorPendente DOUBLE NOT NULL,
  valorPago DOUBLE NOT NULL,
  observacoes VARCHAR(50) NULL,
  PRIMARY KEY(codFinanceiro),
  FOREIGN KEY(Clientes_codClientes)
    REFERENCES Clientes(codClientes)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Locacoes (
  codLocacao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Funcionarios_codFuncionario INTEGER UNSIGNED NOT NULL,
  Clientes_codClientes INTEGER UNSIGNED NOT NULL,
  dataLocacao DATE NOT NULL,
  valorTotal DOUBLE NOT NULL,
  dataDevolucao DATE NOT NULL,
  nomeResponsavel VARCHAR(20) NOT NULL,
  cpfResponsavel VARCHAR(11) NOT NULL,
  dataNascimento DATE NOT NULL,
  PRIMARY KEY(codLocacao),
  FOREIGN KEY(Clientes_codClientes)
    REFERENCES Clientes(codClientes)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Funcionarios_codFuncionario)
    REFERENCES Funcionarios(codFuncionario)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Devolucoes (
  codDevolucao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Clientes_codClientes INTEGER UNSIGNED NOT NULL,
  dataDevolucao DATE NOT NULL,
  observacoesCarro VARCHAR(50) NOT NULL,
  multas DOUBLE NULL,
  valorCobranca DOUBLE NOT NULL,
  PRIMARY KEY(codDevolucao),
  FOREIGN KEY(Clientes_codClientes)
    REFERENCES Clientes(codClientes)
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

