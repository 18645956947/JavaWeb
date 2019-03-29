package com.mmall.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试泛型类
 */
public class Banana {
    public static void main(String[] args){
        Apple apple = new Apple(1, "nihao");
        List<Apple> list = new ArrayList<>();
        list.add(apple);
        System.out.println(list.get(0).toString());
        System.out.println(list.get(0).aa());
    }
}
