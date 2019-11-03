CREATE TABLE `role_permission` (
  `role_id` bigint (20) DEFAULT NULL COMMENT '角色id',
  `permission_id` VARCHAR (20) DEFAULT NULL COMMENT '权限id',
  KEY `role_id` (`role_id`) USING BTREE,
  KEY `permission_id` (`permission_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;