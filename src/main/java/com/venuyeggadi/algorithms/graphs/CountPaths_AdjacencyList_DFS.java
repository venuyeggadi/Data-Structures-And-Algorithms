package com.venuyeggadi.algorithms.graphs;

import java.util.*;

public class CountPaths_AdjacencyList_DFS {


    /** Count paths (backtracking)
     * Time: O(n^v)
     *      where n -> average number of edges from each node
     *            v -> total number of edges
     * Space: O(v)
     *      - O(v) for visit set
     *      - O(v) for recursion stack at any point
     */
    public int dfs(HashMap<String, ArrayList<String>> adjList, String currentNode, String target, HashSet<String> visit) {
        if (visit.contains(currentNode))
            return 0;
        if (currentNode.equals(target))
            return 1;

        int count = 0;
        visit.add(currentNode);
        for (String neighbor: adjList.get(currentNode)) {
            count += dfs(adjList, target, neighbor, visit);
        }
        visit.remove(currentNode);

        return count;
    }
}


