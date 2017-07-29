package com.xf.test.alg;

/**
 * Created by xuefeng on 2017/7/12.
 */
public class KMP {
    /**
     * 暴力破解法 时间开销=O(m*n)
     * rababcds  rababcds rababcds rababcds
     * abc        abc       abc       abc
     * i=0 j=0 ,i=1 2 j=0 1, i=2 j=0, i=3 4 5 j= 0 1 2
     * @param patternStr
     * @param contentStr
     * @return
     */
    public static int index(String patternStr, String contentStr) {
        int pLength = patternStr.length();
        int cLength = contentStr.length();
        int i = 0, j = 0;
        while (i < cLength && j < pLength) {
            if (patternStr.charAt(j) == contentStr.charAt(i)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == pLength) return i - j;
        return -1;
    }

    public static void main(String[] args) {
        final int index = index("abc", "rababcds");
        System.out.println(index);
    }
}
