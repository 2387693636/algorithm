package com.medium;

/**
 * 得到
 */
public class CountNotEqual {
    public static int countEquals(int a, int b) {
        return a | b;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 11;
        System.out.println(countEquals(a, b));
    }
}
