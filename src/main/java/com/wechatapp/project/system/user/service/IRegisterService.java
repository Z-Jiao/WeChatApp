package com.wechatapp.project.system.user.service;

import com.wechatapp.project.system.user.domain.User;


public interface IRegisterService {
    /**
     * 注册功能业务层
     * @return
     */
     boolean registerData(User user);
}
