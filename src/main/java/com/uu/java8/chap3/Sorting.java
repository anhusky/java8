package com.uu.java8.chap3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;


public class Sorting {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Apple {
        private Integer weight = 0;
        private String color = "";
    }

    /**
     * <pre>
     *     page:53
     *             3.6
     * </pre>
     */
    @Test
    public void testQuote1() {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80, "blue"),
                new Apple(155, "red"),
                new Apple(120, "yellow")));
        inventory.sort((a,b) -> a.getWeight() - b.getWeight());
        for (Apple a : inventory) {
            System.out.println(a.color +"-------"+ a.weight);
        }

    }

    @Test
    public void testQuote2() {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80, "b"),
                new Apple(155, "a"),
                new Apple(120, "cbbbb")));
        inventory.sort(comparing(Apple::getWeight).reversed());
        for (Apple a : inventory) {
            System.out.println(a.color +"-------"+ a.weight);
        }


    }

}
