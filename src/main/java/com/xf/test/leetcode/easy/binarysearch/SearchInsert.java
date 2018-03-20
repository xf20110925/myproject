package com.xf.test.leetcode.easy.binarysearch;

/**
 * https://leetcode.com/problems/search-insert-position/description/
 * <p>
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        final SearchInsert searchInsert = new SearchInsert();
        final int index = searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(index);

        final int index1 = searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println(index1);

        final int index2 = searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(index2);
    }

}
