/*
Navicat MySQL Data Transfer

Source Server         : checy
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : vip9

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2022-01-19 11:35:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL auto_increment,
  `cname` varchar(255) default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '数码产品');
INSERT INTO `category` VALUES ('5', '衣服类');
INSERT INTO `category` VALUES ('6', '化妆品');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `oid` bigint(20) NOT NULL auto_increment,
  `ono` varchar(255) default NULL COMMENT '订单号',
  `create_time` datetime default NULL,
  `total_price` decimal(10,2) default NULL,
  PRIMARY KEY  (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '32663726732', '2022-01-19 10:55:23', '299.00');
INSERT INTO `order` VALUES ('2', '8787843', '2022-01-18 10:55:39', '199.00');

-- ----------------------------
-- Table structure for order_product
-- ----------------------------
DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order_product` (
  `oid` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL,
  KEY `pid` (`pid`),
  KEY `oid` (`oid`),
  CONSTRAINT `oid` FOREIGN KEY (`oid`) REFERENCES `order` (`oid`),
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_product
-- ----------------------------
INSERT INTO `order_product` VALUES ('1', '1');
INSERT INTO `order_product` VALUES ('1', '2');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` bigint(20) NOT NULL auto_increment,
  `pname` varchar(255) default NULL,
  `cid` int(11) default NULL,
  `price` decimal(10,2) default NULL,
  PRIMARY KEY  (`pid`),
  KEY `cid` (`cid`),
  CONSTRAINT `cid` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '联想电脑', '1', '2999.00');
INSERT INTO `product` VALUES ('2', 'VIVO手机', '1', '3999.00');
INSERT INTO `product` VALUES ('3', '洗发水', '6', '100.00');
INSERT INTO `product` VALUES ('4', '鞋', null, '299.00');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL auto_increment,
  `sno` varchar(100) default NULL COMMENT '学号',
  `sname` varchar(255) default NULL COMMENT '学生姓名',
  `age` int(11) default NULL COMMENT '年龄',
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('4', '37287832', '多岁的', '11');
INSERT INTO `student` VALUES ('6', '2022008', '张三', '22');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `username` varchar(255) default NULL COMMENT '用户名',
  `password` varchar(255) default NULL COMMENT '密码',
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lucy', null, null);
INSERT INTO `user` VALUES ('2', 'tom', 'tom123', '123456');
INSERT INTO `user` VALUES ('3', 'lily', null, null);
INSERT INTO `user` VALUES ('4', 'guanguan', null, null);
INSERT INTO `user` VALUES ('5', 'guanguan', null, null);
