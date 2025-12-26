package com.venuyeggadi.problemsolving.leetcode;

import java.util.*;

/**
 * Kruskal's Algorithm
 *
 */
class MinCostToConnectAllPoints_Solution1 {
    public int minCostConnectPoints(int[][] points) {
        List<List<Integer>> weightedEdges = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int weight = manhattanDistance(points[i], points[j]);
                List<Integer> edge = new ArrayList<>();
                edge.add(i);
                edge.add(j);
                edge.add(weight);
                weightedEdges.add(edge);
            }
        }

        Collections.sort(weightedEdges, Comparator.comparingInt(e -> e.get(2)));
        // weightedEdges.sort(Comparator.comparingInt(e -> e.get(2)));
        // weightedEdges.sort((e1, e2) -> Integer.compare(e1.get(2), e2.get(2)));

        UnionFind uf = new UnionFind(points.length);

        int edgesCombined = 0;
        int cost = 0;
        int i = 0;
        while (edgesCombined < points.length - 1) {
            List<Integer> edge = weightedEdges.get(i);
            if (uf.union(edge.get(0), edge.get(1))) {
                ++edgesCombined;
                cost += edge.get(2);
            }
            i++;
        }

        /** OR
         * Just union all the edges and count only when union is successful,
         * doesn't change the result because already connected nodes won't be connected again
         */

        return cost;
    }

    private int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
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

            if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            } else if (rank[p2] < rank[p1]) {
                parent[p2] = p1;
            } else {
                parent[p2] = p1;
                ++rank[p1];
            }

            return true;
        }
    }
}


/**
 * Prim's Algorithm
 *
 */
class MinCostToConnectAllPoints_Solution2 {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < points.length; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int weight = manhattanDistance(points[i], points[j]);
                adj.get(i).add(new int[]{j, weight});
                adj.get(j).add(new int[]{i, weight});
            }
        }

        int cost = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[points.length];
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int node = edge[0], weight = edge[1];
            if (visited[node])
                continue;
            visited[node] = true;
            cost += weight;
            for (int[] neighbor : adj.get(node)) {
                if (visited[neighbor[0]])
                    continue;
                pq.add(neighbor);
            }
        }

        return cost;
    }

    private int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}


/**
 * Prim's Algorithm (Optimal)
 *
 */
class MinCostToConnectAllPoints_Solution3 {
}
