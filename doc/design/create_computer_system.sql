/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : computer_system

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 20/10/2022 08:13:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer_question
-- ----------------------------
DROP TABLE IF EXISTS `answer_question`;
CREATE TABLE `answer_question`  (
                                    `answer_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '答疑id',
                                    `time` datetime(0) NULL DEFAULT NULL COMMENT '答疑时间',
                                    `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '答疑内容',
                                    `study_id` int(0) NULL DEFAULT NULL COMMENT '需要答疑的学习者id',
                                    `teacher_id` int(0) NULL DEFAULT NULL COMMENT '给学习者解答的指导者id',
                                    PRIMARY KEY (`answer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '答疑表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
                            `article_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文章id',
                            `author_id` int(0) NULL DEFAULT NULL COMMENT '作者id',
                            `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章题目',
                            `time` datetime(0) NULL DEFAULT NULL COMMENT '创作时间',
                            `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章内容',
                            `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章图片',
                            `like_number` int(0) NULL DEFAULT 0 COMMENT '文章点赞数',
                            `collection_num` int(0) NULL DEFAULT 0 COMMENT '收藏数',
                            `view_num` int(0) NULL DEFAULT 0 COMMENT '浏览数',
                            PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
                               `user_id` int(0) NOT NULL COMMENT '收藏资源的用户id',
                               `resource_id` int(0) NOT NULL COMMENT '收藏资源的资源id',
                               PRIMARY KEY (`user_id`, `resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
                            `college_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '院校id',
                            `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校名',
                            `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校地址',
                            `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
                            `region` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地区',
                            `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
                            `rank` smallint(0) NULL DEFAULT NULL COMMENT '院校排名',
                            `dis_develop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学科建设',
                            PRIMARY KEY (`college_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学校表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (1, '测试', '测试', '测试', '测试', '测试', 123, '测试');

-- ----------------------------
-- Table structure for college_major
-- ----------------------------
DROP TABLE IF EXISTS `college_major`;
CREATE TABLE `college_major`  (
                                  `college_id` int(0) NOT NULL COMMENT '院校id',
                                  `major_id` int(0) NOT NULL COMMENT '专业id',
                                  PRIMARY KEY (`college_id`, `major_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学校专业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
                            `comment_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论id',
                            `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论内容',
                            `create_date` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
                            `resource_id` int(0) NULL DEFAULT NULL COMMENT '评论对应资源id',
                            `author_id` int(0) NULL DEFAULT NULL COMMENT '评论者id',
                            `parent_id` int(0) NULL DEFAULT NULL COMMENT '父亲节点id',
                            `to_uid` int(0) NULL DEFAULT NULL COMMENT '评论对象的id',
                            `level` int(0) NULL DEFAULT NULL COMMENT '评论的层次',
                            `like_number` int(0) NULL DEFAULT 0 COMMENT '点赞数',
                            PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '写的好', '2022-10-19 21:43:34', 1, 3, 0, 0, 1, 0);
INSERT INTO `comment` VALUES (2, '111', '2022-10-19 21:52:43', 1, 1, 1, 3, 2, 0);
INSERT INTO `comment` VALUES (3, '2222', '2022-10-19 21:52:54', 1, 2, 2, 1, 3, 3);
INSERT INTO `comment` VALUES (4, '5555', '2022-10-19 21:54:36', 1, 6, 1, 3, 2, 2);
INSERT INTO `comment` VALUES (5, '好好好', '2022-10-19 21:54:49', 1, 1, 0, 0, 1, 5);

-- ----------------------------
-- Table structure for journal
-- ----------------------------
DROP TABLE IF EXISTS `journal`;
CREATE TABLE `journal`  (
                            `journal_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '日志id',
                            `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志名',
                            `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志内容',
                            `user_id` int(0) NULL DEFAULT NULL COMMENT '发表日志用户',
                            `time` datetime(0) NULL DEFAULT NULL COMMENT '上传或更新时间',
                            PRIMARY KEY (`journal_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
                          `major_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '专业id',
                          `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业名',
                          `major_code` int(0) NULL DEFAULT NULL COMMENT '专业代码',
                          `classify` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业分类',
                          `category` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学科门类',
                          `schooling_length` tinyint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修业年限',
                          `degree` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所授予的学位',
                          `level` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业层次',
                          `instruction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业介绍',
                          PRIMARY KEY (`major_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '专业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for policy
-- ----------------------------
DROP TABLE IF EXISTS `policy`;
CREATE TABLE `policy`  (
                           `policy_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '政策id',
                           `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '政策内容',
                           `classify` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '政策分类',
                           `partition` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '政策分区',
                           PRIMARY KEY (`policy_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '政策表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power`  (
                          `power_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '权限id',
                          `perms` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限标识',
                          PRIMARY KEY (`power_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES (1, 'all');
INSERT INTO `power` VALUES (2, 'no');
INSERT INTO `power` VALUES (3, 'yes');

-- ----------------------------
-- Table structure for quiz
-- ----------------------------
DROP TABLE IF EXISTS `quiz`;
CREATE TABLE `quiz`  (
                         `quiz_id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
                         `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '提问的内容',
                         `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '提问的时间',
                         `study_id` int(0) NULL DEFAULT NULL COMMENT '提问者的id',
                         `teacher_id` int(0) NULL DEFAULT NULL COMMENT '老师的id',
                         PRIMARY KEY (`quiz_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '提问表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
                          `reply_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '回复id',
                          `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回复内容',
                          `time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
                          `user_id` int(0) NULL DEFAULT NULL COMMENT '回复者id',
                          `comment_id` int(0) NULL DEFAULT NULL COMMENT '回复对应评论id',
                          `like_number` int(0) NULL DEFAULT 0 COMMENT '点赞数',
                          PRIMARY KEY (`reply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '回复表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
                             `resource_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '资源id',
                             `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源名',
                             `type` int(0) NULL DEFAULT NULL COMMENT '资源类型,0为视频，1为文章',
                             `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源简介',
                             PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (1, '考研英语', 0, '视频');
INSERT INTO `resource` VALUES (2, '考研数学', 0, '视频');
INSERT INTO `resource` VALUES (3, '考研政治', 0, '视频');
INSERT INTO `resource` VALUES (4, '考研计算机网络', 0, '视频');
INSERT INTO `resource` VALUES (5, '考研数据结构', 0, '视频');
INSERT INTO `resource` VALUES (6, '考研计算机组成原理', 0, '视频');
INSERT INTO `resource` VALUES (7, '考研英语1', 0, '视频');
INSERT INTO `resource` VALUES (8, '考研数学1', 0, '视频');
INSERT INTO `resource` VALUES (9, '考研政治1', 0, '视频');
INSERT INTO `resource` VALUES (10, '考研计算机网络1', 0, '视频');
INSERT INTO `resource` VALUES (11, '考研数据结构1', 0, '视频');
INSERT INTO `resource` VALUES (12, '考研计算机组成原理1', 0, '视频');
INSERT INTO `resource` VALUES (13, '考研英语2', 0, '视频');
INSERT INTO `resource` VALUES (14, '考研数学2', 0, '视频');
INSERT INTO `resource` VALUES (15, '考研政治2', 0, '视频');
INSERT INTO `resource` VALUES (16, '考研计算机网络2', 0, '视频');
INSERT INTO `resource` VALUES (17, '考研数据结构2', 0, '视频');
INSERT INTO `resource` VALUES (18, '考研计算机组成原理2', 0, '视频');
INSERT INTO `resource` VALUES (19, '考研英语3', 0, '视频');
INSERT INTO `resource` VALUES (20, '考研数学3', 0, '视频');
INSERT INTO `resource` VALUES (21, '考研政治3', 0, '视频');
INSERT INTO `resource` VALUES (22, '考研计算机网络3', 0, '视频');
INSERT INTO `resource` VALUES (23, '考研数据结构3', 0, '视频');
INSERT INTO `resource` VALUES (24, '考研计算机组成原理3', 0, '视频');
INSERT INTO `resource` VALUES (25, '考研英语4', 0, '视频');
INSERT INTO `resource` VALUES (26, '考研数学4', 0, '视频');
INSERT INTO `resource` VALUES (27, '考研政治4', 0, '视频');
INSERT INTO `resource` VALUES (28, '考研计算机网络4', 0, '视频');
INSERT INTO `resource` VALUES (29, '考研数据结构4', 0, '视频');
INSERT INTO `resource` VALUES (30, '考研计算机组成原理4', 0, '视频');
INSERT INTO `resource` VALUES (31, '考研英语5', 0, '视频');
INSERT INTO `resource` VALUES (32, '考研数学5', 0, '视频');
INSERT INTO `resource` VALUES (33, '考研政治5', 0, '视频');
INSERT INTO `resource` VALUES (34, '考研计算机网络5', 0, '视频');
INSERT INTO `resource` VALUES (35, '考研数据结构5', 0, '视频');
INSERT INTO `resource` VALUES (36, '考研计算机组成原理5', 0, '视频');
INSERT INTO `resource` VALUES (37, '考研英语6', 0, '视频');
INSERT INTO `resource` VALUES (38, '考研数学6', 0, '视频');
INSERT INTO `resource` VALUES (39, '考研政治6', 0, '视频');
INSERT INTO `resource` VALUES (40, '考研计算机网络6', 0, '视频');
INSERT INTO `resource` VALUES (41, '考研数据结构6', 0, '视频');
INSERT INTO `resource` VALUES (42, '考研计算机组成原理6', 0, '视频');
INSERT INTO `resource` VALUES (43, '考研英语7', 0, '视频');
INSERT INTO `resource` VALUES (44, '考研数学7', 0, '视频');
INSERT INTO `resource` VALUES (45, '考研政治7', 0, '视频');
INSERT INTO `resource` VALUES (46, '考研计算机网络7', 0, '视频');
INSERT INTO `resource` VALUES (47, '考研数据结构7', 0, '视频');
INSERT INTO `resource` VALUES (48, '考研计算机组成原理7', 0, '视频');
INSERT INTO `resource` VALUES (49, '考研英语8', 0, '视频');
INSERT INTO `resource` VALUES (50, '考研数学8', 0, '视频');
INSERT INTO `resource` VALUES (51, '考研政治8', 0, '视频');
INSERT INTO `resource` VALUES (52, '考研计算机网络8', 0, '视频');
INSERT INTO `resource` VALUES (53, '考研数据结构8', 0, '视频');
INSERT INTO `resource` VALUES (54, '考研计算机组成原理8', 0, '视频');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
                         `role_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '角色id',
                         `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名',
                         `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色权限字符串',
                         PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', 'Administrator');
INSERT INTO `role` VALUES (2, '教师', 'teacher');
INSERT INTO `role` VALUES (3, '学生', 'student');
INSERT INTO `role` VALUES (4, '会员', 'vip');

-- ----------------------------
-- Table structure for role_power
-- ----------------------------
DROP TABLE IF EXISTS `role_power`;
CREATE TABLE `role_power`  (
                               `role_id` int(0) NOT NULL COMMENT '角色ID',
                               `power_id` int(0) NOT NULL DEFAULT 0 COMMENT '权限id',
                               PRIMARY KEY (`role_id`, `power_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_power
-- ----------------------------
INSERT INTO `role_power` VALUES (1, 1);
INSERT INTO `role_power` VALUES (2, 3);
INSERT INTO `role_power` VALUES (3, 2);
INSERT INTO `role_power` VALUES (4, 3);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
                            `teacher_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '老师id',
                            `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '老师名字',
                            `background` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '老师的学业背景',
                            `teach_direction` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教授的方向',
                            `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '老师的图片',
                            `teach_time` tinyint(0) NULL DEFAULT 0 COMMENT '教学时长',
                            `information` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人信息',
                            `attent_people` int(0) NULL DEFAULT 0 COMMENT '关注人数',
                            `qualification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '辅导资料和辅导记录',
                            `user_id` int(0) NULL DEFAULT NULL COMMENT '对应的用户id',
                            PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '老师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
                         `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
                         `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
                         `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
                         `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
                         `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
                         `age` tinyint(0) UNSIGNED NULL DEFAULT 0 COMMENT '年龄',
                         `sex` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '保密' COMMENT '性别，默认为保密',
                         `role` tinyint(0) UNSIGNED NULL DEFAULT 1 COMMENT '身份，0为管理员，1为学习者，2为指导者',
                         `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
                         `is_hide` tinyint(0) NULL DEFAULT 0 COMMENT '隐私设置，是否可见，默认为0，可见',
                         `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人留言',
                         PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '仰望星空11', '$2a$10$tXD.fNXa4/FYlOWyre.zXeCf4HkjDSxVy.aTpdUutWMmlXbpn20pq', '13541169382', '2136442@qq.com', 19, '男', 1, '头像11', 0, '这是留言1');
INSERT INTO `user` VALUES (2, 'hjh', '星空', '$2a$10$LOOtNMJ3e2XFXil4wO8Yfe1c5Zwpz10qLfcxZeGvfOLAWuN37UFlG', NULL, NULL, 24, '男', 1, NULL, 0, '这是留言2');
INSERT INTO `user` VALUES (3, 'lgq', '大海', '$2a$10$LOOtNMJ3e2XFXil4wO8Yfe1c5Zwpz10qLfcxZeGvfOLAWuN37UFlG', '17311023002', '224456434@qq.com', 18, '女', 1, '头像', 1, '这是留言3');
INSERT INTO `user` VALUES (6, 'czy', '云朵', '1234', NULL, NULL, 3, '男', 1, NULL, 0, '这是留言4');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
                              `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
                              `role_id` int(0) NOT NULL DEFAULT 0 COMMENT '角色id',
                              PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 4);
INSERT INTO `user_role` VALUES (3, 2);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
                          `video_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '视频的id',
                          `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频的名称',
                          `time` datetime(0) NULL DEFAULT NULL COMMENT '上传时间',
                          `like_number` int(0) NULL DEFAULT 0 COMMENT '点赞数',
                          `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频的介绍',
                          `resource_id` int(0) NULL DEFAULT NULL COMMENT '对应的资源id',
                          `author_id` int(0) NULL DEFAULT NULL COMMENT '作者id',
                          `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频图片',
                          `collection_num` int(0) UNSIGNED NULL DEFAULT 0 COMMENT '收藏数',
                          `view_num` int(0) NULL DEFAULT 0 COMMENT '浏览数',
                          `type_one` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频的类别1',
                          `type_two` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频的类别2',
                          `type_three` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频的类别3',
                          `duration` int(0) NULL DEFAULT 0 COMMENT '视频时长',
                          `link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播放链接或url',
                          `comment_num` int(0) NULL DEFAULT 0 COMMENT '评论数',
                          PRIMARY KEY (`video_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, '考研英语', '2022-10-15 16:10:52', 0, '这是考研英语', 1, 1, '图片', 0, 0, '英语', NULL, NULL, 19, '无', 0);
INSERT INTO `video` VALUES (2, '考研数学', '2022-10-15 16:12:31', 0, '这是考研数学', 2, 3, '图片', 0, 0, '数学', NULL, NULL, 23, '无', 0);
INSERT INTO `video` VALUES (3, '考研政治', '2022-10-15 16:20:06', 0, '这是考研政治', 3, 6, '图片', 0, 0, '政治', NULL, NULL, 453, '无', 0);
INSERT INTO `video` VALUES (4, '考研计算机网络', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 4, 3, '图片', 0, 0, '计算机网络', NULL, NULL, 56, '无', 0);
INSERT INTO `video` VALUES (5, '考研数据结构', '2022-10-15 16:23:21', 0, '这是考研数据结构', 5, 2, '图片', 0, 0, '数据结构', NULL, NULL, 453, '无', 0);
INSERT INTO `video` VALUES (6, '考研计算机组成原理', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 6, 1, '图片', 0, 0, '计算机组成原理', NULL, NULL, 234, '无', 0);
INSERT INTO `video` VALUES (7, '考研英语1', '2022-10-15 16:10:52', 0, '这是考研英语', 7, 4, '图片', 0, 0, '英语', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (8, '考研数学1', '2022-10-15 16:12:31', 0, '这是考研数学', 8, 5, '图片', 0, 0, '数学', NULL, NULL, 32, '无', 0);
INSERT INTO `video` VALUES (9, '考研政治1', '2022-10-15 16:20:06', 0, '这是考研政治', 9, 3, '图片', 0, 0, '政治', NULL, NULL, 4, '无', 0);
INSERT INTO `video` VALUES (10, '考研计算机网络1', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 10, 2, '图片', 0, 0, '计算机网络', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (11, '考研数据结构1', '2022-10-15 16:23:21', 0, '这是考研数据结构', 11, 1, '图片', 0, 0, '数据结构', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (12, '考研计算机组成原理1', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 12, 5, '图片', 0, 0, '计算机组成原理', NULL, NULL, 23, '无', 0);
INSERT INTO `video` VALUES (13, '考研英语2', '2022-10-15 16:10:52', 0, '这是考研英语', 13, 3, '图片', 0, 0, '英语', NULL, NULL, 12, '无', 0);
INSERT INTO `video` VALUES (14, '考研数学2', '2022-10-15 16:12:31', 0, '这是考研数学', 14, 2, '图片', 0, 0, '数学', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (15, '考研政治2', '2022-10-15 16:20:06', 0, '这是考研政治', 15, 4, '图片', 0, 0, '政治', NULL, NULL, 43, '无', 0);
INSERT INTO `video` VALUES (16, '考研计算机网络2', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 16, 2, '图片', 0, 0, '计算机网络', NULL, NULL, 23, '无', 0);
INSERT INTO `video` VALUES (17, '考研数据结构2', '2022-10-15 16:23:21', 0, '这是考研数据结构', 17, 5, '图片', 0, 0, '数据结构', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (18, '考研计算机组成原理2', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 18, 3, '图片', 0, 0, '计算机组成原理', NULL, NULL, 23, '无', 0);
INSERT INTO `video` VALUES (19, '考研英语3', '2022-10-15 16:10:55', 0, '这是考研英语', 19, 2, '图片', 0, 0, '英语', NULL, NULL, 25, '无', 0);
INSERT INTO `video` VALUES (20, '考研数学3', '2022-10-15 16:12:31', 0, '这是考研数学', 20, 4, '图片', 0, 0, '数学', NULL, NULL, 14, '无', 0);
INSERT INTO `video` VALUES (21, '考研政治3', '2022-10-15 16:20:06', 0, '这是考研政治', 21, 5, '图片', 0, 0, '政治', NULL, NULL, 23, '无', 0);
INSERT INTO `video` VALUES (22, '考研计算机网络3', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 22, 3, '图片', 0, 0, '计算机网络', NULL, NULL, 5, '无', 0);
INSERT INTO `video` VALUES (23, '考研数据结构3', '2022-10-15 16:23:21', 0, '这是考研数据结构', 23, 2, '图片', 0, 0, '数据结构', NULL, NULL, 56, '无', 0);
INSERT INTO `video` VALUES (24, '考研计算机组成原理3', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 24, 3, '图片', 0, 0, '计算机组成原理', NULL, NULL, 45, '无', 0);
INSERT INTO `video` VALUES (25, '考研英语4', '2022-10-15 16:10:52', 0, '这是考研英语', 25, 4, '图片', 0, 0, '英语', NULL, NULL, 65, '无', 0);
INSERT INTO `video` VALUES (26, '考研数学4', '2022-10-15 16:12:31', 0, '这是考研数学', 26, 3, '图片', 0, 0, '数学', NULL, NULL, 76, '无', 0);
INSERT INTO `video` VALUES (27, '考研政治4', '2022-10-15 16:20:06', 0, '这是考研政治', 27, 2, '图片', 0, 0, '政治', NULL, NULL, 45, '无', 0);
INSERT INTO `video` VALUES (28, '考研计算机网络4', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 28, 3, '图片', 0, 0, '计算机网络', NULL, NULL, 234, '无', 0);
INSERT INTO `video` VALUES (29, '考研数据结构4', '2022-10-15 16:23:21', 0, '这是考研数据结构', 29, 5, '图片', 0, 0, '数据结构', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (30, '考研计算机组成原理4', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 30, 4, '图片', 0, 0, '计算机组成原理', NULL, NULL, 45, '无', 0);
INSERT INTO `video` VALUES (31, '考研英语5', '2022-10-15 16:10:52', 0, '这是考研英语', 31, 3, '图片', 0, 0, '英语', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (32, '考研数学5', '2022-10-15 16:12:31', 0, '这是考研数学', 32, 2, '图片', 0, 0, '数学', NULL, NULL, 56, '无', 0);
INSERT INTO `video` VALUES (33, '考研政治5', '2022-10-15 16:20:06', 0, '这是考研政治', 33, 1, '图片', 0, 0, '政治', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (34, '考研计算机网络5', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 34, 2, '图片', 0, 0, '计算机网络', NULL, NULL, 32, '无', 0);
INSERT INTO `video` VALUES (35, '考研数据结构5', '2022-10-15 16:23:21', 0, '这是考研数据结构', 35, 4, '图片', 0, 0, '数据结构', NULL, NULL, 45, '无', 0);
INSERT INTO `video` VALUES (36, '考研计算机组成原理5', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 36, 5, '图片', 0, 0, '计算机组成原理', NULL, NULL, 43, '无', 0);
INSERT INTO `video` VALUES (37, '考研英语6', '2022-10-15 16:10:52', 0, '这是考研英语', 37, 3, '图片', 0, 0, '英语', NULL, NULL, 345, '无', 0);
INSERT INTO `video` VALUES (38, '考研数学6', '2022-10-15 16:12:31', 0, '这是考研数学', 38, 2, '图片', 0, 0, '数学', NULL, NULL, 23, '无', 0);
INSERT INTO `video` VALUES (39, '考研政治6', '2022-10-15 16:20:06', 0, '这是考研政治', 39, 3, '图片', 0, 0, '政治', NULL, NULL, 45, '无', 0);
INSERT INTO `video` VALUES (40, '考研计算机网络6', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 40, 4, '图片', 0, 0, '计算机网络', NULL, NULL, 65, '无', 0);
INSERT INTO `video` VALUES (41, '考研数据结构6', '2022-10-15 16:23:21', 0, '这是考研数据结构', 41, 3, '图片', 0, 0, '数据结构', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (42, '考研计算机组成原理6', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 42, 2, '图片', 0, 0, '计算机组成原理', NULL, NULL, 56, '无', 0);
INSERT INTO `video` VALUES (43, '考研英语7', '2022-10-15 16:10:52', 0, '这是考研英语', 43, 3, '图片', 0, 0, '英语', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (44, '考研数学7', '2022-10-15 16:12:31', 0, '这是考研数学', 44, 4, '图片', 0, 0, '数学', NULL, NULL, 23, '无', 0);
INSERT INTO `video` VALUES (45, '考研政治7', '2022-10-15 16:20:06', 0, '这是考研政治', 45, 2, '图片', 0, 0, '政治', NULL, NULL, 23, '无', 0);
INSERT INTO `video` VALUES (46, '考研计算机网络7', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 46, 3, '图片', 0, 0, '计算机网络', NULL, NULL, 125, '无', 0);
INSERT INTO `video` VALUES (47, '考研数据结构7', '2022-10-15 16:23:21', 0, '这是考研数据结构', 47, 4, '图片', 0, 0, '数据结构', NULL, NULL, 45, '无', 0);
INSERT INTO `video` VALUES (48, '考研计算机组成原理7', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 48, 3, '图片', 0, 0, '计算机组成原理', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (49, '考研英语8', '2022-10-15 16:10:52', 0, '这是考研英语', 49, 5, '图片', 0, 0, '英语', NULL, NULL, 65, '无', 0);
INSERT INTO `video` VALUES (50, '考研数学8', '2022-10-15 16:12:31', 0, '这是考研数学', 50, 3, '图片', 0, 0, '数学', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (51, '考研政治8', '2022-10-15 16:20:06', 0, '这是考研政治', 51, 2, '图片', 0, 0, '政治', NULL, NULL, 6, '无', 0);
INSERT INTO `video` VALUES (52, '考研计算机网络8', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 52, 5, '图片', 0, 0, '计算机网络', NULL, NULL, 5, '无', 0);
INSERT INTO `video` VALUES (53, '考研数据结构8', '2022-10-15 16:23:21', 0, '这是考研数据结构', 53, 1, '图片', 0, 0, '数据结构', NULL, NULL, 34, '无', 0);
INSERT INTO `video` VALUES (54, '考研计算机组成原理8', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 54, 4, '图片', 0, 0, '计算机组成原理', NULL, NULL, 23, '无', 0);

SET FOREIGN_KEY_CHECKS = 1;
