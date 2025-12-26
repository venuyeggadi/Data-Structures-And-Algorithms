package com.venuyeggadi.algorithms.graphs.dfs;

public class DFS_AdjacencyMatrix {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = new int[][]
                {
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 0, 0},
                        {0, 0, 1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0},
                };
        dfs(adjacencyMatrix);
        System.out.println();
    }

    /**
     * Time: O(v^2)
     *      As we visit the entire matrix
     *      v -> for visited array
     *
     * where
     *      v -> number of vertices
     */
    public static void dfs(int[][] adjacencyMatrix) {
        int[] visitedVertices = new int[adjacencyMatrix.length];
        dfs(adjacencyMatrix, 1, visitedVertices); // start vertex can be anything, it will explore all vertices.
    }

    private static void dfs(int[][] adjacencyMatrix, int startVertex, int[] visitedVertices) {
        if (visitedVertices[startVertex] == 1)
            return;
        System.out.print(startVertex + " ");
        visitedVertices[startVertex] = 1;
        for (int col = 1; col < adjacencyMatrix[0].length; col++) {
            if (adjacencyMatrix[startVertex][col] == 1 && visitedVertices[col] == 0) {
                dfs(adjacencyMatrix, col, visitedVertices);
            }
        }
    }
}
