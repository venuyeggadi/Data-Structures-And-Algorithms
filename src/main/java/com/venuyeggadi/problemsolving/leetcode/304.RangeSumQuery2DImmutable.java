package com.venuyeggadi.problemsolving.leetcode;

/**
 * Time: O(m * n)
 * Space: O(1)
 */
class NumMatrix1 {
    int[][] matrix;

    public NumMatrix1(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
}


/**
 * Prefix sum for rows only
 * Time: pre-work => O(m * n) and O(n) for queries
 * Space: O(m * n))
 */
class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            prefixSum[i][0] = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                prefixSum[i][j] = matrix[i][j] + prefixSum[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += rangeSum(prefixSum[i], col1, col2);
        }
        return sum;
    }

    private int rangeSum(int[] prefixSum, int start, int end) {
        if (start == 0)
            return prefixSum[end];
        return prefixSum[end] - prefixSum[start - 1];
    }
}


/**
 * 2D prefix sum. Prefix sum array at any index (i, j) contains the sum of all elements in the square with corners (0, 0) and (i, j)
   So the sum of the elements in the square (row1, col1) and (row2, col2) can be obtained by subtracting the two squares formed above
   and left side of it. Here above is [(0, 0), (row1 - 1, col2)] and left is [(0, 0), (row2, col1 - 1)]. During this sum, the square
   [(0, 0), (row1 - 1, col1 - 1)] is getting subtracted twice. So it should be re-added once.

 * How to calculate the 2D prefix sum?
 * For any cell (i, j) of the prefix sum array,
    * (i, j-1) is the sum of the square [(0, 0), (i, j-1)] -> the square above it.
    * (i-1, j) is the sum of the square [(0, 0), (i-1, j)] -> the square left to it.
    * (i-1, j-1) is the sum of the square [(0, 0), (i-1, j-1)] - the square top-left corner to it.
 * So the sum of all the cells in square [(0, 0), (i, j)] is,
    * actualMatrix[i, j] + prefix[i, j-1] + prefix[i-1, j] - prefix[i-1, j-1]
    * Here are subtracting prefix[i-1, j-1] because it is added two times along with prefix[i, j-1] + prefix[i-1, j]

 * Time: pre-work => O(m * n) and O(1) for queries
 * Space: O((m + 1) * (n + 1)) => O(m * n)
 */
class NumMatrix2 {
    int[][] prefix;

    public NumMatrix2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        prefix = new int[m + 1][n + 1];

        for (int row = 1; row < m + 1; ++row) {
            for (int col = 1; col < n + 1; ++col) {
                prefix[row][col] = matrix[row - 1][col - 1]
                        + prefix[row][col - 1] + prefix[row - 1][col] - prefix[row - 1][col - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
    }
}
