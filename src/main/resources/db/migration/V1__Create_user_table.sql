CREATE TABLE user
(
    user_id varchar(20),
    name varchar(50) PRIMARY KEY,
    password varchar(20),
    email varchar(100),
    mobile varchar(100),
    status tinyint(4) DEFAULT 1,
    create_user_id varchar(20) DEFAULT 20,
    create_time datetime
);