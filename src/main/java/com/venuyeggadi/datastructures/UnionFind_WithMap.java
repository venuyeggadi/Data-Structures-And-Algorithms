package com.venuyeggadi.datastructures;

import java.util.HashMap;
import java.util.Map;

public class UnionFind_WithMap {

    private Map<Integer, Integer> parentMap = new HashMap<>();
    private Map<Integer, Integer> rank = new HashMap<>();

    public UnionFind_WithMap(int n) {
        for (int i = 1; i <= n; i++) {
            parentMap.put(i, i);
            rank.put(i, 0);
        }
    }

    /**
     * find : Recursive version (for interviews)
     * Paths compression in this case sets the parents of all the node in the path to the top most top parent.
     * i.e., it flattens the tree.
     * | Measure                                        | Explanation                                                                        |
     * | ---------------------------------------------- | ---------------------------------------------------------------------------------- |
     * | Worst-case (no compression)                    | `O(n)` — only if the tree degenerates into a chain and no path compression yet     |
     * | With path compression + union by rank/size     | Amortized O(α(n))                                                                  |
     * | Practical behavior                             | Effectively **constant time**, ≈ O(1) per operation                                |
     * |--------------------------------------------------------------------------------------------------------------------------------------
     * α(n) -> inverse Ackermann function — grows slower than log⁎(n), practically ≤ 4 for any real input size
     */
    public int findV1_Recursive(int v) {
        if (parentMap.get(v) != v)
            parentMap.put(v, findV1_Recursive(parentMap.get(v)));
        return parentMap.get(v);
    }

    public int findV1_Iterative(int v) {
        // find the root node
        int root = v;
        while (root != parentMap.get(root)) {
            root = parentMap.get(root);
        }

        // set every node's parent along the path to root node
        while (parentMap.get(v) != root) {
            int parent = parentMap.get(v);
            parentMap.put(v, root);
            v = parent;
        }

        return root;
    }

    /**
     * Path compression by path halving - widely used in real life to avoid risky recursive solutions
     * Path compression in this case reduces the length of that particular path each time by half.
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






