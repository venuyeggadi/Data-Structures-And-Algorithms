package com.venuyeggadi.algorithms.graphs;

import java.util.Arrays;
import java.util.List;

public class DFS {
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


        List<List<Integer>> adjacencyList = Arrays.asList(
                null,
                Arrays.asList(2, 3),
                Arrays.asList(1, 4),
                Arrays.asList(1, 4),
                Arrays.asList(2, 3, 5, 6),
                Arrays.asList(4),
                Arrays.asList(4)
        );
        dfs(adjacencyList);
    }

    private static void dfs(int[][] adjacencyMatrix) {
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

    private static void dfs(List<List<Integer>> adjacencyList) {
        int[] visitedVertices = new int[adjacencyList.size()];
        dfs(adjacencyList, 1, visitedVertices);
    }

    private static void dfs(List<List<Integer>> adjacencyList, int startVertex, int[] visitedVertices) {
        if (visitedVertices[startVertex] == 1)
            return;
        System.out.print(startVertex + " ");
        visitedVertices[startVertex] = 1;
        for (int v : adjacencyList.get(startVertex)) {
            if (visitedVertices[v] == 0) {
                dfs(adjacencyList, v, visitedVertices);
            }
        }
    }
}
