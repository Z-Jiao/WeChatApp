package com.wechatapp.project.system.user.mapper;

import com.wechatapp.project.system.user.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生信息映射
 */
@Mapper
public interface StudentMapper {
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
     *
     * @param studentid
     */
    void delStudentById(String studentid);

    /**
     * 按照学生姓名查找
     * @param studentName
     */
    Student findStudentByName(String studentName);
}