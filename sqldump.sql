--
-- Current Database: `Phonebook`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `Phonebook` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `Phonebook`;

--
-- Table structure for table `Locations`
--

DROP TABLE IF EXISTS `Locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Locations` (
  `id` int(11) NOT NULL,
  `street` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `zip` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Locations`
--

LOCK TABLES `Locations` WRITE;
/*!40000 ALTER TABLE `Locations` DISABLE KEYS */;
INSERT INTO `Locations` VALUES (1,'3302 Sweet Rd','Madison','Wisconsin',53704),(2,'3301 Portage Rd','Madison','Wisconsin',53704),(3,'333 web avn','Madison','Wisconsin',53704);
/*!40000 ALTER TABLE `Locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PhoneNumbers`
--

DROP TABLE IF EXISTS `PhoneNumbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PhoneNumbers` (
  `id` int(11) NOT NULL,
  `number` varchar(11) NOT NULL,
  `Users_id` int(11) NOT NULL,
  `PhoneType_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PhoneNumbers_PhoneType` (`PhoneType_id`),
  KEY `PhoneNumbers_Users` (`Users_id`),
  CONSTRAINT `PhoneNumbers_PhoneType` FOREIGN KEY (`PhoneType_id`) REFERENCES `PhoneType` (`id`),
  CONSTRAINT `PhoneNumbers_Users` FOREIGN KEY (`Users_id`) REFERENCES `Users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PhoneNumbers`
--

LOCK TABLES `PhoneNumbers` WRITE;
/*!40000 ALTER TABLE `PhoneNumbers` DISABLE KEYS */;
INSERT INTO `PhoneNumbers` VALUES (1,'6086289124',1,1),(2,'6083334568',2,1),(3,'6084445678',3,1),(4,'6085557895',4,2);
/*!40000 ALTER TABLE `PhoneNumbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PhoneType`
--

DROP TABLE IF EXISTS `PhoneType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PhoneType` (
  `id` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PhoneType`
--

LOCK TABLES `PhoneType` WRITE;
/*!40000 ALTER TABLE `PhoneType` DISABLE KEYS */;
INSERT INTO `PhoneType` VALUES (1,'Work'),(2,'Home');
/*!40000 ALTER TABLE `PhoneType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `id` int(11) NOT NULL,
  `role` varchar(30) NOT NULL,
  `Users_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Role_Users` (`Users_id`),
  CONSTRAINT `Role_Users` FOREIGN KEY (`Users_id`) REFERENCES `Users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `id` int(11) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `Locations_id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Users_Locations` (`Locations_id`),
  CONSTRAINT `Users_Locations` FOREIGN KEY (`Locations_id`) REFERENCES `Locations` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,'Aseng','Vue','Sweets8787',1,'asevue'),(2,'Robert','Curry','Rcurryburry123',2,'rcurry'),(3,'Steve','Winslow','SteSlow123',2,'Sslow'),(4,'Carrie','Barry','CBarns',3,'Cbarry');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

