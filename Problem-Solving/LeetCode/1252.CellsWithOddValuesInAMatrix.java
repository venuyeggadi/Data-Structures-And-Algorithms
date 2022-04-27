/** 1252. Cells with Odd Values in a Matrix
    There is an m x n matrix that is initialized to all 0's. There is also a 2D array
    indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform
    some increment operations on the matrix.
    For each location indices[i], do both of the following:
    Increment all the cells on row ri.
    Increment all the cells on column ci.
    Given m, n, and indices, return the number of odd-valued cells in the matrix after
    applying the increment to all locations in indices.

  * Example 1:
    Input: m = 2, n = 3, indices = [[0,1],[1,1]]
    Output: 6
    Explanation: Initial matrix = [[0,0,0],[0,0,0]].
	After applying first increment it becomes [[1,2,1],[0,1,0]].
	The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
	
  * Example 2:
	Input: m = 2, n = 2, indices = [[1,1],[0,0]]
	Output: 0
	Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
	
  * Constraints:
	* 1 <= m, n <= 50
	* 1 <= indices.length <= 100
	* 0 <= ri < m
	* 0 <= ci < n
	
	Follow up: Could you solve this in O(n + m + indices.length) time with only O(n + m) extra space?
*/

//#1 
/* Time complexity: O(indices.length*(m+n) + m*n)
   Space complexity: O(m*n)
*/
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        
        for(int[] index : indices) {
            for(int col = 0; col < n; col++)
                arr[index[0]][col]++;
            for(int row = 0; row < m; row++)
                arr[row][index[1]]++;
        }
        
        int count = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if((arr[i][j]&1) == 1)
                    count++;
        
        return count;
    }
}


//#2
/*
Time: O(indices.length + (m*n))
Space : O(m+n)
*/
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] columns = new int[n];
        
        for(int[] index : indices) {
            rows[index[0]]++;
            columns[index[1]]++;
        }
        
        int count = 0;
        for(int r : rows)
            for(int c : columns)
                count += (r+c)%2;
        
        return count;
    }
}


//#3
/*
Time: O(indices.length+ m + n)
Space: O(m+n)
*/
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] columns = new int[n];
        
        for(int[] index : indices) {
            rows[index[0]]++;
            columns[index[1]]++;
        }
        
        int r = 0;
        for(int i : rows)
            r += i%2;
        
        int c = 0;
        for(int j : columns)
            c += j%2;
        
        return r*n + c*m - 2*r*c;
    }
}


//#4
/*
Time: O(indices.length + m + n)
Space: O(m + n) //but better than #3 in memory because of boolean arrays
*/
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] rows = new boolean[m];
        boolean[] columns = new boolean[n];
        
        for(int[] index : indices) {
            rows[index[0]] = !rows[index[0]]; //or rows[index[0]] ^= true;
            columns[index[1]] = !columns[index[1]]; //or columns[index[1]] ^= true;
        }
        
        int r = 0;
        for(boolean i : rows)
            r += i?1:0;
        
        int c = 0;
        for(boolean j : columns)
            c += j?1:0;
        
        return r*n + c*m - 2*r*c;
    }
}