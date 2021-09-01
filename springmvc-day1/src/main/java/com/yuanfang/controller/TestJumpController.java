package com.yuanfang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestJump
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/1
 **/
@Controller
public class TestJumpController {

    @RequestMapping("test")
    public String test(){
        System.out.println("test Jump");
        return "index";
    }

    @RequestMapping("test1")
    public String test1(){
        System.out.println("test1 Jump");
        return "redirect:/index.jsp";
    }
}
