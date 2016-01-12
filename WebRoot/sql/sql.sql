/*
SQLyog Community v11.01 (32 bit)
MySQL - 5.1.55-community : Database - opencart_testing
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`opencart_testing` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `opencart_testing`;

/*Table structure for table `oc_mail_task` */

DROP TABLE IF EXISTS `oc_mail_task`;

CREATE TABLE `oc_mail_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `mail_from` varchar(255) NOT NULL,
  `mail_to` varchar(255) NOT NULL COMMENT '0æœªå®Œæˆï¼Œ1å·²å®Œæˆ',
  `mail_subject` varchar(255) NOT NULL,
  `mail_message` longtext NOT NULL,
  `is_ok` int(11) NOT NULL DEFAULT '0',
  `send_count` int(11) NOT NULL DEFAULT '0' COMMENT 'é‚®ä»¶å‘é€æ¬¡æ•°ï¼Œé»˜è®¤0æ¬¡',
  `date_added` datetime NOT NULL,
  `date_modified` datetime NOT NULL,
  PRIMARY KEY (`task_id`),
  KEY `is_ok` (`is_ok`,`send_count`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oc_mail_task` */

/*Table structure for table `oc_opinion` */

DROP TABLE IF EXISTS `oc_opinion`;

CREATE TABLE `oc_opinion` (
  `opinion_id` int(11) NOT NULL AUTO_INCREMENT,
  `os_type` char(1) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `content` text,
  `customer_id` int(11) DEFAULT NULL,
  `netflow_type` char(1) DEFAULT NULL,
  `version_number` varchar(75) DEFAULT NULL,
  `deal_id` int(11) DEFAULT NULL,
  `deal_content` text,
  `deal_date` datetime DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`opinion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oc_opinion` */

/*Table structure for table `oc_version` */

DROP TABLE IF EXISTS `oc_version`;

CREATE TABLE `oc_version` (
  `version_id` int(11) NOT NULL AUTO_INCREMENT,
  `os_type` char(1) DEFAULT NULL,
  `package_name` varchar(50) DEFAULT NULL,
  `content` text,
  `version_number` varchar(128) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`version_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `oc_version` */

insert  into `oc_version`(`version_id`,`os_type`,`package_name`,`content`,`version_number`,`url`,`date_added`,`date_modified`) values (4,'1','com.lantin','1111111111111111\r\n1\r\n1\r\n1111111111111111111111','1.1.0','http://123456.com','2015-09-13 10:40:02','2015-09-13 10:40:04');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
