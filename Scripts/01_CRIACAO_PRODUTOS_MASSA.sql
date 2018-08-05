/*
PROJETO INTERDISCIPLINAR 4 - FACCAMP 2017 - 7º SEMESTRE
CRIADO POR RAQUEL RA:21910 E NICHOLAS RA:21912

*********** SCRIPT DE INSERÇÃO DE PRODUTOS NA TABELA PRODUTO ***********
*/

INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00001, 78965, 'Acucar', '2.59','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00002, 45487, 'Sal', '3.89','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00003, 65621, 'Oleo', '2.59','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00004, 91657, 'Arroz', '14.99','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00005, 78465, 'Feijao', '6.99','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00006, 48854, 'Macarrao', '1.79','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00007, 35124, 'Suco', '1.69','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00008, 78476, 'Refrigerante', '7.69','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00009, 78475, 'Sabonete', '0.99','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00010, 96455, 'Shampoo', '7.99','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00011, 54444, 'Cotonete', '2.99','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00012, 15354, 'Barra de Chocolate', '5.99','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00013, 51623, 'Torrada', '4.59','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00014, 75411, 'Bolacha', '3.59','15060000');
INSERT INTO PRODUTO (IdProduto, CodBarras, Nome, PrecoVenda, NCM) VALUES (00015, 89995, 'Papel Higienico', '22.99','15060000');

select * from produto where IdProduto = 3;

show tables;
desc estoque;
desc produto;

select ncm from produto where IdProduto=00001;