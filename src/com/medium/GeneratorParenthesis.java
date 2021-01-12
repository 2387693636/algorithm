package com.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * n = 3
 * ["((()))","(()())","(())()","()(())","()()()"]
 * 搜索几乎都是用深度优先遍历（回溯算法）
 * 广度优先遍历，得程序员自己编写结点类，显示使用队列这个数据结构。深度优先遍历的时候，就可以直接使用系统栈，
 * 在递归方法执行完成的时候，系统栈顶就把我们所需要的状态信息直接弹出，而无须编写结点类和显示使用栈。
 *
 *
 */
public class GeneratorParenthesis {

    class Node {
        //当前字符串
        private String str;

        //剩余左括号数量
        private int left;
        //剩余右括号数量
        private int right;

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generator(int n) {
        List<String> resultList = new ArrayList<>();
        //输入的整数小于1
        if (n < 1) {
            return resultList;
        }
        // 查看了 Stack 源码，官方推荐使用 Deque 对象，
        // 注意：只使用栈相关的接口，即只使用 `addLast()` 和 `removeLast()`
        Deque<Node> stack = new ArrayDeque<>();
        stack.addLast(new Node("", n, n));
        while (!stack.isEmpty()) {
            Node curNode = stack.removeLast();
            if (curNode.left == 0 && curNode.right == 0) {
                resultList.add(curNode.str);
            }
            if (curNode.left > 0) {
                stack.addLast(new Node(curNode.str + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                stack.addLast(new Node(curNode.str + ")", curNode.left, curNode.right - 1));
            }
        }
        return resultList;
    }

    /**
     * 第二种简单解法
     * @param n
     * @return
     */
    public List<String> generator2(int n) {
        List<String> list = new ArrayList<>();
        generate("", n, n, list);
        return list;
    }

    private void generate(String s, int n, int n1, List<String> list) {
        if (n==0 && n1 ==0){
            list.add(s);
        }
        //左括号小于n
        if (n > 0) {
            generate(s + "(", n - 1, n1, list);
        }

        // 如果右括号剩余多于左括号剩余的话，可以拼接右括号 才能放置右括号
        if (n < n1) {
            generate(s+")" , n , n1-1 , list);
        }
    }

    public static void main(String[] args) {
        GeneratorParenthesis generatorParenthesis = new GeneratorParenthesis();
        List<String> generator = generatorParenthesis.generator(3);
        List<String> generator2 = generatorParenthesis.generator2(3);
        System.out.println("1: "+generator);
        System.out.println("2: "+generator2);
    }
}
