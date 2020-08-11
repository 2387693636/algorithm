package com.simple2;

import com.sun.xml.internal.messaging.saaj.soap.SOAPVersionMismatchException;

/**
 * @auther: xq2580z
 * @date: 2020/2/16 13:54
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class Problem12 {

    public String longestPalindrome7(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];

        for (boolean b : P) {
            System.out.println(b);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem12 problem12=new Problem12();
        String aab = problem12.longestPalindrome7("acaebaca");
        System.out.println(aab);
    }

}
