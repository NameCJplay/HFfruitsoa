/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost:3306
 Source Schema         : fms

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 08/09/2020 21:27:23
*/

CREATE DATABASE IF NOT EXISTS fms default charset utf8 COLLATE utf8_general_ci;

-- 切换数据库
use fms;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hf_classify
-- ----------------------------
DROP TABLE IF EXISTS `hf_classify`;
CREATE TABLE `hf_classify`  (
  `classify_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `classify_parentid` bigint(20) NULL DEFAULT 0 COMMENT '上级id',
  `classify_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`classify_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hf_classify
-- ----------------------------
INSERT INTO `hf_classify` VALUES (3, 0, '苹果');
INSERT INTO `hf_classify` VALUES (4, 0, '梨子');
INSERT INTO `hf_classify` VALUES (5, 0, '西瓜');
INSERT INTO `hf_classify` VALUES (22, 5, '瓜');
INSERT INTO `hf_classify` VALUES (23, 0, '葡萄');
INSERT INTO `hf_classify` VALUES (24, 0, '车厘子');

-- ----------------------------
-- Table structure for hf_dept
-- ----------------------------
DROP TABLE IF EXISTS `hf_dept`;
CREATE TABLE `hf_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_parentid` bigint(20) NULL DEFAULT NULL COMMENT '上级部门',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `dept_address` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所在地址',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hf_dept
-- ----------------------------
INSERT INTO `hf_dept` VALUES (1, 0, '云景嘉园常宁总部', '湖南省 衡阳市 常宁市');
INSERT INTO `hf_dept` VALUES (2, 1, '泉峰市场部', '湖南省 衡阳市 常宁市');
INSERT INTO `hf_dept` VALUES (17, 0, '锦灿嘉园衡阳总部', '湖南省 衡阳市 珠晖区');
INSERT INTO `hf_dept` VALUES (18, 17, '解放西路衡阳店', '湖南省 衡阳市 衡阳县');
INSERT INTO `hf_dept` VALUES (19, 21, '望城区高裕南路部', '湖南省 长沙市 望城区');
INSERT INTO `hf_dept` VALUES (21, 0, '望城区高裕南路部', '湖南省 长沙市 望城区');
INSERT INTO `hf_dept` VALUES (23, 1, '常宁部', '湖南省 衡阳市 耒阳市');

-- ----------------------------
-- Table structure for hf_fruits
-- ----------------------------
DROP TABLE IF EXISTS `hf_fruits`;
CREATE TABLE `hf_fruits`  (
  `fruits_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `fruits_classify_id` bigint(20) NULL DEFAULT NULL COMMENT '商品所属分类id',
  `fruits_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `fruits_cprice` double NOT NULL COMMENT '成本价',
  `fruits_price` double NOT NULL COMMENT '单价',
  `fruits_unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '单位',
  `fruits_stock` int(11) NOT NULL COMMENT '库存',
  `fruits_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片',
  `fruits_create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `fruits_maturity_date` datetime(0) NULL DEFAULT NULL COMMENT '预计到期时间',
  `fruits_supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '供应商+电话',
  `fruits_hot` tinyint(4) NULL DEFAULT 1 COMMENT '1：热销  2：非热销',
  `fruits_status` tinyint(4) NULL DEFAULT 1 COMMENT '1：正常  2：停售  3：已售空',
  PRIMARY KEY (`fruits_id`) USING BTREE,
  INDEX `fruits_classify`(`fruits_classify_id`) USING BTREE,
  CONSTRAINT `fruits_classify` FOREIGN KEY (`fruits_classify_id`) REFERENCES `hf_classify` (`classify_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hf_fruits
-- ----------------------------
INSERT INTO `hf_fruits` VALUES (1, 5, '麒麟西瓜', 1.5, 3, '斤', 1995, '3d0a85bf-0af4-410b-a557-d4409d77c62f.jpg', '2019-12-29 19:10:00', '2020-01-13 19:10:00', '曾兵13054055899', 1, 1);
INSERT INTO `hf_fruits` VALUES (45, 4, '天山雪梨', 2, 6, '斤', 1996, '06e3e2d8-709c-4419-a606-2e2a9175cb0c.jpg', '2019-12-29 21:27:00', '2020-01-01 21:27:00', '曾兵13225689856', 1, 1);
INSERT INTO `hf_fruits` VALUES (46, 3, '冰糖苹果', 3, 7, '斤', 1998, '9a94fb3c-da80-46cc-bb51-fd8eb19f6d8b.jpg', '2019-12-29 15:36:00', '2020-01-07 15:36:00', '曾兵13225689856', 1, 1);
INSERT INTO `hf_fruits` VALUES (47, 4, '新疆香梨', 2, 6, '斤', 1979, '465fde77-6d68-4b78-881f-21d656e6807f.jpg', '2019-12-29 17:04:00', '2020-01-08 17:04:00', '曾兵13225689856', 1, 1);
INSERT INTO `hf_fruits` VALUES (59, 3, '阿克苏苹果', 3, 8, '斤', 1998, 'dbf1bd0a-9297-428e-b9c3-25a957f8d3ab.jpg', '2019-12-29 21:02:00', '2020-01-10 21:02:00', '曾兵13225689856', 1, 1);
INSERT INTO `hf_fruits` VALUES (60, 23, '巨峰葡萄', 5, 28, '斤', 1994, '7cbe1cb7-28f8-47c3-9b86-e0ec6ccdd241.jpg', '2019-12-29 19:13:00', '2020-08-07 19:13:00', '曾兵13225689856', 1, 1);
INSERT INTO `hf_fruits` VALUES (61, 24, '加州车厘子', 99, 188, '斤', 1996, '6ab3a76e-3e06-46fe-bd4c-1d762f882e0d.jpg', '2020-08-09 15:30:56', '2020-08-10 15:30:56', '曾兵13225689856', 1, 1);

-- ----------------------------
-- Table structure for hf_notify
-- ----------------------------
DROP TABLE IF EXISTS `hf_notify`;
CREATE TABLE `hf_notify`  (
  `notify_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `notify_user_id` bigint(20) NOT NULL COMMENT '发布者id',
  `notify_thatuser` bigint(20) NOT NULL DEFAULT 0 COMMENT '接受者id',
  `notify_title` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `notify_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '类型',
  `notify_content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `notify_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注信息',
  `notify_create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `notify_update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`notify_id`) USING BTREE,
  INDEX `user_notify`(`notify_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '通知通告' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hf_notify
-- ----------------------------
INSERT INTO `hf_notify` VALUES (1, 1001, 0, '开门大吉', '1', '热烈庆祝鸿发水果店开业', NULL, '2020-05-20 20:35:42', '2020-05-20 20:35:44');
INSERT INTO `hf_notify` VALUES (2, 1001, 0, '关于水果种类', '2', '苹果梨子哇啊', '明天有榴莲', '2020-05-20 20:36:23', '2020-05-22 22:30:21');
INSERT INTO `hf_notify` VALUES (4, 1001, 0, NULL, '1', '而后龟儿会儿ui赫瑞根和瑞鹤', '21', NULL, '2020-05-22 22:31:34');
INSERT INTO `hf_notify` VALUES (14, 1001, 0, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hf_notify` VALUES (20, 1001, 0, NULL, '5', NULL, NULL, NULL, '2020-08-09 14:37:33');
INSERT INTO `hf_notify` VALUES (23, 1001, 0, '哈哈哈哈', '2', '我回家啦\r\n我会家啦', '我回家啦\r\n我会家啦', '2020-08-11 20:45:52', '2020-08-11 20:45:52');

-- ----------------------------
-- Table structure for hf_notify_file
-- ----------------------------
DROP TABLE IF EXISTS `hf_notify_file`;
CREATE TABLE `hf_notify_file`  (
  `file_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `file_notify_id` bigint(20) NOT NULL COMMENT '消息编号',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '存储路径',
  `file_filename` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '存储文件名',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文件名',
  PRIMARY KEY (`file_id`) USING BTREE,
  INDEX `file_notify`(`file_notify_id`) USING BTREE,
  CONSTRAINT `file_notify` FOREIGN KEY (`file_notify_id`) REFERENCES `hf_notify` (`notify_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '通知通告' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hf_notify_file
-- ----------------------------
INSERT INTO `hf_notify_file` VALUES (58, 23, 'D:/框架/毕业项目/kkFileView-2.2.0/file/NotifyFIle/', '31c81500-9e75-446e-ab8f-95f19b915fcb.jpg', 'image.jpg');

-- ----------------------------
-- Table structure for hf_orders
-- ----------------------------
DROP TABLE IF EXISTS `hf_orders`;
CREATE TABLE `hf_orders`  (
  `orders_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `orders_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单编号',
  `orders_user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `orders_dept_id` bigint(20) NOT NULL COMMENT '部门编号',
  `orders_gross` double NOT NULL COMMENT '总金额',
  `orders_discount` double NULL DEFAULT NULL COMMENT '折扣',
  `orders_dcprice` double NULL DEFAULT NULL COMMENT '折扣价格',
  `orders_profit` double NOT NULL COMMENT '利润',
  `orders_create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `orders_maturity_date` datetime(0) NULL DEFAULT NULL COMMENT '更改时间',
  `orders_status` tinyint(4) NULL DEFAULT 1 COMMENT '交易状态 1：待付款 2：已付款 3：交易成功 4：交易取消',
  PRIMARY KEY (`orders_id`, `orders_number`) USING BTREE,
  INDEX `user_orders`(`orders_user_id`) USING BTREE,
  INDEX `dept_orders`(`orders_dept_id`) USING BTREE,
  CONSTRAINT `dept_orders` FOREIGN KEY (`orders_dept_id`) REFERENCES `hf_dept` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_orders` FOREIGN KEY (`orders_user_id`) REFERENCES `hf_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hf_orders
-- ----------------------------
INSERT INTO `hf_orders` VALUES (8, '1000000995726122', 1001, 1, 2.5, 1, 2.5, 1.3, '2020-08-07 21:44:58', '2020-08-07 21:44:58', 2);
INSERT INTO `hf_orders` VALUES (9, '1000001839799525', 1001, 1, 2.5, 1, 2.5, 1.3, '2020-08-07 21:59:43', '2020-08-07 21:59:43', 2);
INSERT INTO `hf_orders` VALUES (10, '1000001590219760', 1001, 1, 40, 0.95, 38, 16.599999999999998, '2020-08-07 22:09:18', '2020-08-07 22:09:18', 2);
INSERT INTO `hf_orders` VALUES (11, '1000001898986513', 1001, 1, 40, 0.85, 34, 12.6, '2020-08-07 22:14:38', '2020-08-07 22:14:38', 2);
INSERT INTO `hf_orders` VALUES (12, '1000000877383470', 1001, 1, 89, 0.95, 89, 32.55, '2020-08-07 22:16:27', '2020-08-07 22:16:27', 2);
INSERT INTO `hf_orders` VALUES (13, '1000000727706140', 1001, 1, 2.5, 1, 2.5, 1.3, '2020-08-08 09:26:41', '2020-08-08 09:26:41', 2);
INSERT INTO `hf_orders` VALUES (14, '1000001330422062', 1001, 1, 2.5, 1, 2.5, 1.3, '2020-08-08 09:28:27', '2020-08-08 09:28:27', 2);
INSERT INTO `hf_orders` VALUES (15, '1000001863653784', 1001, 1, 2.5, 1, 2.5, 1.3, '2020-08-08 09:29:04', '2020-08-08 09:29:04', 2);
INSERT INTO `hf_orders` VALUES (16, '1000000536656745', 1001, 1, 0.5, 1, 0.5, 0.3, '2020-08-08 09:29:45', '2020-08-08 09:29:45', 2);
INSERT INTO `hf_orders` VALUES (17, '1000001787698927', 1001, 1, 0.5, 1, 0.5, 0.3, '2020-08-08 09:36:28', '2020-08-08 09:36:28', 2);
INSERT INTO `hf_orders` VALUES (18, '1000001129910164', 1001, 1, 40, 0.95, 38, 16.6, '2020-08-08 10:15:48', '2020-08-08 10:15:48', 2);
INSERT INTO `hf_orders` VALUES (19, '1000000905061451', 1001, 1, 40, 0.9, 36, 14.600000000000001, '2020-08-08 19:12:52', '2020-08-08 19:12:52', 2);
INSERT INTO `hf_orders` VALUES (20, '1000001751368994', 1001, 1, 40, 1, 40, 18.6, '2020-08-08 19:13:00', '2020-08-08 19:13:00', 2);
INSERT INTO `hf_orders` VALUES (21, '1000000829595512', 1001, 1, 27.5, 0.7, 19.25, 8.049999999999999, '2020-08-08 19:13:09', '2020-08-08 19:13:09', 2);
INSERT INTO `hf_orders` VALUES (22, '1000001498150283', 1001, 1, 40, 1, 40, 18.6, '2020-08-08 19:13:30', '2020-08-08 19:13:30', 2);
INSERT INTO `hf_orders` VALUES (23, '1000001972300460', 1001, 1, 280, 1, 280, 166, '2020-08-08 19:14:06', '2020-08-08 19:14:06', 2);
INSERT INTO `hf_orders` VALUES (24, '1000001593963977', 1001, 1, 2590, 1, 2590, 1501, '2020-08-08 19:16:17', '2020-08-08 19:16:17', 2);
INSERT INTO `hf_orders` VALUES (25, '1000001854944285', 1001, 1, 157, 1, 157, 125.5, '2020-08-09 14:13:50', '2020-08-09 14:13:50', 2);
INSERT INTO `hf_orders` VALUES (26, '1000000343714456', 1001, 1, 376, 0.9, 338.4, 140.4, '2020-08-09 15:31:19', '2020-08-09 15:31:19', 2);
INSERT INTO `hf_orders` VALUES (27, '1000001946456362', 1001, 1, 197, 0.9, 177.3, 74.8, '2020-08-12 19:30:29', '2020-08-12 19:30:29', 2);
INSERT INTO `hf_orders` VALUES (28, '1000002084787135', 1001, 1, 120, 1, 120, 80, '2020-08-13 22:13:56', '2020-08-13 22:13:56', 2);
INSERT INTO `hf_orders` VALUES (29, '1000001287913558', 1001, 1, 246, 0.95, 233.7, 118.2, '2020-08-14 21:10:56', '2020-08-14 21:10:56', 2);
INSERT INTO `hf_orders` VALUES (30, '1000001161424725', 1001, 1, 16, 1, 16, 9.5, '2020-09-01 22:11:28', '2020-09-01 22:11:28', 2);
INSERT INTO `hf_orders` VALUES (31, '1000001250494590', 1001, 1, 3, 1, 3, 1.5, '2020-09-07 21:24:09', '2020-09-07 21:24:09', 2);

-- ----------------------------
-- Table structure for hf_orders_details
-- ----------------------------
DROP TABLE IF EXISTS `hf_orders_details`;
CREATE TABLE `hf_orders_details`  (
  `details_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `details_ordersnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单编号',
  `details_fruitsid` bigint(20) NOT NULL COMMENT '商品编号',
  `details_fruitsname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `details_count` double NOT NULL COMMENT '商品数量',
  `details_price` double NOT NULL COMMENT '商品价格',
  `details_gross` double NOT NULL COMMENT '合计',
  `details_discount` double NULL DEFAULT NULL COMMENT '折扣',
  `details_dcprice` double NOT NULL COMMENT '折扣后价格',
  `details_cprice` double NOT NULL COMMENT '商品成本价',
  `details_profit` double NOT NULL COMMENT '利润',
  PRIMARY KEY (`details_id`, `details_ordersnumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hf_orders_details
-- ----------------------------
INSERT INTO `hf_orders_details` VALUES (5, '1000000995726122', 1, '麒麟西瓜', 1, 0.5, 0.5, 1, 0.5, 0.2, 0.3);
INSERT INTO `hf_orders_details` VALUES (6, '1000000995726122', 45, '天山雪梨', 1, 2, 2, 1, 2, 1, 1);
INSERT INTO `hf_orders_details` VALUES (7, '1000001839799525', 45, '天山雪梨', 1, 2, 2, 1, 2, 1, 1);
INSERT INTO `hf_orders_details` VALUES (8, '1000001839799525', 1, '麒麟西瓜', 1, 0.5, 0.5, 1, 0.5, 0.2, 0.3);
INSERT INTO `hf_orders_details` VALUES (9, '1000001590219760', 1, '麒麟西瓜', 1, 0.5, 0.5, 0.95, 0.475, 0.2, 0.27499999999999997);
INSERT INTO `hf_orders_details` VALUES (10, '1000001590219760', 59, '阿克苏苹果', 1, 12, 12, 0.95, 11.399999999999999, 5, 6.399999999999999);
INSERT INTO `hf_orders_details` VALUES (11, '1000001590219760', 45, '天山雪梨', 1, 2, 2, 0.95, 1.9, 1, 0.8999999999999999);
INSERT INTO `hf_orders_details` VALUES (12, '1000001590219760', 46, '冰糖苹果', 1, 0.5, 0.5, 0.95, 0.475, 0.2, 0.27499999999999997);
INSERT INTO `hf_orders_details` VALUES (13, '1000001590219760', 60, '巨峰葡萄', 1, 13, 13, 0.95, 12.35, 5, 7.35);
INSERT INTO `hf_orders_details` VALUES (14, '1000001590219760', 47, '新疆香梨', 1, 12, 12, 0.95, 11.399999999999999, 10, 1.3999999999999986);
INSERT INTO `hf_orders_details` VALUES (15, '1000001898986513', 1, '麒麟西瓜', 1, 0.5, 0.5, 0.85, 0.425, 0.2, 0.22499999999999998);
INSERT INTO `hf_orders_details` VALUES (16, '1000001898986513', 45, '天山雪梨', 1, 2, 2, 0.85, 1.7, 1, 0.7);
INSERT INTO `hf_orders_details` VALUES (17, '1000001898986513', 46, '冰糖苹果', 1, 0.5, 0.5, 0.85, 0.425, 0.2, 0.22499999999999998);
INSERT INTO `hf_orders_details` VALUES (18, '1000001898986513', 47, '新疆香梨', 1, 12, 12, 0.85, 10.2, 10, 0.1999999999999993);
INSERT INTO `hf_orders_details` VALUES (19, '1000001898986513', 60, '巨峰葡萄', 1, 13, 13, 0.85, 11.05, 5, 6.050000000000001);
INSERT INTO `hf_orders_details` VALUES (20, '1000001898986513', 59, '阿克苏苹果', 1, 12, 12, 0.85, 10.2, 5, 5.199999999999999);
INSERT INTO `hf_orders_details` VALUES (21, '1000000877383470', 1, '麒麟西瓜', 6, 0.5, 3, 0.95, 2.85, 1.2, 1.65);
INSERT INTO `hf_orders_details` VALUES (22, '1000000877383470', 45, '天山雪梨', 5, 2, 10, 0.95, 9.5, 5, 4.5);
INSERT INTO `hf_orders_details` VALUES (23, '1000000877383470', 46, '冰糖苹果', 4, 0.5, 2, 0.95, 1.9, 0.8, 1.1);
INSERT INTO `hf_orders_details` VALUES (24, '1000000877383470', 47, '新疆香梨', 3, 12, 36, 0.95, 34.2, 30, 4.2);
INSERT INTO `hf_orders_details` VALUES (25, '1000000877383470', 60, '巨峰葡萄', 2, 13, 26, 0.95, 24.7, 10, 14.7);
INSERT INTO `hf_orders_details` VALUES (26, '1000000877383470', 59, '阿克苏苹果', 1, 12, 12, 0.95, 11.4, 5, 6.4);
INSERT INTO `hf_orders_details` VALUES (27, '1000000727706140', 1, '麒麟西瓜', 1, 0.5, 0.5, 1, 0.5, 0.2, 0.3);
INSERT INTO `hf_orders_details` VALUES (28, '1000000727706140', 45, '天山雪梨', 1, 2, 2, 1, 2, 1, 1);
INSERT INTO `hf_orders_details` VALUES (29, '1000001330422062', 1, '麒麟西瓜', 1, 0.5, 0.5, 1, 0.5, 0.2, 0.3);
INSERT INTO `hf_orders_details` VALUES (30, '1000001330422062', 45, '天山雪梨', 1, 2, 2, 1, 2, 1, 1);
INSERT INTO `hf_orders_details` VALUES (31, '1000001863653784', 1, '麒麟西瓜', 1, 0.5, 0.5, 1, 0.5, 0.2, 0.3);
INSERT INTO `hf_orders_details` VALUES (32, '1000001863653784', 45, '天山雪梨', 1, 2, 2, 1, 2, 1, 1);
INSERT INTO `hf_orders_details` VALUES (33, '1000000536656745', 1, '麒麟西瓜', 1, 0.5, 0.5, 1, 0.5, 0.2, 0.3);
INSERT INTO `hf_orders_details` VALUES (34, '1000001787698927', 1, '麒麟西瓜', 1, 0.5, 0.5, 1, 0.5, 0.2, 0.3);
INSERT INTO `hf_orders_details` VALUES (35, '1000001129910164', 1, '麒麟西瓜', 1, 0.5, 0.5, 0.95, 0.475, 0.2, 0.275);
INSERT INTO `hf_orders_details` VALUES (36, '1000001129910164', 45, '天山雪梨', 1, 2, 2, 0.95, 1.9, 1, 0.9);
INSERT INTO `hf_orders_details` VALUES (37, '1000001129910164', 46, '冰糖苹果', 1, 0.5, 0.5, 0.95, 0.475, 0.2, 0.275);
INSERT INTO `hf_orders_details` VALUES (38, '1000001129910164', 47, '新疆香梨', 1, 12, 12, 0.95, 11.4, 10, 1.4);
INSERT INTO `hf_orders_details` VALUES (39, '1000001129910164', 60, '巨峰葡萄', 1, 13, 13, 0.95, 12.35, 5, 7.35);
INSERT INTO `hf_orders_details` VALUES (40, '1000001129910164', 59, '阿克苏苹果', 1, 12, 12, 0.95, 11.4, 5, 6.4);
INSERT INTO `hf_orders_details` VALUES (41, '1000000905061451', 1, '麒麟西瓜', 1, 0.5, 0.5, 0.9, 0.45, 0.2, 0.25);
INSERT INTO `hf_orders_details` VALUES (42, '1000000905061451', 45, '天山雪梨', 1, 2, 2, 0.9, 1.8, 1, 0.8);
INSERT INTO `hf_orders_details` VALUES (43, '1000000905061451', 46, '冰糖苹果', 1, 0.5, 0.5, 0.9, 0.45, 0.2, 0.25);
INSERT INTO `hf_orders_details` VALUES (44, '1000000905061451', 47, '新疆香梨', 1, 12, 12, 0.9, 10.8, 10, 0.8);
INSERT INTO `hf_orders_details` VALUES (45, '1000000905061451', 59, '阿克苏苹果', 1, 12, 12, 0.9, 10.8, 5, 5.8);
INSERT INTO `hf_orders_details` VALUES (46, '1000000905061451', 60, '巨峰葡萄', 1, 13, 13, 0.9, 11.7, 5, 6.7);
INSERT INTO `hf_orders_details` VALUES (47, '1000001751368994', 1, '麒麟西瓜', 1, 0.5, 0.5, 1, 0.5, 0.2, 0.3);
INSERT INTO `hf_orders_details` VALUES (48, '1000001751368994', 45, '天山雪梨', 1, 2, 2, 1, 2, 1, 1);
INSERT INTO `hf_orders_details` VALUES (49, '1000001751368994', 46, '冰糖苹果', 1, 0.5, 0.5, 1, 0.5, 0.2, 0.3);
INSERT INTO `hf_orders_details` VALUES (50, '1000001751368994', 47, '新疆香梨', 1, 12, 12, 1, 12, 10, 2);
INSERT INTO `hf_orders_details` VALUES (51, '1000001751368994', 60, '巨峰葡萄', 1, 13, 13, 1, 13, 5, 8);
INSERT INTO `hf_orders_details` VALUES (52, '1000001751368994', 59, '阿克苏苹果', 1, 12, 12, 1, 12, 5, 7);
INSERT INTO `hf_orders_details` VALUES (53, '1000000829595512', 1, '麒麟西瓜', 1, 0.5, 0.5, 0.7, 0.35, 0.2, 0.15);
INSERT INTO `hf_orders_details` VALUES (54, '1000000829595512', 59, '阿克苏苹果', 1, 12, 12, 0.7, 8.4, 5, 3.4);
INSERT INTO `hf_orders_details` VALUES (55, '1000000829595512', 60, '巨峰葡萄', 1, 13, 13, 0.7, 9.1, 5, 4.1);
INSERT INTO `hf_orders_details` VALUES (56, '1000000829595512', 45, '天山雪梨', 1, 2, 2, 0.7, 1.4, 1, 0.4);
INSERT INTO `hf_orders_details` VALUES (57, '1000001498150283', 1, '麒麟西瓜', 1, 0.5, 0.5, 1, 0.5, 0.2, 0.3);
INSERT INTO `hf_orders_details` VALUES (58, '1000001498150283', 46, '冰糖苹果', 1, 0.5, 0.5, 1, 0.5, 0.2, 0.3);
INSERT INTO `hf_orders_details` VALUES (59, '1000001498150283', 45, '天山雪梨', 1, 2, 2, 1, 2, 1, 1);
INSERT INTO `hf_orders_details` VALUES (60, '1000001498150283', 47, '新疆香梨', 1, 12, 12, 1, 12, 10, 2);
INSERT INTO `hf_orders_details` VALUES (61, '1000001498150283', 60, '巨峰葡萄', 1, 13, 13, 1, 13, 5, 8);
INSERT INTO `hf_orders_details` VALUES (62, '1000001498150283', 59, '阿克苏苹果', 1, 12, 12, 1, 12, 5, 7);
INSERT INTO `hf_orders_details` VALUES (63, '1000001972300460', 1, '麒麟西瓜', 10, 0.5, 5, 1, 5, 2, 3);
INSERT INTO `hf_orders_details` VALUES (64, '1000001972300460', 59, '阿克苏苹果', 10, 12, 120, 1, 120, 50, 70);
INSERT INTO `hf_orders_details` VALUES (65, '1000001972300460', 60, '巨峰葡萄', 10, 13, 130, 1, 130, 50, 80);
INSERT INTO `hf_orders_details` VALUES (66, '1000001972300460', 45, '天山雪梨', 10, 2, 20, 1, 20, 10, 10);
INSERT INTO `hf_orders_details` VALUES (67, '1000001972300460', 46, '冰糖苹果', 10, 0.5, 5, 1, 5, 2, 3);
INSERT INTO `hf_orders_details` VALUES (68, '1000001593963977', 1, '麒麟西瓜', 184, 0.5, 92, 1, 92, 36.8, 55.2);
INSERT INTO `hf_orders_details` VALUES (69, '1000001593963977', 59, '阿克苏苹果', 185, 12, 2220, 1, 2220, 925, 1295);
INSERT INTO `hf_orders_details` VALUES (70, '1000001593963977', 60, '巨峰葡萄', 5, 13, 65, 1, 65, 25, 40);
INSERT INTO `hf_orders_details` VALUES (71, '1000001593963977', 45, '天山雪梨', 85, 2, 170, 1, 170, 85, 85);
INSERT INTO `hf_orders_details` VALUES (72, '1000001593963977', 46, '冰糖苹果', 86, 0.5, 43, 1, 43, 17.2, 25.8);
INSERT INTO `hf_orders_details` VALUES (73, '1000001854944285', 1, '麒麟西瓜', 1, 3, 3, 1, 3, 1.5, 1.5);
INSERT INTO `hf_orders_details` VALUES (74, '1000001854944285', 45, '天山雪梨', 1, 6, 6, 1, 6, 2, 4);
INSERT INTO `hf_orders_details` VALUES (75, '1000001854944285', 60, '巨峰葡萄', 5, 28, 140, 1, 140, 25, 115);
INSERT INTO `hf_orders_details` VALUES (76, '1000001854944285', 59, '阿克苏苹果', 1, 8, 8, 1, 8, 3, 5);
INSERT INTO `hf_orders_details` VALUES (77, '1000000343714456', 61, '加州车厘子', 2, 188, 376, 0.9, 338.4, 198, 140.4);
INSERT INTO `hf_orders_details` VALUES (78, '1000001946456362', 1, '麒麟西瓜', 1, 3, 3, 0.9, 2.7, 1.5, 1.2);
INSERT INTO `hf_orders_details` VALUES (79, '1000001946456362', 45, '天山雪梨', 1, 6, 6, 0.9, 5.4, 2, 3.4);
INSERT INTO `hf_orders_details` VALUES (80, '1000001946456362', 61, '加州车厘子', 1, 188, 188, 0.9, 169.2, 99, 70.2);
INSERT INTO `hf_orders_details` VALUES (81, '1000002084787135', 47, '新疆香梨', 20, 6, 120, 1, 120, 40, 80);
INSERT INTO `hf_orders_details` VALUES (82, '1000001287913558', 1, '麒麟西瓜', 1, 3, 3, 0.95, 2.85, 1.5, 1.35);
INSERT INTO `hf_orders_details` VALUES (83, '1000001287913558', 59, '阿克苏苹果', 1, 8, 8, 0.95, 7.6, 3, 4.6);
INSERT INTO `hf_orders_details` VALUES (84, '1000001287913558', 60, '巨峰葡萄', 1, 28, 28, 0.95, 26.6, 5, 21.6);
INSERT INTO `hf_orders_details` VALUES (85, '1000001287913558', 61, '加州车厘子', 1, 188, 188, 0.95, 178.6, 99, 79.6);
INSERT INTO `hf_orders_details` VALUES (86, '1000001287913558', 45, '天山雪梨', 1, 6, 6, 0.95, 5.7, 2, 3.7);
INSERT INTO `hf_orders_details` VALUES (87, '1000001287913558', 46, '冰糖苹果', 1, 7, 7, 0.95, 6.65, 3, 3.65);
INSERT INTO `hf_orders_details` VALUES (88, '1000001287913558', 47, '新疆香梨', 1, 6, 6, 0.95, 5.7, 2, 3.7);
INSERT INTO `hf_orders_details` VALUES (89, '1000001161424725', 1, '麒麟西瓜', 1, 3, 3, 1, 3, 1.5, 1.5);
INSERT INTO `hf_orders_details` VALUES (90, '1000001161424725', 45, '天山雪梨', 1, 6, 6, 1, 6, 2, 4);
INSERT INTO `hf_orders_details` VALUES (91, '1000001161424725', 46, '冰糖苹果', 1, 7, 7, 1, 7, 3, 4);
INSERT INTO `hf_orders_details` VALUES (92, '1000001250494590', 1, '麒麟西瓜', 1, 3, 3, 1, 3, 1.5, 1.5);

-- ----------------------------
-- Table structure for hf_user
-- ----------------------------
DROP TABLE IF EXISTS `hf_user`;
CREATE TABLE `hf_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `user_mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `user_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `user_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `user_birth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `user_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `user_create` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `user_modified` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  `user_status` tinyint(255) NULL DEFAULT 1 COMMENT '状态 0:禁用，1:正常',
  `user_role` tinyint(255) NULL DEFAULT 1 COMMENT '权限 1:普通用户，2:管理员',
  `user_dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `user_dept`(`user_dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1019 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hf_user
-- ----------------------------
INSERT INTO `hf_user` VALUES (1000, 'admin', '$2a$10$mZk8tsXj65Q7wBt62z0vGun68/3xE7rwlACn7tlQEq62H7a2ZcT/m', '1008611', '1008611@qq.com', '', '2020-01-01', '男', '2020-01-01', '2020-01-01', 1, 2, NULL);
INSERT INTO `hf_user` VALUES (1001, '陈同学', '$2a$10$/dWZWhaaszQQC58CA2cHFOymWUdFrzkiDRwJUn/8s9bbuMXeTIzIC', '185709346478', '2758693093@qq.com', 'ef186700-94c3-4208-a670-0f6b40e59bd0.jpg', '2020-09-05', '男', '2020-5-10', '2020-08-14 22:03', 1, 2, 1);
INSERT INTO `hf_user` VALUES (1014, 'me', '$2a$10$mZk8tsXj65Q7wBt62z0vGun68/3xE7rwlACn7tlQEq62H7a2ZcT/m', '185709346478', '27586933@qq.com', 'f4cefd5d-90d2-4861-9749-5b3e85c32353.jpg', '2020-07-10', '男', '2020-05-31 16:40', '2020-07-02 22:05', 1, 1, 1);
INSERT INTO `hf_user` VALUES (1017, 'dany', '$2a$10$wbCoKzU7TDNA5YbECzQP8u8ReHFkk44caXnGvVZ2Fw6JNppueSYNm', '18978945', '27586933@qq.com', 'f15846d0-647f-48bf-99ac-778cf8761e2d.jpg', '2020-07-25', '女', '2020-07-02 20:40', '2020-07-02 22:06', 1, 1, 2);
INSERT INTO `hf_user` VALUES (1018, '婷婷', '$2a$10$FYhPwQPGj7b4Pfk9bDBboOOhTRWf9aJqkG2Yg5kvDBixsQmNDjAVW', '13973911733', '999999@qq.com', '922ceb85-9098-4a99-9b80-38202d74168b.jpeg', '2000-10-21', '女', '2020-07-05 19:17', '2020-08-14 22:04', 1, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
