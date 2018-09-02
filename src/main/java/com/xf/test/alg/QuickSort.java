package com.xf.test.alg;

import java.util.Arrays;

/**
 * Created by xuefeng on 2018-9-2.
 * 快速排序
 */
public class QuickSort {

    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }

        int l = head, r = tail, pivot = arr[(head + tail) / 2];

        while (l <= r) {
            while (arr[l] < pivot) {
                ++l;
            }
            while (arr[r] > pivot) {
                --r;
            }
            if (l < r) {
                swap(arr, l, r);
                ++l;
                --r;
            } else if (l == r){
                ++l;
            }
        }

        qSort(arr, head, r);
        qSort(arr, l, tail);
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        qSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
