package com.simple2;

/**
 * @auther: xq2580z
 * @date: 2020/2/13 14:14
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。  斐波那契数列的一个现实例子  f(n) = f(n -1) + f(n -2) (n > 2)
动态规划 递归
 */
public class Problem6 {

    //递归解决
    public int climbStairs(int n){
        if (n == 1) {
            return 1;
        }

        else if (n == 2) {
            return 2;
        }
        else{
            System.out.println("n-1是:"+(n-1)+" n-2是:"+(n-2));
//            return climbStairs(n-1)+climbStairs(n-2); // 这样的话重复计算过多
            //大于3阶时
            int result=0,i=1,j=2,k=3;
            while(k<=n){
                result=i+j;
                i=j;
                j=result;
                k++;
                System.out.println(k+"阶楼梯，有"+result+"种方法");
            }
            return result;

        }

    }

    public static void main(String[] args) {
        Problem6 problem6=new Problem6();
        int n=32;
        int i = problem6.climbStairs(n);
        System.out.println("爬"+n+"阶楼梯有"+i+"种方法");
    }

}
