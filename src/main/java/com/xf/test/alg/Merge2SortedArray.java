package com.xf.test.alg;

import java.util.Arrays;

/**
 * Created by xuefeng on 2018-9-1.
 */
public class Merge2SortedArray {
    public static int[] merge(int[] sortedArray1, int[] sortedArray2) {
        int i = 0;
        int j = 0;
        int allLength = sortedArray1.length + sortedArray2.length;
        final int[] ints = new int[allLength];
        int step = 0;
        while (i < sortedArray1.length && j < sortedArray2.length) {
            if (sortedArray1[i] < sortedArray2[j]) {
                ints[step++] = sortedArray1[i];
                i++;
            } else if (sortedArray1[i] >= sortedArray2[j]) {
                ints[step++] = sortedArray2[j];
                j++;
            }

        }

        while (i < sortedArray1.length) {
            ints[step++] = sortedArray1[i];
            i++;
        }

        while (j < sortedArray2.length) {
            ints[step++] = sortedArray2[j];
            j++;
        }
        return ints;
    }

    public static void main(String[] args) {
        final int[] ret = merge(new int[]{1, 2, 31}, new int[]{0, 3, 6});
        System.out.println(Arrays.toString(ret));
    }
}
