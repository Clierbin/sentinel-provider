package com.gupaovip.sentinel;

import com.sun.org.apache.bcel.internal.generic.RET;
import javafx.scene.Group;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName:TestDemo
 * Package:com.gupaovip.sentinel
 * description
 * Created by zhangbin on 2019/8/13.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/8/13 15:52
 */
public class TestDemo {
    public static void main(String[] args) {
/*        // 先来测试一下  list  单个数据转list
        String a="你好";
        List<String> singleton = new ArrayList<>();
        for (String s : singleton) {
            System.out.println(s);
        }
        singleton.add("hello word1");
        singleton.add("hello word22");
        singleton.add("hello word333");
        // 然后试一下 stream 中的  Java Stream API groupingBy()
        Map<Integer, List<String>> collect = singleton.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(collect);*/
        String test = test(b -> {
            b="lll";
            return "你好"+b;
        });
        System.out.println(test);
    }
    public static  String test(ISayService iSayService){
        return iSayService.say("");
    }
}
