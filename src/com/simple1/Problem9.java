package com.simple1;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: xq2580z
 * @date: 2020/2/4 14:35
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *  罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 */
public class Problem9 {

    public int romanWordsToInt(String s) {
        //1.将罗马符号存入哈希表中 HashMap

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        //2.对输入得String罗马符号进行判断 遍历字符 进行匹配
        int result = 0;
        for (int i=0;i<s.length();) {
            //3.先判断两个字符的组合在哈希表中是否存在 若无，则判断一个字符的组合
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                System.out.println(s.substring(i,i+2 ));
                //4.若存在 则将对应的value取出来 加到结果result中
                result += map.get(s.substring(i, i + 2));
                i+=2;
            }else {
                //若无，则判断一个字符的组合
                result += map.get(s.substring(i, i + 1));
                System.out.println(s.substring(i,i+1 ));
                i++;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Problem9 problem9=new Problem9();
        int cm = problem9.romanWordsToInt("MCMXCIV");
        System.out.println(cm);
    }
}
