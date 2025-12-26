package com.venuyeggadi.algorithms.graphs.bfs;

import java.util.*;


/**
 * Start with a vertex. Visit it. Start exploring all it's neighbors immediately.
 */
public class BFS_AdjacencyList {

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
        bfs(adjacencyList, 4);
    }

    /**
     * We should mark the vertex as visited immediately after visiting it, not after adding it to queue and then accessing it.
     *
     * Time: O(v + e) or (n + e)
     *      As we visit each vertex and then visit (iterate) all of its neighbors.
     * Space: O(v)
     *      v -> for queue
     *      v -> for visited array
     *
     * where
     *      v or n -> number of vertices
     *      e -> number of edges
     */
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
