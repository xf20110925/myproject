package com.xf.test.leetcode.easy.binarysearch;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {
    public Integer[] intersection(int[] nums1, int[] nums2) {
        final HashSet<Integer> targets = new HashSet<>();

        Arrays.sort(nums1);
        for (final int i : nums2) {
            final int target = binarySearch(nums1, i);
            if (target != -1){
                targets.add(target);
            }
        }
        return targets.toArray(new Integer[0]);
    }

    public int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end ) / 2;
            if (target > nums[mid]){
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            }else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        final IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();
        final Integer[] interses = intersection.intersection(new int[]{1, 2, 3, 5, 2, 11}, new int[]{3, 2});
        System.out.println(Arrays.toString(interses));
    }
}
