package com.wechatapp.project.system.user.domain;

import lombok.Data;

/**
 * 学生实体类
 */
@Data
public class Student {
    private Integer id;
    private Integer studentId;
    private String name;
    private String sex;
    private Integer phone;
    private String college;
    private String classes;
    private String photo;
}
