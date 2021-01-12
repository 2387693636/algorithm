package com.stream;

import com.util.StudentInfo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Integer> integerList = Arrays.asList(6,5,8,1, 2, 3, 4);
        List<Integer> collect1 = integerList.stream().map(integer -> integer * integer).distinct().collect(Collectors.toList());
        collect1.forEach(System.out::println);

        List<String> strings = Arrays.asList("ab", "bc", "cf", "kj", "kj","");
        //获取空字符串数量信息
        long count = strings.stream().filter("kj"::equals).count();
        System.out.println(count);

        //使用外部联结的左联结。
        //内联结，两边表同时有对应的数据，即任何一边缺失数据就不显示。
        //左联结，读取左边数据表的全部数据，即便右边表无对应数。即右表d中dept_no即使为NULL，也会读取左表e中的全部emp
        // select a.name from a left join b on a.id=b.id;

        //integerList.stream().sorted(Comparator.reverseOrder());
        System.out.println(integerList);
        //使用流的时候注意  列表进来 需要转化为新的列表 可以选择根据某一列的数据进行排序
        List<Integer> collect2 = integerList.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());
        System.out.println(collect2);
        //筛选大于5的数据按照顺序排
        List<Integer> collect3 = integerList.stream().filter(e -> e> 5).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(collect3);

        List<StudentInfo> studentInfoList = new ArrayList<>();
        StudentInfo info = new StudentInfo();
        info.setStuAge(11);
        info.setStuName("d");
        info.setGrade("11");
        studentInfoList.add(info);
        studentInfoList.add(new StudentInfo("a" ,1,"1"));
        studentInfoList.add(new StudentInfo("b" ,2,"2"));
        studentInfoList.add(new StudentInfo("c" ,3,"3"));
        //studentInfoList.stream().forEach(System.out::println);
        //System.out.println(studentInfoList);

        //取出学生姓名生成一个新的姓名数组
        List<Integer> collect5 = studentInfoList.stream().mapToInt(StudentInfo::getStuAge).boxed().distinct().collect(Collectors.toList());
        System.out.println(collect5.toString());


        //List<StudentInfo> collect4 = studentInfoList.stream().filter(e -> e.getStuAge() > 15).collect(Collectors.toList());
        //System.out.println(collect4);

        //list 排序的 DESC ASC注意
    }

}
