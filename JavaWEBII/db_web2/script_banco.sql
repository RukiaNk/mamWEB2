create database bd_web2;

use bd_web2;

drop table tb_usuario;

CREATE TABLE tb_usuario (
  id_usuario int(11) NOT NULL AUTO_INCREMENT,
  login_usuario varchar(50) DEFAULT NULL,
  senha_usuario varchar(50) DEFAULT NULL,
  nome_usuario varchar(100) DEFAULT NULL,
  PRIMARY KEY (id_usuario)
);

insert into tb_usuario
values (1, 'ana', 'ana', 'Ana'),
(2, 'marcos', 'marcos', 'marcos'),
(3, 'michelly', 'michelly', 'michelly');

CREATE TABLE tb_cliente (
   id_cliente int, 
   cpf_cliente CHAR(11),
   nome_cliente VARCHAR(100), 
	email_cliente VARCHAR(100), 
	data_cliente DATE, 
	rua_cliente VARCHAR(100),
   nr_cliente INTEGER, 
   cep_cliente CHAR(8), 
   cidade_cliente VARCHAR(100), 
   uf_cliente CHAR(2),
  PRIMARY KEY (id_cliente)
);

insert into tb_cliente
values (1, '0994623192','ana', 'ana.nicole02@gmail.com', "2017-06-15", 'jose flores', '15', '8380000','Curitiba', 'PR')