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

 Date: 13/10/2022 16:26:29
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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学校表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for college_major
-- ----------------------------
DROP TABLE IF EXISTS `college_major`;
CREATE TABLE `college_major`  (
                                  `college_id` int(0) NOT NULL COMMENT '院校id',
                                  `major_id` int(0) NOT NULL COMMENT '专业id',
                                  PRIMARY KEY (`college_id`, `major_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学校专业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
                            `comment_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论id',
                            `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论内容',
                            `time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
                            `user_id` int(0) NULL DEFAULT NULL COMMENT '评论者id',
                            `resource_id` int(0) NULL DEFAULT NULL COMMENT '评论对应资源id',
                            `like_number` int(0) NULL DEFAULT 0 COMMENT '点赞数',
                            PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

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
                          `perms` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
                          PRIMARY KEY (`power_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '提问表' ROW_FORMAT = Dynamic;

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
                             `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源类型',
                             `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源简介',
                             PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

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
INSERT INTO `user` VALUES (1, 'admin', '仰望星空11', '$2a$10$LN4q82GS4YP7YGXOFf7AD.WNTrq2cB62lc9UB57VFbTK0ijYVZxdm', '15388366005', '2136442@qq.com', 19, '男', 1, '头像11', 0, '这是留言1');
INSERT INTO `user` VALUES (2, 'hjh', NULL, '$2a$10$LOOtNMJ3e2XFXil4wO8Yfe1c5Zwpz10qLfcxZeGvfOLAWuN37UFlG', NULL, NULL, 24, '男', 1, NULL, 0, '这是留言2');
INSERT INTO `user` VALUES (3, 'lgq', '大海', '$2a$10$LOOtNMJ3e2XFXil4wO8Yfe1c5Zwpz10qLfcxZeGvfOLAWuN37UFlG', '17311023002', '224456434@qq.com', 18, '男', 1, '头像', 1, '这是留言3');
INSERT INTO `user` VALUES (6, 'czy', NULL, '1234', NULL, NULL, 3, '男', 1, NULL, 0, '这是留言4');

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
                          `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频的名称',
                          `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上传时间',
                          `like_number` int(0) NULL DEFAULT NULL COMMENT '点赞数',
                          `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频的介绍',
                          `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频的类别',
                          `resource_id` int(0) NULL DEFAULT NULL COMMENT '对应的资源id',
                          `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频图片',
                          PRIMARY KEY (`video_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
