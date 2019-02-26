package com.xf.test.leetcode.easy;

/**
 * Created by xuefeng on 2019/2/26
 * <p>域名反转
 * www.toutiao.com -> com.toutiao.www
 * <p>
 * 思路：先整体反转，第二部在字符'.'区间内进行反转
 */
public class DomainReverser {

    public static char[] reverse(char[] chars) {
        int length = chars.length;
        swap(chars, 0, length - 1);
        printChars(chars);

        int start = 0;
        int end;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                end = i - 1;
                swap(chars, start, end);
                start = i + 1;
            }
        }
        swap(chars, start, length - 1);
        printChars(chars);
        return chars;
    }

    public static void swap(char[] chars, int start, int end) {
        for (int i = start; i <= (start + end) / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[start + end - i];
            chars[start + end - i] = tmp;
        }
    }

    private static void printChars(char[] chars) {
        for (char c : chars) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        reverse(new char[]{'w', 'w', 'w', '.', 't', 'o', 'u', 't', 'i', 'a', 'o', '.', 'c', 'o', 'm'});
        reverse(new char[]{'w', 'a', 'p', '.', 'q', 'q', '.', 'c', 'o', 'm', '.', 'c', 'n'});
    }
}
