package com.yuanfang;

import com.yuanfang.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestUserService
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/2
 **/
public class TestUserService {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.findAll().forEach(System.out::println);
    }
}
