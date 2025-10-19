package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1091. Shortest Path in Binary Matrix
 */

/**
 * BFS - visit layer by layer and increase the distance
 * Time: O(n^2)
 * Space: O(n^2)
 */
class ShortestPathInABinaryMatrix_Solution1 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;

        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1)
            return -1;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int pathLength = 1;

        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int[] node = queue.poll();
                int r = node[0], c = node[1];
                if (r == N - 1 && c == N - 1)
                    return pathLength;

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (Math.min(nr, nc) < 0 || nr == N || nc == N || grid[nr][nc] == 1 || visited[nr][nc])
                        continue;

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
            pathLength++;
        }

        return -1;
    }

    private static final int[][] directions = new int[][] {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };
}


/**
 * BFS - capturing the distance to that node while traversing itself
 */
class ShortestPathInABinaryMatrix_Solution2 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;

        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1)
            return -1;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0], c = node[1], pathLength = node[2];
            if (r == N - 1 && c == N - 1)
                return pathLength;

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (Math.min(nr, nc) < 0 || nr == N || nc == N || grid[nr][nc] == 1 || visited[nr][nc])
                    continue;

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc, pathLength + 1});
            }
        }

        return -1;
    }

    private static final int[][] directions = new int[][] {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };
}


/**
 * BFS - by modifying the grid itself to store the distance to that cells
 * This can used like a precalculated grid. You can get the shortest path to any cell once all the pre-calculation is done.
 */
class ShortestPathInABinaryMatrix_Solution3 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;

        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1)
            return -1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0], c = node[1];
            int distance = grid[r][c];
            if (r == N - 1 && c == N - 1)
                return distance;

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (Math.min(nr, nc) < 0 || nr == N || nc == N || grid[nr][nc] != 0)
                    continue;

                grid[nr][nc] = distance + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        return -1;
    }

    private static final int[][] directions = new int[][] {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };
}


