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

 Date: 31/10/2022 21:15:29
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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '答疑表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

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
                            `college_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '院校id',
                            `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校名',
                            `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校地址',
                            `subjection_id` int(11) NULL DEFAULT NULL COMMENT '隶属编号',
                            `subjection` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校隶属',
                            `type_id` int(11) NULL DEFAULT NULL COMMENT '类型编号',
                            `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
                            `region_id` int(11) NULL DEFAULT NULL COMMENT '地区编号',
                            `region` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地区',
                            `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
                            `rank` smallint(6) NULL DEFAULT NULL COMMENT '院校排名',
                            `attribute_id` int(11) NULL DEFAULT NULL COMMENT '属性编号',
                            `attribute` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校属性',
                            `dis_develop` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学科建设',
                            PRIMARY KEY (`college_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学校表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (1, '北京大学', '北京市海淀区颐和园路5号', 1, '教育部', 1, '理工类', 1, '北京', '010-62751354', 1, 1, '985', '院士:95 硕士点:280 博士点:254 国家重点学科:一级18,二级25');
INSERT INTO `college` VALUES (2, '复旦大学', '上海市杨浦区邯郸路220号', 1, '教育部', 5, '综合类', 3, '上海', '021-55666668', 4, 1, '985', '院士:26 硕士点:一级41 博士点:一级35 国家重点学科:一级 11 ,二级 19');
INSERT INTO `college` VALUES (3, '中国科学技术大学', '安徽省合肥市金寨路 96 号', 2, '中央部委', 1, '理工类', 8, '安徽', '551-63602924', 15, 1, '985', '院士:45 硕士点:一级34 博士点:二级28 国家重点学科:一级8,二级4');
INSERT INTO `college` VALUES (4, '深圳大学', '深圳市南山区南海大道3688号', 3, '地方所属', 5, '综合类', 6, '广东', '0755-26536177', 86, 5, '本科', '院校:6 硕士点:一级38 博士点:一级10');
INSERT INTO `college` VALUES (5, '四川大学', '成都市一环路南一段24号', 1, '教育部', 5, '综合类', 7, '四川', '028-85466153', 14, 2, '211', '院士:13 硕士点:443 博士点:一级47 国家重点学科:二级46');
INSERT INTO `college` VALUES (6, '四川师范大学', '成都市锦江区静安路5号', 1, '教育部', 3, '师范类', 7, '四川', '028-84760732', 186, 5, '本科', '硕士点:一级24二级146 博士点:26');
INSERT INTO `college` VALUES (7, '清华大学', '北京市海淀区清华大学研究生院', 1, '教育部', 1, '理工类', 1, '北京', '010-62782192', 2, 1, '985', '院士:88 硕士点:一级57,二级2 博士点:一级49 国家重点学科:一级22,二级56');
INSERT INTO `college` VALUES (8, '北京航空航天大学', '北京市海淀区学院路37号', 2, '中央部委', 1, '理工类', 1, '北京', '010-82317637', 25, 1, '985', '院士:23 硕士点:一级40 博士点:一级23 国家重点学科:一级8 ,二级28');
INSERT INTO `college` VALUES (9, '北京理工大学', '北京市海淀区中关村南大街5号', 2, '中央部委', 1, '理工类', 1, '北京', '010-68912286', 29, 1, '985', '院士:22 硕士点:一级31 博士点:一级25 国家重点学科:一级4,二级5');
INSERT INTO `college` VALUES (10, '南开大学', '天津市南开区卫津路94号', 1, '教育部', 1, '理工类', 2, '天津', '022-23502121', 16, 1, '985', '院士:12 硕士点:一级42 ,二级39 博士点:一级30 国家重点学科:一级6,二级:8');
INSERT INTO `college` VALUES (11, '上海交通大学', '上海市东川路800号', 1, '教育部', 5, '综合类', 3, '上海', '021-62821069', 7, 1, '985', '院士:46 硕士点:一级56 博士点:一级38 国家重点学科:一级9,二级11');
INSERT INTO `college` VALUES (12, '北京师范大学', '北京市海淀区新街口外大街19号', 1, '教育部', 3, '师范类', 1, '北京', '010-58808156', 17, 1, '985', '院士:23 硕士点:146 博士点:114 国家重点学科:二级11');
INSERT INTO `college` VALUES (13, '浙江大学', '浙江省杭州市西湖区余杭塘路866号', 3, '地方所属', 5, '综合类', 5, '浙江', '0571-87951349', 6, 1, '985', '院士:41 硕士点:309 博士点:274 国家重点学科:一级14,二级21');
INSERT INTO `college` VALUES (14, '山东大学', '中国山东省济南市山大南路27号', 1, '教育部', 1, '理工类', 9, '山东', '0531-88364334', 21, 1, '985', '院士:12 硕士点:一级55 博士点:一级44 国家重点学科:一级2,二级14');
INSERT INTO `college` VALUES (15, '同济大学', '上海市杨浦区四平路1239号', 1, '教育部', 1, '理工类', 3, '上海', '021-65982944', 23, 1, '985', '院士:21 硕士点:一级45 博士点:一级30 国家重点学科:21');
INSERT INTO `college` VALUES (16, '中国人民大学', '北京市海淀区中关村大街59号', 1, '教育部', 5, '综合类', 1, '北京', '010-62515340', 5, 1, '985', '硕士点:一级37,二级189 博士点:一级21,二级129 国家重点学科:一级8');
INSERT INTO `college` VALUES (17, '中国农业大学', '北京市海淀区清华东路17号', 1, '教育部', 6, '农林类', 1, '北京', '010-62732884', 34, 1, '985', '院士:12 硕士点:149 博士点:97 国家重点学科:一级6,二级6');
INSERT INTO `college` VALUES (18, '天津大学', '天津市南开区卫津路92号', 1, '教育部', 5, '综合类', 2, '天津', '022-27404743', 13, 1, '985', '院士:12 硕士点:178 博士点:126 国家重点学科:一级7,二级8');
INSERT INTO `college` VALUES (19, '大连理工大学', '辽宁省大连市甘井子区凌工路2号', 1, '教育部', 1, '理工类', 10, '辽宁', '0411-84708338', 31, 1, '985', '院士:13 硕士点:229 博士点:134 国家重点学科:一级4,二级21');
INSERT INTO `college` VALUES (20, '东北大学', '辽宁省沈阳市和平区文化路三巷11号', 1, '教育部', 1, '理工类', 10, '辽宁', '024-83687556', 26, 1, '985', '院士:4 硕士点:182 博士点:121 国家重点学科:一级3,二级16');
INSERT INTO `college` VALUES (21, '吉林大学', '吉林省长春市前进大街2699号', 1, '教育部', 5, '综合类', 11, '吉林', '0431-85166371', 11, 1, '985', '院士:10 硕士点:198 博士点:264 国家重点学科:一级4,二级15');
INSERT INTO `college` VALUES (22, '哈尔滨工业大学', '哈尔滨市南岗区西大直街92号', 1, '教育部', 1, '理工类', 12, '黑龙江', '0451-86416113', 19, 1, '985', '院士:38 硕士点:一级41 博士点:一级27 国家重点学科:一级9,二级6');
INSERT INTO `college` VALUES (23, '南京大学', '南京市鼓楼区汉口路22号', 1, '教育部', 5, '综合类', 4, '江苏', '89683251', 8, 1, '985', '院士:32 硕士点:一级8,二级6 博士点:一级38,二级3 国家重点学科:一级8');
INSERT INTO `college` VALUES (24, '东南大学', '南京市江宁区东南大学九龙湖校区', 1, '教育部', 1, '理工类', 4, '江苏', '025-83792583', 24, 1, '985', '院士:11 硕士点:一级49 博士点:一级33');
INSERT INTO `college` VALUES (25, '外交学院', '北京市西城区展览馆路24号', 2, '中央部委', 7, '文法类', 1, '北京', '010-68323297', 738, 5, '本科', '硕士点:11 博士点:3 国家重点学科:2');
INSERT INTO `college` VALUES (26, '北京城市学院', '北京市海淀区北四环中路269号', 3, '地方所属', 5, '综合类', 1, '北京', '010-62321818', 699, 5, '本科', '硕士点:4');
INSERT INTO `college` VALUES (27, '河南财经政法大学', '中国·河南·郑州市金水东路180号', 3, '地方所属', 2, '财经类', 13, '河南', '0371-85960212', 349, 5, '本科', '硕士点:一级11');
INSERT INTO `college` VALUES (28, '河南大学', '河南 开封.明伦街/金明大道', 3, '地方所属', 5, '综合类', 13, '河南', '0371-22869091', 81, 5, '本科', '硕士点:一级43 博士点:一级20');
INSERT INTO `college` VALUES (29, '河南工业大学', '郑州市高新区莲花街100号', 3, '地方所属', 1, '理工类', 13, '河南', '0371-67756268', 238, 5, '本科', '硕士点:一级21 博士点:一级3');
INSERT INTO `college` VALUES (30, '河南科技大学', '洛阳 开元大道263号', 3, '地方所属', 1, '理工类', 13, '河南', '0379-64231373', 144, 5, '本科', '硕士点:一级38二级215 博士点:一级4二级15');
INSERT INTO `college` VALUES (31, '河南科技学院', '河南省新乡市华兰大道东段 453003', 3, '地方所属', 3, '师范类', 13, '河南', '0373-3040863', 395, 5, '本科', '硕士点:一级12');
INSERT INTO `college` VALUES (32, '河南理工大学', ' 河南焦作 高新区 世纪路2001号', 3, '地方所属', 1, '理工类', 13, '河南', '0391-3987234', 191, 5, '本科', '院士:12 硕士点:一级20 博士点:一级6 国家重点学科:1');

-- ----------------------------
-- Table structure for college_attribute
-- ----------------------------
DROP TABLE IF EXISTS `college_attribute`;
CREATE TABLE `college_attribute`  (
                                      `attribute_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
                                      `attribute_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名',
                                      PRIMARY KEY (`attribute_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college_attribute
-- ----------------------------
INSERT INTO `college_attribute` VALUES (1, '985');
INSERT INTO `college_attribute` VALUES (2, '211');
INSERT INTO `college_attribute` VALUES (3, '34所自主划线');
INSERT INTO `college_attribute` VALUES (4, '双一流');
INSERT INTO `college_attribute` VALUES (5, '本科');

-- ----------------------------
-- Table structure for college_major
-- ----------------------------
DROP TABLE IF EXISTS `college_major`;
CREATE TABLE `college_major`  (
                                  `college_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '院校id',
                                  `major_id` int(11) NOT NULL COMMENT '专业id',
                                  PRIMARY KEY (`college_id`, `major_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学校专业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college_major
-- ----------------------------
INSERT INTO `college_major` VALUES (1, 1);
INSERT INTO `college_major` VALUES (1, 2);
INSERT INTO `college_major` VALUES (1, 3);
INSERT INTO `college_major` VALUES (1, 4);

-- ----------------------------
-- Table structure for college_region
-- ----------------------------
DROP TABLE IF EXISTS `college_region`;
CREATE TABLE `college_region`  (
                                   `region_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地区编号',
                                   `region_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地区名',
                                   PRIMARY KEY (`region_id`, `region_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college_region
-- ----------------------------
INSERT INTO `college_region` VALUES (1, '北京');
INSERT INTO `college_region` VALUES (2, '天津');
INSERT INTO `college_region` VALUES (3, '上海');
INSERT INTO `college_region` VALUES (4, '江苏');
INSERT INTO `college_region` VALUES (5, '浙江');
INSERT INTO `college_region` VALUES (6, '广东');
INSERT INTO `college_region` VALUES (7, '四川');
INSERT INTO `college_region` VALUES (8, '安徽');
INSERT INTO `college_region` VALUES (9, '山东');
INSERT INTO `college_region` VALUES (10, '辽宁');
INSERT INTO `college_region` VALUES (11, '吉林');
INSERT INTO `college_region` VALUES (12, '黑龙江');
INSERT INTO `college_region` VALUES (13, '河南');

-- ----------------------------
-- Table structure for college_type
-- ----------------------------
DROP TABLE IF EXISTS `college_type`;
CREATE TABLE `college_type`  (
                                 `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型编号',
                                 `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型名',
                                 PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college_type
-- ----------------------------
INSERT INTO `college_type` VALUES (1, '理工类');
INSERT INTO `college_type` VALUES (2, '财经类');
INSERT INTO `college_type` VALUES (3, '师范类');
INSERT INTO `college_type` VALUES (4, '语言类');
INSERT INTO `college_type` VALUES (5, '综合类');
INSERT INTO `college_type` VALUES (6, '农林类');
INSERT INTO `college_type` VALUES (7, '文法类');

-- ----------------------------
-- Table structure for college_subjection
-- ----------------------------
DROP TABLE IF EXISTS `college_subjection`;
CREATE TABLE `college_subjection`  (
                                       `subjection_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '隶属id',
                                       `subjection` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院校隶属',
                                       PRIMARY KEY (`subjection_id`, `subjection`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college_subjection
-- ----------------------------
INSERT INTO `college_subjection` VALUES (1, '教育部');
INSERT INTO `college_subjection` VALUES (2, '中央部委');
INSERT INTO `college_subjection` VALUES (3, '地方所属');

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日志表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '专业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
                         `menu_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '权限id',
                         `path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '页面路由',
                         `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由名字',
                         `component` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由组件',
                         `parentId` int(0) NULL DEFAULT NULL COMMENT '父级',
                         `menu_type` int(0) NULL DEFAULT 1 COMMENT '菜单为1，按钮为0',
                         `level` int(0) NULL DEFAULT 0 COMMENT '层级',
                         `perms` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
                         PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/admin', '后台管理', 'admin', NULL, 1, 1, NULL);
INSERT INTO `menu` VALUES (2, '/systemManage', '系统管理', 'systemManage', 1, 1, 2, NULL);
INSERT INTO `menu` VALUES (3, '/userManage', '用户管理', 'userManage', 2, 1, 3, NULL);
INSERT INTO `menu` VALUES (4, '/add', '添加用户', 'add', 3, 0, 4, 'system:user:add');
INSERT INTO `menu` VALUES (5, '/edit', '编辑用户', 'edit', 3, 0, 4, 'system:user:update');
INSERT INTO `menu` VALUES (6, '/delete', '删除用户', 'delete', 3, 0, 4, 'system:user:delete');
INSERT INTO `menu` VALUES (7, '/view', '查看用户', 'view', 3, 0, 4, 'system:role:view');
INSERT INTO `menu` VALUES (8, '/permissManage', '角色权限', 'permissManage', 2, 1, 3, NULL);
INSERT INTO `menu` VALUES (9, '/role/add', '添加角色', 'role/add', 8, 0, 4, 'system:role:add');
INSERT INTO `menu` VALUES (10, '/role/delete', '删除角色', 'role/delete', 8, 0, 4, 'system:role:delete');
INSERT INTO `menu` VALUES (11, '/role/get', '为角色赋权', 'role/get', 8, 0, 4, 'system:role:getMenu');
INSERT INTO `menu` VALUES (12, '/role/view', '查看角色', 'role/view', 8, 0, 4, 'system:role:view');
INSERT INTO `menu` VALUES (13, '/role/edit', '修改角色', 'role/edit', 8, 0, 4, 'system:role:update');
INSERT INTO `menu` VALUES (14, '/menu/view', '查看权限', 'menu/view', 8, 0, 4, 'system:menu:view');
INSERT INTO `menu` VALUES (15, '/menu/add', '添加权限', 'menu/add', 8, 0, 4, 'system:menu:insert');
INSERT INTO `menu` VALUES (16, '/menu/edit', '修改权限', 'menu/edit', 8, 0, 4, 'system:menu:update');
INSERT INTO `menu` VALUES (17, '/menu/delete', '删除权限', 'menu/delete', 8, 0, 4, 'system:menu:delete');
INSERT INTO `menu` VALUES (18, '/theLogManage', '日志管理', 'theLogManage', 2, 1, 3, NULL);
INSERT INTO `menu` VALUES (19, '/view', '查看日志', 'view', 18, 0, 4, 'system:log:view');
INSERT INTO `menu` VALUES (20, '/delete', '删除日志', 'delete', 18, 0, 4, 'system:log:delete');
INSERT INTO `menu` VALUES (21, '/videoManage', '视频管理', 'videoManage', 1, 1, 2, NULL);
INSERT INTO `menu` VALUES (22, '/videoManage', '管理视频', 'videoManage', 21, 1, 3, NULL);
INSERT INTO `menu` VALUES (23, '/delete', '删除视频', 'delete', 22, 0, 4, 'system:video:delete');
INSERT INTO `menu` VALUES (24, '/view', '查看视频', 'view', 22, 0, 4, 'system:video:view');
INSERT INTO `menu` VALUES (25, '/edit', '修改视频', 'edit', 22, 0, 4, 'system:video:update');
INSERT INTO `menu` VALUES (26, '/teacherManage', '老师管理', 'teacherManage', 1, 1, 2, NULL);
INSERT INTO `menu` VALUES (27, '/teacherManage', '管理老师', 'teacherManage', 26, 1, 3, NULL);
INSERT INTO `menu` VALUES (28, '/delete', '删除老师', 'delete', 27, 0, 4, 'system:teacher:delete');
INSERT INTO `menu` VALUES (29, '/shenghe', '审核老师', 'shenghe', 27, 0, 4, 'system:teacher:sh');
INSERT INTO `menu` VALUES (30, '/front', '前台管理', 'front', NULL, 1, 1, NULL);
INSERT INTO `menu` VALUES (31, '/videoManage', '视频管理', 'videoManage', 30, 1, 2, NULL);
INSERT INTO `menu` VALUES (32, '/remark', '评论视频', 'remark', 31, 0, 3, 'system:video:remark');

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '政策表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '回复表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

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
INSERT INTO `role` VALUES (1, '超级管理员', 'sysAdmin');
INSERT INTO `role` VALUES (2, '普通管理员', 'admin');
INSERT INTO `role` VALUES (3, '学生', 'student');
INSERT INTO `role` VALUES (4, '老师', 'teacher');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
                              `role_id` int(0) NOT NULL COMMENT '角色ID',
                              `menu_id` int(0) NOT NULL DEFAULT 0 COMMENT '权限id',
                              PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (1, 5);
INSERT INTO `role_menu` VALUES (1, 6);
INSERT INTO `role_menu` VALUES (1, 7);
INSERT INTO `role_menu` VALUES (1, 8);
INSERT INTO `role_menu` VALUES (1, 9);
INSERT INTO `role_menu` VALUES (1, 10);
INSERT INTO `role_menu` VALUES (1, 11);
INSERT INTO `role_menu` VALUES (1, 12);
INSERT INTO `role_menu` VALUES (1, 13);
INSERT INTO `role_menu` VALUES (1, 14);
INSERT INTO `role_menu` VALUES (1, 15);
INSERT INTO `role_menu` VALUES (1, 16);
INSERT INTO `role_menu` VALUES (1, 17);
INSERT INTO `role_menu` VALUES (1, 18);
INSERT INTO `role_menu` VALUES (1, 19);
INSERT INTO `role_menu` VALUES (1, 20);
INSERT INTO `role_menu` VALUES (1, 21);
INSERT INTO `role_menu` VALUES (1, 22);
INSERT INTO `role_menu` VALUES (1, 23);
INSERT INTO `role_menu` VALUES (1, 24);
INSERT INTO `role_menu` VALUES (1, 25);
INSERT INTO `role_menu` VALUES (1, 26);
INSERT INTO `role_menu` VALUES (1, 27);
INSERT INTO `role_menu` VALUES (1, 28);
INSERT INTO `role_menu` VALUES (1, 29);
INSERT INTO `role_menu` VALUES (1, 30);
INSERT INTO `role_menu` VALUES (1, 31);
INSERT INTO `role_menu` VALUES (1, 32);
INSERT INTO `role_menu` VALUES (2, 1);
INSERT INTO `role_menu` VALUES (2, 2);
INSERT INTO `role_menu` VALUES (2, 3);
INSERT INTO `role_menu` VALUES (2, 7);
INSERT INTO `role_menu` VALUES (2, 18);
INSERT INTO `role_menu` VALUES (2, 19);
INSERT INTO `role_menu` VALUES (2, 21);
INSERT INTO `role_menu` VALUES (2, 22);
INSERT INTO `role_menu` VALUES (2, 24);
INSERT INTO `role_menu` VALUES (2, 26);
INSERT INTO `role_menu` VALUES (2, 27);
INSERT INTO `role_menu` VALUES (2, 29);
INSERT INTO `role_menu` VALUES (2, 30);
INSERT INTO `role_menu` VALUES (2, 31);
INSERT INTO `role_menu` VALUES (2, 32);
INSERT INTO `role_menu` VALUES (3, 30);
INSERT INTO `role_menu` VALUES (3, 31);
INSERT INTO `role_menu` VALUES (3, 32);

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '老师表' ROW_FORMAT = Dynamic;

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
                         `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
                         `is_hide` tinyint(0) NULL DEFAULT 0 COMMENT '隐私设置，是否可见，默认为0，可见',
                         `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人留言',
                         PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '仰望星空11', '$2a$10$tXD.fNXa4/FYlOWyre.zXeCf4HkjDSxVy.aTpdUutWMmlXbpn20pq', '13541169382', '2136442@qq.com', 19, '男', '头像11', 1, '这是个人留言');
INSERT INTO `user` VALUES (2, 'hjh', '星空', '$2a$10$LOOtNMJ3e2XFXil4wO8Yfe1c5Zwpz10qLfcxZeGvfOLAWuN37UFlG', NULL, '243134@qq.com', 24, '男', '头像', 0, '这是留言2');
INSERT INTO `user` VALUES (3, 'lgq', '大海', '$2a$10$LOOtNMJ3e2XFXil4wO8Yfe1c5Zwpz10qLfcxZeGvfOLAWuN37UFlG', '17311023002', '224456434@qq.com', 18, '女', '头像', 1, '这是留言3');
INSERT INTO `user` VALUES (6, 'czy', '云朵', '$2a$10$0EvmANPmkAOUIKMueFK3L.gy75d9fgy/OsXMwbsWumt9P3QsTFw0C', NULL, '2434213@qq.com', 3, '男', '头像', 0, '这是留言4');
INSERT INTO `user` VALUES (8, 'zhangshan', '张三', '$2a$10$0EvmANPmkAOUIKMueFK3L.gy75d9fgy/OsXMwbsWumt9P3QsTFw0C', NULL, '3543221@qq.com', 23, '保密', '头像', 0, '留言');
INSERT INTO `user` VALUES (9, 'lisi', '李四', '$2a$10$0EvmANPmkAOUIKMueFK3L.gy75d9fgy/OsXMwbsWumt9P3QsTFw0C', NULL, '214234@qq.com', 32, '保密', '头像', 0, '留言');
INSERT INTO `user` VALUES (10, 'wangwu', '王五', '$2a$10$0EvmANPmkAOUIKMueFK3L.gy75d9fgy/OsXMwbsWumt9P3QsTFw0C', NULL, '343542@qq.com', 12, '保密', '头像', 0, '留言');
INSERT INTO `user` VALUES (11, 'zhaoliu', '赵六', '$2a$10$0EvmANPmkAOUIKMueFK3L.gy75d9fgy/OsXMwbsWumt9P3QsTFw0C', NULL, '32421313@qq.com', 43, '保密', '头像', 0, '留言');
INSERT INTO `user` VALUES (12, 'zhangside', '张思德', '$2a$10$0EvmANPmkAOUIKMueFK3L.gy75d9fgy/OsXMwbsWumt9P3QsTFw0C', NULL, '234232@qq.com', 123, '保密', '头像', 0, '留言');
INSERT INTO `user` VALUES (13, 'liuzhijun', '刘志军', '$2a$10$0EvmANPmkAOUIKMueFK3L.gy75d9fgy/OsXMwbsWumt9P3QsTFw0C', NULL, '43543213@qq.com', 21, '保密', '头像', 1, '留言');
INSERT INTO `user` VALUES (14, 'kangxi', '康熙', '$2a$10$pS1J7GrzLYWaIhJfkI2QQeyO2/LS0TUS6fc2awAOHhati/AlzU5T6', NULL, '34542134@qq.com', 32, '保密', '头像', 0, '留言');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
                              `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
                              `role_id` int(0) NOT NULL DEFAULT 0 COMMENT '角色id',
                              PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);
INSERT INTO `user_role` VALUES (3, 3);
INSERT INTO `user_role` VALUES (14, 3);

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
                          `type_id` int(0) NULL DEFAULT NULL COMMENT '视频的类别id',
                          `type_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频的类别名字',
                          `duration` int(0) NULL DEFAULT 0 COMMENT '视频时长',
                          `link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播放链接或url',
                          `comment_num` int(0) NULL DEFAULT 0 COMMENT '评论数',
                          PRIMARY KEY (`video_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, '考研英语', '2022-10-15 16:10:52', 0, '这是考研英语', 1, 1, '图片', 0, 0, 1, '英语', 19, '无', 0);
INSERT INTO `video` VALUES (2, '考研数学', '2022-10-15 16:12:31', 0, '这是考研数学', 2, 3, '图片', 0, 0, 2, '数学', 23, '无', 0);
INSERT INTO `video` VALUES (3, '考研政治', '2022-10-15 16:20:06', 0, '这是考研政治', 3, 6, '图片', 0, 0, 3, '政治', 453, '无', 0);
INSERT INTO `video` VALUES (4, '考研计算机网络', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 4, 3, '图片', 0, 0, 4, '计算机网络', 56, '无', 0);
INSERT INTO `video` VALUES (5, '考研数据结构', '2022-10-15 16:23:21', 0, '这是考研数据结构', 5, 2, '图片', 0, 0, 5, '数据结构', 453, '无', 0);
INSERT INTO `video` VALUES (6, '考研计算机组成原理', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 6, 1, '图片', 0, 0, 6, '计算机组成原理', 234, '无', 0);
INSERT INTO `video` VALUES (7, '考研英语1', '2022-10-15 16:10:52', 0, '这是考研英语', 7, 4, '图片', 0, 0, 1, '英语', 34, '无', 0);
INSERT INTO `video` VALUES (8, '考研数学1', '2022-10-15 16:12:31', 0, '这是考研数学', 8, 5, '图片', 0, 0, 2, '数学', 32, '无', 0);
INSERT INTO `video` VALUES (9, '考研政治1', '2022-10-15 16:20:06', 0, '这是考研政治', 9, 3, '图片', 0, 0, 3, '政治', 4, '无', 0);
INSERT INTO `video` VALUES (10, '考研计算机网络1', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 10, 2, '图片', 0, 0, 4, '计算机网络', 34, '无', 0);
INSERT INTO `video` VALUES (11, '考研数据结构1', '2022-10-15 16:23:21', 0, '这是考研数据结构', 11, 1, '图片', 0, 0, 5, '数据结构', 34, '无', 0);
INSERT INTO `video` VALUES (12, '考研计算机组成原理1', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 12, 5, '图片', 0, 0, 6, '计算机组成原理', 23, '无', 0);
INSERT INTO `video` VALUES (13, '考研英语2', '2022-10-15 16:10:52', 0, '这是考研英语', 13, 3, '图片', 0, 0, 1, '英语', 12, '无', 0);
INSERT INTO `video` VALUES (14, '考研数学2', '2022-10-15 16:12:31', 0, '这是考研数学', 14, 2, '图片', 0, 0, 2, '数学', 34, '无', 0);
INSERT INTO `video` VALUES (15, '考研政治2', '2022-10-15 16:20:06', 0, '这是考研政治', 15, 4, '图片', 0, 0, 3, '政治', 43, '无', 0);
INSERT INTO `video` VALUES (16, '考研计算机网络2', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 16, 2, '图片', 0, 0, 4, '计算机网络', 23, '无', 0);
INSERT INTO `video` VALUES (17, '考研数据结构2', '2022-10-15 16:23:21', 0, '这是考研数据结构', 17, 5, '图片', 0, 0, 5, '数据结构', 34, '无', 0);
INSERT INTO `video` VALUES (18, '考研计算机组成原理2', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 18, 3, '图片', 0, 0, 6, '计算机组成原理', 23, '无', 0);
INSERT INTO `video` VALUES (19, '考研英语3', '2022-10-15 16:10:55', 0, '这是考研英语', 19, 2, '图片', 0, 0, 1, '英语', 25, '无', 0);
INSERT INTO `video` VALUES (20, '考研数学3', '2022-10-15 16:12:31', 0, '这是考研数学', 20, 4, '图片', 0, 0, 2, '数学', 14, '无', 0);
INSERT INTO `video` VALUES (21, '考研政治3', '2022-10-15 16:20:06', 0, '这是考研政治', 21, 5, '图片', 0, 0, 3, '政治', 23, '无', 0);
INSERT INTO `video` VALUES (22, '考研计算机网络3', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 22, 3, '图片', 0, 0, 4, '计算机网络', 5, '无', 0);
INSERT INTO `video` VALUES (23, '考研数据结构3', '2022-10-15 16:23:21', 0, '这是考研数据结构', 23, 2, '图片', 0, 0, 5, '数据结构', 56, '无', 0);
INSERT INTO `video` VALUES (24, '考研计算机组成原理3', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 24, 3, '图片', 0, 0, 6, '计算机组成原理', 45, '无', 0);
INSERT INTO `video` VALUES (25, '考研英语4', '2022-10-15 16:10:52', 0, '这是考研英语', 25, 4, '图片', 0, 0, 1, '英语', 65, '无', 0);
INSERT INTO `video` VALUES (26, '考研数学4', '2022-10-15 16:12:31', 0, '这是考研数学', 26, 3, '图片', 0, 0, 2, '数学', 76, '无', 0);
INSERT INTO `video` VALUES (27, '考研政治4', '2022-10-15 16:20:06', 0, '这是考研政治', 27, 2, '图片', 0, 0, 3, '政治', 45, '无', 0);
INSERT INTO `video` VALUES (28, '考研计算机网络4', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 28, 3, '图片', 0, 0, 4, '计算机网络', 234, '无', 0);
INSERT INTO `video` VALUES (29, '考研数据结构4', '2022-10-15 16:23:21', 0, '这是考研数据结构', 29, 5, '图片', 0, 0, 5, '数据结构', 34, '无', 0);
INSERT INTO `video` VALUES (30, '考研计算机组成原理4', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 30, 4, '图片', 0, 0, 6, '计算机组成原理', 45, '无', 0);
INSERT INTO `video` VALUES (31, '考研英语5', '2022-10-15 16:10:52', 0, '这是考研英语', 31, 3, '图片', 0, 0, 1, '英语', 34, '无', 0);
INSERT INTO `video` VALUES (32, '考研数学5', '2022-10-15 16:12:31', 0, '这是考研数学', 32, 2, '图片', 0, 0, 2, '数学', 56, '无', 0);
INSERT INTO `video` VALUES (33, '考研政治5', '2022-10-15 16:20:06', 0, '这是考研政治', 33, 1, '图片', 0, 0, 3, '政治', 34, '无', 0);
INSERT INTO `video` VALUES (34, '考研计算机网络5', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 34, 2, '图片', 0, 0, 4, '计算机网络', 32, '无', 0);
INSERT INTO `video` VALUES (35, '考研数据结构5', '2022-10-15 16:23:21', 0, '这是考研数据结构', 35, 4, '图片', 0, 0, 5, '数据结构', 45, '无', 0);
INSERT INTO `video` VALUES (36, '考研计算机组成原理5', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 36, 5, '图片', 0, 0, 6, '计算机组成原理', 43, '无', 0);
INSERT INTO `video` VALUES (37, '考研英语6', '2022-10-15 16:10:52', 0, '这是考研英语', 37, 3, '图片', 0, 0, 1, '英语', 345, '无', 0);
INSERT INTO `video` VALUES (38, '考研数学6', '2022-10-15 16:12:31', 0, '这是考研数学', 38, 2, '图片', 0, 0, 2, '数学', 23, '无', 0);
INSERT INTO `video` VALUES (39, '考研政治6', '2022-10-15 16:20:06', 0, '这是考研政治', 39, 3, '图片', 0, 0, 3, '政治', 45, '无', 0);
INSERT INTO `video` VALUES (40, '考研计算机网络6', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 40, 4, '图片', 0, 0, 4, '计算机网络', 65, '无', 0);
INSERT INTO `video` VALUES (41, '考研数据结构6', '2022-10-15 16:23:21', 0, '这是考研数据结构', 41, 3, '图片', 0, 0, 5, '数据结构', 34, '无', 0);
INSERT INTO `video` VALUES (42, '考研计算机组成原理6', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 42, 2, '图片', 0, 0, 6, '计算机组成原理', 56, '无', 0);
INSERT INTO `video` VALUES (43, '考研英语7', '2022-10-15 16:10:52', 0, '这是考研英语', 43, 3, '图片', 0, 0, 1, '英语', 34, '无', 0);
INSERT INTO `video` VALUES (44, '考研数学7', '2022-10-15 16:12:31', 0, '这是考研数学', 44, 4, '图片', 0, 0, 2, '数学', 23, '无', 0);
INSERT INTO `video` VALUES (45, '考研政治7', '2022-10-15 16:20:06', 0, '这是考研政治', 45, 2, '图片', 0, 0, 3, '政治', 23, '无', 0);
INSERT INTO `video` VALUES (46, '考研计算机网络7', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 46, 3, '图片', 0, 0, 4, '计算机网络', 125, '无', 0);
INSERT INTO `video` VALUES (47, '考研数据结构7', '2022-10-15 16:23:21', 0, '这是考研数据结构', 47, 4, '图片', 0, 0, 5, '数据结构', 45, '无', 0);
INSERT INTO `video` VALUES (48, '考研计算机组成原理7', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 48, 3, '图片', 0, 0, 6, '计算机组成原理', 34, '无', 0);
INSERT INTO `video` VALUES (49, '考研英语8', '2022-10-15 16:10:52', 0, '这是考研英语', 49, 5, '图片', 0, 0, 1, '英语', 65, '无', 0);
INSERT INTO `video` VALUES (50, '考研数学8', '2022-10-15 16:12:31', 0, '这是考研数学', 50, 3, '图片', 0, 0, 2, '数学', 34, '无', 0);
INSERT INTO `video` VALUES (51, '考研政治8', '2022-10-15 16:20:06', 0, '这是考研政治', 51, 2, '图片', 0, 0, 3, '政治', 6, '无', 0);
INSERT INTO `video` VALUES (52, '考研计算机网络8', '2022-10-15 16:22:27', 0, '这是考研计算机网络', 52, 5, '图片', 0, 0, 4, '计算机网络', 5, '无', 0);
INSERT INTO `video` VALUES (53, '考研数据结构8', '2022-10-15 16:23:21', 0, '这是考研数据结构', 53, 1, '图片', 0, 0, 5, '数据结构', 34, '无', 0);
INSERT INTO `video` VALUES (54, '考研计算机组成原理8', '2022-10-15 16:24:21', 0, '这是考研计算机组成原理', 54, 4, '图片', 0, 0, 6, '计算机组成原理', 23, '无', 0);

-- ----------------------------
-- Table structure for video_type
-- ----------------------------
DROP TABLE IF EXISTS `video_type`;
CREATE TABLE `video_type`  (
                               `type_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '视频的类别id',
                               `type_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频的类别名',
                               PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video_type
-- ----------------------------
INSERT INTO `video_type` VALUES (1, '英语');
INSERT INTO `video_type` VALUES (2, '数学');
INSERT INTO `video_type` VALUES (3, '政治');
INSERT INTO `video_type` VALUES (4, '计算机网络');
INSERT INTO `video_type` VALUES (5, '数据结构');
INSERT INTO `video_type` VALUES (6, '计算机组成原理');

SET FOREIGN_KEY_CHECKS = 1;
