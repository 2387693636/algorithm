package com.simple2;

/**
 * @auther: xq2580z
 * @date: 2020/2/8 16:54
 */
public class Problem1{

    public int[] arrLastPlus1(int[] arr) {
        for (int i=arr.length-1;i>=0;i--) {
            if (arr[i] != 9) {
                arr[i]++;
                return arr;  //退出
            }
            arr[i]=0;  // 否则 遇到9就进位 最后一位数变为0 然后就新建数组new_arr new_arr[0]=1

        }
        int new_arr[] = new int[arr.length + 1];
        new_arr[0]=1;
        return new_arr;
    }


    public static void main(String[] args) {
        String aa  = "";
        System.out.println(aa);

        int[] a = {2, 9, 9};
        Problem1 problem1=new Problem1();
        int[] ints = problem1.arrLastPlus1(a);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
