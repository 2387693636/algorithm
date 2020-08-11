package com.simple2;

/**
 * @auther: xq2580z
 * @date: 2020/2/15 13:34
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class Problem11 {

    public double findMidian(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;

        if (m > n) {
            return findMidian(B, A);   //确保m<=n
        }

        int i_min = 0, i_max = m, i_half = (m + n + 1) / 2;

        //遍历
        while (i_min <= i_max) {
            int i = (i_min + i_max) / 2;
            int j = i_half - i;
            if (j != 0 && i != m && B[j - 1] > A[i]) {
                i_min = i + 1;
            } else if (i != 0 && j != n && A[i - 1] > B[j]) {
                i_max = i - 1;
            } else {
                //达到要求
                int max_left = 0;
                if ((i == 0)) {
                    max_left = B[j - 1];
                } else if (j == 0) {
                    max_left = A[i - 1];
                } else {
                    max_left = Math.max(A[i - 1], B[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    //奇数
                    return max_left;
                }
                int min_right=0;
                if (i == m) {
                    min_right =  B[j] ;
                } else if (j == n) {
                    min_right = Math.max(A[i], B[j]);
                }

                return (max_left+min_right)/2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Problem11 problem11=new Problem11();
        int [] a={1,3};
        int[] b = {2};
        double midian = problem11.findMidian(a, b);
        System.out.println("中位数是："+midian);

    }
}
