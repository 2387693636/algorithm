package com.simple2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @auther: xq2580z
 * @date: 2020/2/14 15:55
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 实例：
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 通过使用 HashSet 作为滑动窗口，我们可以用 O(1) 的时间来完成对字符是否在当前的子字符串中的检查。
 * 滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，
 * 即 [i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。
 * 例如，我们将 [i,j)向右滑动 1个元素，则它将变为 [i+1,j+1)（左闭，右开）。
 */
public class Problem10 {

    public int findStr(String string) {

        int length = string.length();
        Set<Character> set = new HashSet<>();
        int result = 0, i = 0, j = 0;
        while (i < length && length > j) {

            if (!set.contains(string.charAt(j))) {
                set.add(string.charAt(j++));
                result = Math.max(result, j - i);
            }else {
                set.remove(string.charAt(i++));
            }
        }
        return result;


    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        //        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        Problem10 problem10=new Problem10();
        int abcabcabccccc = problem10.lengthOfLongestSubstring("abcdabcdaccccc");
        System.out.println(abcabcabccccc);
    }
}
