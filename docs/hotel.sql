-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Feb 25, 2017 at 04:44 PM
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
  `mail` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `id` varchar(20) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
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
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(30) COLLATE utf8_bin DEFAULT 'HOTEL',
  `address` varchar(50) COLLATE utf8_bin DEFAULT 'Nanjing',
  `status` tinyint(1) DEFAULT '0',
  `description` text COLLATE utf8_bin
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `liveMes`
--

DROP TABLE IF EXISTS `liveMes`;
CREATE TABLE `liveMes` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `in_time` date NOT NULL,
  `out_time` date DEFAULT NULL,
  `person_num` int(11) DEFAULT '1',
  `person_mes` text COLLATE utf8_bin,
  `pay_method` enum('member_card','credit_card','cash') COLLATE utf8_bin DEFAULT NULL,
  `member_id` varchar(20) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT 'Customer',
  `status` tinyint(1) DEFAULT '0',
  `remainDays` int(11) DEFAULT '0',
  `deposit` int(11) DEFAULT '0',
  `points` int(11) DEFAULT '0',
  `registDate` date DEFAULT NULL,
  `creditCard` text COLLATE utf8_bin
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `modify_application`
--

DROP TABLE IF EXISTS `modify_application`;
CREATE TABLE `modify_application` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `time` date NOT NULL,
  `hotel_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `new_hotel_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `open_application`
--

DROP TABLE IF EXISTS `open_application`;
CREATE TABLE `open_application` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `time` date NOT NULL,
  `hotel_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `reserved`
--

DROP TABLE IF EXISTS `reserved`;
CREATE TABLE `reserved` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `room_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `member_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `time` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
CREATE TABLE `rooms` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `hotel_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `available_time` date NOT NULL,
  `wifi` tinyint(1) DEFAULT '1',
  `pic_url` text COLLATE utf8_bin,
  `type` enum('big','one','double') COLLATE utf8_bin DEFAULT 'one',
  `price` int(11) DEFAULT '100'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`mail`),
  ADD UNIQUE KEY `id` (`id`);

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
-- Indexes for table `liveMes`
--
ALTER TABLE `liveMes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `modify_application`
--
ALTER TABLE `modify_application`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `open_application`
--
ALTER TABLE `open_application`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reserved`
--
ALTER TABLE `reserved`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`);

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
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `member_ibfk_1` FOREIGN KEY (`id`) REFERENCES `account` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
