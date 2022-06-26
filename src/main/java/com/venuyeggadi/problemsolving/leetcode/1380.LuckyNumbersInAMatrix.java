package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 1380. Lucky Numbers in a Matrix
    Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
	A lucky number is an element of the matrix such that it is the minimum element in its row
	and maximum in its column.

  * Example 1:
	Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
	Output: [15]
	Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
	
  * Example 2:
	Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
	Output: [12]
	Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
	
  * Example 3:
	Input: matrix = [[7,8],[1,2]]
	Output: [7]
	Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.

  * Example 4:
	Input: matrix = [[3,6],[7,1],[5,2],[4,8]]
	Output: []
	Explanation: There is no lucky number.

  * Constraints:
	* m == mat.length
	* n == mat[i].length
	* 1 <= n, m <= 50
	* 1 <= matrix[i][j] <= 105.
	* All elements in the matrix are distinct.
*/


//#1
/*
Time: O(3*m*n) = O(m*n)
Space: O(m+n)
*/
class LuckyNumbersInAMatrixSolution1 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] minRow = new int[m];
        int[] maxCol = new int[n];
        
        for(int i = 0; i < m; i++)
            minRow[i] = minInRow(matrix[i]);
        for(int j = 0; j < n; j++)
            maxCol[j] = maxInCol(matrix, j);
        
        LinkedList<Integer> list = new LinkedList<>();
        for(int i : minRow)
            for(int j : maxCol)
                if(i == j)
                    list.add(i);
        
        return list;
    }
    
    static int minInRow(int[] row) {
        int min = row[0];
        for(int i : row)
            if(i < min)
                min = i;
        
        return min;
    }
    
    static int maxInCol(int[][] matrix, int j) {
        int max = matrix[0][j];
        for(int i = 0; i < matrix.length; i++)
            if(matrix[i][j] > max)
                max = matrix[i][j];
        
        return max;
    }
}

//#2
/*
Time: O(m*n + m*m) = O(max(m*n, m*m))
Space: O(1)
*/
class LuckyNumbersInAMatrixSolution2 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNums = new ArrayList<>();
        for(int[] row : matrix) {
            int minCol = 0;
            for(int j = 0; j < row.length; j++)
                if(row[j] < row[minCol])
                    minCol = j;
            
            int maxValueInCol = matrix[0][minCol];
            for(int i = 0; i < matrix.length; i++)
                maxValueInCol = Math.max(maxValueInCol, matrix[i][minCol]);
            
            if(row[minCol] == maxValueInCol)
                luckyNums.add(maxValueInCol);
        }
        
        return luckyNums;
    }
} 


//#3
/*
Time: O(m*n + m*m) = O(max(m*n, m*m))
Space: O(1)
*/
class LuckyNumbersInAMatrixSolution3 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for(int[] row : matrix) {
            int minCol = minCol(row);
            if(checkIfMax(matrix, minCol, row[minCol]))
                list.add(row[minCol]);
        }
        
        return list;
    }
    
    static int minCol(int[] arr) {
        int minCol = 0;
        for(int col = 1; col < arr.length; col++)
            if(arr[col] < arr[minCol])
                minCol = col;
        
        return minCol;
    }
    
    static boolean checkIfMax(int[][] matrix, int col, int value) {
        for(int row = 0; row < matrix.length; row++)
            if(matrix[row][col] > value)
                return false;
        
        return true;
    }
}