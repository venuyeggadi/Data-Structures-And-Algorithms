package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * DFS
 * Time: O(m * n)
 * Space:
 */
class MaxAreaOfIsland_Solution1 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    max = Math.max(max, dfs(grid, row, col));
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0)
            return 0;

        grid[row][col] = 0;

        int up = dfs(grid, row - 1, col);
        int down = dfs(grid, row + 1, col);
        int left = dfs(grid, row, col - 1);
        int right = dfs(grid, row, col + 1);

        return 1 + up + down + left + right;
    }
}


/**
 * BFS
 * Time:
 * Space:
 */
class MaxAreaOfIsland_Solution2 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    max = Math.max(max, bfs(grid, row, col));
                }
            }
        }

        return max;
    }

    private int bfs(int[][] grid, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});

        int sum = 0;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0], c = node[1];
            if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0)
                continue;

            sum += 1;
            grid[r][c] = 0;
            queue.offer(new int[] { r - 1, c });
            queue.offer(new int[] { r + 1, c });
            queue.offer(new int[] { r, c - 1 });
            queue.offer(new int[] { r, c + 1 });
        }

        return sum;
    }
}


