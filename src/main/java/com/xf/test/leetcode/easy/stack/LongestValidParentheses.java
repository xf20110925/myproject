package com.xf.test.leetcode.easy.stack;

import java.util.LinkedList;

/**
 * Created by xuefeng on 2019/2/11
 * <p>
 * 4.1.2 Longest Valid Parentheses
 * 描述
 * Given a string containing just the characters ’(’ and ’)’, find the length of the longest valid (well- formed) parentheses substring.
 * For ”(()”, the longest valid parentheses substring is ”()”, which has length = 2.
 * Another example is ”)()())”, where the longest valid parentheses substring is ”()()”, which has length = 4.
 */
public class LongestValidParentheses {

    public static int solution(String str) {
        LinkedList<Character> queue = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char thisChar = str.charAt(i);
            if (thisChar == '(') {
                queue.push(thisChar);
                continue;
            }
            if (queue.isEmpty())
                continue;
            char thatChar = queue.pollLast();
            if (thatChar == '(' && thisChar == ')')
                num += 2;
        }
        return num;

    }

    public static void main(String[] args) {
        int num = solution(")()())");
        int num1 = solution("(()");
        System.out.println(num);
        System.out.println(num1);
    }
}
