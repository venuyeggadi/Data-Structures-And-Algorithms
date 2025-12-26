package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 */

/**
 * Shortest path -> BFS
 * Need to mark the neighboring fresh oranges as rotten starting from each rotten orange at the same time.
 *
 * BFS - Multi source BFS
 * Time: O(m * n)
 * Space: O(m * n)
 */

class RottingOranges_Solution1 {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[] {r, c});
                }
            }
        }

        int time = -1; /** becomes 0 by the time it processes first rotten orange */
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int[] node = queue.poll();
                int r = node[0], c = node[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (Math.min(nr, nc) < 0 || nr == ROWS || nc == COLS
                            || grid[nr][nc] == 0 || grid[nr][nc] == 2) {  /** or grid[nr][nc] != 1 */
                        continue;
                    }

                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                }
            }

            ++time;
        }

        if (anyFreshOrange(grid))
            return -1;

        return time == -1 ? 0 : time;
    }

    private boolean anyFreshOrange(int[][] grid) {
        for (int[] arr : grid)
            for (int value : arr)
                if (value == 1)
                    return true;

        return false;
    }

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
}

class RottingOranges_Solution1_Way2Better {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    ++fresh;
            }
        }

        int minutes = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean neighborsRotted = false;
            for (int i = 0; i < size; ++i) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];
                for (int[] dir : directions) {
                    int r = row + dir[0], c = col + dir[1];
                    if (Math.min(r, c) < 0 || r == ROWS || c == COLS || grid[r][c] == 0 || grid[r][c] == 2)
                        continue;
                    grid[r][c] = 2;
                    queue.offer(new int[]{r, c});
                    --fresh;
                    neighborsRotted = true;
                }
            }
            if (neighborsRotted)
                ++minutes;
        }

        return fresh == 0 ? minutes : -1;
    }

    private static int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
}


class RottingOranges_Solution1_Way3Better {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int freshOranges = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1)
                    ++freshOranges;
                else if (grid[r][c] == 2)
                    queue.add(new int[] {r, c});
            }
        }

        int time = 0;
        while (!queue.isEmpty() && freshOranges > 0) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int[] node = queue.poll();
                int r = node[0], c = node[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (Math.min(nr, nc) < 0 || nr == ROWS || nc == COLS
                            || grid[nr][nc] == 0 || grid[nr][nc] == 2) { /** or grid[nr][nc] != 1 */
                        continue;
                    }

                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                    --freshOranges;
                }
            }

            ++time;
        }

        return freshOranges == 0 ? time : -1;
    }

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
}


// ToDo
// 1. Do not modify the data passed
// 2. Another solution with capturing the time every time a rotten orange is pushed to queue => (r, c, time) like other bfs leetcode 1091
