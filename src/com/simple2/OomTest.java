package com.simple2;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: xq2580z
 * @date: 2020/2/16 13:41
 */
public class OomTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i=0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}
