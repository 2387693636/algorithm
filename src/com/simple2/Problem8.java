package com.simple2;

/**
 * @auther: xq2580z
 * @date: 2020/2/13 15:27
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

一般而言，对于有序数组可以通过 双指针法 达到O(n+m)O(n + m)O(n+m)的时间复杂度。
 */
public class Problem8 {

    public int [] mergeTwoArray(int[] num1, int m, int[] num2, int n) {

        //1.使用双指针 确定num1数组为输出数组 p1为num1首元素  p2为num2的首元素

        //2.循环 使最小值放num1数组中  如num1[0]=1 num2[0]=2 就把num1[0]=1放于num1[0]首位

        //新建num1数组的copy
//        int[] num1_copy = new int[m];

//        从两个数组右侧开始比较, 即可按从大到小开始合并数组, 即可利用数组1右侧的空间,

        for (int i=m+n-1;i>=0;i--) {
            if (m  > 0 && n > 0 && num1[m - 1]>num2[n-1]||n==0) {
                num1[i] = num1[--m];

            }
            else {
                num1[i] = num2[--n];
            }

        }
        return num1;

    }

    public static void main(String[] args) {
        Problem8 problem8 =new Problem8();
        int []a={1,2,3,5,5,8};
        int[] b = {2, 5, 8, 9, 9};
        int[] ints = problem8.mergeTwoArray(a, 3, b, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
