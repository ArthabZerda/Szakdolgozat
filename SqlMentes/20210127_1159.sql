-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Jan 27. 11:57
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
(3, 'Gutamaya', 'Imperial Cutter', 64, 12, 34, 16),
(4, 'Zorgon Peterson', 'Mamba', 8, 0, 32, 0),
(5, 'Zorgon Peterson', 'Fer-De-Lance', 8, 8, 16, 0),
(6, 'Core Dynamics', 'Federal Dropship', 16, 16, 8, 0),
(7, 'Faulcon DeLacy', 'Anaconda', 32, 8, 64, 16),
(11, 'Zorgon Peterson', 'Adder', 4, 8, 0, 0),
(12, 'Saud Kruger', 'Beluga', 64, 16, 128, 64);

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
(1, 'Sol', 'Rosevelt Port', 0, 9),
(2, 'YS', 'Ashdown', 450, 10);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `userfield` varchar(100) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `passwordfield` varchar(100) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `users`
--

INSERT INTO `users` (`id`, `userfield`, `passwordfield`, `email`) VALUES
(1, 'admin', 'admin', 'valami@email.hu'),
(2, 'user', 'pass', 'user2@email.hu'),
(3, 'bob', 'bob', 'bob@email.hu');

--
-- Indexek a kiírt táblákhoz
--

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
-- A tábla indexei `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `shuttles`
--
ALTER TABLE `shuttles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT a táblához `systems`
--
ALTER TABLE `systems`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
