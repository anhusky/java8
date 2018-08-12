package com.uu.java8.chap3;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * 描述：函数复合
 *
 * @author liupenghao
 * @create 2018-07-14 下午4:52
 **/
public class FunctionRecombination {

    /**
     * <pre>
     * Function andThen签名如下：
     *          default <V> Function<T, V> andThen(Function<? super R, ? extends V> after){}
     * so 返回的也是 自身Function
     * </pre>
     */
    @Test
    public void test1() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        Function<Integer,Integer> h = f.andThen(g);

        System.out.println(h.apply(1));
    }
}
