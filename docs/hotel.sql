-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Mar 07, 2017 at 02:38 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `mail`, `password`, `type`) VALUES
(1, 'master@qq.com', '123456', 2),
(19, 'czqofnju@hello.com', '123456', 0),
(20, 'czqofnjuaaa@hello.com', '123456', 1),
(26, 'czqofnju0@qq.com', '123456', 0),
(27, 'czqofnju1@qq.com', '123456', 0),
(28, 'czqofnju2@qq.com', '123456', 0),
(29, 'czqofnju3@qq.com', '123456', 0),
(30, 'czqofnju4@qq.com', '123456', 0),
(31, 'czqofnju5@qq.com', '123456', 0),
(32, 'czqofnju6@qq.com', '123456', 0),
(33, 'czqofnju7@qq.com', '123456', 0),
(34, 'czqofnju8@qq.com', '123456', 0),
(35, 'czqofnju9@qq.com', '123456', 0),
(36, 'czqofnju10@qq.com', '123456', 0),
(37, 'czqofnju11@qq.com', '123456', 0),
(38, 'czqofnju12@qq.com', '123456', 0),
(39, 'czqofnju13@qq.com', '123456', 0),
(40, 'czqofnju14@qq.com', '123456', 0),
(41, 'czqofnju15@qq.com', '123456', 0),
(42, 'czqofnju16@qq.com', '123456', 0),
(43, 'czqofnju17@qq.com', '123456', 0),
(44, 'czqofnju18@qq.com', '123456', 0),
(45, 'czqofnju19@qq.com', '123456', 0),
(46, 'czqofnju20@qq.com', '123456', 0),
(47, 'czqofnju21@qq.com', '123456', 0),
(48, 'czqofnju22@qq.com', '123456', 0),
(49, 'czqofnju23@qq.com', '123456', 0),
(50, 'czqofnju24@qq.com', '123456', 0),
(51, 'czqofnju25@qq.com', '123456', 0),
(52, 'czqofnju26@qq.com', '123456', 0),
(53, 'czqofnju27@qq.com', '123456', 0),
(54, 'czqofnju28@qq.com', '123456', 0),
(55, 'czqofnju29@qq.com', '123456', 0),
(56, 'czqofnju30@qq.com', '123456', 0),
(57, 'czqofnju31@qq.com', '123456', 0),
(58, 'czqofnju32@qq.com', '123456', 0),
(59, 'czqofnju33@qq.com', '123456', 0),
(60, 'czqofnju34@qq.com', '123456', 0),
(61, 'czqofnju35@qq.com', '123456', 0),
(62, 'czqofnju36@qq.com', '123456', 0),
(63, 'czqofnju37@qq.com', '123456', 0),
(64, 'czqofnju38@qq.com', '123456', 0),
(65, 'czqofnju39@qq.com', '123456', 0),
(66, 'czqofnju40@qq.com', '123456', 0),
(67, 'czqofnju41@qq.com', '123456', 0),
(68, 'czqofnju42@qq.com', '123456', 0),
(69, 'czqofnju43@qq.com', '123456', 0),
(70, 'czqofnju44@qq.com', '123456', 0),
(71, 'czqofnju45@qq.com', '123456', 0),
(72, 'czqofnju46@qq.com', '123456', 0),
(73, 'czqofnju47@qq.com', '123456', 0),
(74, 'czqofnju48@qq.com', '123456', 0),
(75, 'czqofnju49@qq.com', '123456', 0),
(76, 'czqofnju50@qq.com', '123456', 0),
(77, 'czqofnju51@qq.com', '123456', 0),
(78, 'czqofnju52@qq.com', '123456', 0),
(79, 'czqofnju53@qq.com', '123456', 0),
(80, 'czqofnju54@qq.com', '123456', 0),
(81, 'czqofnju55@qq.com', '123456', 0),
(82, 'czqofnju56@qq.com', '123456', 0),
(83, 'czqofnju57@qq.com', '123456', 0),
(84, 'czqofnju58@qq.com', '123456', 0),
(85, 'czqofnju59@qq.com', '123456', 0),
(86, 'czqofnju60@qq.com', '123456', 0),
(87, 'czqofnju61@qq.com', '123456', 0),
(88, 'czqofnju62@qq.com', '123456', 0),
(89, 'czqofnju63@qq.com', '123456', 0),
(90, 'czqofnju64@qq.com', '123456', 0),
(91, 'czqofnju65@qq.com', '123456', 0),
(92, 'czqofnju66@qq.com', '123456', 0),
(93, 'czqofnju67@qq.com', '123456', 0),
(94, 'czqofnju68@qq.com', '123456', 0),
(95, 'czqofnju69@qq.com', '123456', 0),
(96, 'czqofnju70@qq.com', '123456', 0),
(97, 'czqofnju71@qq.com', '123456', 0),
(98, 'czqofnju72@qq.com', '123456', 0),
(99, 'czqofnju73@qq.com', '123456', 0),
(100, 'czqofnju74@qq.com', '123456', 0),
(101, 'czqofnju75@qq.com', '123456', 0),
(102, 'czqofnju76@qq.com', '123456', 0),
(103, 'czqofnju77@qq.com', '123456', 0),
(104, 'czqofnju78@qq.com', '123456', 0),
(105, 'czqofnju79@qq.com', '123456', 0),
(106, 'czqofnju80@qq.com', '123456', 0),
(107, 'czqofnju81@qq.com', '123456', 0),
(108, 'czqofnju82@qq.com', '123456', 0),
(109, 'czqofnju83@qq.com', '123456', 0),
(110, 'czqofnju84@qq.com', '123456', 0),
(111, 'czqofnju85@qq.com', '123456', 0),
(112, 'czqofnju86@qq.com', '123456', 0),
(113, 'czqofnju87@qq.com', '123456', 0),
(114, 'czqofnju88@qq.com', '123456', 0),
(115, 'czqofnju89@qq.com', '123456', 0),
(116, 'czqofnju90@qq.com', '123456', 0),
(117, 'czqofnju91@qq.com', '123456', 0),
(118, 'czqofnju92@qq.com', '123456', 0),
(119, 'czqofnju93@qq.com', '123456', 0),
(120, 'czqofnju94@qq.com', '123456', 0),
(121, 'czqofnju95@qq.com', '123456', 0),
(122, 'czqofnju96@qq.com', '123456', 0),
(123, 'czqofnju97@qq.com', '123456', 0),
(124, 'czqofnju98@qq.com', '123456', 0),
(125, 'czqofnju99@qq.com', '123456', 0),
(126, 'czqofnju0@hotel.com', '123456', 1),
(127, 'czqofnju1@hotel.com', '123456', 1),
(128, 'czqofnju2@hotel.com', '123456', 1),
(129, 'czqofnju3@hotel.com', '123456', 1),
(130, 'czqofnju4@hotel.com', '123456', 1),
(131, 'czqofnju5@hotel.com', '123456', 1),
(132, 'czqofnju6@hotel.com', '123456', 1),
(133, 'czqofnju7@hotel.com', '123456', 1),
(134, 'czqofnju8@hotel.com', '123456', 1),
(135, 'czqofnju9@hotel.com', '123456', 1),
(136, 'czqofnju10@hotel.com', '123456', 1),
(137, 'czqofnju11@hotel.com', '123456', 1),
(138, 'czqofnju12@hotel.com', '123456', 1),
(139, 'czqofnju13@hotel.com', '123456', 1),
(140, 'czqofnju14@hotel.com', '123456', 1),
(141, 'czqofnju15@hotel.com', '123456', 1),
(142, 'czqofnju16@hotel.com', '123456', 1),
(143, 'czqofnju17@hotel.com', '123456', 1),
(144, 'czqofnju18@hotel.com', '123456', 1),
(145, 'czqofnju19@hotel.com', '123456', 1),
(146, 'czqofnju20@hotel.com', '123456', 1),
(147, 'czqofnju21@hotel.com', '123456', 1),
(148, 'czqofnju22@hotel.com', '123456', 1),
(149, 'czqofnju23@hotel.com', '123456', 1),
(150, 'czqofnju24@hotel.com', '123456', 1),
(151, 'czqofnju25@hotel.com', '123456', 1),
(152, 'czqofnju26@hotel.com', '123456', 1),
(153, 'czqofnju27@hotel.com', '123456', 1),
(154, 'czqofnju28@hotel.com', '123456', 1),
(155, 'czqofnju29@hotel.com', '123456', 1),
(156, 'czqofnju30@hotel.com', '123456', 1),
(157, 'czqofnju31@hotel.com', '123456', 1),
(158, 'czqofnju32@hotel.com', '123456', 1),
(159, 'czqofnju33@hotel.com', '123456', 1),
(160, 'czqofnju34@hotel.com', '123456', 1),
(161, 'czqofnju35@hotel.com', '123456', 1),
(162, 'czqofnju36@hotel.com', '123456', 1),
(163, 'czqofnju37@hotel.com', '123456', 1),
(164, 'czqofnju38@hotel.com', '123456', 1),
(165, 'czqofnju39@hotel.com', '123456', 1),
(166, 'czqofnju40@hotel.com', '123456', 1),
(167, 'czqofnju41@hotel.com', '123456', 1),
(168, 'czqofnju42@hotel.com', '123456', 1),
(169, 'czqofnju43@hotel.com', '123456', 1),
(170, 'czqofnju44@hotel.com', '123456', 1),
(171, 'czqofnju45@hotel.com', '123456', 1),
(172, 'czqofnju46@hotel.com', '123456', 1),
(173, 'czqofnju47@hotel.com', '123456', 1),
(174, 'czqofnju48@hotel.com', '123456', 1),
(175, 'czqofnju49@hotel.com', '123456', 1),
(176, 'czqofnju50@hotel.com', '123456', 1),
(177, 'czqofnju51@hotel.com', '123456', 1),
(178, 'czqofnju52@hotel.com', '123456', 1),
(179, 'czqofnju53@hotel.com', '123456', 1),
(180, 'czqofnju54@hotel.com', '123456', 1),
(181, 'czqofnju55@hotel.com', '123456', 1),
(182, 'czqofnju56@hotel.com', '123456', 1),
(183, 'czqofnju57@hotel.com', '123456', 1),
(184, 'czqofnju58@hotel.com', '123456', 1),
(185, 'czqofnju59@hotel.com', '123456', 1),
(186, 'czqofnju60@hotel.com', '123456', 1),
(187, 'czqofnju61@hotel.com', '123456', 1),
(188, 'czqofnju62@hotel.com', '123456', 1),
(189, 'czqofnju63@hotel.com', '123456', 1),
(190, 'czqofnju64@hotel.com', '123456', 1),
(191, 'czqofnju65@hotel.com', '123456', 1),
(192, 'czqofnju66@hotel.com', '123456', 1),
(193, 'czqofnju67@hotel.com', '123456', 1),
(194, 'czqofnju68@hotel.com', '123456', 1),
(195, 'czqofnju69@hotel.com', '123456', 1),
(196, 'czqofnju70@hotel.com', '123456', 1),
(197, 'czqofnju71@hotel.com', '123456', 1),
(198, 'czqofnju72@hotel.com', '123456', 1),
(199, 'czqofnju73@hotel.com', '123456', 1),
(200, 'czqofnju74@hotel.com', '123456', 1),
(201, 'czqofnju75@hotel.com', '123456', 1),
(202, 'czqofnju76@hotel.com', '123456', 1),
(203, 'czqofnju77@hotel.com', '123456', 1),
(204, 'czqofnju78@hotel.com', '123456', 1),
(205, 'czqofnju79@hotel.com', '123456', 1),
(206, 'czqofnju80@hotel.com', '123456', 1),
(207, 'czqofnju81@hotel.com', '123456', 1),
(208, 'czqofnju82@hotel.com', '123456', 1),
(209, 'czqofnju83@hotel.com', '123456', 1),
(210, 'czqofnju84@hotel.com', '123456', 1),
(211, 'czqofnju85@hotel.com', '123456', 1),
(212, 'czqofnju86@hotel.com', '123456', 1),
(213, 'czqofnju87@hotel.com', '123456', 1),
(214, 'czqofnju88@hotel.com', '123456', 1),
(215, 'czqofnju89@hotel.com', '123456', 1),
(216, 'czqofnju90@hotel.com', '123456', 1),
(217, 'czqofnju91@hotel.com', '123456', 1),
(218, 'czqofnju92@hotel.com', '123456', 1),
(219, 'czqofnju93@hotel.com', '123456', 1),
(220, 'czqofnju94@hotel.com', '123456', 1),
(221, 'czqofnju95@hotel.com', '123456', 1),
(222, 'czqofnju96@hotel.com', '123456', 1),
(223, 'czqofnju97@hotel.com', '123456', 1),
(224, 'czqofnju98@hotel.com', '123456', 1),
(225, 'czqofnju99@hotel.com', '123456', 1),
(229, 'czqofnju1234@hello.com', '123456', 0);

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT 'HOTEL',
  `address` varchar(500) COLLATE utf8_bin DEFAULT 'Nanjing',
  `status` int(11) NOT NULL DEFAULT '0',
  `description` varchar(5000) COLLATE utf8_bin DEFAULT 'No Description',
  `pic_url` varchar(6000) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`id`, `name`, `address`, `status`, `description`, `pic_url`) VALUES
(20, 'sdsfs', 'sadfas', 1, 'asdfasf', '/img/upload/1488678867511duck_icon.png'),
(22, 'The Peninsula Tokyo', '2-2-1 Nishi-Shinjuku, Shinjuku-ku ,Shinjuku/Nakano,Tokyo,Japan', 1, 'In Shinjuku’s Skyscraper District just a 5-minute walk from Shinjuku Train Station, Keio Plaza Hotel Tokyo offers sweeping views of Shinjuku, free Wi-Fi and 21 dining options.The Tokyo Metropolitan Government Building is less than a 5-minute walk away, and the Kabukicho area is a 15-minute walk from the property. Meiji Jingu Shrine and Shinjuku Gyoen National Garden are both about a 20-minute walk away.The comfortable rooms at Tokyo Hotel Keio Plaza include a flat-screen TV with satellite and pay-per-view channels. Panoramic views of the Shinjuku skyline can be enjoyed from the rooms. Japanese-style Yukata robes and slippers are provided for all guests.Guests can work up a sweat in the fitness center or, for a fee, take a cool swim in the outdoor pool. The hotel also features a karaoke room, convenience store and business center. A free shuttle to Tokyo Disney Resort is provided.Amanogawa Sake Bar pours premium sake. The wide range of cuisines are served at Keio Plaza Hotel includes Japanese, French, Italian, Chinese and Korean.', '/img/hotel/hotel3.jpeg'),
(23, 'Studio City Hotel', 'Estrada do Istmo, Cotai Macau ,Cotai,Macau,853,China', 0, 'he Studio City Hotel (Hongguan Xinying Jiudian) is located just 3 km (2 mi) from Macao International Airport. The Museum of Taipa and Coloane and Macau Tower Convention & Entertainment Centre are all within a short distance. Guests can dine on Chinese, international and Asian cuisines at the on-site restaurants. In their spare time, guests can unwind with a a relaxing “picnic by the pool” and enjoy a variety of drinks at the Cabana Bar and Premier Bar. Quick bites including ', '/img/hotel/hotel5.jpeg'),
(24, 'Yasuragi Ioujima Hotel', '1-3277-7 Iojimamachi ,Nagasaki,Japan', 1, 'Stop at Yasuragi Ioujima Hotel to discover the wonders of Nagasaki. The hotel offers a high standard of service and amenities to suit the individual needs of all travelers. All the necessary facilities, including free Wi-Fi in all rooms, daily housekeeping, laundromat, 24-hour front desk, facilities for disabled guests, are at hand. Guestrooms are fitted with all the amenities you need for a good night''s sleep. In some of the rooms, guests can find television LCD/plasma screen, air conditioning, heating, wake-up service, balcony/terrace. The hotel offers various recreational opportunities. Convenience and comfort makes Yasuragi Ioujima Hotel the perfect choice for your stay in Nagasaki.', '/img/hotel/hotel1.jpeg'),
(25, 'The Peninsula Tokyo', '2-2-1 Nishi-Shinjuku, Shinjuku-ku ,Shinjuku/Nakano,Tokyo,Japan', 2323, 'In Shinjuku’s Skyscraper District just a 5-minute walk from Shinjuku Train Station, Keio Plaza Hotel Tokyo offers sweeping views of Shinjuku, free Wi-Fi and 21 dining options.The Tokyo Metropolitan Government Building is less than a 5-minute walk away, and the Kabukicho area is a 15-minute walk from the property. Meiji Jingu Shrine and Shinjuku Gyoen National Garden are both about a 20-minute walk away.The comfortable rooms at Tokyo Hotel Keio Plaza include a flat-screen TV with satellite and pay-per-view channels. Panoramic views of the Shinjuku skyline can be enjoyed from the rooms. Japanese-style Yukata robes and slippers are provided for all guests.Guests can work up a sweat in the fitness center or, for a fee, take a cool swim in the outdoor pool. The hotel also features a karaoke room, convenience store and business center. A free shuttle to Tokyo Disney Resort is provided.Amanogawa Sake Bar pours premium sake. The wide range of cuisines are served at Keio Plaza Hotel includes Japanese, French, Italian, Chinese and Korean.', '/img/hotel/hotel3.jpeg'),
(126, 'Studio City Hotel', 'Estrada do Istmo, Cotai Macau ,Cotai,Macau,853,China', 0, 'he Studio City Hotel (Hongguan Xinying Jiudian) is located just 3 km (2 mi) from Macao International Airport. The Museum of Taipa and Coloane and Macau Tower Convention & Entertainment Centre are all within a short distance. Guests can dine on Chinese, international and Asian cuisines at the on-site restaurants. In their spare time, guests can unwind with a a relaxing “picnic by the pool” and enjoy a variety of drinks at the Cabana Bar and Premier Bar. Quick bites including ', '/img/hotel/hotel5.jpeg'),
(127, 'Yasuragi Ioujima Hotel', '1-3277-7 Iojimamachi ,Nagasaki,Japan', 0, 'Stop at Yasuragi Ioujima Hotel to discover the wonders of Nagasaki. The hotel offers a high standard of service and amenities to suit the individual needs of all travelers. All the necessary facilities, including free Wi-Fi in all rooms, daily housekeeping, laundromat, 24-hour front desk, facilities for disabled guests, are at hand. Guestrooms are fitted with all the amenities you need for a good night''s sleep. In some of the rooms, guests can find television LCD/plasma screen, air conditioning, heating, wake-up service, balcony/terrace. The hotel offers various recreational opportunities. Convenience and comfort makes Yasuragi Ioujima Hotel the perfect choice for your stay in Nagasaki.', '/img/hotel/hotel1.jpeg'),
(128, 'The Peninsula Tokyo', '2-2-1 Nishi-Shinjuku, Shinjuku-ku ,Shinjuku/Nakano,Tokyo,Japan', 0, 'In Shinjuku’s Skyscraper District just a 5-minute walk from Shinjuku Train Station, Keio Plaza Hotel Tokyo offers sweeping views of Shinjuku, free Wi-Fi and 21 dining options.The Tokyo Metropolitan Government Building is less than a 5-minute walk away, and the Kabukicho area is a 15-minute walk from the property. Meiji Jingu Shrine and Shinjuku Gyoen National Garden are both about a 20-minute walk away.The comfortable rooms at Tokyo Hotel Keio Plaza include a flat-screen TV with satellite and pay-per-view channels. Panoramic views of the Shinjuku skyline can be enjoyed from the rooms. Japanese-style Yukata robes and slippers are provided for all guests.Guests can work up a sweat in the fitness center or, for a fee, take a cool swim in the outdoor pool. The hotel also features a karaoke room, convenience store and business center. A free shuttle to Tokyo Disney Resort is provided.Amanogawa Sake Bar pours premium sake. The wide range of cuisines are served at Keio Plaza Hotel includes Japanese, French, Italian, Chinese and Korean.', '/img/hotel/hotel3.jpeg'),
(129, 'Studio City Hotel', 'Estrada do Istmo, Cotai Macau ,Cotai,Macau,853,China', 0, 'he Studio City Hotel (Hongguan Xinying Jiudian) is located just 3 km (2 mi) from Macao International Airport. The Museum of Taipa and Coloane and Macau Tower Convention & Entertainment Centre are all within a short distance. Guests can dine on Chinese, international and Asian cuisines at the on-site restaurants. In their spare time, guests can unwind with a a relaxing “picnic by the pool” and enjoy a variety of drinks at the Cabana Bar and Premier Bar. Quick bites including ', '/img/hotel/hotel5.jpeg'),
(130, 'Yasuragi Ioujima Hotel', '1-3277-7 Iojimamachi ,Nagasaki,Japan', 0, 'Stop at Yasuragi Ioujima Hotel to discover the wonders of Nagasaki. The hotel offers a high standard of service and amenities to suit the individual needs of all travelers. All the necessary facilities, including free Wi-Fi in all rooms, daily housekeeping, laundromat, 24-hour front desk, facilities for disabled guests, are at hand. Guestrooms are fitted with all the amenities you need for a good night''s sleep. In some of the rooms, guests can find television LCD/plasma screen, air conditioning, heating, wake-up service, balcony/terrace. The hotel offers various recreational opportunities. Convenience and comfort makes Yasuragi Ioujima Hotel the perfect choice for your stay in Nagasaki.', '/img/hotel/hotel1.jpeg'),
(131, 'The Peninsula Tokyo', '2-2-1 Nishi-Shinjuku, Shinjuku-ku ,Shinjuku/Nakano,Tokyo,Japan', 0, 'In Shinjuku’s Skyscraper District just a 5-minute walk from Shinjuku Train Station, Keio Plaza Hotel Tokyo offers sweeping views of Shinjuku, free Wi-Fi and 21 dining options.The Tokyo Metropolitan Government Building is less than a 5-minute walk away, and the Kabukicho area is a 15-minute walk from the property. Meiji Jingu Shrine and Shinjuku Gyoen National Garden are both about a 20-minute walk away.The comfortable rooms at Tokyo Hotel Keio Plaza include a flat-screen TV with satellite and pay-per-view channels. Panoramic views of the Shinjuku skyline can be enjoyed from the rooms. Japanese-style Yukata robes and slippers are provided for all guests.Guests can work up a sweat in the fitness center or, for a fee, take a cool swim in the outdoor pool. The hotel also features a karaoke room, convenience store and business center. A free shuttle to Tokyo Disney Resort is provided.Amanogawa Sake Bar pours premium sake. The wide range of cuisines are served at Keio Plaza Hotel includes Japanese, French, Italian, Chinese and Korean.', '/img/hotel/hotel3.jpeg'),
(132, 'Studio City Hotel', 'Estrada do Istmo, Cotai Macau ,Cotai,Macau,853,China', 0, 'he Studio City Hotel (Hongguan Xinying Jiudian) is located just 3 km (2 mi) from Macao International Airport. The Museum of Taipa and Coloane and Macau Tower Convention & Entertainment Centre are all within a short distance. Guests can dine on Chinese, international and Asian cuisines at the on-site restaurants. In their spare time, guests can unwind with a a relaxing “picnic by the pool” and enjoy a variety of drinks at the Cabana Bar and Premier Bar. Quick bites including ', '/img/hotel/hotel5.jpeg'),
(133, 'Yasuragi Ioujima Hotel', '1-3277-7 Iojimamachi ,Nagasaki,Japan', 0, 'Stop at Yasuragi Ioujima Hotel to discover the wonders of Nagasaki. The hotel offers a high standard of service and amenities to suit the individual needs of all travelers. All the necessary facilities, including free Wi-Fi in all rooms, daily housekeeping, laundromat, 24-hour front desk, facilities for disabled guests, are at hand. Guestrooms are fitted with all the amenities you need for a good night''s sleep. In some of the rooms, guests can find television LCD/plasma screen, air conditioning, heating, wake-up service, balcony/terrace. The hotel offers various recreational opportunities. Convenience and comfort makes Yasuragi Ioujima Hotel the perfect choice for your stay in Nagasaki.', '/img/hotel/hotel1.jpeg'),
(134, 'The Peninsula Tokyo', '2-2-1 Nishi-Shinjuku, Shinjuku-ku ,Shinjuku/Nakano,Tokyo,Japan', 0, 'In Shinjuku’s Skyscraper District just a 5-minute walk from Shinjuku Train Station, Keio Plaza Hotel Tokyo offers sweeping views of Shinjuku, free Wi-Fi and 21 dining options.The Tokyo Metropolitan Government Building is less than a 5-minute walk away, and the Kabukicho area is a 15-minute walk from the property. Meiji Jingu Shrine and Shinjuku Gyoen National Garden are both about a 20-minute walk away.The comfortable rooms at Tokyo Hotel Keio Plaza include a flat-screen TV with satellite and pay-per-view channels. Panoramic views of the Shinjuku skyline can be enjoyed from the rooms. Japanese-style Yukata robes and slippers are provided for all guests.Guests can work up a sweat in the fitness center or, for a fee, take a cool swim in the outdoor pool. The hotel also features a karaoke room, convenience store and business center. A free shuttle to Tokyo Disney Resort is provided.Amanogawa Sake Bar pours premium sake. The wide range of cuisines are served at Keio Plaza Hotel includes Japanese, French, Italian, Chinese and Korean.', '/img/hotel/hotel3.jpeg'),
(135, 'Studio City Hotel', 'Estrada do Istmo, Cotai Macau ,Cotai,Macau,853,China', 0, 'he Studio City Hotel (Hongguan Xinying Jiudian) is located just 3 km (2 mi) from Macao International Airport. The Museum of Taipa and Coloane and Macau Tower Convention & Entertainment Centre are all within a short distance. Guests can dine on Chinese, international and Asian cuisines at the on-site restaurants. In their spare time, guests can unwind with a a relaxing “picnic by the pool” and enjoy a variety of drinks at the Cabana Bar and Premier Bar. Quick bites including ', '/img/hotel/hotel5.jpeg'),
(136, 'Yasuragi Ioujima Hotel', '1-3277-7 Iojimamachi ,Nagasaki,Japan', 0, 'Stop at Yasuragi Ioujima Hotel to discover the wonders of Nagasaki. The hotel offers a high standard of service and amenities to suit the individual needs of all travelers. All the necessary facilities, including free Wi-Fi in all rooms, daily housekeeping, laundromat, 24-hour front desk, facilities for disabled guests, are at hand. Guestrooms are fitted with all the amenities you need for a good night''s sleep. In some of the rooms, guests can find television LCD/plasma screen, air conditioning, heating, wake-up service, balcony/terrace. The hotel offers various recreational opportunities. Convenience and comfort makes Yasuragi Ioujima Hotel the perfect choice for your stay in Nagasaki.', '/img/hotel/hotel1.jpeg'),
(137, 'The Peninsula Tokyo', '2-2-1 Nishi-Shinjuku, Shinjuku-ku ,Shinjuku/Nakano,Tokyo,Japan', 0, 'In Shinjuku’s Skyscraper District just a 5-minute walk from Shinjuku Train Station, Keio Plaza Hotel Tokyo offers sweeping views of Shinjuku, free Wi-Fi and 21 dining options.The Tokyo Metropolitan Government Building is less than a 5-minute walk away, and the Kabukicho area is a 15-minute walk from the property. Meiji Jingu Shrine and Shinjuku Gyoen National Garden are both about a 20-minute walk away.The comfortable rooms at Tokyo Hotel Keio Plaza include a flat-screen TV with satellite and pay-per-view channels. Panoramic views of the Shinjuku skyline can be enjoyed from the rooms. Japanese-style Yukata robes and slippers are provided for all guests.Guests can work up a sweat in the fitness center or, for a fee, take a cool swim in the outdoor pool. The hotel also features a karaoke room, convenience store and business center. A free shuttle to Tokyo Disney Resort is provided.Amanogawa Sake Bar pours premium sake. The wide range of cuisines are served at Keio Plaza Hotel includes Japanese, French, Italian, Chinese and Korean.', '/img/hotel/hotel3.jpeg'),
(138, 'dsf', 'sdfds', 0, 'sdf', ''),
(139, 'Yasuragi Ioujima Hotel', '1-3277-7 Iojimamachi ,Nagasaki,Japan', 0, 'Stop at Yasuragi Ioujima Hotel to discover the wonders of Nagasaki. The hotel offers a high standard of service and amenities to suit the individual needs of all travelers. All the necessary facilities, including free Wi-Fi in all rooms, daily housekeeping, laundromat, 24-hour front desk, facilities for disabled guests, are at hand. Guestrooms are fitted with all the amenities you need for a good night''s sleep. In some of the rooms, guests can find television LCD/plasma screen, air conditioning, heating, wake-up service, balcony/terrace. The hotel offers various recreational opportunities. Convenience and comfort makes Yasuragi Ioujima Hotel the perfect choice for your stay in Nagasaki.', '/img/hotel/hotel1.jpeg'),
(140, 'The Peninsula Tokyo', '2-2-1 Nishi-Shinjuku, Shinjuku-ku ,Shinjuku/Nakano,Tokyo,Japan', 0, 'In Shinjuku’s Skyscraper District just a 5-minute walk from Shinjuku Train Station, Keio Plaza Hotel Tokyo offers sweeping views of Shinjuku, free Wi-Fi and 21 dining options.The Tokyo Metropolitan Government Building is less than a 5-minute walk away, and the Kabukicho area is a 15-minute walk from the property. Meiji Jingu Shrine and Shinjuku Gyoen National Garden are both about a 20-minute walk away.The comfortable rooms at Tokyo Hotel Keio Plaza include a flat-screen TV with satellite and pay-per-view channels. Panoramic views of the Shinjuku skyline can be enjoyed from the rooms. Japanese-style Yukata robes and slippers are provided for all guests.Guests can work up a sweat in the fitness center or, for a fee, take a cool swim in the outdoor pool. The hotel also features a karaoke room, convenience store and business center. A free shuttle to Tokyo Disney Resort is provided.Amanogawa Sake Bar pours premium sake. The wide range of cuisines are served at Keio Plaza Hotel includes Japanese, French, Italian, Chinese and Korean.', '/img/hotel/hotel3.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `hotel_new`
--

DROP TABLE IF EXISTS `hotel_new`;
CREATE TABLE `hotel_new` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT 'HOTEL',
  `address` varchar(500) COLLATE utf8_bin DEFAULT 'Nanjing',
  `status` int(11) NOT NULL DEFAULT '0',
  `description` varchar(5000) COLLATE utf8_bin DEFAULT 'No Description',
  `old_hotel` int(11) DEFAULT NULL,
  `pic_url` varchar(6000) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `hotel_new`
--

INSERT INTO `hotel_new` (`id`, `name`, `address`, `status`, `description`, `old_hotel`, `pic_url`) VALUES
(8, 'werwr', 'werwer', 0, 'werewrew', 20, NULL),
(9, 'My New Name', 'Nanjing', 0, 'A new good hotel', 20, NULL),
(10, 'sdfdsf', 'sdfsdf', 0, 'sdfsdf', 20, ''),
(11, 'sdf', 'sfsdf', 0, 'sdf', 20, ''),
(12, 'sdf', 'sfsdf', 0, 'sdf', 20, ''),
(13, 'sdf', 'sfsdf', 0, 'sdf', 20, ''),
(14, 'sdf', 'sfsdf', 0, 'sdf', 20, ''),
(15, 'sdf', 'sfsdf', 0, 'sdf', 20, ''),
(16, 'qwewq', 'eqwe', 0, 'wqewq', 20, ''),
(17, 'sds', 'sds', 0, 'sdss', 138, ''),
(18, 'fsdf', 'dssd', 0, 'sdfd', 138, ''),
(19, 'dsf', 'sdfds', 0, 'sdf', 138, ''),
(20, 'sdfd', 'dsf', 0, 'sddfds', 20, ''),
(21, 'ssds', 'dsfsdf', 0, 'sdfsdf', 20, '/Users/czq/Development/j2ee_hotel/src/main/resources/static/img/upload/1488678064608duck_icon.png'),
(22, 'sdsfs', 'sadfas', 0, 'asdfasf', 20, '/img/upload/1488678867511duck_icon.png');

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
  `person_mes` varchar(6000) COLLATE utf8_bin NOT NULL DEFAULT 'No Description',
  `pay_method` int(11) NOT NULL DEFAULT '0',
  `member_id` int(11) NOT NULL DEFAULT '0',
  `room_id` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  `hotel_id` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `live_mes`
--

INSERT INTO `live_mes` (`id`, `in_time`, `out_time`, `person_num`, `person_mes`, `pay_method`, `member_id`, `room_id`, `status`, `hotel_id`) VALUES
(1, '2017-03-01 15:46:16', '2017-03-01 15:56:35', 2, '2323', 0, 19, 1, 1, 20),
(2, '2017-03-01 15:47:29', '2017-03-01 17:55:26', 2, '2323', 0, 19, 2, 1, 20),
(3, '2017-03-01 15:48:12', '2017-03-01 21:52:04', 2, '2323', 0, 19, 2, 1, 20),
(4, '2017-03-01 15:53:58', '2017-03-01 21:53:41', 1, '23', 0, 19, 5, 1, 20),
(5, '2017-03-01 17:21:39', '2017-03-06 13:41:47', 1, '121', 0, 19, 9, 1, 20),
(7, '2017-03-01 17:58:14', '2017-03-01 17:58:14', 1, '22323', 1, 0, 7, 0, 20),
(8, '2017-03-02 11:30:22', '2017-03-02 11:30:22', 2, '', 0, 19, 8, 0, 20),
(9, '2017-03-02 11:31:01', '2017-03-02 11:31:01', 2, '121', 1, 19, 8, 0, 20),
(10, '2017-03-02 11:31:20', '2017-03-02 11:31:20', 2, '121', 0, 19, 8, 0, 20),
(11, '2017-03-02 11:31:40', '2017-03-02 11:31:40', 2, '1', 0, 19, 8, 0, 20),
(12, '2017-03-02 11:32:35', '2017-03-02 11:32:35', 1, '1212', 0, 19, 11, 0, 20);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT 'Customer',
  `status` int(11) NOT NULL DEFAULT '0',
  `remain_days` int(11) NOT NULL DEFAULT '0',
  `deposit` int(11) NOT NULL DEFAULT '0',
  `points` int(11) NOT NULL DEFAULT '0',
  `regist_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `credit_card` varchar(6000) COLLATE utf8_bin NOT NULL DEFAULT 'None',
  `accumulate` int(11) DEFAULT '0',
  `discount` int(11) DEFAULT '0',
  `member_level` int(11) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `name`, `status`, `remain_days`, `deposit`, `points`, `regist_date`, `credit_card`, `accumulate`, `discount`, `member_level`) VALUES
(19, 'QiangChen', 1, 0, 19098, 124, '2017-02-27 23:24:58', '213456666', 0, 2, 0),
(20, 'Name', 0, 0, 0, 0, '2017-03-02 15:34:09', 'None', 0, 2, 0),
(26, 'Member 0', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(27, 'Member 1', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(28, 'Member 2', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(29, 'Member 3', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(30, 'Member 4', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(31, 'Member 5', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(32, 'Member 6', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(33, 'Member 7', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(34, 'Member 8', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(35, 'Member 9', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(36, 'Member 10', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(37, 'Member 11', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(38, 'Member 12', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(39, 'Member 13', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(40, 'Member 14', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(41, 'Member 15', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(42, 'Member 16', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(43, 'Member 17', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(44, 'Member 18', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(45, 'Member 19', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(46, 'Member 20', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(47, 'Member 21', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(48, 'Member 22', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(49, 'Member 23', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(50, 'Member 24', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(51, 'Member 25', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(52, 'Member 26', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(53, 'Member 27', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(54, 'Member 28', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(55, 'Member 29', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(56, 'Member 30', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(57, 'Member 31', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(58, 'Member 32', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(59, 'Member 33', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(60, 'Member 34', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(61, 'Member 35', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(62, 'Member 36', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(63, 'Member 37', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(64, 'Member 38', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(65, 'Member 39', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(66, 'Member 40', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(67, 'Member 41', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(68, 'Member 42', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(69, 'Member 43', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(70, 'Member 44', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(71, 'Member 45', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(72, 'Member 46', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(73, 'Member 47', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(74, 'Member 48', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(75, 'Member 49', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(76, 'Member 50', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(77, 'Member 51', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(78, 'Member 52', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(79, 'Member 53', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(80, 'Member 54', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(81, 'Member 55', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(82, 'Member 56', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(83, 'Member 57', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(84, 'Member 58', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(85, 'Member 59', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(86, 'Member 60', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(87, 'Member 61', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(88, 'Member 62', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(89, 'Member 63', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(90, 'Member 64', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(91, 'Member 65', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(92, 'Member 66', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(93, 'Member 67', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(94, 'Member 68', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(95, 'Member 69', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(96, 'Member 70', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(97, 'Member 71', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(98, 'Member 72', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(99, 'Member 73', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(100, 'Member 74', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(101, 'Member 75', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(102, 'Member 76', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(103, 'Member 77', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(104, 'Member 78', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(105, 'Member 79', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(106, 'Member 80', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(107, 'Member 81', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(108, 'Member 82', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(109, 'Member 83', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(110, 'Member 84', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(111, 'Member 85', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(112, 'Member 86', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(113, 'Member 87', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(114, 'Member 88', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(115, 'Member 89', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(116, 'Member 90', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(117, 'Member 91', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(118, 'Member 92', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(119, 'Member 93', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(120, 'Member 94', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(121, 'Member 95', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(122, 'Member 96', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(123, 'Member 97', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(124, 'Member 98', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(125, 'Member 99', 0, 0, 0, 0, '2017-03-02 22:44:14', 'None', 0, 2, 0),
(229, 'Name', 1, 365, 1001, 0, '2017-03-04 18:25:04', 'None', 0, 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `modify_application`
--

DROP TABLE IF EXISTS `modify_application`;
CREATE TABLE `modify_application` (
  `id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hotel_id` int(20) NOT NULL DEFAULT '0',
  `new_hotel_id` int(20) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `modify_application`
--

INSERT INTO `modify_application` (`id`, `time`, `hotel_id`, `new_hotel_id`, `status`) VALUES
(7, '2017-03-01 09:10:44', 20, 8, 1),
(8, '2017-03-02 12:58:25', 20, 9, 1),
(9, '2017-03-03 13:26:59', 20, 10, 1),
(10, '2017-03-03 13:38:52', 20, 11, 1),
(11, '2017-03-03 13:39:47', 20, 12, 1),
(12, '2017-03-03 13:39:49', 20, 13, 1),
(13, '2017-03-03 13:39:49', 20, 14, 1),
(14, '2017-03-03 13:39:50', 20, 15, 1),
(15, '2017-03-03 13:40:23', 20, 16, 1),
(16, '2017-03-03 14:02:52', 138, 17, 1),
(17, '2017-03-03 14:03:47', 138, 18, 1),
(18, '2017-03-03 14:05:10', 138, 19, 1),
(19, '2017-03-05 01:36:29', 20, 20, 1),
(20, '2017-03-05 01:41:34', 20, 21, 1),
(21, '2017-03-05 01:54:40', 20, 22, 1);

-- --------------------------------------------------------

--
-- Table structure for table `open_application`
--

DROP TABLE IF EXISTS `open_application`;
CREATE TABLE `open_application` (
  `id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hotel_id` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  `reason` varchar(5000) COLLATE utf8_bin NOT NULL DEFAULT 'No description'
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `open_application`
--

INSERT INTO `open_application` (`id`, `time`, `hotel_id`, `status`, `reason`) VALUES
(1, '2017-03-01 09:07:02', 20, 1, 'sdfdsaf'),
(2, '2017-03-01 09:09:06', 20, 1, 'sfsadfdsa'),
(3, '2017-03-01 09:10:30', 20, 1, 'sfsadfdsa'),
(4, '2017-03-02 11:44:45', 20, 1, 'I am apply for open'),
(5, '2017-03-02 12:57:17', 20, 1, 'dsfsdfdsf');

-- --------------------------------------------------------

--
-- Table structure for table `pay_record`
--

DROP TABLE IF EXISTS `pay_record`;
CREATE TABLE `pay_record` (
  `id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bill` int(11) NOT NULL DEFAULT '0',
  `after` int(11) NOT NULL DEFAULT '0',
  `live_id` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `pay_record`
--

INSERT INTO `pay_record` (`id`, `time`, `bill`, `after`, `live_id`) VALUES
(2, '2017-03-03 01:30:22', 22, 712, 0),
(3, '2017-03-03 01:31:20', 22, 690, 0),
(4, '2017-03-03 01:31:40', 22, 668, 0),
(5, '2017-03-03 01:32:35', 22, 646, 0);

-- --------------------------------------------------------

--
-- Table structure for table `point_convert`
--

DROP TABLE IF EXISTS `point_convert`;
CREATE TABLE `point_convert` (
  `id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `member_id` int(11) NOT NULL,
  `point` int(11) NOT NULL DEFAULT '0' COMMENT 'Points to be convert',
  `amount` int(11) NOT NULL DEFAULT '0' COMMENT 'the amount of convert',
  `after` int(11) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Point Convert to deposit';

--
-- Dumping data for table `point_convert`
--

INSERT INTO `point_convert` (`id`, `time`, `member_id`, `point`, `amount`, `after`) VALUES
(1, '2017-03-06 11:51:38', 0, 5, 5, 19095),
(2, '2017-03-06 11:51:43', 0, 3, 3, 19098);

-- --------------------------------------------------------

--
-- Table structure for table `recharge`
--

DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge` (
  `id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `member_id` int(11) NOT NULL DEFAULT '0',
  `former` int(11) NOT NULL DEFAULT '0',
  `after` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `reserved`
--

DROP TABLE IF EXISTS `reserved`;
CREATE TABLE `reserved` (
  `id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL DEFAULT '0',
  `member_id` int(11) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `reserved`
--

INSERT INTO `reserved` (`id`, `room_id`, `member_id`, `time`, `status`) VALUES
(4, 6, 19, '2017-03-05 06:12:36', 0),
(5, 15, 19, '2017-03-05 06:12:40', 0),
(7, 4, 19, '2017-03-07 02:17:16', 0);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
CREATE TABLE `rooms` (
  `id` int(11) NOT NULL,
  `name` varchar(60) COLLATE utf8_bin DEFAULT 'Room',
  `hotel_id` int(11) NOT NULL DEFAULT '0',
  `available_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `wifi` int(11) NOT NULL DEFAULT '1',
  `breakfast` int(11) DEFAULT '0',
  `area` int(11) DEFAULT '50',
  `pic_url` varchar(6000) COLLATE utf8_bin DEFAULT NULL,
  `type` int(11) NOT NULL DEFAULT '0',
  `price` int(11) NOT NULL DEFAULT '100',
  `status` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`id`, `name`, `hotel_id`, `available_time`, `wifi`, `breakfast`, `area`, `pic_url`, `type`, `price`, `status`) VALUES
(1, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 1),
(2, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 3),
(3, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(4, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 1),
(5, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 3),
(6, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 1),
(7, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 2),
(8, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 2),
(9, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 2),
(10, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(11, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 2),
(12, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(13, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(14, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(15, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 1),
(16, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(17, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(18, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(19, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(20, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(21, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(22, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '222', 0, 22, 0),
(23, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'http://sss.com', 0, 34, 0),
(24, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'http://sss.com', 0, 34, 0),
(25, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'http://sss.com', 0, 34, 0),
(26, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'http://sss.com', 0, 34, 0),
(27, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'http://sss.com', 0, 34, 0),
(28, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'http://sss.com', 0, 34, 0),
(29, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'http://sss.com', 0, 34, 0),
(30, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'www', 0, 23, 0),
(31, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'www', 0, 23, 0),
(32, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'www', 0, 23, 0),
(33, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'www', 0, 23, 0),
(34, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'www', 0, 23, 0),
(35, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '2222', 0, 22, 0),
(36, 'Room', 20, '2018-02-01 02:00:00', 1, 0, 50, '22', 0, 22, 0),
(37, 'Room', 20, '2018-02-20 02:00:00', 1, 0, 50, '2', 0, 2, 0),
(38, 'Room', 20, '2018-02-20 02:00:00', 1, 0, 50, '2', 0, 2, 0),
(39, 'Room', 20, '2017-02-20 02:00:00', 1, 0, 50, '2', 0, 2, 0),
(40, 'Room', 20, '2017-02-20 02:00:00', 1, 0, 50, '2', 0, 2, 0),
(41, 'Room', 20, '2017-01-31 02:00:00', 1, 0, 50, '2', 0, 2, 0),
(42, 'Room', 20, '2017-01-31 02:00:00', 1, 0, 50, '2', 0, 2, 0),
(43, 'Room', 20, '2017-01-31 02:00:00', 1, 0, 50, '22', 0, 22, 0),
(44, 'Room', 20, '2016-12-31 02:00:00', 1, 0, 50, '22', 0, 2, 0),
(45, 'Room', 20, '2016-12-31 02:00:00', 1, 0, 50, '22', 0, 2, 0),
(46, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '22', 0, 22, 0),
(47, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '22', 0, 22, 0),
(48, 'Room', 20, '2017-02-01 02:00:00', 1, 0, 50, '22', 0, 2, 0),
(49, 'Room', 20, '2016-01-31 02:00:00', 1, 0, 50, '22', 0, 22, 0),
(50, 'Room', 20, '2016-01-31 02:00:00', 1, 0, 50, '22', 0, 22, 0),
(51, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'http://sss.com', 0, 34, 0),
(52, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'http://sss.com', 0, 34, 0),
(53, 'Room', 20, '2017-03-22 03:00:00', 1, 0, 50, 'http://sss.com', 0, 34, 0);

-- --------------------------------------------------------

--
-- Table structure for table `settlement`
--

DROP TABLE IF EXISTS `settlement`;
CREATE TABLE `settlement` (
  `id` int(11) NOT NULL,
  `hotel_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `settledTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `settled_time` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `settlement`
--

INSERT INTO `settlement` (`id`, `hotel_id`, `amount`, `status`, `settledTime`, `settled_time`) VALUES
(1, 20, 66, 1, '2017-03-03 01:32:07', '2017-03-02 19:30:22'),
(2, 20, 22, 1, '2017-03-03 01:38:54', '2017-03-02 19:32:35');

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
  ADD KEY `member_id` (`member_id`),
  ADD KEY `room_id` (`room_id`);

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
-- Indexes for table `point_convert`
--
ALTER TABLE `point_convert`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `settlement`
--
ALTER TABLE `settlement`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=230;
--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=226;
--
-- AUTO_INCREMENT for table `hotel_new`
--
ALTER TABLE `hotel_new`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `live_mes`
--
ALTER TABLE `live_mes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=230;
--
-- AUTO_INCREMENT for table `modify_application`
--
ALTER TABLE `modify_application`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `open_application`
--
ALTER TABLE `open_application`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `pay_record`
--
ALTER TABLE `pay_record`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `point_convert`
--
ALTER TABLE `point_convert`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `reserved`
--
ALTER TABLE `reserved`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT for table `settlement`
--
ALTER TABLE `settlement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `live_mes`
--
ALTER TABLE `live_mes`
  ADD CONSTRAINT `live_mes_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`);

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
-- Constraints for table `reserved`
--
ALTER TABLE `reserved`
  ADD CONSTRAINT `reserved_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`),
  ADD CONSTRAINT `reserved_ibfk_2` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
