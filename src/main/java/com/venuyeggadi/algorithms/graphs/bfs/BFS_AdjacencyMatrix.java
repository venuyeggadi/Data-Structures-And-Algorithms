package com.venuyeggadi.algorithms.graphs.bfs;

import java.util.*;


/**
 * Start with a vertex. Visit it. Start exploring all it's neighbors immediately.
 */
public class BFS_AdjacencyMatrix {

    public static void main(String[] args) {
        /** matrix of size (n + 1) x (n + 1) for n vertices. Row 0 and column 0 are not used. **/
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
    }

    /**
     * Time: O(v^2)
     *      As we visit the entire matrix
     *      v -> for visited array
     *
     * where
     *      v -> number of vertices
     */
    public static void bfs(int[][] adjMatrix, int startingVertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visitedVertices = new int[adjMatrix.length]; /** or an array of boolean **/

        queue.offer(startingVertex);
        visitedVertices[startingVertex] = 1;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " "); /** or process it after adding the node to queue and marking as visited **/
            for (int col = 1; col < adjMatrix[0].length; col++) {
                if (adjMatrix[vertex][col] == 1 && visitedVertices[col] == 0) {
                    queue.offer(col);
                    visitedVertices[col] = 1;
                }
            }
        }
    }
}
