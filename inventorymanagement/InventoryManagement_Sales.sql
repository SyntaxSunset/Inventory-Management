-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: 127.0.0.1    Database: InventoryManagement
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Sales`
--

DROP TABLE IF EXISTS `Sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Sales` (
  `ItemId` int NOT NULL,
  `Name` varchar(255) NOT NULL,
  `SupplierName` varchar(255) NOT NULL,
  `Quantity` varchar(45) NOT NULL,
  `Price` int NOT NULL,
  `Total` int NOT NULL,
  `DateAndTime` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sales`
--

LOCK TABLES `Sales` WRITE;
/*!40000 ALTER TABLE `Sales` DISABLE KEYS */;
INSERT INTO `Sales` VALUES (1569,'Dell D1 Inkjet Printer','Ishaan Kumar','8',8999,71992,'Mon Nov 11 01:10:25 IST 2024'),(1569,'Dell D1 Inkjet Printer','Ishaan Kumar','6',8999,53994,'Tue Nov 12 01:22:40 IST 2024'),(1569,'Dell D1 Inkjet Printer','Ishaan Kumar','12',8999,107988,'Tue Nov 12 23:06:59 IST 2024'),(1569,'Dell D1 Inkjet Printer','Ishaan Kumar','8',8999,71992,'Wed Nov 13 01:17:31 IST 2024'),(1569,'Dell D1 Inkjet Printer','Ishaan Kumar','5',8999,44995,'Sat Nov 16 00:05:14 IST 2024'),(1574,'Epson Expression Printer','Rishav','25',15999,399975,'Sat Nov 16 13:57:57 IST 2024'),(1574,'Epson Expression Printer','Rishav','50',15999,799950,'Sat Nov 16 14:27:34 IST 2024');
/*!40000 ALTER TABLE `Sales` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-17 11:43:12
