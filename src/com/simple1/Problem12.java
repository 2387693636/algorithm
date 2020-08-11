package com.simple1;


/**
 * @auther: xq2580z
 * @date: 2020/2/7 13:25
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Problem12 {

    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int currSum = nums[0], maxSum = nums[0];
//
//        for (int i = 1; i < n; ++i) {
//            currSum = Math.max(nums[i], currSum + nums[i]);
//            maxSum = Math.max(maxSum, currSum);
//        }
//        return maxSum;
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;  //计数
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem12 problem12 = new Problem12();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = problem12.maxSubArray(nums);
        System.out.println("最大和是：" + i);
    }
}
