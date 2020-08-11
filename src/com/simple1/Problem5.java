package com.simple1;

/**
 * @auther: xq2580z
 * @date: 2020/2/6 18:45
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Problem5 {

    public int removeVal(int[] nums, int val) {
        if (nums.length <= 0 || nums == null) {
            return 0;
        }

        int i=0 , j=0; //i计数

        int length=nums.length;

        for (;j<length;j++) {
            if (nums[j] != val) {
                nums[i]=nums[j];
                System.out.print(nums[i]);
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Problem5 problem5 =new Problem5();
        int[] a = {1, 5, 8, 8, 9, 8, 4, 5, 8, 8};
        int val=8;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println("原来数组长度"+a.length);
        System.out.println("去除"+val+"后");
        int i = problem5.removeVal(a, val);
        System.out.println("现在数组长度"+i);

    }
}
