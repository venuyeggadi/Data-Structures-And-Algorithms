package com.venuyeggadi.problemsolving.leetcode;

/**
 * Recursion
 * Same as Unique Paths I problem.
 *
 * Time: O(2^ (m + n))
 * Space: O(m + n)
 */
class UniquePathsII_Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePaths(0, 0, obstacleGrid);
    }

    private int uniquePaths(int row, int col, int[][] obstacleGrid) {
        if (row == obstacleGrid.length || col == obstacleGrid[0].length)
            return 0;
        if (obstacleGrid[row][col] == 1)
            return 0;
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1)
            return 1;

        return uniquePaths(row, col + 1, obstacleGrid) + uniquePaths(row + 1, col, obstacleGrid);
    }
}


/**
 * Recursion + Memoization (Dynamic programming - Top-down)
 *
 * Time: O(m * n)
 * Space: O(m * n)
 */
class UniquePathsII_Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];

        return uniquePaths(0, 0, obstacleGrid, memo);
    }

    private int uniquePaths(int row, int col, int[][] obstacleGrid, int[][] memo) {
        if (row == obstacleGrid.length || col == obstacleGrid[0].length)
            return 0;
        if (obstacleGrid[row][col] == 1)
            return 0;
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1)
            return 1;
        if (memo[row][col] != 0)
            return memo[row][col];

        memo[row][col] = uniquePaths(row, col + 1, obstacleGrid, memo) + uniquePaths(row + 1, col, obstacleGrid, memo);

        return memo[row][col];
    }
}

/**
 * Dynamic programming - Bottom-up
 *
 * Time: O(m * n)
 * Space: O(m * n)
 */
class UniquePathsII_Solution3 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n-1] = 1;

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0; /** number of paths from an obstacle cell are 0 */
                else
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }

        return dp[0][0];
    }
}


/**
 * Dynamic programming - Bottom-up (Space optimized)
 *
 * Time: O(m * n)
 * Space: O(n)
 */
class UniquePathsII_Solution4 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] prevRow = new int[n];
        for (int c = n - 1; c >= 0; --c) {
            if (obstacleGrid[m - 1][c] == 0)
                prevRow[c] = 1;
            else
                break;
        }

        for (int r = m - 2; r >= 0; --r) {
            int[] currRow = new int[n];
            if (obstacleGrid[r][n - 1] == 0 && prevRow[n - 1] == 1)
                currRow[n - 1] = 1;
            for (int c = n - 2; c >= 0; --c) {
                if (obstacleGrid[r][c] == 1)
                    currRow[c] = 0;
                else
                    currRow[c] = currRow[c + 1] + prevRow[c];
            }

            prevRow = currRow;
        }

        return prevRow[0];
    }
}

/**
 * Dynamic programming - Bottom-up (Space optimized) - Optimal
 *      Derived from solution 3
 * Time: O(m * n)
 * Space: O(n)
 */
class UniquePathsII_Solution5 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] row = new int[n + 1]; /** extra row */
        row[n - 1] = 1;

        for (int r = m - 1; r >= 0; --r) {
            for (int c = n - 1; c >= 0; --c) {
                if (obstacleGrid[r][c] == 1)
                    row[c] = 0;
                else
                    row[c] = row[c] + row[c + 1];
            }
        }

        return row[0];
    }
}


/**
 * Dynamic programming - Bottom-up (In-place)
 *
 * Not recommended
 *
 * Time: O(m * n)
 * Space: O(1)
 */
class UniquePathsII_Solution6 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] row = new int[n + 1]; /** extra row */
        row[n - 1] = 1;

        for (int r = m - 1; r >= 0; --r) {
            for (int c = n - 1; c >= 0; --c) {
                if (obstacleGrid[r][c] == 1)
                    row[c] = 0;
                else
                    row[c] = row[c] + row[c + 1];
            }
        }

        return row[0];
    }
}