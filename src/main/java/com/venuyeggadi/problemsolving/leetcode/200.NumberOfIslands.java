package com.venuyeggadi.problemsolving.leetcode;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * DFS
 * Time:
 * Space:
 */
class NumberOfIslands_Solution1 {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    ++count;
                    dfs(grid, row, column);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0
                || r == grid.length || c == grid[0].length
                || grid[r][c] == '0')
            return;

        grid[r][c] = '0';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}


/**
 * BFS:
 * Time:
 * Space:
 */
class NumberOfIslands_Solution2 {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    ++count;
                    bfs(grid, row, column);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int row, int column) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{ row, column });

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0], c = node[1];
            if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == '0')
                continue;
            grid[r][c] = '0';
            queue.add(new int[]{r - 1, c});
            queue.add(new int[]{r + 1, c});
            queue.add(new int[]{r, c - 1});
            queue.add(new int[]{r, c + 1});
        }
    }
}