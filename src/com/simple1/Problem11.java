package com.simple1;

/**
 * @auther: xq2580z
 * @date: 2020/2/7 12:39
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
注意：整数序列中的每一项将表示为一个字符串。
题目的意思是对序列前一个数进行报数，
数列第一项不是1吗，那第二项就报第一项的有1个1，输出11，
然后第三项就在第二项的基础上报数，第二项是11，第三项不就是2个1么，然后输出21
 */
public class Problem11 {
    public static String countAndSay(int n){
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);  //递归  prev就是n-1后变成1
        StringBuilder stringBuilder = new StringBuilder();
        int index=0; // 记录索引
        char ch = '#';
        for (int i=0;i<prev.length();i++) {
            if (ch != prev.charAt(i)) {
                int length=i-index;
                stringBuilder.append(length);
                stringBuilder.append(ch);
                index=i;
                ch = prev.charAt(i);
            }
        }
        int len=prev.length()-index;
        stringBuilder.append(len);
        stringBuilder.append(ch);
        String string = stringBuilder.substring(2).toString();
        System.out.println(string);
        return string;
    }

    public static void main(String[] args) {
        int n=3;
        String s = Problem11.countAndSay(n);
        System.out.println(n+"的外观数列是 "+s);
    }
}
