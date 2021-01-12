package com.medium;

import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class SumThreeNum {

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public static List<List<Integer>> solution(int[] nums){
        List<List<Integer>> resultList = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            //传入数组为空 或者数组中不足三个数
            return resultList;
        }
        //首先 排序
        Arrays.sort(nums);

        //双指针 遍历 找下标为 i i+1 nums.length - 1  三数之和为0
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                //排序完成后 从i=0开始 num[i]如果大于0  说明这个数组中肯定三数之和不等于0
                break;
            }
            // 去重 如果当前的nums[i] 和nums[i-1]相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len -1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {

                    //找出sum为0的数组下标 添加至返回结果数组
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重 如果当前值与下一值相等 则去重
                    if (nums[left] == nums[left + 1]) {
                        left++;
                    }
                    if (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        List<List<Integer>> collect = resultList.stream().distinct().collect(Collectors.toList());
        return collect;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(len < 3) {
            return ans;
        }
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) {
                break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue; // 去重
            }
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) {
                        L++; // 去重
                    }
                    while (L<R && nums[R] == nums[R-1]) {
                        R--; // 去重
                    }
                    L++;
                    R--;
                }
                else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        List<List<Integer>> solution = solution(nums);
        System.out.println(solution);
        //List<List<Integer>> lists = threeSum(nums);
        //System.out.println(lists);

        List<List<Integer>> lists = threeSum2(nums);
        System.out.println(lists);
    }


}
