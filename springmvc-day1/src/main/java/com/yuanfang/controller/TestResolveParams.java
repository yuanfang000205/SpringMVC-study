package com.yuanfang.controller;

import com.yuanfang.entity.User;
import com.yuanfang.vo.CollectionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName TestResolveParams
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/1
 **/
@Controller
@RequestMapping("params")
public class TestResolveParams {

    /**
     * 测试接收零散类型参数
     * @return
     */
    @RequestMapping("test")
    public String test(String name,Integer age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        return "index";
    }

    /**
     * 测试接收对象类型参数
     * 其中Date类型为yyyy/MM/dd
     * @return
     */
    @RequestMapping("test1")
    public String test1(User user) {
        System.out.println(user);

        return "index";
    }

    /**
     * 测试接收数组类型参数
     * @return
     */
    @RequestMapping("test2")
    public String test2(String[] qqs){
        for (String qq :qqs) {
            System.out.println(qq);
        }
        return "index";
    }

    /**
     * 测试接收数组类型参数
     * @return
     */
    @RequestMapping("test3")
    public String test3(CollectionVO collectionVO){
        collectionVO.getLists().forEach(System.out::println);
        return "index";
    }
}
