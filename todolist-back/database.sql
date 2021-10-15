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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/*Data for the table `user_todolist` */

insert  into `user_todolist`(`task_id`,`task_userid`,`task_content`,`task_type`,`task_createtime`,`task_finishtime`) values (1,1,' 今天早点睡 qwe',0,'2021-08-21 15:58:58',NULL),(2,1,'   今天少吃点 如果没有安装可以参考vuewqe的官方文档进行安装。第一步是下载：npm i element-uN你好啊啊啊急急急急急急i -S；第二步骤：在main.js中引入js和css；第三步骤：让vue引用E  ',0,'2021-08-20 15:59:28',NULL),(6,1,'要把span转给块级元素才行。在span的css中加入以下属性即可。是行内元素要把span转给块级元素才行。在span的css中加入以下属性即可。是行内元素',0,'2021-09-01 19:43:19',NULL),(8,1,'的css中加入以下属性即可。是行内元素，要想margin-to',1,'2021-09-06 19:44:10','2021-09-14 11:35:09'),(9,1,'的css中加入以下属性即可。是行内元素，要想margin-to的css中加入以下属性即可。是行内元素，要想margin-to',1,'2021-09-06 19:44:18','2021-09-14 11:35:11'),(11,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',1,'2021-09-17 19:57:42','2021-09-18 11:07:32'),(13,1,'asdsd阿三大苏打大苏打萨达萨达撒旦撒旦撒旦阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',1,'2021-09-06 19:58:01','2021-09-14 11:35:14'),(15,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',1,'2021-09-01 19:58:14','2021-09-14 11:33:46'),(16,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',1,'2021-09-06 20:02:35','2021-09-14 11:35:16'),(19,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',1,'2021-09-06 20:03:20','2021-09-14 11:35:19'),(21,1,'阿三大苏打大苏打萨达萨达撒旦撒旦撒旦阿三大苏打大苏打萨达萨达撒旦撒旦撒旦',1,'2021-09-06 20:04:36','2021-09-14 11:35:25'),(22,1,' 阿三大苏打大苏打萨达萨达撒旦撒旦撒旦阿三大苏打大苏打萨达萨达撒旦撒旦撒旦 ASDASDASDASD',1,'2021-09-06 20:04:42','2021-09-23 23:41:13'),(23,1,'你好啊',1,'2021-09-11 16:12:07','2021-09-14 11:34:52'),(24,1,'vue项目中使用element-ui时,用到了Dropdown组件。 需要在子菜单上添加click事件。但是使用@click添加点击事件并没有产生效果,毫无反应。 但',1,'2021-09-11 16:14:18','2021-09-14 11:37:11'),(25,1,'在vue项目中使用element的el-dropdown-item标签时 给标签添加c',1,'2021-09-11 16:15:21','2021-09-11 16:43:44'),(29,1,'@RequestParam(\"task_id\") Integer task_id@RequestParam(\"task_id\") Integer task_id',1,'2021-09-11 16:50:36','2021-09-11 16:50:52'),(30,1,'margin: 0 auto;margin: 0 auto;margin: 0 auto;margin: 0 auto;margin: 0 auto;',1,'2021-09-11 16:53:21','2021-09-14 11:37:09'),(31,1,' margin: 0 auto;margin: 0 auto;margin: 0 auto;margin: 0 auto; ',0,'2021-09-11 16:53:28',NULL),(32,1,'@JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")@JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")',1,'2021-09-11 17:00:21','2021-09-14 11:37:08'),(33,1,'@JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")@JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")',1,'2021-09-11 17:00:24','2021-09-11 17:03:50'),(34,1,'比较宽松啊实打实大苏打阿斯顿阿斯顿打开三叠纪卡尼',0,'2021-09-11 17:03:38',NULL),(35,1,'如果没有安装可以参考vue的官方文档进行安装。第一步是下载：npm i element-ui -S；第二步骤：在main.js中引入js和css；第三步骤：让vue引用E',1,'2021-09-14 08:31:42','2021-09-14 11:37:05'),(36,1,'如果没有安装可以参考vue的官方文档进行安装。第一步是下载：npm i element-ui -S；第二步骤：在main.js中引入js和css；第三步骤：让vue引用E',1,'2021-09-14 08:31:46','2021-09-14 11:37:02'),(37,1,'如果没有安装可以参考vue的官方文档进行安装。第一步是下载：npm i element-ui -S；第二步骤：在main.js中引入js和css；第三步骤：让vue引用E',0,'2021-09-14 08:31:57',NULL),(38,1,'   el-icon-s-promotion 123 AASDNASJDNASDN QWEWQE',0,'2021-09-14 08:53:59',NULL),(39,1,'的css中加入以下属性即可。是行内元素，要想margin-to',1,'2021-09-14 09:03:46','2021-09-14 11:42:27'),(40,1,' 的css中加入以下属性即可。是行内元素，要想margin-to ASDADNJASNDKASNDASDNMASNDMSNDMNDASD',0,'2021-09-14 09:03:51',NULL),(42,1,' 的css中加入以下属性即可。是行内元素，要想margin-to的css中加入以下属性即可。是行内SADSAD，要想margin-to ASDSD',0,'2021-09-14 09:08:49',NULL),(43,1,'的css中加入以下属性即可。是行内元素，要想margin-to的css中加入以下属性即可。是行内元素，要想margin-to',0,'2021-09-14 09:08:52',NULL),(44,1,'的css中加入以下属性即可。是行内元素，要想margin-to的css中加入以下属性即可。是行内元素，要想margin-to',0,'2021-09-14 09:08:55',NULL),(45,1,'的css中加入以下属性即可。是行内元素，要想margin-to的css中加入以下属性即可。是行内元素，要想margin-to',1,'2021-09-14 09:09:00','2021-09-18 11:08:06'),(47,1,'啊实打实大苏打实打实的',1,'2021-09-18 11:07:48','2021-09-18 11:07:51'),(48,1,'啊实打实的',1,'2021-09-18 11:08:39','2021-09-23 23:41:22'),(49,1,' 俺是男滴阿森纳的卡就是你的家阿森纳觉得看得见那就是电脑卡机纳斯达克 123',1,'2021-09-23 22:04:24','2021-09-23 23:41:30'),(50,1,'213213',0,'2021-09-23 23:43:43',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
