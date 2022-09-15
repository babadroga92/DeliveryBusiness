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
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Customer` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FullName` varchar(45) NOT NULL,
  `Address` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `City` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `City` (`City`),
  CONSTRAINT `City` FOREIGN KEY (`City`) REFERENCES `City` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (1,'Nemanja Matic','Bul. Despota Stefana 6',NULL),(2,'Jelena Nikic','Sime Solaje 81',NULL),(3,'Alicia Keys','1409 Grassmere Ct',NULL),(4,'Nina Bozic','900 Piney Branch Lane',NULL),(5,'Dragana Mirkovic','Mose Pijade 101',1),(6,'Milos Jovicic','Mose Pijade 102',2),(7,'Dragana Mirkovic','Mose Pijade 101',1),(8,'Milos Jovicic','Mose Pijade 102',2),(9,'Dragana Mirkovic','Mose Pijade 101',1),(10,'Milos Jovicic','Mose Pijade 102',2),(11,'Dragana Mirkovic','Mose Pijade 101',1),(12,'Milos Jovicic','Mose Pijade 102',2),(13,'Dragana Mirkovic','Mose Pijade 101',1),(15,'Dragana Mirkovic','Mose Pijade 101',1),(16,'Milos Jovicic','Mose Pijade 102',2),(17,'Dragana Mirkovic','Mose Pijade 101',1),(18,'Milos Jovicic','Mose Pijade 102',2),(19,'Dragana Mirkovic','Mose Pijade 101',1),(20,'Milos Jovicic','Mose Pijade 102',2),(21,'Dragana Mirkovic','Mose Pijade 101',1),(22,'Milos Jovicic','Mose Pijade 102',2),(23,'Dragana Mirkovic','Mose Pijade 101',1),(24,'Milos Jovicic','Mose Pijade 102',2),(25,'Dragana Mirkovic','Mose Pijade 101',1),(26,'Milos Jovicic','Mose Pijade 102',2),(27,'Dragana Mirkovic','Mose Pijade 101',1),(28,'Milos Jovicic','Mose Pijade 102',2),(29,'Dragana Mirkovic','Mose Pijade 101',1),(30,'Milos Jovicic','Mose Pijade 102',2),(31,'Dragana Mirkovic','Mose Pijade 101',1),(32,'Milos Jovicic','Mose Pijade 102',2),(33,'Dragana Mirkovic','Mose Pijade 101',1),(34,'Milos Jovicic','Mose Pijade 102',2),(35,'Dragana Mirkovic','Mose Pijade 101',1),(36,'Milos Jovicic','Mose Pijade 102',2),(37,'Dragana Mirkovic','Mose Pijade 101',1),(38,'Milos Jovicic','Mose Pijade 102',2),(39,'Dragana Mirkovic','Mose Pijade 101',1),(40,'Milos Jovicic','Mose Pijade 102',2),(41,'Dragana Mirkovic','Mose Pijade 101',1),(42,'Milos Jovicic','Mose Pijade 102',2),(43,'Dragana Mirkovic','Mose Pijade 101',1),(44,'Milos Jovicic','Mose Pijade 102',2),(45,'Dragana Mirkovic','Mose Pijade 101',1),(46,'Milos Jovicic','Mose Pijade 102',2),(47,'Dragana Mirkovic','Mose Pijade 101',1),(48,'Milos Jovicic','Mose Pijade 102',2),(49,'Dragana Mirkovic','Mose Pijade 101',1),(50,'Milos Jovicic','Mose Pijade 102',2),(51,'Dragana Mirkovic','Mose Pijade 101',1),(52,'Milos Jovicic','Mose Pijade 102',2),(53,'Dragana Mirkovic','Mose Pijade 101',1),(54,'Milos Jovicic','Mose Pijade 102',2),(55,'Dragana Mirkovic','Mose Pijade 101',1),(56,'Milos Jovicic','Mose Pijade 102',2),(57,'Dragana Mirkovic','Mose Pijade 101',1),(58,'Milos Jovicic','Mose Pijade 102',2),(59,'Dragana Mirkovic','Mose Pijade 101',1),(60,'Milos Jovicic','Mose Pijade 102',2),(61,'Dragana Mirkovic','Mose Pijade 101',1),(62,'Milos Jovicic','Mose Pijade 102',2),(63,'Dragana Mirkovic','Mose Pijade 101',1),(64,'Milos Jovicic','Mose Pijade 102',2),(65,'Dragana Mirkovic','Mose Pijade 101',1),(66,'Milos Jovicic','Mose Pijade 102',2),(67,'Dragana Mirkovic','Mose Pijade 101',1),(68,'Milos Jovicic','Mose Pijade 102',2),(69,'Dragana Mirkovic','Mose Pijade 101',1),(70,'Milos Jovicic','Mose Pijade 102',2),(71,'Dragana Mirkovic','Mose Pijade 101',1),(72,'Milos Jovicic','Mose Pijade 102',2),(73,'Dragana Mirkovic','Mose Pijade 101',1),(74,'Milos Jovicic','Mose Pijade 102',2),(75,'Dragana Mirkovic','Mose Pijade 101',1),(76,'Milos Jovicic','Mose Pijade 102',2),(77,'Dragana Mirkovic','Mose Pijade 101',1),(78,'Milos Jovicic','Mose Pijade 102',2),(79,'Dragana Mirkovic','Mose Pijade 101',1),(80,'Milos Jovicic','Mose Pijade 102',2),(81,'Dragana Mirkovic','Mose Pijade 101',1),(82,'Milos Jovicic','Mose Pijade 102',2),(83,'Dragana Mirkovic','Mose Pijade 101',1),(84,'Milos Jovicic','Mose Pijade 102',2),(85,'Dragana Mirkovic','Mose Pijade 101',1),(86,'Milos Jovicic','Mose Pijade 102',2),(87,'Dragana Mirkovic','Mose Pijade 101',1),(88,'Milos Jovicic','Mose Pijade 102',2),(89,'Dragana Mirkovic','Mose Pijade 101',1),(90,'Milos Jovicic','Mose Pijade 102',2),(91,'Dragana Mirkovic','Mose Pijade 101',1),(92,'Milos Jovicic','Mose Pijade 102',2),(93,'Dragana Mirkovic','Mose Pijade 101',1),(94,'Milos Jovicic','Mose Pijade 102',2),(95,'Dragana Mirkovic','Mose Pijade 101',1),(96,'Milos Jovicic','Mose Pijade 102',2),(97,'Dragana Mirkovic','Mose Pijade 101',1),(98,'Milos Jovicic','Mose Pijade 102',2),(99,'Dragana Mirkovic','Mose Pijade 101',1),(100,'Milos Jovicic','Mose Pijade 102',2),(101,'Dragana Mirkovic','Mose Pijade 101',1),(102,'Milos Jovicic','Mose Pijade 102',2),(103,'Dragana Mirkovic','Mose Pijade 101',1),(104,'Milos Jovicic','Mose Pijade 102',2),(105,'Dragana Mirkovic','Mose Pijade 101',1),(106,'Milos Jovicic','Mose Pijade 102',2),(107,'Dragana Mirkovic','Mose Pijade 101',1),(108,'Milos Jovicic','Mose Pijade 102',2),(109,'Dragana Mirkovic','Mose Pijade 101',1),(110,'Milos Jovicic','Mose Pijade 102',2),(111,'Dragana Mirkovic','Mose Pijade 101',1),(112,'Milos Jovicic','Mose Pijade 102',2),(113,'Dragana Mirkovic','Mose Pijade 101',1),(114,'Milos Jovicic','Mose Pijade 102',2),(115,'Dragana Mirkovic','Mose Pijade 101',1),(116,'Milos Jovicic','Mose Pijade 102',2),(117,'Dragana Mirkovic','Mose Pijade 101',1),(118,'Milos Jovicic','Mose Pijade 102',2),(119,'Dragana Mirkovic','Mose Pijade 101',1),(120,'Milos Jovicic','Mose Pijade 102',2),(121,'Dragana Mirkovic','Mose Pijade 101',1),(122,'Milos Jovicic','Mose Pijade 102',2),(123,'Dragana Mirkovic','Mose Pijade 101',1),(124,'Milos Jovicic','Mose Pijade 102',2),(125,'Dragana Mirkovic','Mose Pijade 101',1),(126,'Milos Jovicic','Mose Pijade 102',2),(127,'Dragana Mirkovic','Mose Pijade 101',1),(128,'Milos Jovicic','Mose Pijade 102',2),(129,'Dragana Mirkovic','Mose Pijade 101',1),(130,'Milos Jovicic','Mose Pijade 102',2),(131,'Dragana Mirkovic','Mose Pijade 101',1),(132,'Milos Jovicic','Mose Pijade 102',2),(133,'Dragana Mirkovic','Mose Pijade 101',1),(134,'Milos Jovicic','Mose Pijade 102',2),(135,'Dragana Mirkovic','Mose Pijade 101',1),(136,'Milos Jovicic','Mose Pijade 102',2),(137,'Dragana Mirkovic','Mose Pijade 101',1),(138,'Milos Jovicic','Mose Pijade 102',2),(139,'Dragana Mirkovic','Mose Pijade 101',1),(140,'Milos Jovicic','Mose Pijade 102',2);
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
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
