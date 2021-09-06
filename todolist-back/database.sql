/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - todolist
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`todolist` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `todolist`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(64) NOT NULL,
  `user_password` varchar(64) NOT NULL,
  `user_token` varchar(64) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_email`,`user_password`,`user_token`) values (1,'123@sina.com','123456','123@sina.com?id=1'),(2,'321@qq.com','321123','321@qq.com?id=2'),(3,'670918616@sina.com','123456','a'),(4,'123123@sina.com','123123','123123@sina.com?id=4'),(5,'asbdjaskdb@sina.com','123123','a'),(6,'670918616@qq.com','123456','670918616@qq.com?id=6');

/*Table structure for table `user_todolist` */

DROP TABLE IF EXISTS `user_todolist`;

CREATE TABLE `user_todolist` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_userid` int(11) NOT NULL,
  `task_content` varchar(128) NOT NULL,
  `task_type` int(11) NOT NULL,
  `task_createtime` datetime DEFAULT NULL,
  `task_finishtime` datetime DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `user_todolist` */

insert  into `user_todolist`(`task_id`,`task_userid`,`task_content`,`task_type`,`task_createtime`,`task_finishtime`) values (1,1,'今天早点睡',0,'2021-08-21 15:58:58',NULL),(2,1,'今天少吃点',1,'2021-08-20 15:59:28','2021-08-21 15:59:32'),(3,1,'要把span转给块级元素才行。在span的css中加入以下属性即可。是行内元素',0,'2021-09-06 19:41:40',NULL),(4,1,'要把span转给块级元素才行。在span的css中加入以下属性即可。是行内元素',0,'2021-09-30 19:41:53',NULL),(5,1,'要把span转给块级元素才行。在span的css中加入以下属性即可。是行内元素要把span转给块级元素才行。在span的css中加入以下属性即可。是行内元素',0,'2021-09-03 19:42:16',NULL),(6,1,'要把span转给块级元素才行。在span的css中加入以下属性即可。是行内元素要把span转给块级元素才行。在span的css中加入以下属性即可。是行内元素',0,'2021-09-01 19:43:19',NULL),(7,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',0,'2021-09-06 19:43:46',NULL),(8,1,'的css中加入以下属性即可。是行内元素，要想margin-to',0,'2021-09-06 19:44:10',NULL),(9,1,'的css中加入以下属性即可。是行内元素，要想margin-to的css中加入以下属性即可。是行内元素，要想margin-to',0,'2021-09-06 19:44:18',NULL),(10,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',0,'2021-09-06 19:57:32',NULL),(11,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',0,'2021-09-17 19:57:42',NULL),(12,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦啊实打实的',0,'2021-09-06 19:57:52',NULL),(13,1,'asdsd阿三大苏打大苏打萨达萨达撒旦撒旦撒旦阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',0,'2021-09-06 19:58:01',NULL),(14,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',0,'2021-09-02 19:58:07',NULL),(15,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',0,'2021-09-01 19:58:14',NULL),(16,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',0,'2021-09-06 20:02:35',NULL),(17,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',1,'2021-09-08 20:02:43',NULL),(18,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',0,'2021-09-06 20:02:52',NULL),(19,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',0,'2021-09-06 20:03:20',NULL),(20,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',1,'2021-09-06 20:04:30',NULL),(21,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',1,'2021-09-06 20:04:36',NULL),(22,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',1,'2021-09-06 20:04:42',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
