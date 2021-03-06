package com.wechatapp.project.system.user.service;

import com.wechatapp.project.system.user.domain.User;

import java.util.List;

public interface IUserService {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据用户id查询该用户信息
     *
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新用户信息
     * @param id
     * @return
     */
    int UpdateUserById(String id);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    int DelUserById(String id);
}
