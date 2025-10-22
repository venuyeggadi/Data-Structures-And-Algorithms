package com.venuyeggadi.datastructures;

public interface UnionFind {
    int find(int vertex);
    boolean union(int vertex1, int vertex2);
    int componentSize(int v);
    int numberOfComponents();
    boolean connected(int vertex1, int vertex2);
}
