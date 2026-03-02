package com.venuyeggadi.problemsolving.leetcode;


/**
 * Bruteforce - Linear search
 *
 * Time: O(m * n)
 * Space: O(1)
 */


/**
 * Staircase Search
 *
 * Time: O(m + n)
 * Space: O(1)
 */
class SearchA2DMatrix_Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int row = 0;
        while (row < m && target > matrix[row][n - 1])
            ++row;

        if (row >= m)
            return false;

        int col = n - 1;
        while (col >= 0 && target < matrix[row][col])
            --col;

        if (col < 0)
            return false;

        return matrix[row][col] == target;
    }
}

class SearchA2DMatrix_Solution2_Way2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;

        while (row < m && col >= 0) {
            if (target > matrix[row][col])
                ++row;
            else if (target < matrix[row][col])
                --col;
            else
                return true;
        }

        return false;
    }
}

/**
 * Binary Search - Two pass
 * Find the array first and then searching for the element in that array
 *
 * Time: O(log m + log n) => O(log m * n)
 * Space: O(1)
 */
class SearchA2DMatrix_Solution3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchRow(matrix, target);

        if (rowIndex == -1)
            return false;

        return binarySearch(matrix[rowIndex], target);
    }

    private int binarySearchRow(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        int rowLength = matrix[0].length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target >= matrix[mid][0]  && target <= matrix[mid][rowLength])
                return mid;
            else if (target < matrix[mid][0])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }

    private boolean binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid])
                return true;
            else if (target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return false;
    }
}


/**
 * Binary search - One pass
 * Directly searching for the element
 *
 * Time: O(log (m * n))
 * Space: O(1)
 */
class SearchA2DMatrix_Solution4 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / n, col = mid % n;

            if (matrix[row][col] == target)
                return true;
            if (target < matrix[row][col])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return false;
    }
}
