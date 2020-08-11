package com.simple1;

/**
 * @auther: xq2580z
 * @date: 2020/2/7 12:17
 * 给定一个排序数组和一个目标值，
 * 在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
 */
public class Problem10 {
    public int searchInsert(int[] str, int val) {

        //1.遍历排序数组 判断数组中是否存在这样的val
        int a=str.length;
        for (int i=0;i<a;i++) {
            if (str[i] >= val) {
                System.out.println(val+"存在,位置是："+i);
                return i;
            }
        }
        System.out.println(val+"原来不存在,现在插入位置是："+a);
        return a;
        //2.存在的话 则返回索引

        //3.否则 插入 ，按顺序插入 返回插入的索引
    }

    public static void main(String[] args) {
        Problem10 problem10=new Problem10();
        int[] a = {1, 5, 8, 9, 10, 11};
        int target=122;
        int i = problem10.searchInsert(a, target);
        System.out.println(i);
    }
}
