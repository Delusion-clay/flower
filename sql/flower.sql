create database flower;
use flower;

/*
艾航
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_user
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
use flower;
CREATE TABLE `c_user` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `user_name` varchar(20) DEFAULT NULL,
                          `password` varchar(20) DEFAULT NULL,
                          `email` varchar(20) DEFAULT NULL,
                          `provinal` varchar(10) DEFAULT NULL,
                          `city` varchar(10) DEFAULT NULL,
                          `addr` varchar(100) DEFAULT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of c_user
-- ----------------------------
INSERT INTO `c_user` VALUES ('7', 'aa', '123456', '290064525@qq.com', '上海', '上海市', '安顺');
INSERT INTO `c_user` VALUES ('8', 'admin', '123456', '2361142124@qq.com', '贵州省', '黔东南', '贵州省黔东南州');
INSERT INTO `c_user` VALUES ('9', '460649487', 'ai123456789', '460649487@qq.com', null, null, null);
INSERT INTO `c_user` VALUES ('10', 'admin1', '123456', '4751142124@qq.com', null, null, null);
INSERT INTO `c_user` VALUES ('11', 'ai123456', '123456789123', '12456789@qq.com', null, null, null);
INSERT INTO `c_user` VALUES ('12', 'aaa', '123456123456', '123456@qq.com', null, null, null);

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
                         `tokenStr` varchar(200) DEFAULT NULL,
                         `user_id` int(11) DEFAULT NULL,
                         `user_name` varchar(20) DEFAULT NULL,
                         KEY `user_id` (`user_id`) USING BTREE,
                         CONSTRAINT `token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `c_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES ('43adb86e-55a4-4ce5-ab16-f2ec87a8a607', '7', 'aa');
INSERT INTO `token` VALUES ('0024f711-fdc3-477e-89a5-3d5e514a369e', '8', 'admin');
INSERT INTO `token` VALUES ('2510446c-15fa-4d91-badb-bfbb1f503ad2', '8', 'admin');
INSERT INTO `token` VALUES ('08db343f-b8c4-487e-8e73-14199aceda16', '8', 'admin');

create table contact_us(
                           `username` varchar(255) not null unique ,
                           `email` varchar(255) not null ,
                           `phone` varchar(12) not null ,
                           `proposal` varchar(255)
);
alter table contact_us convert to character set utf8;
create table CartItem(
                         `id` int primary key auto_increment,
                         `img_path` varchar(255),
                         `type` varchar(255),
                         `count` int,
                         `price` int,
                         `paymentMethod` varchar(255)
);
alter table CartItem convert to character set utf8;

create table cart(
                     `id` int,
                     `img_path` varchar(255) not null ,
                     `type` varchar(255) not null ,
                     `count` int not null ,
                     `price` int not null ,
                     `paymentMethod` varchar(255) not null
);
alter table cart convert to character set utf8;
# 收藏夹
create table favorite(
                         `id` int,
                         `img_path` varchar(255),
                         `type` varchar(255),
                         `price` int
)