/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mysql
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : materials

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 04/12/2020 21:32:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for inputr
-- ----------------------------
DROP TABLE IF EXISTS `inputr`;
CREATE TABLE `inputr`  (
  `Ino` int(0) NOT NULL AUTO_INCREMENT,
  `Mid` int(0) NOT NULL,
  `Rid` int(0) NOT NULL,
  `count` int(0) NOT NULL,
  `value` decimal(8, 2) NULL DEFAULT NULL,
  `dateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `deal_Pid` int(0) NOT NULL,
  `save_Pid` int(0) NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Ino`) USING BTREE,
  INDEX `Mid`(`Mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inputr
-- ----------------------------
INSERT INTO `inputr` VALUES (1, 1, 1, 20, 24.00, '2019-12-19 15:45:57', 1, 3, '2');
INSERT INTO `inputr` VALUES (2, 2, 2, 10, 11.00, '2019-12-19 15:47:07', 4, 6, '2');
INSERT INTO `inputr` VALUES (3, 3, 3, 100, 130.00, '2019-12-19 15:49:24', 7, 9, '2');
INSERT INTO `inputr` VALUES (4, 1, 1, 23, 23.00, '2020-01-02 19:29:07', 1, 3, '23');
INSERT INTO `inputr` VALUES (5, 2, 1, 21, 12.00, '2020-01-03 10:36:28', 16, 35, '无212');
INSERT INTO `inputr` VALUES (8, 15, 1, 21, 12.00, '2020-01-04 14:47:26', 22, 31, '2·');
INSERT INTO `inputr` VALUES (9, 5, 1, 3, 3.00, '2020-01-04 15:23:36', 21, 35, '123');
INSERT INTO `inputr` VALUES (10, 6, 2, 123, 12.00, '2020-01-04 15:23:51', 37, 53, '12');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `Mid` int(0) NOT NULL AUTO_INCREMENT,
  `Mname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `spec` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unit` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(8, 2) NOT NULL,
  PRIMARY KEY (`Mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES (1, 'A3', 'A3', 'A3', 'A3', 1.23);
INSERT INTO `material` VALUES (2, 'B二', 'B', 'B', 'B', 1.10);
INSERT INTO `material` VALUES (3, 'C', 'C', 'C', 'C', 1.30);
INSERT INTO `material` VALUES (4, 'D', 'D', 'D', 'D', 1.40);
INSERT INTO `material` VALUES (5, 'E', 'E', 'E', 'E', 1.50);
INSERT INTO `material` VALUES (6, 'F', 'F', 'F', 'F', 1.60);
INSERT INTO `material` VALUES (13, '3', '33', '3为', '333', 3.00);
INSERT INTO `material` VALUES (15, '1请问', '1', '12313', '1', 1.00);
INSERT INTO `material` VALUES (16, '1w', '1w', '1w', '1', 1.00);
INSERT INTO `material` VALUES (17, '1o', '1p', '1', '1', 1.00);
INSERT INTO `material` VALUES (18, '2', '2', '2', '2', 2.00);
INSERT INTO `material` VALUES (19, '3', '3', '3', '3', 3.00);
INSERT INTO `material` VALUES (20, '4', '44', '4', '44', 4.00);
INSERT INTO `material` VALUES (21, '5', '55', '5', '5', 5.00);
INSERT INTO `material` VALUES (22, '6', '6', '6', '6', 6.00);
INSERT INTO `material` VALUES (42, '4', '4', '4', '4', 4.00);
INSERT INTO `material` VALUES (43, '6', '6', '6', '6', 6.00);
INSERT INTO `material` VALUES (44, '7', '7', '7', '7', 7.00);
INSERT INTO `material` VALUES (45, '8', '8', '8', '8', 8.00);
INSERT INTO `material` VALUES (46, '8', '8', '8', '8', 8.00);
INSERT INTO `material` VALUES (47, '2', '2', '2', '2', 2.00);
INSERT INTO `material` VALUES (49, '网上', '食物', '食物', '2', 1.00);
INSERT INTO `material` VALUES (50, '中午', '3额1', '单', '3', 4.00);
INSERT INTO `material` VALUES (51, '饿', '恶', '哦', '32', 3.00);
INSERT INTO `material` VALUES (52, '43', '收', '到3', '2', 2.00);
INSERT INTO `material` VALUES (53, '额3', '恶3', '额3', '2', 2.00);
INSERT INTO `material` VALUES (54, '恶', '哦', '哦', '2', 2.00);
INSERT INTO `material` VALUES (55, '额2', '23', '2哦', '2', 2.00);
INSERT INTO `material` VALUES (56, '23额', '恶', '2哦', '1', 1.00);
INSERT INTO `material` VALUES (57, '23哦', '额', '哦3', '1', 1.00);
INSERT INTO `material` VALUES (58, '额', '123额', '1额', '2', 1.00);
INSERT INTO `material` VALUES (59, '23额', '23额', '恶2', '1', 2.00);
INSERT INTO `material` VALUES (60, '恶3', '2额', '3恶', '2', 2.00);
INSERT INTO `material` VALUES (61, '23额', '2恶', '哦2', '2', 2.00);
INSERT INTO `material` VALUES (62, 'e23', '23e', '2', '3', 3.00);
INSERT INTO `material` VALUES (65, 'hy', 'hy', 'fg', '2', 43.00);

-- ----------------------------
-- Table structure for outputr
-- ----------------------------
DROP TABLE IF EXISTS `outputr`;
CREATE TABLE `outputr`  (
  `Ono` int(0) NOT NULL AUTO_INCREMENT,
  `Mid` int(0) NOT NULL,
  `Rid` int(0) NOT NULL,
  `count` int(0) NOT NULL,
  `value` decimal(8, 2) NOT NULL,
  `dateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `user_Pid` int(0) NOT NULL,
  `deal_Pid` int(0) NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Ono`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of outputr
-- ----------------------------
INSERT INTO `outputr` VALUES (1, 1, 1, 10, 12.00, '2019-12-19 15:50:43', 2, 1, '2');
INSERT INTO `outputr` VALUES (2, 2, 2, 5, 5.50, '2019-12-19 15:51:24', 5, 4, '1');
INSERT INTO `outputr` VALUES (3, 3, 3, 50, 65.00, '2019-12-19 15:52:21', 8, 7, '12');
INSERT INTO `outputr` VALUES (4, 15, 5, 432, 12.00, '2020-01-03 11:10:36', 14, 13, '32');
INSERT INTO `outputr` VALUES (5, 1, 1, 1, 21.00, '2020-01-03 14:46:39', 26, 18, '12');
INSERT INTO `outputr` VALUES (6, 2, 2, 12, 12.00, '2020-01-03 14:46:46', 44, 40, '3');
INSERT INTO `outputr` VALUES (9, 2, 3, 1, 1.00, '2020-01-03 14:47:09', 8, 7, '21');
INSERT INTO `outputr` VALUES (10, 1, 1, 2, 1.00, '2020-01-04 16:41:45', 23, 17, '武器');
INSERT INTO `outputr` VALUES (11, 1, 2, 23, 232.00, '2020-01-04 16:42:03', 44, 39, '32');
INSERT INTO `outputr` VALUES (12, 1, 2, 324, 324.00, '2020-01-04 16:43:06', 44, 40, '234');
INSERT INTO `outputr` VALUES (13, 1, 4, 1, 2.00, '2020-01-04 16:44:24', 11, 10, '1');
INSERT INTO `outputr` VALUES (14, 1, 4, 1, 12.00, '2020-01-04 16:46:00', 11, 10, '2');
INSERT INTO `outputr` VALUES (15, 1, 4, 32, 123.00, '2020-01-04 16:47:32', 11, 10, '123');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `Pid` int(0) NOT NULL AUTO_INCREMENT,
  `Ptype` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Pname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Rid` int(0) NOT NULL,
  PRIMARY KEY (`Pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (1, '处理人', '处1', 1);
INSERT INTO `person` VALUES (2, '领取人', '领1', 1);
INSERT INTO `person` VALUES (3, '保管人', '保1', 1);
INSERT INTO `person` VALUES (4, '处理人', '处2', 2);
INSERT INTO `person` VALUES (5, '领取人', '领2', 2);
INSERT INTO `person` VALUES (6, '保管人', '保2', 2);
INSERT INTO `person` VALUES (7, '处理人', '处3', 3);
INSERT INTO `person` VALUES (8, '领取人', '领3Update1', 3);
INSERT INTO `person` VALUES (9, '保管人', '保3', 3);
INSERT INTO `person` VALUES (10, '处理人', '阿林', 4);
INSERT INTO `person` VALUES (11, '领取人', '阿楠', 4);
INSERT INTO `person` VALUES (12, '保管人', '阿力', 4);
INSERT INTO `person` VALUES (13, '处理人', '阿兴', 5);
INSERT INTO `person` VALUES (14, '领取人', '阿威', 5);
INSERT INTO `person` VALUES (15, '保管人', '阿坤2', 5);
INSERT INTO `person` VALUES (16, '处理人', '阿志', 1);
INSERT INTO `person` VALUES (17, '处理人', '处12', 1);
INSERT INTO `person` VALUES (18, '处理人', '处13', 1);
INSERT INTO `person` VALUES (19, '处理人', '处13', 1);
INSERT INTO `person` VALUES (20, '处理人', '处14', 1);
INSERT INTO `person` VALUES (21, '处理人', '处15', 1);
INSERT INTO `person` VALUES (22, '处理人', '处11', 1);
INSERT INTO `person` VALUES (23, '领取人', '领11', 1);
INSERT INTO `person` VALUES (24, '领取人', '领12', 1);
INSERT INTO `person` VALUES (25, '领取人', '领13', 1);
INSERT INTO `person` VALUES (26, '领取人', '领14', 1);
INSERT INTO `person` VALUES (27, '领取人', '领15', 1);
INSERT INTO `person` VALUES (28, '领取人', '领16', 1);
INSERT INTO `person` VALUES (29, '处理人', '处16', 1);
INSERT INTO `person` VALUES (30, '保管人', '保11', 1);
INSERT INTO `person` VALUES (31, '保管人', '保12', 1);
INSERT INTO `person` VALUES (32, '保管人', '保13', 1);
INSERT INTO `person` VALUES (33, '保管人', '保14', 1);
INSERT INTO `person` VALUES (34, '保管人', '保15', 1);
INSERT INTO `person` VALUES (35, '保管人', '保16', 1);
INSERT INTO `person` VALUES (36, '处理人', '处21', 2);
INSERT INTO `person` VALUES (37, '处理人', '处22', 2);
INSERT INTO `person` VALUES (38, '处理人', '处23', 2);
INSERT INTO `person` VALUES (39, '处理人', '处34', 2);
INSERT INTO `person` VALUES (40, '处理人', '处25', 2);
INSERT INTO `person` VALUES (41, '处理人', '处26', 2);
INSERT INTO `person` VALUES (42, '领取人', '领21', 2);
INSERT INTO `person` VALUES (43, '领取人', '领22', 2);
INSERT INTO `person` VALUES (44, '领取人', '领23', 2);
INSERT INTO `person` VALUES (45, '领取人', '领24', 2);
INSERT INTO `person` VALUES (46, '领取人', '领25', 2);
INSERT INTO `person` VALUES (47, '领取人', '领26', 2);
INSERT INTO `person` VALUES (48, '保管人', '保21', 2);
INSERT INTO `person` VALUES (49, '保管人', '保22', 2);
INSERT INTO `person` VALUES (50, '保管人', '保23', 2);
INSERT INTO `person` VALUES (51, '保管人', '保24', 2);
INSERT INTO `person` VALUES (52, '保管人', '保25', 2);
INSERT INTO `person` VALUES (53, '保管人', '保26', 2);
INSERT INTO `person` VALUES (54, '领取人', '领21', 2);
INSERT INTO `person` VALUES (55, '领取人', '领22', 2);
INSERT INTO `person` VALUES (56, '领取人', '领23', 2);
INSERT INTO `person` VALUES (57, '领取人', '领24', 2);

-- ----------------------------
-- Table structure for repository
-- ----------------------------
DROP TABLE IF EXISTS `repository`;
CREATE TABLE `repository`  (
  `Rid` int(0) NOT NULL AUTO_INCREMENT,
  `Rname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repository
-- ----------------------------
INSERT INTO `repository` VALUES (1, '1号库', '王企鹅');
INSERT INTO `repository` VALUES (2, '2号库', '额');
INSERT INTO `repository` VALUES (3, '3号库', '32');
INSERT INTO `repository` VALUES (4, '4号库', '32');
INSERT INTO `repository` VALUES (5, '5号库', '32');

-- ----------------------------
-- Table structure for rest
-- ----------------------------
DROP TABLE IF EXISTS `rest`;
CREATE TABLE `rest`  (
  `Mid` int(0) NOT NULL,
  `Rid` int(0) NOT NULL,
  `count` int(0) NOT NULL,
  `value` decimal(8, 2) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Mid`, `Rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rest
-- ----------------------------
INSERT INTO `rest` VALUES (1, 1, 10, 12.00, NULL);
INSERT INTO `rest` VALUES (2, 2, 5, 5.50, NULL);
INSERT INTO `rest` VALUES (3, 3, 50, 65.00, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uId` int(0) NOT NULL AUTO_INCREMENT,
  `uName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uPwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` int(0) NOT NULL,
  `actualName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UserSex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uId`) USING BTREE,
  UNIQUE INDEX `uName`(`uName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'neverBetray1', '111', 0, 'wxl', '男', '1414141', '/upload/imgs/img20191228182733.jpg');
INSERT INTO `user` VALUES (2, '食物', '2', 0, '阿林', '男', '1我期待群无多·', '/upload/imgs/img20191229211936.jpg');
INSERT INTO `user` VALUES (3, '而且', '3', 0, '3', '女', '123', '/upload/imgs/img20191229182446.jpg');
INSERT INTO `user` VALUES (61, '123', '123', 1, '9809', '女', '0890980890', '/upload/imgs/img20191229212117.jpg');
INSERT INTO `user` VALUES (64, '加密test01', '$2a$10$XHX/sXhrbfn8r.jSpyTja.0g9mJc5qYoWllK0uKAS2AK/ds3O/s8O', 1, '加密test01', '女', '加密test01加密test01加密test01', '/upload/imgs/img20191230115541.jpg');
INSERT INTO `user` VALUES (65, '加密test02', '$2a$10$ts0PlJvm7pqS4Dw4GaFaouMV5lXDqDXFjC584pb5MgaAVHt6QUrxG', 1, '加密test02', '女', '加密test02', '/upload/imgs/img20191230123504.jpg');
INSERT INTO `user` VALUES (66, '加密test03', '$2a$10$PQpsFHg1QwG5caHeDMVATuj/89zzF5Dzxx1LmjEwWprtgUseZWZau', 1, '加密test03', '女', '加密test03加密test03vvvv1', '/upload/imgs/img20191230123940.jpg');
INSERT INTO `user` VALUES (67, 'neverBetray', '$2a$10$DyXZDJzc3gY5tt2d7SjJZeCGDMP03tQ5HfwiBETeQDRKxOuWJ72xO', 1, 'wxl', '女', '地区为多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多付群多多多多多多多哒哒哒哒哒哒多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多', '/upload/imgs/img20191231191702.jpg');
INSERT INTO `user` VALUES (68, 'test1', '$2a$10$wsO5W169aH.IyHWt8omuvuWwLCrbZqZBsHpR/wvnRV7sYHbl7rdZm', 1, '武器', '女', '位', '/upload/imgs/img20191231192634.jpg');
INSERT INTO `user` VALUES (69, 'test02', '$2a$10$MAJQ7HqyzRwJUj7iMa1pOuodHFo7CHN71g0flmwpaBAG1LRyCQUaK', 1, '是阿林呀', '男', '打撒奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥奥二无', '/upload/imgs/img20200101095946.jpg');
INSERT INTO `user` VALUES (72, 'test3', '$2a$10$8.I35j4HFTLuVzQh6ks6OOeQeR/xWoUo3mkaef8QWe70cPu6HZ3QW', 1, '单位分为非', '男', '地区为的无单位单位翁的无多群无所群无所群无所的味道非法违法', '/upload/imgs/img20200101102200.jpg');
INSERT INTO `user` VALUES (73, 'test4', '$2a$10$Lx69TWfrghgpalWLBZnFzevAG/xnT1o8dVgCWKiRwLk7tIOoPcq42', 1, '服务费', '男', '单位房翁风多群无无无无无无无无无无无无无无无无无无无无无无无无无无无无无付群二群无无无无无无无无无无无无无无无无无若付群二', '/upload/imgs/img20200101102629.jpg');
INSERT INTO `user` VALUES (74, '作者', '$2a$10$wJ5YiMJysI7/YsbfnHvAHOX3A2VpaW5SLN893knwdkYnmbWW/aOPS', 1, '密码：root', '男', 'This account belongs to :帅气的作者!', '/upload/imgs/img20201204212957.jpg');
INSERT INTO `user` VALUES (75, 'test5', '$2a$10$dpcM0qZVi8cpsh7/J/Qw4OTJ46yV8sadW53X7xGnzdIe5EckKFJum', 0, '带我去', '女', '单位单位多翁的无多翁的无多', '/upload/imgs/img20200101161352.jpg');

SET FOREIGN_KEY_CHECKS = 1;
