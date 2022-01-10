--
-- Database: `pesos`
--


-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+01:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- --------------------------------------------------------

--
-- Struttura della tabella dei clienti
--

CREATE TABLE `customer` (
  `userId` varchar(12) NOT NULL,
  `customerName` varchar(30) NOT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `address` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Alcuni elementi inseriti direttamente di clienti
--

INSERT INTO `customer` (`userId`, `customerName`, `phoneNumber`, `address`) VALUES
('c001', 'Stefano', '+39034518232', 'Dalmine, Via Roma 5'),
('c002', 'Alessio', '+393314557894', 'Dalmine, Via Centro 3');

-- --------------------------------------------------------

--
-- Struttura della tabella degli impiegati
--

CREATE TABLE `employee` (
  `userId` varchar(12) NOT NULL,
  `employeeName` varchar(50) NOT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `role` varchar(8) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Alcuni elementi inseriti direttamente di impiegati
--

INSERT INTO `employee` (`userId`, `employeeName`, `phoneNumber`, `role`, `salary`) VALUES
('e001', 'Manager', '+39340955489', 'Manager', 50000.00),
('e002', 'Impiegato', '+39339445180', 'General', 30000.00);

-- --------------------------------------------------------

--
--  Struttura della tabella per il login
--

CREATE TABLE `login` (
  `userId` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Inserimento nella tabella per il login
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('e001', 'e001', 0),
('e002', 'e002', 0),
('c001', 'c001', 1),
('deba', 'aaaa', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella del cibo
--

CREATE TABLE `food` (
  `foodId` int(3) UNSIGNED ZEROFILL NOT NULL,
  `foodName` varchar(25) NOT NULL,
  `price` double(4,2) NOT NULL,
  `quantity` int(2) NOT NULL,
  `foodDescription` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserimento nella tabella per i panini
--

INSERT INTO `food` (`foodId`, `foodName`, `price`, `quantity` , `foodDescription`) VALUES
(101,'KingKong', 3.50, 7, 'Banana-bread alla nutella'),
(102, 'PolloPazzo', 3.00,8,  'Panino al pollo con salsa piccante'),
(103, 'Kebab', 5.00, 8, 'Panino con diversi tipi di carne e salse'),
(104, 'TripleUltraDelux', 7.00, 5, 'Panino con tre hamburger, formaggi e pomodoro'),
(105, 'Alpino', 3.00, 6, 'Pane e cotechino');

-- --------------------------------------------------------

--
-- Struttura della tabella delle bevande
--

CREATE TABLE `drink` (
  `drinkId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `drinkName` varchar(50) NOT NULL,
  `price` double(8,2) NOT NULL,
  `quantity` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserimento nella tabella per le bevande
--

INSERT INTO `drink` (`drinkId`, `drinkName`, `price`, `quantity`) VALUES
(201, 'PocaCola', 2.50, 2),
(202, 'Bebsi', 2.00, 10),
(203, 'Fanfa', 2.00, 10),
(204, 'Acqua', 0.50, 20),
(205, 'WinTHEr', 1.50, 15);

-- --------------------------------------------------------

--
-- Struttura della tabella degli acquisti
--

CREATE TABLE `purchaseinfo` (
  `purchaseId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `userId` varchar(12) NOT NULL,
  `productId` varchar(12) NOT NULL,
  `cost` double(12,2) UNSIGNED NOT NULL,
  `amount` int(8) UNSIGNED NOT NULL,
  `date` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserimento di alcuni acquisti
--

INSERT INTO `purchaseinfo` (`purchaseId`, `userId`, `productId`, `cost`, `amount`, `date`) VALUES
(00001, 'c002', '00101', 3.50, 1, '2021-12-26'),
(00002, 'c001', '00101', 7.00, 2, '2021-12-28'),
(00006, 'c001', '00203', 2.00, 1, '2021-12-28');

--
-- Indici per le dumped tables
--

--
-- Indici per la tabella dei clienti
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`userId`);

--
-- Indici per la tabella degli impiegati
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`userId`);

--
-- Indice per il login
--
ALTER TABLE `login`
  ADD UNIQUE KEY `userId` (`userId`),
  ADD UNIQUE KEY `userId_2` (`userId`);

--
-- Indice per i panini
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`foodId`);

--
-- Indice per le bibite
--
ALTER TABLE `drink`
  ADD PRIMARY KEY (`drinkId`);

--
-- Indice per gli acquisti
--
ALTER TABLE `purchaseinfo`
  ADD PRIMARY KEY (`purchaseId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `userId_2` (`userId`);

--
-- AUTO_INCREMENT per le dumped tables
--

--
-- AUTO_INCREMENT per la tabella dei panini
--
ALTER TABLE `food`
  MODIFY `foodId` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella dele bevande
--
ALTER TABLE `drink`
  MODIFY `drinkId` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella degli acquisti
--
ALTER TABLE `purchaseinfo`
  MODIFY `purchaseId` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;


--
-- Constraints per le dumped tables
--

--
-- Constraints per la tabella degli acquisti
--
ALTER TABLE `purchaseinfo`
  ADD CONSTRAINT `FK_PUR_CUS` FOREIGN KEY (`userId`) REFERENCES `purchaseinfo` (`userId`);
