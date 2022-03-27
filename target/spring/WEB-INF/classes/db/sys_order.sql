/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : wollo

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 20/03/2022 21:21:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order`  (
  `id` bigint NOT NULL COMMENT '订单id',
  `ordertime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下单时间',
  `total` double NULL DEFAULT NULL COMMENT '金额',
  `uid` int NOT NULL COMMENT '所属用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order
-- ----------------------------
INSERT INTO `sys_order` VALUES (1, '1021824000000', 50000, 15);
INSERT INTO `sys_order` VALUES (2, '1021824000000', 6000, 15);
INSERT INTO `sys_order` VALUES (3, '1021824000000', 25000, 13);
INSERT INTO `sys_order` VALUES (4, '1021824000000', 35600, 1);

SET FOREIGN_KEY_CHECKS = 1;
