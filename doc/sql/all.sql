DROP  TABLE  IF EXISTS TEST;
CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

ALTER  TABLE  TEST COMMENT '测试表';
INSERT INTO course.test (name) VALUES ('测试1');