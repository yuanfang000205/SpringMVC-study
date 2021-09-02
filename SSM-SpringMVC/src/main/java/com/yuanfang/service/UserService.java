package com.yuanfang.service;

import com.yuanfang.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/2
 **/
public interface UserService {
    void save(User user);
    List<User> findAll();
}
