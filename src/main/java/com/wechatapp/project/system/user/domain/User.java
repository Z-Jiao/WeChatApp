package com.wechatapp.project.system.user.domain;

import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    private String user_id;
    private String name;
    private String password;
    private String email;
    private String mobile;
    private String status;
    private String create_user_id;
    private Date create_time;
    private Set<Role> roles = new HashSet<>();
}
