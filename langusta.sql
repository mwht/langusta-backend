-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 21, 2019 at 02:27 PM
-- Server version: 10.3.12-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `langusta`
--

-- --------------------------------------------------------

--
-- Table structure for table `contest`
--

CREATE TABLE `contest` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `end_date` datetime NOT NULL,
  `end_notification_sent` tinyint(1) NOT NULL DEFAULT 1,
  `platform_id` int(11) NOT NULL,
  `post_link` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `top_comments` varchar(155) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `top_comm_likes` int(11) NOT NULL DEFAULT 0,
  `likes_amount` int(11) NOT NULL DEFAULT 0,
  `winner_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `winner_display_name` text COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `contest`
--

INSERT INTO `contest` (`id`, `user_id`, `title`, `end_date`, `end_notification_sent`, `platform_id`, `post_link`, `top_comments`, `top_comm_likes`, `likes_amount`, `winner_id`, `winner_display_name`) VALUES
(557, 137, 'K1', '2018-12-19 20:00:00', 1, 1, '768903396526481_1910004625749680', NULL, 0, 1, '768903396526481', '7phase Development'),
(558, 137, 'K 2', '2018-12-20 20:00:00', 1, 1, '768903396526481_1880689145347895', NULL, 0, 0, NULL, NULL),
(569, 178, 'Title123', '2018-12-12 09:20:00', 1, 1, '768903396526481_1934505099966299', NULL, 0, 0, '1141776845947153', 'Ignacy Polkowski'),
(579, 178, 'Title123', '2018-12-12 16:32:00', 1, 1, '768903396526481_1934505099966299', NULL, 0, 0, '1141776845947153', 'Ignacy Polkowski'),
(582, 137, 'Titleasdf', '2018-12-12 16:36:00', 1, 1, '768903396526481_1934505099966299', NULL, 0, 0, '1141776845947153', 'Ignacy Polkowski');

-- --------------------------------------------------------

--
-- Table structure for table `facebook_access_token`
--

CREATE TABLE `facebook_access_token` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `access_token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `facebook_access_token`
--

INSERT INTO `facebook_access_token` (`id`, `user_id`, `access_token`) VALUES
(404, 137, 'EAAEkxTWGg4cBAH3g3NtJ6gy2obYbP75mWk10yG58Yv30GdopkW0RwrPW76fUBqjsHaogl4aK4uXVbBqfLfrZBZBEnNZB8sCyQkBoBzdKrZARnlGyY2sL0WOBiRKRA18HbkX4IrCfAuz9eIZCuk7ydKyGebL17U7lStRt6rsph8AZDZD'),
(409, 178, 'EAAEkxTWGg4cBAGv3mWNeMCZA4Wuc3lhGuPKXiCD6ZBpZC7LVwpBHrOWNpY0ig29LUyJ0CGBRRRkeNzF5irOvLkZCZAZBO6aT0JuPLvF3ewDL1nalpFmPohPkjn8HqDWsEU5RxOHbD2OmM0LHitEKkIDFnPu8nImyxlBdAZBv9ULMAZDZD'),
(441, 275, 'EAAEkxTWGg4cBACbmUej4edQCr0Ec7yHooZCmyRAoTZA20IyZCEPlgmnmpsttZCClUFoBIteC3qzzo5pVLOum71epvAAC9SU8HlZAtHJZBG93frQoGNoBwPEuCV8QDESElCZAQ0a2ZBZAz0rT5ggZA9ZBia8422MdZBYXpVW4MnlVcUKD7wZDZD'),
(561, 275, 'EAAEkxTWGg4cBAHiOGJ1A2nCQ3GpBX5Qka8CvMwvSczeZBZCFrsBUPGtd0NL9sM5mRHImsYkfVR6rwU6jMwQzhDr1ZAZANDgeY69F9ZAfa3mnNImKSXfnecZBgIzyaDTkQcl6ZBq3nZAs5bs4TZBDhsysibwamUxcQWX3flvftb44p8AZDZD'),
(658, 137, 'EAAEkxTWGg4cBACMLmFVEpnBgnVJbXoybqbwkuYihAHLGArybebaJ2nFOiocv6DCtEnb8DgqqZAGfQQQPPbubzmkt0w3CBEmKMHZCzrvTjo5t9a2eaxKzZAccCJbsZCTg1YmG0akRqoZAN3uhyzFpGWlhFYXRFLSGmENbMVinLOgZDZD'),
(659, 137, 'EAAEkxTWGg4cBAFNlM3puoZAAJhxapPWe7c2b0DPOIBGZCexQIgLZA3mnlam4P7tU4FdPWkS2nz947mBuZBZCjVNO4HZCZCOYQZBwCf7JkT7uLYRGJvsAKpkmqcDwoO2SeZCADpZA7yX2ZA5hZABVYiVyVpN5WdjBR26tjjQTglVhZB72b6wZDZD');

-- --------------------------------------------------------

--
-- Table structure for table `facebook_post_log`
--

CREATE TABLE `facebook_post_log` (
  `id` int(11) NOT NULL,
  `page_id` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `content` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `post_date` datetime NOT NULL,
  `session_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `facebook_post_log`
--

INSERT INTO `facebook_post_log` (`id`, `page_id`, `content`, `post_date`, `session_id`) VALUES
(262, '768903396526481', 'tesssst', '2018-11-01 00:00:00', 243),
(263, '768903396526481', 'Testing...', '2018-11-01 00:00:00', 244),
(264, '768903396526481', 'sprawdzam to co Michał dodał n', '2018-11-01 00:00:00', 243),
(265, '768903396526481', 'Testing testing.', '2018-11-01 00:00:00', 244),
(266, '768903396526481', 'proof-of-concept', '2018-11-01 15:24:50', 243),
(274, '768903396526481', 'testtt', '2018-11-02 11:42:08', 273),
(278, '768903396526481', 'test4', '2018-11-02 12:38:30', 276),
(308, '768903396526481', 'test ważności tokenów', '2018-11-09 13:21:48', 307),
(380, '768903396526481', '\"768903396526481\"', '2018-11-10 15:56:00', 379),
(381, '768903396526481', 'test app', '2018-11-10 15:57:46', 379),
(382, '768903396526481', 'test app2', '2018-11-10 16:02:43', 379),
(384, '486565685180077', 'test mobile app', '2018-11-10 16:17:06', 383),
(389, '486565685180077', 'test post 123', '2018-11-10 21:26:09', 388),
(407, '486565685180077', 'test12345', '2018-11-10 21:56:45', 406),
(412, '486565685180077', 'Langusta Mobile App test :)', '2018-11-10 22:13:25', 411),
(418, '486565685180077', 'test 13.11.2018', '2018-11-13 21:13:41', 417),
(421, '486565685180077', 'test1235677', '2018-11-14 10:27:59', 420),
(432, '768903396526481', 'test 22.11.2018', '2018-11-22 21:40:17', 431),
(502, '486565685180077', 'test konkursu 123', '2018-12-09 22:14:15', 501),
(533, '768903396526481', 'mobile app test contest', '2018-12-10 16:24:49', 530),
(565, '486565685180077', 's8 test', '2018-12-12 10:09:51', 564),
(578, '486565685180077', '12345', '2018-12-12 17:28:21', 577),
(597, '486565685180077', 'test', '2018-12-28 00:14:25', 596),
(600, '486565685180077', '1q2w3e4r', '2018-12-28 17:17:20', 599),
(611, '486565685180077', 'test dgjfd ', '2019-01-14 16:59:56', 610),
(642, '768903396526481', 'test123', '2019-01-15 20:51:27', 641),
(646, '486565685180077', 'test afgn', '2019-01-15 21:19:49', 645),
(648, '486565685180077', 'test adaś', '2019-01-15 22:36:09', 647),
(667, '486565685180077', 'xxd', '2019-01-16 10:47:43', 666),
(671, '486565685180077', '123', '2019-01-16 16:44:54', 670);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(682);

-- --------------------------------------------------------

--
-- Table structure for table `platform`
--

CREATE TABLE `platform` (
  `id` int(11) NOT NULL,
  `canonical_name` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `display_name` text COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `platform`
--

INSERT INTO `platform` (`id`, `canonical_name`, `display_name`) VALUES
(1, 'facebook', 'Facebook');

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE `session` (
  `id` int(11) NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  `login_ip` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tracking_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_agent` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `session`
--

INSERT INTO `session` (`id`, `expiry_date`, `login_date`, `login_ip`, `tracking_id`, `user_agent`, `user_id`) VALUES
(138, '2018-10-28 19:18:17', '2018-10-28 19:03:17', '93.105.205.206', '9451400f-95fb-4fd6-be32-ed093e95eb37', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(139, '2018-10-28 19:18:29', '2018-10-28 19:03:29', '31.182.196.176', 'f44ce2b8-3d94-452f-9f09-4bdea4f890b5', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(140, '2018-10-28 19:19:32', '2018-10-28 19:04:32', '93.105.205.206', '4df2b178-63f4-407a-82f7-43983f4c2b60', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(142, '2018-10-28 19:30:00', '2018-10-28 19:15:00', '31.182.196.176', '5127f1f6-f898-49c3-a0ae-44162e50de14', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(143, '2018-10-28 19:38:01', '2018-10-28 19:23:01', '93.105.205.206', 'f3b86fc9-66a0-4df3-a6ef-c2a9f5619651', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(146, '2018-10-28 19:43:49', '2018-10-28 19:28:49', '93.105.205.206', '0359ec53-944b-4e6a-8d7b-2f6bbd59271d', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 137),
(147, '2018-10-28 20:15:39', '2018-10-28 20:00:39', '93.105.205.206', '157262e4-c5a3-433e-9aa6-7cd9404bf59b', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(149, '2018-10-28 20:31:35', '2018-10-28 20:16:35', '93.105.205.206', 'a1082112-7b3d-4c03-a034-55f931310a9f', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(151, '2018-10-28 20:35:46', '2018-10-28 20:20:46', '31.182.196.176', 'c8042f47-030f-4afc-89b5-e2e81f3425bf', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(152, '2018-10-28 20:52:50', '2018-10-28 20:37:50', '31.182.196.176', 'd3d73cba-22c9-4b38-9158-0c6a0e07c008', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(153, '2018-10-28 20:55:25', '2018-10-28 20:40:25', '93.105.205.206', '3ea20a63-2191-4bbf-9cd9-0e0889f85ede', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(154, '2018-10-28 20:58:19', '2018-10-28 20:43:19', '93.105.205.206', 'e9a712b8-5990-47c6-aed7-cc434f848da7', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(156, '2018-10-28 21:47:21', '2018-10-28 21:32:21', '93.105.205.206', '4d90aa14-cc52-4025-8f75-ce42fe289bde', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(157, '2018-10-28 22:04:43', '2018-10-28 21:49:43', '93.105.205.206', '37dc1e58-a8e4-4cd3-a921-6e3d8faaa492', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(158, '2018-10-28 22:37:10', '2018-10-28 22:22:10', '93.105.205.206', '1ff631d4-b136-43c4-8310-5914997763d5', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(160, '2018-10-28 23:01:50', '2018-10-28 22:46:50', '93.105.205.206', 'e8f5b5ce-b2bc-4fee-8584-5b99d924ce00', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(161, '2018-10-28 23:29:23', '2018-10-28 23:14:23', '31.182.196.176', 'f2209781-b27c-4756-8757-fd50aa90fecb', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(162, '2018-10-28 23:47:22', '2018-10-28 23:32:22', '31.182.196.176', '0470aac4-1e4e-4568-bf44-f13bde0cd8e3', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(163, '2018-10-29 00:03:29', '2018-10-28 23:48:29', '31.182.196.176', '80974fa8-a7f3-4ebd-80a3-d8b3b6631209', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(164, '2018-10-29 00:20:59', '2018-10-29 00:05:59', '31.182.196.176', '1c2c4447-1808-4c9c-850a-807b5abbe20b', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(165, '2018-10-29 00:36:15', '2018-10-29 00:21:15', '31.182.196.176', '2b557be7-d788-4634-b449-f8089ec4de14', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(166, '2018-10-29 00:51:21', '2018-10-29 00:36:21', '31.182.196.176', '921a2d94-8f8d-4649-9303-25bf32bc9124', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(167, '2018-10-29 01:06:38', '2018-10-29 00:51:38', '31.182.196.176', '015508bd-f00b-4b20-bb69-9f661698e0a2', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(168, '2018-10-29 01:22:11', '2018-10-29 01:07:11', '31.182.196.176', '6544943a-a647-42c2-bfdc-5b5ea06dc77a', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(169, '2018-10-29 09:19:01', '2018-10-29 09:04:01', '93.105.205.206', '40c7bc31-025b-4b87-812a-8a1acc864244', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(170, '2018-10-30 09:42:18', '2018-10-29 09:42:18', '93.105.205.206', '95a23a48-c5d5-4dd1-a5a6-1cfacc3132a5', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(171, '2018-10-30 09:59:56', '2018-10-29 09:59:56', '31.182.196.176', '16d62570-3d39-4316-b20a-c943cd2b228d', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(172, '2018-10-30 11:17:01', '2018-10-29 11:17:01', '5.173.225.2', '0b64eaf7-3a71-4f49-9e66-2fdb212e7a89', 'Mozilla/5.0 (Linux; Android 7.0; SLA-L22) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.64 Mobile Safari/537.36', 137),
(173, '2018-10-30 12:30:06', '2018-10-29 12:30:06', '178.43.192.14', 'f88667c0-fc28-420c-a6f4-182d667c8675', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 137),
(174, '2018-10-30 12:44:04', '2018-10-29 12:44:04', '178.43.192.14', '8cbe039f-f2a6-4111-93d1-873ab5cc16d0', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 137),
(175, '2018-10-30 13:30:22', '2018-10-29 13:30:22', '31.182.196.176', 'e1d8ebef-5fa7-4ef8-9860-2ce117693ae9', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(176, '2018-10-30 13:39:26', '2018-10-29 13:39:26', '178.43.192.14', 'ac7c774e-30d7-4741-b0b1-c6d3df3c5f47', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(177, '2018-10-30 13:40:47', '2018-10-29 13:40:47', '178.43.192.14', '21915608-254d-4406-a8c2-de256c795546', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(179, '2018-10-30 14:01:59', '2018-10-29 14:01:59', '178.43.192.14', '4eb37e02-94b1-40ea-b9c0-92efb89be3cb', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 178),
(181, '2018-10-30 15:25:45', '2018-10-29 15:25:45', '212.51.207.170', 'ee97f454-4c5e-4f92-a722-fef6c20e3caa', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(182, '2018-10-30 15:45:01', '2018-10-29 15:45:01', '212.51.207.170', '5c2be14b-5bd6-4ff4-ba65-645a0e9b70fa', 'Mozilla/5.0 (Android 7.1.2; Mobile; rv:61.0) Gecko/61.0 Firefox/61.0', 137),
(183, '2018-10-30 16:28:47', '2018-10-29 16:28:47', '212.51.207.170', '4fb6e478-21ab-4fb1-beea-4d4748071d3b', 'Mozilla/5.0 (Android 7.1.2; Mobile; rv:61.0) Gecko/61.0 Firefox/61.0', 137),
(184, '2018-10-30 16:30:23', '2018-10-29 16:30:23', '37.47.62.47', 'e25f88d6-290f-4c94-a36a-c2e6b90bf3b4', 'Mozilla/5.0 (Linux; Android 8.0.0; SM-G950F Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.126 Mobile Safari/537.36', 137),
(185, '2018-10-30 17:34:54', '2018-10-29 17:34:54', '31.182.144.150', '60c3e6b3-233b-4f34-a9c0-6b125d820435', 'Mozilla/5.0 (Linux; Android 7.0; SLA-L22) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.64 Mobile Safari/537.36', 137),
(186, '2018-10-30 18:49:32', '2018-10-29 18:49:32', '31.182.246.165', '40373a30-8cda-472f-ba4f-90ebc31cc5cc', 'Mozilla/5.0 (iPad; CPU OS 10_0_1 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) Version/10.0 Mobile/14A403 Safari/602.1', 137),
(187, '2018-10-30 18:51:39', '2018-10-29 18:51:39', '31.182.246.165', 'f65d3e6e-ac4f-4400-9c6c-292967f18cbc', 'Mozilla/5.0 (iPad; CPU OS 10_0_1 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) Version/10.0 Mobile/14A403 Safari/602.1', 137),
(188, '2018-10-30 18:54:36', '2018-10-29 18:54:36', '31.182.246.165', 'd20442e4-c206-4adb-bc8d-e51919387d01', 'Mozilla/5.0 (iPad; CPU OS 10_0_1 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) Version/10.0 Mobile/14A403 Safari/602.1', 137),
(189, '2018-10-30 18:55:08', '2018-10-29 18:55:08', '31.182.246.165', '61eb0c89-4d75-493d-add5-55597323decc', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12) AppleWebKit/602.1.50 (KHTML, like Gecko) Version/10.0 Safari/602.1.31', 137),
(190, '2018-10-30 22:11:28', '2018-10-29 22:11:28', '31.182.209.34', 'dfc8beff-6d73-47f2-8a65-c92756f26d28', 'Mozilla/5.0 (Android 7.1.2; Mobile; rv:61.0) Gecko/61.0 Firefox/61.0', 137),
(191, '2018-10-30 22:25:31', '2018-10-29 22:25:31', '31.182.196.176', 'd06563bd-bd80-44c9-8d7c-4a4bf5ae8600', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(192, '2018-10-30 22:26:44', '2018-10-29 22:26:44', '31.182.209.34', '968f810c-8861-4cc8-b09a-45b72004857a', 'Mozilla/5.0 (Linux; U; Android 7.1.2; pl-pl; Redmi 4A Build/N2G47H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.128 Mobile Safari/537.36 XiaoMi/MiuiBrowser/10.1.2', 137),
(193, '2018-10-30 22:27:46', '2018-10-29 22:27:46', '31.182.209.34', '943eae04-eb7c-4a4f-8c97-5d7d27d70077', 'Mozilla/5.0 (Android 7.1.2; Mobile; rv:61.0) Gecko/61.0 Firefox/61.0', 137),
(194, '2018-10-31 15:07:38', '2018-10-30 15:07:38', '212.51.207.194', '6220f252-13f5-4301-8028-9f0bcbf0dee6', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36', 137),
(195, '2018-10-31 15:07:40', '2018-10-30 15:07:40', '212.51.207.194', '633c7b4c-de11-43fb-860a-89d0a00dd11b', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36', 137),
(196, '2018-10-31 17:09:04', '2018-10-30 17:09:04', '31.182.209.34', 'cde7f526-634b-4397-9a63-fdd367997329', 'Mozilla/5.0 (Android 7.1.2; Mobile; rv:61.0) Gecko/61.0 Firefox/61.0', 137),
(197, '2018-10-31 17:20:03', '2018-10-30 17:20:03', '31.182.196.176', '6f407d5c-4d31-484e-87ff-684cdbc7a081', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(198, '2018-10-31 18:52:45', '2018-10-30 18:52:45', '178.43.133.24', '146fd5ef-cd25-434c-943c-f4589017a646', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(199, '2018-10-31 18:55:15', '2018-10-30 18:55:15', '178.43.133.24', 'ee251a71-861d-4f43-b866-1eaaebba4099', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(200, '2018-10-31 18:55:37', '2018-10-30 18:55:37', '178.43.133.24', '151386e0-af45-4464-ba8e-710e120e2e25', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(201, '2018-10-31 19:01:20', '2018-10-30 19:01:20', '178.43.133.24', '8f2cc10c-4cd9-4504-b897-dab82034b088', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(202, '2018-10-31 19:02:49', '2018-10-30 19:02:49', '178.43.133.24', '38471342-e69a-4a2e-958e-8e58b4ea86fa', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(204, '2018-10-31 19:09:34', '2018-10-30 19:09:34', '178.43.133.24', 'aecaf4cf-f77d-45c7-899a-636cf1d47ea1', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(206, '2018-10-31 19:10:41', '2018-10-30 19:10:41', '178.43.133.24', 'cec2a110-ab1f-4978-8204-df0ccd57c12b', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(207, '2018-10-31 19:46:29', '2018-10-30 19:46:29', '178.43.133.24', '8caf84eb-2e6f-478d-8600-d90bd0802f39', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(215, '2018-10-31 20:25:18', '2018-10-30 20:25:18', '178.43.133.24', '4b4abb5b-bf64-4aa3-bd45-5beacfbc89a8', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(219, '2018-10-31 20:39:37', '2018-10-30 20:39:37', '178.43.133.24', 'd5b1c2fc-47ab-434d-86bb-e7e06efe3482', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(220, '2018-10-31 21:38:21', '2018-10-30 21:38:21', '178.43.133.24', 'dd9cc2b3-8fc9-4438-b78a-5a4bbb81d659', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(221, '2018-10-31 21:38:27', '2018-10-30 21:38:27', '178.43.133.24', 'c3e6a6db-7235-4690-a352-4537b4ee7643', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(223, '2018-10-31 21:39:59', '2018-10-30 21:39:59', '178.43.133.24', '1457498a-078b-4f92-bcf1-18d27d8608ae', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(224, '2018-10-31 21:55:55', '2018-10-30 21:55:55', '178.43.133.24', 'd3a9304e-75d7-4662-9e9f-c7f777bb7e6d', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(225, '2018-10-31 22:02:22', '2018-10-30 22:02:22', '178.43.133.24', 'ba51591e-9691-4bb5-92a2-a5f14be45ff1', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(226, '2018-10-31 22:04:47', '2018-10-30 22:04:47', '178.43.133.24', '3f9a3625-2f6b-43d6-84cc-f6b41e2c61ac', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(227, '2018-11-01 10:20:49', '2018-10-31 10:20:49', '212.51.207.170', '9b572c11-5cf0-4102-8aec-ecb26e373451', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36', 137),
(229, '2018-11-01 10:29:05', '2018-10-31 10:29:05', '212.51.207.170', '88a50178-f6d2-42a1-b2b5-f353c83c69fa', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(230, '2018-11-01 13:35:45', '2018-10-31 13:35:45', '93.105.205.206', '272d1748-d627-49d7-90fd-f1e6ccaaa145', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(231, '2018-11-01 13:35:45', '2018-10-31 13:35:45', '93.105.205.206', '1679c161-331c-4836-9266-82e7ff22ebc4', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(232, '2018-11-01 13:35:45', '2018-10-31 13:35:45', '93.105.205.206', 'd97e5224-7677-49d0-a2c9-7ee9d50f7f74', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(233, '2018-11-01 13:35:45', '2018-10-31 13:35:45', '93.105.205.206', '760ed73e-bcad-4c95-9581-920be89b2a04', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(234, '2018-11-01 18:15:11', '2018-10-31 18:15:11', '93.105.205.206', 'fc0d3228-3920-4289-91e9-8126fb611901', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(237, '2018-11-02 09:05:17', '2018-11-01 09:05:17', '93.105.205.206', 'fc2112d3-0cc7-452d-9a5e-06630e452157', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(238, '2018-11-02 09:25:43', '2018-11-01 09:25:43', '93.105.205.206', 'f0324925-5bde-4bcd-9d5e-bc17a43fe66e', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(239, '2018-11-02 10:24:13', '2018-11-01 10:24:13', '93.105.205.206', '9d1960ac-59e3-42df-80bf-300c16fc20eb', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(240, '2018-11-02 10:26:28', '2018-11-01 10:26:28', '31.182.196.176', '1b0646aa-9794-4215-97a8-8f9f5d3cdd6b', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(241, '2018-11-02 13:39:43', '2018-11-01 13:39:43', '37.47.37.108', 'ce2d55b9-344e-4a17-879d-e81dc3d9e230', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(242, '2018-11-02 14:03:36', '2018-11-01 14:03:36', '31.182.196.176', '1e978fd7-3793-40d3-8cd3-985fe6e11fef', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(243, '2018-11-02 14:11:59', '2018-11-01 14:11:59', '37.47.37.108', 'a1f8fc53-0480-4a46-92d6-9fb22dd369bd', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(244, '2018-11-02 14:12:21', '2018-11-01 14:12:21', '31.182.196.176', '6b8b5743-ba84-4faf-8d89-039958ca9323', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(268, '2018-11-02 16:47:08', '2018-11-01 16:47:08', '46.45.78.131', '0ab641b7-17cf-4358-93f0-5e3c39e9b3c2', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(269, '2018-11-02 16:48:42', '2018-11-01 16:48:42', '46.45.78.131', 'e3c8f660-f19e-4662-8daa-1f55231b0c6d', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(270, '2018-11-02 17:36:36', '2018-11-01 17:36:36', '46.45.78.131', 'bc392796-a573-4216-985e-649402e7df47', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(271, '2018-11-02 17:41:01', '2018-11-01 17:41:01', '46.45.78.131', 'e4333f01-d6f3-4572-bf43-d5a5614f50cc', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(272, '2018-11-02 18:26:49', '2018-11-01 18:26:49', '31.182.196.176', '4c62819b-44ca-4d0a-aa55-5b96db019c80', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 137),
(273, '2018-11-03 11:41:30', '2018-11-02 11:41:30', '93.105.205.206', 'f2329cf4-21ed-40e1-a14e-cadbb5d7424d', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(276, '2018-11-03 12:37:47', '2018-11-02 12:37:47', '93.105.205.206', 'f62960f0-3957-4648-9f59-d1c351fc5209', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(279, '2018-11-03 12:45:51', '2018-11-02 12:45:51', '93.105.205.206', 'ce32b508-276a-4cb4-a417-73964eaa6170', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(280, '2018-11-03 13:24:43', '2018-11-02 13:24:43', '88.199.11.54', '4bfd0225-9283-4e6d-b737-565db5d49419', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(281, '2018-11-03 13:27:51', '2018-11-02 13:27:51', '88.199.11.54', 'd1e7f0c7-5f69-411b-9fad-8fa82e2cb382', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(282, '2018-11-03 15:55:08', '2018-11-02 15:55:08', '5.184.45.234', 'd4c78c63-65b8-4b76-a5e6-4110f472cbcb', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(283, '2018-11-03 20:43:40', '2018-11-02 20:43:40', '46.45.78.131', '624933a6-3cdd-4f71-a241-45477af937d7', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(284, '2018-11-03 20:49:31', '2018-11-02 20:49:31', '46.45.78.131', '14d13dfd-68d5-486d-b080-ac5d4dfe3a4f', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 137),
(286, '2018-11-03 21:01:50', '2018-11-02 21:01:50', '46.45.78.131', 'be37a9b8-ec63-4368-9fc4-f9d28a990b73', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(287, '2018-11-03 21:34:25', '2018-11-02 21:34:25', '46.45.78.131', '9f36f35b-281a-4720-9f9d-40aadd7857dd', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(288, '2018-11-03 21:38:40', '2018-11-02 21:38:40', '46.45.78.131', '7f366007-19d2-4a3e-9aae-ae128f161235', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 137),
(289, '2018-11-03 21:44:33', '2018-11-02 21:44:33', '46.45.78.131', '6c929cfc-b4ab-4f3c-99b0-ce4fc97e8b21', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(290, '2018-11-03 22:27:17', '2018-11-02 22:27:17', '46.45.78.131', 'f2b973a4-72d4-455b-982d-0f4621c3ed72', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(291, '2018-11-03 22:27:32', '2018-11-02 22:27:32', '46.45.78.131', 'cb2d692d-701b-4f33-a5cc-75708fd7c0a4', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(292, '2018-11-03 22:30:39', '2018-11-02 22:30:39', '46.45.78.131', '092fbbe6-49e3-43d4-abf0-b64866068f21', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(293, '2018-11-03 22:32:46', '2018-11-02 22:32:46', '46.45.78.131', 'beb3ae81-8e03-40ca-bca4-4e41b178ce3e', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(294, '2018-11-03 22:33:07', '2018-11-02 22:33:07', '46.45.78.131', 'fe4d3ca3-a1e2-4dc8-a933-44b4780a06f5', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(295, '2018-11-03 22:39:31', '2018-11-02 22:39:31', '46.45.78.131', '84744924-87ed-42d3-9255-b5d5e1415e0d', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(296, '2018-11-04 10:56:15', '2018-11-03 10:56:15', '31.182.196.176', '66618a93-0b35-4212-b569-359d72ccfddd', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(298, '2018-11-04 11:20:38', '2018-11-03 11:20:38', '31.182.196.176', 'da080816-7ffe-4f03-9d2c-4bb9f5bbe394', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(299, '2018-11-06 11:15:00', '2018-11-05 11:15:00', '178.43.120.71', '54e843b7-8af3-46b2-a500-445624c18a20', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(300, '2018-11-06 11:15:00', '2018-11-05 11:15:00', '178.43.120.71', '2d6e5ab2-1a40-4738-aece-cc9f2f7df70e', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(301, '2018-11-06 11:15:01', '2018-11-05 11:15:01', '178.43.120.71', '73fe41a5-41be-44ac-a528-b750b0717d15', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(302, '2018-11-06 11:15:43', '2018-11-05 11:15:43', '178.43.120.71', '4f0f6997-8ae5-4b6c-af76-5751ba4a584f', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(303, '2018-11-06 11:59:53', '2018-11-05 11:59:53', '178.43.120.71', '7206ce36-c1d7-49b3-bc74-982b2e2b2c27', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(304, '2018-11-06 12:01:48', '2018-11-05 12:01:48', '178.43.120.71', '762d9470-e1a5-450e-8e71-0b8765b06b1f', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(305, '2018-11-06 12:05:50', '2018-11-05 12:05:50', '178.43.120.71', '3c765597-418b-4edf-81e1-10fd3edf85c4', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(306, '2018-11-06 16:04:52', '2018-11-05 16:04:52', '212.51.207.170', '4e6172d0-9f52-47f4-b190-e2557a5e4e4e', 'Mozilla/5.0 (X11; Fedora; Linux x86_64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(307, '2018-11-10 13:21:26', '2018-11-09 13:21:26', '37.47.4.41', '4931775b-af30-49b5-8380-d0fc3b16b513', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(309, '2018-11-10 16:46:25', '2018-11-09 16:46:25', '93.105.205.206', '754df559-8015-47e6-a9a9-7f8d54fe10ef', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(315, '2018-11-10 19:03:25', '2018-11-09 19:03:25', '93.105.205.206', '11f4023f-fe7f-4ae4-8bf5-23fd2fece157', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(316, '2018-11-10 19:04:13', '2018-11-09 19:04:13', '93.105.205.206', '6885ea6e-9dd9-4168-a9aa-31b84ef2f9e1', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(317, '2018-11-10 19:08:28', '2018-11-09 19:08:28', '93.105.205.206', 'fb2edd1d-de0d-4523-955f-0c891ea604fa', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(319, '2018-11-10 19:49:13', '2018-11-09 19:49:13', '178.43.80.240', '0c5c7d9d-410d-4d8e-bd2f-8fbfa89af001', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(320, '2018-11-10 20:11:11', '2018-11-09 20:11:11', '178.43.80.240', 'e69ef108-9ec0-4594-8d9c-88e4aec57c61', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(321, '2018-11-10 20:14:03', '2018-11-09 20:14:03', '178.43.80.240', '6f9b3d25-32cb-4d72-8fc6-05149e0ad7a6', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(322, '2018-11-10 20:17:49', '2018-11-09 20:17:49', '31.182.196.176', '0cb5d2f0-decd-4372-b927-c7c4970de619', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(323, '2018-11-10 20:17:56', '2018-11-09 20:17:56', '31.182.196.176', 'd44a7aed-fa04-4408-8ecd-035964b25ee3', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(324, '2018-11-10 20:18:26', '2018-11-09 20:18:26', '31.182.196.176', '68026137-7857-4a62-8dc7-0da74ba2da84', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(325, '2018-11-10 20:18:33', '2018-11-09 20:18:33', '31.182.196.176', '3a3d0827-e825-4c52-8a86-455fe3dc4c59', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(326, '2018-11-10 20:18:41', '2018-11-09 20:18:41', '31.182.196.176', 'e8e587b1-308b-467a-be0d-90ae0fe48521', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(327, '2018-11-10 20:18:59', '2018-11-09 20:18:59', '31.182.196.176', '5330729e-63e1-4f46-85e6-df13f066338b', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(328, '2018-11-10 20:20:33', '2018-11-09 20:20:33', '31.182.196.176', 'ec8f3643-f0af-40d4-933d-653b1277d0d5', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(329, '2018-11-10 20:20:39', '2018-11-09 20:20:39', '31.182.196.176', 'c501ef13-593f-4c21-aa31-df8b928c6772', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(330, '2018-11-10 20:21:15', '2018-11-09 20:21:15', '31.182.196.176', '8fe2f990-bc3b-46fa-be6e-134f00381aa2', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(331, '2018-11-10 20:21:54', '2018-11-09 20:21:54', '31.182.196.176', '0ab4e135-8d47-4b4d-976a-f224b36789ab', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(332, '2018-11-10 20:23:06', '2018-11-09 20:23:06', '31.182.196.176', '70ff30a7-ea9f-4b56-adc6-66ba9df940ec', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(333, '2018-11-10 20:42:21', '2018-11-09 20:42:21', '31.182.196.176', 'f88b1725-4833-41d1-8eb8-50c57ff9c164', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(334, '2018-11-10 20:42:30', '2018-11-09 20:42:30', '31.182.196.176', '625ab34b-83de-44ad-b895-2c987d1fb591', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(335, '2018-11-10 20:42:41', '2018-11-09 20:42:41', '93.105.205.206', 'af873038-7b01-455e-bb0f-7a4b3c6c82f7', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(336, '2018-11-10 20:43:02', '2018-11-09 20:43:02', '93.105.205.206', 'fd3f0b7b-cee5-48ff-ac13-9861eeae7b5e', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(337, '2018-11-10 20:43:27', '2018-11-09 20:43:27', '93.105.205.206', 'eb314dad-0bf4-457a-91f0-309258c0af74', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(338, '2018-11-10 20:43:43', '2018-11-09 20:43:43', '31.182.196.176', '37778dfe-7aad-4d90-a328-51ee330dabb4', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(339, '2018-11-10 20:52:00', '2018-11-09 20:52:00', '178.43.80.240', '54b8d126-4096-49ee-ac2d-570830ce3b46', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 137),
(340, '2018-11-10 20:52:11', '2018-11-09 20:52:11', '178.43.80.240', '4a5e1a69-6218-4697-8763-62d0049af441', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 137),
(341, '2018-11-10 21:14:18', '2018-11-09 21:14:18', '178.43.80.240', 'a97375d4-0840-4983-a62c-9e310d2218e1', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(342, '2018-11-10 21:23:17', '2018-11-09 21:23:17', '178.43.80.240', '2e4d3427-8fc6-46ee-a531-5335c9dc5361', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(343, '2018-11-10 23:07:20', '2018-11-09 23:07:20', '178.43.80.240', '7ad7d492-decd-41f7-99c3-6b5f00e90232', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(344, '2018-11-11 10:01:31', '2018-11-10 10:01:31', '178.43.210.156', 'a21fd30c-a44d-45af-8440-7a1ef3d40007', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(345, '2018-11-11 10:15:39', '2018-11-10 10:15:39', '178.43.210.156', 'e808f566-df42-49d4-a793-039d83d229ee', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(346, '2018-11-11 11:07:51', '2018-11-10 11:07:51', '178.43.210.156', '67055901-1e19-44e7-9614-ae7323b36d5e', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(347, '2018-11-11 11:29:23', '2018-11-10 11:29:23', '93.105.205.206', 'eb0cd406-d5a4-45cb-9fba-5a66e5ccbe1b', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(348, '2018-11-11 11:29:23', '2018-11-10 11:29:23', '93.105.205.206', 'd874161c-8959-46e0-a1a0-b95a3714af12', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(349, '2018-11-11 11:29:56', '2018-11-10 11:29:56', '93.105.205.206', '28e768df-c008-424d-83bb-8419a4373f16', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(350, '2018-11-11 11:30:24', '2018-11-10 11:30:24', '93.105.205.206', '19fed811-5daa-4aec-9f94-6f5649699fe9', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(351, '2018-11-11 11:32:08', '2018-11-10 11:32:08', '178.43.210.156', 'ec673d21-d335-433f-a921-b1150302e678', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(352, '2018-11-11 11:53:53', '2018-11-10 11:53:53', '93.105.205.206', 'dc69955d-78d4-4fbc-84d2-475a28e5e23b', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(353, '2018-11-11 11:59:21', '2018-11-10 11:59:21', '178.43.210.156', '26b0784a-8a8a-41a0-b4e7-106a9fb6deff', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(354, '2018-11-11 12:00:59', '2018-11-10 12:00:59', '93.105.205.206', '101879df-a469-4255-a97f-a23938f0cecf', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(355, '2018-11-11 12:04:01', '2018-11-10 12:04:01', '93.105.205.206', 'ff8b2465-39d0-4dc5-ba41-9c20ea728cb7', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(356, '2018-11-11 12:05:18', '2018-11-10 12:05:18', '178.43.210.156', 'cb797b82-099d-4c02-ab25-d42e5c1849ab', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(357, '2018-11-11 12:12:17', '2018-11-10 12:12:17', '178.43.210.156', '2f4a7adc-9a97-445b-bc39-472ea8aeec22', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(358, '2018-11-11 12:24:38', '2018-11-10 12:24:38', '178.43.210.156', '18632432-796c-4974-afdf-d4449fb8a0c5', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(359, '2018-11-11 12:26:53', '2018-11-10 12:26:53', '178.43.210.156', '63df6f43-66d6-4a9c-8430-083df2718d7a', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(360, '2018-11-11 12:28:04', '2018-11-10 12:28:04', '178.43.210.156', '599c14c1-33a4-41d8-95d2-1996c7349554', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(361, '2018-11-11 12:39:28', '2018-11-10 12:39:28', '178.43.210.156', 'c7e5340f-c79c-4c64-981e-b8ba8e82237e', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(362, '2018-11-11 12:41:17', '2018-11-10 12:41:17', '178.43.210.156', '5dd5eb0c-dcb3-428a-9055-3c665d05a541', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(363, '2018-11-11 12:49:46', '2018-11-10 12:49:46', '178.43.210.156', 'ecf9cc91-ac27-466b-a8a9-d351e8febe02', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(364, '2018-11-11 12:49:53', '2018-11-10 12:49:53', '178.43.210.156', 'f60638ed-32c9-4f68-a6db-fc84042cc332', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(365, '2018-11-11 12:50:24', '2018-11-10 12:50:24', '178.43.210.156', '36d17581-3e12-47fc-a29f-8297f51d5e53', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(366, '2018-11-11 12:51:06', '2018-11-10 12:51:06', '178.43.210.156', '084b06e9-718f-4c88-8df2-21f8a68c0ff8', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(367, '2018-11-11 12:57:05', '2018-11-10 12:57:05', '178.43.210.156', 'db98e197-ada2-48b3-a0e6-098e43200be5', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(368, '2018-11-11 13:05:29', '2018-11-10 13:05:29', '178.43.210.156', '16056c23-7140-4741-9e6d-182f52e1baf9', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(369, '2018-11-11 13:08:45', '2018-11-10 13:08:45', '178.43.210.156', '5c9c7e5a-ee75-4473-b7f2-fd531033fdf8', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(370, '2018-11-11 13:16:28', '2018-11-10 13:16:28', '178.43.210.156', '5121650e-9513-4b3f-9e2c-2461ec75f6ad', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(371, '2018-11-11 13:59:57', '2018-11-10 13:59:57', '178.43.210.156', 'b6478a90-43cc-4c98-8256-2258c6d71143', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(372, '2018-11-11 14:02:40', '2018-11-10 14:02:40', '178.43.210.156', '955c2cc3-b262-4f20-9eb1-eb5e47b1da00', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(373, '2018-11-11 14:02:50', '2018-11-10 14:02:50', '178.43.210.156', 'f272710f-6031-4dda-b50e-a85e47797fd4', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(374, '2018-11-11 14:11:21', '2018-11-10 14:11:21', '178.43.210.156', 'b2016e61-735d-47e6-a186-60621a997d0f', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(375, '2018-11-11 14:53:08', '2018-11-10 14:53:08', '178.43.210.156', '9da77159-f48a-498e-9d0a-69640cf39e0f', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(376, '2018-11-11 15:00:35', '2018-11-10 15:00:35', '178.43.210.156', '1b27f820-59a7-4b08-a564-1c9c911bd488', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(377, '2018-11-11 15:18:47', '2018-11-10 15:18:47', '178.43.210.156', '9086deac-fe18-431a-b270-4ac461d7fed1', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(378, '2018-11-11 15:44:19', '2018-11-10 15:44:19', '31.182.196.176', 'c2aeb570-2236-420b-9c90-2d61ab098258', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(379, '2018-11-11 15:55:46', '2018-11-10 15:55:46', '178.43.210.156', '2adf8422-4fa1-4887-9271-b99c01cba315', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(383, '2018-11-11 16:15:18', '2018-11-10 16:15:18', '178.43.210.156', '6b2da856-3631-48d2-bb4a-99842d496873', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 178),
(385, '2018-11-11 21:17:40', '2018-11-10 21:17:40', '178.43.210.156', '2d796002-0a65-4492-8499-8fafb399ec4d', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(386, '2018-11-11 21:19:34', '2018-11-10 21:19:34', '178.43.210.156', 'e91bd66b-ad1c-480b-b91f-1ea149af3aa7', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 178),
(387, '2018-11-11 21:23:26', '2018-11-10 21:23:26', '178.43.210.156', 'e2f21305-cb80-450d-b389-eb9cc6d0a506', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(388, '2018-11-11 21:25:50', '2018-11-10 21:25:50', '178.43.210.156', 'de7b1a10-6c88-4e80-ba27-67b1e472ca04', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 178),
(390, '2018-11-11 21:29:22', '2018-11-10 21:29:22', '178.43.210.156', '1afb3aff-d27c-4be3-a671-c7662bbd2112', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(391, '2018-11-11 21:29:45', '2018-11-10 21:29:45', '178.43.210.156', '3b488771-0aef-4c42-8058-5cfce696107d', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(392, '2018-11-11 21:30:18', '2018-11-10 21:30:18', '178.43.210.156', 'e0b24fc3-a8ed-49ce-9582-fd00d5fba47d', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(393, '2018-11-11 21:30:30', '2018-11-10 21:30:30', '93.105.205.206', 'c626a674-4072-44c8-9923-863b16539f42', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(394, '2018-11-11 21:31:26', '2018-11-10 21:31:26', '178.43.210.156', '5af04c92-9c67-4193-9588-10ac68346509', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(395, '2018-11-11 21:31:55', '2018-11-10 21:31:55', '178.43.210.156', 'ada06429-51dd-476c-b9fb-30100aac1d06', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(397, '2018-11-11 21:36:23', '2018-11-10 21:36:23', '178.43.210.156', 'fb45afad-aa36-4f14-b686-e2f2442ed376', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(398, '2018-11-11 21:36:57', '2018-11-10 21:36:57', '178.43.210.156', 'eda5179a-7b10-4d12-9ae9-9cf0015c9f57', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 137),
(399, '2018-11-11 21:42:10', '2018-11-10 21:42:10', '31.182.196.176', 'ffb7464b-3ab3-4c54-8169-984cb8f8e0e1', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(401, '2018-11-11 21:52:58', '2018-11-10 21:52:58', '178.43.210.156', '19e33fb8-ba61-4455-99d1-ad228093fc8b', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(402, '2018-11-11 21:55:17', '2018-11-10 21:55:17', '178.43.210.156', '81af4950-229e-4866-a95b-13298fa4c51e', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 137),
(403, '2018-11-11 21:55:28', '2018-11-10 21:55:28', '93.105.205.206', '3895af8a-7497-4d09-a793-b4e3ee557b4c', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(405, '2018-11-11 21:56:26', '2018-11-10 21:56:26', '93.105.205.206', '9eed53ed-b7be-4b34-adb9-c9d94c7d194d', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(406, '2018-11-11 21:56:31', '2018-11-10 21:56:31', '178.43.210.156', '2f70963f-133c-4a45-b75a-34d1cb6acc6e', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 178),
(408, '2018-11-11 22:03:29', '2018-11-10 22:03:29', '178.43.210.156', '21bb85b3-fa2d-41bd-ba98-4c82156d8e28', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 178),
(410, '2018-11-11 22:05:43', '2018-11-10 22:05:43', '178.43.210.156', 'd7a34b33-72aa-4621-b37e-67dbd99383e0', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 178),
(411, '2018-11-11 22:12:43', '2018-11-10 22:12:43', '178.43.210.156', 'f7d2f808-766a-4fa9-95f2-32bfe3a5a286', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(413, '2018-11-12 12:53:43', '2018-11-11 12:53:43', '31.182.196.176', '7cab0b5b-09fa-4389-b777-570eb1f701f7', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(414, '2018-11-12 13:06:13', '2018-11-11 13:06:13', '178.43.188.161', '06cdaed5-993f-4079-aa0a-0f6d301acb0e', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 178),
(415, '2018-11-12 13:07:54', '2018-11-11 13:07:54', '178.43.188.161', '98253be1-ec8c-4524-865f-1cd1a3a90a60', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(416, '2018-11-12 13:09:15', '2018-11-11 13:09:15', '178.43.188.161', 'c444aac8-01da-4c38-b982-ffcdb7aba760', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(417, '2018-11-14 21:13:13', '2018-11-13 21:13:13', '178.43.127.196', '7a04257f-ca19-43a4-905b-3b9b2818b856', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(419, '2018-11-15 10:25:26', '2018-11-14 10:25:26', '212.51.207.170', '54a64104-9355-4129-8b4c-9c26c84d3613', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36', 137),
(420, '2018-11-15 10:27:39', '2018-11-14 10:27:39', '212.51.207.170', 'a8bb2ca1-afe2-480d-92b6-99dd3d09ea0f', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(422, '2018-11-17 13:08:47', '2018-11-16 13:08:47', '37.47.40.216', '6c684152-740f-4a6d-a13a-1c0b5c199e13', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(423, '2018-11-17 13:15:03', '2018-11-16 13:15:03', '37.47.40.216', '757bc1cf-36e5-4fa3-bd05-5a2a8f165cc5', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 137),
(424, '2018-11-23 18:24:00', '2018-11-22 18:24:00', '178.43.189.201', '9423eb31-022f-4e0d-a767-30eb31db6810', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36', 137),
(425, '2018-11-23 18:24:00', '2018-11-22 18:24:00', '178.43.189.201', '010002bd-c8cc-4fd1-96b0-be9f2218f39d', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36', 137),
(426, '2018-11-23 18:24:00', '2018-11-22 18:24:00', '178.43.189.201', '65e83ff0-2206-4db6-8413-11a6b28a27cd', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36', 137),
(427, '2018-11-23 18:24:00', '2018-11-22 18:24:00', '178.43.189.201', '0ab1fd94-85da-4dc9-9d50-2a57c2f5d5a8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36', 137),
(428, '2018-11-23 18:24:00', '2018-11-22 18:24:00', '178.43.189.201', '4d728181-ed82-43ac-b343-70f1c1d09d6c', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36', 137),
(429, '2018-11-23 18:24:00', '2018-11-22 18:24:00', '178.43.189.201', 'f11a3b41-92fc-4db6-a86d-f059c89ebd91', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36', 137),
(430, '2018-11-23 18:24:10', '2018-11-22 18:24:10', '178.43.189.201', 'ccd0d4bb-491a-459c-9b4f-5b4e3518d27f', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36', 137),
(431, '2018-11-23 21:39:56', '2018-11-22 21:39:56', '178.43.189.201', '6b0c47da-5547-4c27-85a4-3bb386fec0ae', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; Android SDK built for x86 Build/OSR1.170901.043)', 137),
(433, '2018-11-25 14:58:21', '2018-11-24 14:58:21', '93.105.205.206', '72926344-c207-40d4-8f53-8eb28baf8c6c', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(434, '2018-11-25 17:52:18', '2018-11-24 17:52:18', '93.105.205.206', 'd549d88a-6407-401c-a67a-880987c3186e', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(437, '2018-11-25 19:12:35', '2018-11-24 19:12:35', '93.105.205.206', '1829a80c-fa3c-403a-87dc-754b795ffd38', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(438, '2018-11-25 19:39:21', '2018-11-24 19:39:21', '93.105.205.206', '4d7ffeed-befd-493c-8978-d034e5ca4239', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(439, '2018-11-25 20:37:51', '2018-11-24 20:37:51', '93.105.205.206', 'b4c5b079-f8c7-466a-aa27-554c826a98f5', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(440, '2018-11-26 10:12:40', '2018-11-25 10:12:40', '93.105.205.206', '6abaf4c7-56a4-4cea-9829-21c99915099e', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(442, '2018-12-07 21:07:38', '2018-12-06 21:07:38', '93.105.205.206', '8bb102e9-6422-4103-81da-df2af8bc7416', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(443, '2018-12-08 14:24:23', '2018-12-07 14:24:23', '31.182.196.176', 'acee60ad-d263-4d4c-8fc6-2734779400cc', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(444, '2018-12-08 14:36:01', '2018-12-07 14:36:01', '31.182.196.176', 'a47f4dda-6c64-4ea5-9abe-c276177ba841', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(445, '2018-12-08 14:42:44', '2018-12-07 14:42:44', '31.182.196.176', '8526d6d1-38eb-4941-af64-0301ca23d71e', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(446, '2018-12-08 17:30:13', '2018-12-07 17:30:13', '93.105.205.206', '1fcfa7c8-838d-465a-8817-294589b289ee', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(449, '2018-12-08 17:40:29', '2018-12-07 17:40:29', '31.182.196.176', '0e876762-f3f6-4c55-89cd-0ee03b946be5', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(453, '2018-12-09 13:26:12', '2018-12-08 13:26:12', '93.105.205.206', '0ae9d241-3cd0-41b6-8afe-a24d7febfacb', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(454, '2018-12-09 13:26:41', '2018-12-08 13:26:41', '93.105.205.206', '9831b24c-2e69-4dc5-a4e4-7589e449604a', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(455, '2018-12-09 17:12:30', '2018-12-08 17:12:30', '178.43.209.190', '7977904b-d346-43ed-a72b-9868f259ed57', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(456, '2018-12-09 20:15:29', '2018-12-08 20:15:29', '178.43.209.190', '5681338b-dcf3-4d76-87ee-bca01124b662', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36', 137),
(457, '2018-12-09 20:22:36', '2018-12-08 20:22:36', '178.43.209.190', '4ecf4c4e-aced-42af-aaf3-e5e0225148f3', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(458, '2018-12-10 16:23:49', '2018-12-09 16:23:49', '37.47.39.210', '99a3f17f-df21-4715-b757-a706f66fa9a1', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36', 275),
(461, '2018-12-10 17:30:30', '2018-12-09 17:30:30', '93.105.205.206', '958ccaca-f614-4d03-9ba7-74c909778378', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36', 275),
(462, '2018-12-10 17:30:48', '2018-12-09 17:30:48', '93.105.205.206', '5518a97a-8371-4b0a-9601-51e63dda1bda', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(463, '2018-12-10 19:44:36', '2018-12-09 19:44:36', '178.43.209.200', '82a8d345-c66a-4a24-be18-0dc3897fb03d', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(464, '2018-12-10 20:01:12', '2018-12-09 20:01:12', '178.43.209.200', '1091740e-66fd-4e3c-a2fa-bad22be3bc32', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(465, '2018-12-10 20:09:13', '2018-12-09 20:09:13', '178.43.209.200', 'd0e38aa5-0c2f-41f5-a4ca-8ca9eb0b5584', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(466, '2018-12-10 20:10:19', '2018-12-09 20:10:19', '178.43.209.200', 'df1ce72e-b8f2-4d6a-8590-2b576dd52f07', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(467, '2018-12-10 20:25:07', '2018-12-09 20:25:07', '178.43.209.200', '1f9e6182-f69c-42f3-bcf9-bc088828de83', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(468, '2018-12-10 20:27:41', '2018-12-09 20:27:41', '178.43.209.200', '3b955ac3-ef3c-43bf-ba66-08f8b0805330', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137);
INSERT INTO `session` (`id`, `expiry_date`, `login_date`, `login_ip`, `tracking_id`, `user_agent`, `user_id`) VALUES
(469, '2018-12-10 20:28:31', '2018-12-09 20:28:31', '178.43.209.200', '1d3228a3-f3fe-4d42-a480-1657aec7dbf6', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(470, '2018-12-10 20:36:21', '2018-12-09 20:36:21', '178.43.209.200', 'fe3eb9cd-904b-4ac6-bfdc-45eac31b0bbc', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(471, '2018-12-10 20:38:54', '2018-12-09 20:38:54', '178.43.209.200', '312d01c5-0c7a-456b-b45c-895eae8812d4', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(472, '2018-12-10 20:39:02', '2018-12-09 20:39:02', '178.43.209.200', '05b1087b-8e2e-4c62-9f92-dd3e5198144b', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(473, '2018-12-10 20:41:27', '2018-12-09 20:41:27', '178.43.209.200', '28133810-cc53-44b2-9cb7-ad8b85c26701', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(474, '2018-12-10 20:53:47', '2018-12-09 20:53:47', '178.43.209.200', '33ec51d1-7c09-4e0c-b47a-005b931526ae', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(475, '2018-12-10 20:54:00', '2018-12-09 20:54:00', '178.43.209.200', '3b6d0e0a-4eb3-41dd-8fd2-04cc36ae6a17', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(476, '2018-12-10 20:57:01', '2018-12-09 20:57:01', '178.43.209.200', 'edf0ff43-40cc-4b58-bb16-a60175433c7f', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36', 137),
(477, '2018-12-10 21:08:59', '2018-12-09 21:08:59', '178.43.209.200', '5dad498d-ad35-423d-8c3d-1d409d9b8f50', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(478, '2018-12-10 21:11:51', '2018-12-09 21:11:51', '178.43.209.200', '52fa6263-fd67-4be5-be6d-364582c25b53', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(479, '2018-12-10 21:15:05', '2018-12-09 21:15:05', '178.43.209.200', '149df58c-8a11-441c-94a9-ffa8386a904c', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(480, '2018-12-10 21:16:52', '2018-12-09 21:16:52', '178.43.209.200', 'f53beaf7-4d58-4258-9f40-d0ae1b747788', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(481, '2018-12-10 21:20:42', '2018-12-09 21:20:42', '178.43.209.200', '3e12a91f-3755-4073-a6b4-783b8c6cfcb9', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(482, '2018-12-10 21:22:18', '2018-12-09 21:22:18', '178.43.209.200', '5f569e89-9253-44ae-9548-d0a1a9c520eb', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(483, '2018-12-10 21:23:07', '2018-12-09 21:23:07', '178.43.209.200', '318db184-9603-486f-bf95-2e1f0b94d246', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(484, '2018-12-10 21:23:53', '2018-12-09 21:23:53', '178.43.209.200', 'ae6ee9e7-41c3-43f3-ae0a-1aa3c78e3c24', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(485, '2018-12-10 21:25:46', '2018-12-09 21:25:46', '178.43.209.200', '1b009bf6-8ebb-42e7-9b91-cf6bef9397fb', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(486, '2018-12-10 21:27:00', '2018-12-09 21:27:00', '178.43.209.200', 'c6de0ada-f4be-48a7-82e6-fb32e378280a', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(487, '2018-12-10 21:28:06', '2018-12-09 21:28:06', '178.43.209.200', '9832aa5a-6b11-431f-b0ee-8bd165e82f02', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(488, '2018-12-10 21:31:16', '2018-12-09 21:31:16', '178.43.209.200', '52e55117-41a2-48d9-8c83-f507e5ac6c9a', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(489, '2018-12-10 21:36:41', '2018-12-09 21:36:41', '178.43.209.200', '32c14fe9-48d1-463e-b5f4-3240466fbbd8', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(490, '2018-12-10 21:36:54', '2018-12-09 21:36:54', '178.43.209.200', '05563365-b4cc-4d46-9278-b24d01315fc2', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(491, '2018-12-10 21:38:25', '2018-12-09 21:38:25', '178.43.209.200', '502047e3-6df0-47af-86e1-d38a47cc5ef6', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(492, '2018-12-10 21:38:46', '2018-12-09 21:38:46', '178.43.209.200', '1636b902-ffe6-45c9-b354-4939edb643e4', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(493, '2018-12-10 21:40:25', '2018-12-09 21:40:25', '178.43.209.200', 'ae460118-cf6a-4817-a5eb-1539a65d02b4', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(494, '2018-12-10 21:40:49', '2018-12-09 21:40:49', '178.43.209.200', '5a969d14-d7d0-4513-a360-1937c16701e9', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(495, '2018-12-10 21:41:27', '2018-12-09 21:41:27', '178.43.209.200', '76f49534-ae9f-44db-be1a-ad930cc62126', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(496, '2018-12-10 21:51:41', '2018-12-09 21:51:41', '178.43.209.200', 'e92ccb58-92e6-43bf-a0ac-61a1968abefa', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(497, '2018-12-10 21:54:46', '2018-12-09 21:54:46', '178.43.209.200', 'b45012b3-7eca-4c55-8115-8d8b0d26be1d', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(498, '2018-12-10 21:57:17', '2018-12-09 21:57:17', '178.43.209.200', '0b07378c-92f6-40c1-9a04-cd96d663e13c', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(499, '2018-12-10 22:02:10', '2018-12-09 22:02:10', '178.43.209.200', 'c664acd6-d438-4892-850c-7cf5121a7861', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(500, '2018-12-10 22:03:42', '2018-12-09 22:03:42', '178.43.209.200', 'f743c728-ab80-40d8-8cb5-e9b997443bef', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(501, '2018-12-10 22:14:01', '2018-12-09 22:14:01', '178.43.209.200', '49aa1f3c-b48e-4c5f-8102-4bcf8fee8e1d', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(503, '2018-12-10 22:17:28', '2018-12-09 22:17:28', '178.43.209.200', '97fa5293-0c23-4a51-95c0-adcda529df5b', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(504, '2018-12-10 23:38:50', '2018-12-09 23:38:50', '178.43.209.200', 'c10eb62b-ec59-45c9-952e-a0ac19319812', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(505, '2018-12-10 23:40:48', '2018-12-09 23:40:48', '178.43.209.200', '463aca83-aeca-43e6-b7a6-fe4c343232f6', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(506, '2018-12-10 23:41:40', '2018-12-09 23:41:40', '178.43.209.200', '26cf5275-b096-43fe-afd3-ef7babae798a', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(507, '2018-12-10 23:41:58', '2018-12-09 23:41:58', '178.43.209.200', 'a22dfebc-8679-49cb-afd2-d5bbb8c0e1b2', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(508, '2018-12-10 23:44:58', '2018-12-09 23:44:58', '178.43.209.200', '77f08709-ff2b-4b70-b120-c555cb8ef4ec', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(509, '2018-12-10 23:45:06', '2018-12-09 23:45:06', '178.43.209.200', '0fd63ac0-8e5d-4169-820e-22264a5ab299', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(510, '2018-12-10 23:45:48', '2018-12-09 23:45:48', '178.43.209.200', '9e41d029-58ba-452f-b45f-2b54abd4dc6b', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(511, '2018-12-10 23:52:01', '2018-12-09 23:52:01', '178.43.209.200', 'a421b2f1-d168-435b-bea0-11ff740e5856', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(512, '2018-12-10 23:52:18', '2018-12-09 23:52:18', '178.43.209.200', 'd7e25cb1-b79a-445e-a673-f90c84735a3d', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(513, '2018-12-10 23:53:18', '2018-12-09 23:53:18', '178.43.209.200', '574ca5cf-3ca9-45d7-bdb0-91614a23ef9e', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(514, '2018-12-10 23:53:32', '2018-12-09 23:53:32', '178.43.209.200', 'ddb0d501-8e8b-40ff-a856-e8883368764e', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(515, '2018-12-10 23:55:03', '2018-12-09 23:55:03', '178.43.209.200', 'f6ade79b-74db-4fb2-88a3-2d37416fe593', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(516, '2018-12-10 23:57:25', '2018-12-09 23:57:25', '178.43.209.200', 'cddd0a75-993f-4caf-9f07-5354e7113404', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(517, '2018-12-10 23:58:31', '2018-12-09 23:58:31', '178.43.209.200', '84eb86e7-6a83-41d2-81c9-4bfc8cc4e101', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(518, '2018-12-10 23:59:09', '2018-12-09 23:59:09', '178.43.209.200', '6bbf0dbc-70e0-42fc-89bf-9ba04175360d', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(519, '2018-12-11 00:01:33', '2018-12-10 00:01:33', '178.43.209.200', '4121b8b4-5f65-4615-a8fa-4e5877d562ff', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(520, '2018-12-11 00:01:49', '2018-12-10 00:01:49', '178.43.209.200', '29971b7c-b123-4428-99a0-165e78bb9972', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(521, '2018-12-11 12:45:04', '2018-12-10 12:45:04', '185.62.182.27', '651c9e11-1c29-4fee-bbd2-560cebfa43d1', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(522, '2018-12-11 12:45:08', '2018-12-10 12:45:08', '185.62.182.27', '9758f505-157f-478b-9126-692979b89aa8', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(523, '2018-12-11 14:23:02', '2018-12-10 14:23:02', '185.62.182.27', '6775d8c9-f9a8-40c7-9cc4-df7ab5f93bd6', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(524, '2018-12-11 14:26:13', '2018-12-10 14:26:13', '185.62.182.27', 'bc0fd8d5-6e27-4edf-a372-56fbb2a5345d', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(525, '2018-12-11 14:35:22', '2018-12-10 14:35:22', '185.62.182.27', 'b57667fd-48a2-46ec-86f0-0648ec479fe4', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(526, '2018-12-11 14:35:43', '2018-12-10 14:35:43', '185.62.182.27', '7653fff2-6562-4355-b01a-8e09b5fed1c7', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(527, '2018-12-11 14:39:05', '2018-12-10 14:39:05', '185.62.182.27', '0c00e3b1-feb0-4987-8aae-d6db0227bcf7', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(528, '2018-12-11 14:39:48', '2018-12-10 14:39:48', '185.62.182.27', 'c8eefb05-a73b-407a-b351-138505e70182', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(529, '2018-12-11 14:43:07', '2018-12-10 14:43:07', '185.62.182.27', 'a818c383-dec3-48e6-98a2-17e676e2620b', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(530, '2018-12-11 14:52:08', '2018-12-10 14:52:08', '185.62.182.27', 'ba15c376-9d3c-4e20-af19-266267dca3aa', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(534, '2018-12-11 16:29:32', '2018-12-10 16:29:32', '212.51.207.170', '4f35f150-64d7-4a40-abcc-7275e63730d2', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 275),
(539, '2018-12-11 16:52:43', '2018-12-10 16:52:43', '212.51.207.170', 'ec409478-c16d-4f7c-87b5-8d7436683a9c', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 178),
(541, '2018-12-11 17:01:38', '2018-12-10 17:01:38', '212.51.207.170', '1e5008bf-9e57-4cba-aa71-f74f9e3e544f', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36', 137),
(542, '2018-12-11 17:04:49', '2018-12-10 17:04:49', '212.51.207.170', '21f1dedd-cf57-4c89-bb10-6694a4f739e4', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(543, '2018-12-11 17:08:13', '2018-12-10 17:08:13', '212.51.207.170', 'f5011831-531c-4765-beac-f369e4eec792', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(544, '2018-12-11 17:08:13', '2018-12-10 17:08:13', '212.51.207.170', 'b2c1d3d7-68e5-49c0-b401-a32b87860b58', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(545, '2018-12-11 17:08:13', '2018-12-10 17:08:13', '212.51.207.170', '90e4e1ea-1f0c-49aa-9055-93161fb01f1b', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(546, '2018-12-11 17:08:14', '2018-12-10 17:08:14', '212.51.207.170', '1f51228a-69f0-48aa-b653-8e7a37b3a839', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(547, '2018-12-11 17:08:15', '2018-12-10 17:08:15', '212.51.207.170', 'bbf0833e-1180-42ef-a9d2-deb43a7ab285', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(548, '2018-12-11 17:09:08', '2018-12-10 17:09:08', '212.51.207.170', '66f6ef02-4b50-473b-8a3d-465215f6201c', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 178),
(549, '2018-12-11 17:18:49', '2018-12-10 17:18:49', '212.51.207.170', '0a039662-26aa-4ebf-8852-a5cab892acac', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(551, '2018-12-11 18:51:34', '2018-12-10 18:51:34', '37.47.6.7', '8e438427-bdd5-4be1-a08e-782b7048308f', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(552, '2018-12-11 19:02:04', '2018-12-10 19:02:04', '37.47.6.7', 'f5bd8ac7-d140-48ac-840c-800d52f95269', 'Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0', 275),
(553, '2018-12-12 17:31:45', '2018-12-11 17:31:45', '31.182.196.176', '5dd6c157-7979-4082-9b36-dbef0cc13447', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(554, '2018-12-12 18:32:34', '2018-12-11 18:32:34', '31.182.196.176', '2dee1959-3606-42d5-9a6a-513a318e394c', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(555, '2018-12-12 18:50:30', '2018-12-11 18:50:30', '31.182.196.176', 'aa972a5b-c9eb-4758-8efc-536d9b8f0ed1', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(556, '2018-12-12 19:17:09', '2018-12-11 19:17:09', '31.182.196.176', '762704f5-27b5-4220-9c75-d8d044ec05a9', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(559, '2018-12-12 19:56:43', '2018-12-11 19:56:43', '31.182.196.176', '5208b807-6768-49d5-aadc-d44106645e8a', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0', 137),
(560, '2018-12-13 08:28:32', '2018-12-12 08:28:32', '212.51.207.170', '4fec4e98-6e9e-49dd-b154-44acd77bf051', 'Mozilla/5.0 (Linux; Android 7.0; SLA-L22) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.83 Mobile Safari/537.36', 275),
(562, '2018-12-13 08:30:07', '2018-12-12 08:30:07', '212.51.207.170', '4196baf8-d22d-4163-ad14-f4e23832cf9d', 'Mozilla/5.0 (Linux; Android 7.0; SLA-L22) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.83 Mobile Safari/537.36', 137),
(563, '2018-12-13 10:03:27', '2018-12-12 10:03:27', '212.51.207.170', '6523e4a9-c65c-45d8-ba74-2878fde6d61c', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(564, '2018-12-13 10:09:14', '2018-12-12 10:09:14', '37.47.53.255', '3c870a66-0380-4e93-a010-d5c1565cefc8', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(566, '2018-12-13 10:11:34', '2018-12-12 10:11:34', '37.47.53.255', 'b3b0cba0-f516-4310-95a2-098b40d2abe2', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(567, '2018-12-13 10:17:30', '2018-12-12 10:17:30', '212.51.207.170', 'b97cda75-c0d6-45f8-a5ed-02a449421f27', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36', 137),
(568, '2018-12-13 10:17:47', '2018-12-12 10:17:47', '37.47.53.255', '95168422-7982-4b99-a4d0-a8e20d99a3d6', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 178),
(570, '2018-12-13 10:19:34', '2018-12-12 10:19:34', '212.51.207.170', '3f120d26-a2a0-4138-8a87-9e3df7bfcbcb', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36', 178),
(571, '2018-12-13 10:43:06', '2018-12-12 10:43:06', '37.47.53.255', '9a28f9ea-5baf-4973-8ce5-8c2b470bb777', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(572, '2018-12-13 10:43:27', '2018-12-12 10:43:27', '37.47.53.255', '24642ae6-f0f3-43cb-bfb9-6143945d5f74', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(573, '2018-12-13 12:16:34', '2018-12-12 12:16:34', '37.47.53.255', '7af69550-20f1-4112-ac8f-0bf85fa7f930', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(574, '2018-12-13 12:16:58', '2018-12-12 12:16:58', '37.47.53.255', 'c4f9317c-ce97-4680-a304-88c18bad11f4', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(575, '2018-12-13 15:45:38', '2018-12-12 15:45:38', '37.47.53.255', '0302bb34-74bb-497c-a8ab-c105989686ae', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(576, '2018-12-13 17:27:35', '2018-12-12 17:27:35', '37.47.53.255', 'dae5a946-0f31-4654-9d1a-ba784fb42de8', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(577, '2018-12-13 17:28:01', '2018-12-12 17:28:01', '37.47.53.255', 'c67a0fb2-ca1f-4636-b034-513d4b42d2b3', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 178),
(580, '2018-12-13 17:32:58', '2018-12-12 17:32:58', '212.51.207.170', 'effc7833-02cb-4f1c-914b-840ca775e17b', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36', 178),
(581, '2018-12-13 17:34:02', '2018-12-12 17:34:02', '37.47.53.255', 'f5cadb64-0c8a-4813-81a8-5a1d388432c9', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(583, '2018-12-13 17:34:58', '2018-12-12 17:34:58', '212.51.207.170', 'beaab55b-fba2-4884-9c89-4ec3b1fdc790', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36', 137),
(584, '2018-12-14 14:58:51', '2018-12-13 14:58:51', '37.47.49.124', 'b694bb6c-87df-423c-a91d-56668f1983df', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(585, '2018-12-18 10:03:03', '2018-12-17 10:03:03', '37.47.52.26', 'aa065266-f4d3-4402-89b4-4a6dbbe542d3', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(586, '2018-12-18 10:03:26', '2018-12-17 10:03:26', '37.47.52.26', 'a4b392aa-c5dd-4480-8d84-ccf60550f3e1', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(587, '2018-12-20 18:33:07', '2018-12-19 18:33:07', '93.105.205.206', 'b0513af0-5daf-4e72-9566-48efc3f8775b', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 275),
(588, '2018-12-20 18:33:07', '2018-12-19 18:33:07', '93.105.205.206', '2567da2c-beb5-48ad-b5c9-ab03ac7fdcd1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 275),
(589, '2018-12-20 18:33:07', '2018-12-19 18:33:07', '93.105.205.206', '8eb16266-0852-46e0-a2a8-89e05a08367e', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 275),
(590, '2018-12-20 18:36:09', '2018-12-19 18:36:09', '93.105.205.206', '431110e9-dda5-464e-a82f-31893998b335', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 275),
(591, '2018-12-21 10:17:47', '2018-12-20 10:17:47', '37.47.56.162', '19686fee-01b2-41d7-aed1-f8604826e23f', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(592, '2018-12-23 12:44:08', '2018-12-22 12:44:08', '93.105.205.206', '0b006b76-6838-4f36-acd8-8d06849543e8', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 275),
(593, '2018-12-23 12:44:08', '2018-12-22 12:44:08', '93.105.205.206', '325af42c-dfa5-464e-bb92-f30b0bf58e31', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 275),
(594, '2018-12-23 12:45:38', '2018-12-22 12:45:38', '93.105.205.206', 'deb19de9-7c30-4257-bcf0-9d9c2036f075', 'PostmanRuntime/7.4.0', 275),
(595, '2018-12-25 17:31:36', '2018-12-24 17:31:36', '37.47.40.126', '1c9f2117-e7ec-4465-9b08-a6cd3a1f6d2c', 'Mozilla/5.0 (Android 7.1.2; Mobile; rv:61.0) Gecko/61.0 Firefox/61.0', 137),
(596, '2018-12-29 00:14:02', '2018-12-28 00:14:02', '37.47.54.169', '69e0bc22-00a4-4870-8ce9-3a82cda79d83', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(598, '2018-12-29 17:17:03', '2018-12-28 17:17:03', '37.47.53.197', '322ebbf4-a960-4546-9766-a2219d93f758', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(599, '2018-12-29 17:17:03', '2018-12-28 17:17:03', '37.47.53.197', '84df5154-39b5-4ae6-9b88-e03f3ebecdaf', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(601, '2018-12-29 19:31:16', '2018-12-28 19:31:16', '37.47.53.197', 'cdb3d95c-f880-4901-9104-4956cf46f267', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(602, '2019-01-02 01:41:14', '2019-01-01 01:41:14', '37.47.59.150', 'ea3e6cdb-185a-4774-bd7e-8d3727aff773', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(603, '2019-01-02 01:41:14', '2019-01-01 01:41:14', '37.47.59.150', '5fbc4b7f-ede9-4e75-aa80-04ac0d6de943', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(604, '2019-01-02 01:41:14', '2019-01-01 01:41:14', '37.47.59.150', '9dc80d7d-f3fa-424a-9af7-18a772bba450', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(605, '2019-01-02 14:36:28', '2019-01-01 14:36:28', '93.105.205.206', '5d3917d5-49f2-4d0f-80c7-6662f0c8eb28', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 275),
(606, '2019-01-02 14:51:37', '2019-01-01 14:51:37', '93.105.205.206', 'c265f529-d252-4798-8e60-c5afa2848a5f', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 275),
(607, '2019-01-02 14:52:20', '2019-01-01 14:52:20', '93.105.205.206', 'ced78407-4ad4-4ac3-9e3f-4d36860c5337', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 275),
(608, '2019-01-09 18:40:55', '2019-01-08 18:40:55', '93.105.205.206', '82d66794-d429-4726-a406-708be33f1c8d', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 275),
(609, '2019-01-15 16:59:37', '2019-01-14 16:59:37', '37.47.60.239', '0b9fa615-cfb3-443a-ae25-31f726b6745e', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(610, '2019-01-15 16:59:40', '2019-01-14 16:59:40', '37.47.60.239', '77d0e591-d0b4-420b-b2be-c8b625cef802', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(612, '2019-01-15 23:29:50', '2019-01-14 23:29:50', '178.43.84.253', 'a77f0b91-fdae-460a-9d44-54aa0578a806', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(613, '2019-01-15 23:33:01', '2019-01-14 23:33:01', '178.43.84.253', 'f4e57826-dfe5-4a7e-8dca-e70712be94b7', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 137),
(614, '2019-01-15 23:39:58', '2019-01-14 23:39:58', '178.43.84.253', 'f8c908d8-de0e-4b41-8455-fa0d24c9e78e', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(615, '2019-01-15 23:46:50', '2019-01-14 23:46:50', '178.43.84.253', '23cd4554-121d-41cd-af81-0ca302036ad9', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(616, '2019-01-15 23:52:50', '2019-01-14 23:52:50', '178.43.84.253', '4b8cf2ab-c126-4489-86f3-d41238f63ed1', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(617, '2019-01-15 23:52:51', '2019-01-14 23:52:51', '178.43.84.253', '47e17c5c-c6bd-4c40-9708-a261ec4402cb', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(618, '2019-01-15 23:52:51', '2019-01-14 23:52:51', '178.43.84.253', '54ba38b7-5ce3-40a5-89c2-76a0f43cc473', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(619, '2019-01-15 23:52:51', '2019-01-14 23:52:51', '178.43.84.253', '5c82651f-af9d-405e-bbea-fefda1c4ed27', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(620, '2019-01-15 23:52:51', '2019-01-14 23:52:51', '178.43.84.253', '14888d86-cca8-4d6c-b43d-95212f65e452', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(621, '2019-01-15 23:52:51', '2019-01-14 23:52:51', '178.43.84.253', 'a44ea44b-e191-4ada-a26d-d35e8d86d016', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(622, '2019-01-15 23:52:51', '2019-01-14 23:52:51', '178.43.84.253', 'fbddf88a-f7c3-4070-a4d6-7d5315b6393b', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(623, '2019-01-15 23:52:51', '2019-01-14 23:52:51', '178.43.84.253', '519a7832-5027-4ead-a1f7-3ac645dca82e', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(624, '2019-01-15 23:54:55', '2019-01-14 23:54:55', '178.43.84.253', 'e2e6774c-1f5c-47d7-b184-7228a4402f2b', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(625, '2019-01-15 23:57:56', '2019-01-14 23:57:56', '178.43.84.253', '774e984b-36a1-4e69-9e17-2317fe94f384', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 137),
(626, '2019-01-16 15:15:22', '2019-01-15 15:15:22', '31.182.221.121', '31ee0d09-c072-4ae0-8ae6-09d57d08be93', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0', 137),
(627, '2019-01-16 15:15:46', '2019-01-15 15:15:46', '212.191.92.131', 'e4dfadfa-42bb-4c0b-a38b-16a1a7ede02d', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 137),
(628, '2019-01-16 16:35:33', '2019-01-15 16:35:33', '37.47.49.169', '19ccb3da-6f46-4b82-88f0-5a0848f68633', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(629, '2019-01-16 17:03:05', '2019-01-15 17:03:05', '37.47.49.169', '640cf2d8-bf36-4065-a1bf-8239913c0653', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(630, '2019-01-16 17:04:30', '2019-01-15 17:04:30', '37.47.49.169', '29a4247b-9c5b-4417-bf76-ac8c137ccd8f', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(631, '2019-01-16 17:06:46', '2019-01-15 17:06:46', '37.47.49.169', '313e563d-2563-4225-8800-d7099c229fd1', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(632, '2019-01-16 17:07:04', '2019-01-15 17:07:04', '37.47.49.169', 'd52f7034-717a-41f9-9410-0bb380eb7c62', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(633, '2019-01-16 17:07:27', '2019-01-15 17:07:27', '37.47.49.169', '2dd527d8-66cb-40b1-b938-b3093d1eefa1', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(634, '2019-01-16 19:52:02', '2019-01-15 19:52:02', '178.43.210.189', 'ee4a3663-1802-46ce-8bd5-ff2cd1008709', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 137),
(635, '2019-01-16 20:09:08', '2019-01-15 20:09:08', '178.43.210.189', 'dd5a6452-33e8-4cce-ae81-e7a401932714', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 178),
(636, '2019-01-16 20:12:40', '2019-01-15 20:12:40', '178.43.210.189', '13f13bfe-e68e-4749-9540-53d44b011c07', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 178),
(637, '1970-01-01 01:00:00', '2019-01-15 20:16:00', '178.43.210.189', '86419785-373a-445f-b3f8-051cfff4c2e3', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 178),
(638, '2019-01-16 20:39:06', '2019-01-15 20:39:06', '178.43.210.189', '6f5f9688-3d78-4287-b020-ddadbe2a82fc', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 137),
(639, '1970-01-01 01:00:00', '2019-01-15 20:39:13', '178.43.210.189', '619be1c1-8e6b-4446-b1ee-9147da52cc71', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 178),
(640, '2019-01-16 20:39:37', '2019-01-15 20:39:37', '178.43.210.189', 'f7549012-1969-4758-b6ab-435b1f61f26f', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 178),
(641, '2019-01-16 20:42:10', '2019-01-15 20:42:10', '178.43.210.189', '05387e6a-05b3-4fa1-b754-cb2d93305a75', 'Dalvik/2.1.0 (Linux; U; Android 9; Android SDK built for x86 Build/PSR1.180720.012)', 178),
(643, '2019-01-16 20:55:54', '2019-01-15 20:55:54', '37.47.49.169', 'f81848be-b757-477a-af0a-1c49f9dd9972', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(644, '2019-01-16 20:56:04', '2019-01-15 20:56:04', '37.47.49.169', '6a99b24a-ca0b-40b7-a55e-9c74037233d3', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(645, '2019-01-16 21:19:34', '2019-01-15 21:19:34', '37.47.49.169', 'c8f7fa75-4991-48ee-bea3-269b8a8f2fe6', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(647, '2019-01-16 22:35:49', '2019-01-15 22:35:49', '93.105.205.206', '2a0f7611-50bd-4189-84a1-eb77200608ac', 'Dalvik/2.1.0 (Linux; U; Android 7.0; SLA-L22 Build/HUAWEISLA-L22)', 137),
(649, '2019-01-16 22:36:19', '2019-01-15 22:36:19', '93.105.205.206', '26eb0f43-e4cb-4ccb-b79b-deb608c22658', 'Dalvik/2.1.0 (Linux; U; Android 7.0; SLA-L22 Build/HUAWEISLA-L22)', 137),
(650, '2019-01-16 22:36:25', '2019-01-15 22:36:25', '93.105.205.206', 'f04500ca-47c0-4bc8-9b05-8891e5a4be4b', 'Dalvik/2.1.0 (Linux; U; Android 7.0; SLA-L22 Build/HUAWEISLA-L22)', 137),
(651, '2019-01-16 22:36:32', '2019-01-15 22:36:32', '93.105.205.206', '7a5a3871-147f-427f-8d21-a54c79beb672', 'Dalvik/2.1.0 (Linux; U; Android 7.0; SLA-L22 Build/HUAWEISLA-L22)', 137),
(652, '2019-01-16 22:37:09', '2019-01-15 22:37:09', '37.47.49.169', '5618f622-fd9a-4d00-a1b6-04c9201bc6f6', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(653, '2019-01-16 22:46:42', '2019-01-15 22:46:42', '37.47.49.169', 'a45748eb-1e75-4525-b507-2e7daf23011c', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(654, '2019-01-17 06:27:29', '2019-01-16 06:27:29', '93.105.205.206', 'f839e878-1469-4bdd-b183-9dbe1660feec', 'Dalvik/2.1.0 (Linux; U; Android 7.0; SLA-L22 Build/HUAWEISLA-L22)', 137),
(655, '2019-01-17 06:27:29', '2019-01-16 06:27:29', '93.105.205.206', '8c79ac45-8401-4892-9cdb-0390c645bad1', 'Dalvik/2.1.0 (Linux; U; Android 7.0; SLA-L22 Build/HUAWEISLA-L22)', 137),
(656, '2019-01-17 07:24:55', '2019-01-16 07:24:55', '93.105.205.206', '3a982dfe-7d5c-420c-a7e8-d897bd7831ff', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 137),
(657, '2019-01-17 08:08:17', '2019-01-16 08:08:17', '37.47.38.112', '499026bf-a9e8-4045-a74c-f18e1b49e6c7', 'Mozilla/5.0 (X11; Linux x86_64; rv:66.0) Gecko/20100101 Firefox/66.0', 137),
(660, '2019-01-17 09:18:01', '2019-01-16 09:18:01', '5.173.192.175', 'b1291ef9-c879-40c6-b44c-f2f594335e24', 'Dalvik/2.1.0 (Linux; U; Android 7.0; SLA-L22 Build/HUAWEISLA-L22)', 137),
(661, '2019-01-17 09:18:02', '2019-01-16 09:18:02', '5.173.192.175', '2e1688c4-5678-4b6d-a92f-60842b33efcb', 'Dalvik/2.1.0 (Linux; U; Android 7.0; SLA-L22 Build/HUAWEISLA-L22)', 137),
(662, '2019-01-17 09:38:07', '2019-01-16 09:38:07', '212.51.207.170', '58b225b7-5cde-479f-81f6-74116b31ef7d', 'Dalvik/2.1.0 (Linux; U; Android 7.0; SLA-L22 Build/HUAWEISLA-L22)', 137),
(663, '2019-01-17 09:40:50', '2019-01-16 09:40:50', '212.51.207.170', 'ac1ac8da-3049-4955-b17e-a4bd2e3b8bd0', 'Mozilla/5.0 (X11; Linux x86_64; rv:66.0) Gecko/20100101 Firefox/66.0', 137),
(664, '2019-01-17 09:45:26', '2019-01-16 09:45:26', '212.51.207.170', '7a76ea36-2b66-4af9-8992-74327a7a6e5d', 'Dalvik/2.1.0 (Linux; U; Android 7.0; SLA-L22 Build/HUAWEISLA-L22)', 137),
(665, '2019-01-17 09:53:04', '2019-01-16 09:53:04', '212.51.207.170', '11503bf6-3c26-46c1-9faa-ee68d0879016', 'Mozilla/5.0 (Linux; Android 7.0; SLA-L22) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.99 Mobile Safari/537.36', 137),
(666, '2019-01-17 10:47:15', '2019-01-16 10:47:15', '37.47.58.49', 'f2a8f756-516e-459a-8a47-927226eff4c9', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(668, '2019-01-17 10:48:12', '2019-01-16 10:48:12', '37.47.58.49', 'd70bac30-e85f-4936-ac8b-ba9c4e8747c5', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(669, '2019-01-17 13:41:47', '2019-01-16 13:41:47', '37.47.58.49', 'b2315ca9-b139-4d67-ad7d-dcb6c314a7b8', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(670, '2019-01-17 16:44:43', '2019-01-16 16:44:43', '37.47.58.49', '7070a2d9-3d47-4906-8be3-23ec00661e64', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(680, '2019-01-18 13:11:44', '2019-01-17 13:11:44', '37.47.59.235', 'dd92531a-b87d-43e1-b62a-8c54a750e925', 'Dalvik/2.1.0 (Linux; U; Android 8.0.0; SM-G950F Build/R16NW)', 137),
(681, '1970-01-01 01:00:00', '2019-01-19 19:21:12', '93.105.205.206', '5e5b8e10-62f6-44b2-b9be-91d44f034257', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0', 275);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pass` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `active` tinyint(1) NOT NULL DEFAULT 0,
  `actcode` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `pass`, `created_at`, `active`, `actcode`) VALUES
(137, 'test@test.com', 'Krzysztof', 'Dymkowski', '$2a$10$fBgChcCd1py1PZA5dEBnhu38RKks5rcPP5ueqGduFj6qePKryoNAi', '2018-11-02 14:09:24', 1, ''),
(178, 'mradamskii@gmail.com', 'Mr', 'Adamskii', '$2a$10$Rh1b/2o7.qeidzECgJT6.eJV0a8Ofp47cizTP751mzQV5ssTuZHrq', '2018-11-02 14:09:24', 1, ''),
(218, 'test@tes12312t.com', 'First name', 'Last Name', '$2a$10$Nk.kY5O.dV6a0UxYS.Tdj.CPQZemIG.PF1xDrjosebmGGqDiXNZEC', '2018-11-02 14:09:24', 0, ''),
(222, 'test@tytrtyrest.com', 'First name', 'Last Name', '$2a$10$vqE522B5v8xAVKLT8l0sguBGFJYdFeYQ7hToTaqf9V61mgRPvzDoy', '2018-11-02 14:09:24', 0, ''),
(228, 'test@test23423.com', 'First name', 'Last Name', '$2a$10$7YSAmDZWisvNV919./Qb0uXkdqspSCE5fyaojWJkvIDftMaWViAsS', '2018-11-02 14:09:24', 0, ''),
(236, '768903396526481@facebook.com', 'ab', 'cd', '$2a$10$uk.UEyH2n3lKUb7x/xxFnuAK3evozyYVYF8z./I/aHLCgHATD33y6', '2018-11-02 14:09:24', 0, ''),
(267, 'test@te123123st.com', 'First name', 'Last Name', '$2a$10$5gaDEubBq/HU8u6nxwdHMexRX9uvsBe3FEYXKQZfIYUPrKp8CwvjK', '2018-11-02 14:09:24', 0, ''),
(275, 'kontakt@e-otc.pl', 'Sebastian', 'Madejski', '$2a$10$vyRr0k3nNXHstt3vcN4V1e4APfZyi5gdFBDaMCyjeV3D0sbml3z9K', '2018-11-02 14:09:24', 1, ''),
(285, 'First name', 'test@tesasdadt.com', 'password', '$2a$10$Ukx61pTzd/qwcdA.sVEVjeUkP.vnUpUpWtrH/rpHniU3puP.Br2c2', '2018-11-02 20:56:45', 0, 'ddd36fc3-1405-4b39-a9bd-e0fe0ea472dc'),
(297, 'test12345@test123147453465078345976.xyzxd', 'Elo', 'Mordo', '$2a$10$ccelYrh0Uwjx06GkaxaLoO1NRMVYboowo/JkbPoKXv2pfwYdNQ4u.', '2018-11-03 11:19:17', 0, '9c0d7d73-0d86-4af7-a246-0b2c3d35e655'),
(318, 'test@teasdfasdfst.com', 'First name', 'Last Name', '$2a$10$/P/yQTG6OQscbogLZInNOegWK4eIr84HttX4F7TUg1PKNsnkFOMPG', '2018-11-09 19:46:00', 0, 'c3060874-3993-4d29-8d43-f0463235e075'),
(672, 'testhuehue123', 'Magda', 'huehuehue', '$2a$10$/xh2W46AqhttkwfnwwgtJOvtFxSSpj9ks2yG5/9hnW.EbEIH6D5.6', '2019-01-17 13:11:23', 0, '9fe4d396-6700-4e08-a6d6-d3ff9be262fd'),
(673, 'testhuehue123', 'Magda', 'huehuehue', '$2a$10$SPsrZDWlGpvV0HAesDlaY.QrpWSdoM3ach8GV2kWf3yD8g.2/Mmd.', '2019-01-17 13:11:23', 0, 'ce911b27-c6a4-49fc-8a84-8c573c02c41c'),
(674, 'testhuehue123', 'Magda', 'huehuehue', '$2a$10$htVeOm2lk6jR96Uo9bCIGe/uFatrO9PJ/Fd7dBFQuvAHHnu1r.kOa', '2019-01-17 13:11:23', 0, '4e2cbc21-34f5-4ad9-a8bb-d6eff98ab77c'),
(675, 'testhuehue123', 'Magda', 'huehuehue', '$2a$10$PRma.hqUG5e5K4/BULn9/eYBofBT9M1HJZ7HulIooEeAvBHFWVaIy', '2019-01-17 13:11:23', 0, 'de8a0448-402a-4f1f-b5c4-db9fc301af14'),
(676, 'testhuehue123', 'Magda', 'huehuehue', '$2a$10$syJKI.C4u8NOoJb9Rxg69uUWzeU/kYyQ.vKVlOLObplCWIOsqPYRm', '2019-01-17 13:11:23', 0, 'f438584c-6532-4325-b52d-5d5ca0ea3b52'),
(677, 'testhuehue123', 'Magda', 'huehuehue', '$2a$10$CLbgs2Qz.E88IHBDEYBK5ONl3VWPfsZ79wKq6aXZ56pn0wOumQA0e', '2019-01-17 13:11:23', 0, '847129a0-5bab-4f6d-86a8-235effcc69da'),
(678, 'testhuehue123', 'Magda', 'huehuehue', '$2a$10$8txDWN4ePfDnzGi08gZTReaQEufc2gNWaBleI2PrezeNu.fMpVoGu', '2019-01-17 13:11:23', 0, '712c0704-438d-420c-86fe-50b3105cc58d'),
(679, 'testhuehue123', 'Magda', 'huehuehue', '$2a$10$R1uVAByjSpS4bE7Haj9GGuXq5f3QL3VeB8Y1fmChxuqF3rDfQ91Fa', '2019-01-17 13:11:23', 0, 'd2b2b835-24ff-438c-8121-0edafb3fbe94');

-- --------------------------------------------------------

--
-- Table structure for table `youtube_access_token`
--

CREATE TABLE `youtube_access_token` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `access_token` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `expiry_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contest`
--
ALTER TABLE `contest`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `platform_id` (`platform_id`);

--
-- Indexes for table `facebook_access_token`
--
ALTER TABLE `facebook_access_token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `facebook_post_log`
--
ALTER TABLE `facebook_post_log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `session_id` (`session_id`);

--
-- Indexes for table `platform`
--
ALTER TABLE `platform`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `canonical_name` (`canonical_name`);

--
-- Indexes for table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tracking_id` (`tracking_id`(40)),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `youtube_access_token`
--
ALTER TABLE `youtube_access_token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_user_id_user` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `facebook_access_token`
--
ALTER TABLE `facebook_access_token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=660;

--
-- AUTO_INCREMENT for table `platform`
--
ALTER TABLE `platform`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `youtube_access_token`
--
ALTER TABLE `youtube_access_token`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contest`
--
ALTER TABLE `contest`
  ADD CONSTRAINT `contest_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `contest_ibfk_2` FOREIGN KEY (`platform_id`) REFERENCES `platform` (`id`);

--
-- Constraints for table `facebook_access_token`
--
ALTER TABLE `facebook_access_token`
  ADD CONSTRAINT `facebook_access_token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `facebook_post_log`
--
ALTER TABLE `facebook_post_log`
  ADD CONSTRAINT `facebook_post_log_ibfk_1` FOREIGN KEY (`session_id`) REFERENCES `session` (`id`);

--
-- Constraints for table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `session_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `youtube_access_token`
--
ALTER TABLE `youtube_access_token`
  ADD CONSTRAINT `FK_user_id_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
