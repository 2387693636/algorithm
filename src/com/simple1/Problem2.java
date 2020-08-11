package com.simple1;

import java.util.HashMap;
import java.util.Stack;

/**
 * @auther: xq2580z
 * @date: 2020/2/5 10:00
 * 将检测括号是否匹配。
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

 */
public class Problem2 {

    //1. 使用Hash表来存需要匹配的符号
    private HashMap<Character , Character> hashMap;

    //2. 无参构造函数初始化 给hashmapp存入符号信息
    public Problem2(){
        hashMap = new HashMap<Character, Character>();
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        hashMap.put(')', '(');
    }

    //3. 利用栈 先进后出
    //一次处理表达式的每个括号。
    //如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
    //如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
    //如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
    public boolean isValid(String s) {
        //1. 初始化栈 stack
        Stack<Character> stack=new Stack<Character>();
        //遍历给定的字符串中的一个字符并在栈上进行推入和弹出操作
        for (int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);  // 遍历s的元素 每个组成部分
            //判断其在hash表中是否存在对应的部分
            if (hashMap.containsKey(c)) {
                //存在的话就从栈顶取出元素 若栈为空则设置为‘#’
                char topElement = stack.isEmpty() ? '#' : stack.pop();

                //判断这个topElement在hash表中是否存在
                if (topElement != hashMap.get(c)) {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        //如果这个栈中依然包括元素 则表明这个组合是非法的
        return  stack.isEmpty();

    }

    public static void main(String[] args) {
        Problem2 problem2 =new Problem2();
        boolean valid = problem2.isValid("{{}}");
        System.out.println(valid);
    }


}
