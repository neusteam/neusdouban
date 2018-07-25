/*
Navicat MySQL Data Transfer

Source Server         : ycj
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : douban

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-07-25 10:02:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for actorinfo
-- ----------------------------
DROP TABLE IF EXISTS `actorinfo`;
CREATE TABLE `actorinfo` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `birth` date NOT NULL,
  `hometown` varchar(6) NOT NULL,
  `occupation` varchar(10) NOT NULL,
  `describe` text NOT NULL,
  `url` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of actorinfo
-- ----------------------------

-- ----------------------------
-- Table structure for movieinfo
-- ----------------------------
DROP TABLE IF EXISTS `movieinfo`;
CREATE TABLE `movieinfo` (
  `movie_id` int(20) NOT NULL AUTO_INCREMENT,
  `moviename` varchar(20) NOT NULL,
  `date` datetime NOT NULL,
  `director` varchar(20) NOT NULL,
  `actor` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,
  `language` varchar(20) NOT NULL,
  `picture` text NOT NULL,
  `average` float(3,1) NOT NULL,
  `describe` text NOT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movieinfo
-- ----------------------------
INSERT INTO `movieinfo` VALUES ('1', '我不是药神', '2018-07-05 00:00:00', '文牧野', '徐峥/王传君', '剧情/喜剧', '中国', '普通话', 'drfasgagagdag', '0.0', '');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `score` float(2,1) NOT NULL,
  `comments` text NOT NULL,
  `user_id` int(11) NOT NULL,
  `movie_id` int(20) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0',
  `name` varchar(20) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `url` varchar(20) NOT NULL,
  `phonenumber` int(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `city` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '464839566@qq.com', '111', '0', '', '', '', '0', '', '');
INSERT INTO `users` VALUES ('2', '2015214256', '111111', '1', '', '', '', '0', '', '');
INSERT INTO `users` VALUES ('3', '20000000', '2222', '0', '', '', '', '0', '', '');
