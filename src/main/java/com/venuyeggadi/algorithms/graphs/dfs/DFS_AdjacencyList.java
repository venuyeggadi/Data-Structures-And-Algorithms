package com.venuyeggadi.algorithms.graphs.dfs;

import java.util.Arrays;
import java.util.List;

public class DFS_AdjacencyList {
    public static void main(String[] args) {
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

    public static void dfs(List<List<Integer>> adjacencyList) {
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
