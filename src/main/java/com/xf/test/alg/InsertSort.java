package com.xf.test.alg;


/**
 * Created by xuefeng on 2017/8/7.
 */
public class InsertSort {
    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int k = array[i];
            while (j >= 0 && k < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = k;
        }
        return array;

    }

    public static void main(String[] args) {
        final int[] ints = insertSort(new int[]{1, 22, 3, 55, 12, 0, 21});
        for (final int anInt : ints) {
            System.out.print(anInt + "\t");
        }
    }
}
