package com.test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/8/19 9:04
 */
public class Propertitiestest {
    public static void main(String[] args) {
        double result = (3 * 100/ 7);
        System.out.println(result);

        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(1);
        double x = 3;
        int y=7;
        System.out.println("百分数：" + nt.format(x / y));
        String format = nt.format(x / y);
        String[] strings = {"a", "b","a1", "b1","a2", "b2","a3", "b3"};
        int length = strings.length;
        double result2 = y*0.1*10 / length;
        System.out.println(result2);
        System.out.println(nt.format(y*0.1*10 / length));
    }
}
