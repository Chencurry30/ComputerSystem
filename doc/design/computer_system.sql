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

 Date: 10/11/2022 21:01:17
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
  `subjection_id` int(0) NULL DEFAULT NULL COMMENT '隶属编号',
  `subjection` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校隶属',
  `type_id` int(0) NULL DEFAULT NULL COMMENT '类型编号',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `region_id` int(0) NULL DEFAULT NULL COMMENT '地区编号',
  `region` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地区',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `rank` smallint(0) NULL DEFAULT NULL COMMENT '院校排名',
  `attribute_id` int(0) NULL DEFAULT NULL COMMENT '属性编号',
  `attribute` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校属性',
  `dis_develop` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学科建设',
  PRIMARY KEY (`college_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学校表' ROW_FORMAT = Dynamic;

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
INSERT INTO `college` VALUES (33, '河南农业大学', '中国·河南·郑州农业路63号', 3, '地方所属', 6, '农林类', 13, '河南', '0371-63558825', 177, 2, '211', '院士:1 硕士点:一级18二级85 博士点:一级9 国家重点学科:一级1二级2');
INSERT INTO `college` VALUES (34, '河南师范大学', '河南省新乡市建设东路46号', 3, '地方所属', 3, '师范类', 13, '河南', '0373-3329034', 155, 4, '双一流', '硕士点:一级27二级7 博士点:一级10');
INSERT INTO `college` VALUES (35, '天津医科大学', '天津市和平区气象台路22号', 3, '地方所属', 8, '医药类', 2, '天津', '022-83336930', 145, 2, '211', '院士:3 硕士点:一级12 博士点:一级10 国家重点学科:二级4');
INSERT INTO `college` VALUES (36, '东华大学', '上海市松江区人民北路2999号', 1, '教育部', 1, '理工类', 3, '上海', '021-67792430', 68, 2, '211', '院士:4 硕士点:一级29 博士点:一级10 国家重点学科:一级1,二级5');
INSERT INTO `college` VALUES (37, '华东理工大学', '上海市梅陇路130号', 1, '教育部', 1, '理工类', 3, '上海', '021-64252453', 68, 2, '211', '院士:10 硕士点:一级27,二级142 博士点:一级13,二级80 国家重点学科:8');
INSERT INTO `college` VALUES (38, '华东师范大学', '上海市青浦区康业路188号', 1, '教育部', 3, '师范类', 3, '上海', '021-54344721', 28, 1, '985', '院士:6 硕士点:一级38,二级6 博士点:一级26 国家重点学科:一级2,二级5');
INSERT INTO `college` VALUES (39, '上海财经大学', '上海市杨浦区国定路777号', 1, '教育部', 2, '财经类', 3, '上海', '021-65903795', 72, 2, '211', '硕士点:一级42,二级2 博士点:一级6,二级48 国家重点学科:二级4');
INSERT INTO `college` VALUES (40, '上海大学', '上海市嘉定区塔城路453弄', 3, '地方所属', 5, '综合类', 3, '上海', '021-66133763', 60, 2, '211', '院士:16 硕士点:一级42,二级2 博士点:一级24,二级2 国家重点学科:二级4');
INSERT INTO `college` VALUES (41, '河北金融学院', '河北省保定市恒祥北大街3188号', 3, '地方所属', 2, '财经类', 14, '河北', '0312-3338138', 544, 5, '本科', '硕士点:1');
INSERT INTO `college` VALUES (42, '上海外国语大学', '上海市杨浦区靖宇中路190号', 1, '教育部', 4, '语言类', 3, '上海', '021-35373072', 752, 5, '本科', '硕士点:一级7 ,二级39 博士点:一级3 ,二级19 国家重点学科:2');
INSERT INTO `college` VALUES (43, '河海大学', '南京市西康路1号', 1, '教育部', 1, '理工类', 4, '江苏', '025-83786303', 39, 2, '211', '院士:18 硕士点:一级38,二级5 博士点:一级16 国家重点学科:一级1,二级7');
INSERT INTO `college` VALUES (44, '江南大学', '无锡市蠡湖大道1800号', 1, '教育部', 5, '综合类', 4, '江苏', '0510-85197929', 76, 2, '211', '院士:2 硕士点:一级28 博士点:一级7 国家重点学科:一级1,二级5');
INSERT INTO `college` VALUES (45, '南京航空航天大学', '江苏省南京市秦淮区御道街29号', 2, '中央部委', 1, '理工类', 4, '江苏', '84892487', 57, 2, '211', '院士:11 硕士点:一级33 博士点:一级17 国家重点学科:一级2,二级9');
INSERT INTO `college` VALUES (46, '南京理工大学', '南京市玄武区光华路1号', 2, '中央部委', 1, '理工类', 4, '江苏', '025-84303162', 50, 2, '211', '院士:16 硕士点:117 博士点:50 国家重点学科:9');
INSERT INTO `college` VALUES (47, '南京农业大学', '中国南京卫岗1号', 1, '教育部', 6, '农林类', 4, '江苏', '84396872', 47, 2, '211', '院士:2 硕士点:一级31 博士点:一级17 国家重点学科:一级4,二级3');
INSERT INTO `college` VALUES (48, '南京师范大学', '南京市鼓楼区宁海路122号', 3, '地方所属', 3, '师范类', 4, '江苏', '025-85891892', 53, 2, '211', '院士:1 硕士点:一级40,二级1 博士点:一级25,二级1 国家重点学科:二级6');
INSERT INTO `college` VALUES (49, '苏州大学', '苏州市吴中区干将东路333号', 3, '地方所属', 5, '综合类', 4, '江苏', '0512-65227655', 49, 2, '211', '院士:7 硕士点:一级51 博士点:一级28 国家重点学科:一级4');
INSERT INTO `college` VALUES (50, '中国药科大学', '南京市鼓楼区童家巷24号', 1, '教育部', 8, '医药类', 4, '江苏', '025-86185281', 142, 2, '211', '院士:2 硕士点:一级6,二级37 博士点:一级2,二级24 国家重点学科:二级1');
INSERT INTO `college` VALUES (51, '厦门大学', '厦门市思明区思明南路422号', 1, '教育部', 5, '综合类', 4, '江苏', '0592-2184166', 22, 1, '985', '院士:22 硕士点:一级52,二级3 博士点:一级33 国家重点学科:一级5,二级9');
INSERT INTO `college` VALUES (52, '福州大学', '福州市闽侯县大学新区学园路2号', 3, '地方所属', 1, '理工类', 15, '福建', '0591-22865515', 73, 2, '211', '院士:10 硕士点:一级39,二级4 博士点:一级11,二级2 国家重点学科:二级1');
INSERT INTO `college` VALUES (53, '中国海洋大学', '青岛市崂山区松岭路238号', 1, '教育部', 5, '综合类', 9, '山东', '0532-66782080', 54, 1, '985', '院士:13 硕士点:一级35 博士点:一级16 国家重点学科:一级2,二级9');
INSERT INTO `college` VALUES (54, '郑州大学', '郑州市科学大道100号', 3, '地方所属', 5, '综合类', 13, '河南', '0371-67781710', 46, 4, '双一流', '院士:11 硕士点:一级59 博士点:一级30');
INSERT INTO `college` VALUES (55, '武汉大学', '湖北省武汉市武昌区八一路299号', 1, '教育部', 5, '综合类', 16, '湖北', '027-68754231', 9, 1, '985', '院士:18 硕士点:一级57 博士点:一级46 国家重点学科:一级5,二级17');
INSERT INTO `college` VALUES (56, '华中科技大学', '湖北省武汉市洪山区珞喻路1037号', 1, '教育部', 5, '综合类', 16, '湖北', '027-87541746', 12, 1, '985', '院士:17 硕士点:202 博士点:189 国家重点学科:一级7,二级15');
INSERT INTO `college` VALUES (57, '华中师范大学', '湖北省武汉市洪山区珞喻路152号', 1, '教育部', 3, '师范类', 16, '湖北', '027-67861488', 36, 4, '双一流', '硕士点:一级33,二级4 博士点:一级21 国家重点学科:二级8');
INSERT INTO `college` VALUES (58, '华中农业大学', '武汉市洪山区狮子山街特1号', 1, '教育部', 6, '农林类', 16, '湖北', '027-87280470', 43, 2, '211', '院士:4 硕士点:一级27 博士点:一级15\r\n\r\n院校排名：综合排名:43 农林类:2');
INSERT INTO `college` VALUES (59, '武汉理工大学', '湖北省武汉市珞狮路122号', 1, '教育部', 1, '理工类', 16, '湖北', '027-87651413', 40, 2, '211', '院士:14 硕士点:一级46 博士点:一级19');
INSERT INTO `college` VALUES (60, '中南财经政法大学', '湖北省武汉市东湖新技术开发区南湖大道182号', 1, '教育部', 2, '财经类', 16, '湖北', '027-88386706', 69, 2, '211', '院士: 硕士点:一级17,二级97 博士点:一级7,二级57 国家重点学科:二级4');
INSERT INTO `college` VALUES (61, '湖南大学', '湖南省长沙市岳麓区麓山南路麓山门', 1, '教育部', 5, '综合类', 17, '湖南', '0731-88822856', 32, 1, '985', '院士:11 硕士点:一级36 博士点:一级27 国家重点学科:一级2,二级14');
INSERT INTO `college` VALUES (62, '中南大学', '长沙市岳麓区麓山南路', 1, '教育部', 5, '综合类', 17, '湖南', '0731-88836421', 20, 1, '985', '院士:11 硕士点:一级36 博士点:一级27 国家重点学科:一级2,二级14');

-- ----------------------------
-- Table structure for college_attribute
-- ----------------------------
DROP TABLE IF EXISTS `college_attribute`;
CREATE TABLE `college_attribute`  (
  `attribute_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `attribute_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名',
  PRIMARY KEY (`attribute_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `college_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '院校id',
  `major_id` int(0) NOT NULL COMMENT '专业id',
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
  `region_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '地区编号',
  `region_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地区名',
  PRIMARY KEY (`region_id`, `region_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `college_region` VALUES (14, '河北');
INSERT INTO `college_region` VALUES (15, '福建');
INSERT INTO `college_region` VALUES (16, '湖北');
INSERT INTO `college_region` VALUES (17, '湖南');

-- ----------------------------
-- Table structure for college_subjection
-- ----------------------------
DROP TABLE IF EXISTS `college_subjection`;
CREATE TABLE `college_subjection`  (
  `subjection_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '隶属id',
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
-- Table structure for college_type
-- ----------------------------
DROP TABLE IF EXISTS `college_type`;
CREATE TABLE `college_type`  (
  `type_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '类型编号',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型名',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `college_type` VALUES (8, '医药类');

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '写的好', '2022-10-19 21:43:34', 1, 3, 0, 0, 1, 3);
INSERT INTO `comment` VALUES (2, '111', '2022-10-19 21:52:43', 1, 1, 1, 3, 2, 0);
INSERT INTO `comment` VALUES (3, '2222', '2022-10-19 21:52:54', 1, 2, 2, 1, 3, 3);
INSERT INTO `comment` VALUES (4, '5555', '2022-10-19 21:54:36', 1, 6, 1, 3, 2, 2);
INSERT INTO `comment` VALUES (5, '好好好', '2022-10-19 21:54:49', 1, 1, 0, 0, 1, 5);
INSERT INTO `comment` VALUES (6, '真的写的好呀', '2022-11-05 14:59:08', 1, 1, 5, 1, 2, 0);
INSERT INTO `comment` VALUES (7, '好的呀', '2022-11-05 15:00:37', 1, 2, 0, 0, 1, 0);
INSERT INTO `comment` VALUES (8, '好的呀', '2022-11-10 20:35:55', 1, 1, 0, 0, 1, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

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
INSERT INTO `menu` VALUES (35, 'test', '测试', 'test', NULL, 1, 1, NULL);

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
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `question_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `question_type` tinyint(0) NULL DEFAULT NULL COMMENT '题目类型，1为单选，2为多选，3为判断，4为简答',
  `question_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '题干',
  `classify_id` int(0) NULL DEFAULT NULL COMMENT '题目分类id',
  `classify_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '题目分类名字',
  `document_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '题目附件',
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '题目答案',
  `analysis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '题目解析',
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 201 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '题目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, 1, '数学题1', 2, '数学', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (2, 1, '数学题2', 2, '数学', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (3, 1, '数学题3', 2, '数学', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (4, 1, '数学题4', 2, '数学', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (5, 1, '数学题5', 2, '数学', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (6, 1, '数学题6', 2, '数学', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (7, 1, '数学题7', 2, '数学', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (8, 1, '数学题8', 2, '数学', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (9, 1, '数学题9', 2, '数学', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (10, 1, '数学题10', 2, '数学', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (11, 1, '数学题11', 2, '数学', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (12, 1, '数学题12', 2, '数学', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (13, 1, '数学题13', 2, '数学', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (14, 1, '数学题14', 2, '数学', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (15, 1, '数学题15', 2, '数学', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (16, 1, '数学题16', 2, '数学', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (17, 1, '数学题17', 2, '数学', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (18, 1, '数学题18', 2, '数学', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (19, 1, '数学题19', 2, '数学', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (20, 1, '数学题20', 2, '数学', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (21, 1, '数学题21', 2, '数学', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (22, 1, '数学题22', 2, '数学', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (23, 1, '数学题23', 2, '数学', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (24, 1, '数学题24', 2, '数学', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (25, 1, '数学题25', 2, '数学', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (26, 1, '数学题26', 2, '数学', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (27, 1, '数学题27', 2, '数学', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (28, 1, '数学题28', 2, '数学', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (29, 1, '数学题29', 2, '数学', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (30, 1, '数学题30', 2, '数学', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (31, 1, '数学题31', 2, '数学', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (32, 1, '数学题32', 2, '数学', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (33, 1, '数学题33', 2, '数学', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (34, 1, '数学题34', 2, '数学', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (35, 1, '数学题35', 2, '数学', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (36, 1, '数学题36', 2, '数学', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (37, 1, '数学题37', 2, '数学', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (38, 1, '数学题38', 2, '数学', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (39, 1, '数学题39', 2, '数学', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (40, 1, '数学题40', 2, '数学', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (41, 1, '政治题1', 3, '政治', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (42, 1, '政治题2', 3, '政治', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (43, 1, '政治题3', 3, '政治', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (44, 1, '政治题4', 3, '政治', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (45, 1, '政治题5', 3, '政治', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (46, 1, '政治题6', 3, '政治', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (47, 1, '政治题7', 3, '政治', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (48, 1, '政治题8', 3, '政治', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (49, 1, '政治题9', 3, '政治', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (50, 1, '政治题10', 3, '政治', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (51, 1, '政治题11', 3, '政治', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (52, 1, '政治题12', 3, '政治', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (53, 1, '政治题13', 3, '政治', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (54, 1, '政治题14', 3, '政治', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (55, 1, '政治题15', 3, '政治', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (56, 1, '政治题16', 3, '政治', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (57, 1, '政治题17', 3, '政治', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (58, 1, '政治题18', 3, '政治', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (59, 1, '政治题19', 3, '政治', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (60, 1, '政治题20', 3, '政治', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (61, 1, '政治题21', 3, '政治', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (62, 1, '政治题22', 3, '政治', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (63, 1, '政治题23', 3, '政治', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (64, 1, '政治题24', 3, '政治', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (65, 1, '政治题25', 3, '政治', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (66, 1, '政治题26', 3, '政治', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (67, 1, '政治题27', 3, '政治', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (68, 1, '政治题28', 3, '政治', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (69, 1, '政治题29', 3, '政治', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (70, 1, '政治题30', 3, '政治', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (71, 1, '政治题31', 3, '政治', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (72, 1, '政治题32', 3, '政治', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (73, 1, '政治题33', 3, '政治', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (74, 1, '政治题34', 3, '政治', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (75, 1, '政治题35', 3, '政治', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (76, 1, '政治题36', 3, '政治', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (77, 1, '政治题37', 3, '政治', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (78, 1, '政治题38', 3, '政治', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (79, 1, '政治题39', 3, '政治', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (80, 1, '政治题40', 3, '政治', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (81, 1, '计算机网络1', 4, '计算机网络', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (82, 1, '计算机网络2', 4, '计算机网络', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (83, 1, '计算机网络3', 4, '计算机网络', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (84, 1, '计算机网络4', 4, '计算机网络', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (85, 1, '计算机网络5', 4, '计算机网络', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (86, 1, '计算机网络6', 4, '计算机网络', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (87, 1, '计算机网络7', 4, '计算机网络', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (88, 1, '计算机网络8', 4, '计算机网络', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (89, 1, '计算机网络9', 4, '计算机网络', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (90, 1, '计算机网络10', 4, '计算机网络', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (91, 1, '计算机网络11', 4, '计算机网络', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (92, 1, '计算机网络12', 4, '计算机网络', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (93, 1, '计算机网络13', 4, '计算机网络', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (94, 1, '计算机网络14', 4, '计算机网络', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (95, 1, '计算机网络15', 4, '计算机网络', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (96, 1, '计算机网络16', 4, '计算机网络', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (97, 1, '计算机网络17', 4, '计算机网络', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (98, 1, '计算机网络18', 4, '计算机网络', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (99, 1, '计算机网络19', 4, '计算机网络', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (100, 1, '计算机网络20', 4, '计算机网络', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (101, 1, '计算机网络21', 4, '计算机网络', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (102, 1, '计算机网络22', 4, '计算机网络', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (103, 1, '计算机网络23', 4, '计算机网络', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (104, 1, '计算机网络24', 4, '计算机网络', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (105, 1, '计算机网络25', 4, '计算机网络', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (106, 1, '计算机网络26', 4, '计算机网络', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (107, 1, '计算机网络27', 4, '计算机网络', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (108, 1, '计算机网络28', 4, '计算机网络', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (109, 1, '计算机网络29', 4, '计算机网络', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (110, 1, '计算机网络30', 4, '计算机网络', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (111, 1, '计算机网络31', 4, '计算机网络', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (112, 1, '计算机网络32', 4, '计算机网络', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (113, 1, '计算机网络33', 4, '计算机网络', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (114, 1, '计算机网络34', 4, '计算机网络', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (115, 1, '计算机网络35', 4, '计算机网络', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (116, 1, '计算机网络36', 4, '计算机网络', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (117, 1, '计算机网络37', 4, '计算机网络', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (118, 1, '计算机网络38', 4, '计算机网络', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (119, 1, '计算机网络39', 4, '计算机网络', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (120, 1, '计算机网络40', 4, '计算机网络', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (121, 1, '数据结构1', 5, '数据结构', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (122, 1, '数据结构2', 5, '数据结构', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (123, 1, '数据结构3', 5, '数据结构', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (124, 1, '数据结构4', 5, '数据结构', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (125, 1, '数据结构5', 5, '数据结构', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (126, 1, '数据结构6', 5, '数据结构', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (127, 1, '数据结构7', 5, '数据结构', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (128, 1, '数据结构8', 5, '数据结构', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (129, 1, '数据结构9', 5, '数据结构', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (130, 1, '数据结构10', 5, '数据结构', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (131, 1, '数据结构11', 5, '数据结构', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (132, 1, '数据结构12', 5, '数据结构', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (133, 1, '数据结构13', 5, '数据结构', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (134, 1, '数据结构14', 5, '数据结构', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (135, 1, '数据结构15', 5, '数据结构', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (136, 1, '数据结构16', 5, '数据结构', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (137, 1, '数据结构17', 5, '数据结构', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (138, 1, '数据结构18', 5, '数据结构', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (139, 1, '数据结构19', 5, '数据结构', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (140, 1, '数据结构20', 5, '数据结构', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (141, 1, '数据结构21', 5, '数据结构', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (142, 1, '数据结构22', 5, '数据结构', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (143, 1, '数据结构23', 5, '数据结构', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (144, 1, '数据结构24', 5, '数据结构', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (145, 1, '数据结构25', 5, '数据结构', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (146, 1, '数据结构26', 5, '数据结构', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (147, 1, '数据结构27', 5, '数据结构', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (148, 1, '数据结构28', 5, '数据结构', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (149, 1, '数据结构29', 5, '数据结构', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (150, 1, '数据结构30', 5, '数据结构', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (151, 1, '数据结构31', 5, '数据结构', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (152, 1, '数据结构32', 5, '数据结构', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (153, 1, '数据结构33', 5, '数据结构', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (154, 1, '数据结构34', 5, '数据结构', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (155, 1, '数据结构35', 5, '数据结构', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (156, 1, '数据结构36', 5, '数据结构', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (157, 1, '数据结构37', 5, '数据结构', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (158, 1, '数据结构38', 5, '数据结构', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (159, 1, '数据结构39', 5, '数据结构', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (160, 1, '数据结构40', 5, '数据结构', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (161, 1, '计算机组成原理1', 6, '计算机组成原理', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (162, 1, '计算机组成原理2', 6, '计算机组成原理', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (163, 1, '计算机组成原理3', 6, '计算机组成原理', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (164, 1, '计算机组成原理4', 6, '计算机组成原理', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (165, 1, '计算机组成原理5', 6, '计算机组成原理', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (166, 1, '计算机组成原理6', 6, '计算机组成原理', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (167, 1, '计算机组成原理7', 6, '计算机组成原理', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (168, 1, '计算机组成原理8', 6, '计算机组成原理', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (169, 1, '计算机组成原理9', 6, '计算机组成原理', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (170, 1, '计算机组成原理10', 6, '计算机组成原理', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (171, 1, '计算机组成原理11', 6, '计算机组成原理', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (172, 1, '计算机组成原理12', 6, '计算机组成原理', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (173, 1, '计算机组成原理13', 6, '计算机组成原理', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (174, 1, '计算机组成原理14', 6, '计算机组成原理', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (175, 1, '计算机组成原理15', 6, '计算机组成原理', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (176, 1, '计算机组成原理16', 6, '计算机组成原理', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (177, 1, '计算机组成原理17', 6, '计算机组成原理', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (178, 1, '计算机组成原理18', 6, '计算机组成原理', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (179, 1, '计算机组成原理19', 6, '计算机组成原理', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (180, 1, '计算机组成原理20', 6, '计算机组成原理', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (181, 1, '计算机组成原理21', 6, '计算机组成原理', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (182, 1, '计算机组成原理22', 6, '计算机组成原理', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (183, 1, '计算机组成原理23', 6, '计算机组成原理', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (184, 1, '计算机组成原理24', 6, '计算机组成原理', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (185, 1, '计算机组成原理25', 6, '计算机组成原理', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (186, 1, '计算机组成原理26', 6, '计算机组成原理', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (187, 1, '计算机组成原理27', 6, '计算机组成原理', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (188, 1, '计算机组成原理28', 6, '计算机组成原理', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (189, 1, '计算机组成原理29', 6, '计算机组成原理', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (190, 1, '计算机组成原理30', 6, '计算机组成原理', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (191, 1, '计算机组成原理31', 6, '计算机组成原理', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (192, 1, '计算机组成原理32', 6, '计算机组成原理', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (193, 1, '计算机组成原理33', 6, '计算机组成原理', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (194, 1, '计算机组成原理34', 6, '计算机组成原理', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (195, 1, '计算机组成原理35', 6, '计算机组成原理', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (196, 1, '计算机组成原理36', 6, '计算机组成原理', '无', 'C', '暂无答案解析');
INSERT INTO `question` VALUES (197, 1, '计算机组成原理37', 6, '计算机组成原理', '无', 'A', '暂无答案解析');
INSERT INTO `question` VALUES (198, 1, '计算机组成原理38', 6, '计算机组成原理', '无', 'D', '暂无答案解析');
INSERT INTO `question` VALUES (199, 1, '计算机组成原理39', 6, '计算机组成原理', '无', 'B', '暂无答案解析');
INSERT INTO `question` VALUES (200, 1, '计算机组成原理40', 6, '计算机组成原理', '无', 'C', '暂无答案解析');

-- ----------------------------
-- Table structure for question_choice
-- ----------------------------
DROP TABLE IF EXISTS `question_choice`;
CREATE TABLE `question_choice`  (
  `choice_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `question_id` int(0) NULL DEFAULT NULL COMMENT '所属题目id',
  `choice_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '选项（A,B,C...）',
  `choice_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '选项描述',
  PRIMARY KEY (`choice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 801 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '选择题选项表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_choice
-- ----------------------------
INSERT INTO `question_choice` VALUES (1, 1, 'A', '这是数学题1的选项A');
INSERT INTO `question_choice` VALUES (2, 1, 'B', '这是数学题1的选项B');
INSERT INTO `question_choice` VALUES (3, 1, 'C', '这是数学题1的选项C');
INSERT INTO `question_choice` VALUES (4, 1, 'D', '这是数学题1的选项D');
INSERT INTO `question_choice` VALUES (5, 2, 'A', '这是数学题2的选项A');
INSERT INTO `question_choice` VALUES (6, 2, 'B', '这是数学题2的选项B');
INSERT INTO `question_choice` VALUES (7, 2, 'C', '这是数学题2的选项C');
INSERT INTO `question_choice` VALUES (8, 2, 'D', '这是数学题2的选项D');
INSERT INTO `question_choice` VALUES (9, 3, 'A', '这是数学题3的选项A');
INSERT INTO `question_choice` VALUES (10, 3, 'B', '这是数学题3的选项B');
INSERT INTO `question_choice` VALUES (11, 3, 'C', '这是数学题3的选项C');
INSERT INTO `question_choice` VALUES (12, 3, 'D', '这是数学题3的选项D');
INSERT INTO `question_choice` VALUES (13, 4, 'A', '这是数学题4的选项A');
INSERT INTO `question_choice` VALUES (14, 4, 'B', '这是数学题4的选项B');
INSERT INTO `question_choice` VALUES (15, 4, 'C', '这是数学题4的选项C');
INSERT INTO `question_choice` VALUES (16, 4, 'D', '这是数学题4的选项D');
INSERT INTO `question_choice` VALUES (17, 5, 'A', '这是数学题5的选项A');
INSERT INTO `question_choice` VALUES (18, 5, 'B', '这是数学题5的选项B');
INSERT INTO `question_choice` VALUES (19, 5, 'C', '这是数学题5的选项C');
INSERT INTO `question_choice` VALUES (20, 5, 'D', '这是数学题5的选项D');
INSERT INTO `question_choice` VALUES (21, 6, 'A', '这是数学题6的选项A');
INSERT INTO `question_choice` VALUES (22, 6, 'B', '这是数学题6的选项B');
INSERT INTO `question_choice` VALUES (23, 6, 'C', '这是数学题6的选项C');
INSERT INTO `question_choice` VALUES (24, 6, 'D', '这是数学题6的选项D');
INSERT INTO `question_choice` VALUES (25, 7, 'A', '这是数学题7的选项A');
INSERT INTO `question_choice` VALUES (26, 7, 'B', '这是数学题7的选项B');
INSERT INTO `question_choice` VALUES (27, 7, 'C', '这是数学题7的选项C');
INSERT INTO `question_choice` VALUES (28, 7, 'D', '这是数学题7的选项D');
INSERT INTO `question_choice` VALUES (29, 8, 'A', '这是数学题8的选项A');
INSERT INTO `question_choice` VALUES (30, 8, 'B', '这是数学题8的选项B');
INSERT INTO `question_choice` VALUES (31, 8, 'C', '这是数学题8的选项C');
INSERT INTO `question_choice` VALUES (32, 8, 'D', '这是数学题8的选项D');
INSERT INTO `question_choice` VALUES (33, 9, 'A', '这是数学题9的选项A');
INSERT INTO `question_choice` VALUES (34, 9, 'B', '这是数学题9的选项B');
INSERT INTO `question_choice` VALUES (35, 9, 'C', '这是数学题9的选项C');
INSERT INTO `question_choice` VALUES (36, 9, 'D', '这是数学题9的选项D');
INSERT INTO `question_choice` VALUES (37, 10, 'A', '这是数学题10的选项A');
INSERT INTO `question_choice` VALUES (38, 10, 'B', '这是数学题10的选项B');
INSERT INTO `question_choice` VALUES (39, 10, 'C', '这是数学题10的选项C');
INSERT INTO `question_choice` VALUES (40, 10, 'D', '这是数学题10的选项D');
INSERT INTO `question_choice` VALUES (41, 11, 'A', '这是数学题11的选项A');
INSERT INTO `question_choice` VALUES (42, 11, 'B', '这是数学题11的选项B');
INSERT INTO `question_choice` VALUES (43, 11, 'C', '这是数学题11的选项C');
INSERT INTO `question_choice` VALUES (44, 11, 'D', '这是数学题11的选项D');
INSERT INTO `question_choice` VALUES (45, 12, 'A', '这是数学题12的选项A');
INSERT INTO `question_choice` VALUES (46, 12, 'B', '这是数学题12的选项B');
INSERT INTO `question_choice` VALUES (47, 12, 'C', '这是数学题12的选项C');
INSERT INTO `question_choice` VALUES (48, 12, 'D', '这是数学题12的选项D');
INSERT INTO `question_choice` VALUES (49, 13, 'A', '这是数学题13的选项A');
INSERT INTO `question_choice` VALUES (50, 13, 'B', '这是数学题13的选项B');
INSERT INTO `question_choice` VALUES (51, 13, 'C', '这是数学题13的选项C');
INSERT INTO `question_choice` VALUES (52, 13, 'D', '这是数学题13的选项D');
INSERT INTO `question_choice` VALUES (53, 14, 'A', '这是数学题14的选项A');
INSERT INTO `question_choice` VALUES (54, 14, 'B', '这是数学题14的选项B');
INSERT INTO `question_choice` VALUES (55, 14, 'C', '这是数学题14的选项C');
INSERT INTO `question_choice` VALUES (56, 14, 'D', '这是数学题14的选项D');
INSERT INTO `question_choice` VALUES (57, 15, 'A', '这是数学题15的选项A');
INSERT INTO `question_choice` VALUES (58, 15, 'B', '这是数学题15的选项B');
INSERT INTO `question_choice` VALUES (59, 15, 'C', '这是数学题15的选项C');
INSERT INTO `question_choice` VALUES (60, 15, 'D', '这是数学题15的选项D');
INSERT INTO `question_choice` VALUES (61, 16, 'A', '这是数学题16的选项A');
INSERT INTO `question_choice` VALUES (62, 16, 'B', '这是数学题16的选项B');
INSERT INTO `question_choice` VALUES (63, 16, 'C', '这是数学题16的选项C');
INSERT INTO `question_choice` VALUES (64, 16, 'D', '这是数学题16的选项D');
INSERT INTO `question_choice` VALUES (65, 17, 'A', '这是数学题17的选项A');
INSERT INTO `question_choice` VALUES (66, 17, 'B', '这是数学题17的选项B');
INSERT INTO `question_choice` VALUES (67, 17, 'C', '这是数学题17的选项C');
INSERT INTO `question_choice` VALUES (68, 17, 'D', '这是数学题17的选项D');
INSERT INTO `question_choice` VALUES (69, 18, 'A', '这是数学题18的选项A');
INSERT INTO `question_choice` VALUES (70, 18, 'B', '这是数学题18的选项B');
INSERT INTO `question_choice` VALUES (71, 18, 'C', '这是数学题18的选项C');
INSERT INTO `question_choice` VALUES (72, 18, 'D', '这是数学题18的选项D');
INSERT INTO `question_choice` VALUES (73, 19, 'A', '这是数学题19的选项A');
INSERT INTO `question_choice` VALUES (74, 19, 'B', '这是数学题19的选项B');
INSERT INTO `question_choice` VALUES (75, 19, 'C', '这是数学题19的选项C');
INSERT INTO `question_choice` VALUES (76, 19, 'D', '这是数学题19的选项D');
INSERT INTO `question_choice` VALUES (77, 20, 'A', '这是数学题20的选项A');
INSERT INTO `question_choice` VALUES (78, 20, 'B', '这是数学题20的选项B');
INSERT INTO `question_choice` VALUES (79, 20, 'C', '这是数学题20的选项C');
INSERT INTO `question_choice` VALUES (80, 20, 'D', '这是数学题20的选项D');
INSERT INTO `question_choice` VALUES (81, 21, 'A', '这是数学题21的选项A');
INSERT INTO `question_choice` VALUES (82, 21, 'B', '这是数学题21的选项B');
INSERT INTO `question_choice` VALUES (83, 21, 'C', '这是数学题21的选项C');
INSERT INTO `question_choice` VALUES (84, 21, 'D', '这是数学题21的选项D');
INSERT INTO `question_choice` VALUES (85, 22, 'A', '这是数学题22的选项A');
INSERT INTO `question_choice` VALUES (86, 22, 'B', '这是数学题22的选项B');
INSERT INTO `question_choice` VALUES (87, 22, 'C', '这是数学题22的选项C');
INSERT INTO `question_choice` VALUES (88, 22, 'D', '这是数学题22的选项D');
INSERT INTO `question_choice` VALUES (89, 23, 'A', '这是数学题23的选项A');
INSERT INTO `question_choice` VALUES (90, 23, 'B', '这是数学题23的选项B');
INSERT INTO `question_choice` VALUES (91, 23, 'C', '这是数学题23的选项C');
INSERT INTO `question_choice` VALUES (92, 23, 'D', '这是数学题23的选项D');
INSERT INTO `question_choice` VALUES (93, 24, 'A', '这是数学题24的选项A');
INSERT INTO `question_choice` VALUES (94, 24, 'B', '这是数学题24的选项B');
INSERT INTO `question_choice` VALUES (95, 24, 'C', '这是数学题24的选项C');
INSERT INTO `question_choice` VALUES (96, 24, 'D', '这是数学题24的选项D');
INSERT INTO `question_choice` VALUES (97, 25, 'A', '这是数学题25的选项A');
INSERT INTO `question_choice` VALUES (98, 25, 'B', '这是数学题25的选项B');
INSERT INTO `question_choice` VALUES (99, 25, 'C', '这是数学题25的选项C');
INSERT INTO `question_choice` VALUES (100, 25, 'D', '这是数学题25的选项D');
INSERT INTO `question_choice` VALUES (101, 26, 'A', '这是数学题26的选项A');
INSERT INTO `question_choice` VALUES (102, 26, 'B', '这是数学题26的选项B');
INSERT INTO `question_choice` VALUES (103, 26, 'C', '这是数学题26的选项C');
INSERT INTO `question_choice` VALUES (104, 26, 'D', '这是数学题26的选项D');
INSERT INTO `question_choice` VALUES (105, 27, 'A', '这是数学题27的选项A');
INSERT INTO `question_choice` VALUES (106, 27, 'B', '这是数学题27的选项B');
INSERT INTO `question_choice` VALUES (107, 27, 'C', '这是数学题27的选项C');
INSERT INTO `question_choice` VALUES (108, 27, 'D', '这是数学题27的选项D');
INSERT INTO `question_choice` VALUES (109, 28, 'A', '这是数学题28的选项A');
INSERT INTO `question_choice` VALUES (110, 28, 'B', '这是数学题28的选项B');
INSERT INTO `question_choice` VALUES (111, 28, 'C', '这是数学题28的选项C');
INSERT INTO `question_choice` VALUES (112, 28, 'D', '这是数学题28的选项D');
INSERT INTO `question_choice` VALUES (113, 29, 'A', '这是数学题29的选项A');
INSERT INTO `question_choice` VALUES (114, 29, 'B', '这是数学题29的选项B');
INSERT INTO `question_choice` VALUES (115, 29, 'C', '这是数学题29的选项C');
INSERT INTO `question_choice` VALUES (116, 29, 'D', '这是数学题29的选项D');
INSERT INTO `question_choice` VALUES (117, 30, 'A', '这是数学题30的选项A');
INSERT INTO `question_choice` VALUES (118, 30, 'B', '这是数学题30的选项B');
INSERT INTO `question_choice` VALUES (119, 30, 'C', '这是数学题30的选项C');
INSERT INTO `question_choice` VALUES (120, 30, 'D', '这是数学题30的选项D');
INSERT INTO `question_choice` VALUES (121, 31, 'A', '这是数学题31的选项A');
INSERT INTO `question_choice` VALUES (122, 31, 'B', '这是数学题31的选项B');
INSERT INTO `question_choice` VALUES (123, 31, 'C', '这是数学题31的选项C');
INSERT INTO `question_choice` VALUES (124, 31, 'D', '这是数学题31的选项D');
INSERT INTO `question_choice` VALUES (125, 32, 'A', '这是数学题32的选项A');
INSERT INTO `question_choice` VALUES (126, 32, 'B', '这是数学题32的选项B');
INSERT INTO `question_choice` VALUES (127, 32, 'C', '这是数学题32的选项C');
INSERT INTO `question_choice` VALUES (128, 32, 'D', '这是数学题32的选项D');
INSERT INTO `question_choice` VALUES (129, 33, 'A', '这是数学题33的选项A');
INSERT INTO `question_choice` VALUES (130, 33, 'B', '这是数学题33的选项B');
INSERT INTO `question_choice` VALUES (131, 33, 'C', '这是数学题33的选项C');
INSERT INTO `question_choice` VALUES (132, 33, 'D', '这是数学题33的选项D');
INSERT INTO `question_choice` VALUES (133, 34, 'A', '这是数学题34的选项A');
INSERT INTO `question_choice` VALUES (134, 34, 'B', '这是数学题34的选项B');
INSERT INTO `question_choice` VALUES (135, 34, 'C', '这是数学题34的选项C');
INSERT INTO `question_choice` VALUES (136, 34, 'D', '这是数学题34的选项D');
INSERT INTO `question_choice` VALUES (137, 35, 'A', '这是数学题35的选项A');
INSERT INTO `question_choice` VALUES (138, 35, 'B', '这是数学题35的选项B');
INSERT INTO `question_choice` VALUES (139, 35, 'C', '这是数学题35的选项C');
INSERT INTO `question_choice` VALUES (140, 35, 'D', '这是数学题35的选项D');
INSERT INTO `question_choice` VALUES (141, 36, 'A', '这是数学题36的选项A');
INSERT INTO `question_choice` VALUES (142, 36, 'B', '这是数学题36的选项B');
INSERT INTO `question_choice` VALUES (143, 36, 'C', '这是数学题36的选项C');
INSERT INTO `question_choice` VALUES (144, 36, 'D', '这是数学题36的选项D');
INSERT INTO `question_choice` VALUES (145, 37, 'A', '这是数学题37的选项A');
INSERT INTO `question_choice` VALUES (146, 37, 'B', '这是数学题37的选项B');
INSERT INTO `question_choice` VALUES (147, 37, 'C', '这是数学题37的选项C');
INSERT INTO `question_choice` VALUES (148, 37, 'D', '这是数学题37的选项D');
INSERT INTO `question_choice` VALUES (149, 38, 'A', '这是数学题38的选项A');
INSERT INTO `question_choice` VALUES (150, 38, 'B', '这是数学题38的选项B');
INSERT INTO `question_choice` VALUES (151, 38, 'C', '这是数学题38的选项C');
INSERT INTO `question_choice` VALUES (152, 38, 'D', '这是数学题38的选项D');
INSERT INTO `question_choice` VALUES (153, 39, 'A', '这是数学题39的选项A');
INSERT INTO `question_choice` VALUES (154, 39, 'B', '这是数学题39的选项B');
INSERT INTO `question_choice` VALUES (155, 39, 'C', '这是数学题39的选项C');
INSERT INTO `question_choice` VALUES (156, 39, 'D', '这是数学题39的选项D');
INSERT INTO `question_choice` VALUES (157, 40, 'A', '这是数学题40的选项A');
INSERT INTO `question_choice` VALUES (158, 40, 'B', '这是数学题40的选项B');
INSERT INTO `question_choice` VALUES (159, 40, 'C', '这是数学题40的选项C');
INSERT INTO `question_choice` VALUES (160, 40, 'D', '这是数学题40的选项D');
INSERT INTO `question_choice` VALUES (161, 41, 'A', '这是政治题1的选项A');
INSERT INTO `question_choice` VALUES (162, 41, 'B', '这是政治题1的选项B');
INSERT INTO `question_choice` VALUES (163, 41, 'C', '这是政治题1的选项C');
INSERT INTO `question_choice` VALUES (164, 41, 'D', '这是政治题1的选项D');
INSERT INTO `question_choice` VALUES (165, 42, 'A', '这是政治题2的选项A');
INSERT INTO `question_choice` VALUES (166, 42, 'B', '这是政治题2的选项B');
INSERT INTO `question_choice` VALUES (167, 42, 'C', '这是政治题2的选项C');
INSERT INTO `question_choice` VALUES (168, 42, 'D', '这是政治题2的选项D');
INSERT INTO `question_choice` VALUES (169, 43, 'A', '这是政治题3的选项A');
INSERT INTO `question_choice` VALUES (170, 43, 'B', '这是政治题3的选项B');
INSERT INTO `question_choice` VALUES (171, 43, 'C', '这是政治题3的选项C');
INSERT INTO `question_choice` VALUES (172, 43, 'D', '这是政治题3的选项D');
INSERT INTO `question_choice` VALUES (173, 44, 'A', '这是政治题4的选项A');
INSERT INTO `question_choice` VALUES (174, 44, 'B', '这是政治题4的选项B');
INSERT INTO `question_choice` VALUES (175, 44, 'C', '这是政治题4的选项C');
INSERT INTO `question_choice` VALUES (176, 44, 'D', '这是政治题4的选项D');
INSERT INTO `question_choice` VALUES (177, 45, 'A', '这是政治题5的选项A');
INSERT INTO `question_choice` VALUES (178, 45, 'B', '这是政治题5的选项B');
INSERT INTO `question_choice` VALUES (179, 45, 'C', '这是政治题5的选项C');
INSERT INTO `question_choice` VALUES (180, 45, 'D', '这是政治题5的选项D');
INSERT INTO `question_choice` VALUES (181, 46, 'A', '这是政治题6的选项A');
INSERT INTO `question_choice` VALUES (182, 46, 'B', '这是政治题6的选项B');
INSERT INTO `question_choice` VALUES (183, 46, 'C', '这是政治题6的选项C');
INSERT INTO `question_choice` VALUES (184, 46, 'D', '这是政治题6的选项D');
INSERT INTO `question_choice` VALUES (185, 47, 'A', '这是政治题7的选项A');
INSERT INTO `question_choice` VALUES (186, 47, 'B', '这是政治题7的选项B');
INSERT INTO `question_choice` VALUES (187, 47, 'C', '这是政治题7的选项C');
INSERT INTO `question_choice` VALUES (188, 47, 'D', '这是政治题7的选项D');
INSERT INTO `question_choice` VALUES (189, 48, 'A', '这是政治题8的选项A');
INSERT INTO `question_choice` VALUES (190, 48, 'B', '这是政治题8的选项B');
INSERT INTO `question_choice` VALUES (191, 48, 'C', '这是政治题8的选项C');
INSERT INTO `question_choice` VALUES (192, 48, 'D', '这是政治题8的选项D');
INSERT INTO `question_choice` VALUES (193, 49, 'A', '这是政治题9的选项A');
INSERT INTO `question_choice` VALUES (194, 49, 'B', '这是政治题9的选项B');
INSERT INTO `question_choice` VALUES (195, 49, 'C', '这是政治题9的选项C');
INSERT INTO `question_choice` VALUES (196, 49, 'D', '这是政治题9的选项D');
INSERT INTO `question_choice` VALUES (197, 50, 'A', '这是政治题10的选项A');
INSERT INTO `question_choice` VALUES (198, 50, 'B', '这是政治题10的选项B');
INSERT INTO `question_choice` VALUES (199, 50, 'C', '这是政治题10的选项C');
INSERT INTO `question_choice` VALUES (200, 50, 'D', '这是政治题10的选项D');
INSERT INTO `question_choice` VALUES (201, 51, 'A', '这是政治题11的选项A');
INSERT INTO `question_choice` VALUES (202, 51, 'B', '这是政治题11的选项B');
INSERT INTO `question_choice` VALUES (203, 51, 'C', '这是政治题11的选项C');
INSERT INTO `question_choice` VALUES (204, 51, 'D', '这是政治题11的选项D');
INSERT INTO `question_choice` VALUES (205, 52, 'A', '这是政治题12的选项A');
INSERT INTO `question_choice` VALUES (206, 52, 'B', '这是政治题12的选项B');
INSERT INTO `question_choice` VALUES (207, 52, 'C', '这是政治题12的选项C');
INSERT INTO `question_choice` VALUES (208, 52, 'D', '这是政治题12的选项D');
INSERT INTO `question_choice` VALUES (209, 53, 'A', '这是政治题13的选项A');
INSERT INTO `question_choice` VALUES (210, 53, 'B', '这是政治题13的选项B');
INSERT INTO `question_choice` VALUES (211, 53, 'C', '这是政治题13的选项C');
INSERT INTO `question_choice` VALUES (212, 53, 'D', '这是政治题13的选项D');
INSERT INTO `question_choice` VALUES (213, 54, 'A', '这是政治题14的选项A');
INSERT INTO `question_choice` VALUES (214, 54, 'B', '这是政治题14的选项B');
INSERT INTO `question_choice` VALUES (215, 54, 'C', '这是政治题14的选项C');
INSERT INTO `question_choice` VALUES (216, 54, 'D', '这是政治题14的选项D');
INSERT INTO `question_choice` VALUES (217, 55, 'A', '这是政治题15的选项A');
INSERT INTO `question_choice` VALUES (218, 55, 'B', '这是政治题15的选项B');
INSERT INTO `question_choice` VALUES (219, 55, 'C', '这是政治题15的选项C');
INSERT INTO `question_choice` VALUES (220, 55, 'D', '这是政治题15的选项D');
INSERT INTO `question_choice` VALUES (221, 56, 'A', '这是政治题16的选项A');
INSERT INTO `question_choice` VALUES (222, 56, 'B', '这是政治题16的选项B');
INSERT INTO `question_choice` VALUES (223, 56, 'C', '这是政治题16的选项C');
INSERT INTO `question_choice` VALUES (224, 56, 'D', '这是政治题16的选项D');
INSERT INTO `question_choice` VALUES (225, 57, 'A', '这是政治题17的选项A');
INSERT INTO `question_choice` VALUES (226, 57, 'B', '这是政治题17的选项B');
INSERT INTO `question_choice` VALUES (227, 57, 'C', '这是政治题17的选项C');
INSERT INTO `question_choice` VALUES (228, 57, 'D', '这是政治题17的选项D');
INSERT INTO `question_choice` VALUES (229, 58, 'A', '这是政治题18的选项A');
INSERT INTO `question_choice` VALUES (230, 58, 'B', '这是政治题18的选项B');
INSERT INTO `question_choice` VALUES (231, 58, 'C', '这是政治题18的选项C');
INSERT INTO `question_choice` VALUES (232, 58, 'D', '这是政治题18的选项D');
INSERT INTO `question_choice` VALUES (233, 59, 'A', '这是政治题19的选项A');
INSERT INTO `question_choice` VALUES (234, 59, 'B', '这是政治题19的选项B');
INSERT INTO `question_choice` VALUES (235, 59, 'C', '这是政治题19的选项C');
INSERT INTO `question_choice` VALUES (236, 59, 'D', '这是政治题19的选项D');
INSERT INTO `question_choice` VALUES (237, 60, 'A', '这是政治题20的选项A');
INSERT INTO `question_choice` VALUES (238, 60, 'B', '这是政治题20的选项B');
INSERT INTO `question_choice` VALUES (239, 60, 'C', '这是政治题20的选项C');
INSERT INTO `question_choice` VALUES (240, 60, 'D', '这是政治题20的选项D');
INSERT INTO `question_choice` VALUES (241, 61, 'A', '这是政治题21的选项A');
INSERT INTO `question_choice` VALUES (242, 61, 'B', '这是政治题21的选项B');
INSERT INTO `question_choice` VALUES (243, 61, 'C', '这是政治题21的选项C');
INSERT INTO `question_choice` VALUES (244, 61, 'D', '这是政治题21的选项D');
INSERT INTO `question_choice` VALUES (245, 62, 'A', '这是政治题22的选项A');
INSERT INTO `question_choice` VALUES (246, 62, 'B', '这是政治题22的选项B');
INSERT INTO `question_choice` VALUES (247, 62, 'C', '这是政治题22的选项C');
INSERT INTO `question_choice` VALUES (248, 62, 'D', '这是政治题22的选项D');
INSERT INTO `question_choice` VALUES (249, 63, 'A', '这是政治题23的选项A');
INSERT INTO `question_choice` VALUES (250, 63, 'B', '这是政治题23的选项B');
INSERT INTO `question_choice` VALUES (251, 63, 'C', '这是政治题23的选项C');
INSERT INTO `question_choice` VALUES (252, 63, 'D', '这是政治题23的选项D');
INSERT INTO `question_choice` VALUES (253, 64, 'A', '这是政治题24的选项A');
INSERT INTO `question_choice` VALUES (254, 64, 'B', '这是政治题24的选项B');
INSERT INTO `question_choice` VALUES (255, 64, 'C', '这是政治题24的选项C');
INSERT INTO `question_choice` VALUES (256, 64, 'D', '这是政治题24的选项D');
INSERT INTO `question_choice` VALUES (257, 65, 'A', '这是政治题25的选项A');
INSERT INTO `question_choice` VALUES (258, 65, 'B', '这是政治题25的选项B');
INSERT INTO `question_choice` VALUES (259, 65, 'C', '这是政治题25的选项C');
INSERT INTO `question_choice` VALUES (260, 65, 'D', '这是政治题25的选项D');
INSERT INTO `question_choice` VALUES (261, 66, 'A', '这是政治题26的选项A');
INSERT INTO `question_choice` VALUES (262, 66, 'B', '这是政治题26的选项B');
INSERT INTO `question_choice` VALUES (263, 66, 'C', '这是政治题26的选项C');
INSERT INTO `question_choice` VALUES (264, 66, 'D', '这是政治题26的选项D');
INSERT INTO `question_choice` VALUES (265, 67, 'A', '这是政治题27的选项A');
INSERT INTO `question_choice` VALUES (266, 67, 'B', '这是政治题27的选项B');
INSERT INTO `question_choice` VALUES (267, 67, 'C', '这是政治题27的选项C');
INSERT INTO `question_choice` VALUES (268, 67, 'D', '这是政治题27的选项D');
INSERT INTO `question_choice` VALUES (269, 68, 'A', '这是政治题28的选项A');
INSERT INTO `question_choice` VALUES (270, 68, 'B', '这是政治题28的选项B');
INSERT INTO `question_choice` VALUES (271, 68, 'C', '这是政治题28的选项C');
INSERT INTO `question_choice` VALUES (272, 68, 'D', '这是政治题28的选项D');
INSERT INTO `question_choice` VALUES (273, 69, 'A', '这是政治题29的选项A');
INSERT INTO `question_choice` VALUES (274, 69, 'B', '这是政治题29的选项B');
INSERT INTO `question_choice` VALUES (275, 69, 'C', '这是政治题29的选项C');
INSERT INTO `question_choice` VALUES (276, 69, 'D', '这是政治题29的选项D');
INSERT INTO `question_choice` VALUES (277, 70, 'A', '这是政治题30的选项A');
INSERT INTO `question_choice` VALUES (278, 70, 'B', '这是政治题30的选项B');
INSERT INTO `question_choice` VALUES (279, 70, 'C', '这是政治题30的选项C');
INSERT INTO `question_choice` VALUES (280, 70, 'D', '这是政治题30的选项D');
INSERT INTO `question_choice` VALUES (281, 71, 'A', '这是政治题31的选项A');
INSERT INTO `question_choice` VALUES (282, 71, 'B', '这是政治题31的选项B');
INSERT INTO `question_choice` VALUES (283, 71, 'C', '这是政治题31的选项C');
INSERT INTO `question_choice` VALUES (284, 71, 'D', '这是政治题31的选项D');
INSERT INTO `question_choice` VALUES (285, 72, 'A', '这是政治题32的选项A');
INSERT INTO `question_choice` VALUES (286, 72, 'B', '这是政治题32的选项B');
INSERT INTO `question_choice` VALUES (287, 72, 'C', '这是政治题32的选项C');
INSERT INTO `question_choice` VALUES (288, 72, 'D', '这是政治题32的选项D');
INSERT INTO `question_choice` VALUES (289, 73, 'A', '这是政治题33的选项A');
INSERT INTO `question_choice` VALUES (290, 73, 'B', '这是政治题33的选项B');
INSERT INTO `question_choice` VALUES (291, 73, 'C', '这是政治题33的选项C');
INSERT INTO `question_choice` VALUES (292, 73, 'D', '这是政治题33的选项D');
INSERT INTO `question_choice` VALUES (293, 74, 'A', '这是政治题34的选项A');
INSERT INTO `question_choice` VALUES (294, 74, 'B', '这是政治题34的选项B');
INSERT INTO `question_choice` VALUES (295, 74, 'C', '这是政治题34的选项C');
INSERT INTO `question_choice` VALUES (296, 74, 'D', '这是政治题34的选项D');
INSERT INTO `question_choice` VALUES (297, 75, 'A', '这是政治题35的选项A');
INSERT INTO `question_choice` VALUES (298, 75, 'B', '这是政治题35的选项B');
INSERT INTO `question_choice` VALUES (299, 75, 'C', '这是政治题35的选项C');
INSERT INTO `question_choice` VALUES (300, 75, 'D', '这是政治题35的选项D');
INSERT INTO `question_choice` VALUES (301, 76, 'A', '这是政治题36的选项A');
INSERT INTO `question_choice` VALUES (302, 76, 'B', '这是政治题36的选项B');
INSERT INTO `question_choice` VALUES (303, 76, 'C', '这是政治题36的选项C');
INSERT INTO `question_choice` VALUES (304, 76, 'D', '这是政治题36的选项D');
INSERT INTO `question_choice` VALUES (305, 77, 'A', '这是政治题37的选项A');
INSERT INTO `question_choice` VALUES (306, 77, 'B', '这是政治题37的选项B');
INSERT INTO `question_choice` VALUES (307, 77, 'C', '这是政治题37的选项C');
INSERT INTO `question_choice` VALUES (308, 77, 'D', '这是政治题37的选项D');
INSERT INTO `question_choice` VALUES (309, 78, 'A', '这是政治题38的选项A');
INSERT INTO `question_choice` VALUES (310, 78, 'B', '这是政治题38的选项B');
INSERT INTO `question_choice` VALUES (311, 78, 'C', '这是政治题38的选项C');
INSERT INTO `question_choice` VALUES (312, 78, 'D', '这是政治题38的选项D');
INSERT INTO `question_choice` VALUES (313, 79, 'A', '这是政治题39的选项A');
INSERT INTO `question_choice` VALUES (314, 79, 'B', '这是政治题39的选项B');
INSERT INTO `question_choice` VALUES (315, 79, 'C', '这是政治题39的选项C');
INSERT INTO `question_choice` VALUES (316, 79, 'D', '这是政治题39的选项D');
INSERT INTO `question_choice` VALUES (317, 80, 'A', '这是政治题40的选项A');
INSERT INTO `question_choice` VALUES (318, 80, 'B', '这是政治题40的选项B');
INSERT INTO `question_choice` VALUES (319, 80, 'C', '这是政治题40的选项C');
INSERT INTO `question_choice` VALUES (320, 80, 'D', '这是政治题40的选项D');
INSERT INTO `question_choice` VALUES (321, 81, 'A', '这是计算机网络题1的选项A');
INSERT INTO `question_choice` VALUES (322, 81, 'B', '这是计算机网络题1的选项B');
INSERT INTO `question_choice` VALUES (323, 81, 'C', '这是计算机网络题1的选项C');
INSERT INTO `question_choice` VALUES (324, 81, 'D', '这是计算机网络题1的选项D');
INSERT INTO `question_choice` VALUES (325, 82, 'A', '这是计算机网络题2的选项A');
INSERT INTO `question_choice` VALUES (326, 82, 'B', '这是计算机网络题2的选项B');
INSERT INTO `question_choice` VALUES (327, 82, 'C', '这是计算机网络题2的选项C');
INSERT INTO `question_choice` VALUES (328, 82, 'D', '这是计算机网络题2的选项D');
INSERT INTO `question_choice` VALUES (329, 83, 'A', '这是计算机网络题3的选项A');
INSERT INTO `question_choice` VALUES (330, 83, 'B', '这是计算机网络题3的选项B');
INSERT INTO `question_choice` VALUES (331, 83, 'C', '这是计算机网络题3的选项C');
INSERT INTO `question_choice` VALUES (332, 83, 'D', '这是计算机网络题3的选项D');
INSERT INTO `question_choice` VALUES (333, 84, 'A', '这是计算机网络题4的选项A');
INSERT INTO `question_choice` VALUES (334, 84, 'B', '这是计算机网络题4的选项B');
INSERT INTO `question_choice` VALUES (335, 84, 'C', '这是计算机网络题4的选项C');
INSERT INTO `question_choice` VALUES (336, 84, 'D', '这是计算机网络题4的选项D');
INSERT INTO `question_choice` VALUES (337, 85, 'A', '这是计算机网络题5的选项A');
INSERT INTO `question_choice` VALUES (338, 85, 'B', '这是计算机网络题5的选项B');
INSERT INTO `question_choice` VALUES (339, 85, 'C', '这是计算机网络题5的选项C');
INSERT INTO `question_choice` VALUES (340, 85, 'D', '这是计算机网络题5的选项D');
INSERT INTO `question_choice` VALUES (341, 86, 'A', '这是计算机网络题6的选项A');
INSERT INTO `question_choice` VALUES (342, 86, 'B', '这是计算机网络题6的选项B');
INSERT INTO `question_choice` VALUES (343, 86, 'C', '这是计算机网络题6的选项C');
INSERT INTO `question_choice` VALUES (344, 86, 'D', '这是计算机网络题6的选项D');
INSERT INTO `question_choice` VALUES (345, 87, 'A', '这是计算机网络题7的选项A');
INSERT INTO `question_choice` VALUES (346, 87, 'B', '这是计算机网络题7的选项B');
INSERT INTO `question_choice` VALUES (347, 87, 'C', '这是计算机网络题7的选项C');
INSERT INTO `question_choice` VALUES (348, 87, 'D', '这是计算机网络题7的选项D');
INSERT INTO `question_choice` VALUES (349, 88, 'A', '这是计算机网络题8的选项A');
INSERT INTO `question_choice` VALUES (350, 88, 'B', '这是计算机网络题8的选项B');
INSERT INTO `question_choice` VALUES (351, 88, 'C', '这是计算机网络题8的选项C');
INSERT INTO `question_choice` VALUES (352, 88, 'D', '这是计算机网络题8的选项D');
INSERT INTO `question_choice` VALUES (353, 89, 'A', '这是计算机网络题9的选项A');
INSERT INTO `question_choice` VALUES (354, 89, 'B', '这是计算机网络题9的选项B');
INSERT INTO `question_choice` VALUES (355, 89, 'C', '这是计算机网络题9的选项C');
INSERT INTO `question_choice` VALUES (356, 89, 'D', '这是计算机网络题9的选项D');
INSERT INTO `question_choice` VALUES (357, 90, 'A', '这是计算机网络题10的选项A');
INSERT INTO `question_choice` VALUES (358, 90, 'B', '这是计算机网络题10的选项B');
INSERT INTO `question_choice` VALUES (359, 90, 'C', '这是计算机网络题10的选项C');
INSERT INTO `question_choice` VALUES (360, 90, 'D', '这是计算机网络题10的选项D');
INSERT INTO `question_choice` VALUES (361, 91, 'A', '这是计算机网络题11的选项A');
INSERT INTO `question_choice` VALUES (362, 91, 'B', '这是计算机网络题11的选项B');
INSERT INTO `question_choice` VALUES (363, 91, 'C', '这是计算机网络题11的选项C');
INSERT INTO `question_choice` VALUES (364, 91, 'D', '这是计算机网络题11的选项D');
INSERT INTO `question_choice` VALUES (365, 92, 'A', '这是计算机网络题12的选项A');
INSERT INTO `question_choice` VALUES (366, 92, 'B', '这是计算机网络题12的选项B');
INSERT INTO `question_choice` VALUES (367, 92, 'C', '这是计算机网络题12的选项C');
INSERT INTO `question_choice` VALUES (368, 92, 'D', '这是计算机网络题12的选项D');
INSERT INTO `question_choice` VALUES (369, 93, 'A', '这是计算机网络题13的选项A');
INSERT INTO `question_choice` VALUES (370, 93, 'B', '这是计算机网络题13的选项B');
INSERT INTO `question_choice` VALUES (371, 93, 'C', '这是计算机网络题13的选项C');
INSERT INTO `question_choice` VALUES (372, 93, 'D', '这是计算机网络题13的选项D');
INSERT INTO `question_choice` VALUES (373, 94, 'A', '这是计算机网络题14的选项A');
INSERT INTO `question_choice` VALUES (374, 94, 'B', '这是计算机网络题14的选项B');
INSERT INTO `question_choice` VALUES (375, 94, 'C', '这是计算机网络题14的选项C');
INSERT INTO `question_choice` VALUES (376, 94, 'D', '这是计算机网络题14的选项D');
INSERT INTO `question_choice` VALUES (377, 95, 'A', '这是计算机网络题15的选项A');
INSERT INTO `question_choice` VALUES (378, 95, 'B', '这是计算机网络题15的选项B');
INSERT INTO `question_choice` VALUES (379, 95, 'C', '这是计算机网络题15的选项C');
INSERT INTO `question_choice` VALUES (380, 95, 'D', '这是计算机网络题15的选项D');
INSERT INTO `question_choice` VALUES (381, 96, 'A', '这是计算机网络题16的选项A');
INSERT INTO `question_choice` VALUES (382, 96, 'B', '这是计算机网络题16的选项B');
INSERT INTO `question_choice` VALUES (383, 96, 'C', '这是计算机网络题16的选项C');
INSERT INTO `question_choice` VALUES (384, 96, 'D', '这是计算机网络题16的选项D');
INSERT INTO `question_choice` VALUES (385, 97, 'A', '这是计算机网络题17的选项A');
INSERT INTO `question_choice` VALUES (386, 97, 'B', '这是计算机网络题17的选项B');
INSERT INTO `question_choice` VALUES (387, 97, 'C', '这是计算机网络题17的选项C');
INSERT INTO `question_choice` VALUES (388, 97, 'D', '这是计算机网络题17的选项D');
INSERT INTO `question_choice` VALUES (389, 98, 'A', '这是计算机网络题18的选项A');
INSERT INTO `question_choice` VALUES (390, 98, 'B', '这是计算机网络题18的选项B');
INSERT INTO `question_choice` VALUES (391, 98, 'C', '这是计算机网络题18的选项C');
INSERT INTO `question_choice` VALUES (392, 98, 'D', '这是计算机网络题18的选项D');
INSERT INTO `question_choice` VALUES (393, 99, 'A', '这是计算机网络题19的选项A');
INSERT INTO `question_choice` VALUES (394, 99, 'B', '这是计算机网络题19的选项B');
INSERT INTO `question_choice` VALUES (395, 99, 'C', '这是计算机网络题19的选项C');
INSERT INTO `question_choice` VALUES (396, 99, 'D', '这是计算机网络题19的选项D');
INSERT INTO `question_choice` VALUES (397, 100, 'A', '这是计算机网络题20的选项A');
INSERT INTO `question_choice` VALUES (398, 100, 'B', '这是计算机网络题20的选项B');
INSERT INTO `question_choice` VALUES (399, 100, 'C', '这是计算机网络题20的选项C');
INSERT INTO `question_choice` VALUES (400, 100, 'D', '这是计算机网络题20的选项D');
INSERT INTO `question_choice` VALUES (401, 101, 'A', '这是计算机网络题21的选项A');
INSERT INTO `question_choice` VALUES (402, 101, 'B', '这是计算机网络题21的选项B');
INSERT INTO `question_choice` VALUES (403, 101, 'C', '这是计算机网络题21的选项C');
INSERT INTO `question_choice` VALUES (404, 101, 'D', '这是计算机网络题21的选项D');
INSERT INTO `question_choice` VALUES (405, 102, 'A', '这是计算机网络题22的选项A');
INSERT INTO `question_choice` VALUES (406, 102, 'B', '这是计算机网络题22的选项B');
INSERT INTO `question_choice` VALUES (407, 102, 'C', '这是计算机网络题22的选项C');
INSERT INTO `question_choice` VALUES (408, 102, 'D', '这是计算机网络题22的选项D');
INSERT INTO `question_choice` VALUES (409, 103, 'A', '这是计算机网络题23的选项A');
INSERT INTO `question_choice` VALUES (410, 103, 'B', '这是计算机网络题23的选项B');
INSERT INTO `question_choice` VALUES (411, 103, 'C', '这是计算机网络题23的选项C');
INSERT INTO `question_choice` VALUES (412, 103, 'D', '这是计算机网络题23的选项D');
INSERT INTO `question_choice` VALUES (413, 104, 'A', '这是计算机网络题24的选项A');
INSERT INTO `question_choice` VALUES (414, 104, 'B', '这是计算机网络题24的选项B');
INSERT INTO `question_choice` VALUES (415, 104, 'C', '这是计算机网络题24的选项C');
INSERT INTO `question_choice` VALUES (416, 104, 'D', '这是计算机网络题24的选项D');
INSERT INTO `question_choice` VALUES (417, 105, 'A', '这是计算机网络题25的选项A');
INSERT INTO `question_choice` VALUES (418, 105, 'B', '这是计算机网络题25的选项B');
INSERT INTO `question_choice` VALUES (419, 105, 'C', '这是计算机网络题25的选项C');
INSERT INTO `question_choice` VALUES (420, 105, 'D', '这是计算机网络题25的选项D');
INSERT INTO `question_choice` VALUES (421, 106, 'A', '这是计算机网络题26的选项A');
INSERT INTO `question_choice` VALUES (422, 106, 'B', '这是计算机网络题26的选项B');
INSERT INTO `question_choice` VALUES (423, 106, 'C', '这是计算机网络题26的选项C');
INSERT INTO `question_choice` VALUES (424, 106, 'D', '这是计算机网络题26的选项D');
INSERT INTO `question_choice` VALUES (425, 107, 'A', '这是计算机网络题27的选项A');
INSERT INTO `question_choice` VALUES (426, 107, 'B', '这是计算机网络题27的选项B');
INSERT INTO `question_choice` VALUES (427, 107, 'C', '这是计算机网络题27的选项C');
INSERT INTO `question_choice` VALUES (428, 107, 'D', '这是计算机网络题27的选项D');
INSERT INTO `question_choice` VALUES (429, 108, 'A', '这是计算机网络题28的选项A');
INSERT INTO `question_choice` VALUES (430, 108, 'B', '这是计算机网络题28的选项B');
INSERT INTO `question_choice` VALUES (431, 108, 'C', '这是计算机网络题28的选项C');
INSERT INTO `question_choice` VALUES (432, 108, 'D', '这是计算机网络题28的选项D');
INSERT INTO `question_choice` VALUES (433, 109, 'A', '这是计算机网络题29的选项A');
INSERT INTO `question_choice` VALUES (434, 109, 'B', '这是计算机网络题29的选项B');
INSERT INTO `question_choice` VALUES (435, 109, 'C', '这是计算机网络题29的选项C');
INSERT INTO `question_choice` VALUES (436, 109, 'D', '这是计算机网络题29的选项D');
INSERT INTO `question_choice` VALUES (437, 110, 'A', '这是计算机网络题30的选项A');
INSERT INTO `question_choice` VALUES (438, 110, 'B', '这是计算机网络题30的选项B');
INSERT INTO `question_choice` VALUES (439, 110, 'C', '这是计算机网络题30的选项C');
INSERT INTO `question_choice` VALUES (440, 110, 'D', '这是计算机网络题30的选项D');
INSERT INTO `question_choice` VALUES (441, 111, 'A', '这是计算机网络题31的选项A');
INSERT INTO `question_choice` VALUES (442, 111, 'B', '这是计算机网络题31的选项B');
INSERT INTO `question_choice` VALUES (443, 111, 'C', '这是计算机网络题31的选项C');
INSERT INTO `question_choice` VALUES (444, 111, 'D', '这是计算机网络题31的选项D');
INSERT INTO `question_choice` VALUES (445, 112, 'A', '这是计算机网络题32的选项A');
INSERT INTO `question_choice` VALUES (446, 112, 'B', '这是计算机网络题32的选项B');
INSERT INTO `question_choice` VALUES (447, 112, 'C', '这是计算机网络题32的选项C');
INSERT INTO `question_choice` VALUES (448, 112, 'D', '这是计算机网络题32的选项D');
INSERT INTO `question_choice` VALUES (449, 113, 'A', '这是计算机网络题33的选项A');
INSERT INTO `question_choice` VALUES (450, 113, 'B', '这是计算机网络题33的选项B');
INSERT INTO `question_choice` VALUES (451, 113, 'C', '这是计算机网络题33的选项C');
INSERT INTO `question_choice` VALUES (452, 113, 'D', '这是计算机网络题33的选项D');
INSERT INTO `question_choice` VALUES (453, 114, 'A', '这是计算机网络题34的选项A');
INSERT INTO `question_choice` VALUES (454, 114, 'B', '这是计算机网络题34的选项B');
INSERT INTO `question_choice` VALUES (455, 114, 'C', '这是计算机网络题34的选项C');
INSERT INTO `question_choice` VALUES (456, 114, 'D', '这是计算机网络题34的选项D');
INSERT INTO `question_choice` VALUES (457, 115, 'A', '这是计算机网络题35的选项A');
INSERT INTO `question_choice` VALUES (458, 115, 'B', '这是计算机网络题35的选项B');
INSERT INTO `question_choice` VALUES (459, 115, 'C', '这是计算机网络题35的选项C');
INSERT INTO `question_choice` VALUES (460, 115, 'D', '这是计算机网络题35的选项D');
INSERT INTO `question_choice` VALUES (461, 116, 'A', '这是计算机网络题36的选项A');
INSERT INTO `question_choice` VALUES (462, 116, 'B', '这是计算机网络题36的选项B');
INSERT INTO `question_choice` VALUES (463, 116, 'C', '这是计算机网络题36的选项C');
INSERT INTO `question_choice` VALUES (464, 116, 'D', '这是计算机网络题36的选项D');
INSERT INTO `question_choice` VALUES (465, 117, 'A', '这是计算机网络题37的选项A');
INSERT INTO `question_choice` VALUES (466, 117, 'B', '这是计算机网络题37的选项B');
INSERT INTO `question_choice` VALUES (467, 117, 'C', '这是计算机网络题37的选项C');
INSERT INTO `question_choice` VALUES (468, 117, 'D', '这是计算机网络题37的选项D');
INSERT INTO `question_choice` VALUES (469, 118, 'A', '这是计算机网络题38的选项A');
INSERT INTO `question_choice` VALUES (470, 118, 'B', '这是计算机网络题38的选项B');
INSERT INTO `question_choice` VALUES (471, 118, 'C', '这是计算机网络题38的选项C');
INSERT INTO `question_choice` VALUES (472, 118, 'D', '这是计算机网络题38的选项D');
INSERT INTO `question_choice` VALUES (473, 119, 'A', '这是计算机网络题39的选项A');
INSERT INTO `question_choice` VALUES (474, 119, 'B', '这是计算机网络题39的选项B');
INSERT INTO `question_choice` VALUES (475, 119, 'C', '这是计算机网络题39的选项C');
INSERT INTO `question_choice` VALUES (476, 119, 'D', '这是计算机网络题39的选项D');
INSERT INTO `question_choice` VALUES (477, 120, 'A', '这是计算机网络题40的选项A');
INSERT INTO `question_choice` VALUES (478, 120, 'B', '这是计算机网络题40的选项B');
INSERT INTO `question_choice` VALUES (479, 120, 'C', '这是计算机网络题40的选项C');
INSERT INTO `question_choice` VALUES (480, 120, 'D', '这是计算机网络题40的选项D');
INSERT INTO `question_choice` VALUES (481, 121, 'A', '这是数据结构题1的选项A');
INSERT INTO `question_choice` VALUES (482, 121, 'B', '这是数据结构题1的选项B');
INSERT INTO `question_choice` VALUES (483, 121, 'C', '这是数据结构题1的选项C');
INSERT INTO `question_choice` VALUES (484, 121, 'D', '这是数据结构题1的选项D');
INSERT INTO `question_choice` VALUES (485, 122, 'A', '这是数据结构题2的选项A');
INSERT INTO `question_choice` VALUES (486, 122, 'B', '这是数据结构题2的选项B');
INSERT INTO `question_choice` VALUES (487, 122, 'C', '这是数据结构题2的选项C');
INSERT INTO `question_choice` VALUES (488, 122, 'D', '这是数据结构题2的选项D');
INSERT INTO `question_choice` VALUES (489, 123, 'A', '这是数据结构题3的选项A');
INSERT INTO `question_choice` VALUES (490, 123, 'B', '这是数据结构题3的选项B');
INSERT INTO `question_choice` VALUES (491, 123, 'C', '这是数据结构题3的选项C');
INSERT INTO `question_choice` VALUES (492, 123, 'D', '这是数据结构题3的选项D');
INSERT INTO `question_choice` VALUES (493, 124, 'A', '这是数据结构题4的选项A');
INSERT INTO `question_choice` VALUES (494, 124, 'B', '这是数据结构题4的选项B');
INSERT INTO `question_choice` VALUES (495, 124, 'C', '这是数据结构题4的选项C');
INSERT INTO `question_choice` VALUES (496, 124, 'D', '这是数据结构题4的选项D');
INSERT INTO `question_choice` VALUES (497, 125, 'A', '这是数据结构题5的选项A');
INSERT INTO `question_choice` VALUES (498, 125, 'B', '这是数据结构题5的选项B');
INSERT INTO `question_choice` VALUES (499, 125, 'C', '这是数据结构题5的选项C');
INSERT INTO `question_choice` VALUES (500, 125, 'D', '这是数据结构题5的选项D');
INSERT INTO `question_choice` VALUES (501, 126, 'A', '这是数据结构题6的选项A');
INSERT INTO `question_choice` VALUES (502, 126, 'B', '这是数据结构题6的选项B');
INSERT INTO `question_choice` VALUES (503, 126, 'C', '这是数据结构题6的选项C');
INSERT INTO `question_choice` VALUES (504, 126, 'D', '这是数据结构题6的选项D');
INSERT INTO `question_choice` VALUES (505, 127, 'A', '这是数据结构题7的选项A');
INSERT INTO `question_choice` VALUES (506, 127, 'B', '这是数据结构题7的选项B');
INSERT INTO `question_choice` VALUES (507, 127, 'C', '这是数据结构题7的选项C');
INSERT INTO `question_choice` VALUES (508, 127, 'D', '这是数据结构题7的选项D');
INSERT INTO `question_choice` VALUES (509, 128, 'A', '这是数据结构题8的选项A');
INSERT INTO `question_choice` VALUES (510, 128, 'B', '这是数据结构题8的选项B');
INSERT INTO `question_choice` VALUES (511, 128, 'C', '这是数据结构题8的选项C');
INSERT INTO `question_choice` VALUES (512, 128, 'D', '这是数据结构题8的选项D');
INSERT INTO `question_choice` VALUES (513, 129, 'A', '这是数据结构题9的选项A');
INSERT INTO `question_choice` VALUES (514, 129, 'B', '这是数据结构题9的选项B');
INSERT INTO `question_choice` VALUES (515, 129, 'C', '这是数据结构题9的选项C');
INSERT INTO `question_choice` VALUES (516, 129, 'D', '这是数据结构题9的选项D');
INSERT INTO `question_choice` VALUES (517, 130, 'A', '这是数据结构题10的选项A');
INSERT INTO `question_choice` VALUES (518, 130, 'B', '这是数据结构题10的选项B');
INSERT INTO `question_choice` VALUES (519, 130, 'C', '这是数据结构题10的选项C');
INSERT INTO `question_choice` VALUES (520, 130, 'D', '这是数据结构题10的选项D');
INSERT INTO `question_choice` VALUES (521, 131, 'A', '这是数据结构题11的选项A');
INSERT INTO `question_choice` VALUES (522, 131, 'B', '这是数据结构题11的选项B');
INSERT INTO `question_choice` VALUES (523, 131, 'C', '这是数据结构题11的选项C');
INSERT INTO `question_choice` VALUES (524, 131, 'D', '这是数据结构题11的选项D');
INSERT INTO `question_choice` VALUES (525, 132, 'A', '这是数据结构题12的选项A');
INSERT INTO `question_choice` VALUES (526, 132, 'B', '这是数据结构题12的选项B');
INSERT INTO `question_choice` VALUES (527, 132, 'C', '这是数据结构题12的选项C');
INSERT INTO `question_choice` VALUES (528, 132, 'D', '这是数据结构题12的选项D');
INSERT INTO `question_choice` VALUES (529, 133, 'A', '这是数据结构题13的选项A');
INSERT INTO `question_choice` VALUES (530, 133, 'B', '这是数据结构题13的选项B');
INSERT INTO `question_choice` VALUES (531, 133, 'C', '这是数据结构题13的选项C');
INSERT INTO `question_choice` VALUES (532, 133, 'D', '这是数据结构题13的选项D');
INSERT INTO `question_choice` VALUES (533, 134, 'A', '这是数据结构题14的选项A');
INSERT INTO `question_choice` VALUES (534, 134, 'B', '这是数据结构题14的选项B');
INSERT INTO `question_choice` VALUES (535, 134, 'C', '这是数据结构题14的选项C');
INSERT INTO `question_choice` VALUES (536, 134, 'D', '这是数据结构题14的选项D');
INSERT INTO `question_choice` VALUES (537, 135, 'A', '这是数据结构题15的选项A');
INSERT INTO `question_choice` VALUES (538, 135, 'B', '这是数据结构题15的选项B');
INSERT INTO `question_choice` VALUES (539, 135, 'C', '这是数据结构题15的选项C');
INSERT INTO `question_choice` VALUES (540, 135, 'D', '这是数据结构题15的选项D');
INSERT INTO `question_choice` VALUES (541, 136, 'A', '这是数据结构题16的选项A');
INSERT INTO `question_choice` VALUES (542, 136, 'B', '这是数据结构题16的选项B');
INSERT INTO `question_choice` VALUES (543, 136, 'C', '这是数据结构题16的选项C');
INSERT INTO `question_choice` VALUES (544, 136, 'D', '这是数据结构题16的选项D');
INSERT INTO `question_choice` VALUES (545, 137, 'A', '这是数据结构题17的选项A');
INSERT INTO `question_choice` VALUES (546, 137, 'B', '这是数据结构题17的选项B');
INSERT INTO `question_choice` VALUES (547, 137, 'C', '这是数据结构题17的选项C');
INSERT INTO `question_choice` VALUES (548, 137, 'D', '这是数据结构题17的选项D');
INSERT INTO `question_choice` VALUES (549, 138, 'A', '这是数据结构题18的选项A');
INSERT INTO `question_choice` VALUES (550, 138, 'B', '这是数据结构题18的选项B');
INSERT INTO `question_choice` VALUES (551, 138, 'C', '这是数据结构题18的选项C');
INSERT INTO `question_choice` VALUES (552, 138, 'D', '这是数据结构题18的选项D');
INSERT INTO `question_choice` VALUES (553, 139, 'A', '这是数据结构题19的选项A');
INSERT INTO `question_choice` VALUES (554, 139, 'B', '这是数据结构题19的选项B');
INSERT INTO `question_choice` VALUES (555, 139, 'C', '这是数据结构题19的选项C');
INSERT INTO `question_choice` VALUES (556, 139, 'D', '这是数据结构题19的选项D');
INSERT INTO `question_choice` VALUES (557, 140, 'A', '这是数据结构题20的选项A');
INSERT INTO `question_choice` VALUES (558, 140, 'B', '这是数据结构题20的选项B');
INSERT INTO `question_choice` VALUES (559, 140, 'C', '这是数据结构题20的选项C');
INSERT INTO `question_choice` VALUES (560, 140, 'D', '这是数据结构题20的选项D');
INSERT INTO `question_choice` VALUES (561, 141, 'A', '这是数据结构题21的选项A');
INSERT INTO `question_choice` VALUES (562, 141, 'B', '这是数据结构题21的选项B');
INSERT INTO `question_choice` VALUES (563, 141, 'C', '这是数据结构题21的选项C');
INSERT INTO `question_choice` VALUES (564, 141, 'D', '这是数据结构题21的选项D');
INSERT INTO `question_choice` VALUES (565, 142, 'A', '这是数据结构题22的选项A');
INSERT INTO `question_choice` VALUES (566, 142, 'B', '这是数据结构题22的选项B');
INSERT INTO `question_choice` VALUES (567, 142, 'C', '这是数据结构题22的选项C');
INSERT INTO `question_choice` VALUES (568, 142, 'D', '这是数据结构题22的选项D');
INSERT INTO `question_choice` VALUES (569, 143, 'A', '这是数据结构题23的选项A');
INSERT INTO `question_choice` VALUES (570, 143, 'B', '这是数据结构题23的选项B');
INSERT INTO `question_choice` VALUES (571, 143, 'C', '这是数据结构题23的选项C');
INSERT INTO `question_choice` VALUES (572, 143, 'D', '这是数据结构题23的选项D');
INSERT INTO `question_choice` VALUES (573, 144, 'A', '这是数据结构题24的选项A');
INSERT INTO `question_choice` VALUES (574, 144, 'B', '这是数据结构题24的选项B');
INSERT INTO `question_choice` VALUES (575, 144, 'C', '这是数据结构题24的选项C');
INSERT INTO `question_choice` VALUES (576, 144, 'D', '这是数据结构题24的选项D');
INSERT INTO `question_choice` VALUES (577, 145, 'A', '这是数据结构题25的选项A');
INSERT INTO `question_choice` VALUES (578, 145, 'B', '这是数据结构题25的选项B');
INSERT INTO `question_choice` VALUES (579, 145, 'C', '这是数据结构题25的选项C');
INSERT INTO `question_choice` VALUES (580, 145, 'D', '这是数据结构题25的选项D');
INSERT INTO `question_choice` VALUES (581, 146, 'A', '这是数据结构题26的选项A');
INSERT INTO `question_choice` VALUES (582, 146, 'B', '这是数据结构题26的选项B');
INSERT INTO `question_choice` VALUES (583, 146, 'C', '这是数据结构题26的选项C');
INSERT INTO `question_choice` VALUES (584, 146, 'D', '这是数据结构题26的选项D');
INSERT INTO `question_choice` VALUES (585, 147, 'A', '这是数据结构题27的选项A');
INSERT INTO `question_choice` VALUES (586, 147, 'B', '这是数据结构题27的选项B');
INSERT INTO `question_choice` VALUES (587, 147, 'C', '这是数据结构题27的选项C');
INSERT INTO `question_choice` VALUES (588, 147, 'D', '这是数据结构题27的选项D');
INSERT INTO `question_choice` VALUES (589, 148, 'A', '这是数据结构题28的选项A');
INSERT INTO `question_choice` VALUES (590, 148, 'B', '这是数据结构题28的选项B');
INSERT INTO `question_choice` VALUES (591, 148, 'C', '这是数据结构题28的选项C');
INSERT INTO `question_choice` VALUES (592, 148, 'D', '这是数据结构题28的选项D');
INSERT INTO `question_choice` VALUES (593, 149, 'A', '这是数据结构题29的选项A');
INSERT INTO `question_choice` VALUES (594, 149, 'B', '这是数据结构题29的选项B');
INSERT INTO `question_choice` VALUES (595, 149, 'C', '这是数据结构题29的选项C');
INSERT INTO `question_choice` VALUES (596, 149, 'D', '这是数据结构题29的选项D');
INSERT INTO `question_choice` VALUES (597, 150, 'A', '这是数据结构题30的选项A');
INSERT INTO `question_choice` VALUES (598, 150, 'B', '这是数据结构题30的选项B');
INSERT INTO `question_choice` VALUES (599, 150, 'C', '这是数据结构题30的选项C');
INSERT INTO `question_choice` VALUES (600, 150, 'D', '这是数据结构题30的选项D');
INSERT INTO `question_choice` VALUES (601, 151, 'A', '这是数据结构题31的选项A');
INSERT INTO `question_choice` VALUES (602, 151, 'B', '这是数据结构题31的选项B');
INSERT INTO `question_choice` VALUES (603, 151, 'C', '这是数据结构题31的选项C');
INSERT INTO `question_choice` VALUES (604, 151, 'D', '这是数据结构题31的选项D');
INSERT INTO `question_choice` VALUES (605, 152, 'A', '这是数据结构题32的选项A');
INSERT INTO `question_choice` VALUES (606, 152, 'B', '这是数据结构题32的选项B');
INSERT INTO `question_choice` VALUES (607, 152, 'C', '这是数据结构题32的选项C');
INSERT INTO `question_choice` VALUES (608, 152, 'D', '这是数据结构题32的选项D');
INSERT INTO `question_choice` VALUES (609, 153, 'A', '这是数据结构题33的选项A');
INSERT INTO `question_choice` VALUES (610, 153, 'B', '这是数据结构题33的选项B');
INSERT INTO `question_choice` VALUES (611, 153, 'C', '这是数据结构题33的选项C');
INSERT INTO `question_choice` VALUES (612, 153, 'D', '这是数据结构题33的选项D');
INSERT INTO `question_choice` VALUES (613, 154, 'A', '这是数据结构题34的选项A');
INSERT INTO `question_choice` VALUES (614, 154, 'B', '这是数据结构题34的选项B');
INSERT INTO `question_choice` VALUES (615, 154, 'C', '这是数据结构题34的选项C');
INSERT INTO `question_choice` VALUES (616, 154, 'D', '这是数据结构题34的选项D');
INSERT INTO `question_choice` VALUES (617, 155, 'A', '这是数据结构题35的选项A');
INSERT INTO `question_choice` VALUES (618, 155, 'B', '这是数据结构题35的选项B');
INSERT INTO `question_choice` VALUES (619, 155, 'C', '这是数据结构题35的选项C');
INSERT INTO `question_choice` VALUES (620, 155, 'D', '这是数据结构题35的选项D');
INSERT INTO `question_choice` VALUES (621, 156, 'A', '这是数据结构题36的选项A');
INSERT INTO `question_choice` VALUES (622, 156, 'B', '这是数据结构题36的选项B');
INSERT INTO `question_choice` VALUES (623, 156, 'C', '这是数据结构题36的选项C');
INSERT INTO `question_choice` VALUES (624, 156, 'D', '这是数据结构题36的选项D');
INSERT INTO `question_choice` VALUES (625, 157, 'A', '这是数据结构题37的选项A');
INSERT INTO `question_choice` VALUES (626, 157, 'B', '这是数据结构题37的选项B');
INSERT INTO `question_choice` VALUES (627, 157, 'C', '这是数据结构题37的选项C');
INSERT INTO `question_choice` VALUES (628, 157, 'D', '这是数据结构题37的选项D');
INSERT INTO `question_choice` VALUES (629, 158, 'A', '这是数据结构题38的选项A');
INSERT INTO `question_choice` VALUES (630, 158, 'B', '这是数据结构题38的选项B');
INSERT INTO `question_choice` VALUES (631, 158, 'C', '这是数据结构题38的选项C');
INSERT INTO `question_choice` VALUES (632, 158, 'D', '这是数据结构题38的选项D');
INSERT INTO `question_choice` VALUES (633, 159, 'A', '这是数据结构题39的选项A');
INSERT INTO `question_choice` VALUES (634, 159, 'B', '这是数据结构题39的选项B');
INSERT INTO `question_choice` VALUES (635, 159, 'C', '这是数据结构题39的选项C');
INSERT INTO `question_choice` VALUES (636, 159, 'D', '这是数据结构题39的选项D');
INSERT INTO `question_choice` VALUES (637, 160, 'A', '这是数据结构题40的选项A');
INSERT INTO `question_choice` VALUES (638, 160, 'B', '这是数据结构题40的选项B');
INSERT INTO `question_choice` VALUES (639, 160, 'C', '这是数据结构题40的选项C');
INSERT INTO `question_choice` VALUES (640, 160, 'D', '这是数据结构题40的选项D');
INSERT INTO `question_choice` VALUES (641, 161, 'A', '这是计算机组成原理题1的选项A');
INSERT INTO `question_choice` VALUES (642, 161, 'B', '这是计算机组成原理题1的选项B');
INSERT INTO `question_choice` VALUES (643, 161, 'C', '这是计算机组成原理题1的选项C');
INSERT INTO `question_choice` VALUES (644, 161, 'D', '这是计算机组成原理题1的选项D');
INSERT INTO `question_choice` VALUES (645, 162, 'A', '这是计算机组成原理题2的选项A');
INSERT INTO `question_choice` VALUES (646, 162, 'B', '这是计算机组成原理题2的选项B');
INSERT INTO `question_choice` VALUES (647, 162, 'C', '这是计算机组成原理题2的选项C');
INSERT INTO `question_choice` VALUES (648, 162, 'D', '这是计算机组成原理题2的选项D');
INSERT INTO `question_choice` VALUES (649, 163, 'A', '这是计算机组成原理题3的选项A');
INSERT INTO `question_choice` VALUES (650, 163, 'B', '这是计算机组成原理题3的选项B');
INSERT INTO `question_choice` VALUES (651, 163, 'C', '这是计算机组成原理题3的选项C');
INSERT INTO `question_choice` VALUES (652, 163, 'D', '这是计算机组成原理题3的选项D');
INSERT INTO `question_choice` VALUES (653, 164, 'A', '这是计算机组成原理题4的选项A');
INSERT INTO `question_choice` VALUES (654, 164, 'B', '这是计算机组成原理题4的选项B');
INSERT INTO `question_choice` VALUES (655, 164, 'C', '这是计算机组成原理题4的选项C');
INSERT INTO `question_choice` VALUES (656, 164, 'D', '这是计算机组成原理题4的选项D');
INSERT INTO `question_choice` VALUES (657, 165, 'A', '这是计算机组成原理题5的选项A');
INSERT INTO `question_choice` VALUES (658, 165, 'B', '这是计算机组成原理题5的选项B');
INSERT INTO `question_choice` VALUES (659, 165, 'C', '这是计算机组成原理题5的选项C');
INSERT INTO `question_choice` VALUES (660, 165, 'D', '这是计算机组成原理题5的选项D');
INSERT INTO `question_choice` VALUES (661, 166, 'A', '这是计算机组成原理题6的选项A');
INSERT INTO `question_choice` VALUES (662, 166, 'B', '这是计算机组成原理题6的选项B');
INSERT INTO `question_choice` VALUES (663, 166, 'C', '这是计算机组成原理题6的选项C');
INSERT INTO `question_choice` VALUES (664, 166, 'D', '这是计算机组成原理题6的选项D');
INSERT INTO `question_choice` VALUES (665, 167, 'A', '这是计算机组成原理题7的选项A');
INSERT INTO `question_choice` VALUES (666, 167, 'B', '这是计算机组成原理题7的选项B');
INSERT INTO `question_choice` VALUES (667, 167, 'C', '这是计算机组成原理题7的选项C');
INSERT INTO `question_choice` VALUES (668, 167, 'D', '这是计算机组成原理题7的选项D');
INSERT INTO `question_choice` VALUES (669, 168, 'A', '这是计算机组成原理题8的选项A');
INSERT INTO `question_choice` VALUES (670, 168, 'B', '这是计算机组成原理题8的选项B');
INSERT INTO `question_choice` VALUES (671, 168, 'C', '这是计算机组成原理题8的选项C');
INSERT INTO `question_choice` VALUES (672, 168, 'D', '这是计算机组成原理题8的选项D');
INSERT INTO `question_choice` VALUES (673, 169, 'A', '这是计算机组成原理题9的选项A');
INSERT INTO `question_choice` VALUES (674, 169, 'B', '这是计算机组成原理题9的选项B');
INSERT INTO `question_choice` VALUES (675, 169, 'C', '这是计算机组成原理题9的选项C');
INSERT INTO `question_choice` VALUES (676, 169, 'D', '这是计算机组成原理题9的选项D');
INSERT INTO `question_choice` VALUES (677, 170, 'A', '这是计算机组成原理题10的选项A');
INSERT INTO `question_choice` VALUES (678, 170, 'B', '这是计算机组成原理题10的选项B');
INSERT INTO `question_choice` VALUES (679, 170, 'C', '这是计算机组成原理题10的选项C');
INSERT INTO `question_choice` VALUES (680, 170, 'D', '这是计算机组成原理题10的选项D');
INSERT INTO `question_choice` VALUES (681, 171, 'A', '这是计算机组成原理题11的选项A');
INSERT INTO `question_choice` VALUES (682, 171, 'B', '这是计算机组成原理题11的选项B');
INSERT INTO `question_choice` VALUES (683, 171, 'C', '这是计算机组成原理题11的选项C');
INSERT INTO `question_choice` VALUES (684, 171, 'D', '这是计算机组成原理题11的选项D');
INSERT INTO `question_choice` VALUES (685, 172, 'A', '这是计算机组成原理题12的选项A');
INSERT INTO `question_choice` VALUES (686, 172, 'B', '这是计算机组成原理题12的选项B');
INSERT INTO `question_choice` VALUES (687, 172, 'C', '这是计算机组成原理题12的选项C');
INSERT INTO `question_choice` VALUES (688, 172, 'D', '这是计算机组成原理题12的选项D');
INSERT INTO `question_choice` VALUES (689, 173, 'A', '这是计算机组成原理题13的选项A');
INSERT INTO `question_choice` VALUES (690, 173, 'B', '这是计算机组成原理题13的选项B');
INSERT INTO `question_choice` VALUES (691, 173, 'C', '这是计算机组成原理题13的选项C');
INSERT INTO `question_choice` VALUES (692, 173, 'D', '这是计算机组成原理题13的选项D');
INSERT INTO `question_choice` VALUES (693, 174, 'A', '这是计算机组成原理题14的选项A');
INSERT INTO `question_choice` VALUES (694, 174, 'B', '这是计算机组成原理题14的选项B');
INSERT INTO `question_choice` VALUES (695, 174, 'C', '这是计算机组成原理题14的选项C');
INSERT INTO `question_choice` VALUES (696, 174, 'D', '这是计算机组成原理题14的选项D');
INSERT INTO `question_choice` VALUES (697, 175, 'A', '这是计算机组成原理题15的选项A');
INSERT INTO `question_choice` VALUES (698, 175, 'B', '这是计算机组成原理题15的选项B');
INSERT INTO `question_choice` VALUES (699, 175, 'C', '这是计算机组成原理题15的选项C');
INSERT INTO `question_choice` VALUES (700, 175, 'D', '这是计算机组成原理题15的选项D');
INSERT INTO `question_choice` VALUES (701, 176, 'A', '这是计算机组成原理题16的选项A');
INSERT INTO `question_choice` VALUES (702, 176, 'B', '这是计算机组成原理题16的选项B');
INSERT INTO `question_choice` VALUES (703, 176, 'C', '这是计算机组成原理题16的选项C');
INSERT INTO `question_choice` VALUES (704, 176, 'D', '这是计算机组成原理题16的选项D');
INSERT INTO `question_choice` VALUES (705, 177, 'A', '这是计算机组成原理题17的选项A');
INSERT INTO `question_choice` VALUES (706, 177, 'B', '这是计算机组成原理题17的选项B');
INSERT INTO `question_choice` VALUES (707, 177, 'C', '这是计算机组成原理题17的选项C');
INSERT INTO `question_choice` VALUES (708, 177, 'D', '这是计算机组成原理题17的选项D');
INSERT INTO `question_choice` VALUES (709, 178, 'A', '这是计算机组成原理题18的选项A');
INSERT INTO `question_choice` VALUES (710, 178, 'B', '这是计算机组成原理题18的选项B');
INSERT INTO `question_choice` VALUES (711, 178, 'C', '这是计算机组成原理题18的选项C');
INSERT INTO `question_choice` VALUES (712, 178, 'D', '这是计算机组成原理题18的选项D');
INSERT INTO `question_choice` VALUES (713, 179, 'A', '这是计算机组成原理题19的选项A');
INSERT INTO `question_choice` VALUES (714, 179, 'B', '这是计算机组成原理题19的选项B');
INSERT INTO `question_choice` VALUES (715, 179, 'C', '这是计算机组成原理题19的选项C');
INSERT INTO `question_choice` VALUES (716, 179, 'D', '这是计算机组成原理题19的选项D');
INSERT INTO `question_choice` VALUES (717, 180, 'A', '这是计算机组成原理题20的选项A');
INSERT INTO `question_choice` VALUES (718, 180, 'B', '这是计算机组成原理题20的选项B');
INSERT INTO `question_choice` VALUES (719, 180, 'C', '这是计算机组成原理题20的选项C');
INSERT INTO `question_choice` VALUES (720, 180, 'D', '这是计算机组成原理题20的选项D');
INSERT INTO `question_choice` VALUES (721, 181, 'A', '这是计算机组成原理题21的选项A');
INSERT INTO `question_choice` VALUES (722, 181, 'B', '这是计算机组成原理题21的选项B');
INSERT INTO `question_choice` VALUES (723, 181, 'C', '这是计算机组成原理题21的选项C');
INSERT INTO `question_choice` VALUES (724, 181, 'D', '这是计算机组成原理题21的选项D');
INSERT INTO `question_choice` VALUES (725, 182, 'A', '这是计算机组成原理题22的选项A');
INSERT INTO `question_choice` VALUES (726, 182, 'B', '这是计算机组成原理题22的选项B');
INSERT INTO `question_choice` VALUES (727, 182, 'C', '这是计算机组成原理题22的选项C');
INSERT INTO `question_choice` VALUES (728, 182, 'D', '这是计算机组成原理题22的选项D');
INSERT INTO `question_choice` VALUES (729, 183, 'A', '这是计算机组成原理题23的选项A');
INSERT INTO `question_choice` VALUES (730, 183, 'B', '这是计算机组成原理题23的选项B');
INSERT INTO `question_choice` VALUES (731, 183, 'C', '这是计算机组成原理题23的选项C');
INSERT INTO `question_choice` VALUES (732, 183, 'D', '这是计算机组成原理题23的选项D');
INSERT INTO `question_choice` VALUES (733, 184, 'A', '这是计算机组成原理题24的选项A');
INSERT INTO `question_choice` VALUES (734, 184, 'B', '这是计算机组成原理题24的选项B');
INSERT INTO `question_choice` VALUES (735, 184, 'C', '这是计算机组成原理题24的选项C');
INSERT INTO `question_choice` VALUES (736, 184, 'D', '这是计算机组成原理题24的选项D');
INSERT INTO `question_choice` VALUES (737, 185, 'A', '这是计算机组成原理题25的选项A');
INSERT INTO `question_choice` VALUES (738, 185, 'B', '这是计算机组成原理题25的选项B');
INSERT INTO `question_choice` VALUES (739, 185, 'C', '这是计算机组成原理题25的选项C');
INSERT INTO `question_choice` VALUES (740, 185, 'D', '这是计算机组成原理题25的选项D');
INSERT INTO `question_choice` VALUES (741, 186, 'A', '这是计算机组成原理题26的选项A');
INSERT INTO `question_choice` VALUES (742, 186, 'B', '这是计算机组成原理题26的选项B');
INSERT INTO `question_choice` VALUES (743, 186, 'C', '这是计算机组成原理题26的选项C');
INSERT INTO `question_choice` VALUES (744, 186, 'D', '这是计算机组成原理题26的选项D');
INSERT INTO `question_choice` VALUES (745, 187, 'A', '这是计算机组成原理题27的选项A');
INSERT INTO `question_choice` VALUES (746, 187, 'B', '这是计算机组成原理题27的选项B');
INSERT INTO `question_choice` VALUES (747, 187, 'C', '这是计算机组成原理题27的选项C');
INSERT INTO `question_choice` VALUES (748, 187, 'D', '这是计算机组成原理题27的选项D');
INSERT INTO `question_choice` VALUES (749, 188, 'A', '这是计算机组成原理题28的选项A');
INSERT INTO `question_choice` VALUES (750, 188, 'B', '这是计算机组成原理题28的选项B');
INSERT INTO `question_choice` VALUES (751, 188, 'C', '这是计算机组成原理题28的选项C');
INSERT INTO `question_choice` VALUES (752, 188, 'D', '这是计算机组成原理题28的选项D');
INSERT INTO `question_choice` VALUES (753, 189, 'A', '这是计算机组成原理题29的选项A');
INSERT INTO `question_choice` VALUES (754, 189, 'B', '这是计算机组成原理题29的选项B');
INSERT INTO `question_choice` VALUES (755, 189, 'C', '这是计算机组成原理题29的选项C');
INSERT INTO `question_choice` VALUES (756, 189, 'D', '这是计算机组成原理题29的选项D');
INSERT INTO `question_choice` VALUES (757, 190, 'A', '这是计算机组成原理题30的选项A');
INSERT INTO `question_choice` VALUES (758, 190, 'B', '这是计算机组成原理题30的选项B');
INSERT INTO `question_choice` VALUES (759, 190, 'C', '这是计算机组成原理题30的选项C');
INSERT INTO `question_choice` VALUES (760, 190, 'D', '这是计算机组成原理题30的选项D');
INSERT INTO `question_choice` VALUES (761, 191, 'A', '这是计算机组成原理题31的选项A');
INSERT INTO `question_choice` VALUES (762, 191, 'B', '这是计算机组成原理题31的选项B');
INSERT INTO `question_choice` VALUES (763, 191, 'C', '这是计算机组成原理题31的选项C');
INSERT INTO `question_choice` VALUES (764, 191, 'D', '这是计算机组成原理题31的选项D');
INSERT INTO `question_choice` VALUES (765, 192, 'A', '这是计算机组成原理题32的选项A');
INSERT INTO `question_choice` VALUES (766, 192, 'B', '这是计算机组成原理题32的选项B');
INSERT INTO `question_choice` VALUES (767, 192, 'C', '这是计算机组成原理题32的选项C');
INSERT INTO `question_choice` VALUES (768, 192, 'D', '这是计算机组成原理题32的选项D');
INSERT INTO `question_choice` VALUES (769, 193, 'A', '这是计算机组成原理题33的选项A');
INSERT INTO `question_choice` VALUES (770, 193, 'B', '这是计算机组成原理题33的选项B');
INSERT INTO `question_choice` VALUES (771, 193, 'C', '这是计算机组成原理题33的选项C');
INSERT INTO `question_choice` VALUES (772, 193, 'D', '这是计算机组成原理题33的选项D');
INSERT INTO `question_choice` VALUES (773, 194, 'A', '这是计算机组成原理题34的选项A');
INSERT INTO `question_choice` VALUES (774, 194, 'B', '这是计算机组成原理题34的选项B');
INSERT INTO `question_choice` VALUES (775, 194, 'C', '这是计算机组成原理题34的选项C');
INSERT INTO `question_choice` VALUES (776, 194, 'D', '这是计算机组成原理题34的选项D');
INSERT INTO `question_choice` VALUES (777, 195, 'A', '这是计算机组成原理题35的选项A');
INSERT INTO `question_choice` VALUES (778, 195, 'B', '这是计算机组成原理题35的选项B');
INSERT INTO `question_choice` VALUES (779, 195, 'C', '这是计算机组成原理题35的选项C');
INSERT INTO `question_choice` VALUES (780, 195, 'D', '这是计算机组成原理题35的选项D');
INSERT INTO `question_choice` VALUES (781, 196, 'A', '这是计算机组成原理题36的选项A');
INSERT INTO `question_choice` VALUES (782, 196, 'B', '这是计算机组成原理题36的选项B');
INSERT INTO `question_choice` VALUES (783, 196, 'C', '这是计算机组成原理题36的选项C');
INSERT INTO `question_choice` VALUES (784, 196, 'D', '这是计算机组成原理题36的选项D');
INSERT INTO `question_choice` VALUES (785, 197, 'A', '这是计算机组成原理题37的选项A');
INSERT INTO `question_choice` VALUES (786, 197, 'B', '这是计算机组成原理题37的选项B');
INSERT INTO `question_choice` VALUES (787, 197, 'C', '这是计算机组成原理题37的选项C');
INSERT INTO `question_choice` VALUES (788, 197, 'D', '这是计算机组成原理题37的选项D');
INSERT INTO `question_choice` VALUES (789, 198, 'A', '这是计算机组成原理题38的选项A');
INSERT INTO `question_choice` VALUES (790, 198, 'B', '这是计算机组成原理题38的选项B');
INSERT INTO `question_choice` VALUES (791, 198, 'C', '这是计算机组成原理题38的选项C');
INSERT INTO `question_choice` VALUES (792, 198, 'D', '这是计算机组成原理题38的选项D');
INSERT INTO `question_choice` VALUES (793, 199, 'A', '这是计算机组成原理题39的选项A');
INSERT INTO `question_choice` VALUES (794, 199, 'B', '这是计算机组成原理题39的选项B');
INSERT INTO `question_choice` VALUES (795, 199, 'C', '这是计算机组成原理题39的选项C');
INSERT INTO `question_choice` VALUES (796, 199, 'D', '这是计算机组成原理题39的选项D');
INSERT INTO `question_choice` VALUES (797, 200, 'A', '这是计算机组成原理题40的选项A');
INSERT INTO `question_choice` VALUES (798, 200, 'B', '这是计算机组成原理题40的选项B');
INSERT INTO `question_choice` VALUES (799, 200, 'C', '这是计算机组成原理题40的选项C');
INSERT INTO `question_choice` VALUES (800, 200, 'D', '这是计算机组成原理题40的选项D');

-- ----------------------------
-- Table structure for question_classify
-- ----------------------------
DROP TABLE IF EXISTS `question_classify`;
CREATE TABLE `question_classify`  (
  `classify_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '题目分类id',
  `classify_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '题目分类名字',
  PRIMARY KEY (`classify_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_classify
-- ----------------------------
INSERT INTO `question_classify` VALUES (1, '英语');
INSERT INTO `question_classify` VALUES (2, '数学');
INSERT INTO `question_classify` VALUES (3, '政治');
INSERT INTO `question_classify` VALUES (4, '计算机网络');
INSERT INTO `question_classify` VALUES (5, '数据结构');
INSERT INTO `question_classify` VALUES (6, '计算机组成原理');

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', 'sysAdmin');
INSERT INTO `role` VALUES (2, '普通管理员', 'admin');
INSERT INTO `role` VALUES (3, '学生', 'student');
INSERT INTO `role` VALUES (4, '老师', 'teacher');
INSERT INTO `role` VALUES (6, '测试1', 'test1');
INSERT INTO `role` VALUES (7, '测试', 'test');

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
INSERT INTO `role_menu` VALUES (2, 5);
INSERT INTO `role_menu` VALUES (2, 6);
INSERT INTO `role_menu` VALUES (2, 7);
INSERT INTO `role_menu` VALUES (2, 8);
INSERT INTO `role_menu` VALUES (2, 9);
INSERT INTO `role_menu` VALUES (2, 10);
INSERT INTO `role_menu` VALUES (2, 11);
INSERT INTO `role_menu` VALUES (2, 13);
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
  `direction_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `direction_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教授的方向',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '老师的图片',
  `teach_time` tinyint(0) NULL DEFAULT 0 COMMENT '教学时长',
  `information` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人信息',
  `attent_people` int(0) NULL DEFAULT 0 COMMENT '关注人数',
  `qualification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '辅导资料和辅导记录',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '对应的用户id',
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '老师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张三', '博士研究生', '1', '大数据', NULL, 5, '个人简介', 1000, '2次', 1);
INSERT INTO `teacher` VALUES (2, '李四', '博士研究生', '2', '机器学习', NULL, 4, '个人简介', 2000, '4次', 1);
INSERT INTO `teacher` VALUES (3, '王五', '硕士研究生', '3', '网络管理', NULL, 5, '个人简介', 2000, '4次', 1);
INSERT INTO `teacher` VALUES (4, '赵六', '博士研究生', '4', '高等数学', NULL, 3, '个人简介', 5000, '3次', 1);

-- ----------------------------
-- Table structure for teacher_direction
-- ----------------------------
DROP TABLE IF EXISTS `teacher_direction`;
CREATE TABLE `teacher_direction`  (
  `direction_id` int(0) NOT NULL AUTO_INCREMENT,
  `direction_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`direction_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_direction
-- ----------------------------
INSERT INTO `teacher_direction` VALUES (1, '大数据');
INSERT INTO `teacher_direction` VALUES (2, '机器学习');
INSERT INTO `teacher_direction` VALUES (3, '网络管理');
INSERT INTO `teacher_direction` VALUES (4, '高等数学');

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
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

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
INSERT INTO `user` VALUES (12, 'zhangside', '张思德', '$2a$10$0EvmANPmkAOUIKMueFK3L.gy75d9fgy/OsXMwbsWumt9P3QsTFw0C', NULL, '14323@qq.com', 20, '男', '头像', 0, '留言');
INSERT INTO `user` VALUES (13, 'liuzhijun', '刘志军', '$2a$10$0EvmANPmkAOUIKMueFK3L.gy75d9fgy/OsXMwbsWumt9P3QsTFw0C', NULL, '43543213@qq.com', 21, '保密', '头像', 1, '留言');
INSERT INTO `user` VALUES (14, 'kangxi', '康熙', '$2a$10$pS1J7GrzLYWaIhJfkI2QQeyO2/LS0TUS6fc2awAOHhati/AlzU5T6', NULL, '34542134@qq.com', 32, '保密', '头像', 0, '留言');
INSERT INTO `user` VALUES (16, 'jhlyyds', NULL, '$2a$10$WfywuUG5K/GG5tWGBPCinO91qgQ9F1P4LRf7DVRXIF8L9ownPfhpG', NULL, '213@qq.com', 20, '男', NULL, 0, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `role_id` int(0) NOT NULL DEFAULT 0 COMMENT '角色id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);
INSERT INTO `user_role` VALUES (2, 3);
INSERT INTO `user_role` VALUES (3, 3);
INSERT INTO `user_role` VALUES (3, 4);
INSERT INTO `user_role` VALUES (14, 3);
INSERT INTO `user_role` VALUES (16, 3);

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
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
