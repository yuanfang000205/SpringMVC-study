package com.yuanfang.dao;

import com.yuanfang.entity.User;

import java.util.List;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/5
 **/
public interface UserDAO {
    /**
     * 查询所有用户信息
     */
    List<User> findAll();
}
