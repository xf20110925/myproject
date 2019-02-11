package com.xf.test.leetcode.easy.string;

/**
 * 题目：
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * “A man, a plan, a canal: Panama” is a palindrome.
 * “race a car” is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * 翻译：
 * 给定一个字符串，检测它是否是回文对称的，只考虑其中字母与数字的字符。
 * 例如”A man, a plan, a canal: Panama”是回文对称的，”race a car”不是。
 * 提示：你考虑过字符串可能是空的情况吗？这是一个面试中应该问出的好问题。为了处理这个问题，我们假定空串是回文对称的。
 */
public class ValidPalindrome {
    public static boolean valid(String str) {
        str = str.replaceAll("[\\s+\\W+]", "").toLowerCase();
        if (str.isEmpty())
            return true;
        final char[] chars = str.toCharArray();
        int charLength = chars.length;
        for (int i = 0; i < charLength / 2; i++) {
            if (chars[i] != chars[charLength - i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(valid("A man, a plan, a canal: Panama"));
        System.out.println(valid("abcdcba"));
        System.out.println(valid("abcdqcba"));
    }
}
