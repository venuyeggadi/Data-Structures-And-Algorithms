/**
 * In MATLAB, there is a handy function called reshape which can reshape an
   m x n matrix into a new one with a different size r x c keeping its original data.
   You are given an m x n matrix mat and two integers r and c representing the row number
   and column number of the wanted reshaped matrix. The reshaped matrix should be filled
   with all the elements of the original matrix in the same row-traversing order as they were.
   If the reshape operation with given parameters is possible and legal,
   output the new reshaped matrix; Otherwise, output the original matrix.

 * Example 1:
   Input: mat = [[1,2],[3,4]], r = 1, c = 4
   Output: [[1,2,3,4]]

 * Example 2:
   Input: mat = [[1,2],[3,4]], r = 2, c = 4
   Output: [[1,2],[3,4]]
 */


//#1
//O(r*c), O(r*c)
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length != r*c)
            return mat;
        int[] whole = new int[r*c];
        int k = 0;
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[i].length; j++)
                whole[k++] = mat[i][j];
        int[][] result = new int[r][c];
        k = 0;
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                result[i][j] = whole[k++];
        return result;
    }
}



//#2
//O(r*c), O(r*c)
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if(m*n != r*c)
            return mat;
        int[][] result = new int[r][c];
        int total = m*n, i = 0, j = 0, new_i = 0, new_j = 0;
        while(total-- > 0) {
            result[new_i][new_j] = mat[i][j]; 
            j++;
            new_j++;
            if(j == n) {
                i++;
                j = 0;
            }
            if(new_j == c) {
                new_i++;
                new_j = 0;
            }
        }
        return result;
    }
}


//same as #2 but clean
//O(r*c, r*c)
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if(m*n != r*c)
            return mat;
        int[][] res = new int[r][c];
        int newI = 0, newJ = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[newI][newJ] = mat[i][j];
                newJ++;
                if(newJ == c) {
                    newI++;
                    newJ = 0;
                }
            }
        }
        
        return res;
    }
}



//#3
// O(r*c), O(r*c);
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if(m*n != r*c)
            return mat;
        int[][] result = new int[r][c];
        int total = m*n;
        for(int i = 0; i < total; i++)
            result[i/c][i%c] = mat[i/n][i%n];
        
        return result;
    }
}