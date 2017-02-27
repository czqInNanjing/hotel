-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Feb 27, 2017 at 04:55 PM
-- Server version: 5.5.42
-- PHP Version: 5.6.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--
CREATE DATABASE IF NOT EXISTS `hotel` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `hotel`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `mail` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `type` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `mail`, `password`, `type`) VALUES
(1, 'master@qq.com', '123456', 2),
(2, 'hotel@qq.com', '123456', 1),
(12, 'czqofnju@hello.com', '123456', 0);

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_bin DEFAULT 'HOTEL',
  `address` varchar(50) COLLATE utf8_bin DEFAULT 'Nanjing',
  `status` tinyint(1) DEFAULT '0',
  `description` text COLLATE utf8_bin
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `hotel_new`
--

DROP TABLE IF EXISTS `hotel_new`;
CREATE TABLE `hotel_new` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_bin DEFAULT 'HOTEL',
  `address` varchar(50) COLLATE utf8_bin DEFAULT 'Nanjing',
  `status` tinyint(1) DEFAULT '0',
  `description` text COLLATE utf8_bin
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `live_mes`
--

DROP TABLE IF EXISTS `live_mes`;
CREATE TABLE `live_mes` (
  `id` int(11) NOT NULL,
  `in_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `out_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `person_num` int(11) NOT NULL DEFAULT '1',
  `person_mes` text COLLATE utf8_bin,
  `pay_method` int(11) NOT NULL DEFAULT '0',
  `member_id` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT 'Customer',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `remain_days` int(11) NOT NULL DEFAULT '0',
  `deposit` int(11) NOT NULL DEFAULT '0',
  `points` int(11) NOT NULL DEFAULT '0',
  `regist_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `credit_card` varchar(6000) COLLATE utf8_bin NOT NULL DEFAULT '''Not any'''
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `name`, `status`, `remain_days`, `deposit`, `points`, `regist_date`, `credit_card`) VALUES
(12, 'Smith', 0, 0, 0, 0, '2017-02-26 09:21:23', '');

-- --------------------------------------------------------

--
-- Table structure for table `modify_application`
--

DROP TABLE IF EXISTS `modify_application`;
CREATE TABLE `modify_application` (
  `id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hotel_id` int(20) DEFAULT NULL,
  `new_hotel_id` int(20) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `open_application`
--

DROP TABLE IF EXISTS `open_application`;
CREATE TABLE `open_application` (
  `id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hotel_id` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `reason` text COLLATE utf8_bin
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `pay_record`
--

DROP TABLE IF EXISTS `pay_record`;
CREATE TABLE `pay_record` (
  `id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bill` int(11) DEFAULT NULL,
  `live_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `recharge`
--

DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge` (
  `id` int(11) NOT NULL,
  `time` date NOT NULL,
  `member_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `former` int(11) DEFAULT NULL,
  `later` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `reserved`
--

DROP TABLE IF EXISTS `reserved`;
CREATE TABLE `reserved` (
  `id` int(11) NOT NULL,
  `room_id` int(11) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
CREATE TABLE `rooms` (
  `id` int(11) NOT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `available_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `wifi` tinyint(1) DEFAULT '1',
  `pic_url` text COLLATE utf8_bin,
  `type` int(11) NOT NULL DEFAULT '0',
  `price` int(11) NOT NULL DEFAULT '100'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hotel_new`
--
ALTER TABLE `hotel_new`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `live_mes`
--
ALTER TABLE `live_mes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `member_id` (`member_id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `modify_application`
--
ALTER TABLE `modify_application`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hotel_id` (`hotel_id`),
  ADD KEY `new_hotel_id` (`new_hotel_id`);

--
-- Indexes for table `open_application`
--
ALTER TABLE `open_application`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hotel_id` (`hotel_id`);

--
-- Indexes for table `pay_record`
--
ALTER TABLE `pay_record`
  ADD PRIMARY KEY (`id`),
  ADD KEY `live_id` (`live_id`);

--
-- Indexes for table `recharge`
--
ALTER TABLE `recharge`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reserved`
--
ALTER TABLE `reserved`
  ADD PRIMARY KEY (`id`),
  ADD KEY `room_id` (`room_id`),
  ADD KEY `member_id` (`member_id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `hotel_new`
--
ALTER TABLE `hotel_new`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `live_mes`
--
ALTER TABLE `live_mes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `modify_application`
--
ALTER TABLE `modify_application`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pay_record`
--
ALTER TABLE `pay_record`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `recharge`
--
ALTER TABLE `recharge`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `reserved`
--
ALTER TABLE `reserved`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`id`) REFERENCES `account` (`id`);

--
-- Constraints for table `hotel_new`
--
ALTER TABLE `hotel_new`
  ADD CONSTRAINT `hotel_new_ibfk_1` FOREIGN KEY (`id`) REFERENCES `account` (`id`);

--
-- Constraints for table `live_mes`
--
ALTER TABLE `live_mes`
  ADD CONSTRAINT `live_mes_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`);

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `member_ibfk_1` FOREIGN KEY (`id`) REFERENCES `account` (`id`);

--
-- Constraints for table `modify_application`
--
ALTER TABLE `modify_application`
  ADD CONSTRAINT `modify_application_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  ADD CONSTRAINT `modify_application_ibfk_2` FOREIGN KEY (`new_hotel_id`) REFERENCES `hotel_new` (`id`);

--
-- Constraints for table `open_application`
--
ALTER TABLE `open_application`
  ADD CONSTRAINT `open_application_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`);

--
-- Constraints for table `pay_record`
--
ALTER TABLE `pay_record`
  ADD CONSTRAINT `pay_record_ibfk_1` FOREIGN KEY (`live_id`) REFERENCES `live_mes` (`id`);

--
-- Constraints for table `reserved`
--
ALTER TABLE `reserved`
  ADD CONSTRAINT `reserved_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`),
  ADD CONSTRAINT `reserved_ibfk_2` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
