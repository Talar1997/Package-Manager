-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 11 Lut 2020, 01:53
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
  `timestamp` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `download_list`
--

INSERT INTO `download_list` (`id_download`, `timestamp`) VALUES
(1, '2020-02-10'),
(2, '2020-02-10'),
(3, '2020-02-10'),
(4, '2020-02-10'),
(5, '2020-02-10'),
(6, '2020-02-10'),
(7, '2020-02-10'),
(8, '2020-02-10'),
(9, '2020-02-10'),
(10, '2020-02-10'),
(11, '2020-02-10'),
(12, '2020-02-10'),
(13, '2020-02-10'),
(14, '2020-02-10'),
(15, '2020-02-10'),
(16, '2020-02-10'),
(17, '2020-02-10'),
(18, '2020-02-10'),
(19, '2020-02-10'),
(20, '2020-02-10'),
(21, '2020-02-10'),
(22, '2020-02-09'),
(23, '2020-02-09'),
(24, '2020-02-09'),
(25, '2020-02-09'),
(26, '2020-02-09'),
(27, '2020-02-09'),
(28, '2020-02-09'),
(29, '2020-01-29'),
(30, '2020-01-29'),
(31, '2020-01-30'),
(32, '2020-01-30'),
(33, '2020-01-30'),
(34, '2020-01-30'),
(35, '2020-01-30'),
(36, '2020-01-30'),
(37, '2020-01-30'),
(38, '2020-01-30'),
(39, '2020-01-30'),
(40, '2020-01-30'),
(41, '2020-01-30'),
(42, '2020-01-30'),
(43, '2019-12-30'),
(44, '2019-12-30'),
(45, '2019-12-30'),
(46, '2020-01-30'),
(47, '2019-12-30'),
(48, '2019-12-30'),
(49, '2019-12-30'),
(50, '2020-01-30'),
(51, '2019-12-30'),
(52, '2019-12-30'),
(53, '2019-12-30'),
(54, '2020-01-30'),
(55, '2019-12-30'),
(56, '2019-12-30'),
(57, '2019-12-30'),
(58, '2020-01-30'),
(59, '2019-12-30'),
(60, '2019-12-30'),
(61, '2019-12-30'),
(62, '2020-02-11'),
(63, '2020-02-11'),
(64, '2020-02-11'),
(65, '2020-02-11'),
(66, '2020-02-11');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `fav_package`
--

CREATE TABLE `fav_package` (
  `id_fav` int(11) NOT NULL,
  `id_package` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
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
  `name` varchar(128) COLLATE utf8mb4_polish_ci NOT NULL,
  `description` text COLLATE utf8mb4_polish_ci,
  `version` varchar(64) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `download_counter` int(11) DEFAULT '0',
  `added_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `id_uploader` int(11) DEFAULT NULL,
  `id_licence` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;

--
-- Zrzut danych tabeli `file_list`
--


-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `licence`
--

CREATE TABLE `licence` (
  `id_licence` int(11) NOT NULL,
  `licence_key` varchar(1024) COLLATE utf8_polish_ci NOT NULL,
  `id_file_list` int(11) DEFAULT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `id_added_by` int(11) DEFAULT NULL,
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
(176, '2020-02-09 16:04:01', 'User created', 'Utworzono nowego uzytkownika: test'),
(177, '2020-02-09 16:39:32', 'User deleted', 'Usuni?to uzytkownika: test przez: [tu nazwa usuwajacego]'),
(178, '2020-02-09 17:35:13', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(179, '2020-02-09 17:36:27', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(180, '2020-02-09 17:38:34', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(181, '2020-02-09 17:45:04', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(182, '2020-02-09 17:53:36', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(183, '2020-02-09 17:55:20', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(184, '2020-02-09 18:02:30', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(185, '2020-02-09 18:33:49', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(186, '2020-02-09 18:35:13', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(187, '2020-02-09 18:36:54', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(188, '2020-02-09 18:38:40', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(189, '2020-02-09 18:44:15', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(190, '2020-02-09 20:27:17', 'Login error', 'Nieudana próba logowania do systemu: admin'),
(191, '2020-02-09 20:27:21', 'Login error', 'Nieudana próba logowania do systemu: admin'),
(192, '2020-02-09 20:27:45', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(193, '2020-02-09 20:27:51', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(194, '2020-02-09 20:28:07', 'User edited', 'Edytowano uzytkownika id: 1 przez: admin (1)'),
(195, '2020-02-09 20:28:24', 'User edited', 'Edytowano uzytkownika id: 1 przez: admin (1)'),
(196, '2020-02-09 20:31:08', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(197, '2020-02-09 20:31:23', 'User edited', 'Edytowano uzytkownika id: 2 przez: admin (1)'),
(198, '2020-02-09 20:31:38', 'User edited', 'Edytowano uzytkownika id: 2 przez: admin (1)'),
(199, '2020-02-09 20:31:53', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(200, '2020-02-09 20:33:07', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(201, '2020-02-09 20:38:29', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(202, '2020-02-09 21:05:35', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(203, '2020-02-09 21:07:19', 'User edited', 'Edytowano uzytkownika id: 1 przez: admin (1)'),
(204, '2020-02-09 21:07:26', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(205, '2020-02-09 21:08:52', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(206, '2020-02-09 21:11:49', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(207, '2020-02-09 21:14:02', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(208, '2020-02-09 21:17:08', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(209, '2020-02-09 21:19:28', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(210, '2020-02-09 21:21:37', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(211, '2020-02-09 21:22:20', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(212, '2020-02-09 21:24:59', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(213, '2020-02-09 21:38:20', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(214, '2020-02-09 21:38:26', 'Role created', 'Utworzono now? rol?: test'),
(215, '2020-02-09 21:41:45', 'Role created', 'Utworzono now? rol?: Uprawnienia admina'),
(216, '2020-02-09 21:43:03', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(217, '2020-02-09 21:43:45', 'User edited', 'Edytowano uzytkownika id: 10 przez: admin (1)'),
(218, '2020-02-09 21:45:02', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(219, '2020-02-09 21:47:45', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(220, '2020-02-09 21:49:49', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(221, '2020-02-09 21:50:15', 'User edited', 'Edytowano uzytkownika id: 10 przez: admin (1)'),
(222, '2020-02-09 21:51:43', 'Role created', 'Utworzono now? rol?: licence_manager'),
(223, '2020-02-09 21:53:27', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(224, '2020-02-09 22:06:59', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(225, '2020-02-09 22:07:09', 'Role created', 'Utworzono now? rol?: uó?aa???'),
(226, '2020-02-09 22:10:05', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(227, '2020-02-09 22:10:23', 'Role created', 'Utworzono nową rolę: cółąę'),
(228, '2020-02-09 23:35:04', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(229, '2020-02-09 23:37:27', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(230, '2020-02-09 23:38:39', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(231, '2020-02-09 23:39:40', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(232, '2020-02-09 23:46:57', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(233, '2020-02-09 23:48:03', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(234, '2020-02-09 23:52:55', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(235, '2020-02-10 00:12:34', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(236, '2020-02-10 00:16:10', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(237, '2020-02-10 00:17:08', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(238, '2020-02-10 00:19:00', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(239, '2020-02-10 00:20:35', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(240, '2020-02-10 00:20:44', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(241, '2020-02-10 12:39:57', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(242, '2020-02-10 13:14:33', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(243, '2020-02-10 13:14:51', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(244, '2020-02-10 13:15:03', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(245, '2020-02-10 13:15:18', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(246, '2020-02-10 13:15:25', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(247, '2020-02-10 13:15:33', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(248, '2020-02-10 13:16:01', 'Role created', 'Utworzono nową rolę: Test'),
(249, '2020-02-10 13:16:05', 'Role edited', 'Edytowano role id: 5 przez: admin (1)'),
(250, '2020-02-10 13:16:10', 'Role edited', 'Edytowano role id: 5 przez: admin (1)'),
(251, '2020-02-10 13:16:33', 'User edited', 'Edytowano uzytkownika id: 9 przez: admin (1)'),
(252, '2020-02-10 13:16:42', 'User edited', 'Edytowano uzytkownika id: 9 przez: admin (1)'),
(253, '2020-02-10 13:22:52', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(254, '2020-02-10 17:21:28', 'Login error', 'Nieudana próba logowania do systemu: admi'),
(255, '2020-02-10 17:21:31', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(256, '2020-02-10 17:54:51', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(257, '2020-02-10 17:54:58', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(258, '2020-02-10 18:16:13', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(259, '2020-02-10 18:36:25', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(260, '2020-02-10 18:38:30', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(261, '2020-02-10 18:39:44', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(262, '2020-02-10 18:43:54', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(263, '2020-02-10 18:53:59', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(264, '2020-02-10 18:55:00', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(265, '2020-02-10 18:55:41', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(266, '2020-02-10 18:57:12', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(267, '2020-02-10 18:58:17', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(268, '2020-02-10 19:00:29', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(269, '2020-02-10 19:01:20', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(270, '2020-02-10 19:03:10', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(271, '2020-02-10 19:03:43', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(272, '2020-02-10 19:04:27', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(273, '2020-02-10 19:06:36', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(274, '2020-02-10 19:07:49', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(275, '2020-02-10 19:08:39', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(276, '2020-02-10 19:10:08', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(277, '2020-02-10 19:51:13', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(278, '2020-02-10 19:52:48', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(279, '2020-02-10 20:36:33', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(280, '2020-02-10 20:39:35', 'Login error', 'Nieudana próba logowania do systemu: admin'),
(281, '2020-02-10 20:39:37', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(282, '2020-02-10 20:41:45', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(283, '2020-02-10 20:43:03', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(284, '2020-02-10 20:47:02', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(285, '2020-02-10 20:56:29', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(286, '2020-02-10 21:06:05', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(287, '2020-02-10 21:07:53', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(288, '2020-02-10 21:27:13', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(289, '2020-02-10 21:38:39', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(290, '2020-02-10 21:58:48', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(291, '2020-02-10 22:00:00', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(292, '2020-02-10 22:42:21', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(293, '2020-02-10 22:43:31', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(294, '2020-02-10 22:46:54', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(295, '2020-02-10 22:47:02', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(296, '2020-02-10 22:47:14', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(297, '2020-02-10 22:47:30', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(298, '2020-02-10 22:47:55', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(299, '2020-02-10 22:48:09', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(300, '2020-02-10 22:48:21', 'Role created', 'Utworzono nową rolę: test'),
(301, '2020-02-10 22:48:26', 'Role edited', 'Edytowano role id: 6 przez: admin (1)'),
(302, '2020-02-10 22:58:32', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(303, '2020-02-10 23:00:22', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(304, '2020-02-10 23:08:27', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(305, '2020-02-10 23:09:29', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(306, '2020-02-10 23:11:23', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(307, '2020-02-10 23:16:40', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(308, '2020-02-10 23:18:25', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(309, '2020-02-10 23:20:18', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(310, '2020-02-10 23:23:16', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(311, '2020-02-10 23:25:44', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(312, '2020-02-10 23:27:12', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(313, '2020-02-10 23:28:41', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(314, '2020-02-10 23:34:24', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(315, '2020-02-10 23:43:05', 'Role edited', 'Edytowano role id: 6 przez: admin (1)'),
(316, '2020-02-10 23:43:40', 'Role edited', 'Edytowano role id: 6 przez: admin (1)'),
(317, '2020-02-10 23:43:47', 'Role edited', 'Edytowano role id: 6 przez: admin (1)'),
(318, '2020-02-10 23:44:12', 'Role edited', 'Edytowano role id: 4 przez: admin (1)'),
(319, '2020-02-10 23:51:42', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(320, '2020-02-10 23:52:57', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(321, '2020-02-10 23:54:31', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(322, '2020-02-10 23:56:04', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(323, '2020-02-10 23:58:02', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(324, '2020-02-11 00:14:57', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(325, '2020-02-11 00:18:00', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(326, '2020-02-11 00:22:46', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(327, '2020-02-11 00:27:46', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(328, '2020-02-11 00:29:54', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(329, '2020-02-11 00:33:17', 'Login successfull', 'Logowanie do systemu: admin (id: 1)'),
(330, '2020-02-11 00:47:48', 'Login successfull', 'Logowanie do systemu: admin (id: 1)');

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
(4, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0),
(5, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1),
(6, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0),
(7, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0),
(8, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1);

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
(4, 'priviliged_user', 'Funkcje użytkownika + może wyświetlać dostępne licencje', 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `software_package`
--

CREATE TABLE `software_package` (
  `id_package` int(11) NOT NULL,
  `name` varchar(256) COLLATE utf8mb4_polish_ci NOT NULL,
  `description` varchar(2048) COLLATE utf8mb4_polish_ci NOT NULL,
  `cretion_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_user` int(11) DEFAULT NULL,
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
(1, 'admin', 'Adam', 'Talarczyk', 'Adam.Talarczyk@hotmail.pl', 'a1e03cf022862126dabb2b06e3223521', 1, '2020-01-06 14:27:50'),
(2, 'user', 'Karolek', 'Wojtyla', 'Adam.Talarczyk@ibemag.pl1', 'a1e03cf022862126dabb2b06e3223521', 4, '2020-01-06 14:27:55'),
(3, 'moderator', 'Donald', 'Trump', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 3, '2020-01-06 14:27:56'),
(4, 'priv_user', 'Martyna', 'Buc', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 4, '2020-01-06 14:28:53'),
(5, 'user1', 'Adrian', 'Malina', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 2, '2020-01-06 14:27:59'),
(6, 'moderator360', 'Dariusz0', 'Kolos', 'Adam.Talarczssyk@ibemag.pl', 'd41d8cd98f00b204e9800998ecf8427e', 2, '2020-01-06 14:29:53'),
(7, 'priv_user1', 'Mariusz', 'Pudzianowski', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 4, '2020-01-06 14:28:53'),
(8, 'user2', 'Adam', 'Małysz', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 2, '2020-01-06 14:28:14'),
(9, 'moderator2', 'Norbert', 'Surowiec', 'Adam.Talarcazyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 3, '2020-01-06 14:28:12'),
(10, 'priv_user3', 'Beata', 'Malina', 'Adams.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 3, '2020-01-06 14:28:05'),
(11, 'user4', 'John', 'Paul', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 2, '2020-01-06 14:27:53'),
(12, 'moderator4', 'Jonasz', 'Koran-Mekka', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 3, '2020-01-06 14:27:54'),
(23, 'moderator4', 'Jonasz', 'Koran-Mekka', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 3, '2020-01-06 14:27:54'),
(24, 'user4', 'John', 'Paul', 'Adam.Talarczyk@ibemag.pl', 'a1e03cf022862126dabb2b06e3223521', 2, '2020-01-06 14:27:53'),
(25, 'kmielczarek', 'Konstancja', 'Mielczarek', 'kmielczi@hwdp.pl', 'eb65eb39cde1c19e0594f2ee51f5a6b1', 2, '2020-02-08 14:31:06');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `download_list`
--
ALTER TABLE `download_list`
  ADD PRIMARY KEY (`id_download`);

--
-- Indexes for table `fav_package`
--
ALTER TABLE `fav_package`
  ADD PRIMARY KEY (`id_fav`),
  ADD KEY `id_package` (`id_package`),
  ADD KEY `id_user` (`id_user`);

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
  ADD KEY `id_file` (`id_file`),
  ADD KEY `id_uploader` (`id_uploader`),
  ADD KEY `FKaclsgldlubyg7x7txf5vroxp6` (`id_licence`);

--
-- Indexes for table `licence`
--
ALTER TABLE `licence`
  ADD PRIMARY KEY (`id_licence`),
  ADD KEY `id_file_list` (`id_file_list`,`id_added_by`),
  ADD KEY `FKr5apnuxftc9il02pa2h7oqc5y` (`id_added_by`);

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
  MODIFY `id_download` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;
--
-- AUTO_INCREMENT dla tabeli `fav_package`
--
ALTER TABLE `fav_package`
  MODIFY `id_fav` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `file`
--
ALTER TABLE `file`
  MODIFY `id_file` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT dla tabeli `file_list`
--
ALTER TABLE `file_list`
  MODIFY `id_list_file` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT dla tabeli `licence`
--
ALTER TABLE `licence`
  MODIFY `id_licence` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `log`
--
ALTER TABLE `log`
  MODIFY `id_log` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=331;
--
-- AUTO_INCREMENT dla tabeli `permission`
--
ALTER TABLE `permission`
  MODIFY `id_permission` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
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
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `fav_package`
--
ALTER TABLE `fav_package`
  ADD CONSTRAINT `FKnwso1qry5g2dw4hv9pcv5bkxn` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `fav_package_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE,
  ADD CONSTRAINT `fav_package_ibfk_2` FOREIGN KEY (`id_package`) REFERENCES `software_package` (`id_package`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `file_list`
--
ALTER TABLE `file_list`
  ADD CONSTRAINT `FKaclsgldlubyg7x7txf5vroxp6` FOREIGN KEY (`id_licence`) REFERENCES `licence` (`id_licence`),
  ADD CONSTRAINT `FKcctypabwllr62f5k570wg8ind` FOREIGN KEY (`id_file`) REFERENCES `file` (`id_file`),
  ADD CONSTRAINT `FKtriv9i6w3vew1bkng0hvbs4wa` FOREIGN KEY (`id_uploader`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `file_list_ibfk_3` FOREIGN KEY (`id_licence`) REFERENCES `licence` (`id_licence`) ON DELETE SET NULL,
  ADD CONSTRAINT `file_list_ibfk_4` FOREIGN KEY (`id_uploader`) REFERENCES `user` (`id_user`) ON DELETE SET NULL,
  ADD CONSTRAINT `file_list_ibfk_5` FOREIGN KEY (`id_file`) REFERENCES `file` (`id_file`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `licence`
--
ALTER TABLE `licence`
  ADD CONSTRAINT `FKr5apnuxftc9il02pa2h7oqc5y` FOREIGN KEY (`id_added_by`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `licence_ibfk_2` FOREIGN KEY (`id_file_list`) REFERENCES `file_list` (`id_list_file`),
  ADD CONSTRAINT `licence_ibfk_3` FOREIGN KEY (`id_added_by`) REFERENCES `user` (`id_user`) ON DELETE SET NULL;

--
-- Ograniczenia dla tabeli `role`
--
ALTER TABLE `role`
  ADD CONSTRAINT `FKe656989qfduyxsmqadl716k6t` FOREIGN KEY (`id_permission`) REFERENCES `permission` (`id_permission`),
  ADD CONSTRAINT `role_ibfk_1` FOREIGN KEY (`id_permission`) REFERENCES `permission` (`id_permission`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `software_package`
--
ALTER TABLE `software_package`
  ADD CONSTRAINT `FK59v66hg7xl5h9lw1cw62q0ak6` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `software_package_ibfk_1` FOREIGN KEY (`id_file_list`) REFERENCES `file_list` (`id_list_file`),
  ADD CONSTRAINT `software_package_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE SET NULL;

--
-- Ograniczenia dla tabeli `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKe36vhtbbut4wj3vw6i2006c10` FOREIGN KEY (`id_permission`) REFERENCES `role` (`id_role`),
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_permission`) REFERENCES `role` (`id_role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
