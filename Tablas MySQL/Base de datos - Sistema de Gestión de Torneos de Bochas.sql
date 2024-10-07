CREATE DATABASE  IF NOT EXISTS `sgtb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sgtb`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sgtb
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `administradorID` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`administradorID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'Juan','González','juan.gonzalez@gmail.com'),(2,'María','Pérez','maria.perez@gmail.com'),(3,'Carlos','Lopez','carlos.lopez@gmail.com'),(4,'Lucía','Martinez','lucia.martinez@gmail.com');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugador`
--

DROP TABLE IF EXISTS `jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugador` (
  `jugadorID` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `edad` int NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `puntaje` int DEFAULT NULL,
  PRIMARY KEY (`jugadorID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES (1,'Pedro','Ramirez',30,'pedro.ramirez@gmail.com',150),(2,'Ana','Fernandez',25,'ana.fernandez@gmail.com',200),(3,'Luis','Garcia',28,'luis.garcia@gmail.com',180),(4,'Sofia','Martinez',22,'sofia.martinez@gmail.com',170),(5,'Jorge','Lopez',35,'jorge.lopez@gmailv.com',160),(6,'Carla','Gomez',27,'carla.gomez@gmail.com',190),(7,'Diego','Alvarez',29,'diego.alvarez@gmail.com',210),(8,'Laura','Sanchez',26,'laura.sanchez@gmail.com',140);
/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partido` (
  `partidoID` int NOT NULL AUTO_INCREMENT,
  `jugador1` int NOT NULL,
  `jugador2` int NOT NULL,
  `fecha` datetime NOT NULL,
  `resultado` varchar(45) NOT NULL,
  `administrador` int NOT NULL,
  `torneo` int NOT NULL,
  PRIMARY KEY (`partidoID`),
  KEY `jugador1_idx` (`jugador1`),
  KEY `jugador2_idx` (`jugador2`),
  KEY `administrador_idx` (`administrador`),
  KEY `torneo_idx` (`torneo`),
  CONSTRAINT `administrador` FOREIGN KEY (`administrador`) REFERENCES `administrador` (`administradorID`),
  CONSTRAINT `jugador1` FOREIGN KEY (`jugador1`) REFERENCES `jugador` (`jugadorID`),
  CONSTRAINT `jugador2` FOREIGN KEY (`jugador2`) REFERENCES `jugador` (`jugadorID`),
  CONSTRAINT `torneop` FOREIGN KEY (`torneo`) REFERENCES `torneo` (`torneoID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES (1,1,2,'2024-10-10 10:00:00','3-1',1,1),(2,3,4,'2024-10-10 11:00:00','2-3',1,1),(3,5,6,'2024-10-10 12:00:00','1-3',2,1),(4,7,8,'2024-10-10 13:00:00','3-0',2,1),(5,1,3,'2024-11-15 10:00:00','3-2',3,2),(6,4,5,'2024-11-15 11:00:00','1-3',3,2),(7,6,7,'2024-11-15 12:00:00','3-1',4,2),(8,8,2,'2024-11-15 13:00:00','2-3',4,2),(9,1,4,'2024-12-20 10:00:00','3-0',1,3),(10,5,8,'2024-12-20 11:00:00','2-3',2,3);
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ranking`
--

DROP TABLE IF EXISTS `ranking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ranking` (
  `rankingID` int NOT NULL AUTO_INCREMENT,
  `jugador` int NOT NULL,
  `puntos` int NOT NULL,
  PRIMARY KEY (`rankingID`),
  KEY `jugador_idx` (`jugador`),
  CONSTRAINT `jugador` FOREIGN KEY (`jugador`) REFERENCES `jugador` (`jugadorID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranking`
--

LOCK TABLES `ranking` WRITE;
/*!40000 ALTER TABLE `ranking` DISABLE KEYS */;
INSERT INTO `ranking` VALUES (1,1,150),(2,2,200),(3,3,180),(4,4,170),(5,5,160),(6,6,190),(7,7,210),(8,8,140);
/*!40000 ALTER TABLE `ranking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torneo`
--

DROP TABLE IF EXISTS `torneo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `torneo` (
  `torneoID` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `estado` tinyint NOT NULL,
  PRIMARY KEY (`torneoID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torneo`
--

LOCK TABLES `torneo` WRITE;
/*!40000 ALTER TABLE `torneo` DISABLE KEYS */;
INSERT INTO `torneo` VALUES (1,'Torneo de Primavera','2024-09-21 10:00:00',1),(2,'Torneo de Verano','2024-12-21 15:00:00',0),(3,'Torneo Anual','2024-01-01 09:30:00',1);
/*!40000 ALTER TABLE `torneo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-06 20:58:49
