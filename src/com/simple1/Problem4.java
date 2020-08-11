package com.simple1;

/**
 * @auther: xq2580z
 * @date: 2020/2/6 18:10
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
给定 nums = [0,0,1,1,1,2,2,3,3,4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
你不需要考虑数组中超出新长度后面的元素。
 */
public class Problem4 {

    public int removeDuplicates(int [] nums){

        if (nums.length <= 0 || null == nums) {
            return 0;
        }

        //使用双指针 p,q 一个在前 一个在后
        int p=0, q=1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) { //.比较 p 和 q 位置的元素是否相等。
                nums[p + 1] = nums[q]; //如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
                p++;
            }
            q++; //如果相等，q 直接后移 1位 不相等 q+1计数
        }  //重复上述过程，直到 q 等于数组长度。

        //返回 p + 1，即为新数组长度
        return p+1;

    }

    public static void main(String[] args) {
        Problem4 problem4=new Problem4();
        int[] a={1,2,2,8,8,8,9,11,55,666,888};
        System.out.println("原来数组长度是："+a.length);
        int i = problem4.removeDuplicates(a);
        System.out.println("现在数组长度是："+i);
    }
}
