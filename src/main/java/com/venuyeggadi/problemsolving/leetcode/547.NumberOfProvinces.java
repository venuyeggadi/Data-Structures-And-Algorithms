package com.venuyeggadi.problemsolving.leetcode;


/**
 * DFS
 */
class NumberOfProvinces_Solution2 {
}


/**
 * BFS
 */
class NumberOfProvinces_Solution1 {
}


/**
 * UnionFind - Disjoint Set
 */
class NumberOfProvinces_Solution3 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1)
                    uf.union(i, j);
            }
        }

        return uf.components();
    }

    private static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int numberOfComponents;

        public UnionFind(int n) {
            numberOfComponents = n;
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

            if (rank[p1] < rank[p2])
                parent[p1] = p2;
            else if (rank[p2] < rank[p1])
                parent[p2] = p1;
            else {
                parent[p2] = p1;
                ++rank[p1];
            }

            --numberOfComponents;

            return true;
        }

        public int components() {
            return numberOfComponents;
        }
    }
}
