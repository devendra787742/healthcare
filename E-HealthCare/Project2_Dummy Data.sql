-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: project2
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_47bvqemyk6vlm0w7crc3opdd4` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES (1,'corbin.johnson@yahoo','female','Ephraim','autem',NULL),(2,'fbechtelar@yahoo.com','male','Ralph','ullam',NULL),(3,'runolfsdottir.hiram@','female','Luther','rerum',NULL),(4,'kbruen@gmail.com','female','Eve','$2a$12$dfVGeRAFpM7KSJZU26Ecd..nfpO./SupuqSNui60yolUZhXUbzsdK',NULL),(5,'jany61@hotmail.com','male','Dell','ut',NULL);
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `online` bit(1) NOT NULL,
  `payment_status` bit(1) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `doctor_id` bigint NOT NULL,
  `patient_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmujeo4tymoo98cmf7uj3vsv76` (`doctor_id`),
  KEY `FK8exap5wmg8kmb1g1rx3by21yt` (`patient_id`),
  CONSTRAINT `FK8exap5wmg8kmb1g1rx3by21yt` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKmujeo4tymoo98cmf7uj3vsv76` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (1,'2022-09-27',_binary '',_binary '\0','Cancelled','17:30:00',1,33),(2,'2023-09-02',_binary '\0',_binary '\0','Pending','16:58:38',9,35),(3,'2021-09-19',_binary '\0',_binary '\0','Pending','15:56:44',7,16),(4,'2022-04-23',_binary '\0',_binary '','Confirmed','11:50:01',4,24),(5,'2022-06-02',_binary '',_binary '','Confirmed','10:28:19',12,2),(6,'2023-05-11',_binary '',_binary '','Cancelled','02:31:21',7,30),(7,'2022-09-19',_binary '',_binary '\0','Cancelled','05:54:43',2,32),(8,'2022-04-18',_binary '',_binary '','Attended','19:36:24',10,40),(9,'2023-05-25',_binary '',_binary '\0','Pending','12:17:22',9,32),(10,'2021-11-03',_binary '',_binary '\0','Cancelled','09:21:58',4,19),(11,'2022-03-14',_binary '\0',_binary '\0','Cancelled','15:11:33',11,10),(12,'2023-02-16',_binary '\0',_binary '','Pending','02:11:44',11,31),(13,'2023-07-05',_binary '\0',_binary '\0','Pending','08:20:48',4,38),(14,'2022-09-19',_binary '',_binary '','Pending','09:28:52',5,1),(15,'2023-07-08',_binary '',_binary '','Pending','18:49:09',12,27),(16,'2023-03-05',_binary '',_binary '\0','Cancelled','16:03:36',14,24),(17,'2022-09-27',_binary '\0',_binary '','Cancelled','11:00:00',1,3),(18,'2023-05-31',_binary '\0',_binary '','Attended','15:53:16',10,47),(19,'2021-10-31',_binary '\0',_binary '','Cancelled','15:31:08',15,34),(20,'2023-05-13',_binary '\0',_binary '','Attended','02:04:57',11,47),(21,'2022-06-09',_binary '',_binary '','Attended','17:23:26',12,2),(22,'2022-05-10',_binary '',_binary '','Pending','11:59:08',7,48),(23,'2021-12-10',_binary '',_binary '','Pending','09:41:42',11,17),(24,'2023-05-14',_binary '\0',_binary '','Confirmed','05:35:23',3,28),(25,'2023-03-24',_binary '\0',_binary '\0','Pending','22:28:36',12,4),(26,'2023-08-19',_binary '\0',_binary '\0','Cancelled','16:11:40',4,48),(27,'2022-10-31',_binary '\0',_binary '\0','Pending','01:46:14',8,28),(28,'2022-09-27',_binary '',_binary '\0','Confirmed','15:30:00',1,42),(29,'2022-09-19',_binary '\0',_binary '\0','Confirmed','09:35:25',5,18),(30,'2023-07-25',_binary '',_binary '','Cancelled','13:54:09',6,39),(31,'2022-02-26',_binary '\0',_binary '','Pending','11:10:27',3,11),(32,'2023-09-02',_binary '',_binary '\0','Pending','16:48:16',10,45),(33,'2022-06-23',_binary '',_binary '','Pending','08:00:05',14,15),(34,'2021-09-29',_binary '\0',_binary '','Confirmed','10:16:57',8,7),(35,'2021-10-25',_binary '',_binary '','Attended','04:01:31',15,3),(36,'2023-01-11',_binary '\0',_binary '\0','Cancelled','20:19:50',12,42),(37,'2022-05-15',_binary '',_binary '','Pending','03:58:19',15,2),(38,'2023-01-02',_binary '',_binary '\0','Cancelled','09:19:36',3,21),(39,'2022-09-17',_binary '',_binary '','Confirmed','19:09:32',5,11),(40,'2023-03-04',_binary '',_binary '\0','Pending','02:00:40',13,48),(41,'2022-09-25',_binary '\0',_binary '','Confirmed','02:37:10',15,45),(42,'2022-11-29',_binary '',_binary '\0','Confirmed','06:55:50',10,43),(43,'2023-09-03',_binary '',_binary '\0','Confirmed','10:07:43',8,35),(44,'2023-05-26',_binary '\0',_binary '\0','Confirmed','19:31:08',12,34),(45,'2023-02-19',_binary '',_binary '','Cancelled','21:37:44',10,40),(46,'2023-05-01',_binary '\0',_binary '\0','Pending','15:45:35',10,44),(47,'2023-06-27',_binary '\0',_binary '\0','Cancelled','00:48:32',15,7),(48,'2023-03-19',_binary '\0',_binary '\0','Confirmed','05:07:10',5,22),(49,'2022-10-29',_binary '',_binary '','Cancelled','01:51:44',15,10),(50,'2022-09-18',_binary '\0',_binary '\0','Confirmed','02:48:28',5,31),(51,'2023-06-07',_binary '\0',_binary '\0','Confirmed','09:46:17',5,5),(52,'2021-10-28',_binary '',_binary '','Cancelled','09:49:55',4,45),(53,'2023-06-19',_binary '\0',_binary '\0','Attended','20:29:52',10,36),(54,'2022-03-30',_binary '',_binary '','Cancelled','01:36:09',9,7),(55,'2023-02-16',_binary '',_binary '\0','Confirmed','05:06:22',5,35),(56,'2023-03-15',_binary '\0',_binary '','Confirmed','03:06:10',14,41),(57,'2023-08-03',_binary '\0',_binary '','Attended','09:09:48',5,27),(58,'2022-03-28',_binary '',_binary '','Confirmed','05:56:14',14,1),(59,'2022-12-12',_binary '\0',_binary '','Cancelled','10:26:52',8,44),(60,'2022-02-22',_binary '\0',_binary '','Pending','19:18:29',11,47),(61,'2022-12-04',_binary '\0',_binary '\0','Pending','08:35:03',3,21),(62,'2022-09-27',_binary '\0',_binary '','Cancelled','14:00:00',1,47),(63,'2022-09-28',_binary '',_binary '','Cancelled','17:30:00',1,38),(64,'2023-08-15',_binary '',_binary '\0','Pending','01:06:51',4,13),(65,'2023-08-13',_binary '',_binary '\0','Pending','00:16:11',3,31),(66,'2021-12-19',_binary '\0',_binary '','Cancelled','23:53:40',15,29),(67,'2022-09-28',_binary '\0',_binary '\0','Cancelled','15:30:00',1,28),(68,'2022-06-12',_binary '',_binary '','Pending','00:46:34',8,31),(69,'2023-02-26',_binary '',_binary '\0','Confirmed','00:17:02',14,15),(70,'2022-07-20',_binary '',_binary '\0','Cancelled','13:06:36',2,10),(71,'2022-03-28',_binary '',_binary '','Confirmed','09:26:26',14,47),(72,'2023-01-11',_binary '\0',_binary '\0','Attended','10:59:15',10,13),(73,'2021-11-18',_binary '',_binary '','Pending','06:45:00',5,35),(74,'2022-01-21',_binary '\0',_binary '','Confirmed','13:27:37',11,49),(75,'2022-04-01',_binary '\0',_binary '\0','Pending','15:44:06',4,14),(76,'2023-05-20',_binary '\0',_binary '\0','Attended','04:19:28',5,42),(77,'2021-11-27',_binary '',_binary '\0','Pending','17:10:10',15,47),(78,'2022-02-15',_binary '\0',_binary '','Pending','06:45:48',6,25),(79,'2022-09-28',_binary '\0',_binary '\0','Attended','16:30:00',1,17),(80,'2023-01-03',_binary '',_binary '\0','Confirmed','08:21:21',13,47),(81,'2022-01-18',_binary '',_binary '','Attended','17:54:27',11,3),(82,'2022-03-18',_binary '\0',_binary '\0','Attended','22:23:37',5,23),(83,'2022-10-03',_binary '',_binary '\0','Cancelled','07:03:19',5,3),(84,'2022-09-15',_binary '\0',_binary '','Attended','23:18:10',13,42),(85,'2023-06-19',_binary '',_binary '','Confirmed','18:49:31',11,13),(86,'2021-11-15',_binary '',_binary '','Confirmed','08:49:37',11,23),(87,'2023-05-08',_binary '\0',_binary '','Confirmed','21:43:17',4,28),(88,'2023-08-02',_binary '',_binary '\0','Pending','01:51:59',4,6),(89,'2023-07-09',_binary '\0',_binary '\0','Pending','22:00:44',11,34),(90,'2022-03-09',_binary '\0',_binary '\0','Confirmed','09:09:38',10,37),(91,'2022-09-12',_binary '',_binary '','Pending','09:43:11',6,11),(92,'2021-10-22',_binary '',_binary '','Confirmed','13:34:13',6,42),(93,'2022-06-23',_binary '\0',_binary '\0','Confirmed','23:55:08',10,12),(94,'2022-09-28',_binary '',_binary '\0','Cancelled','18:30:00',1,43),(95,'2021-11-15',_binary '',_binary '','Attended','06:46:52',14,42),(96,'2023-05-05',_binary '\0',_binary '','Cancelled','01:00:57',6,48),(97,'2021-10-12',_binary '',_binary '','Pending','16:20:38',7,33),(98,'2022-09-28',_binary '',_binary '\0','Cancelled','19:30:00',1,12),(99,'2023-07-26',_binary '\0',_binary '\0','Confirmed','22:22:32',10,24),(100,'2022-10-06',_binary '',_binary '\0','Pending','00:01:35',11,19),(101,'2022-09-28',_binary '\0',_binary '\0','Cancelled','14:00:00',21,1),(102,'2022-09-20',_binary '',_binary '\0','Cancelled','11:00:00',2,53),(103,'2022-09-22',_binary '\0',_binary '\0','Cancelled','13:30:00',13,56),(104,'2022-09-23',_binary '\0',_binary '\0','Pending','11:00:00',7,2),(105,'2022-09-30',_binary '\0',_binary '\0','Cancelled','15:00:00',15,56),(106,'2022-09-30',_binary '\0',_binary '\0','Confirmed','15:00:00',15,2),(107,'2022-09-28',_binary '',_binary '\0','Attended','09:00:00',1,2),(108,'2022-09-23',_binary '',_binary '\0','Pending','10:00:00',14,2),(109,'2022-09-21',_binary '',_binary '\0','Pending','08:30:00',11,2),(110,'2022-09-22',_binary '',_binary '',NULL,'13:00:00',13,2),(111,'2022-09-23',_binary '\0',_binary '\0','Pending','10:00:00',2,2),(112,'2022-09-24',_binary '\0',_binary '\0','Pending','11:30:00',13,2),(113,'2022-09-27',_binary '\0',_binary '\0','Pending','10:00:00',11,56),(114,'2022-09-24',_binary '\0',_binary '\0','Pending','10:00:00',15,56),(115,'2022-09-28',_binary '',_binary '','Confirmed','15:00:00',1,1),(116,'2022-09-30',_binary '',_binary '','Pending','12:00:00',2,10),(117,'2022-09-30',_binary '',_binary '','Cancelled','15:00:00',1,10),(118,'2022-09-28',_binary '\0',_binary '\0','Cancelled','11:00:00',1,10),(119,'2022-09-27',_binary '\0',_binary '\0','Confirmed','18:30:00',1,10),(120,'2022-09-27',_binary '\0',_binary '\0','Cancelled','18:00:00',1,10),(121,'2022-09-27',_binary '\0',_binary '\0','Cancelled','19:30:00',1,10),(122,'2022-09-28',_binary '\0',_binary '\0','Cancelled','12:00:00',1,10),(123,'2022-09-27',_binary '\0',_binary '\0','Cancelled','19:30:00',1,10),(124,'2022-09-29',_binary '',_binary '','Pending','13:00:00',11,10),(125,'2022-09-29',_binary '\0',_binary '\0','Confirmed','14:00:00',1,10),(126,'2022-09-30',_binary '',_binary '','Pending','15:30:00',39,10);
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `bill_number` bigint NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `patient_id` bigint NOT NULL,
  PRIMARY KEY (`bill_number`),
  KEY `FKiklkhnj1odoll0m9otela7gb9` (`patient_id`),
  CONSTRAINT `FKiklkhnj1odoll0m9otela7gb9` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `department_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Ut perferendis aut dolores et explicabo voluptatem dicta.','Orthopaedics'),(2,'Soluta earum tempore et dolorem tempore.','Anesthetics'),(3,'Accusantium quia molestiae recusandae qui ut qui.','Cardiology'),(4,'Voluptas soluta voluptas excepturi porro natus quas doloribus.','Psychiatry'),(5,'Corporis sit accusantium sint voluptatem qui tempore sequi ut.','Oncology'),(6,'Eum nisi eum in est.','Pediatrics'),(7,'Dolorem iusto quos molestiae nihil dolore et magnam.','Neurology'),(8,'Vero provident minus in qui ad.','Neonatal Unit'),(9,'doctor of nails','Qwerty'),(26,'It offers primary care services (including a continence program, Memory and Alzheimer\'s Treatment Center and metabolic bone center), an Elder House Call Program and a full range of inpatient care services','Geriatrics'),(27,NULL,NULL),(28,NULL,NULL),(29,'sabfj fkdgithot vfdghoijhtrdp','Neonaty');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `fees` double NOT NULL,
  `is_validated` bit(1) NOT NULL,
  `is_working` bit(1) NOT NULL,
  `speciality` varchar(255) DEFAULT NULL,
  `department_id` bigint NOT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_caifv0va46t2mu85cg5afmayf` (`email`),
  KEY `FKl2mro81neln9topymd898urh1` (`department_id`),
  CONSTRAINT `FKl2mro81neln9topymd898urh1` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,'uheidenreich@gmail.c','female','Katlynn','$2a$12$bB6zSs1ok.e5BBHd2NUKP.tr3NTphfgzArjBh3LBJjMYoLZXPgWUG','Consequatur sed rerum vero est.',1347,_binary '',_binary '','Tenetur dignissimos repellendus et totam. Occaecati eligendi in exercitationem veritatis sunt.',3,NULL),(2,'lsawayn@yahoo.com','female','Michale','$2a$12$EOL53vBEAl/gFw/d.H6BCeVOE/WlDgpeCfGVWMD1BOu913nbQAbbK','Soluta eos similique libero enim nisi magni.',1148,_binary '',_binary '','Sequi doloremque ab accusamus animi molestias iste velit. Provident et repellendus nobis perferendis velit quo.',5,NULL),(3,'melisa28@hotmail.com','female','Gwen','corporis','Aut vel suscipit sed.',790,_binary '',_binary '\0','Aut voluptatem itaque dolores necessitatibus. Sed non repudiandae est id est dolorem ut. Dolorem voluptatem quas dicta.',2,NULL),(4,'maximillian60@yahoo.','female','Crystel','aut','Cum quae explicabo iusto ullam ut quaerat.',756,_binary '\0',_binary '','Dicta nihil asperiores et est a vel. Deserunt autem ullam officia. Corrupti eligendi reprehenderit doloremque nisi consequatur beatae.',2,NULL),(5,'beatty.teresa@yahoo.','male','Kristina','$2a$10$skjOP4xpazSpBGhxNRp.ZuqbjoMHoKMhOoxdSUUtAYN6WJKi/eDvq','Incidunt mollitia assumenda ea sit quae.',1100,_binary '\0',_binary '','Et officiis perferendis ea et nam repellendus neque. Qui laudantium nesciunt minima et perferendis aut sed. Dicta iste quam non architecto.',4,NULL),(6,'bennie12@hotmail.com','male','Norris','explicabo','Omnis libero animi voluptatem natus.',1090,_binary '\0',_binary '','Velit nulla cupiditate quo consequatur. Voluptates quidem ut voluptates et laborum. Quo minus quae consectetur sed dolore.',5,NULL),(7,'edison53@hotmail.com','male','Alivia','ab','Aliquid itaque libero et eum nihil.',816,_binary '',_binary '','Quia quae facilis nulla a. Commodi dignissimos exercitationem exercitationem voluptas esse in. Voluptatem architecto perspiciatis aut voluptatem voluptatum cumque rerum sit.',7,NULL),(8,'kayla.medhurst@hotma','female','Eden','voluptatum','Quia porro perspiciatis aspernatur.',926,_binary '\0',_binary '','Sunt est enim voluptatem hic eaque necessitatibus fuga. Aut molestiae voluptas aliquam quasi est voluptas. Iure exercitationem eaque dolor expedita harum laudantium.',8,NULL),(9,'bh@gmail.com','male','bhai','$2a$10$9nj7Gbrh8dXBGY9w71d43OuvVfodiJ7gPNNE48tfA85Px9pOkPrze','itus',500,_binary '',_binary '','abc',3,NULL),(10,'kendra.lehner@hotmai','female','Damon','officia','Harum doloribus voluptatibus dolores.',792,_binary '\0',_binary '\0','Molestias blanditiis quidem at aut facilis illum. Qui sit non dolor consequuntur dolores minus.',8,NULL),(11,'agustina.hauck@yahoo','male','Delphine','assumenda','Et dolorum rerum aut minus.',1005,_binary '',_binary '','Autem non magnam tempora officia expedita eum odit. Cumque in nihil qui accusantium est ad delectus nesciunt.',1,NULL),(12,'moen.scottie@hotmail','male','Terrill','quia','Ipsa ipsam doloremque omnis.',831,_binary '',_binary '','Aut voluptatibus ea veritatis eum dolores. Corporis ab doloremque qui quibusdam.',8,NULL),(13,'raphaelle03@gmail.co','male','Raina','laudantium','Debitis alias quia eligendi.',793,_binary '',_binary '','Quis corrupti hic porro ad minus aspernatur eum sunt. Nemo asperiores repellendus rerum voluptas veniam nam.',3,NULL),(14,'wsmitham@gmail.com','male','Betty','minus','Non tempora ad commodi omnis in non.',1044,_binary '',_binary '','Tempora quis dolor culpa distinctio. Est impedit id explicabo aut eum.',6,NULL),(15,'ephraim.powlowski@gm','male','Jadon','$2a$12$ULSrB.enS9aMnwFKLmEsnOivUCHBtnXI.zrVoJQaTjGCfRtKqejtq','Eligendi sint molestiae est est totam eveniet.',1447,_binary '',_binary '','Qui minima deleniti delectus ratione ex. Iste nostrum dolore sequi quibusdam. Tempora voluptatum ut et.',5,NULL),(17,'kgf@gmail.com','male','Garuda','minus','Non tempora ad commodi omnis in non.',1044,_binary '',_binary '\0','Tempora quis dolor culpa distinctio. Est impedit id explicabo aut eum.',3,NULL),(18,'raina@gmail.co','male','Raina','laudantium','Debitis alias quia eligendi.',793,_binary '',_binary '','Quis corrupti hic porro ad minus aspernatur eum sunt. Nemo asperiores repellendus rerum voluptas veniam nam.',7,NULL),(19,'drcool@gmail.com','male','abcd','dr ','asdasdasd',800,_binary '',_binary '\0','asdfasd',3,NULL),(20,'adtle@gmail.com','male','Qwe','aaa','dsgsdfg',900,_binary '\0',_binary '','dsfsd',5,NULL),(21,'asd@gmail.com','male','asddfs','123','dkgsn',700,_binary '',_binary '','dsfms',6,NULL),(22,'ae@gmail.com','male','sdf','123435','dsfokt',1200,_binary '',_binary '\0','xcgkvdfl',1,NULL),(24,'asdfgh@gmail.com','female','Anand','$2a$10$SsbtQ3RJfxbd89TgJiRZauAKZF7LqwINsvJCQNQ7Bwl0kPCgFGNai','sdkfj ,rtiowj',1400,_binary '',_binary '\0','dsgf-wer',3,NULL),(25,'chaitali@gmail.com','female','Chaitali','$2a$10$U25isCY8.hDTy7hV6tle/eGGbw2SjniAuyEuYwVo.lSIMYHe7c7q2','mbbs',1200,_binary '',_binary '','dsfg dsgfs sdfdf',6,NULL),(33,'dinu12@gmail.com','male','Dinesh','$2a$10$MXjq8fSqnEl/Tob3Ezjlte4v9EwuwCzg8UmVtzRIfi5tZDD8vctdO','bhms',600,_binary '\0',_binary '','surgery',7,NULL),(35,'dinu1@gmail.com',NULL,'Dinesh','$2a$10$DMvthAQQGBGRZ9jp8fGGnuF0hFXSq.3DYW4x4SW5XmP/Ea1teYiVe','bhms',600,_binary '',_binary '','surgery',6,NULL),(37,'ambesh@gmail.com','male','Ambesh Raturi','$2a$10$e1rz6j36AADluAoE7s.3xuF.8wwNl51GcewvOK0yDM6k.4k2hV/kG','MBBS, MD, MS',1500,_binary '\0',_binary '','Knee replacement surgery',1,NULL),(38,'anant@gmail.com','male','Anant','$2a$10$J/tB4Y58oQew.5Fv1h3tDecDdb2NB1Rp2oFlOhVCTDpOppkI8zUAK','mbbs',1500,_binary '',_binary '','aaa',1,NULL),(39,'manbag1219@gmail.com','female','Manisha Bagul','$2a$10$/Yn91un0gma3weISf23UZe4AHKoG1RvHz9tSyqYrBwgyZrcnHyAJq','MBBS, MD',1300,_binary '',_binary '','Clinical Neurophysiology',7,NULL);
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `rating` double NOT NULL,
  `doctor_id` bigint NOT NULL,
  `patient_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkrlnib2ygk75b4a1d8m8s66pr` (`doctor_id`),
  KEY `FKphlqohiy7u0u2vjccah5fshh6` (`patient_id`),
  CONSTRAINT `FKkrlnib2ygk75b4a1d8m8s66pr` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  CONSTRAINT `FKphlqohiy7u0u2vjccah5fshh6` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (51,'Qui aut similique voluptatibus recusandae possimus rerum. Est odit velit dolorum. Inventore iusto dolores cumque quam id. Voluptas saepe possimus vel ut quod dolor.',1,6,10),(52,'Itaque est sint magni sint molestias. Non alias reprehenderit cupiditate nam. Maxime ab quia consequatur reprehenderit. Voluptatibus vel corrupti modi nesciunt incidunt sint sequi.',9,5,36),(53,'Velit veniam aut voluptates quis et aut. Libero vero repellendus nostrum laboriosam omnis. Ut iste dolor facere et voluptatum quibusdam.',6,4,25),(54,'Labore repudiandae magni odit in. Aspernatur eveniet maxime dolor laboriosam et distinctio pariatur. Amet nulla facilis voluptates officiis et et.',3,1,11),(55,'Eligendi odit dolor ipsum aliquam. Rerum eos eos pariatur magni. Fugit possimus placeat laudantium in cumque velit dolor eveniet. Pariatur reprehenderit dolorem dolor voluptatem sed.',8,4,7),(56,'Ipsam eius tempora distinctio tempora officia dolorem officiis. Itaque animi excepturi aliquid ipsa corporis dolores. Quisquam omnis occaecati quasi enim expedita qui fugiat. Soluta ipsam provident aut iste ipsum.',9,7,25),(57,'Enim eum consectetur inventore aut fugit nisi. Ducimus vel est odio vitae cumque. Dolorem pariatur numquam natus ex qui nesciunt.',0,6,1),(58,'Esse delectus minima hic nobis est et soluta. Iusto porro aut doloremque perferendis enim corrupti. Qui aperiam sit facere earum autem numquam et.',3,7,42),(59,'Aut aut possimus enim consequuntur ut voluptatem et. Iure iste eveniet qui rerum est est veniam nostrum. At ad quas voluptate unde praesentium qui. Omnis quia voluptatem doloremque itaque dolore aut vitae. Corporis laboriosam ut exercitationem odit.',9,3,50),(60,'Nesciunt natus reprehenderit suscipit inventore. Temporibus nulla quia et libero. Libero ipsa vero est quos aut. Ducimus est ducimus facere.',3,6,12),(61,'Asperiores recusandae aperiam non perferendis dolorum. Repudiandae dignissimos dignissimos illo ut saepe. Omnis facilis consequuntur nam numquam autem dicta.',3,4,17),(62,'Voluptatum non sit eveniet eum. Et fuga laborum animi ut. Autem nulla incidunt aut nisi dolorem. Veritatis ut fuga cum voluptatem provident.',9,5,41),(63,'Non optio eius eaque expedita aut velit praesentium. Ipsum architecto aliquid non doloremque error voluptatem. Quasi consequatur nesciunt est delectus.',2,6,32),(64,'Odio quisquam dignissimos saepe minus occaecati molestias eos. Autem ducimus consequatur adipisci blanditiis cupiditate rerum nobis. Corrupti accusamus qui qui non rerum ut omnis.',9,7,3),(65,'Quasi quam amet error ad. Laudantium repellendus ut veniam molestiae fugit doloremque. Maxime quia neque repellendus eos eos qui et. Et eius ut veniam.',3,6,25),(66,'Et est et laboriosam. Velit nemo itaque cumque voluptatem nostrum repudiandae. Reiciendis sed quo placeat qui laudantium est. Voluptatem itaque ullam beatae modi voluptatem voluptatem expedita.',7,2,23),(67,'Ducimus corporis praesentium eum doloribus. Eligendi eos labore pariatur dolorem nesciunt porro necessitatibus.',8,5,48),(68,'Asperiores architecto voluptate quo commodi beatae consequatur omnis qui. Reiciendis ab corporis aut recusandae. Rerum praesentium velit non id. Nostrum est ut et nihil.',5,4,13),(69,'Et omnis iusto necessitatibus sint omnis molestiae nostrum quas. Enim impedit dolorum eum sit accusamus in. Quia incidunt ut nesciunt corporis alias. Quisquam earum ipsum aut ipsa.',3,6,21),(70,'Recusandae earum fuga saepe quidem. Aut quisquam magni est et suscipit sed qui. Tenetur id voluptas asperiores ipsam est sunt tempore.',4,3,14),(71,'Voluptatem rerum qui eligendi perspiciatis ex. Quo enim omnis placeat necessitatibus. Est eius qui ea.',9,2,13),(72,'Sed asperiores assumenda est natus illo fugit qui. Ut distinctio consequatur ut qui aut. Voluptatem veniam et esse modi accusamus quia qui.',8,6,33),(73,'Atque voluptate repudiandae voluptatem dignissimos quis dolorem. Voluptate magnam assumenda in libero.',1,7,46),(74,'Repudiandae ut magni nobis eius quis minima quis. Sit dolor voluptatum sit. Voluptas dolorum cupiditate delectus et consequatur.',1,5,8),(76,'Laboriosam quisquam vero excepturi dicta atque exercitationem reiciendis. Voluptas velit voluptatem ducimus voluptatem. Et maiores dignissimos accusamus ut accusamus labore quibusdam.',4,1,37),(77,'Consequatur autem sequi blanditiis omnis dolorum amet eius. Et rerum corporis expedita reprehenderit. Saepe exercitationem laborum fugit unde sit. Voluptate consequatur quia sint a.',8,1,3),(78,'Illum optio et assumenda sequi molestiae. Harum qui non rerum est. Pariatur tempore sit possimus dicta. Assumenda occaecati non dolores et expedita.',9,2,45),(79,'Aliquid sapiente inventore voluptatum eius magni consectetur. Aut saepe quas qui sint provident quisquam eos sit. Numquam commodi rem dolorem deleniti non minus. Animi sunt ipsam adipisci.',5,1,1),(80,'Mollitia iste est aperiam placeat recusandae. In consequuntur neque sed est beatae minima tempora. Placeat fugiat sed exercitationem aut. Omnis et facilis illum eum doloribus.',7,7,15),(81,'Velit dicta eum amet deleniti occaecati error. Qui optio nesciunt non accusamus id id. Dolorem et alias adipisci. Nulla ad similique iste modi. Voluptas quae unde provident ipsum quasi.',5,6,44),(82,'Dolorem cum et mollitia aliquam. Quam qui quia et. In eum eos et atque et corporis quisquam. Aut sequi voluptatem ad deleniti itaque sunt et.',8,1,22),(83,'Vel quaerat et dolore molestiae ipsam. Eos dolor error commodi id vitae autem. Ab qui aut tempore consequatur vero.',9,7,11),(84,'Et et distinctio reiciendis. Sint iure facilis neque libero deserunt occaecati. Maiores doloribus non rem. At doloremque autem omnis ut quia qui nostrum maiores. Animi et sed sint ab qui exercitationem dolor.',0,3,28),(85,'Reiciendis quas tempora nam rerum voluptatum voluptas est. Dolorum tenetur quod vel incidunt. Et et provident est reprehenderit voluptates corrupti. Sed blanditiis alias minima in sequi.',6,4,5),(86,'Sunt inventore ullam eveniet accusamus quaerat natus asperiores. Aut sunt voluptates architecto et dignissimos. Aut repudiandae aliquid culpa.',7,2,27),(87,'Quisquam est ut voluptatum rerum dignissimos iusto impedit aut. A aliquam id autem atque dolor sit voluptatem magnam. Ut ut magni laboriosam sed voluptatem molestias est.',5,2,18),(88,'Molestiae a velit et et. Commodi quibusdam soluta non dolorem. Libero modi pariatur culpa praesentium dignissimos. Modi rem vero officia aperiam nesciunt dolore.',0,5,14),(89,'Atque dolor quia minima sint voluptas consectetur maiores. Et qui non odio expedita veritatis expedita. Doloribus explicabo ab et ea nisi facere repellat. Id facere vel aliquam magni nulla.',1,7,48),(90,'Quis vero nesciunt sint qui dolorum laborum dolor. Et qui eum perspiciatis. Non quo provident occaecati facere quidem atque eos.',3,7,12),(91,'Blanditiis dolor veritatis unde voluptatem sit ipsa nobis. Et ut inventore quidem autem. Vel eligendi eum et sint facere ut.',1,1,8),(92,'Libero non asperiores odio harum. A culpa omnis omnis consectetur aperiam facilis dolor. Enim corrupti ut dolor aliquid autem amet corrupti. Sit id maxime quis alias odit corrupti. Magnam ad quos possimus pariatur necessitatibus.',1,3,1),(94,'Consectetur dolores voluptas occaecati accusamus sequi nihil aut. Mollitia laboriosam adipisci porro ut dicta necessitatibus fuga. Ipsa ad voluptatibus vel ratione iste quia ut consectetur. Qui ut qui labore ut.',6,3,27),(95,'Quisquam ut nemo adipisci aliquam earum et. Laborum minima unde repellat nemo. Libero itaque provident odio id aut ut quisquam.',8,2,11),(96,'Saepe dolor nostrum voluptate hic excepturi. Harum nobis est eaque praesentium hic. Ut aliquid consequatur delectus sunt repudiandae in soluta.',9,5,45),(97,'Ullam eos rerum sunt est ut earum consequatur fugit. Et asperiores iste error consectetur. Sit sit voluptas dolorum fugit iste. Expedita tenetur velit eligendi rerum sit est.',4,2,43),(98,'Quia sunt totam rerum eaque ipsa. Eaque est facere vitae dolor eum est doloribus. Eaque reprehenderit sunt cupiditate.',2,5,37),(99,'Est non odit accusamus dolorum. Qui eum facere aut. Aliquam voluptatum ea dicta eius perferendis sit. Cum non et quisquam ipsa suscipit et. Nihil repellat quibusdam eligendi laboriosam.',1,3,17),(100,'Sapiente in aut eos reprehenderit optio impedit autem omnis. Impedit expedita nobis quam impedit quidem sapiente.',6,3,38),(101,'xczkjvnodfsijoidfsv dklgsjsrogko',5,2,1),(102,'dlsfer dsflgser',5,6,2),(103,'he cured my cancer',8,2,10);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_test`
--

DROP TABLE IF EXISTS `lab_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab_test` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `test_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_test`
--

LOCK TABLES `lab_test` WRITE;
/*!40000 ALTER TABLE `lab_test` DISABLE KEYS */;
INSERT INTO `lab_test` VALUES (1,'doppler ultrasound'),(2,'plain chest X-ray'),(3,'ECG'),(4,'voluptates'),(5,'assumenda'),(6,'possimus'),(7,'aspernatur'),(8,'maxime'),(9,'id'),(10,'saepe');
/*!40000 ALTER TABLE `lab_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `dob` date NOT NULL,
  `height` double NOT NULL,
  `weight` double NOT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_a370hmxgv0l5c9panryr1ji7d` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,'abcd@gmail.com','male','Peyton','$2a$12$dWIEWjC/grXPuTvlgrGWW.igMSOoeDGc8ToYcKymjC7Y1cWW2DymC','abcd','O_POSITIVE','1993-02-07',56,156,NULL),(2,'ehealthcarehospital@gmail.com','male','Valentin','$2a$12$PJbG5Oj7Y7L6JRn5w690a.mN/0iCxPiz5vIBAUp1GFCBnyzoaGYOq','Leffler Mountain','A_NEGATIVE','1999-11-09',0,0,NULL),(3,'broderick.bradtke@gm','female','Corbin','$2a$10$glfFuB1k/zViB/XDXE98GuTQww.eTBoWC.6ZfFokduxij7s9DIHCW','corbin','A_POSITIVE','1977-06-24',156,56,'doctors-1.jpg'),(4,'abradtke@gmail.com','male','Deshaun','non','Bessie Mall','A_POSITIVE','1965-09-16',0,0,NULL),(5,'ccartwright@hotmail.','male','Junior','quia','Buford Passage','A_POSITIVE','1956-12-26',0,0,NULL),(6,'friesen.audrey@yahoo','male','Lenny','rerum','Amir Locks','A_POSITIVE','1986-03-21',0,0,NULL),(7,'cswift@hotmail.com','female','Madyson','quasi','Fritsch Lane','B_POSITIVE','1980-11-20',0,0,NULL),(8,'onie88@hotmail.com','female','Kayden','fugit','Stokes Loaf','B_POSITIVE','2001-12-05',0,0,NULL),(9,'amara.langosh@gmail.','female','Elliot','autem','Kenny Streets','B_POSITIVE','2012-12-20',0,0,NULL),(10,'shivamraturi23@gmail.com','male','Shivam Patil','$2a$10$9EOfLcyponctT6ELi82b3e9IALgDmHU9LVd7XoP.5UpUIAlyMqzZ2','23, Ganesh Colony, Shiv Nagar, Jalgaon, Maharashtra','AB_POSITIVE','1995-06-17',160,65,'testimonials-5.jpg'),(11,'ankunding.cassandre@','male','Logan','aliquam','Fisher Vista','B_NEGATIVE','2004-09-06',0,0,NULL),(12,'ubeahan@yahoo.com','male','Dee','voluptate','O\'Connell Highway','A_POSITIVE','1977-09-12',0,0,NULL),(13,'trycia.jenkins@gmail','female','Christopher','recusandae','Ernestine Centers','B_POSITIVE','1987-05-31',0,0,NULL),(14,'ustoltenberg@hotmail','female','Ole','corrupti','Windler Landing','B_NEGATIVE','1989-11-17',0,0,NULL),(15,'laverna45@yahoo.com','female','Geovanni','porro','Kiehn Row','O_NEGATIVE','1963-04-19',0,0,NULL),(16,'rrutherford@hotmail.','male','Jasmin','labore','Annamarie Pike','B_NEGATIVE','2016-06-28',0,0,NULL),(17,'lonzo07@gmail.com','male','Brody','quaerat','Haley Coves','B_POSITIVE','1956-08-14',0,0,NULL),(18,'schroeder.willard@ya','female','Keshawn','eos','Terrance Mall','B_NEGATIVE','1995-01-10',0,0,NULL),(19,'elmore.satterfield@g','female','Lucas','occaecati','McDermott Fields','B_NEGATIVE','1963-05-29',0,0,NULL),(20,'lhilll@yahoo.com','male','Gideon','ea','Breitenberg Tunnel','O_NEGATIVE','2019-10-14',0,0,NULL),(21,'weber.damian@hotmail','female','Chauncey','quisquam','Zoila Brooks','AB_POSITIVE','1944-11-22',0,0,NULL),(22,'uhirthe@gmail.com','female','Darwin','architecto','Beer Mountains','AB_POSITIVE','1962-05-09',0,0,NULL),(23,'gavin50@gmail.com','male','Ward','dignissimos','Louvenia Tunnel','O_POSITIVE','2017-06-22',0,0,NULL),(24,'carleton.cremin@gmai','male','Murphy','provident','Kemmer Ville','AB_POSITIVE','2022-02-10',0,0,NULL),(25,'alessia44@gmail.com','male','Rafael','sed','Eliane Gateway','B_POSITIVE','1956-09-14',0,0,NULL),(26,'lesch.dayne@hotmail.','male','Leonel','et','Theodora Parks','AB_POSITIVE','1995-03-26',0,0,NULL),(27,'effie.price@hotmail.','female','Aaron','suscipit','Veum Lane','O_NEGATIVE','2008-11-22',0,0,NULL),(28,'tbuckridge@yahoo.com','male','Anthony','iste','Keira Centers','AB_NEGATIVE','2004-01-02',0,0,NULL),(29,'nicolas.myrtice@gmai','female','Adonis','ratione','Thompson Prairie','AB_NEGATIVE','1975-09-23',0,0,NULL),(30,'catalina.schimmel@ho','male','Nathan','et','Danial Club','A_POSITIVE','1946-10-21',0,0,NULL),(31,'elyssa56@yahoo.com','male','Ephraim','dolores','Moses Radial','AB_POSITIVE','1996-06-25',0,0,NULL),(32,'rudolph83@gmail.com','female','Norbert','at','Marley Mission','A_NEGATIVE','1972-09-25',0,0,NULL),(33,'kanderson@gmail.com','female','Pete','maiores','Murphy Ports','B_POSITIVE','1961-10-24',0,0,NULL),(34,'waelchi.michelle@hot','female','Ned','aut','Mitchell Estate','B_POSITIVE','1972-07-29',0,0,NULL),(35,'uthiel@hotmail.com','male','Bell','ullam','Ford Brook','B_POSITIVE','2012-05-19',0,0,NULL),(36,'askiles@hotmail.com','female','Uriah','esse','Aurelie Circle','AB_NEGATIVE','2003-12-22',0,0,NULL),(37,'will.hiram@hotmail.c','female','Broderick','molestiae','Elyssa Ports','A_POSITIVE','2014-06-10',0,0,NULL),(38,'ambeshraturidac@gmail.com','female','Wilton','est','Yoshiko Isle','B_NEGATIVE','1996-02-28',0,0,NULL),(39,'marlon.gleason@gmail','female','Joey','mollitia','Harber Underpass','AB_POSITIVE','1950-03-19',0,0,NULL),(40,'vbrown@gmail.com','female','Andres','quis','Marvin Orchard','O_NEGATIVE','2011-12-04',0,0,NULL),(41,'matilde08@gmail.com','female','Oran','officiis','Margie Forges','B_NEGATIVE','1992-03-05',0,0,NULL),(42,'bafocehaq@rungel.net','male','Robbie','et','Francisca Port','O_POSITIVE','1994-08-20',0,0,NULL),(43,'qroberts@yahoo.com','male','Ansel','consequuntur','Juvenal Meadow','B_POSITIVE','1947-11-03',0,0,NULL),(44,'bode.yasmeen@hotmail','female','Bailey','a','Freeman Loop','O_POSITIVE','1998-09-10',0,0,NULL),(45,'dereck63@yahoo.com','female','Sid','nobis','Ray Harbors','AB_NEGATIVE','1946-08-08',0,0,NULL),(46,'russ75@hotmail.com','female','Domenico','perspiciatis','Lora Camp','A_POSITIVE','1946-10-25',0,0,NULL),(47,'vszklzy555@tormails.com','male','Kale','aut','Smith Hill','A_POSITIVE','1972-08-25',0,0,NULL),(48,'sbartell@hotmail.com','male','Reece','odio','Cristobal Ranch','O_POSITIVE','1961-01-17',0,0,NULL),(49,'wfadel@hotmail.com','male','Emiliano','est','Garret Street','AB_NEGATIVE','2006-07-05',0,0,NULL),(50,'gwendolyn10@yahoo.co','male','Coy','dolor','Cindy Hill','O_POSITIVE','2011-11-25',0,0,NULL),(53,'mayuri@gmail.com','female','Mayuri','$2a$10$J9GUepEVNY7V6bpWd6S8UOZoduGivlXgZhNLQF2Kk0b3bRbkfljhG','xkcv dsrf,sd dfsgvkmfgv','A_NEGATIVE','2022-09-16',100,25,'gallery-3.jpg'),(56,'mayuri123@gmail.com','male','Qwerty','$2a$10$n0c/7uvDaZFoHOg5bwezo.jlLQLOcjv28INtIEqOGAyWKJHiLxcpC','zdsfkmseo dslkfmg','AB_POSITIVE','2022-09-17',120,20,'gallery-5.jpg'),(59,'xyz@gmail.com','female','xyz','$2a$10$XAMqkkeM3SN9/L4NE7mpuOFMrFhznjx5PwGKdN/P.Kqywz.5uSFzC','qwertuiop asd','AB_POSITIVE','2017-06-08',170,65,'testimonials-3.jpg'),(61,'atharva@gmail.com','other','athava','$2a$12$U5ar.WZBRVCoCM/WBTi07.PEqYRGr9ov8faqW/xNNpYRxy3fw3ZL2','Jammu & Kashmir','A_NEGATIVE','2022-09-27',50,3,'testimonials-1.jpg'),(62,'manass@gmail.com',NULL,'Manas Shastri','$2a$10$7/tU4lf.Ru8xe6t8McBwpOMcEuxpg8A189Ffizep/B9Ibg1Wv6EzO','23, Dashrath Nagar, Ayodhya Lane, Gwalior, Madhya Pradesh-474003','B_POSITIVE','2008-06-27',157,59,'testimonials-5.jpg'),(63,'anant12345@gmail.com',NULL,'Anant','$2a$10$SNdqIG5j.tI5LCZtDHsRwukg4PQvKA4KPYDfFahU9aZLURu/ZIk9u','dsjaf dskfjsoire fdskgjsoti',NULL,'2022-09-29',39,59,'testimonials-4.jpg'),(64,'kbruen@gmail.com',NULL,'Anant','$2a$10$O1HJ//Sc9h9RZUU1afzhdeOdmTInGlJmeo1X9YXl1WYXtSTt.ht7u','26, sdfjni, ewlrjwo',NULL,'2022-09-29',29,83,'testimonials-1.jpg'),(65,'hsbfkskdv@sda.com',NULL,'ab','$2a$10$PAbJehGEiGoMEpxQ0Dob5eUYrzmyfOtdEXmAHqJPpqNqAT6H7i94G','dfserlg ds;fl,d;l,gs',NULL,'2022-09-09',54,29,'testimonials-2.jpg'),(67,'hsbfkskdvads@sda.com','other','acdxfsd','$2a$10$Rw/1opkgbSCVY6HRTYv50e7oafYwXf.C8CB1jISzj6wJR.nFloQeG','dxzfs dfsggdf sadgfsd','A_NEGATIVE','2022-09-14',54,33,'testimonials-4.jpg');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatment`
--

DROP TABLE IF EXISTS `treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `medicines` varchar(255) DEFAULT NULL,
  `symptoms` varchar(255) NOT NULL,
  `treatment_date` date DEFAULT NULL,
  `doctor_id` bigint NOT NULL,
  `patient_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsi61v4743s4ecygr5ps9y1tx0` (`doctor_id`),
  KEY `FKbjc3c609dcqb8v7dx1r0g8fq7` (`patient_id`),
  CONSTRAINT `FKbjc3c609dcqb8v7dx1r0g8fq7` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `FKsi61v4743s4ecygr5ps9y1tx0` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment`
--

LOCK TABLES `treatment` WRITE;
/*!40000 ALTER TABLE `treatment` DISABLE KEYS */;
INSERT INTO `treatment` VALUES (1,'laboriosam','Iure non eius eligendi suscipit dolorum.','2023-06-18',6,41),(2,'qui','Voluptatem dolorem eum voluptatibus.','2023-03-21',4,7),(3,'rerum','Pariatur incidunt perspiciatis ad et consectetur repellat.','2021-12-31',4,49),(4,'aspernatur','Molestias quam aut corporis aut.','2022-08-09',1,40),(5,'optio','In ex sint quia et aut.','2023-03-28',3,17),(6,'perspiciatis','Et est ut et.','2021-09-11',2,28),(7,'ex','Nam minima quia quis quod iure provident.','2022-09-21',3,43),(8,'iusto','Accusamus totam quod reprehenderit.','2022-01-12',6,28),(9,'sequi','Iure nostrum ea nam eos quia nihil.','2022-02-08',2,19),(10,'libero','Consequatur ullam expedita totam.','2022-12-21',7,34),(11,'eos','Ipsam voluptates reprehenderit deserunt dolor et vitae.','2021-09-23',3,22),(12,'provident','Ut voluptatem nemo iste aut perferendis.','2022-10-03',6,42),(13,'architecto','Nam dolorem est quaerat ut voluptatem.','2022-10-21',3,47),(14,'et','Ea impedit vitae animi voluptatem dolore.','2023-08-11',7,4),(15,'qui','Reprehenderit minus rerum alias aut fugiat.','2022-04-01',3,46),(16,'ad','Ex et est molestiae.','2022-10-26',7,32),(17,'illo','Natus sint fuga nam ut architecto.','2022-03-03',5,13),(18,'odit','Aliquam laborum ea asperiores.','2022-04-28',1,42),(19,'vel','Ut eaque porro et eos temporibus nulla.','2023-05-14',5,22),(20,'cupiditate','Corrupti voluptatem praesentium odit quas.','2023-05-28',7,24),(21,'voluptate','Qui ea ratione explicabo est pariatur.','2023-06-30',6,28),(22,'quae','Nam perspiciatis atque quisquam tenetur.','2022-01-01',6,12),(23,'sint','Sed omnis qui incidunt inventore atque fugit.','2023-01-09',2,3),(24,'magni','Qui vel ipsum maxime.','2022-08-14',2,38),(25,'sed','Itaque unde ea et sed consequatur.','2022-01-10',6,11),(26,'voluptas','Qui ab quae debitis ab.','2022-08-24',7,15),(27,'aperiam','Iure accusantium impedit ut nulla.','2022-11-22',5,18),(28,'quae','Inventore quidem aut qui.','2023-04-19',3,49),(29,'quam','Vel itaque molestias ratione voluptas maiores magnam dolorum.','2023-08-20',4,33),(30,'doloremque','Beatae eos autem dolores.','2022-02-21',7,34),(31,'eum','Veniam possimus voluptatem ipsa voluptas doloribus aut.','2021-11-20',2,20),(32,'qui','Voluptas corporis iusto saepe maiores eius eveniet.','2023-05-20',6,19),(33,'et','Recusandae ducimus non officia fugit accusamus.','2022-02-24',5,37),(34,'voluptatem','Error ab molestias odit provident.','2023-02-16',2,45),(35,'et','Perferendis provident fugit eius.','2022-11-25',2,40),(36,'facere','Molestias eum reprehenderit optio.','2022-01-16',5,21),(37,'quidem','Eum consequatur velit omnis maiores quia.','2022-06-17',6,40),(38,'doloribus','Perspiciatis rerum culpa perferendis omnis.','2023-08-16',3,43),(39,'et','Deserunt reprehenderit vel excepturi ducimus.','2023-06-30',3,3),(40,'illum','Hic vitae consequatur deleniti voluptatum.','2022-12-03',2,37),(41,'velit','Molestiae facilis dignissimos sapiente rerum.','2023-06-28',1,12),(42,'et','Accusantium nihil in ipsa possimus velit.','2022-12-27',2,5),(43,'dolorem','Iste id vitae et esse unde.','2022-10-27',3,6),(44,'a','Minima dolores odio rerum distinctio aliquid commodi.','2023-06-11',2,6),(45,'officia','Velit autem animi modi aut.','2023-03-05',7,45),(46,'quod','Quia odit voluptate debitis.','2023-04-16',2,20),(47,'unde','Autem ipsa quis minus deserunt est magnam.','2022-07-26',2,1),(48,'qui','Maiores enim voluptates excepturi pariatur sunt.','2023-03-26',1,22),(49,'aut','Repudiandae omnis blanditiis iusto velit minima nihil.','2022-04-18',6,5),(50,'veritatis','Explicabo ipsa ea nostrum in.','2022-05-21',1,18),(51,'qui','Laborum quisquam enim corporis eos et.','2021-10-27',7,7),(52,'est','Vitae commodi autem qui debitis et ut.','2023-03-05',6,14),(53,'ab','Consequatur tempora quis quia.','2022-02-01',2,10),(54,'explicabo','Fuga est sequi sed velit.','2021-12-23',5,19),(55,'similique','Voluptatem minima consequatur magni.','2022-12-02',4,32),(56,'sint','Ab in omnis non omnis in sapiente.','2022-07-14',2,50),(57,'soluta','Dolor et laborum laudantium quis aspernatur.','2022-10-11',4,16),(58,'expedita','Asperiores perferendis et cupiditate repellendus facilis.','2023-03-15',5,9),(59,'et','Non ut eveniet iste reiciendis non.','2023-07-09',3,12),(60,'neque','Cumque accusamus rerum repellat voluptate neque.','2022-07-31',7,40),(61,'blanditiis','Et architecto quia itaque nemo quos laborum tenetur.','2023-04-30',3,31),(62,'reiciendis','Quia laborum qui voluptate qui nihil.','2022-02-08',2,2),(63,'explicabo','Autem omnis et qui ipsum minima.','2021-12-08',4,20),(64,'dolorum','Quasi est sint culpa.','2022-08-03',1,33),(65,'eum','Necessitatibus dolores et ad.','2023-03-07',6,7),(66,'ea','Voluptate molestiae saepe et voluptas.','2021-10-06',5,39),(67,'impedit','Totam rem sunt autem quasi aut.','2022-03-17',5,39),(68,'placeat','Dolorum voluptatem explicabo necessitatibus.','2021-10-18',7,40),(69,'eveniet','Sapiente fugit fugiat ut earum reprehenderit facilis.','2023-05-29',1,1),(70,'quaerat','Molestias occaecati nihil inventore.','2023-01-05',3,18),(71,'quod','Quam cum velit consequatur saepe maiores voluptatem.','2021-10-06',7,43),(72,'dolore','Aut aut fugiat debitis id.','2022-11-15',5,21),(73,'excepturi','Explicabo voluptas ducimus quos quo inventore.','2023-04-15',3,21),(74,'distinctio','Cumque dolores velit impedit voluptatum.','2023-05-19',5,43),(75,'eum','Quia possimus dolor provident rerum ut.','2023-05-15',6,2),(76,'quod','Et aut beatae qui voluptas voluptas.','2022-12-18',3,6),(77,'impedit','Nam ut et animi.','2022-03-05',4,46),(78,'reiciendis','Quos expedita aut perferendis recusandae.','2023-05-31',3,3),(79,'alias','Vel quod aspernatur et doloremque.','2021-11-21',6,1),(80,'magni','Minima dolor quia nostrum voluptatibus cumque.','2022-01-15',6,26),(81,'eos','Dolorem officia vero debitis vel.','2022-02-23',4,4),(82,'vitae','Tempora aut excepturi ut vitae molestiae illum.','2023-01-27',3,32),(83,'ea','Illo quia reiciendis omnis fugit.','2023-06-21',3,1),(84,'vero','Natus occaecati voluptatem et omnis.','2023-08-19',2,5),(85,'porro','Dolorem quasi est quaerat.','2023-05-30',4,16),(86,'deserunt','Consequatur consequatur ut itaque id.','2023-03-19',5,9),(87,'ut','Quasi quae qui esse et est quos.','2022-06-13',5,3),(88,'ut','Id expedita molestias accusamus qui iste.','2023-08-26',2,41),(89,'vero','Excepturi occaecati sint quisquam totam repellendus quis sed.','2022-08-12',5,12),(90,'ipsa','Ex ullam dolorem veritatis laborum.','2023-09-03',6,45),(91,'id','Voluptate architecto sed sed.','2022-06-08',3,9),(92,'ipsa','Saepe animi sunt qui distinctio dolorem.','2021-10-03',3,41),(93,'quos','Laboriosam eos voluptas qui atque.','2023-08-23',7,7),(94,'optio','Est ullam rem eos et.','2023-03-21',4,37),(95,'et','Quis asperiores fugiat sequi accusamus quos.','2022-01-12',1,28),(96,'sit','Illo hic rerum fuga eum esse.','2021-10-19',3,37),(97,'fugiat','Id maiores ducimus facere voluptate.','2021-12-17',2,37),(98,'quis','Quisquam debitis molestiae nam.','2023-07-08',7,40),(99,'dignissimos','Recusandae esse quas excepturi placeat quia.','2023-01-02',2,27),(100,'nisi','Et ea qui iure.','2021-12-13',4,2),(101,'xmfnskfk, sdkfje','sdkfksa dfgslkrpogk','2022-09-17',5,18),(102,'xmfnskfk, sdkfje','dsfjkas','2022-09-17',5,11),(103,'zxc','xzvcz','2022-09-17',5,11),(104,'sweet','abcd','2022-09-17',5,11),(105,'asdfghk','abqwerty','2022-09-17',5,11),(106,'gggggggggggggggggg','qqqqqqqqqqqqqqqqq','2022-09-17',5,11),(107,'d;flgkdsfmgkmlskd','xzkdfnskdf','2022-09-18',5,31),(108,'wryjwryjwryj','dkfjsidsjf dfogskodfskg','2022-09-18',5,31),(109,'pudinhara, churan','upset stomach, dysentry','2022-09-19',2,32),(110,'sdf dskfjwroe ','sdf, dsfkmkre dsfnk','2022-09-19',2,32),(111,'wryjwryjwryj','sdjfhaks dsfsad','2022-09-25',15,45),(112,'Paracetamol','cough, cold','2022-09-27',1,47),(113,'dfs dsg','safaer dsgrt','2022-09-27',1,10);
/*!40000 ALTER TABLE `treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatment_lab`
--

DROP TABLE IF EXISTS `treatment_lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment_lab` (
  `treatment_id` bigint NOT NULL,
  `lab_id` bigint NOT NULL,
  KEY `FKbi4u8ck2scmfg8t134bdwucnd` (`lab_id`),
  KEY `FKq16fhmfekx5043t5v7kjjkmqv` (`treatment_id`),
  CONSTRAINT `FKbi4u8ck2scmfg8t134bdwucnd` FOREIGN KEY (`lab_id`) REFERENCES `lab_test` (`id`),
  CONSTRAINT `FKq16fhmfekx5043t5v7kjjkmqv` FOREIGN KEY (`treatment_id`) REFERENCES `treatment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment_lab`
--

LOCK TABLES `treatment_lab` WRITE;
/*!40000 ALTER TABLE `treatment_lab` DISABLE KEYS */;
INSERT INTO `treatment_lab` VALUES (67,9),(84,3),(65,7),(30,1),(6,7),(99,4),(89,1),(10,6),(100,2),(97,6),(81,2),(26,8),(71,3),(19,6),(2,7),(8,3),(19,1),(58,10),(65,2),(20,9),(61,1),(47,5),(100,6),(47,2),(26,1),(83,3),(14,9),(27,3),(22,6),(73,7),(93,4),(38,7),(81,8),(50,7),(92,5),(49,5),(3,5),(1,7),(66,1),(52,4),(17,10),(32,8),(36,6),(59,5),(7,8),(49,4),(81,1),(52,5),(32,4),(72,10),(59,4),(93,8),(66,10),(43,1),(6,9),(83,8),(35,4),(8,1),(6,3),(50,5),(67,9),(100,7),(46,2),(27,7),(54,4),(84,1),(14,9),(15,1),(98,8),(75,9),(34,2),(34,2),(5,6),(76,4),(64,4),(35,1),(27,4),(21,10),(21,9),(65,1),(26,1),(10,1),(50,5),(1,10),(83,4),(19,6),(4,6),(38,2),(61,8),(25,5),(31,10),(20,10),(84,1),(34,7),(3,2),(93,1),(84,10),(22,1),(77,9),(52,1),(101,1),(101,4),(103,2),(104,2),(104,6),(105,2),(105,3),(105,1),(105,4),(106,3),(106,4),(107,4),(107,6),(108,5),(109,2),(109,5),(110,4),(110,3),(111,3),(111,5),(111,4),(112,2),(112,5),(113,4),(113,2);
/*!40000 ALTER TABLE `treatment_lab` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-28 11:39:28
