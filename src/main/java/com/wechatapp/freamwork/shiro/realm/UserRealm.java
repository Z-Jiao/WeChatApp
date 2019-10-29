package com.wechatapp.freamwork.shiro.realm;

import com.wechatapp.project.system.user.domain.Student;
import com.wechatapp.project.system.user.service.IStudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private IStudentService studentService;

    /**
     * 执行授权逻辑
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
//        info.addStringPermission("user:add");
        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        Student Student = (Student) subject.getPrincipal();
        return info;
    }
    //在登录的时候调用
    //SimpleHash类帮助快速加密
    @Bean("MD5pwd")
    public static String MD5Pwd(String name, String pwd) {
        // 加密算法MD5
        // salt盐 username + salt
        // 迭代次数
        String md5Pwd = new SimpleHash("MD5", pwd,
                ByteSource.Util.bytes(name + "salt"), 2).toHex();
        return md5Pwd;
    }
    /**
     * 当执行login方法时会跳转到改方法执行认证
     * 执行认证逻辑
     *
     * @param arg0
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {

        //获取页面传过来的用户名和密码
        String name = (String) arg0.getPrincipal();
        String userPwd = new String((char[]) arg0.getCredentials());
        String pwd = MD5Pwd(name, userPwd);
        //编写shiro的判断逻辑
        Student student = studentService.findByStudentId(name);
        String password = student.getPassword();
        if (name == null) {
            //用户名不存在
            throw new AccountException("用户名不存在");
            //shiro底层会抛出UnKnowAccountException
        } else if (!pwd.equals(password)){
            throw new AccountException("密码不正确");
        }
            //判断密码
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        return new SimpleAuthenticationInfo(name, password,
                ByteSource.Util.bytes(name + "salt"), getName());
    }
}
