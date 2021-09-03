package com.yuanfang.test;

import java.io.File;

/**
 * @ClassName TestFileName
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/3
 **/
public class TestFileName {
    public static void main(String[] args) {
        String name = "aa.txt";
        String[] split = name.split("\\.");
        System.out.println(split[split.length-1]);

        int i = name.lastIndexOf(".");
        String s = name.substring(i);
        System.out.println(s);
    }
}
