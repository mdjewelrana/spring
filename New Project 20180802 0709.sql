-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema book_store
--

CREATE DATABASE IF NOT EXISTS book_store;
USE book_store;

--
-- Definition of table `author`
--

DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `auth_id` int(10) unsigned NOT NULL auto_increment,
  `auth_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `author`
--

/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` (`auth_id`,`auth_name`) VALUES 
 (1,'abid'),
 (2,'jewel'),
 (3,'reajul');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;


--
-- Definition of table `book_list`
--

DROP TABLE IF EXISTS `book_list`;
CREATE TABLE `book_list` (
  `book_id` int(10) unsigned NOT NULL auto_increment,
  `cat_id` int(10) unsigned NOT NULL,
  `sub_cat_id` int(10) unsigned NOT NULL,
  `auth_id` int(10) unsigned NOT NULL,
  `pub_id` int(10) unsigned NOT NULL,
  `book_title` varchar(45) NOT NULL,
  `book_price` varchar(45) NOT NULL,
  `book_discount` varchar(45) NOT NULL,
  `book_url` varchar(45) NOT NULL,
  `book_status` varchar(45) NOT NULL,
  PRIMARY KEY  (`book_id`),
  KEY `FK_book_list_1` (`cat_id`),
  KEY `FK_book_list_2` (`sub_cat_id`),
  KEY `FK_book_list_3` (`auth_id`),
  KEY `FK_book_list_4` (`pub_id`),
  CONSTRAINT `FK_book_list_1` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`),
  CONSTRAINT `FK_book_list_2` FOREIGN KEY (`sub_cat_id`) REFERENCES `sub_category` (`sub_cat_id`),
  CONSTRAINT `FK_book_list_3` FOREIGN KEY (`auth_id`) REFERENCES `author` (`auth_id`),
  CONSTRAINT `FK_book_list_4` FOREIGN KEY (`pub_id`) REFERENCES `publisher` (`pub_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_list`
--

/*!40000 ALTER TABLE `book_list` DISABLE KEYS */;
INSERT INTO `book_list` (`book_id`,`cat_id`,`sub_cat_id`,`auth_id`,`pub_id`,`book_title`,`book_price`,`book_discount`,`book_url`,`book_status`) VALUES 
 (1,1,1,1,1,'motion','200','10','78967ooiuui','good'),
 (3,2,5,1,3,'little kids','50','5','565khjghf','good'),
 (4,7,1,2,3,'Motion analysis','200','10','78967ooiuui','good');
/*!40000 ALTER TABLE `book_list` ENABLE KEYS */;


--
-- Definition of table `book_read`
--

DROP TABLE IF EXISTS `book_read`;
CREATE TABLE `book_read` (
  `book_read_id` int(10) unsigned NOT NULL auto_increment,
  `book_nam` varchar(45) NOT NULL,
  `book_pdf` varchar(45) NOT NULL,
  PRIMARY KEY  (`book_read_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_read`
--

/*!40000 ALTER TABLE `book_read` DISABLE KEYS */;
INSERT INTO `book_read` (`book_read_id`,`book_nam`,`book_pdf`) VALUES 
 (2,'drama','yut'),
 (3,'Poum','ffddgd');
/*!40000 ALTER TABLE `book_read` ENABLE KEYS */;


--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cat_id` int(10) unsigned NOT NULL auto_increment,
  `cat_name` varchar(45) NOT NULL,
  `cat_desc` varchar(45) NOT NULL,
  PRIMARY KEY  (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`cat_id`,`cat_name`,`cat_desc`) VALUES 
 (1,'Science','500 are availables'),
 (2,'Drama','500 are availables'),
 (3,'Islamic','200 are availables'),
 (4,'Poem','500 are availables'),
 (5,'History','500 are availables'),
 (6,'Medical','500 are availables'),
 (7,'Fiction','500 are availables'),
 (8,'Children','500 are availables'),
 (9,'Romantic','500 are availables');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `image`
--

DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `image_id` int(10) unsigned NOT NULL auto_increment,
  `book_id` int(10) unsigned NOT NULL,
  `image_name` varchar(45) NOT NULL,
  `image` varchar(45) NOT NULL,
  PRIMARY KEY  (`image_id`),
  KEY `FK_image_1` (`book_id`),
  CONSTRAINT `FK_image_1` FOREIGN KEY (`book_id`) REFERENCES `book_list` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `image`
--

/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` (`image_id`,`book_id`,`image_name`,`image`) VALUES 
 (2,1,'uieiutee','eteterter');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;


--
-- Definition of table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(10) unsigned NOT NULL auto_increment,
  `user_id` int(10) unsigned NOT NULL,
  `order_qty` int(10) unsigned NOT NULL,
  `order_date` date NOT NULL,
  `order_status` varchar(45) NOT NULL,
  `book_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`order_id`),
  KEY `FK_order_1` (`user_id`),
  KEY `FK_order_book` (`book_id`),
  CONSTRAINT `FK_order_book` FOREIGN KEY (`book_id`) REFERENCES `book_list` (`book_id`),
  CONSTRAINT `FK_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order`
--

/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`order_id`,`user_id`,`order_qty`,`order_date`,`order_status`,`book_id`) VALUES 
 (1,1,58,'2018-08-15','5',1),
 (2,3,5,'2018-08-08','good',4),
 (3,4,5,'2018-08-14','new',4);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;


--
-- Definition of table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details` (
  `order_detail_id` int(10) unsigned NOT NULL auto_increment,
  `order_id` int(10) unsigned NOT NULL,
  `book_id` int(10) unsigned NOT NULL,
  `book_total_price` double NOT NULL,
  `book_price` double NOT NULL,
  `book_discount` double NOT NULL,
  `book_net_price` double NOT NULL,
  PRIMARY KEY  (`order_detail_id`),
  KEY `FK_order_details_1` (`order_id`),
  KEY `FK_order_details_2` (`book_id`),
  CONSTRAINT `FK_order_details_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
  CONSTRAINT `FK_order_details_2` FOREIGN KEY (`book_id`) REFERENCES `book_list` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_details`
--

/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` (`order_detail_id`,`order_id`,`book_id`,`book_total_price`,`book_price`,`book_discount`,`book_net_price`) VALUES 
 (7,1,1,3248,56,6,3242),
 (8,2,4,2500,500,10,2250),
 (9,3,3,500,100,10,450);
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;


--
-- Definition of table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
CREATE TABLE `publisher` (
  `pub_id` int(10) unsigned NOT NULL auto_increment,
  `pub_name` varchar(45) NOT NULL,
  `pub_address` varchar(45) NOT NULL,
  `pub_contact` varchar(45) NOT NULL,
  `pub_country` varchar(45) NOT NULL,
  PRIMARY KEY  (`pub_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `publisher`
--

/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` (`pub_id`,`pub_name`,`pub_address`,`pub_contact`,`pub_country`) VALUES 
 (1,'rakib','dhaka','01123223','bangladesh'),
 (3,'jewel','islamabad','01123223','pakisthan'),
 (4,'reajul','barishal','654564516549','bangladesh');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;


--
-- Definition of table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
CREATE TABLE `sub_category` (
  `sub_cat_id` int(10) unsigned NOT NULL auto_increment,
  `sub_cat_name` varchar(45) NOT NULL,
  `sub_cat_desc` varchar(45) NOT NULL,
  `cat_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`sub_cat_id`),
  KEY `FK_sub_category_1` (`cat_id`),
  CONSTRAINT `FK_sub_category_1` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_category`
--

/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` (`sub_cat_id`,`sub_cat_name`,`sub_cat_desc`,`cat_id`) VALUES 
 (1,'Physics','motion',1),
 (3,'Tragedy','good',2),
 (4,'Haditsh','good',3),
 (5,'Children','good',4);
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;


--
-- Definition of table `upcoming_book`
--

DROP TABLE IF EXISTS `upcoming_book`;
CREATE TABLE `upcoming_book` (
  `book_id` int(10) unsigned NOT NULL auto_increment,
  `auth_name` varchar(45) NOT NULL,
  `p_date` date NOT NULL,
  PRIMARY KEY  (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `upcoming_book`
--

/*!40000 ALTER TABLE `upcoming_book` DISABLE KEYS */;
INSERT INTO `upcoming_book` (`book_id`,`auth_name`,`p_date`) VALUES 
 (1,'jewel','2014-01-20'),
 (2,'abid','2018-05-02'),
 (3,'rana','2018-08-15'),
 (5,'sagor','2018-07-26'),
 (6,'Hasan','2018-08-10');
/*!40000 ALTER TABLE `upcoming_book` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL auto_increment,
  `user_name` varchar(45) NOT NULL,
  `user_address` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `reg_date` date NOT NULL,
  `gender` varchar(30) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`user_id`),
  KEY `FK_user_role` (`role_id`),
  CONSTRAINT `FK_user_role` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`,`user_name`,`user_address`,`email`,`password`,`reg_date`,`gender`,`phone`,`role_id`) VALUES 
 (1,'Abid','dhaka','jewel@gmail.com','123kjkd','2018-08-07','male','0127764646',4),
 (3,'Abid','dhaka','hjhh@gmail.com','123bbcbc','2018-08-22','male','646464646',4),
 (4,'Jewel','Magura','jewel.ranama92@gmail.com','745755','2018-08-22','male','01937745755',5);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(10) unsigned NOT NULL auto_increment,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`role_id`,`role_name`) VALUES 
 (4,'User'),
 (5,'Admin'),
 (6,'Guest');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
