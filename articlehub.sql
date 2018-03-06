/*
 Navicat Premium Data Transfer

 Source Server         : mysql-localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : articlehub

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 09/02/2018 21:11:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `aid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `authorid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `reading` int(11) NOT NULL DEFAULT 0,
  `datetime` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('116123db-8c97-4ed9-9f3f-7b895091c233', '我的故事', 'qwerty', 'faa66f1f-08a7-4369-a6d0-4aaa76331f63', 0, '2018-01-03 13:25:40');
INSERT INTO `article` VALUES ('a093a6e7-ae95-4728-aa8e-8f9b5ac3036c', '新建文章', '123', 'faa66f1f-08a7-4369-a6d0-4aaa76331f63', 0, '2018-01-03 23:29:43');
INSERT INTO `article` VALUES ('c384d948-9ae9-41b8-8cac-b91dade3f4f2', '文章123', '123', '6b2ddc24-a59b-4ca2-9b9c-131c1794de25', 0, '2018-01-03 13:24:31');
INSERT INTO `article` VALUES ('f4aca05a-a60b-41fb-898d-9199b935d6c1', '文章2文章2文章2', '123', 'faa66f1f-08a7-4369-a6d0-4aaa76331f63', 0, '2018-01-03 13:6:16');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `cid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `aid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('11761598-c3d0-4da4-b17f-e5809a8cc759', '123', 'c384d948-9ae9-41b8-8cac-b91dade3f4f2');
INSERT INTO `collect` VALUES ('5a32885a-cf29-41e9-b7cb-d31e341feae4', 'qwerty', 'c384d948-9ae9-41b8-8cac-b91dade3f4f2');
INSERT INTO `collect` VALUES ('60bae5d6-64fe-48c0-922a-79240feffd57', 'qwerty', 'f4aca05a-a60b-41fb-898d-9199b935d6c1');
INSERT INTO `collect` VALUES ('7fecdb52-7e77-43c9-93d7-c048172e328c', '123', 'f4aca05a-a60b-41fb-898d-9199b935d6c1');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `cid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `aid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `datetime` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('23296da9-3577-431b-84ca-49bff333c9a7', '123', 'c384d948-9ae9-41b8-8cac-b91dade3f4f2', '我的评论我的评论我的评论我的评论我的评论我的评论', '2018-01-03 13:38:34');
INSERT INTO `comment` VALUES ('2bd8214c-a1d2-4cc2-9e1d-473a133d33cd', '123', '116123db-8c97-4ed9-9f3f-7b895091c233', '评论123', '2018-01-03 23:23:19');
INSERT INTO `comment` VALUES ('4d4ed270-626e-4e3d-a6d7-da4fdeed8e55', '123', '116123db-8c97-4ed9-9f3f-7b895091c233', '评论评论评论评论评论评论评论', '2018-01-03 22:58:4');
INSERT INTO `comment` VALUES ('921ed360-b8bb-4f8f-9f40-fa0e1b4855f2', '123123123123', '116123db-8c97-4ed9-9f3f-7b895091c233', '评论评论评论我的评论', '2018-01-03 22:59:7');
INSERT INTO `comment` VALUES ('bad4fa84-da1a-4155-8710-b206b4cb1d72', '123', 'c384d948-9ae9-41b8-8cac-b91dade3f4f2', '评论123', '2018-01-03 23:14:38');
INSERT INTO `comment` VALUES ('e6927556-ebd0-4d97-a027-1793016c8d33', '123', '116123db-8c97-4ed9-9f3f-7b895091c233', '评论', '2018-01-03 23:28:30');

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `fid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `authorid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`fid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES ('8be9e28b-9f2a-a6eb-9d47-07aeb98bcfdd', '123', 'f4aca05a-a60b-41fb-898d');
INSERT INTO `follow` VALUES ('b74a44ea-7fc8-b51a-5e58-ecc072276e76', '123', 'qwerty');

-- ----------------------------
-- Table structure for subscribe
-- ----------------------------
DROP TABLE IF EXISTS `subscribe`;
CREATE TABLE `subscribe`  (
  `sid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subscribe
-- ----------------------------
INSERT INTO `subscribe` VALUES ('847ac570-e61d-4976-a5f4-7a0cc2663798', '123', 'faa66f1f-08a7-4369-a6d0-4aaa76331f63');
INSERT INTO `subscribe` VALUES ('99a0f5f2-c1ac-4aa7-5b5d-76a88d44d657', '123', '966701cd-1bc8-40e7-bae3-f0a1bb6b118b');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `a` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `tid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `portraitURL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('6b2ddc24-a59b-4ca2-9b9c-131c1794de25', '科普', 'https://upload.jianshu.io/collections/images/76/12.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180', '专题公告专题公告科普专题公告专题公告专题公告专题公告专题公告专题公告');
INSERT INTO `topic` VALUES ('6f772d11-ee4f-4b9f-a3bf-2f8efd1f5024', '新专题', 'https://upload.jianshu.io/collections/images/16/computer_guy.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240', '专题公告');
INSERT INTO `topic` VALUES ('966701cd-1bc8-40e7-bae3-f0a1bb6b118b', '小说', 'https://upload.jianshu.io/collections/images/11/20100120161805563.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180', '专题一公告专题一公告专题一公告专题一公告专题一公告专题一公告');
INSERT INTO `topic` VALUES ('faa66f1f-08a7-4369-a6d0-4aaa76331f63', '故事', 'https://upload.jianshu.io/collections/images/13/%E5%95%8A.png?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180', '故事专题公告故事专题公告故事专题公告故事专题公告故事专题公告故事专题公告故事专题公告故事专题公告故事专题公告');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `portraitURL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `admin` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123', 'https://upload.jianshu.io/collections/images/16/computer_guy.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240', '用户1', '123', '123123123@abc.com', '我是管理员', 1);
INSERT INTO `user` VALUES ('123123123123', 'https://upload.jianshu.io/collections/images/261938/man-hands-reading-boy-large.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180', '作者2', '121212', '135135@abc.com', '我是作者2我是作者2我是作者2', 0);
INSERT INTO `user` VALUES ('f4aca05a-a60b-41fb-898d', 'https://upload.jianshu.io/collections/images/4/sy_20091020135145113016.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180', '小作者', '1212', '789789789@abc.com', '我是小作者小作者小作者', 0);
INSERT INTO `user` VALUES ('qwerty', 'https://upload.jianshu.io/collections/images/28/%E4%B8%8A%E7%8F%AD%E8%BF%99%E7%82%B9%E4%BA%8B%E5%84%BF.jpeg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180', '作者3', '1212', '12123123@abc.com', '我是作者3作者3作者3作者3作者3', 0);

-- ----------------------------
-- View structure for articlecollected
-- ----------------------------
DROP VIEW IF EXISTS `articlecollected`;
CREATE ALGORITHM = UNDEFINED DEFINER = `skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `articlecollected` AS select `articledetail`.`aid` AS `aid`,`articledetail`.`title` AS `title`,`articledetail`.`authorid` AS `authorid`,`articledetail`.`tid` AS `tid`,`articledetail`.`reading` AS `reading`,`articledetail`.`authorName` AS `authorName`,`articledetail`.`datetime` AS `datetime`,`articledetail`.`collection` AS `collection`,`articledetail`.`commentNum` AS `commentNum`,`articledetail`.`portraitURL` AS `portraitURL`,`articledetail`.`topic` AS `topic`,`collect`.`uid` AS `uid` from (`articledetail` join `collect`) where (`articledetail`.`aid` = `collect`.`aid`);

-- ----------------------------
-- View structure for articledetail
-- ----------------------------
DROP VIEW IF EXISTS `articledetail`;
CREATE ALGORITHM = UNDEFINED DEFINER = `skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `articledetail` AS select `article`.`aid` AS `aid`,`article`.`title` AS `title`,`article`.`authorid` AS `authorid`,`article`.`tid` AS `tid`,`article`.`reading` AS `reading`,`user`.`username` AS `authorName`,`article`.`datetime` AS `datetime`,(select count(`collect`.`cid`) from `collect` where (`collect`.`aid` = `article`.`aid`)) AS `collection`,(select count(`comment`.`cid`) from `comment` where (`comment`.`aid` = `article`.`aid`)) AS `commentNum`,`user`.`portraitURL` AS `portraitURL`,`topic`.`name` AS `topic` from ((`article` join `user`) join `topic`) where ((`article`.`authorid` = `user`.`uid`) and (`article`.`tid` = `topic`.`tid`));

-- ----------------------------
-- View structure for author
-- ----------------------------
DROP VIEW IF EXISTS `author`;
CREATE ALGORITHM = UNDEFINED DEFINER = `skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `author` AS select `user`.`uid` AS `uid`,`user`.`portraitURL` AS `portraitURL`,`user`.`username` AS `name`,`user`.`desc` AS `desc`,(select count(`follow`.`fid`) from `follow` where (`follow`.`authorid` = `user`.`uid`)) AS `followNum`,(select count(`article`.`aid`) from `article` where (`article`.`authorid` = `user`.`uid`)) AS `articleNum`,`user`.`admin` AS `admin` from `user`;

-- ----------------------------
-- View structure for commentdetail
-- ----------------------------
DROP VIEW IF EXISTS `commentdetail`;
CREATE ALGORITHM = UNDEFINED DEFINER = `skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `commentdetail` AS select `comment`.`cid` AS `cid`,`user`.`username` AS `username`,`user`.`portraitURL` AS `portraitURL`,`comment`.`datetime` AS `datetime`,`article`.`title` AS `article`,`comment`.`text` AS `content`,`article`.`aid` AS `aid`,`article`.`authorid` AS `authorid` from ((`comment` join `user`) join `article`) where ((`comment`.`uid` = `user`.`uid`) and (`comment`.`aid` = `article`.`aid`));

-- ----------------------------
-- View structure for followdetail
-- ----------------------------
DROP VIEW IF EXISTS `followdetail`;
CREATE ALGORITHM = UNDEFINED DEFINER = `skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `followdetail` AS select `follow`.`uid` AS `muid`,`follow`.`authorid` AS `uid`,`author`.`portraitURL` AS `portraitURL`,`author`.`name` AS `name`,`author`.`followNum` AS `followNum` from (`follow` join `author`) where (`follow`.`authorid` = `author`.`uid`);

-- ----------------------------
-- View structure for topicdetail
-- ----------------------------
DROP VIEW IF EXISTS `topicdetail`;
CREATE ALGORITHM = UNDEFINED DEFINER = `skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `topicdetail` AS select `subscribe`.`uid` AS `muid`,`subscribe`.`tid` AS `tid`,`topicview`.`name` AS `name`,`topicview`.`portraitURL` AS `portraitURL`,`topicview`.`subscribeNum` AS `subscribeNum` from (`subscribe` join `topicview`) where (`subscribe`.`tid` = `topicview`.`tid`);

-- ----------------------------
-- View structure for topicview
-- ----------------------------
DROP VIEW IF EXISTS `topicview`;
CREATE ALGORITHM = UNDEFINED DEFINER = `skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `topicview` AS select `topic`.`tid` AS `tid`,`topic`.`name` AS `name`,`topic`.`portraitURL` AS `portraitURL`,(select count(`subscribe`.`sid`) from `subscribe` where (`subscribe`.`tid` = `topic`.`tid`)) AS `subscribeNum`,(select count(`article`.`aid`) from `article` where (`article`.`tid` = `topic`.`tid`)) AS `articleNum`,`topic`.`desc` AS `desc` from `topic`;

SET FOREIGN_KEY_CHECKS = 1;
