package com.wechatapp.freamwork.shiro.controller;

import com.wechatapp.project.system.user.domain.User;
import com.wechatapp.project.system.user.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: wangsaichao
 * @date: 2018/5/11
 * @description:
 */
@Controller
public class LoginController {
    /**
     * 访问项目根路径
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(Model model) {
        return "/login";
    }


    /**
     * 跳转到login页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "/login";
    }

    /**
     * 用户登录
     *
     * @param request
     * @param userid
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(HttpServletRequest request, String userid, String password, Model model, HttpSession session, String tryCode) {
        //对验证码的校验
        String rightCode = (String) request.getSession().getAttribute("rightCode");
        if (rightCode == null) {
            model.addAttribute("error", "验证码不能为空");
            return "/login";
        } else if (!rightCode.equals(tryCode)) {
            model.addAttribute("error", "验证码错误");
            return "/login";
        }
        System.out.println("rightCode="+rightCode+"tryCode="+tryCode);
        System.out.println("userid=" + userid);
        System.out.println("password=" + password);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userid, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //登录操作
            subject.login(usernamePasswordToken);
            User user = (User) subject.getPrincipal();
            //更新用户登录时间，也可以在ShiroRealm里面做
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "/system/main";
        } catch (Exception e) {
            //登录失败从request中获取shiro处理的异常信息 shiroLoginFailure:就是shiro异常类的全类名
            model.addAttribute("error", e.getMessage());
            //返回登录页面
            return "login";
        }
    }

    @RequestMapping("/index")
    public String index() {
            return "/login";
    }

//        /**
//         * 登出  这个方法没用到,用的是shiro默认的logout
//         * @param session
//         * @param model
//         * @return
//         */
//        @RequestMapping("/logout")
//        public String logout(HttpSession session, Model model) {
//            Subject subject = SecurityUtils.getSubject();
//            subject.logout();
//            model.addAttribute("msg","安全退出！");
//            return "login";
//        }

    /**
     * 跳转到无权限页面
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/unauthorized")
    public String unauthorized(HttpSession session, Model model) {
        return "/unauthorized";
    }
}
