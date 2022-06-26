package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 54. Spiral Matrix
    Given an m x n matrix, return all elements of the matrix in spiral order.

  * Example 1:
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,3,6,9,8,7,4,5]

  * Example 2:
    Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]

  * Constraints:
    * m == matrix.length
    * n == matrix[i].length
    * 1 <= m, n <= 10
    * -100 <= matrix[i][j] <= 100
*/


//#1
//O(m*n), O(1)
class SpiralMatrixSolution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int firstRow = 0;
        int lastColumn = n-1;
        int lastRow = m-1;
        int firstColumn = 0;
        List<Integer> ansList = new ArrayList<>(m*n);
        
        while(firstRow <= lastRow && firstColumn <= lastColumn) {
            for(int i = firstColumn; i <= lastColumn; i++)
                ansList.add(matrix[firstRow][i]);
            
            for(int i = firstRow+1; i <= lastRow; i++)
                ansList.add(matrix[i][lastColumn]);
            
            if(lastRow > firstRow) {
                for(int i = lastColumn-1; i >= firstColumn; i--)
                    ansList.add(matrix[lastRow][i]);
            }
            
            if(firstColumn < lastColumn) {
                for(int i = lastRow-1; i > firstRow; i--)
                    ansList.add(matrix[i][firstColumn]);
            }
            
            firstRow += 1;
            lastColumn -= 1;
            lastRow -= 1;
            firstColumn += 1;
        }
        
        return ansList;
    }
}
//same solution with single pointer
//O(m*n), O(1)
class SpiralMatrixSolution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ansList = new ArrayList<>(m*n);
        int totalLayers = (Math.min(m, n)+1)/2;
        
        for(int layer = 0; layer < totalLayers; layer++) {
            for(int i = layer; i < n-layer; i++)
                ansList.add(matrix[layer][i]);
            
            for(int i = layer+1; i < m-layer; i++)
                ansList.add(matrix[i][n-1-layer]);
            if(layer < m-1-layer) {
                for(int i = n-layer-2; i >= layer; i--)
                    ansList.add(matrix[m-1-layer][i]);
            }
            if(layer < n-1-layer) {
                for(int i = m-2-layer; i > layer; i--)
                    ansList.add(matrix[i][layer]);
            }
        }
        
        return ansList;
    }
}


//#2
/*  When traversing the matrix in the spiral order, at any time we follow one out of the
    following four directions: RIGHT DOWN LEFT UP. Suppose we are working on a 5 x 3 matrix as such:
    0 1 2 3 4 5
    6 7 8 9 10
    11 12 13 14 15
    Imagine a cursor starts off at (0, -1), i.e. the position at '0', then we can achieve the
    spiral order by doing the following:
    Go right 5 times
    Go down 2 times
    Go left 4 times
    Go up 1 times.
    Go right 3 times
    Go down 0 times -> quit
    Notice that the directions we choose always follow the order 'right->down->left->up',and for
    horizontal movements, the number of shifts follows:{5, 4, 3}, and vertical movements follows {2, 1, 0}.
    Thus, we can make use of a direction matrix that records the offset for all directions, then an array
    of two elements that stores the number of shifts for horizontal and vertical movements, respectively.
    This way, we really just need one for loop instead of four.
    Another good thing about this implementation is that: If later we decided to do spiral traversal on
    a different direction (e.g. Counterclockwise), then we only need to change the Direction matrix;
    the main loop does not need to be touched.
*/
class SpiralMatrixSolution3 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0)
            return res;
        int n = matrix[0].length;
        if(n == 0)
            return res;
        int[][] dirMatrix = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] range = {n, m-1};
        int dir = 0;           // index of dirMatrix, 0: right, 1: down, 2: left, 3: up
        int row = 0, col = -1; // initial position
        
        while(range[dir%2] != 0){
            for(int i = 0; i < range[dir%2]; i += 1){
                row += dirMatrix[dir][0];
                col += dirMatrix[dir][1];
                res.add(matrix[row][col]);
            }
            
            range[dir%2] -= 1;
            dir = (dir + 1) % 4;
        }
        
        return res;
        
    }
}