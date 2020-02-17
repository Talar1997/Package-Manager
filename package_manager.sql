-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 09 Lut 2020, 17:10
-- Wersja serwera: 10.1.26-MariaDB
-- Wersja PHP: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `package_manager`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `download_list`
--

CREATE TABLE `download_list` (
  `id_download` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `file`
--

CREATE TABLE `file` (
  `id_file` int(11) NOT NULL,
  `filename` varchar(256) COLLATE utf8mb4_polish_ci NOT NULL,
  `file_binary` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `file_list`
--

CREATE TABLE `file_list` (
  `id_list_file` int(11) NOT NULL,
  `id_file` int(11) NOT NULL,
  `id_licence` int(11) DEFAULT NULL,
  `name` varchar(128) COLLATE utf8mb4_polish_ci NOT NULL,
  `description` text COLLATE utf8mb4_polish_ci,
  `version` varchar(64) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `download_counter` int(11) DEFAULT '0',
  `added_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `id_uploader` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `licence`
--

CREATE TABLE `licence` (
  `id_licence` int(11) NOT NULL,
  `licence_key` varchar(1024) COLLATE utf8_polish_ci NOT NULL,
  `id_file_list` int(11) NOT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `id_added_by` int(11) NOT NULL,
  `added_date` datetime NOT NULL,
  `in_use` tinyint(1) NOT NULL,
  `description` text COLLATE utf8_polish_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `log`
--

CREATE TABLE `log` (
  `id_log` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type` varchar(64) COLLATE utf8mb4_polish_ci NOT NULL,
  `value` varchar(2048) COLLATE utf8mb4_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

--
-- Zrzut danych tabeli `log`
--

INSERT INTO `log` (`id_log`, `timestamp`, `type`, `value`) VALUES
(1, '2020-01-06 14:50:09', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(2, '2020-01-06 14:50:37', 'Login error', 'Nieudana próba logowania do systemu'),
(3, '2020-01-06 14:51:08', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(4, '2020-01-06 14:52:59', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(5, '2020-01-06 14:53:37', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(6, '2020-01-06 16:48:29', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(7, '2020-01-06 16:50:52', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(8, '2020-01-06 16:52:46', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(9, '2020-01-06 17:24:30', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(10, '2020-01-06 17:50:07', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(11, '2020-01-06 17:52:43', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(12, '2020-01-06 17:58:45', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(13, '2020-01-06 18:00:17', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(14, '2020-01-06 18:02:00', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(15, '2020-01-06 18:02:50', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(16, '2020-01-06 18:03:55', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(17, '2020-01-06 18:05:26', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(18, '2020-01-06 18:07:46', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(19, '2020-01-06 18:08:35', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(20, '2020-01-06 18:10:08', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(21, '2020-01-06 18:10:41', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(22, '2020-01-06 19:50:28', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(23, '2020-01-06 20:55:45', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(24, '2020-01-06 20:55:57', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(25, '2020-01-06 20:56:22', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(26, '2020-01-06 22:08:47', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(27, '2020-01-06 22:10:19', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(28, '2020-01-07 12:50:54', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(29, '2020-01-07 17:14:08', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(30, '2020-01-07 17:17:00', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(31, '2020-01-07 18:52:14', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(32, '2020-01-07 18:52:33', 'User created', 'Utworzono nowego uzytkownika: test'),
(33, '2020-01-07 18:54:06', 'User created', 'Utworzono nowego uzytkownika: test2'),
(34, '2020-01-07 18:55:31', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(35, '2020-01-07 18:55:52', 'User created', 'Utworzono nowego uzytkownika: test12'),
(36, '2020-01-07 18:59:05', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(37, '2020-01-07 18:59:21', 'User created', 'Utworzono nowego uzytkownika: bee'),
(38, '2020-01-07 19:01:33', 'User created', 'Utworzono nowego uzytkownika: guwnol'),
(39, '2020-01-11 17:39:37', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(40, '2020-01-12 15:03:58', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(41, '2020-01-12 21:15:19', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(42, '2020-01-13 17:48:43', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(43, '2020-01-13 19:37:50', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(44, '2020-01-13 19:41:47', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(45, '2020-01-13 19:48:05', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(46, '2020-01-13 19:50:26', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(47, '2020-01-13 20:54:39', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(48, '2020-01-13 21:01:41', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(49, '2020-01-13 21:08:34', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(50, '2020-01-13 21:11:52', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(51, '2020-01-14 21:55:58', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(52, '2020-01-14 22:17:28', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(53, '2020-01-14 22:21:35', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(54, '2020-01-14 22:22:46', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(55, '2020-01-14 22:24:30', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(56, '2020-01-14 22:30:10', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(57, '2020-01-14 22:35:03', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(58, '2020-01-14 22:36:40', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(59, '2020-01-14 22:40:16', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(60, '2020-01-14 22:41:04', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(61, '2020-01-14 22:42:07', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(62, '2020-01-14 22:43:12', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(63, '2020-01-14 22:46:38', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(64, '2020-01-14 22:48:25', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(65, '2020-01-14 22:55:31', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(66, '2020-01-15 16:38:38', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(67, '2020-01-15 17:40:24', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(68, '2020-01-15 18:08:43', 'User created', 'Utworzono nowego uzytkownika: TestowyUser'),
(69, '2020-01-15 20:42:09', 'Login error', 'Nieudana próba logowania do systemu'),
(70, '2020-01-15 20:42:11', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(71, '2020-01-23 18:23:18', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(72, '2020-01-23 19:17:44', 'Login error', 'Nieudana próba logowania do systemu'),
(73, '2020-01-23 19:17:47', 'Login successfull', 'Logowanie do systemu: admin id: 1'),
(74, '2020-01-23 19:38:51', 'Login error', 'Nieudana próba logowania do systemu: admin'),
(75, '2020-01-23 19:38:54', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(76, '2020-01-23 19:42:57', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(77, '2020-01-23 20:15:58', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(78, '2020-01-23 20:27:41', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(79, '2020-01-24 20:56:30', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(80, '2020-01-24 22:42:40', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(81, '2020-01-24 22:44:34', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(82, '2020-01-24 22:47:18', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(83, '2020-01-24 22:49:34', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(84, '2020-01-26 20:33:01', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(85, '2020-01-26 23:05:14', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(86, '2020-01-26 23:44:57', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(87, '2020-01-28 15:07:29', 'Login error', 'Nieudana próba logowania do systemu: aaa'),
(88, '2020-01-28 15:07:33', 'Login error', 'Nieudana próba logowania do systemu: aaa'),
(89, '2020-01-28 15:07:37', 'Login error', 'Nieudana próba logowania do systemu: aaa'),
(90, '2020-01-28 15:07:40', 'Login error', 'Nieudana próba logowania do systemu: aaa'),
(91, '2020-01-28 15:10:55', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(92, '2020-01-28 15:11:17', 'Login error', 'Nieudana próba logowania do systemu: admin'),
(93, '2020-01-28 15:11:20', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(94, '2020-01-28 15:13:53', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(95, '2020-01-28 15:14:13', 'User created', 'Utworzono nowego uzytkownika: Admion'),
(96, '2020-01-28 15:18:15', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(97, '2020-01-28 15:18:29', 'User created', 'Utworzono nowego uzytkownika: admion'),
(98, '2020-01-28 15:18:46', 'Login successfull', 'Logowanie do systemu: admion (id: 21)'),
(99, '2020-01-28 15:18:58', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(100, '2020-01-28 16:03:48', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(101, '2020-01-28 16:05:44', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(102, '2020-01-28 16:57:58', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(103, '2020-01-28 16:58:06', 'User deleted', 'Usuni?to uzytkownika: admion przez: [tu nazwa usuwajacego]'),
(104, '2020-01-28 16:58:13', 'User deleted', 'Usuni?to uzytkownika: TestowyUser przez: [tu nazwa usuwajacego]'),
(105, '2020-01-28 16:59:09', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(106, '2020-01-28 16:59:14', 'User deleted', 'Usuni?to uzytkownika: guwnol przez: [tu nazwa usuwajacego]'),
(107, '2020-01-28 17:08:29', 'User deleted', 'Usuni?to uzytkownika: priv_user4 przez: [tu nazwa usuwajacego]'),
(108, '2020-01-28 17:08:55', 'User created', 'Utworzono nowego uzytkownika: Cwel'),
(109, '2020-01-28 17:09:04', 'User deleted', 'Usuni?to uzytkownika: Cwel przez: [tu nazwa usuwajacego]'),
(110, '2020-01-28 17:27:12', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(111, '2020-01-28 17:28:05', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(112, '2020-01-28 17:28:44', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(113, '2020-01-28 18:27:37', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(114, '2020-01-28 18:41:01', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(115, '2020-01-28 18:42:22', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(116, '2020-01-28 18:43:39', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(117, '2020-01-30 20:19:35', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(118, '2020-01-30 20:29:51', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(119, '2020-01-30 21:01:23', 'User deleted', 'Usuni?to uzytkownika: priv_user3 przez: [tu nazwa usuwajacego]'),
(120, '2020-02-01 18:02:55', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(121, '2020-02-01 18:12:29', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(122, '2020-02-01 18:22:37', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(123, '2020-02-01 18:23:36', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(124, '2020-02-01 18:32:57', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(125, '2020-02-01 18:36:32', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(126, '2020-02-01 18:37:27', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(127, '2020-02-01 18:38:54', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(128, '2020-02-05 16:28:05', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(129, '2020-02-05 17:34:13', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(130, '2020-02-05 17:35:50', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(131, '2020-02-05 17:36:39', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(132, '2020-02-05 17:44:54', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(133, '2020-02-05 17:52:39', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(134, '2020-02-05 17:54:24', 'Login error', 'Nieudana próba logowania do systemu: admin'),
(135, '2020-02-05 17:54:27', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(136, '2020-02-05 18:00:06', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(137, '2020-02-05 18:05:21', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(138, '2020-02-05 18:06:39', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(139, '2020-02-06 17:05:08', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(140, '2020-02-06 17:09:20', 'Login error', 'Nieudana próba logowania do systemu: '),
(141, '2020-02-06 17:11:07', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(142, '2020-02-06 17:25:13', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(143, '2020-02-06 17:36:24', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(144, '2020-02-06 17:40:10', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(145, '2020-02-06 17:40:53', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(146, '2020-02-06 17:41:52', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(147, '2020-02-06 17:43:18', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(148, '2020-02-06 17:46:28', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(149, '2020-02-06 17:47:06', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(150, '2020-02-06 17:49:03', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(151, '2020-02-06 17:56:41', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(152, '2020-02-06 17:58:22', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(153, '2020-02-06 18:09:55', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(154, '2020-02-06 18:44:12', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(155, '2020-02-06 18:51:50', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(156, '2020-02-06 19:30:16', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(157, '2020-02-06 19:38:35', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(158, '2020-02-06 19:41:10', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(159, '2020-02-06 19:41:48', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(160, '2020-02-06 19:45:43', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(161, '2020-02-06 19:46:57', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(162, '2020-02-06 19:50:23', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(163, '2020-02-06 19:57:53', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(164, '2020-02-06 19:59:59', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(165, '2020-02-06 20:11:45', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(166, '2020-02-06 20:12:23', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(167, '2020-02-08 13:25:33', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(168, '2020-02-08 14:31:06', 'User created', 'Utworzono nowego uzytkownika: kmielczarek'),
(169, '2020-02-08 15:08:27', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(170, '2020-02-08 15:40:37', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(171, '2020-02-08 15:41:07', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(172, '2020-02-08 15:41:12', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(173, '2020-02-08 16:07:12', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(174, '2020-02-09 12:42:48', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(175, '2020-02-09 16:00:58', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(176, '2020-02-09 16:04:01', 'User created', 'Utworzono nowego uzytkownika: test');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `permission`
--

CREATE TABLE `permission` (
  `id_permission` int(11) NOT NULL,
  `upload_file` tinyint(1) NOT NULL,
  `download_file` tinyint(1) NOT NULL,
  `delete_file` tinyint(1) NOT NULL,
  `create_package` tinyint(1) NOT NULL,
  `delete_package` tinyint(1) NOT NULL,
  `set_permission` tinyint(1) NOT NULL,
  `create_user` tinyint(1) NOT NULL,
  `view_logs` tinyint(1) NOT NULL,
  `get_licence` tinyint(1) NOT NULL DEFAULT '0',
  `add_licence` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

--
-- Zrzut danych tabeli `permission`
--

INSERT INTO `permission` (`id_permission`, `upload_file`, `download_file`, `delete_file`, `create_package`, `delete_package`, `set_permission`, `create_user`, `view_logs`, `get_licence`, `add_licence`) VALUES
(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0),
(3, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0),
(4, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_polish_ci NOT NULL,
  `description` varchar(1024) COLLATE utf8mb4_polish_ci NOT NULL,
  `id_permission` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

--
-- Zrzut danych tabeli `role`
--

INSERT INTO `role` (`id_role`, `name`, `description`, `id_permission`) VALUES
(1, 'sysadmin', 'Administrator systemu', 1),
(2, 'user', 'Użytkownik systemu, podstawowe uprawnienia', 2),
(3, 'moderator', 'Moderator, posiada uprawnienia do moderowania paczkami, nie posiada uprawnień do zarządzania użytkownikami', 3),
(4, 'privileged_user', 'Funkcje użytkownika + może wyświetlać dostępne licencje', 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `software_package`
--

CREATE TABLE `software_package` (
  `id_package` int(11) NOT NULL,
  `name` varchar(256) COLLATE utf8mb4_polish_ci NOT NULL,
  `description` varchar(2048) COLLATE utf8mb4_polish_ci NOT NULL,
  `cretion_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_user` int(11) NOT NULL,
  `id_file_list` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(64) COLLATE utf8mb4_polish_ci NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `surname` varchar(256) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `email` varchar(1024) COLLATE utf8mb4_polish_ci NOT NULL,
  `password` varchar(2048) COLLATE utf8mb4_polish_ci NOT NULL,
  `id_permission` int(11) NOT NULL DEFAULT '2',
  `timestamp_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`id_user`, `username`, `name`, `surname`, `email`, `password`, `id_permission`, `timestamp_created`) VALUES
(1, 'admin', 'Adam', 'Talarczyk', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 1, '2020-01-06 14:27:50'),
(2, 'user', 'Karol', 'Wojtyła', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 2, '2020-01-06 14:27:55'),
(3, 'moderator', 'Donald', 'Trump', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 3, '2020-01-06 14:27:56'),
(4, 'priv_user', 'Martyna', 'Buc', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 4, '2020-01-06 14:28:53'),
(5, 'user1', 'Adrian', 'Malina', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 2, '2020-01-06 14:27:59'),
(6, 'moderator1', 'Dariusz', 'Kolos', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 3, '2020-01-06 14:29:53'),
(7, 'priv_user1', 'Mariusz', 'Pudzianowski', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 4, '2020-01-06 14:28:53'),
(8, 'user2', 'Adam', 'Małysz', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 2, '2020-01-06 14:28:14'),
(9, 'moderator2', 'Norbert', 'Surowiec', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 3, '2020-01-06 14:28:12'),
(10, 'priv_user3', 'Beata', 'Malina', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 4, '2020-01-06 14:28:05'),
(11, 'user4', 'John', 'Paul', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 2, '2020-01-06 14:27:53'),
(12, 'moderator4', 'Jonasz', 'Koran-Mekka', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 3, '2020-01-06 14:27:54'),
(23, 'moderator4', 'Jonasz', 'Koran-Mekka', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 3, '2020-01-06 14:27:54'),
(24, 'user4', 'John', 'Paul', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 2, '2020-01-06 14:27:53'),
(25, 'kmielczarek', 'Konstancja', 'Mielczarek', 'kmielczi@hwdp.pl', 'eb65eb39cde1c19e0594f2ee51f5a6b1', 2, '2020-02-08 14:31:06'),
(26, 'test', 'rasda', 'agadg', 'asdas@asd1q2.pl', 'a1e03cf022862126dabb2b06e3223521', 4, '2020-02-09 16:04:01');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `download_list`
--
ALTER TABLE `download_list`
  ADD PRIMARY KEY (`id_download`);

--
-- Indexes for table `file`
--
ALTER TABLE `file`
  ADD PRIMARY KEY (`id_file`);

--
-- Indexes for table `file_list`
--
ALTER TABLE `file_list`
  ADD PRIMARY KEY (`id_list_file`),
  ADD KEY `id_file` (`id_file`,`id_licence`),
  ADD KEY `id_licence` (`id_licence`);

--
-- Indexes for table `licence`
--
ALTER TABLE `licence`
  ADD PRIMARY KEY (`id_licence`),
  ADD KEY `id_file_list` (`id_file_list`,`id_added_by`),
  ADD KEY `id_added_by` (`id_added_by`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id_log`);

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id_permission`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`),
  ADD KEY `id_permission` (`id_permission`);

--
-- Indexes for table `software_package`
--
ALTER TABLE `software_package`
  ADD PRIMARY KEY (`id_package`),
  ADD KEY `id_user` (`id_user`,`id_file_list`),
  ADD KEY `id_file_list` (`id_file_list`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_permission` (`id_permission`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `download_list`
--
ALTER TABLE `download_list`
  MODIFY `id_download` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `file_list`
--
ALTER TABLE `file_list`
  MODIFY `id_list_file` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `licence`
--
ALTER TABLE `licence`
  MODIFY `id_licence` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `log`
--
ALTER TABLE `log`
  MODIFY `id_log` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=177;
--
-- AUTO_INCREMENT dla tabeli `permission`
--
ALTER TABLE `permission`
  MODIFY `id_permission` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT dla tabeli `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT dla tabeli `software_package`
--
ALTER TABLE `software_package`
  MODIFY `id_package` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `file_list`
--
ALTER TABLE `file_list`
  ADD CONSTRAINT `file_list_ibfk_1` FOREIGN KEY (`id_file`) REFERENCES `file` (`id_file`),
  ADD CONSTRAINT `file_list_ibfk_3` FOREIGN KEY (`id_licence`) REFERENCES `licence` (`id_licence`);

--
-- Ograniczenia dla tabeli `licence`
--
ALTER TABLE `licence`
  ADD CONSTRAINT `licence_ibfk_1` FOREIGN KEY (`id_added_by`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `licence_ibfk_2` FOREIGN KEY (`id_file_list`) REFERENCES `file_list` (`id_list_file`);

--
-- Ograniczenia dla tabeli `role`
--
ALTER TABLE `role`
  ADD CONSTRAINT `role_ibfk_1` FOREIGN KEY (`id_permission`) REFERENCES `permission` (`id_permission`);

--
-- Ograniczenia dla tabeli `software_package`
--
ALTER TABLE `software_package`
  ADD CONSTRAINT `software_package_ibfk_1` FOREIGN KEY (`id_file_list`) REFERENCES `file_list` (`id_list_file`),
  ADD CONSTRAINT `software_package_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Ograniczenia dla tabeli `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_permission`) REFERENCES `role` (`id_role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
