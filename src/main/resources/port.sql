/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : port

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 09/03/2023 23:18:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公告标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '公告内容',
  `createtime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建时间',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发布人',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '逻辑删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES (1, '港口安全维护通告', '尊敬的各位用户，为确保港口安全运营，维护各方利益，请各位用户一定要加强港口安全意识，同时注意以下几点：  1. 请遵守港口安全交通规则，不闯红灯，不超速行驶； 2. 请勿在港口区域内饮酒后驾车，不得酒后驾驶； 3. 请勿带有易燃易爆物品入港口，严格按照港口安全要求办理相关手续，确保安全运输； 4. 若发现有异常情况，请及时上报港口管理部门。  港口安全事关所有用户的利益，请大家一定要服从管理规定，积极配合港口管理部门，共同维护良好的运营环境。', '2023-03-09 20:50:01', 'admin', b'0');
INSERT INTO `announcement` VALUES (2, '港口运营调整通知', '尊敬的各位用户，为便于更好地为各位提供贴心服务，本港口将于近期进行如下运营调整：  1. 提高货物装卸效率，缩短货物滞留时间； 2. 增加货物中转配送服务，提升港口客户服务质量； 3. 加强港口设备运转监管，确保设备运行的稳定性和安全性。  感谢各位用户的理解和支持，我们将以更高的运营标准和更优质的服务态度为各位提供更加安心、便捷的服务。', '2023-03-09 21:36:55', 'admin', b'0');
INSERT INTO `announcement` VALUES (3, '港口船舶限制通知', ' 尊敬的各位用户，为了更好地保障港口运营安全稳定，特制定如下船舶限制规定：  1. 请勿搭载一些危险品或者龙虎斗类赌博诈骗等非法非正规货物的船只进入港口； 2. 严格核实运输证明和手续，确保船只和货物的安全性和合法性； 3. 船只进入港口前，请先拨打港口管理部门联系电话进行查询和确认。  如有疑问，请及时联系港口管理部门，我们将积极为大家提供协助和支持，共同维护港口运营安全。', '2023-03-09 21:39:05', '陈键樑', b'0');

-- ----------------------------
-- Table structure for appeal
-- ----------------------------
DROP TABLE IF EXISTS `appeal`;
CREATE TABLE `appeal`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `shipid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '申诉船只的id',
  `userid` int NULL DEFAULT NULL COMMENT '申诉用户的id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '申述内容',
  `status` int NOT NULL DEFAULT 0 COMMENT '申诉状态',
  `createdat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appeal
-- ----------------------------
INSERT INTO `appeal` VALUES (9, '1', 1, '数据不准确：我发现港口管理部门公布的数据不准确，希望能够提高数据管理水平，提供准确的数据信息。', 2, '2023-03-08 20:59:40', 0);
INSERT INTO `appeal` VALUES (10, '1', 1, '违规操作：我发现港口管理人员存在违规操作的行为，导致货物出现异常情况，希望有关部门能够加强规章制定和监管工作，防止出现违规操作的行为。', 0, '2023-03-08 22:04:17', 0);
INSERT INTO `appeal` VALUES (11, '2', 1, '货物滞留：货物长时间滞留在港口未能及时出港，影响了我的生产和商业活动。', 1, '2023-03-09 22:27:33', 0);
INSERT INTO `appeal` VALUES (12, '2', 1, '运输安全：我发现一些船只和货物存在安全隐患，希望港口管理部门能够加强安全监管并采取有效措施，确保运货安全。', 0, '2023-03-09 22:27:40', 0);
INSERT INTO `appeal` VALUES (13, '1', 1, ' 清关服务：港口清关服务能力欠缺，导致我的货物清关时间拖延，影响我商品的正常出口，希望能够提高清关服务质量。', 0, '2023-03-09 22:27:49', 0);
INSERT INTO `appeal` VALUES (14, '3', 1, '环境卫生：我发现港口管理部门对港口环境卫生存在一定疏忽，希望能够加强清洁管理，提高港口环境质量。', 0, '2023-03-09 22:27:53', 0);
INSERT INTO `appeal` VALUES (15, '2', 1, '港口收费：我认为港口的收费标准过高，不合理，希望有关部门能够重新审视收费标准并进行调整。', 0, '2023-03-09 22:28:01', 0);

-- ----------------------------
-- Table structure for releases
-- ----------------------------
DROP TABLE IF EXISTS `releases`;
CREATE TABLE `releases`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `shipid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '船舶ID',
  `operatorid` int NULL DEFAULT NULL COMMENT '操作员ID',
  `releasetime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '放行时间',
  `clearancetype` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '放行类型：0：未放行 1：入港放行，2：出港放行',
  `clearanceremark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '放行备注',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of releases
-- ----------------------------
INSERT INTO `releases` VALUES (1, '1', 2, '2022-03-03 00:00:00', 1, '货物标记：xxx\r\n封号：xxx\r\n托运单号：xxx\r\n日期时间：xxx\r\n放行者签名：xxx', 0);
INSERT INTO `releases` VALUES (2, '2', 2, '2022-08-09 06:00:00', 1, NULL, 0);
INSERT INTO `releases` VALUES (3, '3', 2, '2022-02-09 03:00:00', 3, NULL, 0);
INSERT INTO `releases` VALUES (4, '4', 2, '2022-08-09 06:00:00', 2, '货物名称：xxx\r\n货物规格：xxx\r\n货物数量：xxx\r\n收发货人联系方式：xxx\r\n运输方式：xxx\r\n备注：xxx', 0);
INSERT INTO `releases` VALUES (5, '5', 2, '2022-09-08 00:05:00', 3, '', 0);
INSERT INTO `releases` VALUES (6, '6', 2, '2022-08-09 06:00:00', 1, '', 0);
INSERT INTO `releases` VALUES (7, '7', 2, '2022-02-08 09:00:00', 4, '', 0);
INSERT INTO `releases` VALUES (8, '8', 2, '2022-02-08 09:00:00', 3, '', 1);
INSERT INTO `releases` VALUES (9, '9', 2, '2022-02-08 09:00:00', 3, '', 1);
INSERT INTO `releases` VALUES (10, '10', 2, '2022-01-29 08:00:00', 1, '', 0);
INSERT INTO `releases` VALUES (11, '11', 2, '2022-12-02 07:00:00', 1, '', 0);
INSERT INTO `releases` VALUES (12, '12', 2, '2022-08-09 06:00:00', 2, NULL, 0);
INSERT INTO `releases` VALUES (13, '4', 2, '2022-08-09 06:00:00', 4, '', 1);

-- ----------------------------
-- Table structure for ships
-- ----------------------------
DROP TABLE IF EXISTS `ships`;
CREATE TABLE `ships`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '船名',
  `shiptype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '船型',
  `length` float NULL DEFAULT NULL COMMENT '船长',
  `draft` float NULL DEFAULT NULL COMMENT '吃水深度',
  `tonnage` float NULL DEFAULT NULL COMMENT '吨位',
  `captainname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '船长姓名',
  `ownername` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '船东姓名',
  `userId` int UNSIGNED NULL DEFAULT NULL COMMENT '用户ID',
  `reviewstatus` int NOT NULL DEFAULT 0 COMMENT '审核状态',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`userId` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '船舶表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ships
-- ----------------------------
INSERT INTO `ships` VALUES (1, 'name', 'type', 1, 1, 1, 'cname', 'ownername', 1, 1, b'0');
INSERT INTO `ships` VALUES (2, '玉龙号', '集装箱船', 20, 22, 200, '李四', '王五', 1, 1, b'0');
INSERT INTO `ships` VALUES (3, '青岛号', '油轮', 20, 3, 211, '赵六', '钱七', 2, 2, b'0');
INSERT INTO `ships` VALUES (4, '长江号', '客运船', 15, 35, 33, '吴十', '张百三', 3, 2, b'0');
INSERT INTO `ships` VALUES (5, '东风号', '油轮', 30, 23, 11, '李百四', '张二十', 1, 2, b'0');
INSERT INTO `ships` VALUES (6, '黄浦江号', '化学品船', 30, 43, 1, '郑十一', '张百', 1, 0, b'0');
INSERT INTO `ships` VALUES (7, '新天地号', '集装箱船', 20, 12, 22, '张二', '孙八', 2, 0, b'0');
INSERT INTO `ships` VALUES (8, '泰山号', '客运船', 9, 21, 9, '周九', '李百', 3, 0, b'0');
INSERT INTO `ships` VALUES (9, '南极号', '客运船', 4, 55, 442, '郑二十九', '王二', 3, 0, b'0');
INSERT INTO `ships` VALUES (10, '东海之光', '集装箱船', 5, 11, 222, '吴二', '郑二', 1, 2, b'0');
INSERT INTO `ships` VALUES (11, '珠江之舞', '游轮', 33, 35, 33, '王二十四', '刘十七\r\n', 1, 1, b'0');
INSERT INTO `ships` VALUES (12, '北风号', '客运船', 11, 32, 4, '刘十七\r\n刘一', '吴二十八', 1, 1, b'0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户昵称',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `userphone` int UNSIGNED NULL DEFAULT NULL COMMENT '用户电话号码',
  `realname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `usership` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '所属船只',
  `roleid` int UNSIGNED NULL DEFAULT NULL COMMENT '角色ID',
  `reviewstatus` int NOT NULL DEFAULT 0 COMMENT '审核状态',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', '$2a$10$pRF0H.DphPipmelMnEnYK.O0B0XyB8/e.YIHDbTSEFb00hdjjtKZO', 123553121, '陈键樑', NULL, 1, 1, b'0');
INSERT INTO `user` VALUES (2, 'admin', '$2a$10$IzE9VkK1usg4EjDna8MAgOiQtZTBGdeh1HCia2etEQRTrtgFdvoq6', 321315533, 'admin', '', 2, 1, b'0');
INSERT INTO `user` VALUES (3, 'user', '$2a$10$aqF6ixjGNkUSOBn1xz.Llu52bjagXj5eTRVXXw92f8zmxD23mNVJ6', 321315553, 'user', '2', 3, 1, b'0');
INSERT INTO `user` VALUES (4, 'bobsmith', '$2a$10$sXryxRu8shRwCAGdgPQR7O7fVFBmRGgIBe2yWHCFSrINvR8vDEfX2', 123456789, 'Bob Smith', '1', 3, 0, b'0');
INSERT INTO `user` VALUES (5, 'jobedoe', '$2a$10$e28wfgbCLswGnRK642VwZ.qLadhuoFc6ITe7mSVNvuLMWmNwYVUh.', 555555555, 'Jobe Doe', '2', 3, 0, b'0');
INSERT INTO `user` VALUES (6, 'sarahlee', '$2a$10$5rkiEzBNSUqmAe7CWrwyIeb60kcg21cQMalO.b4Cu2WB7jma/fiTy', 888888888, 'Sarah Lee', '4', 3, 1, b'0');
INSERT INTO `user` VALUES (7, 'mikejohn', '$2a$10$OyxfDfV309sxbkNDWSOb1eZtpyGa6YaqYFXQJP0N.K89rmmy6yYa.', 111111111, 'Mike John', '1', 3, 1, b'0');
INSERT INTO `user` VALUES (8, 'amyjones', '$2a$10$RXt9rYeLWWjgFZjDW0G3YetXMyPMci09AHbmbq4bwsecuwwLpzDhe', 446564565, 'Amy Jones', '1', 3, 2, b'0');
INSERT INTO `user` VALUES (9, 'liuyang', '$2a$10$.PAtCF48.Dka/D9080Md/OKjEa9nzrk99eN2cSIbbcGng7cWARTXu', 555152214, 'Liu Yang', '2', 3, 1, b'0');
INSERT INTO `user` VALUES (10, 'janedoe', '$2a$10$TM1tgf60Lti7kgU4YtDpQ.p2Czt9mOgXPiDhEVilIZnAs.7KofOR2', 123456789, 'Jane Doe', '2', 2, 1, b'0');
INSERT INTO `user` VALUES (11, 'kellyluo', '$2a$10$Ew.twsfyoBfNaIX/o8380ePXppfFy5Uud.JSqSJyAFRE3jMPDzkZq', 446564546, 'Kelly Luo', '3', 3, 1, b'0');
INSERT INTO `user` VALUES (12, 'del', '$2a$10$.2kBicspvKI3Jm7dGWaLVelW1YhwVAtfAMPMzkSDMrkQABZECvcI2', 123553121, 'dele', '', 1, 1, b'1');

SET FOREIGN_KEY_CHECKS = 1;
