package com.simple2;

/**
 * @auther: xq2580z
 * @date: 2020/2/13 12:09
 *
实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

存在整数 a 满足 a2≤x<(a+1)2a^2 \le x < (a + 1)^2a2≤x<(a+1)2，
称 a 为 x 的 整数平方根。从几何角度来看，整数平方根就是小于 x 的最大正方形的边长。
 */
public class Problem5 {
    public int sqrt(int x) {

        //使用二分法查找 在一个有序集合中找到这样的a
        if (x < 2) { //1
            return x;
        }

        //定义中间量 num p
        long num;  //num是p的平方
        int p;   // p是我们要找的整数

        int l =2, r=x/2;
        while (l <= r) {
            p=l+(r-l)/2;
            num=(long) p*p;  //看p平方

            if (num > x) {  //说明超出
                r=p-1;
            } else if ((num < x)) { //说明还可以继续找
                l=p+1;
            }
            else {
                return p;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        int sqrt = problem5.sqrt(1024);
        System.out.println(sqrt);
    }
}
