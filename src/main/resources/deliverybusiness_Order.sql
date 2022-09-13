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
-- Table structure for table `Order`
--

DROP TABLE IF EXISTS `Order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Order` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `OrderDate` date NOT NULL,
  `PreparedDate` date NOT NULL,
  `TakenOverDate` date NOT NULL,
  `IsPaid` tinyint NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  `Note` varchar(45) NOT NULL,
  `restaurant_ID` int NOT NULL,
  `Customer_ID` int NOT NULL,
  `Coupons_ID` int NOT NULL,
  `OrderStatus_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Order_restaurant1_idx` (`restaurant_ID`),
  KEY `fk_Order_Customer1_idx` (`Customer_ID`),
  KEY `fk_Order_Coupons1_idx` (`Coupons_ID`),
  KEY `fk_Order_OrderStatus1_idx` (`OrderStatus_ID`),
  CONSTRAINT `fk_Order_Coupons1` FOREIGN KEY (`Coupons_ID`) REFERENCES `Coupons` (`ID`),
  CONSTRAINT `fk_Order_Customer1` FOREIGN KEY (`Customer_ID`) REFERENCES `Customer` (`ID`),
  CONSTRAINT `fk_Order_OrderStatus1` FOREIGN KEY (`OrderStatus_ID`) REFERENCES `OrderStatus` (`ID`),
  CONSTRAINT `fk_Order_restaurant1` FOREIGN KEY (`restaurant_ID`) REFERENCES `restaurant` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Order`
--

LOCK TABLES `Order` WRITE;
/*!40000 ALTER TABLE `Order` DISABLE KEYS */;
INSERT INTO `Order` VALUES (1,'2020-10-01','2020-10-01','0000-00-00',1,1.00,'fahe',1,1,1,1),(6,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(7,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(8,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(9,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(10,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(11,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(13,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(14,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(15,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(16,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(17,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(18,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(19,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(20,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(21,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(22,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(23,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(24,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(25,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(26,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(27,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(28,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(29,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(30,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(31,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(32,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(33,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1),(34,'2022-01-10','2022-01-10','2022-01-10',1,11.99,'note',1,1,1,1),(35,'2022-01-10','2022-01-10','2022-01-10',1,10.99,'note',1,2,1,1);
/*!40000 ALTER TABLE `Order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-13 13:52:25
