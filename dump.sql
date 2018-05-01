-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.21-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры для таблица navr.facultet
CREATE TABLE IF NOT EXISTS `facultet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица navr.request
CREATE TABLE IF NOT EXISTS `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `namecompany` varchar(255) DEFAULT NULL,
  `datestart` date DEFAULT NULL,
  `datefinish` date DEFAULT NULL,
  `idspeciality` int(11) DEFAULT NULL,
  `minavscore` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `request_speciality_id_fk` (`idspeciality`),
  CONSTRAINT `request_speciality_id_fk` FOREIGN KEY (`idspeciality`) REFERENCES `speciality` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица navr.requstandstudent
CREATE TABLE IF NOT EXISTS `requstandstudent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idstudent` int(11) DEFAULT NULL,
  `idrequest` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `requstandstudent_student_id_fk` (`idstudent`),
  KEY `requstandstudent_request_id_fk` (`idrequest`),
  CONSTRAINT `requstandstudent_request_id_fk` FOREIGN KEY (`idrequest`) REFERENCES `request` (`id`),
  CONSTRAINT `requstandstudent_student_id_fk` FOREIGN KEY (`idstudent`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица navr.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_user_id_fk` (`user_id`),
  CONSTRAINT `role_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица navr.speciality
CREATE TABLE IF NOT EXISTS `speciality` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `facult_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `speciality_facultet_id_fk` (`facult_id`),
  CONSTRAINT `speciality_facultet_id_fk` FOREIGN KEY (`facult_id`) REFERENCES `facultet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица navr.student
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `surname` varchar(255) DEFAULT NULL,
  `namestud` varchar(255) DEFAULT NULL,
  `spec_id` int(11) DEFAULT NULL,
  `groupstud` int(11) DEFAULT NULL,
  `budjet` varchar(255) DEFAULT NULL,
  `avscore` double DEFAULT NULL,
  `statusstud` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_speciality_id_fk` (`spec_id`),
  CONSTRAINT `student_speciality_id_fk` FOREIGN KEY (`spec_id`) REFERENCES `speciality` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица navr.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `passuser` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `id_request` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_request_id_fk` (`id_request`),
  KEY `user_student_id_fk` (`student_id`),
  CONSTRAINT `user_request_id_fk` FOREIGN KEY (`id_request`) REFERENCES `request` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_student_id_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
