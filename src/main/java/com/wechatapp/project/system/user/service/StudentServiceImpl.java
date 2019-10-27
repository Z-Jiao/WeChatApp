package com.wechatapp.project.system.user.service;

import com.wechatapp.project.system.user.domain.Student;
import com.wechatapp.project.system.user.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAllStudents() {

        return studentMapper.findAllStudents();

    }

    @Override
    public Student findByStudentId(Integer studentId) {
        return studentMapper.findByStudentId(studentId);
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public void alterStudent(Student student) {
        studentMapper.alterStudent(student);
    }

    @Override
    public void delStudentById(Integer id) {
        studentMapper.delStudentById(id);
    }

    @Override
    public Student findStudentByName(String StudentName) {
       return studentMapper.findStudentByName(StudentName);
    }
}
