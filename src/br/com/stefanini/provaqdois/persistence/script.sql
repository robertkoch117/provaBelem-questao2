CREATE DATABASE bdquestao2;

USE bdquestao2;

DROP TABLE cliente;

CREATE TABLE cliente(idCliente int PRIMARY KEY auto_increment,
					nome VARCHAR(50),
					email VARCHAR(50),
					senha VARCHAR(50));
					
INSERT INTO cliente VALUES (100, 'perfil um', 'ativo');


SELECT u.id, u.nome, u.email, u.senha, c.status, v.comissao FROM 
usuario u LEFT JOIN cliente c on u.id = c.idCliente
LEFT JOIN vendedor v on u.id = v.idVendedor;

select u.id, u.nome, u.email, u.senha, c.status, c.perfil from usuario u left join cliente c on u.id = c.idCliente where c.status="ativo";