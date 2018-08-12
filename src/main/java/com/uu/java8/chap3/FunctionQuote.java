package com.uu.java8.chap3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * 描述：方法引用
 * 3.6
 *
 * @author liupenghao
 * @create 2018-07-11 下午3:12
 **/
public class FunctionQuote {
    /**
     * 对字符串进行排序，忽略大小写
     */
    @Test
    public void stringToSort() {
        List<String> items = Arrays.asList("a", "b", "A", "B");
        //items.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        items.sort(String::compareToIgnoreCase);
        for (String s : items) {
            System.out.println(s);
        }
    }

    /**
     * page 57
     * 构造函数  方法引用
     */
    @Test
    public void testBiFunction() {
        BiFunction<String, Integer, Apple> function =
                //(color, weight) -> new Apple(color, weight);
                Apple::new;
        Apple apple = function.apply("yellow", 100);
        System.out.println(apple.toString());
    }

}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Apple {
    private String color;
    private Integer weight;
}

