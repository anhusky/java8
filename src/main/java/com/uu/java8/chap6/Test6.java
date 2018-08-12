package com.uu.java8.chap6;

import com.uu.java8.entity.Dish;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * 描述：
 *
 * @author liupenghao
 * @create 2018-08-10 上午8:41
 **/
public class Test6 {


    enum CaloricLevel {DIET, NORMAL, FAT}


    /**
     * 6.2  joing 方法测试
     */
    @Test
    public void joinTest() {
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println(shortMenu);
    }

    /**
     * 广义的归约汇总
     */
    @Test
    public void reduceTest() {
        Integer totalCalories = Dish.menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("totalCalories = " + totalCalories);


        //相当于
        Integer collect = Dish.menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("totalCalories 2 = " + collect);

    }

    /**
     *
     */
    @Test
    public void reduceTest2() {
        Optional<Dish> dish = Dish.menu.stream()
                .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(dish.get());
    }


    /**
     * 6.3 查找每个子分组 最高热量的菜
     * (多级分组）
     *
     * @return
     */
    @Test
    public void getMostCaloricByType() {
        Map<Dish.Type, Dish> mostCaloricByType = Dish.menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
    }


    /**
     * 6.3 找出每种类型 的Dish ，菜单中都有哪些CaloricLevel，及对象的Dish
     * (多级分组）
     */
    @Test
    public void getCaloricLevelByType() {
        Map<Dish.Type, Map<CaloricLevel, Set<Dish>>> collect = Dish.menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy((Dish dish) -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }, toSet())
                )
        );
    }

    /**
     * 6.3 找出每种类型 的Dish ，菜单中都有哪些CaloricLevel
     * (多级分组）
     */
    @Test
    public void getCaloricLevelByTypeTwo() {
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = Dish.menu.stream().collect(
                groupingBy(Dish::getType,
                        mapping((Dish dish) -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }, toCollection(HashSet::new))
                )
        );
    }

    /**
     * 6.4 分区
     * （多级）
     */
    @Test
    public void getPartitioningBy() {
        Map<Boolean, List<Dish>> collect = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
       /* Dish.menu.stream().collect(
                partitioningBy(Dish::isVegetarian)
                ,counting()
        );*/

        Map<Boolean, Map<Dish.Type, List<Dish>>> collect1 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        Map<Boolean, Map<Boolean, List<Dish>>> collect2 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, partitioningBy(d -> d.getCalories() > 500)));

    }

}


