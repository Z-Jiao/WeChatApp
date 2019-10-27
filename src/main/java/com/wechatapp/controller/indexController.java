package com.wechatapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {

    @PostMapping("/index")
    public String login(@RequestParam(name = "studentId") String studentId, @RequestParam(name = "password") String password) {
        if (studentId.equals("123456") || password.equals("123456")) {
            return "redirect:system/student";
        } else {
            return "index";
        }
    }
}
