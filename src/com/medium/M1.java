package com.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: xq2580z
 * @date: 2020/2/16 14:22
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 N字形排列。
 * <p>
  * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右 逐行读取 ，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class M1 {

    /*
    row 行数
    str 目标字符串
     */
    public String revert(String str, int row) {
        if (row < 2) {
            //1行的话就直接返回 str
            return str;
        }

        //否则 使用StringBuilder来拼接结果
//        StringBuilder stringBuilder = new StringBuilder();
        //用List来当每一行 存储每行的字母
        List<StringBuilder> list = new ArrayList<>();

        //遍历字符串
        for (int i = 0; i < row; i++) {
            //按照 row 的长度遍历
            //遍历一次就是一行
            list.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char sb : str.toCharArray()) {
            list.get(i).append(sb);
            if (i == 0 || i == row - 1) {
                //到达转折点 需要反转了
                flag = -flag;
            }
            i = i + flag;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder re : list) {
            //遍历list
            result.append(re);
        }
        return result.toString();
    }

    public String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) {
                flag = - flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }



    public static void main(String[] args) {
        M1 m = new M1();
        String s = "LEETCODEISHIRING";
        int row = 3;
        String revert = m.revert(s, row);
        System.out.println(revert);
    }
}
