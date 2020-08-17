package com.study.pattern.factory;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author: zou_xq
 * @description: 测试简单工厂方法模式的应用
 * @date: 2020/8/14 14:45
 */
public class DateTest {
    public static void main(String[] args) {
        Locale locale = Locale.FRENCH;
        Date date = new Date();
        String format_now = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale).format(date);
        System.out.println("现在时间时：" + format_now);
        try {
            date = DateFormat.getDateInstance(DateFormat.DEFAULT, locale).parse("16 nov.01");
            System.out.println("date: "+date);
        } catch (Exception e) {
            System.out.println("exception is : " + e );
        }
    }
}
