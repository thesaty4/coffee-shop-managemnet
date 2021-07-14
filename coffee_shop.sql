-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2021 at 08:07 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffee_shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `customer_id` int(11) DEFAULT NULL,
  `coffee_name` varchar(50) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`customer_id`, `coffee_name`, `quantity`) VALUES
(19, 'americano', 12),
(20, 'cafe latte', 1),
(21, 'cafee au lait', 2),
(23, 'caramel macchiato', 1);

-- --------------------------------------------------------

--
-- Table structure for table `coffee_info`
--

CREATE TABLE `coffee_info` (
  `coffee_name` varchar(50) NOT NULL,
  `price` float DEFAULT NULL,
  `cur_date` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coffee_info`
--

INSERT INTO `coffee_info` (`coffee_name`, `price`, `cur_date`) VALUES
('affogato', 143.1, '2021-04-02'),
('americano', 120, '2021-04-02'),
('cafe latte', 190, '2021-04-02'),
('cafe mocha', 190, '2021-04-02'),
('cafee au lait', 123, '2021-04-02'),
('cappuccino', 233, '2021-04-02'),
('caramel macchiato', 150, '2021-04-02'),
('cofe cubano', 122, '2021-04-02'),
('cortado', 222, '2021-04-02'),
('espresso', 189, '2021-04-02'),
('frappuccino', 80.3, '2021-04-02'),
('iced coffee', 122, '2021-04-02'),
('irish coffee', 134, '2021-04-02'),
('plain coffee', 122, '2021-04-02'),
('turkish coffee', 112, '2021-04-02');

-- --------------------------------------------------------

--
-- Table structure for table `customer_info`
--

CREATE TABLE `customer_info` (
  `customer_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `total_pay` int(11) DEFAULT NULL,
  `purchase_date` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_info`
--

INSERT INTO `customer_info` (`customer_id`, `name`, `gender`, `mobile`, `total_pay`, `purchase_date`) VALUES
(17, 'satya', 'male', '1234567890', 143, '2021-04-04'),
(18, 'dipankar', 'male', '1234567890', 143, '2021-04-04'),
(19, 'asif', 'male', '1234567890', 1440, '2021-04-04'),
(20, 'amisha', 'female', '1234567890', 190, '2021-04-04'),
(21, 'justin', 'male', '0987654321', 246, '2021-04-04'),
(23, 'arif', 'male', '456789220', 150, '2021-04-04');

-- --------------------------------------------------------

--
-- Table structure for table `login_info`
--

CREATE TABLE `login_info` (
  `usr_name` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `mobile` varchar(14) DEFAULT NULL,
  `passwd` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login_info`
--

INSERT INTO `login_info` (`usr_name`, `name`, `gender`, `email`, `address`, `mobile`, `passwd`) VALUES
('theasif', 'md.asif', 'male', 'asif@gmail.com', 'gorakhpur', '1245389098', '123'),
('thesatya', 'satya mishra', 'male', 'satyamishra@gmail.com', 'khalilabad', '9120829055', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `coffee_name` (`coffee_name`);

--
-- Indexes for table `coffee_info`
--
ALTER TABLE `coffee_info`
  ADD PRIMARY KEY (`coffee_name`);

--
-- Indexes for table `customer_info`
--
ALTER TABLE `customer_info`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `login_info`
--
ALTER TABLE `login_info`
  ADD PRIMARY KEY (`usr_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_info`
--
ALTER TABLE `customer_info`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer_info` (`customer_id`),
  ADD CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`coffee_name`) REFERENCES `coffee_info` (`coffee_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
