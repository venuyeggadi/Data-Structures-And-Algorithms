package com.venuyeggadi.problemsolving.leetcode;

class RedundantConnection_Solution1 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1]))
                return edge;
        }

        return new int[]{0, 0};
    }
}

class UnionFind {
    private int[] parentMap;
    private int[] rank;

    public UnionFind(int n) {
        parentMap = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parentMap[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int node) {
        int parent = node;
        while (parent != parentMap[parent]) {
            parentMap[parent] = parentMap[parentMap[parent]];
            parent = parentMap[parent];
        }
        return parent;
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);
        if (p1 == p2)
            return false;

        if (rank[p1] > rank[p2])
            parentMap[p2] = p1;
        else if (rank[p2] > rank[p1])
            parentMap[p1] = p2;
        else {
            parentMap[p2] = p1;
            rank[p1]++;
        }

        return true;
    }
}