package com.xf.test.leetcode.easy;

import java.util.Arrays;

/**
 * 题目：
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * <p>
 * 翻译:
 * 给定2个排序好的整数数组nums1和nums2，把nums2合并到nums1中成为1个排序的数组。
 * 提示：你可以假定nums1有足够的空间（大小>=m+n）来容纳来自nums2的额外的元素。nums1和nums2的元素的个数各自被初始化为m和n。
 */
public class MergeTwoSortArray {
    public static Integer[] merge(Integer[] nums1, int m, Integer[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (p2 < 0 || (p1 > 0 && nums1[p1] >= nums2[p2])) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        final Integer[] nums1 = Arrays.asList(0, 2, 3, 5, 10, 33).toArray(new Integer[13]);
        final Integer[] nums2 = Arrays.asList(1, 5, 13, 25, 30, 31, 100).toArray(new Integer[0]);
        final String allData = Arrays.toString(merge(nums1, 6, nums2, 7));
        System.out.println(allData);
    }
}
