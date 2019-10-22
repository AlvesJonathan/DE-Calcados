-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 15-Ago-2014 às 13:16
-- Versão do servidor: 5.5.36
-- PHP Version: 5.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sisvendas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

CREATE TABLE IF NOT EXISTS `caixa` (
  `CODIGO` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DINHEIRO` float NOT NULL DEFAULT '0',
  `CHEQUE` float NOT NULL DEFAULT '0',
  `CARTAO` float NOT NULL DEFAULT '0',
  `VALE` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`CODIGO`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `caixa`
--

INSERT INTO `caixa` (`CODIGO`, `DINHEIRO`, `CHEQUE`, `CARTAO`, `VALE`) VALUES
(1, 58.41, 8.65, 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) DEFAULT NULL,
  `ENDERECO` varchar(255) DEFAULT NULL,
  `BAIRRO` varchar(60) DEFAULT NULL,
  `CIDADE` varchar(60) DEFAULT NULL,
  `UF` varchar(2) DEFAULT NULL,
  `CEP` varchar(10) DEFAULT NULL,
  `TELEFONE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`CODIGO`, `NOME`, `ENDERECO`, `BAIRRO`, `CIDADE`, `UF`, `CEP`, `TELEFONE`) VALUES
(1, 'BALCAO', 'RUA 1', 'CENTRO', 'UBÁ', 'MG', '000', '0000000000'),
(2, 'JOÃO ALFREDO DA SILVA', 'RUA: PEDRO BOTARO, 100', 'CENTRO', 'UBÁ', 'MG', '36500-000', '(32) 3531-9999');

-- --------------------------------------------------------

--
-- Estrutura da tabela `contas`
--

CREATE TABLE IF NOT EXISTS `contas` (
  `PK_CODIGO` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FK_CODIGO_PESSOA` int(10) unsigned NOT NULL,
  `DESCRICAO` varchar(500) NOT NULL,
  `DATA` date DEFAULT NULL,
  `VENCIMENTO` date DEFAULT NULL,
  `PAGAMENTO` date DEFAULT NULL,
  `FK_TIPO_PAGAMENTO` int(10) unsigned NOT NULL DEFAULT '1',
  `OBSERVACAO` varchar(300) NOT NULL,
  `SITUACAO` tinyint(1) NOT NULL,
  `VALOR` float NOT NULL,
  `TIPO_CONTA` varchar(10) NOT NULL DEFAULT 'PAGAR',
  PRIMARY KEY (`PK_CODIGO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `contas`
--

INSERT INTO `contas` (`PK_CODIGO`, `FK_CODIGO_PESSOA`, `DESCRICAO`, `DATA`, `VENCIMENTO`, `PAGAMENTO`, `FK_TIPO_PAGAMENTO`, `OBSERVACAO`, `SITUACAO`, `VALOR`, `TIPO_CONTA`) VALUES
(1, 1, 'conta de luz', '2014-07-02', '2014-07-10', '2014-07-10', 1, '', 0, 40, 'PAGAR'),
(2, 1, 'conta de agua', '2014-07-02', '2014-07-10', '2014-07-10', 1, 'tste2', 1, 30.5, 'PAGAR'),
(3, 1, 'INTERNET OI VELOX', '2014-07-03', '2014-07-10', '2014-07-10', 1, 'CONTA DE INTERNET', 0, 84.89, 'PAGAR'),
(4, 1, 'Formatação de computador', '2014-07-03', '2014-07-10', '2014-07-10', 1, '', 1, 80, 'RECEBER'),
(5, 1, 'Cheque do cliente a ser descontado dia 15/06/2014', '2014-07-04', '2014-07-15', '2014-07-10', 3, 'teste', 0, 340, 'RECEBER');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedores`
--

CREATE TABLE IF NOT EXISTS `fornecedores` (
  `CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) DEFAULT NULL,
  `ENDERECO` varchar(255) DEFAULT NULL,
  `BAIRRO` varchar(60) DEFAULT NULL,
  `CIDADE` varchar(60) DEFAULT NULL,
  `UF` varchar(2) DEFAULT NULL,
  `CEP` varchar(10) DEFAULT NULL,
  `TELEFONE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `fornecedores`
--

INSERT INTO `fornecedores` (`CODIGO`, `NOME`, `ENDERECO`, `BAIRRO`, `CIDADE`, `UF`, `CEP`, `TELEFONE`) VALUES
(1, 'FD FORNECEDORES LTDA', 'RUA 2', 'CENTRO 2', 'UBÁ', 'MG', '234', '234234');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE IF NOT EXISTS `produtos` (
  `CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `FORNECEDORES_CODIGO` int(11) NOT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `VALOR` double DEFAULT NULL,
  `ESTOQUE` int(11) DEFAULT NULL,
  `CODIGO_BARRAS` varchar(100) DEFAULT '0',
  PRIMARY KEY (`CODIGO`),
  KEY `FK_produtos_1` (`FORNECEDORES_CODIGO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`CODIGO`, `FORNECEDORES_CODIGO`, `NOME`, `VALOR`, `ESTOQUE`, `CODIGO_BARRAS`) VALUES
(1, 1, 'Fubá Da Roça', 1.25, -2, '1'),
(2, 1, 'Arroz Tio João', 9.67, 88, '2'),
(3, 1, 'Fermento em Pó Bicalho', 3.5, 57, '3'),
(4, 1, 'Açucar União pacote 5kg', 6.4, 90, '4'),
(5, 1, 'Café Negão 500g', 5.8, 94, '5'),
(6, 1, 'Farinha de Trigo', 1, 29, '123456');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_usuarios`
--

CREATE TABLE IF NOT EXISTS `tbl_usuarios` (
  `pk_codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`pk_codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`pk_codigo`, `nome`, `login`, `senha`) VALUES
(1, 'ADMINISTRADOR', 'admin', '123'),
(2, 'ANA CAROLINA', 'ana', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_pagamento`
--

CREATE TABLE IF NOT EXISTS `tipo_pagamento` (
  `pk_codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`pk_codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `tipo_pagamento`
--

INSERT INTO `tipo_pagamento` (`pk_codigo`, `descricao`) VALUES
(1, 'DINHEIRO'),
(2, 'CARTÃO'),
(3, 'CHEQUE'),
(4, 'VALE');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas`
--

CREATE TABLE IF NOT EXISTS `vendas` (
  `CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `CLIENTES_CODIGO` int(11) NOT NULL,
  `DATA_VENDA` date DEFAULT NULL,
  `VALOR_TOTAL` float DEFAULT NULL,
  `DESCONTO` float DEFAULT NULL,
  `TIPO_PAGAMENTO` int(10) unsigned DEFAULT '1',
  PRIMARY KEY (`CODIGO`),
  KEY `FK_vendas_1` (`CLIENTES_CODIGO`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Extraindo dados da tabela `vendas`
--

INSERT INTO `vendas` (`CODIGO`, `CLIENTES_CODIGO`, `DATA_VENDA`, `VALOR_TOTAL`, `DESCONTO`, `TIPO_PAGAMENTO`) VALUES
(1, 1, '2014-05-10', 412, 0, 0),
(2, 1, '2014-06-29', 115.75, 0, 0),
(3, 1, '2014-07-01', 500, 0, 0),
(4, 1, '2014-07-01', 500, 500, 0),
(5, 1, '2014-07-01', 500, 500, 0),
(6, 1, '2014-07-01', 500, 500, 0),
(7, 1, '2014-07-02', 1.25, 0, 1),
(8, 1, '2014-07-04', 500, 500, 1),
(9, 1, '2014-07-05', 500, 500, 1),
(10, 1, '2014-07-05', 0, 0, 1),
(11, 1, '2014-07-05', 19.57, 0, 1),
(12, 1, '2014-07-05', 27.62, 0, 1),
(13, 1, '2014-07-05', 1, 0.25, 0),
(14, 1, '2014-07-05', 125, 0, 0),
(15, 1, '2014-07-05', 26.62, 0, 0),
(16, 1, '2014-07-06', 1.25, 0, 1),
(17, 1, '2014-07-06', 7.65, 0, 3),
(18, 1, '2014-07-06', 14.1, 0, 1),
(19, 1, '2014-07-06', 27.5, 0, 1),
(20, 2, '2014-07-06', 8.65, 0, 3),
(21, 1, '2014-07-06', 1.25, 0, 1),
(22, 1, '2014-07-06', 9, 0, 1),
(23, 1, '2014-07-06', 1.25, 0, 0),
(24, 1, '2014-07-06', 6.4, 0, 0),
(25, 1, '2014-07-06', 5.8, 0, 0),
(26, 1, '2014-07-06', 10.92, 0, 0),
(27, 1, '2014-07-06', 17.32, 0, 1),
(28, 1, '2014-07-06', 14.42, 0, 1),
(29, 1, '2014-07-21', 14.42, 0, 1),
(30, 1, '2014-08-08', 2, 0, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas_produto`
--

CREATE TABLE IF NOT EXISTS `vendas_produto` (
  `CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO_PRODUTO` int(11) DEFAULT NULL,
  `CODIGO_VENDA` int(11) DEFAULT NULL,
  `QUANTIDADE` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`),
  KEY `FK_vendas_produto_1` (`CODIGO_PRODUTO`),
  KEY `FK_vendas_produto_2` (`CODIGO_VENDA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=75 ;

--
-- Extraindo dados da tabela `vendas_produto`
--

INSERT INTO `vendas_produto` (`CODIGO`, `CODIGO_PRODUTO`, `CODIGO_VENDA`, `QUANTIDADE`) VALUES
(1, 1, 1, 3),
(2, 2, 1, 2),
(3, 1, 2, 1),
(4, 1, 2, 2),
(5, 3, 2, 32),
(10, 2, 4, 1),
(11, 3, 4, 1),
(12, 1, 4, 1),
(13, 4, 4, 1),
(14, 2, 5, 1),
(15, 1, 5, 1),
(16, 2, 6, 1),
(17, 3, 6, 1),
(18, 1, 7, 1),
(19, 2, 8, 1),
(20, 3, 8, 1),
(21, 4, 8, 1),
(22, 5, 8, 1),
(23, 1, 8, 1),
(24, 1, 9, 1),
(25, 2, 9, 1),
(26, 3, 9, 1),
(27, 4, 9, 1),
(28, 1, 9, 3),
(29, 1, 10, 1),
(30, 2, 11, 1),
(31, 3, 11, 1),
(32, 4, 11, 1),
(33, 1, 12, 1),
(34, 2, 12, 1),
(35, 3, 12, 1),
(36, 4, 12, 1),
(37, 5, 12, 1),
(38, 6, 12, 1),
(39, 1, 13, 1),
(40, 1, 14, 1),
(41, 1, 15, 1),
(42, 2, 15, 1),
(43, 3, 15, 1),
(44, 4, 15, 1),
(45, 5, 15, 1),
(46, 1, 16, 1),
(47, 1, 17, 1),
(48, 4, 17, 1),
(49, 1, 18, 2),
(50, 5, 18, 2),
(51, 1, 19, 1),
(52, 1, 19, 21),
(53, 1, 20, 1),
(54, 6, 20, 1),
(55, 4, 20, 1),
(56, 1, 21, 1),
(57, 6, 22, 2),
(58, 3, 22, 2),
(59, 1, 23, 1),
(60, 4, 24, 1),
(61, 5, 25, 1),
(62, 2, 26, 1),
(63, 1, 26, 1),
(64, 1, 27, 1),
(65, 2, 27, 1),
(66, 4, 27, 1),
(67, 1, 28, 1),
(68, 2, 28, 1),
(69, 3, 28, 1),
(70, 1, 29, 1),
(71, 2, 29, 1),
(72, 3, 29, 1),
(73, 1, 30, 1),
(74, 6, 30, 1);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `FK_produtos_1` FOREIGN KEY (`FORNECEDORES_CODIGO`) REFERENCES `fornecedores` (`CODIGO`);

--
-- Limitadores para a tabela `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `FK_vendas_1` FOREIGN KEY (`CLIENTES_CODIGO`) REFERENCES `clientes` (`CODIGO`);

--
-- Limitadores para a tabela `vendas_produto`
--
ALTER TABLE `vendas_produto`
  ADD CONSTRAINT `FK_vendas_produto_1` FOREIGN KEY (`CODIGO_PRODUTO`) REFERENCES `produtos` (`CODIGO`),
  ADD CONSTRAINT `FK_vendas_produto_2` FOREIGN KEY (`CODIGO_VENDA`) REFERENCES `vendas` (`CODIGO`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
