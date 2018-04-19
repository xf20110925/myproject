package com.xf.test.alg;

import java.util.Arrays;

/**
 * Created by xuefeng on 2018-4-19.
 */
public class SelectionSort {

    private static int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            if (i != smallestIndex) {
                int tmp = nums[i];
                nums[i] = nums[smallestIndex];
                nums[smallestIndex] = tmp;

            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{3, 2, 22, 1, 111, 22, 33})));
    }
}
