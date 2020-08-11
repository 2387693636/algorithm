package com.simple2;

/**
 * @auther: xq2580z
 * @date: 2020/2/12 11:47
 */
public class Problem2 {

    public int numForLastWord(String s) {

        int count=0;
        for (int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i) != ' ') {  //从后往前 一个字母一个字母遍历 并且计数 遇到空格 返回前面的计数
                count++;
            }
            else if (count > 0) {
                return count;  //退出for循环
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Problem2 problem2=new Problem2();
        String s = "hi bro world";
        int i = problem2.numForLastWord(s);
        System.out.println(i);
    }

}
