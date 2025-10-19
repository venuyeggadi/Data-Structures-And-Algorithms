package com.venuyeggadi.algorithms.graphs;

import java.util.*;

public class ShortestPath_AdjacencyList_BFS {

    // Shortest path from node to target.
    public int bfs( HashMap<String, List<String>> adjList, String node, String target) {
        Queue<String> q = new ArrayDeque<>();
        HashSet<String> visit = new HashSet<>();
        q.add(node);
        visit.add(node);

        int length = 0;

        while (!q.isEmpty()) {
            int queueLength = q.size();
            for (int i = 0; i < queueLength; i++) {
                String curr = q.poll();
                if (curr.equals(target))
                    return length;

                for (String neighbor : adjList.get(curr)) {
                    if (!visit.contains(neighbor)) {
                        q.add(neighbor);
                        visit.add(neighbor);
                    }
                }
            }
            length++;
        }

        return length;
    }
}
