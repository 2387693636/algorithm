package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zou_xq
 * @description:   时间戳转现在时间 currentTime转时间戳信息·
 * @date: 2020/8/18 11:47
 */
public class TestTime {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        long thatTime = Long.valueOf("1597652906570");
        long thisTime = Long.valueOf("1597722858111");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(currentTime));
        System.out.println(dateFormat.format(thatTime));
        System.out.println(dateFormat.format(thisTime));
    }
}
