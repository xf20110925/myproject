package com.xf.test.alg;


/**
 * Created by xuefeng on 2017/8/7.
 */
public class InsertSort {
    public static int[] insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {

            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]){
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
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
