/* Lógico_projeto49: */
create database crud_projeto_squad;
use crud_projeto_squad;

CREATE TABLE usuario (
	id int auto_increment PRIMARY KEY,
	nome varchar(50),
	cpf varchar(11) unique,
	sexo varchar(1),
	email varchar(50),
	senha varchar(20),
    endereco varchar(50),
    complemento varchar(50),
    cidade varchar(50),
	estado varchar(30),
    cep varchar(10),
    tipo_usuario varchar(50)
);

CREATE TABLE duvidas (
    assunto varchar(100),
    mensagem varchar(2000),
    nome varchar(50),
    email varchar(50),
    id_duvida int auto_increment PRIMARY KEY
);

CREATE TABLE requests (
    id int auto_increment PRIMARY KEY,
    equip varchar(50),
    relato varchar(500),
    fk_usuario_cpf varchar(11)
   
);

CREATE TABLE doacao (
    nome varchar(50),
    email varchar(50),
    quantia varchar(30),
    id_doacao int auto_increment PRIMARY KEY
);
 
ALTER TABLE requests ADD CONSTRAINT FK_requests_2
    FOREIGN KEY (fk_usuario_cpf)
    REFERENCES usuario (cpf)
    ON DELETE RESTRICT;
    
    select * from  usuario;