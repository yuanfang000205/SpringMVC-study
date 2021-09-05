package com.yuanfang.service;

import com.yuanfang.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/5
 **/
public interface UserService {
    /**
     * 查询所有
     */
    List<User> findAll();
}
