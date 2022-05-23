-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 23 2022 г., 07:58
-- Версия сервера: 10.4.22-MariaDB
-- Версия PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `javaee_db`
--

-- --------------------------------------------------------

--
-- Структура таблицы `countries`
--

CREATE TABLE `countries` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `countries`
--

INSERT INTO `countries` (`id`, `name`, `code`) VALUES
(1, 'KAZAKHSTAN', 'KAZ'),
(2, 'GREAT BRITAIN', 'GBR'),
(3, 'UNITED STATES OF AMERICA', 'USA'),
(4, 'CANADA', 'CAD');

-- --------------------------------------------------------

--
-- Структура таблицы `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `header` varchar(255) NOT NULL,
  `content` varchar(5000) NOT NULL,
  `author` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `news`
--

INSERT INTO `news` (`id`, `header`, `content`, `author`, `type`) VALUES
(1, 'Billie Eilish says \'tons of people\' hate her now, but she feels less pressure than before: \'I\'m not worried\'', 'Since then, things have changed, as has her attitude.  \"Now, like tons of people hate me so I\'m not worried anymore,\" Eilish explained. \"I\'m like, âOh, OK, well, if you like me, you like me, if you donât, you don\'t.\'\"  BILLIE EILISH CALLS OUT JIMMY KIMMEL FOR MAKING HER LOOK \'DUMB\' DURING HER LAST APPEARANCE ON HIS SHOW  Her past answers to the question were also highlighted during the video interview.  \"Yep, but I don\'t f---ing care,\" she said previously. \"I really don\'t care. It\'s the kind of pressure, like it hits me, and then I don\'t care.\"', 'Billie Eilish', 'culture'),
(2, 'Nurgissa will marry on this MONTH', 'Nurgissa and Aruzhan going to marry', 'Akzhol Knyazzov', 'culture');

-- --------------------------------------------------------

--
-- Структура таблицы `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `birth_date` date NOT NULL,
  `city` varchar(255) NOT NULL,
  `country_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `students`
--

INSERT INTO `students` (`id`, `name`, `surname`, `birth_date`, `city`, `country_id`) VALUES
(1, 'Cilian', 'Murphy', '1992-05-18', 'Boston', 3),
(2, 'Akzhol', 'Knyazov', '2020-11-24', 'Almaty', 1),
(3, 'Tom', 'Hardy', '1988-12-12', 'Birmingham', 2),
(4, 'Nurgissa', 'Ussen', '1998-10-13', 'Aktau', 1),
(5, 'Quka', 'Salyq', '1998-07-21', 'Almaty', 1),
(8, 'Dimash', 'Kudaibergen', '1995-11-06', 'Almaty', 1),
(9, 'Adriano', 'Celentano', '1950-10-16', 'Toronto', 4);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD KEY `students_countries_id_fk` (`country_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `countries`
--
ALTER TABLE `countries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_countries_id_fk` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
