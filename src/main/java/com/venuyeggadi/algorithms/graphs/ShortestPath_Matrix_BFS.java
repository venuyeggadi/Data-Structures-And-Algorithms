package com.venuyeggadi.algorithms.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ShortestPath_Matrix_BFS {

    public static void main(String[] args) {
        int[][] grid =
                {{0, 0, 0, 0},
                 {1, 1, 0, 0},
                 {0, 0, 0, 1},
                 {0, 1, 0, 0}};

        System.out.println(bfs(grid, 0, 0));
    }

    /** Shortest path from top left to bottom right */
    /**
     * Time: O(m * n)
     * Space: O(m * n)
     */
    public static int bfs(int[][] grid, int row, int col) {
        int ROWS = grid.length, COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{row, col});
        visited[row][col] = true;
        int length = 0;

        while (!queue.isEmpty()) {
            int queueLength = queue.size();

            for (int i = 0; i < queueLength; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                for (int[] dir : directions) {
                    int newR = r + dir[0], newC = c + dir[1];
                    if (Math.min(newR, newC) < 0 || newR == ROWS || newC == COLS
                            || grid[newR][newC] == 1 || visited[newR][newC]) {
                        continue;
                    }
                    queue.add(new int[]{newR, newC});
                    visited[newR][newC] = true;
                }
            }

            length++;
        }

        return length; /** This should/will never be called **/
    }

    private static final int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
}