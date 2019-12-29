-- MySQL dump 10.13  Distrib 5.7.10, for osx10.9 (x86_64)
--
-- Host: localhost    Database: Fxdb
-- ------------------------------------------------------
-- Server version	5.7.10

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
  `room_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '客房编号/不显示',
  `room_type` char(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '客房类型',
  `room_price` int(11) DEFAULT NULL COMMENT '客房单价',
  `room_peple_id` char(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '客户编号',
  `room_in_date` datetime DEFAULT NULL COMMENT '入住日期',
  `room_card` char(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '折扣',
  `room_sex` char(5) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '总额',
  `room_peple_name` char(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '客户姓名',
  `room_id_number` int(11) DEFAULT NULL COMMENT '客房编号',
  `room_phone` char(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '客户联系电话',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_room`
--

LOCK TABLES `booking_room` WRITE;
/*!40000 ALTER TABLE `booking_room` DISABLE KEYS */;
INSERT INTO `booking_room` VALUES (15,'商务间',150,'31','2019-12-19 07:06:37','333333333333','男','张三',102,'187765323'),(16,'标准间',199,'1','2019-12-19 07:11:26','402556165156156165','男','李四',103,'18786565566');
/*!40000 ALTER TABLE `booking_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `client_name` char(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '姓名',
  `client_sex` char(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `client_native` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '籍贯',
  `client_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '客户的id',
  `client_phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '客户联系电话',
  `client_id_card` char(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '客户身份证',
  `client_id_number` char(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '作为逻辑主键',
  PRIMARY KEY (`client_id`),
  KEY `client_id_number` (`client_id_number`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('张三','男','广西',118,'187765323','333333333333','31'),('李四','男','广西',119,'18786565566','402556165156156165','1');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info_room`
--

DROP TABLE IF EXISTS `info_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `info_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房间信息id',
  `type` char(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '房间类型',
  `area` int(11) DEFAULT NULL COMMENT '房间面积',
  `iphone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '房间的电话',
  `ps` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '房间备注',
  `tv` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否有电视',
  `max_people` int(11) DEFAULT NULL COMMENT '额定人数',
  `max_bed` int(11) DEFAULT NULL COMMENT '床数',
  `rest` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否有卫生间',
  `air_conditioning` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否有空调',
  `id_number` int(11) DEFAULT NULL COMMENT '房间编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44030 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info_room`
--

LOCK TABLES `info_room` WRITE;
/*!40000 ALTER TABLE `info_room` DISABLE KEYS */;
INSERT INTO `info_room` VALUES (44027,'商务间',100,'077-3333','商务房','IPTV',2,2,'单间','无',102),(44028,'标准间',100,'0777-3333','标准间，双人床','IPTV',2,2,'单间','有',103),(44029,'组合套间',100,'0777-3265','组合套间','IPTV',6,3,'单间','有',104);
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
  `room_id_number` int(20) DEFAULT NULL,
  PRIMARY KEY (`room_id`) USING BTREE,
  KEY `room_id_number` (`room_id_number`)
) ENGINE=InnoDB AUTO_INCREMENT=44042 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standard_room`
--

LOCK TABLES `standard_room` WRITE;
/*!40000 ALTER TABLE `standard_room` DISABLE KEYS */;
INSERT INTO `standard_room` VALUES (44035,'商务间','三楼',150,'商务房',102),(44038,'标准间','二楼',199,'标准间，双人床',103),(44039,'单人间','一楼',100,'单人间',105),(44040,'标准间','一楼',199,'标准间，双人床',106),(44041,'组合套间','四楼',200,'组合套间',104);
/*!40000 ALTER TABLE `standard_room` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('e10adc3949ba59abbe56e057f20f883e','管理员',1,'20181004095','1','1','1','/png/屏幕快照 2019-11-23 18.40.07.png'),('e10adc3949ba59abbe56e057f20f883e','管理员',2,'admin','1','1','1','/png/128x128-ic_perm_identity_48px.png'),('e10adc3949ba59abbe56e057f20f883e','管理员',31,'1596863112','n','n','nn','/png/屏幕快照 2019-11-23 18.40.07.png'),('e10adc3949ba59abbe56e057f20f883e','用户',32,'123456','112','','121','/png/icons8-user_group_man_man.png');
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_verify`
--

LOCK TABLES `users_verify` WRITE;
/*!40000 ALTER TABLE `users_verify` DISABLE KEYS */;
INSERT INTO `users_verify` VALUES (1,'你的生日是?','您父亲的姓名是？','您的出生地是？'),(2,'你的生日是?','您父亲的姓名是？','您的出生地是？'),(31,'你的生日是?','您父亲的姓名是？','您的出生地是？'),(32,'你父母亲的姓名?','您父亲的姓名是？','您的出生地是？');
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

-- Dump completed on 2019-12-23 14:21:07
