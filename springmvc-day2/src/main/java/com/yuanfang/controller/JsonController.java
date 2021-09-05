package com.yuanfang.controller;

import com.alibaba.fastjson.JSONObject;
import com.yuanfang.entity.User;
import com.yuanfang.exceptions.UserNameNotFoundException;
import com.yuanfang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName JsonController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/4
 **/
@Controller
@RequestMapping("json")
public class JsonController {

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    public String test(){
        System.out.println("===========2=============");
        throw new RuntimeException("用户不存在！！！");
        //return "index";//====> ModelAndView  view index
    }

    @RequestMapping("findAll")
    @ResponseBody
    public List<User> findAll(HttpServletRequest request) {
        List<User> users = userService.findAll();
        request.setAttribute("users", users);
        return users;
    }

    /**
     * 使用springmvc提供注解@ResponseBody
     *  作用:用来将控制器方法的返回值转为json,并响应给前台
     */
    @RequestMapping("showAll")
    public @ResponseBody List<User> showAll(){
        //1.收集数据
        //2.调用业务
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID().toString(),"小陈123",23,new Date()));
        users.add(new User(UUID.randomUUID().toString(),"小黑",25,new Date()));
        users.add(new User(UUID.randomUUID().toString(),"小明",26,new Date()));
        return users;
    }

    /**
     * 使用阿里fastjson转换json
     */
    @RequestMapping("find")
    public void findAll(HttpServletResponse response) throws IOException {
        //1.收集数据
        //2.调用业务
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID().toString(),"小陈",23,new Date()));
        users.add(new User(UUID.randomUUID().toString(),"小黑",25,new Date()));
        users.add(new User(UUID.randomUUID().toString(),"小明",26,new Date()));
        //fastjson
        String s = JSONObject.toJSONStringWithDateFormat(users, "yyyy-MM-dd");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);
    }
}
