CREATE DATABASE  IF NOT EXISTS  `hmily`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;

CREATE DATABASE IF NOT EXISTS `db_a` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

USE `db_a`;

DROP TABLE IF EXISTS `account_rmb`;

CREATE TABLE `account_rmb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL,
  `balance` decimal(10,0) NOT NULL COMMENT '用户余额',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

insert  into `account_rmb`(`id`,`user_name`,`balance`,`create_time`,`update_time`) values (1,'a', 7000,'2021-03-13 14:54:22',NULL);

DROP TABLE IF EXISTS `account_dollar`;
CREATE TABLE `account_dollar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL,
  `balance` decimal(10,0) NOT NULL COMMENT '用户余额',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

insert  into `account_dollar`(`id`,`user_name`,`balance`,`create_time`,`update_time`) values (1,'a', 0,'2021-03-13 14:54:22',NULL);

DROP TABLE IF EXISTS `account_freeze`;
CREATE TABLE `account_freeze` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL,
  `balance` decimal(10,0) NOT NULL COMMENT '用户余额',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

insert  into `account_freeze`(`id`,`user_name`,`balance`,`create_time`,`update_time`) values (1,'a', 0,'2021-03-13 14:54:22',NULL);



CREATE DATABASE IF NOT EXISTS `db_b` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

USE `db_b`;

DROP TABLE IF EXISTS `account_rmb`;

CREATE TABLE `account_rmb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL,
  `balance` decimal(10,0) NOT NULL COMMENT '用户余额',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

insert  into `account_rmb`(`id`,`user_name`,`balance`,`create_time`,`update_time`) values (1,'b', 0,'2021-03-13 14:54:22',NULL);

DROP TABLE IF EXISTS `account_dollar`;
CREATE TABLE `account_dollar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL,
  `balance` decimal(10,0) NOT NULL COMMENT '用户余额',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

insert  into `account_dollar`(`id`,`user_name`,`balance`,`create_time`,`update_time`) values (1,'b', 1000,'2021-03-13 14:54:22',NULL);

DROP TABLE IF EXISTS `account_freeze`;
CREATE TABLE `account_freeze` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL,
  `balance` decimal(10,0) NOT NULL COMMENT '用户余额',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

insert  into `account_freeze`(`id`,`user_name`,`balance`,`create_time`,`update_time`) values (1,'b', 0,'2021-03-13 14:54:22',NULL);
