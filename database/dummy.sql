-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: dummy
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `data` (
  `code` varchar(20) NOT NULL,
  `name` varchar(70) NOT NULL,
  `age` int(11) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `job` varchar(50) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
INSERT INTO `data` VALUES ('ag124','Joni Trojacek',37,'3443433','jtrojacek@live.com','Sports Journalist'),('ag16','Zoe Hubler',54,'343242','zhub@live.com','College Principal'),('ag195','Shirley Gooden',39,'4543433','sgdn@icloud.com','Customer Designer'),('ag213','Petra Younce',24,'4345434','pyounce@live.com','Engineer'),('ag230','Shad Tamez',29,'3762232','shadtam@yahoo.com','Bus Driver'),('ag234','Kathaleen Daves',45,'8277433','kdaves@hotmail.com','School Teacher'),('ag317','Patrick Prenatt',72,'8372732','papre@live.com','Retired'),('ag320','Lesli Collie',51,'7434342','lescol@icloud.com','College Teacher'),('ag345','Wilbert Gangestad',20,'2311213','wilgan@yahoo.com','Software Junior Developer'),('ag390','Elbert Malik',19,'73434634','elmalik@msn.com','College Student'),('ag450','Hassie Stagner',34,'8377444','hstagner@live.com','Software Senior Developer'),('ag454','Caroll Prowse',73,'8773723','cprow@msn.com','Lawyer'),('ag52','Brianna Mcmaster',47,'5323434','bmaster@hotmail.com','Nurse'),('ag552','Sheena Jaquez',41,'7554433','sjaq@msn.com','Visual Designer'),('ag578','Napoleon Agudelo',31,'4343433','napa@icloud.com','College Student'),('ag590','Darrel Blauser',48,'7273232','dbla@hotmail.com','College Teacher'),('ag945','Debroah Sylvia',54,'1232233','dSylvia@yahoo.com','School Principal'),('ag95','Jennie Hilgefort',21,'4343433','jhilgefort@icloud.com','College Student'),('ag953','Porsha Mills',23,'8343434','pomills@yahoo.com','Sales Representant'),('ag976','Mazie Newland',43,'8237732','mnewland@hotmail.com','School Teacher');
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'dummy'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-05 14:03:04
