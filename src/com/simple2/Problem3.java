package com.simple2;

/**
 * @auther: xq2580z
 * @date: 2020/2/12 17:05
 * 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 */
public class Problem3 {

    public String addBinaryString(String a, String b) {

        if (a.length() <= 0 || a.equals(null)) {
            return b;
        }
        if (b.length() <= 0 || b.equals(null)) {
            return a;
        }

        //模拟下进位
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                count += a.charAt(i--) - '0';
                System.out.println("a "+count);
            }
            if (j >= 0) {
                System.out.println( " b.charAt(j--) ");
                count += b.charAt(j--) - '0';

                System.out.println("b "+count);
            }
            stringBuilder.append(count % 2);
            count >>= 1;
        }

        String string = stringBuilder.reverse().toString();
        return count > 0 ? '1' + string : string;

    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        Problem3 problem3 = new Problem3();
        String string = problem3.addBinaryString(a, b);
        System.out.println(string);

    }

}
