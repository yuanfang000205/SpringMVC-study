package com.yuanfang.dao;

import com.yuanfang.entity.User;

import java.util.List;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/2
 **/
public interface UserDAO {
    void save(User user);
    List<User> findAll();
}
