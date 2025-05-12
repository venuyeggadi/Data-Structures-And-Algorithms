package com.venuyeggadi.problemsolving.leetcode;


/**
 * Time: O(log m + log n) => O(log m * n)
 * Space: O(1)
 */
class SearchA2DMatrix_Solution1 {
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
