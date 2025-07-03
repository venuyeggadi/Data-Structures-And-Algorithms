package com.venuyeggadi.algorithms.graphs;

import java.util.*;

public class BFS {

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
        bfs(adjacencyMatrix, 4);
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
        bfs(adjacencyList, 4);
    }

    // Adjacency matrix
    public static void bfs(int[][] adjMatrix, int startingVertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visitedVertices = new int[adjMatrix.length];

        queue.offer(startingVertex);
        visitedVertices[startingVertex] = 1;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int col = 1; col < adjMatrix[0].length; col++) {
                if (adjMatrix[vertex][col] == 1 && visitedVertices[col] == 0) {
                    queue.offer(col);
                    visitedVertices[col] = 1;
                }
            }
        }
    }

    // Adjacency list
    private static void bfs(List<List<Integer>> adjacencyList, int startingVertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visitedVertices = new int[adjacencyList.size()];

        queue.offer(startingVertex);
        visitedVertices[startingVertex] = 1;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int v : adjacencyList.get(vertex)) {
                if (visitedVertices[v] == 0) {
                    queue.offer(v);
                    visitedVertices[v] = 1;
                }
            }
        }
    }
}
