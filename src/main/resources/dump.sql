 SET NAMES utf8 ;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cargo` (
  `cargo_id` int(5) NOT NULL AUTO_INCREMENT,
  `cargo_name` varchar(50) NOT NULL,
  `cargo_length` float(8,2) DEFAULT NULL,
  `cargo_width` float(8,2) DEFAULT NULL,
  `cargo_height` float(8,2) DEFAULT NULL,
  `cargo_weight` float(10,2) DEFAULT NULL,
  `cargo_dangerous` tinyint(4) DEFAULT NULL,
  `cargo_fragile` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`cargo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `cargo_owner`
--

DROP TABLE IF EXISTS `cargo_owner`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cargo_owner` (
  `cargo_owner_id` int(5) NOT NULL AUTO_INCREMENT,
  `cargo_owner_name` varchar(60) NOT NULL,
  `cargo_owner_desc` varchar(255) DEFAULT NULL,
  `cargo_owner_phone` varchar(20) DEFAULT NULL,
  `user_id` int(5) NOT NULL,
  PRIMARY KEY (`cargo_owner_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `cargo_owner_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cargo_owner`
--

LOCK TABLES `cargo_owner` WRITE;
INSERT INTO `cargo_owner` VALUES (1,'Furniture Planet','Сеть мебельных магазинов и магазинов стройматериалов','+375 17 277 86 86',1);
UNLOCK TABLES;

--
-- Table structure for table `carrier`
--

DROP TABLE IF EXISTS `carrier`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `carrier` (
  `carrier_id` int(5) NOT NULL AUTO_INCREMENT,
  `carrier_name` varchar(60) NOT NULL,
  `carrier_desc` varchar(255) DEFAULT NULL,
  `carrier_phone` varchar(20) DEFAULT NULL,
  `user_id` int(5) NOT NULL,
  PRIMARY KEY (`carrier_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `carrier_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `carrier`
--

LOCK TABLES `carrier` WRITE;
INSERT INTO `carrier` VALUES (1,'БелТранс','Перевозки по всей Беларуси','+375 17 223 23 23',3),(2,'Транспортик','Перевозки по всей Беларуси и странам СНГ','+375 17 266 26 36',2);
UNLOCK TABLES;

--
-- Table structure for table `delivery_method`
--

DROP TABLE IF EXISTS `delivery_method`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `delivery_method` (
  `delivery_method_id` int(5) NOT NULL AUTO_INCREMENT,
  `delivery_method_name` varchar(40) NOT NULL,
  `delivery_method_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`delivery_method_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `delivery_method`
--

LOCK TABLES `delivery_method` WRITE;
INSERT INTO `delivery_method` VALUES (1,'автотранспорт','перевозки грузовыми машинами'),(2,'воздушный транспорт','перевозки самолётами'),(3,'морской транспорт','перевозки короблями'),(4,'железнодорожный транспорт','перевозки поездами');
UNLOCK TABLES;

--
-- Table structure for table `locality`
--

DROP TABLE IF EXISTS `locality`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `locality` (
  `locality_id` int(5) NOT NULL AUTO_INCREMENT,
  `locality_name` varchar(50) NOT NULL,
  `country` varchar(30) NOT NULL,
  PRIMARY KEY (`locality_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `locality`
--

LOCK TABLES `locality` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rate` (
  `rate_id` int(5) NOT NULL AUTO_INCREMENT,
  `rate_price_per_kg` float(10,2) NOT NULL,
  `average_speed` float(6,2) NOT NULL,
  `carrier_id` int(5) NOT NULL,
  `delivery_method_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`rate_id`),
  KEY `carrier_id` (`carrier_id`),
  KEY `delivery_method_id` (`delivery_method_id`),
  CONSTRAINT `rate_ibfk_1` FOREIGN KEY (`carrier_id`) REFERENCES `carrier` (`carrier_id`),
  CONSTRAINT `rate_ibfk_2` FOREIGN KEY (`delivery_method_id`) REFERENCES `delivery_method` (`delivery_method_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rate`
--

LOCK TABLES `rate` WRITE;
INSERT INTO `rate` VALUES (1,4.00,65.90,1,1),(2,3.00,50.20,1,4),(3,4.70,70.50,2,1),(4,24.50,750.00,2,2),(5,3.10,53.70,2,4);
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `route` (
  `route_id` int(5) NOT NULL AUTO_INCREMENT,
  `departure_locality_id` int(5) NOT NULL,
  `destination_locality_id` int(5) NOT NULL,
  PRIMARY KEY (`route_id`),
  KEY `departure_locality_id` (`departure_locality_id`),
  KEY `destination_locality_id` (`destination_locality_id`),
  CONSTRAINT `route_ibfk_1` FOREIGN KEY (`departure_locality_id`) REFERENCES `locality` (`locality_id`),
  CONSTRAINT `route_ibfk_2` FOREIGN KEY (`destination_locality_id`) REFERENCES `locality` (`locality_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ticket` (
  `ticket_id` int(5) NOT NULL AUTO_INCREMENT,
  `cargo_owner_id` int(5) NOT NULL,
  `cargo_id` int(5) NOT NULL,
  `cargo_quantity` int(7) NOT NULL,
  `departure_date` datetime NOT NULL,
  `route_id` int(5) NOT NULL,
  `status` varchar(30) DEFAULT NULL,
  `date_of_creation` datetime NOT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `cargo_owner_id` (`cargo_owner_id`),
  KEY `cargo_id` (`cargo_id`),
  KEY `route_id` (`route_id`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`cargo_owner_id`) REFERENCES `cargo_owner` (`cargo_owner_id`),
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`cargo_id`) REFERENCES `cargo` (`cargo_id`),
  CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `transportation`
--

DROP TABLE IF EXISTS `transportation`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transportation` (
  `transportation_id` int(5) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(5) NOT NULL,
  `carrier_id` int(5) NOT NULL,
  `status` varchar(30) DEFAULT NULL,
  `destination_date` datetime NOT NULL,
  `total_price` float(10,2) NOT NULL,
  PRIMARY KEY (`transportation_id`),
  KEY `ticket_id` (`ticket_id`),
  KEY `carrier_id` (`carrier_id`),
  CONSTRAINT `transportation_ibfk_1` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`ticket_id`),
  CONSTRAINT `transportation_ibfk_2` FOREIGN KEY (`carrier_id`) REFERENCES `carrier` (`carrier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transportation`
--

LOCK TABLES `transportation` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `transportation_waypoint`
--

DROP TABLE IF EXISTS `transportation_waypoint`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transportation_waypoint` (
  `transportation_waypoint_id` int(5) NOT NULL AUTO_INCREMENT,
  `transportation_id` int(5) NOT NULL,
  `waypoint_id` int(5) NOT NULL,
  PRIMARY KEY (`transportation_waypoint_id`),
  KEY `transportation_id` (`transportation_id`),
  KEY `waypoint_id` (`waypoint_id`),
  CONSTRAINT `transportation_waypoint_ibfk_1` FOREIGN KEY (`transportation_id`) REFERENCES `transportation` (`transportation_id`),
  CONSTRAINT `transportation_waypoint_ibfk_2` FOREIGN KEY (`waypoint_id`) REFERENCES `waypoint` (`waypoint_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transportation_waypoint`
--

LOCK TABLES `transportation_waypoint` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(5) NOT NULL AUTO_INCREMENT,
  `user_login` varchar(25) NOT NULL,
  `user_password` varchar(25) NOT NULL,
  `user_email` varchar(25) NOT NULL,
  `user_role` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'owner','owner123','owner@mail.ru','2'),(2,'carrier','carrier','carrier@mail.ru','1'),(3,'BelTrans','transport111','belt@gmail.com','1');
UNLOCK TABLES;

--
-- Table structure for table `waypoint`
--

DROP TABLE IF EXISTS `waypoint`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `waypoint` (
  `waypoint_id` int(5) NOT NULL AUTO_INCREMENT,
  `route_id` int(5) NOT NULL,
  `rate_id` int(5) DEFAULT NULL,
  `from_locality_id` int(5) NOT NULL,
  `to_locality_id` int(5) NOT NULL,
  `backward` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`waypoint_id`),
  KEY `route_id` (`route_id`),
  KEY `from_locality_id` (`from_locality_id`),
  KEY `to_locality_id` (`to_locality_id`),
  KEY `rate_id` (`rate_id`),
  CONSTRAINT `waypoint_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`),
  CONSTRAINT `waypoint_ibfk_2` FOREIGN KEY (`from_locality_id`) REFERENCES `locality` (`locality_id`),
  CONSTRAINT `waypoint_ibfk_3` FOREIGN KEY (`to_locality_id`) REFERENCES `locality` (`locality_id`),
  CONSTRAINT `waypoint_ibfk_4` FOREIGN KEY (`rate_id`) REFERENCES `rate` (`rate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `waypoint`
--

LOCK TABLES `waypoint` WRITE;
UNLOCK TABLES;
