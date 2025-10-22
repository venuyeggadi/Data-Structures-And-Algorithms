package com.venuyeggadi.datastructures;


public class UnionFind_Rank implements UnionFind {
    private final int[] parent;
    private final int[] rank;
    private int numberOfComponents;

    public UnionFind_Rank(int n) {
        numberOfComponents = n;

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int v) {
        return findV1_Recursive(v);
        //return findV1_Iterative();
        //return findV2_PathHalving();
        //return findV3_Bruteforce();
    }

    public boolean union(int v1, int v2) {
        int p1 = find(v1), p2 = find(v2);
        if (p1 == p2)
            return false;

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else if (rank[p2] > rank[p1]) {
            parent[p1] = p2;
        } else {
            parent[p1] = p2;
            ++rank[p2];
        }

        --numberOfComponents; // since two different components are merged

        return true;
    }

    public int componentSize(int v) {
        int size = 0;
        int root = find(v);
        for (int i = 0; i < parent.length; i++) {
            if (find(i) == root)
                ++size;
        }

        return size;
    }

    public int numberOfComponents() {
        return numberOfComponents;
    }

    public boolean connected(int vertex1, int vertex2) {
        int parent1 = find(vertex1), parent2 = find(vertex2);
        return parent1 == parent2;
    }


    // Sets everything along the path to root node. Reduces the length of the path to 1.
    private int findV1_Recursive(int v) {
        if (v != parent[v])
            parent[v] = findV1_Recursive(parent[v]);
        return parent[v];
    }

    // Sets everything along the path to root node. Reduces the length of the path to 1.
    private int findV1_Iterative(int v) {
        // find the root node
        int root = v;
        while (root != parent[root]) {
            root = parent[root];
        }

        // set every node's parent along the path to root node
        while (parent[v] != root) {
            int p = parent[v];
            parent[v] = root;
            v = p;
        }

        return root;
    }

    // Path compression in this case reduces the length of that particular path each time by half.
    private int findV2_PathHalving(int v) {
        while (v != parent[v]) {
            parent[v] = parent[parent[v]]; // Path compression
            v = parent[v];
        }

        return v;
    }

    // No path compression.
    private int findV3_Bruteforce(int v) {
        while (v != parent[v]) {
            v = parent[v];
        }

        return v;
    }
}
