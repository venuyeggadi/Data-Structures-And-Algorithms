package com.venuyeggadi.problemsolving.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Leetcode 695
 */

/**
 * Traverse through each cell, if the cell is '1', take the area as 1 and take area from all its neighbors and mark them as visited,
   so that you don't count the cells belonging to the same island twice.
 * Marking all it's neighbors (cells that form and island) can be done using either dfs or bfs.
 */

/**
 * DFS
 * Time: O(m * n)
 * Space: O(m * n)
 */
class MaxAreaOfIsland_Solution1 {
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        int maxArea = 0;
        boolean[][] visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int area = dfs(grid, r, c, visited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (Math.min(r, c) < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0 || visited[r][c])
            return 0;

        visited[r][c] = true;
        int area = 1;

        area += dfs(grid, r + 1, c, visited);
        area += dfs(grid, r - 1, c, visited);
        area += dfs(grid, r, c + 1, visited);
        area += dfs(grid, r, c - 1, visited);

        return area;
    }
}


/**
 * BFS
 * Time: 2 * m * n => O(m * n)
 * Space: O(m * n)
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


class MaxAreaOfIsland_Solution2_Way2 {

    private static final int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        int maxArea = 0;
        boolean[][] visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    maxArea = Math.max(maxArea, bfs(grid, r, c, visited));
                }
            }
        }

        return maxArea;
    }

    private int bfs(int[][] grid, int row, int col, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int area = 0;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            area += 1;

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (Math.min(nr, nc) < 0 || nr == grid.length || nc == grid[0].length || grid[nr][nc] == 0 || visited[nr][nc]) {
                    continue;
                }
                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return area;
    }
}


/**
 * Disjoint Set (UnionFind) - Union By Size
 * Time: O(m * n)
 * Space: O(m * n)
 */
// ToDo
class MaxAreaOfIsland_Solution3 {
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        UnionFind uf = new UnionFind(ROWS * COLS);

        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                if (grid[i][j] == 0)
                    continue;
                int index = computeIndex(i, j, COLS);
                for (int[] dir : directions) {
                    int r = i + dir[0], c = j + dir[1];
                    if (r >= 0 && c >= 0 && r < ROWS && c < COLS && grid[r][c] == 1) {
                        int neighborIndex = computeIndex(r, c, COLS);
                        uf.union(index, neighborIndex);
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                if (grid[i][j] == 1)
                    max = Math.max(max, uf.size(computeIndex(i, j, COLS)));
            }
        }

        return max;
    }

    private int computeIndex(int r, int c, int COLS) {
        return r * COLS + c;
    }

    private static int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    private static class UnionFind {
        public int[] parent, size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int v) {
            while (v != parent[v]) {
                parent[v] = parent[parent[v]];
                v = parent[v];
            }

            return parent[v];
        }

        public boolean union(int v1, int v2) {
            int p1 = find(v1), p2 = find(v2);
            if (p1 == p2)
                return false;

            if (size[p1] > size[p2]) {
                parent[p2] = p1;
                size[p1] += size[p2];
            } else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }

            return true;
        }

        public int size(int v) {
            return size[parent[v]];
        }
    }
}