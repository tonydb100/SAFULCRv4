CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asset`
--

DROP TABLE IF EXISTS `asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asset` (
  `asset_id` int(11) NOT NULL AUTO_INCREMENT,
  `asset_name` varchar(45) NOT NULL,
  `asset_department` varchar(45) NOT NULL,
  `asset_headquarter` varchar(45) NOT NULL,
  `asset_code` varchar(45) NOT NULL,
  `asset_registrationDate` varchar(45) NOT NULL,
  `asset_user` varchar(45) NOT NULL,
  `asset_description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`asset_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` VALUES (1,'SILLA','SELECCIONE DEPARTAMENTO','SELECCIONE SEDE','S23','04/04/2017 23:45:20','amorales','SENCILLA'),(2,'MESA','ADMINISTRACION','SAN PEDRO','M54','04/04/2017 23:48:37','','MESA LARGA 2M');
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(45) NOT NULL,
  `department_detail` varchar(100) DEFAULT NULL,
  `department_headquarter` varchar(45) NOT NULL,
  `department_registrationDate` varchar(45) NOT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (2,'ADMINISTRACION','AREA ADMINISTRATIVA','HEREDIA','09/03/2017 11:06:50'),(3,'CONTABILIDAD','DEPARTAMENTO CONTABLE','SAN PEDRO','09/03/2017 11:34:36'),(7,'VXCV','','HEREDIA','23/03/2017 23:06:39');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER'),(3,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `session` (
  `session_id` int(11) NOT NULL AUTO_INCREMENT,
  `session_username` varchar(45) NOT NULL,
  `session_start` varchar(45) NOT NULL,
  `session_end` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES (1,'amorales','09/03/2017 13:03:45','final'),(2,'amorales','09/03/2017 13:22:11','final'),(3,'sakly','09/03/2017 13:22:23','final'),(4,'sakly','09/03/2017 13:26:14','final'),(5,'sakly','09/03/2017 13:27:37','final'),(6,'sakly','09/03/2017 13:33:22','final'),(7,'amorales','09/03/2017 13:33:46','final'),(8,'amorales','09/03/2017 21:12:04','final'),(9,'sakly','09/03/2017 21:12:18','final'),(10,'sakly','09/03/2017 21:22:17','final'),(11,'amorales','20/03/2017 23:23:06','final'),(12,'amorales','20/03/2017 23:48:07','final'),(13,'amorales','20/03/2017 23:50:46','final'),(14,'amorales','20/03/2017 23:52:20','final'),(15,'amorales','20/03/2017 23:59:26','finally'),(16,'sakly','21/03/2017 22:40:19','finallys'),(17,'amorales','21/03/2017 22:47:17',NULL),(18,'amorales','21/03/2017 22:50:23','finallys'),(19,'amorales','21/03/2017 22:55:00','21/03/2017 22:55:10'),(20,'amorales','21/03/2017 22:57:55','21/03/2017 22:58:02'),(21,'sakly','21/03/2017 23:00:35','21/03/2017 23:00:41'),(22,'amorales','21/03/2017 23:02:11','21/03/2017 23:02:18'),(23,'amorales','23/03/2017 21:59:23','23/03/2017 21:59:59'),(24,'amorales','23/03/2017 22:28:51',NULL),(25,'amorales','23/03/2017 22:30:48','23/03/2017 22:37:36'),(26,'amorales','23/03/2017 22:37:53',NULL),(27,'amorales','23/03/2017 22:49:30',NULL),(28,'amorales','23/03/2017 22:53:55',NULL),(29,'amorales','23/03/2017 23:07:06','23/03/2017 23:07:53'),(30,'amorales','23/03/2017 23:09:33',NULL),(31,'amorales','04/04/2017 20:20:19',NULL),(32,'amorales','04/04/2017 20:25:42',NULL),(33,'amorales','04/04/2017 23:34:44','04/04/2017 23:36:35'),(34,'amorales','04/04/2017 23:36:47',NULL),(35,'amorales','04/04/2017 23:38:50',NULL),(36,'amorales','04/04/2017 23:39:32',NULL),(37,'amorales','04/04/2017 23:45:01',NULL),(38,'amorales','04/04/2017 23:48:00','04/04/2017 23:48:46'),(39,'amorales','05/04/2017 21:26:07','05/04/2017 21:26:34'),(40,'amorales','05/04/2017 21:39:11',NULL),(41,'amorales','05/04/2017 21:49:45','05/04/2017 21:49:50'),(42,'amorales','05/04/2017 21:51:27',NULL),(43,'amorales','05/04/2017 21:54:08',NULL),(44,'amorales','05/04/2017 21:54:53',NULL),(45,'amorales','05/04/2017 21:56:19',NULL),(46,'amorales','05/04/2017 22:04:00','05/04/2017 22:04:32'),(47,'amorales','05/04/2017 22:05:19','05/04/2017 22:06:33'),(48,'amorales','05/04/2017 22:13:44','05/04/2017 22:14:41'),(49,'amorales','05/04/2017 22:15:33',NULL),(50,'amorales','05/04/2017 22:20:27',NULL),(51,'amorales','05/04/2017 22:22:25','05/04/2017 22:22:52'),(52,'sakly','05/04/2017 22:27:00','05/04/2017 22:27:11'),(53,'amorales','05/04/2017 22:27:17','05/04/2017 22:27:53'),(54,'amorales','05/04/2017 22:29:28','05/04/2017 22:29:57'),(55,'amorales','06/04/2017 21:38:48','06/04/2017 21:40:05'),(56,'amorales','07/04/2017 09:03:58','07/04/2017 09:05:45'),(57,'amorales','10/04/2017 15:26:47','10/04/2017 15:26:51'),(58,'amorales','10/04/2017 15:41:04','10/04/2017 15:41:21'),(59,'amorales','10/04/2017 15:52:03','10/04/2017 15:53:27'),(60,'rfinol','10/04/2017 15:53:35','10/04/2017 15:53:39');
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_idCard` varchar(45) NOT NULL,
  `user_firstName` varchar(45) NOT NULL,
  `user_lastName` varchar(45) NOT NULL,
  `user_lastName2` varchar(45) DEFAULT NULL,
  `user_phone1` varchar(45) NOT NULL,
  `user_phone2` varchar(45) DEFAULT NULL,
  `user_address` varchar(100) DEFAULT NULL,
  `user_email` varchar(45) NOT NULL,
  `user_role` varchar(45) NOT NULL,
  `user_username` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `user_registrationDate` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'3333','ANTHONY','MORALES','SALAZAR','5555','','ADDRESS','MAIL','ADMIN','amorales','cxome','09/03/2017 11:29:19'),(4,'4444','STEVEN','AKLY','NOTARO','7665','','ADDRESS','MAIL','USER','sakly','ulkgc','09/03/2017 11:35:57'),(8,'5555','MARIA','ANGULO','','5674','','','MAIL','USER','mangulo','olnby','10/04/2017 15:52:44'),(9,'6666','RAUL','FINOL','','874343','','','MAIL','ADMIN','rfinol','tqiis','10/04/2017 15:53:12');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-10 15:55:19
