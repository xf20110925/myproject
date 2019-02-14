package com.xf.test.leetcode.easy;

/**
 * Created by xuefeng on 2019/2/14
 * <p>
 * 15.1 Reverse Integer
 * 描述
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought
 * through this!
 * If the integer’s last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then
 * the reverse of 1000000003 overflows. How should you handle such cases?
 * row an exception? Good, but what if throwing an exception is not an option? You would then have
 * to re-design the function (ie, add an extra parameter).
 */
public class ReverseInteger {
    public static int reverse(int num) {
        String numStr = String.valueOf(num);
        StringBuilder result = new StringBuilder();
        boolean fistZero = true;
        for (int i = numStr.length() - 1; i > 0; i--) {
            if (fistZero && numStr.charAt(i) == '0') {
                continue;
            } else
                fistZero = false;
            result.append(numStr.charAt(i));
        }
        if (numStr.charAt(0) == '-')
            result.insert(0, numStr.charAt(0));
        else
            result.append(numStr.charAt(0));
        return Integer.valueOf(result.toString());
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1230400));
    }
}
