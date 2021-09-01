package com.yuanfang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/1
 **/
@Controller
public class HelloController {

    @RequestMapping(value = "hello")
    public String hello(){
        //1.收集数据
        //2.调用业务方法
        System.out.println("hello springmvc");
        //3.处理响应
        return "index";//页面逻辑名
    }
}
