package com.simple1;
/**
 * @auther: xq2580z
 * @date: 2020/2/4 11:05
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Problem8 {

    public boolean isPalindrome(int x){
        if (x < 0 || (x % 10 == 0 && x != 0)) {   //非回文数
            return false;
        }
        int a=0; //逆序数字 就是
        while (x > a) {
            a=a*10 + x%10;
            x=x/10;
        }
        return a==x||x==a/10;
    }

    public static void main(String[] args) {
        Problem8 problem8 =new Problem8();
        int xx=1221;
        boolean palindrome = problem8.isPalindrome(xx);
        System.out.println(xx+"是回文数吗？"+palindrome);
    }

}
