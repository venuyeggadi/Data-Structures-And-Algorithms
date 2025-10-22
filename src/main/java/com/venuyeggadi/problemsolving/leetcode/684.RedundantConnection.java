package com.venuyeggadi.problemsolving.leetcode;


/**
 * In the problem, it is explicitly given that the number of nodes are equal n, which is same as the number of edges.
 * We know this for a fact that a tree with n nodes will have exactly n - 1 edges. Since they introduced another edge
 * to form a cycle, number of nodes = number of edges = n.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * DFS - Cycle detection
 *      Gradually build an adjacency list by adding one edge at a time. After adding each edge, check if adding that edge
 *      resulted in a cycle in the graph. If yes, that edge is the edge to be removed to make the graph a tree.
 *
 * Time: O(E * (V + E))
 *      E => number of edges
 *      V + E => Time taken for dfs function
 * Space: O(V + E)
 *      V + 2 * E for the adjacency list
 *      V for the visited array
 *      at max V for the recursion stack at ant point
 */
class RedundantConnection_Solution1 {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(edges.length + 1);
        for (int i = 0; i <= edges.length; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            adj.get(src).add(dest);
            adj.get(dest).add(src);

            if (dfs(adj, src, -1, new boolean[edges.length + 1]))
                return new int[]{src, dest};
        }

        return new int[]{};
    }

    // dfs -> cycle exists in the graph?
    private boolean dfs(List<List<Integer>> adj, int node, int parent, boolean[] visited) {
        if (visited[node])
            return true;

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent)
                continue;
            if (dfs(adj, neighbor, node, visited))
                return true;
        }

        return false;
    }
}


/**
 * DFS - Reachability
 *      Gradually build an adjacency list by adding one edge at a time. ** Before ** adding each edge, check if a path
 *      already exists between the nodes of that edge. If a path already exists, adding this edge is going to result in
 *      a cycle, so this edge is the answer.
 *
 * Time: O(E * (V + E))
 *      E => number of edges
 *      V + E => Time taken for dfs function
 * Space: O(V + E)
 *      V + 2 * E for the adjacency list
 *      V for the visited array
 *      at max V for the recursion stack at ant point
 */
class RedundantConnection_Solution1Way2_Better {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(edges.length + 1);
        for (int i = 0; i <= edges.length; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            if (dfs(adj, src, dest, new boolean[edges.length + 1]))
                return new int[]{src, dest};

            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }

        return new int[]{};
    }

    //dfs -> Reachability (path exists from src to dest ?)
    private boolean dfs(List<List<Integer>> adj, int src, int dest, boolean[] visited) {
        if (src == dest)
            return true;

        visited[src] = true;

        for (int neighbor : adj.get(src)) {
            if (visited[neighbor])
                continue;
            if (dfs(adj, neighbor, dest, visited))
                return true;
        }

        return false;
    }
}

/**
 * BFS - Reachability
 *      Gradually build an adjacency list by adding one edge at a time. ** Before ** adding each edge, check if a path
 *      already exists between the nodes of that edge. If a path already exists, adding this edge is going to result in
 *      a cycle, so this edge is the answer.
 *
 * Time: O(E * (V + E))
 *      E => number of edges
 *      V + E => Time taken for bfs function
 * Space: O(V + E)
 *      V + 2 * E for the adjacency list
 *      V for the visited array and
 *      at max V for the queue at any point
 */
class RedundantConnection_Solution2 {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(edges.length + 1);
        for (int i = 0; i <= edges.length; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1];
            if (bfs(adj, src, dest))
                return new int[]{src, dest};

            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }

        return new int[]{};
    }

    private boolean bfs(List<List<Integer>> adj, int src, int dest) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[adj.size() + 1];
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == dest)
                return true;
            for (int neighbor : adj.get(node)) {
                if (visited[neighbor])
                    continue;
                queue.offer(neighbor);
                visited[neighbor] = true;
            }
        }

        return false;
    }
}


/**
 * DFS (Optimal)
 * Time complexity: O(V+E)
 * Space complexity: O(V+E)
 */
class RedundantConnection_Solution3 {
}


/**
 * Topological Sort (Kahn's Algorithm)
 * Time complexity: O(V+E)
 * Space complexity: O(V+E)
 */
class RedundantConnection_Solution4 {

}


/**
 * When solving with UnionFind, as we are adding the edges one by one gradually, the edge that forms a cycle is
 * the last edge forms a cycle. Because after that, there can not be another edge that can form a cycle because it would only
 * mean that an edge is duplicated which isn't true in case of this problem (all the edges are unique).
 */
class RedundantConnection_Solution5 {
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
    private final int[] parentMap;
    private final int[] rank;

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