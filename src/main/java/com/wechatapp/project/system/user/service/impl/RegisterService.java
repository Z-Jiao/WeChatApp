package com.wechatapp.project.system.user.service.impl;

import com.wechatapp.project.system.user.domain.User;
import com.wechatapp.project.system.user.service.IRegisterService;
import com.wechatapp.project.system.user.service.IUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterService implements IRegisterService {
    @Autowired
    private IUserService userService;


    @Override
    public boolean registerData(User user) {
        User user1 = userService.findUserById(user.getUser_id());
        if (user1 == null) {
            // 将用户名作为盐值
            ByteSource salt = ByteSource.Util.bytes(user1.getUser_id());
            /*
             * MD5加密：
             * 使用SimpleHash类对原始密码进行加密。
             * 第一个参数代表使用MD5方式加密
             * 第二个参数为原始密码
             * 第三个参数为盐值，即用户名
             * 第四个参数为加密次数
             * 最后用toHex()方法将加密后的密码转成String
             * */
            String password = new SimpleHash("MD5", user.getPassword(), salt, 1024).toHex();
            user.setPassword(password);
            userService.addUser(user);
            return true;
        }
        return false;
    }
}
