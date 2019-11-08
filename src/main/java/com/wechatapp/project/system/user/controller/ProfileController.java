package com.wechatapp.project.system.user.controller;

import com.wechatapp.project.system.user.domain.User;
import com.wechatapp.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ProfileController {

    @Autowired
    private IUserService userService;

    @GetMapping("/system/user/profile")
    public String getUserPhoto( Model model,HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        model.addAttribute("user", user);
        System.out.println(user);
       return "/system/user/profile";
    }

}
