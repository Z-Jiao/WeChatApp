package com.wechatapp.freamwork.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;



@Controller
public class IndexController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String defaultIndex() {
        return "/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(HttpServletRequest httpServletRequest, @RequestParam("studentId") String username,@RequestParam("password") String password,@RequestParam("tryCode")String tryCode,Model model) {
        String rightCode = (String) httpServletRequest.getSession().getAttribute("rightCode");
        if (rightCode ==null){
            model.addAttribute("error","验证码不能为空");
            return "/index";
        }else if (!rightCode.equals(tryCode)) {
            model.addAttribute("error","验证码错误");
            return "/index";
        }

        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            model.addAttribute("error","未知账户");
            return "index";

        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("error","密码不正确");
            return "index";

        } catch (LockedAccountException lae) {
            model.addAttribute("error","账户已锁定");
            return "index";

        } catch (ExcessiveAttemptsException eae) {
            model.addAttribute("error","用户名或密码错误次数过多");
            return "index";

        } catch (AuthenticationException ae) {
            model.addAttribute("error","用户名或密码不正确");
            return "index";

        }
        if (subject.isAuthenticated()) {
            return "/system/main";

        } else {
            token.clear();
            return "/index";
        }
    }
}
