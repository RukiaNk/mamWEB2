use bd_web2;

DROP TABLE tb_cliente;

CREATE TABLE tb_estado (
id_estado int PRIMARY KEY AUTO_INCREMENT,
nome_estado VARCHAR(100),
sigla_estado CHAR(2) 
);   
   
INSERT INTO tb_estado (nome_estado, sigla_estado) VALUES
('Acre', 'AC'), ('Alagoas', 'AL'), ('Amapá', 'AP'), ('Amazonas', 'AM'),
('Bahia', 'BA'), ('Ceará', 'CE'), ('Distrito Federal', 'DF'), ('Espírito Santo', 'ES'),
('Goiás', 'GO'), ('Maranhão', 'MA'), ('Mato Grosso', 'MA'), ('Mato Grosso do Sul', 'MS'),
('Minas Gerais', 'MG'), ('Pará', 'PA'), ('Paraíba', 'PB'), ('Paraná', 'PR'),
('Pernambuco', 'PE'), ('Piauí', 'PI'), ('Rio de Janeiro', 'RJ'), ('Rio Grande do Norte', 'RN'),
('Rio Grande do Sul', 'RS'), ('Rondônia', 'RO'), ('Roraima', 'RR'), ('Santa Catarina', 'SC'),
('São Paulo', 'SP'), ('Sergipe', 'SE'), ('Tocantins', 'TO');

CREATE TABLE tb_cidade (
id_cidade int PRIMARY KEY AUTO_INCREMENT,
nome_cidade VARCHAR(100), 
id_estado int,
CONSTRAINT FOREIGN KEY (id_estado) REFERENCES tb_estado (id_estado));

INSERT INTO tb_cidade (nome_cidade, id_estado) VALUES
('Rio Branco', 1), ('Maceio', 2), ('Macapa', 3), ('Manaus', 4),
('Salvador', 5), ('Fortaleza', 6), ('Brasilia', 7), ('Vitoria', 8),
('Goiania', 9), ('Sao Luis', 10), ('Cuiaba', 11), ('Campo Grande', 12),
('Belo Horizonte', 13), ('Belem', 14), ('Joao Pessoa', 15), ('Curitiba', 16),
('Recife', 17), ('Teresina', 18), ('Rio de Janeiro', 19), ('Natal', 20),
('Porto Alegre', 21), ('Porto Velho', 22), ('Boa Vista', 23), ('Florianopolis', 24),
('São Paulo', 25), ('Aracaju', 26), ('Palmas', 27);

CREATE TABLE tb_cliente (
id_cliente int AUTO_INCREMENT PRIMARY KEY,
cpf_cliente char(11),
nome_cliente varchar(100),
email_cliente varchar(100),
data_cliente date,
rua_cliente varchar(100),
nr_cliente int,
cep_cliente char(8),
id_cidade int, 
CONSTRAINT FOREIGN KEY (id_cidade) REFERENCES tb_cidade (id_cidade));

INSERT INTO tb_cliente (nome_cliente, cpf_cliente, email_cliente, data_cliente, rua_cliente, nr_cliente, cep_cliente, id_cidade) VALUES
	('Paulo',  '48521687994', 'paulo@abc.com', '1990-08-12', 'Rua Do Paulo', 99, '21342454', 16),
    ('Joao',   '14123659748', 'joao@abc.com', '1989-07-05', 'Rua Do Joao', 99, '46791215', 16),
    ('Jose',   '48457545754', 'jose@abc.com', '1992-11-03', 'Rua Do Jose', 99, '87519425', 16),
    ('Maria',  '51276491376', 'maria@abc.com', '1991-04-01', 'Rua Da Maria', 99, '29461324', 19),
    ('Marcia', '16794521872', 'marcia@abc.com', '1992-04-30', 'Rua Da Marcia', 99, '84561279', 21),
    ('Joana',  '31679481275', 'joana@abc.com', '1997-05-19', 'Rua Da Joana', 99, '87963214', 12),
    ('Bruno',  '19764312754', 'bruno@abc.com', '1985-02-16', 'Rua Do Bruno', 99, '85213641', 15),
    ('Gabriela', '27542729252', 'gabriela@abc.com', '1982-03-13', 'Rua Da Gabriela', 99, '84512222', 12),
    ('Leticia',  '21679431679', 'leticia@abc.com', '1979-07-22', 'Rua Da Leticia', 99, '88745512', 18),
    ('Anderson', '15711112541', 'anderson@abc.com', '1980-01-21', 'Rua Do Anderson', 99, '98547112', 16);
    
CREATE TABLE tb_produto (
id_produto int PRIMARY KEY auto_increment, 
nome_produto VARCHAR(100));

INSERT INTO tb_produto (nome_produto) values
	('ProdA'), ('ProdB'), ('ProdC'), ('ProdD'), ('ProdE'), ('ProdF'); 

CREATE TABLE tb_tipo_atendimento (
id_tipo_atendimento int PRIMARY KEY auto_increment, 
nome_tipo_atendimento VARCHAR(50));

INSERT INTO tb_tipo_atendimento (nome_tipo_atendimento) values
	('Suporte'), ('Reclamacao'), ('Informativo');

CREATE TABLE tb_atendimento (
id_atendimento int PRIMARY KEY auto_increment, 
dt_hr_atendimento datetime, 
dsc_atendimento VARCHAR(255), 
id_produto int, 
id_tipo_atendimento int, 
id_usuario int,
id_cliente int,
res_atendimento CHAR(1),
CONSTRAINT FOREIGN KEY (id_produto) REFERENCES tb_produto (id_produto),
CONSTRAINT FOREIGN KEY (id_tipo_atendimento) REFERENCES tb_tipo_atendimento (id_tipo_atendimento),
CONSTRAINT FOREIGN KEY (id_usuario) REFERENCES tb_usuario (id_usuario),
CONSTRAINT FOREIGN KEY (id_cliente) REFERENCES tb_cliente (id_cliente));   


