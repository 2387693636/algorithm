package com.simple3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * O(n)
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    public int solutiuon(int[] nums) {
        int length = nums.length;
//        if (length < 3) {
//            return -1;
//        }
        int result = 0;
        //任何数与0异或为任何数 相同的数异或为0
        //相同为0，不同为1. 异或同一个数两次，原数不变。
        for (int i = 0; i < nums.length; i++) {
            //异或
            result = result ^ nums[i];
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] ints = {1, 2};
        int solutiuon = singleNumber.solutiuon(ints);

        System.out.println(solutiuon);
        System.out.println(1^2);
    }
}
