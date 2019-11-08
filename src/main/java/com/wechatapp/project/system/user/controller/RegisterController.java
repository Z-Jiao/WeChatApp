package com.wechatapp.project.system.user.controller;

import com.wechatapp.project.system.user.domain.User;
import com.wechatapp.project.system.user.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 注册控制层
 */
@Controller
public class RegisterController {
    @Autowired
    private IRegisterService registerService;

    @RequestMapping(value="/register",method= RequestMethod.GET)
    public ModelAndView toRegister(){
        return new ModelAndView("/register");
    }

    @PostMapping(value = "/register")
    public String register(String userid, String name, String password, String email, String mobile, String create_user_id, String avatar, Model model) throws ParseException {
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        String nowTime = sdf.format(date);
        Date time = sdf.parse(nowTime);
        User user = new User();
        user.setUser_id(userid);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setCreate_user_id(create_user_id);
        user.setCreate_time(time);
        user.setAvatar(avatar);
        System.out.println(user);
        boolean data = registerService.registerData(user);

        if (data) {
            model.addAttribute("userid", userid);
            model.addAttribute("password", password);
            return "/login";
        } else {
            model.addAttribute("error", "对不起，该学号/或工号已经存在！");
            return "/register";
        }
    }
}
