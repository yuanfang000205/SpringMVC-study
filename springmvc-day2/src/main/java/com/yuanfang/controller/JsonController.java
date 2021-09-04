package com.yuanfang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName JsonController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/4
 **/
@Controller
@RequestMapping("json")
public class JsonController {
    @RequestMapping("test")
    public String test(){
        System.out.println("===========2=============");
        throw new RuntimeException("保存失败,请稍后再试...");
        //return "index";//====> ModelAndView  view index
    }

}
