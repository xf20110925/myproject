package com.xf.test.leetcode.easy.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/reshape-the-matrix/description/
 * <p>
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * <p>
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * <p>
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * <p>
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * <p>
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 * [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * Note:
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 */
public class ReshapetheMatrix {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length)
            return nums;
        final LinkedList<Integer> queue = new LinkedList<>();
        for (final int[] numArray : nums) {
            for (final int i : numArray) {
                queue.add(i);
            }

        }
        final int[][] newArray = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newArray[i][j] = queue.poll();
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        final int[][] ints = matrixReshape(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, 1, 4);
        for (final int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
