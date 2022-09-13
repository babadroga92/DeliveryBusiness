-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: 127.0.0.1    Database: deliverybusiness
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `OpeningHours`
--

DROP TABLE IF EXISTS `OpeningHours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `OpeningHours` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FromTime` varchar(20) DEFAULT NULL,
  `ToTime` varchar(20) DEFAULT NULL,
  `WeekDay_ID` int NOT NULL,
  `restaurant_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_OpeningHours_WeekDay1_idx` (`WeekDay_ID`),
  KEY `fk_OpeningHours_restaurant1_idx` (`restaurant_ID`),
  CONSTRAINT `fk_OpeningHours_restaurant1` FOREIGN KEY (`restaurant_ID`) REFERENCES `restaurant` (`ID`),
  CONSTRAINT `fk_OpeningHours_WeekDay1` FOREIGN KEY (`WeekDay_ID`) REFERENCES `WeekDay` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OpeningHours`
--

LOCK TABLES `OpeningHours` WRITE;
/*!40000 ALTER TABLE `OpeningHours` DISABLE KEYS */;
INSERT INTO `OpeningHours` VALUES (1,'9:00','21:00',1,1),(2,'9:00','21:00',2,1),(3,'9:00','21:00',3,1),(4,'9:00','21:00',4,1),(5,'9:00','22:00',5,1),(6,'9:00','22:00',6,1),(7,'9:00','15:00',7,1);
/*!40000 ALTER TABLE `OpeningHours` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-13 13:52:24
