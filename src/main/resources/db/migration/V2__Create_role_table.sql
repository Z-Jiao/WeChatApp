CREATE TABLE role
(
    role_id bigint(20) PRIMARY KEY,
    role_name varchar(100),
    remark varchar(100),
    create_user_id varchar(20),
    create_time datetime
);