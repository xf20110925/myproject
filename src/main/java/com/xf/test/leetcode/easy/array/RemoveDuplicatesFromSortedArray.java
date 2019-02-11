package com.xf.test.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created by xuefeng on 2019/2/11
 * <p>
 * 2.1.1 Remove Duplicates from Sorted Array
 * 描述
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant mem- ory.
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesFromSortedArray {

    public static int solution(int[] array, int n) {

        int index = 0;
        for (int i = 1; i < n; i++) {
            if (array[index] != array[i]) {
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
