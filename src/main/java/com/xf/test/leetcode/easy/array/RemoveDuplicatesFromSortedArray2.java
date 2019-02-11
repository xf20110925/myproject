package com.xf.test.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created by xuefeng on 2019/2/11
 * <p>
 * 2.1.2 Remove Duplicates from Sorted Array II
 * 描述
 * Follow up for ”Remove Duplicates”: What if duplicates are allowed at most twice? For example, Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3]
 * <p>
 * 4 第2章 线性表 分析
 * 加一个变量记录一下元素出现的次数即可。这题因为是已经排序的数组，所以一个变量即可解 决。如果是没有排序的数组，则需要引入一个 hashmap 来记录出现次数。
 */
public class RemoveDuplicatesFromSortedArray2 {

    public static int solution(int[] array, int n) {

        int index = 0;
        int occur = 1;
        for (int i = 1; i < n; i++) {
            if (array[index] == array[i]) {
                occur++;
            } else {
                occur = 1;
            }
            if (occur <= 2) {
                array[++index] = array[i];
            }
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, index + 1)));
        return index + 1;
    }

    public static void main(String[] args) {
        int distinctLength = solution(new int[]{1, 2, 3, 3, 3, 4, 4, 5, 8}, 9);
        System.out.println(distinctLength);
    }
}
