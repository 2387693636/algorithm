package com.test;

import java.text.MessageFormat;

/**
 * @author: zou_xq
 * @description: 字符串灵活拼接，将形式和内容有效的分开
 * @date: 2020/8/18 14:56
 */
public class TestMessageFormat {
    public static void main(String[] args) {
        String a = "5";
        String b = "2";
        String c = "0";
        long startTimeMillis1 = System.currentTimeMillis();
        String format = MessageFormat.format("{0}:{1}:{2}", a, b, c);
        long endTimeMillis1 = System.currentTimeMillis();
        System.out.println("format为："+format+"; 耗时："+(endTimeMillis1-startTimeMillis1));

        long startTimeMillis2 = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer append = stringBuffer.append(a).append(":").append(b)
                .append(":").append(c);
        long endTimeMillis2 = System.currentTimeMillis();
        System.out.println("append："+append.toString()+"; 耗时："+(endTimeMillis2-startTimeMillis2));
    }
}
