package com.venuyeggadi.problemsolving.leetcode;

/* A robot is located at the top-left corner of a m x n grid
   (marked 'Start' in the diagram below).
   The robot can only move either down or right at any point in time.
   The robot is trying to reach the bottom-right corner of the grid
   (marked 'Finish' in the diagram below).

   How many possible unique paths are there?

 * Example 1:
   Input: m = 3, n = 7
   Output: 28
 
 * Example 2:
   Input: m = 3, n = 2
   Output: 3
   Explanation:
   From the top-left corner, there are a total of 3 ways to reach the
   bottom-right corner:
   1. Right -> Down -> Down
   2. Down -> Down -> Right
   3. Down -> Right -> Down

 * Example 3:
   Input: m = 7, n = 3
   Output: 28
 
 * Example 4:
   Input: m = 3, n = 3
   Output: 6 

 * Constraints:
   * 1 <= m, n <= 100
   * It's guaranteed that the answer will be less than or equal to 2 * 109.

*/

import java.util.Arrays;


/**
 * Recursion / DFS  (Top-down approaches)
 * Intuition
 *      The total paths from cell(i, j) is the sum of the paths from the cell right to it and the cell left to it.
 *      i.e., uniquePaths(i, j+1) + uniquePaths(i+1, j).
 *
 * Time: O(2 ^ (m + n))
 * Space: O(m + n)
 *
 * Both these solutions are top-down
 */
// Way1 - How many paths lead to this point.
class UniquePathsSolution1Way1 {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}

// Way2 - How many paths emerge from this point
class UniquePathsSolution1Way2 {
    public int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n);
    }

    private int dfs(int i, int j, int m, int n) {
        if (i == m || j == n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;

        return dfs(i, j + 1, m, n) + dfs(i + 1, j, m, n);
    }
}



/**
 * Recursion + Memoization - (Dynamic Programming - Top-down)
 * Time: O(m * n)
 * Space: O(m * n)
 */
class UniquePathsSolution2  {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];

        return dfs(0, 0, m, n, memo);
    }

    private int dfs(int i, int j, int m, int n, int[][] memo) {
        if (i == m || j == n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;

        if (memo[i][j] != 0)
            return memo[i][j];

        memo[i][j]= dfs(i, j + 1, m, n, memo) + dfs(i + 1, j, m, n, memo);
        return memo[i][j];
    }
}


/**
 * Dynamic programming (bottom-up)
 *  Algorithm :
 *     * Traverse thought every cell and store the number of ways you can reach to
 *       that cell.
 *     * At the end target cell(bottom-right) contains the answer.
 * Time: O(m*n)
 * Space: O(m*n)
 */
class UniquePaths_Solution3 {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];

        for(int i = m-1; i >= 0; --i) {
            for(int j = n-1; j >= 0; --j) {
                if (i == m-1 || j == n-1)
                    paths[i][j] = 1;
                else
                    paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
            }
        }

        return paths[m - 1][n - 1];
    }
}

class UniquePaths_Solution3_Way1 {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m + 1][n + 1];
        paths[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1)
                    continue;
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m][n];
    }
}

class UniquePaths_Solution3_Way2 {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m + 1][n + 1];
        paths[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                paths[i][j] += paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m][n];
    }
}

class UniquePaths_Solution3_Way3 {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m + 1][n + 1];
        paths[m][n - 1] = 1;

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                paths[i][j] = paths[i][j+1] + paths[i+1][j];
            }
        }

        return paths[0][0];
    }
}

/**
 * Dynamic programming (bottom-up) - Space optimized
 *      Same as above using only one array of size n.
 *
 * Time: O(m*n)
 * Space: O(n) - Assuming that the locally initialized row array gets garbage collected for each iteration.
 */
class UniquePaths_Solution4 {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for (int i = 0; i < m - 1; i++) {
            int[] newRow = new int[n];
            newRow[0] = 1;

            for (int j = 1; j < n; j++) {
                newRow[j] = row[j] + newRow[j - 1];
            }

            row = newRow;
        }

        return row[n - 1];
    }
}

/**
 * Dynamic programming (bottom-up) - Space optimized (Optimal)
 *      Same as above using only one array of size n.
 *      Derived from Solution3_Way3
 * Time: O(m * n)
 * Space: O(n)
 */
class UniquePaths_Solution5 {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n + 1];
        row[n - 1] = 1;

        for (int r = m - 1; r >= 0; --r) {
            for (int c = n - 1; c >= 0; --c) {
                row[c] = row[c] + row[c + 1];
            }
        }

        return row[0];
    }
}


//#2
//O(m-1) or O(n-1), O(1)
/*
Intuition : Observe the below pattern.
   Input: m = 3, n = 2
   Output: 3
   Explanation:
   From the top-left corner, there are a total of 3 ways to reach the
   bottom-right corner:
   1. Right -> Down -> Down
   2. Down -> Down -> Right
   3. Down -> Right -> Down
   So here, it must take 2 (3-1 = 2) down steps and 1 (2-1 = 1) right steps.
   i.e., m-1 down steps and n-1 right steps in general.
   In total, we take m-1 + n-1 = m+n-2 steps.
   So from m+n-2 total steps we choose to take m-1 down steps so that remaining
   will be right steps. we can do this in (m+n-2)C(m-1) steps.
   (or)
   From m+n-2 total steps we choose to take n-1 right steps so that remaining
   will be down steps. we can do this in (m+n-2)C(n-1) steps.

   so the answer will be (m+n-2)C(m-1) or (m+n-2)C(n-1) which are equal since
   nCr = nC(n-r).
   Now the problem is to calculate nCr.
   nCr = n*(n-1)*...(n-(r-1))  /  r*(r-1)*(r-2)*....*2*1
       = n*(n-1)*...(n-r+1)  /  1*2*....*(r-2)*(r-1)*r
*/
class UniquePathsSolution5 {
    public int uniquePaths(int m, int n) {
        int N = m+n-2;
        int r = m-1; //or n-1
        if(N-r < r)
            r = N - r;//C(N, r) = C(N, N-r); C = combination
        long numerator = 1, denominator = 1;
        for(int i = 1; i <= r; i++) {
            numerator *= (N-i+1);
            denominator *= i;
            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return (int)(numerator/denominator);
    }
    
    static long gcd(long a, long b) {
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }
}
//Dividing by gcd on every step to avoid overflow problem in most of the time.
//It doesn't alter the result as however divide them at the end.