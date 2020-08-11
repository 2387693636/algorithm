package com.simple2;

/**
 * @auther: xq2580z
 * @date: 2020/2/12 17:05
 * 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 */
public class Problem4 {

    public String addBinaryString(String a, String b) {

        //1.逐位计算

        //2.算每一位的加 和进位carry 判断进位 使用StringBuilder拼接

        StringBuilder sb = new StringBuilder();
        int m = a.length(), n = b.length();

        if (m < n) {
            return addBinaryString(b, a); // 算数从上到下 上面市大的下面是小的
        }

        int max = Math.max(m, n);
        int carry=0;
        int j=n-1; //j计数 最大的字符串
        //3.循环遍历 a , b 字符串  判断其中的进位即可
        for (int i=max-1;i>=0;--i) {
            //判断a中的1
            if (a.charAt(i)=='1'){
                ++carry;  // 进位
            }

            //判断b中的1
            if (j >= 0 && b.charAt(j--) == '1') {
                ++carry; // 进位
            }

            //判断carry进位是否等于1
            if (carry % 2 == 1) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            carry/=2;
        }

        if (carry == 1) {
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();

    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1001";
        Problem4 problem4 = new Problem4();
        String string = problem4.addBinaryString(a, b);
        System.out.println(string);

    }

}
