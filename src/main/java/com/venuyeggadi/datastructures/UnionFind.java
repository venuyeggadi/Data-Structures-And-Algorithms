package com.venuyeggadi.datastructures;

/**
 * Given the vertices and edges between them, how could we quickly check whether two vertices are connected?
 * The primary use of disjoint sets is to address the connectivity between the components of a network.
 * The “network“ here can be a computer network or a social network. For instance, we can use a disjoint set
 * to determine if two people share a common ancestor.
 *
 * Used in
 *    Kruskal's minimum spanning tree algorith
 *    Grid percolation
 *    Network connectivity
 *    Lowest common ancestor in trees
 *    Image processing
 */

public interface UnionFind {
    int find(int vertex);
    boolean union(int vertex1, int vertex2);
    int componentSize(int v);
    int numberOfComponents();
    boolean connected(int vertex1, int vertex2);
}
