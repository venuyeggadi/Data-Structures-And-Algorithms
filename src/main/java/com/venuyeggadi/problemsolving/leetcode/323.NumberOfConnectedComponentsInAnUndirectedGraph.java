package com.venuyeggadi.problemsolving.leetcode;

import java.util.*;

/**
 * DFS
 * Intuition:
 *      Go through each node and see if we're visiting this node for the first time. If so, we can mark itself and
 *      all its neighbors as visited and increment the count of the components by 1.
 *
 *
 * Time: V + E
 *      V -> best case when all the nodes are disconnected because dfs will take only O(1)
 *      (V + E) + V -> when all the node are connected in single component
 *          the first dfs will visit all the nodes and their edges taking total of V + E time,
 *          subsequent V dfs calls will only take O(1) as all of them would've been visited already.
 *
 *  Space: V + E
 *      V + 2 * E -> For adjacency list
 *      V -> visited array
 *      V -> at max at any point for the recursion stack.
 */

class NumberOfConnectedComponentsInAnUndirectedGraph_Solution1 {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dfs(adj, i, visited))
                ++count;
        }

        return count;
    }

    /**
     * bfs -> is it an unvisited node?
     */
    private boolean dfs(List<List<Integer>> adj, int node, boolean[] visited) {
        if (visited[node])
            return false;
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            dfs(adj, neighbor, visited);
        }

        return true;
    }
}


/**
 * BFS
 *
 * Time: V + E
 *      V -> best case when all the nodes are disconnected because bfs will take only O(1)
 *      (V + E) + V -> when all the node are connected in single component
 *          the first bfs will visit all the nodes and their edges taking total of V + E time,
 *          subsequent V dfs calls will only take O(1) as all of them would've been visited already.
 *
 * Space: V + E
 *      V + 2 * E -> For adjacency list
 *      V -> visited array
 *      V -> at max at any point for the queue
 */
class NumberOfConnectedComponentsInAnUndirectedGraph_Solution2 {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (bfs(adj, i, visited))
                ++count;
        }

        return count;
    }

    /**
     * bfs -> is it an unvisited node?
     */
    private boolean bfs(List<List<Integer>> adj, int node, boolean[] visited) {
        if (visited[node])
            return false;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int neighbor : adj.get(n)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return true;
    }
}


/**
 * Union Find - Disjoint Set
 * Intuition:
 *      We can build the Disjoint Set/ Union Find structure with all the edges given. The nodes are now grouped.
 *      Now find the parents of all the nodes and count the unique ones.
 *
 * Time: V + (V + E) * a(V) => (V + E) * a(V)
 *      V + E * a(V) for forming the disjoint set
 *      V * a(V) for finding the parent of each node
 *
 * Space: V
 *      V -> Disjoint Set
 *      V -> for the parents HashSet
 *
 * V - vertices
 * E - Edges
 */
class NumberOfConnectedComponentsInAnUndirectedGraph_Solution3 {
    public int countComponents(int n, int[][] edges) {
        UnionFind_323 uf = new UnionFind_323(n);

        for (int[] edge : edges)
            uf.union(edge[0], edge[1]);

        Set<Integer> parents = new HashSet<>();
        for (int i = 0; i < n; i++)
            parents.add(uf.find(i));

        return parents.size();
    }
}


/**
 * Disjoint Set - UnionFind
 * Intuition:
 *       When we initialize the disjoint set, evey node will have itself as the parent. So we have n number of components.
 *       As we gradually connect the nodes, every successful connection will reduce the number of components by 1 because
 *       two different components have become one.
 *
 * Time: V + E * a(V) for forming the disjoint set
 *
 * Space: V for the Disjoint Set
 *
 * V - vertices
 * E - Edges
 */
class NumberOfConnectedComponentsInAnUndirectedGraph_Solution4 {
    public int countComponents(int n, int[][] edges) {
        UnionFind_323 uf = new UnionFind_323(n);

        int count = n;
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1]))
                --count;
        }

        return count;
    }
}

class UnionFind_323 {
    private int[] parent;
    private int[] rank;

    public UnionFind_323(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int v) {
        while (v != parent[v]) {
            parent[v] = parent[parent[v]];
            v = parent[v];
        }

        return v;
    }

    public boolean union(int v1, int v2) {
        int p1 = find(v1), p2 = find(v2);
        if (p1 == p2)
            return false;

        if (rank[p1] > rank[p2])
            parent[p2] = p1;
        else if (rank[p2] > rank[p1])
            parent[p1] = p2;
        else {
            parent[p2] = p1;
            ++rank[p1];
        }

        return true;
    }
}