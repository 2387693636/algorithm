package com.simple1;

/**
 * @auther: xq2580z
 * @date: 2020/2/4 15:40
 * 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。 所有输入只包含小写字母 a-z 。
 */
public class Problem1 {

    public String findPublicStr(String[] str) {

        //1. 先判空 若为空则返回""
        if (str.length == 0 || null == str) {
            return "";
        }
        //2. 遍历数组foreach
        String s = str[0];
        System.out.println(str[0]);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i].indexOf(s));
            int j=0;  //记录索引
            for (;j<s.length() && j<str[i].length();j++) {
                if (s.charAt(j) != str[i].charAt(j)) {
                    //当str[]数组的第一个元素的charAt()和现在第i个元素的charAt()不相等 则说明他们的公共前缀找完了
                    break;
                }
            }
            s = s.substring(0, j);
            if ("".equals(s))
            {
                return s;
            }

        }

        return s;
    }

    public static void main(String[] args) {
        Problem1 problem1=new Problem1();
        String[] strings = {"a11sda11sda11sd", "a11sda1das", "a11sda11sddd"};
        String publicStr = problem1.findPublicStr(strings);
        System.out.println(publicStr);
    }


}
