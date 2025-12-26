package com.venuyeggadi.algorithms.graphs.topologicalsort;

import java.util.*;

public class TopologicalSort_Kahns {
    public static void main(String[] args) {
        List<List<Integer>> adjList = Arrays.asList(
                List.of(1, 2),
                List.of(3),
                List.of(4),
                List.of(5),
                List.of(5),
                List.of(),
                List.of(7),
                List.of()
        );

        System.out.println(topSort(adjList, 8));
    }

    /**
     * Time: O(V + E)
     *      E -> to compute the in-degree for all vertices
     *      V -> to find vertices with in-degree 0.
     *      V + E -> process all the vertices and their edges one by one
     * Space: O(V)
     *      V -> for in-degree array
     *      V -> at max for queue
     */
    public static List<Integer> topSort(List<List<Integer>> adjList, int n) {
        List<Integer> list = new ArrayList<>();
        int[] inDegree = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();

        for (List<Integer> adj : adjList) {
            for (int v : adj) {
                inDegree[v]++;
            }
        }

        for (int v = 0; v < n; ++v) {
            if (inDegree[v] == 0)
                queue.offer(v);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);
            for (int nei : adjList.get(node)) {
                if (--inDegree[nei] == 0)
                    queue.offer(nei);
            }
        }

        if (list.size() != n) /** Cycle detected. Cannot form a topological order.*/
            return null;

        return list;
    }
}
