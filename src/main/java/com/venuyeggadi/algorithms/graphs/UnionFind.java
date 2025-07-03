package com.venuyeggadi.algorithms.graphs;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    private Map<Integer, Integer> parentMap = new HashMap<>();
    private Map<Integer, Integer> rank = new HashMap<>();

    public UnionFind(int n) {
        for (int i = 1; i <= n; i++) {
            parentMap.put(i, i);
            rank.put(i, 0);
        }
    }

    public int find(int vertex) {
        int parent = parentMap.get(vertex);

        while (parent != parentMap.get(parent)) {
            parentMap.put(parent, parentMap.get(parentMap.get(parent))); // Path compression
            parent = parentMap.get(parent);
        }

        return vertex;
    }

    // (v1, v2) is an edge
    public boolean union(int v1, int v2) {
        int parent1 = parentMap.get(v1), parent2 = parentMap.get(v2);
        if (parent1 == parent2)
            return false;

        if (rank.get(parent1) > rank.get(parent2)) {
            parentMap.put(parent2, parent1);
        } else if (rank.get(parent2) > rank.get(parent1)) {
            parentMap.put(parent1, parent2);
        } else {
            parentMap.put(parent2, parent1);
            rank.put(parent1, rank.getOrDefault(parent1, 0) + 1);
        }

        return true;
    }
}
