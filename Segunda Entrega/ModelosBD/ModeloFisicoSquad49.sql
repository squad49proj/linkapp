create database crud_projeto_squad;
use crud_projeto_squad;

ALTER SCHEMA `crud_projeto_squad`  DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE usuario (
	`id` int auto_increment PRIMARY KEY,
	`nome` varchar(50) not null,
	`cpf` varchar(11) not null unique,
	`sexo` varchar(10) not null,
	`email` varchar(50) not null,
	`senha` varchar(20) not null,
    `endereco` varchar(50) not null,
    `complemento` varchar(50) not null,
    `cidade` varchar(50) not null,
	`estado` varchar(30) not null,
    `cep` varchar(10) not null,
    `tipo_usuario` varchar(50) not null
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
    nome varchar(50) not null,
    equip varchar(50) not null,
    relato varchar(500) not null,
    cpf varchar(11)
);

CREATE TABLE doacao (
    nome varchar(50),
    email varchar(50),
    quantia varchar(30),
    id_doacao int auto_increment PRIMARY KEY
);
    
ALTER TABLE requests ADD CONSTRAINT fk_cpf_1 FOREIGN KEY (cpf) REFERENCES usuario (cpf);

INSERT INTO `usuario` VALUES (null, 'Rodrigo', '45544', 'masculino', 'rod@gmail', 'dwdadd', 'rua 7', 'casa 40', 'fortaleza', 'CE', '45546', 'Doador');
INSERT INTO `usuario` VALUES (null, 'Jonas', '45568', 'masculino', 'rod@gmail', 'dwdadd', 'rua 7', 'casa 40', 'fortaleza', 'CE', '45546', 'Doador');
INSERT INTO `requests` VALUES (null, 'Felipe', 'Notebook', 'Olá, meu nome é Felipe. Sou estudante de administração na UFC e preciso de um notebook para estudar.', '45544');


select * from requests;

select * from usuario;
