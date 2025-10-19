package com.venuyeggadi.algorithms.graphs;

public class CountPaths_Matrix_DFS {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0},
                        {1, 1, 0, 0},
                        {0, 0, 0, 1},
                        {0, 1, 0, 0}};

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        System.out.println(dfs(grid, 0, 0, visited));
    }

    /** Count paths (backtracking)
     *
     * Time: O(4 ^(m*n))
     * Space: (m * n)
     * */

    private static int dfs(int[][] grid, int r, int c, boolean[][] visited) {
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

        count += dfs(grid, r + 1, c, visited);
        count += dfs(grid, r - 1, c, visited);
        count += dfs(grid, r, c + 1, visited);
        count += dfs(grid, r, c - 1, visited);

        visited[r][c] = false; /** Because another path from a different cell can take the same cell route */

        return count;
    }
}
