CREATE DATABASE livraria;
USE livraria;

CREATE TABLE clientes (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
    cpf CHAR(11) NOT NULL,
    nascimento DATE NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    endereco VARCHAR(100),
    estado_civil TINYINT NOT NULL,
    escolaridade TINYINT,
    CONSTRAINT  UC_CPF UNIQUE (cpf),
    CONSTRAINT  UC_EMAIL UNIQUE (email)
);