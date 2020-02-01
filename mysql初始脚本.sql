/*
Navicat MySQL Data Transfer

Source Server         : mysql_123456
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : openauth.net

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-12-20 20:34:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `Id` varchar(50) NOT NULL,
  `Content` varchar(1000) DEFAULT NULL,
  `SupportCnt` int(11) DEFAULT '0',
  `OpposeCnt` int(11) DEFAULT '0',
  `AnswerTo` varchar(50) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `UserId` varchar(50) DEFAULT NULL,
  `accept` int(11) NOT NULL DEFAULT '0' COMMENT '是否采纳',
  `praise` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('0467300b-7bc4-4d40-b7c5-252e2606b286', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 20:26:50', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('066fd8ac-1c0a-4922-a027-1b19a54fa319', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 14:10:34', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('14fa4b4f-a01f-4cbc-be6e-5ca538183047', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 20:26:39', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('22f2f531-882d-42b3-b6e1-a2956aee44b7', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 14:08:08', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('2ca2ee8d-bca9-40a0-b767-35a33ab2b653', 'dsdsdsdsdface[左哼哼] ', '0', '0', '977be216-ecfa-43af-97ba-217d2e867e4e', '2016-12-16 15:53:47', 'f77e649d-7159-48b3-bbc1-750f83403cae', '0', '0');
INSERT INTO `answer` VALUES ('3226ad63-8c21-4ead-8003-38eedf878276', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 20:27:01', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('359164f8-c58f-448f-9fdc-7f845cb53edf', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 20:26:45', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('4076ffb7-7cdc-43d0-ad10-ca160d4a5882', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-19 19:48:44', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('43820df3-dffc-4ee3-b98f-35df2ae06665', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 16:20:23', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('4d179790-5017-4d55-aa60-a5175ab84daa', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 20:26:57', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('53472199-25df-4cfc-8eed-9102e0d47229', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 14:52:18', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('7170608f-d15d-4889-92bd-f1cf27799b8a', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-19 20:35:41', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('94e43378-2d47-4b2a-a655-c2ff52b106b3', 'fdddfdd', '0', '0', '977be216-ecfa-43af-97ba-217d2e867e4e', '2016-12-14 21:01:55', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('9f0eb31f-a54d-4a1a-851a-92afa04c825a', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 15:20:19', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('ab269931-b58d-424e-a73a-e335f7cae7ed', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 15:17:08', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('ad4377f3-d8a0-45c7-a7dc-28dfa021e28b', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-19 20:36:35', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('b15448fd-eea2-48ae-a6c1-76ea3219198c', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 15:24:55', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('b4ad9662-d7ec-4074-a3c3-2fe1b38ab8fc', 'wewwweface[太开心] ', '0', '0', 'b767e51e-5c2c-4a8d-878f-92cec0b82052', '2016-12-19 14:12:53', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('bd7daf75-f435-4c22-9551-e6de29b966e3', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 17:50:00', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('d2db22ae-9a74-4418-aba7-5506f3e780c5', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 15:21:54', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');
INSERT INTO `answer` VALUES ('f20d2e89-cc45-42d6-8da8-45041eb24942', 'ok', '0', '0', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', '2016-12-20 08:36:00', 'd8c8a352-452f-45ea-b699-4dc566885694', '0', '0');


-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` varchar(50) NOT NULL,
  `time` datetime NOT NULL,
  `content` varchar(200) NOT NULL,
  `href` varchar(1000) DEFAULT NULL,
  `from` varchar(50) NOT NULL,
  `to` varchar(50) NOT NULL,
  `fromstatus` int(4) NOT NULL DEFAULT '0' COMMENT '来源方状态',
  `tostatus` int(4) NOT NULL DEFAULT '0' COMMENT '到达方状态',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `fromname` varchar(50) DEFAULT NULL COMMENT '来源方名称',
  `toname` varchar(50) DEFAULT NULL COMMENT '到达方名字',
  `read` int(4) NOT NULL DEFAULT '0',
  `title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `title` varchar(200) DEFAULT NULL,
  `Id` varchar(50) NOT NULL,
  `Content` varchar(10000) DEFAULT NULL,
  `SupportCnt` int(11) DEFAULT '0',
  `OpposeCnt` int(11) DEFAULT '0',
  `CommentTo` varchar(50) DEFAULT NULL,
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  `UserId` varchar(50) DEFAULT NULL,
  `hits` int(11) NOT NULL DEFAULT '0' COMMENT '浏览量',
  `stick` int(11) NOT NULL DEFAULT '0' COMMENT '置顶',
  `comment` int(11) NOT NULL DEFAULT '0' COMMENT '回答数',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '加精',
  `experience` int(11) NOT NULL DEFAULT '0' COMMENT '悬赏',
  `accept` varchar(50) DEFAULT NULL COMMENT '采纳',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('dd', '7d6f6f41-7144-417d-b5ec-bd3f6f4b9993', 'ddddddddddfffdface[互粉] ', '0', '0', null, '2016-12-19 14:04:55', 'd8c8a352-452f-45ea-b699-4dc566885694', '1', '0', '18', '0', '5', null);
INSERT INTO `question` VALUES ('dsdsds', '977be216-ecfa-43af-97ba-217d2e867e4e', 'dsdsdsfffffff', '0', '0', null, '2016-12-14 19:26:11', 'f77e649d-7159-48b3-bbc1-750f83403cae', '58', '0', '5', '0', '5', '94e43378-2d47-4b2a-a655-c2ff52b106b3');
INSERT INTO `question` VALUES ('dccccc', 'b767e51e-5c2c-4a8d-878f-92cec0b82052', 'cccgdgdgd', '0', '0', null, '2016-12-19 14:05:04', 'd8c8a352-452f-45ea-b699-4dc566885694', '5', '0', '1', '0', '5', null);

-- ----------------------------
-- Table structure for sysconf
-- ----------------------------
DROP TABLE IF EXISTS `sysconf`;
CREATE TABLE `sysconf` (
  `id` varchar(50) NOT NULL,
  `value` varchar(200) NOT NULL,
  `key` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysconf
-- ----------------------------
INSERT INTO `sysconf` VALUES ('8223baeb-a7e9-4932-a64b-d709300473e2', '2.0', 'version');
INSERT INTO `sysconf` VALUES ('c0b07303-6e23-4f89-9570-d6aef0d7b92f', '4305', 'download');


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) NOT NULL,
  `rmb` int(11) NOT NULL DEFAULT '0' COMMENT 'VIP等级',
  `createtime` datetime NOT NULL,
  `logintime` datetime DEFAULT NULL,
  `wxopenid` varchar(100) DEFAULT NULL,
  `qqopenid` varchar(100) DEFAULT NULL,
  `questioncnt` int(11) NOT NULL DEFAULT '0',
  `answercnt` int(11) NOT NULL DEFAULT '0',
  `pic` varchar(100) DEFAULT NULL,
  `auth` int(11) NOT NULL DEFAULT '0' COMMENT '用户权限',
  `experience` int(11) NOT NULL DEFAULT '0' COMMENT '经验值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('d8c8a352-452f-45ea-b699-4dc566885694', 'yubaolee', '盖世玉宝', 'lueSGJZetyySpUndWjMBEg==', '2', '2016-12-01 10:44:52', null, null, null, '0', '25', '0.jpg', '1', '0');
INSERT INTO `user` VALUES ('f77e649d-7159-48b3-bbc1-750f83403cae', 'admin', '无敌&王子', 'lueSGJZetyySpUndWjMBEg==', '0', '2016-12-01 16:50:06', null, null, null, '0', '4', '3.jpg', '0', '0');

-- ----------------------------
-- Table structure for user Token
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token` (
  `user_id` varchar(50) NOT NULL,
  `token` varchar(256) DEFAULT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token'
