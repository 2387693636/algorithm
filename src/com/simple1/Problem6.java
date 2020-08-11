package com.simple1;

/**
 * @auther: xq2580z
 * @date: 2020/2/6 19:13
 * 给定一个 s1 字符串和一个 s2 字符串，
 * 在 s1 字符串中找出 s2 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 */
public class Problem6 {

    public int findStr(String s1, String s2) {
        int n1=s1.length();

        int n2 = s2.length();

        if (n1 < n2) {
            return -1;
        } else if (n2 == 0) {
            return 0;
        }
        for (int i=0;i<n1-n2+1;i++) {
            if (s1.substring(i, i + n2).equals(s2)) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Problem6 problem6=new Problem6();
        int str = problem6.findStr("111sasasdfs", "sas");
        System.out.println(str);
    }
}
