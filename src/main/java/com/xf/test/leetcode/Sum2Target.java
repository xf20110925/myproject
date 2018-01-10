package com.xf.test.leetcode;

import java.util.*;

/**
 * Created by xuefeng on 2018-1-10.
 * 翻译：
 * 给定一个整形数组和一个整数target，返回2个元素的下标，它们满足相加的和为target。
 * 你可以假定每个输入，都会恰好有一个满足条件的返回结果。
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Sum2Target {

    //O(n*n)
    public static int[] returnIndex1(int target, int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    //O(n)
    public static int[] returnIndex2(int target, int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int mistake = target - arr[i];
            if (map.get(mistake) != null) {
                return new int[]{i, map.get(mistake)};
            } else {
                //map 存放数组值、下标的k,v值
                map.put(arr[i], i);
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        final int[] ret = returnIndex1(9, new int[]{2, 7, 11, 15});
        System.out.println(Arrays.toString(ret));
        final int[] ret1 = returnIndex2(9, new int[]{2, 7, 11, 15});
        System.out.println(Arrays.toString(ret1));
    }
}
