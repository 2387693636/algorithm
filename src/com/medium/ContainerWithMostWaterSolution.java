package com.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 */
public class ContainerWithMostWaterSolution {
    /**
     * 1. 暴力法 两层遍历
     * 解决思路：
     * 算出：下标之差最大 * 对应值差最小的那个值 = 返回值
     **/
    public int maxContainer(int[] height) {
        if (height.length < 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            //遍历数组 选取下标之差最大且对应值差最小的
            //  [1,8,6,2,5,4,8,3,7]
            for (int j = i + 1; j < height.length; j++) {
                //再遍历剩下的
                //选出最大的面积
                max = Math.max(max, (Math.min(height[i], height[j])) * (j - i));
            }
        }
        return max;
    }

    /**
     * 2. 双指针 最左边 最右边的指针移动 （过程中固定较长的那条纪录值指针 移动短的指针）
     *
     * @param arr
     */
    public int soblePointSolution(int[] arr) {
        //定义左右指针 及 返回面积值
        int max = 0, left = 0, right= arr.length - 1;
        while (left < right) {
            //遍历数组 求出面积最大值 (right-left)是长 Math.min(arr[left], arr[right])是宽 之积为面积
            max = Math.max(max, (Math.min(arr[left], arr[right])) * (right - left));

            //每次遍历后 需要判断现在的左右指针大小 若左指针对应数值小于右指针对应数值 则移动左指针 （移动小的）
            if (arr[left] < arr[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        ContainerWithMostWaterSolution solution = new ContainerWithMostWaterSolution();
        int[] a = {1, 2,5 , 9};
        System.out.println("开始："+System.currentTimeMillis());
        int i = solution.maxContainer(a);
        System.out.println(i);
        System.out.println("结束：" + System.currentTimeMillis());
        solution.soblePointSolution(a);

        System.out.println("2 ------->开始："+System.currentTimeMillis());
        solution.soblePointSolution(a);
        System.out.println(i);
        System.out.println("2 ------->结束：" + System.currentTimeMillis());
    }
}
