package com.venuyeggadi.algorithms.recursion;

import java.util.Arrays;

public class MaximumValueAndIndexInMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][] {
            new int[]{1, 2, 4, 3},
            new int[]{7, 8, 9, 10},
            new int[]{12, 15, 13, 11},
            new int[]{23, 16, 18, 17},
        };

        System.out.println(Arrays.toString(maxValue(mat)));
        System.out.println(Arrays.toString(maxValueV2(mat)));
    }

    public static int[] maxValue(int[][] mat) {
        return maxValueInner(mat, 0, 0);
    }

    private static int[] maxValueInner(int[][] mat, int row, int col) {
        if ((row == mat.length - 1) && (col == mat[0].length - 1))
            return new int[]{mat[row][col], row, col};

        int nextCol = col + 1, nextRow = row;
        if (nextCol == mat[0].length) {
            nextCol = 0;
            ++nextRow;
        }

        int[] nextMax = maxValueInner(mat, nextRow, nextCol);
        if (mat[row][col] > nextMax[0])
            return new int[]{mat[row][col], row, col};

        return nextMax;
    }

    public static int[] maxValueV2(int[][] mat) {
        return maxValueV2Inner(mat, 0, 0);
    }

    private static int[] maxValueV2Inner(int[][] mat, int row, int col) {
        if (row == mat.length)
            return null;
        if (col == mat[0].length)
            return maxValueV2Inner(mat, row + 1, 0);

        int[] nextMax = maxValueV2Inner(mat, row, col + 1);
        if (nextMax == null || mat[row][col] > nextMax[0])
            return new int[]{mat[row][col], row, col};

        return nextMax;
    }
}
