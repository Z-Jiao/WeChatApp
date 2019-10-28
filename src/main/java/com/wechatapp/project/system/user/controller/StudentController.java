package com.wechatapp.project.system.user.controller;

import com.wechatapp.project.system.user.domain.Student;
import com.wechatapp.project.system.user.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 学生管理控制层
 */
@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/system/student")
    public String findAllStudent(Model model) {
        List<Student> students = studentService.findAllStudents();
       model.addAttribute("students",students);
       return "main";
    }

}
