/*
Navicat MySQL Data Transfer

Source Server         : chaopei
Source Server Version : 50711
Source Host           : 127.0.0.1:3306
Source Database       : cxjw

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2022-05-06 08:25:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` int(5) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `cname` varchar(50) NOT NULL,
  `period` int(3) DEFAULT NULL,
  `credit` int(2) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=1016 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1001', 'kb3251', '论语导读', '75', '8');
INSERT INTO `course` VALUES ('1002', 'sk5421', '大学生安全教育', '65', '6');
INSERT INTO `course` VALUES ('1003', 'jy3421', '就业指导', '70', '6');
INSERT INTO `course` VALUES ('1004', 'gy2154', '中国近代史纲要', '75', '8');
INSERT INTO `course` VALUES ('1005', 'jk1521', '大学生心理健康', '75', '8');
INSERT INTO `course` VALUES ('1006', 'cx1028', '创新思维训练', '25', '2');
INSERT INTO `course` VALUES ('1007', 'xz1205', ' 应用文写作', '30', '3');
INSERT INTO `course` VALUES ('1008', 'mg3028', '毛泽东思想概论', '35', '4');
INSERT INTO `course` VALUES ('1009', 'cy6018', '大学生创业基础', '40', '5');
INSERT INTO `course` VALUES ('1010', 'wl3219', '网络创业基础', '20', '2');
INSERT INTO `course` VALUES ('1011', 'gs6158', '高等数学一', '75', '8');
INSERT INTO `course` VALUES ('1012', 'gs6159', '高等数学二', '75', '8');
INSERT INTO `course` VALUES ('1013', 'en5126', '大学英语一', '40', '4');
INSERT INTO `course` VALUES ('1014', 'en5127', '大学英语二', '40', '4');
INSERT INTO `course` VALUES ('1015', 'en5128', '大学英语三', '40', '4');

-- ----------------------------
-- Table structure for `course_dept`
-- ----------------------------
DROP TABLE IF EXISTS `course_dept`;
CREATE TABLE `course_dept` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `cid` int(5) NOT NULL,
  `did` int(5) NOT NULL,
  `ctype` varchar(8) DEFAULT NULL,
  `ttype` varchar(8) DEFAULT NULL,
  `status` smallint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100016 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_dept
-- ----------------------------
INSERT INTO `course_dept` VALUES ('100001', '1001', '201', ' 必修', '考试', '1');
INSERT INTO `course_dept` VALUES ('100002', '1001', '202', '公选课', '考查', '1');
INSERT INTO `course_dept` VALUES ('100003', '1002', '201', '公选课', '考查', '1');
INSERT INTO `course_dept` VALUES ('100004', '1003', '201', '限选课', '考试', '1');
INSERT INTO `course_dept` VALUES ('100005', '1004', '201', '公选课', '考查', '1');
INSERT INTO `course_dept` VALUES ('100006', '1004', '203', '必修', '考试', '1');
INSERT INTO `course_dept` VALUES ('100007', '1005', '201', '必修', '考试', '1');
INSERT INTO `course_dept` VALUES ('100008', '1006', '201', '必修', '考试', '2');
INSERT INTO `course_dept` VALUES ('100009', '1007', '201', '必修', '考试', '1');
INSERT INTO `course_dept` VALUES ('100010', '1008', '201', '公选课', '考查', '1');
INSERT INTO `course_dept` VALUES ('100011', '1009', '201', '必修', '考试', '1');
INSERT INTO `course_dept` VALUES ('100012', '1010', '201', '公选课', '考查', '1');
INSERT INTO `course_dept` VALUES ('100013', '1011', '201', '必修', '考试', '2');
INSERT INTO `course_dept` VALUES ('100014', '1012', '202', '公选课', '考查', '2');
INSERT INTO `course_dept` VALUES ('100015', '1013', '202', '必修', '考试', '2');

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `did` int(5) NOT NULL AUTO_INCREMENT,
  `dname` varchar(24) NOT NULL,
  `tel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('201', '文学院', '13120007589');
INSERT INTO `dept` VALUES ('202', '计算机学院', '13120007896');
INSERT INTO `dept` VALUES ('203', '经济管理学院', '13120007590');
