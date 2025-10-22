package com.venuyeggadi.datastructures;


public class UnionFind_Size implements UnionFind {
    private final int[] parent;
    private final int[] size;
    private int numberOfComponents;

    public UnionFind_Size(int n) {
        numberOfComponents = n;

        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int v) {
        if (v != parent[v])
            parent[v] = find(parent[v]);
        return parent[v];
    }

    public boolean union(int v1, int v2) {
        int p1 = find(v1), p2 = find(v2);
        if (p1 == p2)
            return false;

        if (size[p1] > size[p2]) {
            parent[p2] = p1;
            size[p1] += size[p2];
        } else {
            parent[p1] = p2;
            size[p2] += size[p1];
        }

        --numberOfComponents; // since two different components are merged

        return true;
    }

    public int componentSize(int v) {
        int root = find(v);
        return size[root];
    }

    public int numberOfComponents() {
        return numberOfComponents;
    }

    public boolean connected(int vertex1, int vertex2) {
        int parent1 = find(vertex1), parent2 = find(vertex2);
        return parent1 == parent2;
    }
}
