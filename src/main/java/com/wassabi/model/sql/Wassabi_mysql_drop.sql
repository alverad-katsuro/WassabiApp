ALTER TABLE `Produto` DROP FOREIGN KEY `Produto_fk0`;

ALTER TABLE `Endereco` DROP FOREIGN KEY `Endereco_fk0`;

ALTER TABLE `Venda` DROP FOREIGN KEY `Venda_fk0`;

ALTER TABLE `venda_has_produto` DROP FOREIGN KEY `venda_has_produto_fk0`;

ALTER TABLE `venda_has_produto` DROP FOREIGN KEY `venda_has_produto_fk1`;

ALTER TABLE `Cartao` DROP FOREIGN KEY `Cartao_fk0`;

DROP TABLE Cartao;
DROP TABLE Endereco;
DROP TABLE venda_has_produto;
DROP TABLE Venda;
DROP TABLE Produto;
DROP TABLE Categoria;