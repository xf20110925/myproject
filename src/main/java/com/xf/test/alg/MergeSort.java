package com.xf.test.alg;

import java.util.Arrays;

/**
 * Created by xuefeng on 2018-9-1.
 * 归并排序
 */
public class MergeSort {

    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);

        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }

        for (k = start; k <= end; k++)
            arr[k] = result[k];

    }

    public static void main(String[] args) {
        final int[] array = {2, 3, 4, 1, 44, 22, 12, 50, 0, 6};
        merge_sort_recursive(array, new int[10], 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


}
