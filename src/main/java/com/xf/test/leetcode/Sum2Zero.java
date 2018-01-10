package com.xf.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * http://blog.csdn.net/lnho2015/article/details/51314133
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * <p>
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 翻译：
 * 给定一个数组S，它包含n个整数，它是否存在3个元素a，b，c，满足a+b+c=0?找出所有满足条件的元素数组。
 * 提示：a，b，c三个元素必须是升序排列（也就是满足a ≤ b ≤ c），最终的结果不能包含重复的元素数组。例如给定S为{-1 0 1 2 -1 -4}，返回结果是(-1, 0, 1)和(-1, -1, 2)。
 */
public class Sum2Zero {

    public static void findZeroArray1(int[] arrays) {
        Arrays.sort(arrays);
        for (int i = 0; i < arrays.length - 2; i++) {
            //结果去重
            if (i > 0 && arrays[i] == arrays[i - 1])
                continue;
            for (int j = i + 1; j < arrays.length - 1; j++) {
                for (int k = j + 1; k < arrays.length; k++) {
                    if (arrays[i] + arrays[j] + arrays[k] > 0)
                        continue;
                    if (arrays[i] + arrays[j] + arrays[k] == 0) {
                        System.out.println(Arrays.toString(new int[]{arrays[i], arrays[j], arrays[k]}));
                    }

                }
            }
        }
    }

    public static void findZeroArray2(int[] arrays) {
        Arrays.sort(arrays);
        //优化第三层循环
        final Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arrays.length; i++) {
            if (map.get(arrays[i]) == null) {
                map.put(arrays[i], new ArrayList<>());
                map.get(arrays[i]).add(i);
            } else {
                map.get(arrays[i]).add(i);
            }
        }
        for (int i = 0; i < arrays.length - 2; i++) {
            if (arrays[i] > 0)
                continue;
            //结果去重
            if (i > 0 && arrays[i] == arrays[i - 1])
                continue;
            for (int j = i + 1; j < arrays.length - 1; j++) {
                if (arrays[i] + arrays[j] > 0)
                    continue;
                int mistake = 0 - arrays[i] - arrays[j];
                if (map.get(mistake) != null) {
                    if (mistake >= arrays[j])
                        System.out.println(Arrays.toString(new int[]{arrays[i], arrays[j], mistake}));
                }
            }
        }
    }

    public static void main(String[] args) {
        findZeroArray1(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("**********输出分隔*************");
        findZeroArray2(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
