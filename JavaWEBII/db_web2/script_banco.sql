create database bd_web2;

use bd_web2;


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
values (1, '0994623192','ana', 'ana.nicole02@gmail.com', "2017-06-15", 'jose flores', '15', '8380000','Curitiba', 'PR');


CREATE TABLE tb_estado (
  id_estado int(2) unsigned zerofill NOT NULL AUTO_INCREMENT,
  sigla_estado varchar(10) NOT NULL DEFAULT '',
  nome_estado varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (id_estado)
);

CREATE TABLE tb_produto (
  id_produto int(11) NOT NULL AUTO_INCREMENT,
  nome_produto varchar(100) DEFAULT NULL,
  PRIMARY KEY (id_produto)
);

CREATE TABLE tb_cidade (
  id_cidade int(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
  id_estado int(2) unsigned zerofill NOT NULL DEFAULT '00',
  nome_cidade varchar(50) NOT NULL DEFAULT '',
  UNIQUE KEY idcidade (id_cidade),
  KEY idcidade2 (id_cidade)
);

CREATE TABLE tb_atendimento (
  id_atendimento int(11) NOT NULL AUTO_INCREMENT,
  dt_hr_atendimento datetime DEFAULT NULL,
  dsc_atendimento varchar(255) DEFAULT NULL,
  id_produto int(11) DEFAULT NULL,
  id_tipo_atendimento int(11) DEFAULT NULL,
  id_usuario int(11) DEFAULT NULL,
  id_cliente int(11) DEFAULT NULL,
  res_atendimento char(1) DEFAULT NULL,
  PRIMARY KEY (id_atendimento),
  KEY fkatid_produto (id_produto),
  KEY fkatid_tipo_atendimento (id_tipo_atendimento),
  KEY fkatid_usuario (id_usuario),
  KEY fkatid_cliente (id_cliente),
  CONSTRAINT fkatid_cliente FOREIGN KEY (id_cliente) REFERENCES tb_cliente (id_cliente),
  CONSTRAINT fkatid_produto FOREIGN KEY (id_produto) REFERENCES tb_produto (id_produto),
  CONSTRAINT fkatid_tipo_atendimento FOREIGN KEY (id_tipo_atendimento) REFERENCES tb_tipo_atendimento (id_tipo_atendimento),
  CONSTRAINT fkatid_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario (id_usuario)
);

CREATE TABLE tb_tipo_atendimento (
  id_tipo_atendimento int(11) NOT NULL,
  nome_tipo_atendimento varchar(50) DEFAULT NULL,
  PRIMARY KEY (id_tipo_atendimento)
);
