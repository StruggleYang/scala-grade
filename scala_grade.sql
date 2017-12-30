/*
Navicat MySQL Data Transfer

Source Server         : this
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : scala_grade

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-12-26 15:52:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `scala_clazz`
-- ----------------------------
DROP TABLE IF EXISTS `scala_clazz`;
CREATE TABLE `scala_clazz` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `g_id` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of scala_clazz
-- ----------------------------
INSERT INTO `scala_clazz` VALUES ('1', '高一1班', '1');
INSERT INTO `scala_clazz` VALUES ('2', '高一2班', '1');
INSERT INTO `scala_clazz` VALUES ('3', '高一3班', '1');
INSERT INTO `scala_clazz` VALUES ('4', '高二1班', '2');
INSERT INTO `scala_clazz` VALUES ('5', '高二2班', '2');
INSERT INTO `scala_clazz` VALUES ('6', '高二3班', '2');
INSERT INTO `scala_clazz` VALUES ('7', '高三1班', '3');
INSERT INTO `scala_clazz` VALUES ('8', '高三2班', '3');
INSERT INTO `scala_clazz` VALUES ('9', '高三3班', '3');

-- ----------------------------
-- Table structure for `scala_grade`
-- ----------------------------
DROP TABLE IF EXISTS `scala_grade`;
CREATE TABLE `scala_grade` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of scala_grade
-- ----------------------------
INSERT INTO `scala_grade` VALUES ('1', '高一');
INSERT INTO `scala_grade` VALUES ('2', '高二');
INSERT INTO `scala_grade` VALUES ('3', '高三');

-- ----------------------------
-- Table structure for `scala_student`
-- ----------------------------
DROP TABLE IF EXISTS `scala_student`;
CREATE TABLE `scala_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `sex` varchar(60) DEFAULT NULL,
  `chinese` int(11) DEFAULT NULL,
  `math` int(11) DEFAULT NULL,
  `english` int(11) DEFAULT NULL,
  `c_id` int(11) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scala_student
-- ----------------------------
INSERT INTO `scala_student` VALUES ('1', '王一', '男', '67', '100', '54', '00000000001');
INSERT INTO `scala_student` VALUES ('2', '王二', '女', '76', '45', '78', '00000000002');
INSERT INTO `scala_student` VALUES ('3', '王三', '女', '95', '58', '98', '00000000003');
INSERT INTO `scala_student` VALUES ('4', '王四', '女', '85', '65', '66', '00000000004');
INSERT INTO `scala_student` VALUES ('5', '王五', '男', '55', '85', '54', '00000000005');
INSERT INTO `scala_student` VALUES ('6', '张一', '男', '100', '95', '97', '00000000006');
INSERT INTO `scala_student` VALUES ('7', '张二', '男', '75', '18', '78', '00000000007');
INSERT INTO `scala_student` VALUES ('8', '张三', '女', '89', '75', '46', '00000000008');
INSERT INTO `scala_student` VALUES ('9', '张四', '女', '84', '98', '85', '00000000009');
INSERT INTO `scala_student` VALUES ('10', '张武', '男', '71', '75', '74', '00000000001');
INSERT INTO `scala_student` VALUES ('11', '李一', '男', '68', '62', '100', '00000000002');
INSERT INTO `scala_student` VALUES ('12', '李二', '男', '99', '91', '99', '00000000003');
INSERT INTO `scala_student` VALUES ('13', '李三', '女', '41', '100', '95', '00000000004');
INSERT INTO `scala_student` VALUES ('14', '李四', '女', '96', '87', '83', '00000000005');
INSERT INTO `scala_student` VALUES ('15', '刘一', '女', '54', '71', '89', '00000000006');
INSERT INTO `scala_student` VALUES ('16', '刘二', '男', '63', '72', '85', '00000000007');
INSERT INTO `scala_student` VALUES ('17', '刘三', '男', '63', '69', '74', '00000000008');
INSERT INTO `scala_student` VALUES ('18', '刘四', '男', '41', '85', '78', '00000000009');
INSERT INTO `scala_student` VALUES ('19', '刘五', '男', '96', '87', '98', '00000000001');
INSERT INTO `scala_student` VALUES ('20', '刘六', '女', '54', '55', '57', '00000000002');
INSERT INTO `scala_student` VALUES ('21', '赵一', '男', '67', '76', '54', '00000000003');
INSERT INTO `scala_student` VALUES ('22', '赵二', '女', '77', '97', '54', '00000000004');
INSERT INTO `scala_student` VALUES ('23', '赵三', '男', '54', '79', '54', '00000000005');
INSERT INTO `scala_student` VALUES ('24', '赵四', '女', '98', '79', '54', '00000000006');
INSERT INTO `scala_student` VALUES ('25', '赵五', '男', '98', '67', '54', '00000000007');
INSERT INTO `scala_student` VALUES ('26', '赵刘', '女', '87', '65', '54', '00000000008');
INSERT INTO `scala_student` VALUES ('27', '赵七', '男', '76', '54', '54', '00000000009');
INSERT INTO `scala_student` VALUES ('28', '赵八', '男', '65', '45', '54', '00000000001');
INSERT INTO `scala_student` VALUES ('29', '赵九', '女', '87', '45', '54', '00000000002');
INSERT INTO `scala_student` VALUES ('30', '赵十', '女', '98', '45', '54', '00000000003');
INSERT INTO `scala_student` VALUES ('31', '钱一', '女', '77', '76', '54', '00000000004');
INSERT INTO `scala_student` VALUES ('32', '钱二', '女', '67', '76', '54', '00000000005');
INSERT INTO `scala_student` VALUES ('33', '钱三', '男', '67', '76', '54', '00000000006');
INSERT INTO `scala_student` VALUES ('34', '钱四', '女', '77', '76', '54', '00000000007');
INSERT INTO `scala_student` VALUES ('35', '钱五', '女', '67', '76', '54', '00000000008');
INSERT INTO `scala_student` VALUES ('36', '钱刘', '女', '67', '76', '54', '00000000009');
INSERT INTO `scala_student` VALUES ('37', '钱七', '男', '67', '76', '54', '00000000001');
INSERT INTO `scala_student` VALUES ('38', '钱八', '女', '67', '95', '54', '00000000002');
INSERT INTO `scala_student` VALUES ('39', '钱九', '男', '67', '95', '54', '00000000003');
INSERT INTO `scala_student` VALUES ('40', '钱十', '女', '67', '95', '54', '00000000004');
INSERT INTO `scala_student` VALUES ('41', '孙一', '男', '67', '95', '54', '00000000005');
INSERT INTO `scala_student` VALUES ('42', '孙二', '男', '67', '76', '54', '00000000006');
INSERT INTO `scala_student` VALUES ('43', '孙三', '女', '67', '76', '54', '00000000007');
INSERT INTO `scala_student` VALUES ('44', '孙四', '女', '67', '76', '54', '00000000008');
INSERT INTO `scala_student` VALUES ('45', '孙五', '男', '67', '76', '54', '00000000009');
INSERT INTO `scala_student` VALUES ('46', '孙刘', '女', '31', '76', '54', '00000000001');
INSERT INTO `scala_student` VALUES ('47', '孙七', '男', '32', '76', '54', '00000000002');
INSERT INTO `scala_student` VALUES ('48', '孙八', '女', '67', '78', '54', '00000000003');
INSERT INTO `scala_student` VALUES ('49', '孙九', '男', '67', '78', '54', '00000000004');
INSERT INTO `scala_student` VALUES ('50', '孙十', '男', '45', '78', '54', '00000000005');
INSERT INTO `scala_student` VALUES ('51', '李一', '男', '78', '78', '54', '00000000006');
INSERT INTO `scala_student` VALUES ('52', '李二', '女', '67', '78', '54', '00000000007');
INSERT INTO `scala_student` VALUES ('53', '李三', '男', '98', '78', '54', '00000000008');
INSERT INTO `scala_student` VALUES ('54', '李四', '女', '89', '78', '54', '00000000009');
INSERT INTO `scala_student` VALUES ('55', '李五', '男', '67', '78', '54', '00000000001');
INSERT INTO `scala_student` VALUES ('56', '李刘', '女', '76', '78', '54', '00000000002');
INSERT INTO `scala_student` VALUES ('57', '李七', '男', '56', '78', '54', '00000000003');
INSERT INTO `scala_student` VALUES ('58', '李八', '女', '98', '54', '54', '00000000004');
INSERT INTO `scala_student` VALUES ('59', '李九', '男', '67', '78', '54', '00000000005');
INSERT INTO `scala_student` VALUES ('60', '李十', '男', '87', '78', '54', '00000000006');
INSERT INTO `scala_student` VALUES ('61', '', null, null, null, null, null);
