/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.13 : Database - todolist
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
  `user_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_email`,`user_password`,`user_token`) values (1,'123@sina.com','123456','123@sina.com?id=1'),(2,'321@qq.com','321123','321@qq.com?id=2'),(3,'final.com','543','final.com?id=12'),(13,'shufan@qq.com','190310','shufan@qq.com?id=13'),(14,'shufan@163.com','123456','shufan@163.com?id=14'),(15,'suyou@163.com','123456','suyou@163.com?id=15'),(16,'1321231@3132.com','123456','a'),(17,'yyq163@163.com','123456','yyq163@163.com?id=17'),(18,'suyouyou@163.com','123456','a'),(19,'suyu@163.com','123456','suyu@163.com?id=19'),(20,'123456789789@qq.com','123456','a');

/*Table structure for table `user_todolist` */

DROP TABLE IF EXISTS `user_todolist`;

CREATE TABLE `user_todolist` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_userid` int(11) NOT NULL,
  `task_content` varchar(60) DEFAULT NULL,
  `task_type` int(11) NOT NULL,
  `task_createtime` datetime DEFAULT NULL,
  `task_finishtime` datetime DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_todolist` */

insert  into `user_todolist`(`task_id`,`task_userid`,`task_content`,`task_type`,`task_createtime`,`task_finishtime`) values (1,1,'今天早点睡',0,'2021-08-21 15:58:58',NULL),(2,1,'今天少吃点',1,'2021-08-20 15:59:28','2021-08-21 15:59:32');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
