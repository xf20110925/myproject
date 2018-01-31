package com.xf.test.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuefeng on 2018-1-10.
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
 * <p>
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 * <p>
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 * <p>
 * For example, given
 * <p>
 * A = [12, 28, 46, 32, 50]
 * B = [50, 12, 32, 46, 28]
 * We should return
 * [1, 4, 3, 2, 0]
 * as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
 * Note:
 * <p>
 * A, B have equal lengths in range [1, 100].
 * A[i], B[i] are integers in range [0, 10^5].
 */
public class ArrayMapping {

    public static void anagramMappings(int[] a, int[] b) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            final ArrayList<Integer> list = map.get(b[i]);
            if (list == null) {
                map.put(b[i], new ArrayList());
                map.get(b[i]).add(i);
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(map.get(a[i]));
        }
    }

    public static void main(String[] args) {
        anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28});
    }
}
