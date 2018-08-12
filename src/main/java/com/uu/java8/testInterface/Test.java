package com.uu.java8.testInterface;

import com.uu.java8.entity.Apple;

/**
 * 描述：
 *
 * @author liupenghao
 * @create 2018-07-11 下午3:12
 **/
public interface Test {

    Integer i = 0;
    Apple apple = new Apple("yellow", 111);

    static Integer hh() {
        return 1;
    }


    default Integer reversed() {
        return 2;
    }

    static void main(String[] args) {
        //i = 9;  不能修改接口中定义的属性
        //apple.setColor("red");
        //apple.setWeight(222);

        // apple = new Apple("red",222);
        System.out.println(apple.toString());
    }
}
