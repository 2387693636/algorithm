package com.simple1;

/**
 * @auther: xq2580z
 * @date: 2020/2/4 10:32
 * letcode 简单第七题
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Problem7 {

    private  int reverse(int x ){
        //输入x 有符号 反转其各个位数的数字


        int rev = 0 ; //结果

        while (x != 0) {
            int p = x%10; //除十后，余数
            x=x/10; //x除十取整

            //判断是否会溢出
            if (rev > Integer.MAX_VALUE / 10 || (rev==Integer.MAX_VALUE/10 && p>7)) return 0; //正数溢出

            if (rev < Integer.MIN_VALUE/ 10 || (rev == Integer.MIN_VALUE/10 && p <-8)) return 0; //负数溢出

            rev=rev*10 + p;  //可能会导致溢出。

        }

        return rev;
    }

    public static void main(String[] args) {
        Problem7 problem7 = new Problem7();
        int result = problem7.reverse(-235);
        System.out.println("结果是："+result);
    }


}
