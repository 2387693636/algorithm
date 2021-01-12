package com.medium;

import java.util.HashMap;

/**
 * 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 输入: dividend = 10, divisor = 3
 输出: 3
 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 */
public class TwoNumDivide {
    public static int divide(int a, int b) {

        //1.先考虑溢出情况
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        //按位取反( ~ )，按位与( & )，按位异或( ^ )，按位或( | )。
        //按位异或 即不同为1，相同为0
        boolean is = (a > 0) ^ (b > 0);
        //取绝对值
        int absA = abs(a);
        int absB = abs(b);
        int result = 0 , count =0;

        //除
        while (absA >= absB) {
            //被除数大于除数
            count = 0;
            while ((absA >= (absB << count))) {
                //不满足的条件是 absB乘以n次2后
                count++;
            }
            //除数乘以n-1次2
            absA -= (absB << (count - 1));
            result += 1 << (count - 1);
        }
        if (is) {
            return -result;
        }else {
            return result;
        }
    }

    /**
     * 取绝对值
     * @param a
     * @return
     */
    public static int abs(int a) {
        return (a < 0) ? -a : a;
    }

    public static void main(String[] args) {
        int a = -2147483648;
        int b =  -1;
        int divide = divide(a, b);
        int div = div(a, b);

        System.out.println(divide);
        System.out.println(div);
    }

    private static int div(int a, int b) {
        //取绝对值
        long y = Math.abs(a);
        long x = Math.abs(b);
        long ans = 0;
        //如果被除数大于等于除数
        while(y >= x){
            long k = y, car = 1;
            while(k-(x << car) > 0) {
                //寻找最大的减数
                car ++;
            }
            // <<左移，变大  >>右移，变小
            y -= (x << (car-1));
            //商
            ans += (1 << (car-1));
        }

        if(a > 0 ^ b > 0) {
            //^异或 被除数与除数符号不同才为负
            ans = -ans;
        }

        if(ans >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(ans <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) ans;
    }
}
