/*
PROJETO INTERDISCIPLINAR 4 - FACCAMP 2017 - 7º SEMESTRE
CRIADO POR RAQUEL RA:21910 E NICHOLAS RA:21912

*********** SCRIPT DE INSERÇÃO DE FORNECEDORES NA TABELA FORNECEDOR ***********
*/

INSERT INTO FORNECEDOR (IdFornecedor, CNPJ, RazaoSocial, NomeFantasia, Bairro, Cidade, Estado, CEP) VALUES (00001, '13219435000123', 'Fornecedor A', 'Fornc A','Vila Comercial', 'Sao Paulo','SP','13219360');
INSERT INTO FORNECEDOR (IdFornecedor, CNPJ, RazaoSocial, NomeFantasia, Bairro, Cidade, Estado, CEP) VALUES (00002, '43249468000121', 'Fornecedor B', 'Fornc B','Vila Mariana', 'Sao Paulo','SP','16432900');
INSERT INTO FORNECEDOR (IdFornecedor, CNPJ, RazaoSocial, NomeFantasia, Bairro, Cidade, Estado, CEP) VALUES (00003, '43567876000111', 'Fornecedor C', 'Fornc C','Cidade Nova', 'Jundiai','SP','43214888');
INSERT INTO FORNECEDOR (IdFornecedor, CNPJ, RazaoSocial, NomeFantasia, Bairro, Cidade, Estado, CEP) VALUES (00004, '98234543000122', 'Fornecedor D', 'Fornc D','Caxambu', 'Jundiai','SP','55229330');
INSERT INTO FORNECEDOR (IdFornecedor, CNPJ, RazaoSocial, NomeFantasia, Bairro, Cidade, Estado, CEP) VALUES (00004, '98234543000122', 'Fornecedor D', 'Fornc D','Caxambu', 'Jundiai','SP','55229330');


select * from FORNECEDOR where IdFornecedor = 5;

START TRANSACTION;
SET @IDFORNECEDOR = 7; 
DELETE FROM fornecedor WHERE NOT EXISTS (
	SELECT * FROM estoque inner join fornecedor f on (estoque.IdFornecedor = f.IdFornecedor and estoque.IdFornecedor = @IDFORNECEDOR)    
ROLLBACK;