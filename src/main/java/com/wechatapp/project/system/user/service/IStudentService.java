package com.wechatapp.project.system.user.service;

import com.wechatapp.project.system.user.domain.Student;

import java.util.List;

/**
 * 学生信息业务层
 */
public interface IStudentService {
    /**
     * 查询所有学生信息
     *
     * @return
     */
    List<Student> findAllStudents();

    /**
     * 查询学生信息通过学生证
     */
    Student findByStudentId(String studentId);

    /**
     * 增加学生信息
     */
    void addStudent(Student student);

    /**
     * 更改学生信息
     *
     * @param student
     */
    void alterStudent(Student student);

    /**
     * 删除学生信息
     * @param studentid
     */
    void delStudentById(String studentid);

    /**
     * 按照学生姓名查找
     * @param userName
     */
    Student findStudentByName(String userName);
}
