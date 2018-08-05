/*
PROJETO INTERDISCIPLINAR 4 - FACCAMP 2017 - 7º SEMESTRE
CRIADO POR RAQUEL RA:21910 E NICHOLAS RA:21912

*********** SCRIPT DE INSERÇÃO DE DADOS NA TABELA ESTOQUE ***********
*/

INSERT INTO estoque (IdProduto, IdFornecedor, NomeProduto, NomeFantasia, Quantidade, Ativo) VALUES (00001, 00003, 'Acucar', 'Fornc C', 2, 1);
INSERT INTO estoque (IdProduto, IdFornecedor, NomeProduto, NomeFantasia, Quantidade, Ativo) VALUES (00015, 00003, 'Papel Higienico', 'Fornc C', 5, 1);
INSERT INTO estoque (IdProduto, IdFornecedor, NomeProduto, NomeFantasia, Quantidade, Ativo) VALUES (00005, 00001, 'Feijao', 'Fornc A', 10, 1);
INSERT INTO estoque (IdProduto, IdFornecedor, NomeProduto, NomeFantasia, Quantidade, Ativo) VALUES (00002, 00001, 'Sal', 'Fornc A', 6, 1);
INSERT INTO estoque (IdProduto, IdFornecedor, NomeProduto, NomeFantasia, Quantidade, Ativo) VALUES (00002, 00003, 'Sal', 'Fornc C', 2, 1);
INSERT INTO estoque (IdProduto, IdFornecedor, NomeProduto, NomeFantasia, Quantidade, Ativo) VALUES (00007, 00002, 'Suco', 'Fornc B', 2, 1);
INSERT INTO estoque (IdProduto, IdFornecedor, NomeProduto, NomeFantasia, Quantidade, Ativo) VALUES (00009, 00004, 'Sabonete', 'Fornc D', 30, 1);


start transaction;
	update estoque set quantidade = 4 where IdProduto = 1;
/*commit;*/
select * from estoque where idproduto = 2;

select * from estoque where IdProduto = 7 and IdFornecedor = 2;


SELECT 
    *
FROM
    ESTOQUE e
        INNER JOIN
    produto p ON p.IdProduto = e.IdProduto
        INNER JOIN
    fornecedor f ON f.IdFornecedor = e.IdFornecedor
ORDER BY e.IdProduto ASC;

SELECT * FROM FORNECEDOR;
SELECT * FROM PRODUTO;

DELETE FROM ESTOQUE WHERE idproduto = 7 AND idfornecedor = 2
