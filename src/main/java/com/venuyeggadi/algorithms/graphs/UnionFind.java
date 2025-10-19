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

    /**
     * find : Recursive version (for interviews)
     * Paths compression in this case sets the parents of all the node in the path to the top most most parent.
     * i.e., it flattens the tree.
     * | Measure                                        | Explanation                                                                        |
     * | ---------------------------------------------- | ---------------------------------------------------------------------------------- |
     * | Worst-case (no compression)                    | `O(n)` — only if the tree degenerates into a chain and no path compression yet     |
     * | With path compression + union by rank/size     | Amortized O(α(n))                                                                  |
     * | Practical behavior                             | Effectively **constant time**, ≈ O(1) per operation                                |
     * |--------------------------------------------------------------------------------------------------------------------------------------
     * α(n) -> inverse Ackermann function — grows slower than log⁎(n), practically ≤ 4 for any real input size
     */
    public int findRec(int x) {
        if (parentMap.get(x) != x)
            parentMap.put(x, findRec(parentMap.get(x)));
        return parentMap.get(x);
    }

    /**
     *
     * | Measure                      | Explanation                                   |
     * | ---------------------------- | --------------------------------------------- |
     * | Worst-case (first few ops)   | O(log n) – before paths are flattened         |
     * | Amortized                    | O(α(n)) — same as recursive version           |
     * | Practical                    | ≈ O(1) per operation after a few unions/finds |
     */
    public int find(int vertex) {
        while (vertex != parentMap.get(vertex)) {
            parentMap.put(vertex, parentMap.get(parentMap.get(vertex))); // Path compression
            vertex = parentMap.get(vertex);
        }

        return vertex;
    }

    /**
     * Time: time taken for find operations
     * But time taken for find operations also again depends on whether union is done by rank or not.
     */
    public boolean union(int v1, int v2) {
        int parent1 = find(v1), parent2 = find(v2);
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
