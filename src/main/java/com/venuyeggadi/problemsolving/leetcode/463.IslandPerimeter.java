package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * DFS
 * Time: O(m * n)
 * Space: O(m * n)
 */
class IslandPerimeter_Solution1 {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int r = 0, c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    r = i; c = j;
                    break;
                }
            }
        }

        return dfs(grid, r, c, visited);
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (visited[row][col])
            return 0;

        visited[row][col] = true;
        int perimeter = 0;
        for (int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (Math.min(r, c) < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
                ++perimeter;
            else
                perimeter += dfs(grid, r, c, visited);
        }

        return perimeter;
    }

    private static final int[][] directions = new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
}

class IslandPerimeter_Solution1Way2 {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int r = 0, c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    r = i; c = j;
                    break;
                }
            }
        }

        return dfs(grid, r, c, visited);
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (Math.min(row, col) < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0)
            return 1;
        if (visited[row][col])
            return 0;

        visited[row][col] = true;
        int perimeter = 0;
        for (int[] dir : directions) {
            perimeter += dfs(grid, row + dir[0], col + dir[1], visited);
        }

        return perimeter;
    }

    private static final int[][] directions = new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
}


/**
 * BFS
 * Time: O(m * n)
 * Space: O(m * n)
 */
class IslandPerimeter_Solution2 {
    public int islandPerimeter(int[][] grid) {
        int r = 0, c = 0, ROWS = grid.length, COLS = grid[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    r = i; c = j;
                    break;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        int perimeter = 0;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : directions) {
                int row = cell[0] + dir[0], col = cell[1] + dir[1];
                if (Math.min(row, col) < 0 || row == ROWS || col == COLS || grid[row][col] == 0)
                    ++perimeter;
                else if (visited[row][col])
                    continue;
                else {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }

        return perimeter;
    }

    private static final int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
}


/**
 * Iteration 1
 * Time: O(m * n)
 * Space: O(1)
 */
class IslandPerimeter_Solution3 {
    public int islandPerimeter(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0)
                    continue;
                for (int[] dir : directions) {
                    int r = i + dir[0], c = j + dir[1];
                    if (Math.min(r, c) < 0 || r == ROWS || c == COLS || grid[r][c] == 0)
                        ++perimeter;
                }
            }
        }

        return perimeter;
    }

    private final int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
}


/**
 * Iteration 2
 *      Consider 4 as perimeter for each cell with value 1. And if the cell is not in first row or first column and has a 1 valued cell
 *      above it or left side of it, subtract 2 (Because it doesn't come under perimeter and it's added 2 times as part of the these two cell.
 * Time: O(m * n)
 * Space: O(1)
 */
class IslandPerimeter_Solution4 {
    public int islandPerimeter(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int perimeter = 0;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 0)
                    continue;
                perimeter += 4;
                if (row > 0 && grid[row - 1][col] == 1)
                    perimeter -= 2;
                if (col > 0 && grid[row][col - 1] == 1)
                    perimeter -= 2;
            }
        }

        return perimeter;
    }
}


