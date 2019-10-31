package com.wechatapp.project.system.user.service.impl;

import com.wechatapp.project.system.user.domain.User;
import com.wechatapp.project.system.user.mapper.UserMapper;
import com.wechatapp.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {

        return userMapper.findAllUser();
    }

    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int UpdateUserById(String id)
    {
        return userMapper.UpdateUserById(id);
    }

    @Override
    public int DelUserById(String id)
    {
        return userMapper.DelUserById(id);
    }
}
