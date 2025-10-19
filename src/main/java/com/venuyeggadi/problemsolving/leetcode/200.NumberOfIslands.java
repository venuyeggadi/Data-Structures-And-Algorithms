package com.venuyeggadi.problemsolving.leetcode;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Leetcode 200
 */

/**
 * Traverse through each cell, if the cell is '1', increase the count of islands and marks all it's neighbors as visited,
   so that you don't count the cells belonging to the same island twice.
 * Marking all it's neighbors (cells that form and island) can be done using either dfs or bfs.
 */

/**
 * DFS
 * Time: O(m * n)
 *      In the worst case, all cells might be '1'. So the first iteration would mark all the cells as visited and would take time
 *      of (m * n). Rest of the iterations (m * n - 1) would take time 1. So total of 1 * m * n + (m * n - 1) * 1 => 2 * m * n
 *
 * Space: O(m * n)
 *      space by visited array => m * n
 *      space by call stack at any point of time => m * n
 */
class NumberOfIslands_Solution1 {
    public int numIslands(char[][] grid) {
        int result = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    result += 1;
                    dfs(grid, r, c, visited);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (Math.min(row, col) < 0 || row == grid.length || col == grid[0].length || grid[row][col] == '0' || visited[row][col])
            return;

        visited[row][col] = true;

        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
    }
}


/**
 * BFS
 * Time: O(m * n)
 * Space: O(m * n)
 *      Space by visited array => m * n
 *      Space by queue at max => m * n
 */
class NumberOfIslands_Solution2 {

    private static final int[][] directions = {{1, 0}, {-1, 0},
            {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int result = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    bfs(grid, r, c, visited);
                    result += 1;
                }
            }
        }

        return result;
    }

    private void bfs(char[][] grid, int row, int col, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] dir : directions) {
                int newR = r + dir[0], newC = c + dir[1];
                if (newR < 0 || newC < 0 || newR == grid.length ||
                        newC == grid[0].length || grid[newR][newC] == '0' || visited[newR][newC]) {
                    continue;
                }
                queue.offer(new int[]{newR, newC});
                visited[newR][newC] = true;
            }
        }
    }
}


/**
 * Disjoint Set (UnionFind)
 * Time: O(m * n)
 * Space: O(m * n)
 */
// ToDo
class NumberOfIslands_Solution3 {

}