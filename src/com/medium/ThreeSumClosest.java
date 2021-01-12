package com.medium;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class ThreeSumClosest {
    public static int sumThreeNum(int[] nums , int tartget) {
        if (nums.length < 3) {
            return Arrays.stream(nums).sum();
        }
        //先排序
        Arrays.sort(nums);
        //先定义结果 固定为前三个数之和 后续根据双指针进行更新
        int result = nums[0] + nums[1] + nums[2];
        //然后固定一个元素值为第，再去寻找另外两个元素，也就是双指针 利用双指针 每次更新
        for (int i = 0; i < nums.length - 2; i++) {
            //定义双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                int sum = nums[i] + nums[left] + nums[right];
                //判断是否接近 根据差值来判断哪个更接近
                if (Math.abs(sum - tartget) < Math.abs(result - tartget)) {
                    //把最接近的值给result
                    result = sum;
                }
                //根据条件 先移动下标 再去判差值取最接近的
                if (sum > tartget) {
                    right--;
                    while (left != right && nums[right+1] == nums[right]) {
                        right--;
                    }
                }else {
                    left++;
                    while (right != left && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
                //重复的值 i+1
                while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int i = sumThreeNum(nums , target);
        System.out.println(i);
    }
}
