-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Ápr 13. 08:58
-- Kiszolgáló verziója: 10.4.21-MariaDB
-- PHP verzió: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `jaratok`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `appeals`
--

CREATE TABLE `appeals` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `reason` varchar(2000) COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `routes`
--

CREATE TABLE `routes` (
  `id` int(11) NOT NULL,
  `fromS` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `toS` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `ship` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `mfuel` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `economy` int(11) NOT NULL,
  `business` int(11) NOT NULL,
  `first` int(11) NOT NULL,
  `distance` int(11) NOT NULL,
  `shuttle_id` int(11) NOT NULL,
  `from_id` int(11) NOT NULL,
  `to_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `routes`
--

INSERT INTO `routes` (`id`, `fromS`, `toS`, `ship`, `mfuel`, `date`, `economy`, `business`, `first`, `distance`, `shuttle_id`, `from_id`, `to_id`) VALUES
(8, 'YS', 'Luyten 674-15 ', 'Dolphin', 8, '2022-04-15 01:00:00', 8, 32, 12, 19, 7, 1, 5),
(9, 'YS', 'LFT 1748 ', 'Dolphin', 8, '2022-04-15 01:00:00', 8, 32, 12, 46, 7, 1, 8),
(10, 'YS', 'LFT 1748 ', 'Dolphin', 8, '2022-04-21 00:00:00', 8, 32, 11, 46, 7, 1, 8),
(11, 'YS', 'Alpha Centauri', 'Fer-De-Lance', 8, '2022-04-14 04:07:00', 4, 12, 0, 4, 5, 1, 2),
(12, 'Alpha Centauri', 'YS', 'Beluga', 64, '2022-04-21 04:07:00', 12, 32, 64, 446, 9, 2, 14),
(13, 'Alpha Centauri', 'YS', 'Beluga', 64, '2022-08-30 04:07:00', 12, 32, 64, 446, 9, 2, 14),
(14, 'YS', 'Alpha Centauri', 'Type-7', 32, '2022-09-09 04:07:00', 64, 12, 0, 4, 6, 1, 2),
(15, 'YS', 'Betelgeuze', 'Victory-class', 10000, '2022-10-22 23:30:00', 2048, 1024, 509, 548, 10, 1, 16),
(16, 'Groombridge 34 ', 'LHS 3006 ', 'Imperial Cutter', 64, '2022-04-14 10:00:00', 0, 29, 32, 25, 3, 4, 7),
(17, 'SOL', 'Beta Hydri  ', 'Imperial Cutter', 64, '2022-04-22 06:00:00', 0, 32, 30, 24, 3, 1, 6);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `shuttles`
--

CREATE TABLE `shuttles` (
  `id` int(11) NOT NULL,
  `manufacturer` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `shipName` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `maxFuel` int(11) NOT NULL,
  `eSeats` int(11) NOT NULL,
  `bSeats` int(11) NOT NULL,
  `fSeats` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `shuttles`
--

INSERT INTO `shuttles` (`id`, `manufacturer`, `shipName`, `maxFuel`, `eSeats`, `bSeats`, `fSeats`) VALUES
(3, 'Gutamaya', 'Imperial Cutter', 64, 0, 32, 32),
(4, 'Zorgon Peterson', 'Mamba', 8, 16, 8, 2),
(5, 'Zorgon Peterson', 'Fer-De-Lance', 8, 4, 12, 0),
(6, 'LAKON', 'Type-7', 32, 64, 12, 0),
(7, 'Saud Kruger', 'Dolphin', 8, 8, 32, 12),
(8, 'Saud Kruger', 'Orca', 32, 8, 32, 18),
(9, 'Saud Kruger', 'Beluga', 64, 12, 32, 64),
(10, 'Brewer corp.', 'Victory-class', 10000, 2048, 1024, 512),
(11, 'Core Dynamics', 'Federal Corvette', 64, 64, 64, 32);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `systems`
--

CREATE TABLE `systems` (
  `id` int(11) NOT NULL,
  `systemName` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `starportName` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `solDistance` int(11) NOT NULL,
  `numOfBodies` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `systems`
--

INSERT INTO `systems` (`id`, `systemName`, `starportName`, `solDistance`, `numOfBodies`) VALUES
(1, 'SOL', 'Abraham', 0, 40),
(2, 'Alpha Centauri', 'Lig', 4, 23),
(3, 'WISE 0855-0714 ', 'Space Installations', 7, 14),
(4, 'Groombridge 34 ', '4A', 11, 22),
(5, 'Luyten 674-15 ', 'Ruthenium Port', 19, 33),
(6, 'Beta Hydri  ', 'Goemon', 24, 54),
(7, 'LHS 3006 ', 'Yuksarr wing', 36, 21),
(8, 'LFT 1748 ', 'LFT 1748 A2', 46, 36),
(9, 'Ross 690 ', 'Slough', 59, 3),
(10, 'VESPER-M4 ', 'Homestad', 61, 23),
(11, 'BD+26 2184 ', 'Chaudhary Enterprise', 69, 14),
(12, 'Sun Takush ', 'Jack╗s Town', 81, 11),
(13, 'HIP 59382 ', 'Panet B1', 132, 38),
(14, 'YS', 'Ashdown', 450, 23),
(15, 'Beagle point', 'Sol view point', 62400, 2),
(16, 'Betelgeuze', 'Giant Star View', 548, 4);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `tickets`
--

CREATE TABLE `tickets` (
  `ticketId` int(11) NOT NULL,
  `route_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `departure` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `destination` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `ship` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `date` datetime NOT NULL,
  `seat` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `tickets`
--

INSERT INTO `tickets` (`ticketId`, `route_id`, `user_id`, `departure`, `destination`, `ship`, `date`, `seat`) VALUES
(6, 10, 1, 'Sol', 'LFT 1748 ', 'Dolphin', '2022-04-21 00:00:00', 'First Class'),
(7, 15, 1, 'Sol', 'Betelgeuze', 'Victory-class', '2022-10-22 23:30:00', 'First Class'),
(8, 15, 1, 'Sol', 'Betelgeuze', 'Victory-class', '2022-10-22 23:30:00', 'First Class'),
(9, 15, 1, 'Sol', 'Betelgeuze', 'Victory-class', '2022-10-22 23:30:00', 'First Class'),
(10, 17, 1, 'SOL', 'Beta Hydri  ', 'Imperial Cutter', '2022-04-22 06:00:00', 'First Class'),
(11, 17, 1, 'SOL', 'Beta Hydri  ', 'Imperial Cutter', '2022-04-22 06:00:00', 'First Class'),
(12, 16, 1, 'Groombridge 34 ', 'LHS 3006 ', 'Imperial Cutter', '2022-04-14 10:00:00', 'Business'),
(13, 16, 1, 'Groombridge 34 ', 'LHS 3006 ', 'Imperial Cutter', '2022-04-14 10:00:00', 'Business'),
(14, 16, 1, 'Groombridge 34 ', 'LHS 3006 ', 'Imperial Cutter', '2022-04-14 10:00:00', 'Business');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `userfield` varchar(100) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `passwordfield` varchar(100) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `clearance` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `wallet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `users`
--

INSERT INTO `users` (`id`, `userfield`, `passwordfield`, `email`, `clearance`, `wallet`) VALUES
(1, 'Admin', 'admin', 'test@gmail.com', 'O5', 1850658473),
(2, 'user', 'pass', 'user@mail.com', 'L0', 0),
(3, 'bob', 'bob', 'bob@bob.com', 'L0', 0),
(4, 'Vicky', 'admin', 'al@gmail.com', 'L4', 0),
(5, 'noob', 'noob', 'noob@gmail.com', 'banned', 0),
(6, 'Dominik', '36531', 'bakcsanyi.dominik.2017ice@bankitatabanya.hu', 'L0', 0),
(7, 'asd', '62647', 'b.arthab1022@gmail.com', 'L0', 0);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `appeals`
--
ALTER TABLE `appeals`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- A tábla indexei `routes`
--
ALTER TABLE `routes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `shuttle_id` (`shuttle_id`),
  ADD KEY `from_id` (`from_id`,`to_id`),
  ADD KEY `to_id` (`to_id`);

--
-- A tábla indexei `shuttles`
--
ALTER TABLE `shuttles`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `systems`
--
ALTER TABLE `systems`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`ticketId`),
  ADD KEY `route_id` (`route_id`),
  ADD KEY `user_id` (`user_id`);

--
-- A tábla indexei `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `appeals`
--
ALTER TABLE `appeals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT a táblához `routes`
--
ALTER TABLE `routes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT a táblához `shuttles`
--
ALTER TABLE `shuttles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT a táblához `systems`
--
ALTER TABLE `systems`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT a táblához `tickets`
--
ALTER TABLE `tickets`
  MODIFY `ticketId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT a táblához `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `appeals`
--
ALTER TABLE `appeals`
  ADD CONSTRAINT `appeals_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `routes`
--
ALTER TABLE `routes`
  ADD CONSTRAINT `routes_ibfk_1` FOREIGN KEY (`from_id`) REFERENCES `systems` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `routes_ibfk_2` FOREIGN KEY (`to_id`) REFERENCES `systems` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `routes_ibfk_3` FOREIGN KEY (`shuttle_id`) REFERENCES `shuttles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `tickets`
--
ALTER TABLE `tickets`
  ADD CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `routes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tickets_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
