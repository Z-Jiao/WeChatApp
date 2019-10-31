package com.wechatapp.project.system.user.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Permission {
    private int id;
    private String parent_id;
    private String parent_ids;
    private String sesource_type;
    private String url;
    private String name;
    private char available;
    private Set<Role> roles = new HashSet<>();
}
