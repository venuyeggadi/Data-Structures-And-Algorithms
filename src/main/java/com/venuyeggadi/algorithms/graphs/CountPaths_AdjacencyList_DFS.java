package com.venuyeggadi.algorithms.graphs;

import java.sql.Array;
import java.util.*;

public class CountPaths_AdjacencyList_DFS {


    // Count paths (backtracking)
    public int dfs(HashMap<String, ArrayList<String>> adjList, String currentNode, String target, HashSet<String> visit) {
        if (visit.contains(currentNode))
            return 0;
        if (currentNode == target)
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


