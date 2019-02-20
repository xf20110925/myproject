package com.xf.test.leetcode.easy.stack;

import java.util.Stack;

/**
 * Created by xuefeng on 2019/2/20
 * <p>
 * 去除字符串中连续的ac 和 b，比如aaccd，去除之后就是d，因为去除中间的ac后，剩下acd，则再去除ac，剩下d。
 * <p>
 * <p>
 * 思路：这道题当时完全没有考虑到用栈来解决，写了一个递归的很麻烦的办法，结果可想而知啦。
 * 用栈很好解决啦，遇到一个c，判断栈顶是不是a，如果是a，则栈顶元素出栈，如果遇到b，则不做任何操作，如果遇到其他情况，将元素压入栈顶。
 * <p>
 * 作者：石晓文的学习日记
 * 链接：https://www.jianshu.com/p/9e98c6de2bfe
 * 來源：简书
 * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */
public class RemoveString {

    public static String remove(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'b')
                continue;
            else if (c == 'c') {
                Character peek = stack.peek();
                if (peek == 'a')
                    stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            stringBuffer.insert(0, stack.pop());
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(remove("aaccdbrd"));
    }
}
