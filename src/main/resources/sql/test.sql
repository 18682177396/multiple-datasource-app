DROP TABLE IF EXISTS `test_order`;
CREATE TABLE `test_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
