package com.xf.test.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-element/description/
 * <p>
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement {

    //mine 注意i++，可省略tmp操作
    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int tmp = nums[j];
                nums[j] = nums[i];
                j++;
                nums[i] = tmp;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

    //stadard solution
    public static int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                swap(nums, i, j);
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }

    static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arrays = {2, 3, 2, 2, 3};
//        final int i = removeElement(arrays, 3);
//        System.out.println(i);

        final int i1 = removeElement1(arrays, 3);
        System.out.println(i1);
    }
}
