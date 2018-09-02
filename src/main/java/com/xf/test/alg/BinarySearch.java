package com.xf.test.alg;

/**
 * Created by xuefeng on 2018-9-2.
 */
public class BinarySearch {

    public static int search(int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] < target) {
                start = mid + 1;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int searchRecursion(int[] array, int target, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (array[mid] == target)
            return mid;
        else if (array[mid] < target)
            return searchRecursion(array, target, mid + 1, end);
        else
            return searchRecursion(array, target, start, mid - 1);

    }

    public static void main(String[] args) {
        final int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(arr, 4, 0, arr.length - 1));
        System.out.println(searchRecursion(arr, 4, 0, arr.length - 1));
    }

}
