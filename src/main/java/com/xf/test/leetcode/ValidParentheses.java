package com.xf.test.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 题目：
 * Given a string containing just the characters , determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, “()” and “()[]{}” are all valid but “(]” and “([)]” are not.
 * <p>
 * 翻译：
 * 给定一个字符串，只包含’(‘, ‘)’, ‘{‘, ‘}’, ‘[’ 和’]’这些字符，检查它是否是“有效”的。
 * 括号必须以正确的顺序关闭，例如”()” 和”()[]{}”都是有效的，”(]” 和”([)]”是无效的。
 * <p>
 * 分析：
 * 本题考查的是栈结构，具有后进先出的特性。有效包含2个方面，第一个是如果是关闭的括号，前一位一定要刚好有一个开启的括号；第二个是最终结果，需要把所有开启的括号都抵消完。一个比较容易出错的地方是，遇到关闭括号时，要先判断栈是否已经空了。
 */
public class ValidParentheses {

    public static boolean valid(String str) {
        final LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.toCharArray().length; i++) {
            final char thisChar = str.charAt(i);
            if (thisChar == '{' || thisChar == '[' || thisChar == '(') {
                stack.push(thisChar);
                continue;
            }
            //遇到关闭括号判断为空返回false
            if (stack.isEmpty())
                return false;
            final Character stackChar = stack.pollLast();
            if ((thisChar == '}' && stackChar != '{') || (thisChar == ']' && stackChar != '[') || (thisChar == ')' && stackChar != '('))
                return false;
        }
        //防止"(){}[["情况判断错误
        if (!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        for (final String str : Arrays.asList("(){}[](){}", "(){}[[", "({[]})", "]}()")) {
            System.out.println(String.format("valid str[%s], ret[%s]", str, valid(str)));
        }
    }
}
