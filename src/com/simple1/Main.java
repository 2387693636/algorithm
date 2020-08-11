package com.simple1;

public class Main {

    public static void main(String[] args) {

        System.out.println(5 / 2);
        System.out.println(Math.round(2.5));
        System.out.println(Math.floor(5));

        int l=3 , r=4;
        int i = (l + r) / 2;
        System.out.println("("+l+"+"+r+")÷2="+i);
        //1-3   4-7


        System.out.println("".length());
        System.out.println("".equals(null)); //说明""虽然没有长度， 但是它有意义，表示不为null的一个String

        System.out.println(2%2);
        System.out.println(2/3);
    }
}
