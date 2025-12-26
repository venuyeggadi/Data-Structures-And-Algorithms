package com.venuyeggadi.algorithms.graphs;


/**
 * Count the unique paths from top-left to the bottom-right. A single path may only move along 0's and can't visit
 * the same cell more than once.
 */
public class CountPaths_Matrix_DFS {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0},
                        {1, 1, 0, 0},
                        {0, 0, 0, 1},
                        {0, 1, 0, 0}};

        System.out.println(dfs(grid));
    }

    /** Count paths (backtracking)
     *
     * Time: O(4^(m*n))
     *      thinking in terms of tree with 4 nodes from each node and maximum height as m * n
     * Space: (m * n)
     *      - (m * n) for visited array
     *      - (m * n) for recursion stack at any point
     * */
    private static int dfs(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfsInner(grid, 0, 0, visited);
    }

    private static int dfsInner(int[][] grid, int r, int c, boolean[][] visited) {
        int ROWS = grid.length, COLS = grid[0].length;

        if (Math.min(r, c) < 0 || r == ROWS || c == COLS ||
                visited[r][c] || grid[r][c] == 1 ) {
            return 0;
        }

        if (r == ROWS - 1 && c == COLS - 1) {
            return 1;
        }

        visited[r][c] = true;
        int count = 0;

        count += dfsInner(grid, r + 1, c, visited);
        count += dfsInner(grid, r - 1, c, visited);
        count += dfsInner(grid, r, c + 1, visited);
        count += dfsInner(grid, r, c - 1, visited);

        visited[r][c] = false; /** Because another path from a different cell can take the same cell route */

        return count;
    }
}
