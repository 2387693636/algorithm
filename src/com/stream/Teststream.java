package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @description:
 * @projectName:xq-study-algorithm
 * @see:com
 * @author: zou_xq
 * @createTime:2020/7/29 14:21
 */
public class Teststream {
    public static void main(String[] args) {
        //在 Java 8 中, 集合接口有两个方法来生成流：
        //   1.stream() − 为集合创建串行流。
        //   2.parallelStream() − 为集合创建并行流。
        List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> collect = stringList.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        //老式foreach
//        for (String s : collect) {
//            System.out.println(s);
//        }

        // 提供了新的方法 'forEach' 来迭代流中的每个数据
        collect.forEach(System.out::println);

        //map 方法用于映射每个元素到对应的结果
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        List<Integer> collect1 = integerList.stream().map(integer -> integer * integer).distinct().collect(Collectors.toList());
        collect1.forEach(System.out::println);

        List<String> strings = Arrays.asList("ab", "bc", "cf", "kj", "kj","");
        //获取空字符串数量信息
        long count = strings.stream().filter(s -> "kj".equals(s)).count();
        System.out.println(count);

        //使用外部联结的左联结。
        //内联结，两边表同时有对应的数据，即任何一边缺失数据就不显示。
        //左联结，读取左边数据表的全部数据，即便右边表无对应数。即右表d中dept_no即使为NULL，也会读取左表e中的全部emp
        // select a.name from a left join b on a.id=b.id;



    }
}
