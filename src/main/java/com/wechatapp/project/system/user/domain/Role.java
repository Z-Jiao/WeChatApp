package com.wechatapp.project.system.user.domain;

import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class Role {
    private Integer role_id;
    private String role_name;
    private String remark;
    private String create_user_id;
    private Date create_time;
    private Set<Permission> permissions = new HashSet<>();
}
