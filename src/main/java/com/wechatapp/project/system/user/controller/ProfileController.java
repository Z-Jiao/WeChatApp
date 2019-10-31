package com.wechatapp.project.system.user.controller;

import com.wechatapp.project.system.user.domain.Student;
import com.wechatapp.project.system.user.domain.Token;
import com.wechatapp.project.system.user.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ProfileController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/system/user/profile")
    public String getUserPhoto( Model model,HttpServletRequest httpServletRequest) {
        Object token = httpServletRequest.getSession().getAttribute("token");
        System.out.println(token);

//        Student user = studentService.findByStudentId(username);
//        System.out.println(user);
//        model.addAttribute("user", user);
////        return "/system/user/profile";
//    }
        return "";
    }

}
