-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: FXdb
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `booking_room`
--

DROP TABLE IF EXISTS `booking_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking_room` (
  `room_id` int(20) NOT NULL AUTO_INCREMENT,
  `room_type` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_price` int(11) DEFAULT NULL,
  `room_peple_id` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_in_date` datetime DEFAULT NULL,
  `room_discount` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_out_date` datetime DEFAULT NULL,
  `room_amout` int(20) DEFAULT NULL,
  `room_id_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_room`
--

LOCK TABLES `booking_room` WRITE;
/*!40000 ALTER TABLE `booking_room` DISABLE KEYS */;
INSERT INTO `booking_room` VALUES (1,'总统套房',1000,'100','2019-07-07 00:00:00','未知','2019-08-08 00:00:00',1000,101);
/*!40000 ALTER TABLE `booking_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `client_name` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `client_sex` char(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `client_native` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `client_id` int(20) NOT NULL,
  `client_phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `client_id_card` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('11','11','111',11,'11',NULL);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info_room`
--

DROP TABLE IF EXISTS `info_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `info_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(24) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `area` int(11) DEFAULT NULL,
  `iphone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ps` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tv` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `max_people` int(11) DEFAULT NULL,
  `max_bed` int(11) DEFAULT NULL,
  `rest` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `air_conditioning` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info_room`
--

LOCK TABLES `info_room` WRITE;
/*!40000 ALTER TABLE `info_room` DISABLE KEYS */;
INSERT INTO `info_room` VALUES (5,'n','1',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `info_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `standard_room`
--

DROP TABLE IF EXISTS `standard_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `standard_room` (
  `room_id` int(20) NOT NULL AUTO_INCREMENT,
  `room_type` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_floor` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_price` int(20) DEFAULT NULL,
  `room_remark` char(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_id_number` int(20) NOT NULL,
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standard_room`
--

LOCK TABLES `standard_room` WRITE;
/*!40000 ALTER TABLE `standard_room` DISABLE KEYS */;
INSERT INTO `standard_room` VALUES (1,'总统套房内设','100',1000,'这是顶级的总统套房',100);
/*!40000 ALTER TABLE `standard_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `room_type` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_area` int(20) DEFAULT NULL,
  `room_rated_people` int(20) DEFAULT NULL,
  `room_rated_bed` int(20) DEFAULT NULL,
  `room_air_conditioning` char(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_tv` char(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_rest` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room_phone` char(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `roon_ps` char(50) COLLATE utf8_unicode_ci DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES ('hh',200,22,2,'1','2','jhkjk','hkl','231315');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `password` char(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '123456',
  `userType` char(3) COLLATE utf8_unicode_ci NOT NULL DEFAULT '用户',
  `UUID` int(11) NOT NULL AUTO_INCREMENT,
  `id` char(15) COLLATE utf8_unicode_ci NOT NULL,
  `question_two` char(255) COLLATE utf8_unicode_ci NOT NULL,
  `question_three` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `question_one` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `picture` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('feng','用户',1,'20181004095','','','',NULL),('feng','管理员',2,'admin','','','',NULL),('123','用户',3,'sss','问题2','问题3','问题1',NULL),('123456','用户',4,'2','222','22','22',NULL),('123456','用户',5,'s','sss','s','s',NULL),('123456','用户',6,'ss','s','ss','ss',NULL),('123','用户',7,'sss','问题2','问题3','问题1',NULL),('feng','用户',9,'feng','张','1425368490','封',NULL),('213123','用户',10,'3213','0-30333333','2323333333333','23123',NULL),('213123','用户',11,'feng','0-30333333','2323333333333','23123',NULL),('213123','用户',12,'zhang','0-30333333','2323333333333','23123',NULL),('213123','用户',13,'nmb','0-30333333','2323333333333','23123',NULL),('213123','用户',14,'nmb','0-30333333','2323333333333','23123',NULL),('213123','用户',15,'nmb','0-30333333','2323333333333','23123',NULL),('23','用户',16,'2','2312','31','31',NULL),('23','用户',17,'6','2312','31','31',NULL),('23','用户',18,'6','2312','31','31',NULL),('23','用户',19,'6','2312','31','31',NULL),('23','用户',20,'6','2312','31','31',NULL),('23','用户',21,'6','2312','31','31',NULL),('1231','用户',22,'2123','231231','321','23123',NULL),('1231','用户',23,'2123','231231','321','23123',NULL),('2212','用户',24,'2222','2222','222','ss',NULL),('2212','用户',25,'2222','2222','222','ss',NULL),('1132','用户',26,'113','s','s','s',NULL),('1111','用户',27,'1111','1111','111','111',NULL),('12346','用户',28,'123456','222','22','222',NULL),('12346','用户',29,'123456','222','22','222',NULL),('12346','用户',30,'123456','222','22','222',NULL),('feng','管理员',31,'1596863112','n','n','nn',NULL),('feng','用户',32,'14253684920','sss','ss','sss',NULL),('feng','用户',33,'1425368490','buzhidao','buzhidao','buzhidao','/png/timg.jpeg'),('fengge123','用户',34,'18776530219','李邵东','1425368490','南宁学院','/png/屏幕快照 2019-11-23 18.40.07.png'),('bbbb','用户',35,'nmbbbbb','22','222','222','/png/icons8-user_group_man_man.png');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_verify`
--

DROP TABLE IF EXISTS `users_verify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_verify` (
  `UUID` int(11) NOT NULL AUTO_INCREMENT,
  `select_one` char(255) COLLATE utf8_unicode_ci NOT NULL,
  `select_two` char(255) COLLATE utf8_unicode_ci NOT NULL,
  `select_three` char(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`UUID`),
  CONSTRAINT `fk_verify_referenced_users` FOREIGN KEY (`UUID`) REFERENCES `users` (`UUID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_verify`
--

LOCK TABLES `users_verify` WRITE;
/*!40000 ALTER TABLE `users_verify` DISABLE KEYS */;
INSERT INTO `users_verify` VALUES (1,'buzhidao','buzhidao','buzhidao'),(2,'buzhidao','buzhidao','buzhidao'),(3,'1','2','3'),(4,'1','2','3'),(5,'1','2','3'),(6,'bizhidao','buzhidao','buzhidao'),(7,'1','2','3'),(9,'你父母亲的姓名?','您父亲的姓名是？','您的学号（或工号）是？'),(10,'你的生日?','您配偶的姓名是？','您的出生地是？'),(11,'你的生日?','您配偶的姓名是？','您的出生地是？'),(12,'你的生日?','您配偶的姓名是？','您的出生地是？'),(13,'你的生日?','您配偶的姓名是？','您的出生地是？'),(14,'你的生日?','您配偶的姓名是？','您的出生地是？'),(15,'你的生日?','您配偶的姓名是？','您的出生地是？'),(16,'你的生日?','您配偶的姓名是？','您的小学校名是？'),(17,'你的生日?','您配偶的姓名是？','您的小学校名是？'),(18,'你的生日?','您配偶的姓名是？','您的小学校名是？'),(19,'你的生日?','您配偶的姓名是？','您的小学校名是？'),(20,'你的生日?','您配偶的姓名是？','您的小学校名是？'),(21,'你的生日?','您配偶的姓名是？','您的小学校名是？'),(22,'你喜欢看的电影?','您父亲的姓名是？','您的出生地是？'),(23,'你喜欢看的电影?','您父亲的姓名是？','您的出生地是？'),(24,'你毕业于那个初中?','您父亲的姓名是？','您的小学校名是？'),(25,'你毕业于那个初中?','您父亲的姓名是？','您的小学校名是？'),(26,'你的生日?','您父亲的姓名是？','您的出生地是？'),(27,'你毕业于那个初中?','您配偶的姓名是？','您的小学校名是？'),(28,'你的生日?','您配偶的姓名是？','您的小学校名是？'),(29,'你的生日?','您配偶的姓名是？','您的小学校名是？'),(30,'你的生日?','您配偶的姓名是？','您的小学校名是？'),(31,'你的生日?','您父亲的姓名是？','您的出生地是？'),(32,'你毕业于那个初中?','您配偶的姓名是？','您的小学校名是？'),(33,'你的生日?','您配偶的姓名是？','您的小学校名是？'),(34,'你毕业于那个初中?','您高中班主任的名字是？','您的学号（或工号）是？'),(35,'你毕业于那个初中?','您配偶的姓名是？','您的小学校名是？');
/*!40000 ALTER TABLE `users_verify` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-09 19:32:42
