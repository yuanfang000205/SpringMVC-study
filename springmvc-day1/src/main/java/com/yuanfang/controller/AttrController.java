package com.yuanfang.controller;

import com.yuanfang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName AttrController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/2
 **/
@Controller
@RequestMapping("attr")
public class AttrController {
    /**
     * 使用request对象传递数据  ====> Model对象  其底层封装就是request对象 只能用于forward跳转
     */
    @RequestMapping("test")
    public String test(Model model,HttpServletRequest request, HttpServletResponse response) {
        //1.收集数据
        //2.调用业务方法
        String name = "陈建军";
        User user = new User("21", "胖子", 12, new Date());
        User user1 = new User("11", "瘦子", 22, new Date());
        User user2 = new User("22", "矮子", 33, new Date());
        List<User> users = Arrays.asList(user1,user2);
        model.addAttribute("users",users);
        model.addAttribute("user",user);
        model.addAttribute("username",name);
        //request.setAttribute("users",users);
        //request.setAttribute("username",name);
        //request.setAttribute("user",user);
        //3.流程跳转
        return  "attr";
    }

    /**
     * 使用redirect跳转传递数据
     *      两种方式:1）地址栏>拼接数据 2）session对象
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("test1")
    public String test1(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        //1.收集数据
        //2.调用业务
        String name = "陈建军";
        User user = new User("22", "矮子", 33, new Date());
        request.getSession().setAttribute("user",user);
        //流程跳转
        return "redirect:/attr.jsp?name=" + URLEncoder.encode(name,"UTF-8");
    }
}
