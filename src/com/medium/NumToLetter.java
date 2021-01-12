package com.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 思路：递归：所有组合就用搜索算法 深度优先搜索
 */
public class NumToLetter {
    public static List<String> numtoletter(String num) {
        //输入
        List<String> resultList = new ArrayList<>();

        if (num.length() < 1) {
            return resultList;
        }
        //先构造数字对应的字母 哈希表存储 key为数字 value为对应的字母数组
        Map<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");

        StringBuffer stringBuffer = new StringBuffer();
        int index = 0;
        backtrack(resultList, hashMap, index, num, stringBuffer);

        return resultList;
    }

    private static void backtrack(List<String> resultList, Map<Character, String> hashMap, Integer index, String num, StringBuffer stringBuffer) {

        if (num.length() == index) {
            resultList.add(stringBuffer.toString());
        }else {
            char c = num.charAt(index);
            String letters = hashMap.get(c);
            int count = letters.length();
            for (int i = 0; i < count; i++) {
                stringBuffer.append(letters.charAt(i));
                //递归
                backtrack(resultList,hashMap,index+1,num,stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        List<String> numtoletter = NumToLetter.numtoletter("23");
        System.out.println(numtoletter);
    }
}
