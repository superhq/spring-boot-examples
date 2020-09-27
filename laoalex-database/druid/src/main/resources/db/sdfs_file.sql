/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.64.128-root
 Source Server Type    : MySQL
 Source Server Version : 100140
 Source Host           : 192.168.64.128:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 100140
 File Encoding         : 65001

 Date: 27/09/2020 17:33:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sdfs_file
-- ----------------------------
DROP TABLE IF EXISTS `sdfs_file`;
CREATE TABLE `sdfs_file`  (
  `file_id` bigint(20) UNSIGNED NOT NULL COMMENT '文件id',
  `file_size` bigint(20) UNSIGNED NULL DEFAULT 0 COMMENT '文件大小，单位B',
  `file_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `file_digest` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件摘要，默认是md5值',
  `state` int(11) NULL DEFAULT 1 COMMENT '状态',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `store_id` int(11) NOT NULL DEFAULT 1 COMMENT 'S3信息记录的ID',
  PRIMARY KEY (`file_id`) USING BTREE,
  INDEX `file_md5`(`file_digest`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sdfs_file
-- ----------------------------
INSERT INTO `sdfs_file` VALUES (595974710393061376, 3384, 'yml', '57605af0134e4dbcffb3bbb0a26cfdd9', 1, '2019-07-03 13:50:43', 1);
INSERT INTO `sdfs_file` VALUES (596660321903923200, 322, 'txt', '25ab98ecf705d3fd02c749d320e9ba3b', 1, '2019-07-05 11:15:06', 1);
INSERT INTO `sdfs_file` VALUES (596661048453844992, 152948, 'pdf', '164e67d72c5bfede52e71bcd17ece942', 1, '2019-07-05 11:17:59', 1);
INSERT INTO `sdfs_file` VALUES (596661182260531200, 10922, 'xlsx', 'b43e6f8fab0f3d252a37279854ea73f4', 1, '2019-07-05 11:18:31', 1);
INSERT INTO `sdfs_file` VALUES (596661382798594048, 2077, 'txt', '8aa6c2f463507de6432fc2a46bb9486f', 1, '2019-07-05 11:19:19', 1);
INSERT INTO `sdfs_file` VALUES (596662010727845888, 3, 'txt', '202cb962ac59075b964b07152d234b70', 1, '2019-07-05 11:21:48', 1);
INSERT INTO `sdfs_file` VALUES (596663967790092288, 10427198, 'pdf', '9da3f56a82b4f1a24e597426e22ff3d2', 1, '2019-07-05 11:29:35', 1);
INSERT INTO `sdfs_file` VALUES (596666228301844480, 684852, 'xlsx', 'ba831699b23a4a65bb9c9774824c5086', 1, '2019-07-05 11:38:34', 1);
INSERT INTO `sdfs_file` VALUES (596666939307675648, 6, 'txt', '5479c00a47510206a017c985699f4d07', 1, '2019-07-05 11:41:23', 1);
INSERT INTO `sdfs_file` VALUES (596667161840668672, 9764, 'xlsx', '27948fbd4c6c6cd80736452eddd7f791', 1, '2019-07-05 11:42:16', 1);
INSERT INTO `sdfs_file` VALUES (596667466636546048, 33792, 'xls', 'f184e0f0e0d9c90189834ecbc7390c58', 1, '2019-07-05 11:43:29', 1);
INSERT INTO `sdfs_file` VALUES (596696124324900864, 16395, 'php', '48822fef226122728c4c59355d29bebe', 1, '2019-07-05 13:37:22', 1);
INSERT INTO `sdfs_file` VALUES (596705463081168896, 340, 'sql', '876e64735b24756123d05d0ce881c427', 1, '2019-07-05 14:14:28', 1);
INSERT INTO `sdfs_file` VALUES (600632382583750656, 163088, 'png', '1d227a7439bf80dda3ba161f0c397e7f', 1, '2019-07-16 10:18:39', 1);
INSERT INTO `sdfs_file` VALUES (600634209157005312, 14822, 'docx', '1849957d419494495753a12494c3383a', 1, '2019-07-16 10:25:54', 1);
INSERT INTO `sdfs_file` VALUES (600634621872324608, 505495, 'docx', 'c43014c0c6230451bb4ccfbec3f686d5', 1, '2019-07-16 10:27:33', 1);
INSERT INTO `sdfs_file` VALUES (600652850413977600, 35014, 'docx', 'a3170445e4779be0c0ba9477afc1660c', 1, '2019-07-16 11:39:59', 1);
INSERT INTO `sdfs_file` VALUES (600693893381505024, 7366, 'png', 'e68b64f43e6f9ad58895d6ba1917664a', 1, '2019-07-16 14:23:04', 1);
INSERT INTO `sdfs_file` VALUES (600694135136993280, 4, 's360', 'd3d80b656929a5bc0fa34381bf42fbdd', 1, '2019-07-16 14:24:02', 1);
INSERT INTO `sdfs_file` VALUES (600697431218208768, 1083576, 'jpg', '507bf53ea67673ff50067b71ef3da95c', 1, '2019-07-16 14:37:08', 1);
INSERT INTO `sdfs_file` VALUES (601003399504216064, 17920, 'dll', '02c63f568e598aad85dd401d7b26e82a', 1, '2019-07-17 10:52:56', 1);
INSERT INTO `sdfs_file` VALUES (601047986046255104, 57488, 'downloadLog_delegate', '0737158312650ea6b58a7a8438cc937c', 1, '2019-07-17 13:50:06', 1);
INSERT INTO `sdfs_file` VALUES (601048727964106752, 1179, '0827b1cbd3c6e45859ff3642c4f329b3', '7deda924560e34827ce55c70a3f8bd56', 1, '2019-07-17 13:53:03', 1);
INSERT INTO `sdfs_file` VALUES (601049584533258240, 869593, 'jpg', 'd7dd85de4ecc28d39dd70f70ec6d7858', 1, '2019-07-17 13:56:27', 1);
INSERT INTO `sdfs_file` VALUES (601053640597192704, 761991, 'png', '40c579f2c09928fe95946ab59537b658', 1, '2019-07-17 14:12:34', 1);
INSERT INTO `sdfs_file` VALUES (601054644931674112, 5, 'txt', '9fb967ff8d2ab5b93a3e6154fcafe2ed', 1, '2019-07-17 14:16:34', 1);
INSERT INTO `sdfs_file` VALUES (601360558588870656, 14087, 'xlsx', '4fc35aa78b1193a956ef96078e0f1940', 1, '2019-07-18 10:32:09', 1);
INSERT INTO `sdfs_file` VALUES (601461120735035392, 45364, 'jpg', '0b79410240c8b548462af08d392c1393', 1, '2019-07-18 17:11:45', 1);
INSERT INTO `sdfs_file` VALUES (601698005002489856, 2275, 'txt', '0291c3d46e82253e9ff340ae5777ddf8', 1, '2019-07-19 08:53:03', 1);
INSERT INTO `sdfs_file` VALUES (601698201207836672, 13640, 'xlsx', 'd3629e72984a9b71d51f060044520682', 1, '2019-07-19 08:53:50', 1);
INSERT INTO `sdfs_file` VALUES (601698434293698560, 900, 'logs_360_clear', 'def4b529792e73a4ee2251e74f81aa0b', 1, '2019-07-19 08:54:45', 1);
INSERT INTO `sdfs_file` VALUES (601698660836446208, 3955, 'log', '08b9dbb227fcb5a69aefa045afc27a41', 1, '2019-07-19 08:55:39', 1);
INSERT INTO `sdfs_file` VALUES (601707490530037760, 111896, 'png', '339bea98ca8e0afdcc48abc741caf0ed', 1, '2019-07-19 09:30:44', 1);
INSERT INTO `sdfs_file` VALUES (602860665294295040, 568417, 'xlsx', '4d7f6550bd0ec323ee8fe787b9150605', 1, '2019-07-22 13:53:03', 1);
INSERT INTO `sdfs_file` VALUES (602860959348559872, 14261, 'docx', '584c1caa050c70a9f3b4a4e22a9b0c9d', 1, '2019-07-22 13:54:13', 1);
INSERT INTO `sdfs_file` VALUES (603203003886075904, 159, 'txt', '82527e33ba78907f65fac92b194d6a25', 1, '2019-07-23 12:33:23', 1);
INSERT INTO `sdfs_file` VALUES (603221962987544576, 7, 'txt', '63aa7a757facbec84cf8368c72bcc8a4', 1, '2019-07-23 13:48:43', 1);

SET FOREIGN_KEY_CHECKS = 1;
