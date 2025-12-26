package com.venuyeggadi.algorithms.graphs.minimum_spanning_trees;

import com.venuyeggadi.datastructures.UnionFind;
import com.venuyeggadi.datastructures.UnionFind_Rank;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskals {

    /**
     * Intuition:
     *      Pick the edges with less cost one by one and connect them. This can be done using sorting the edges based on
     *      their weight and then connecting them using UnionFind (Disjoint Set). When connecting the edges, only consider
     *      that edge to be part of the minimum spanning tree if the union operation is successful (Because we don't consider
     *      that which is connecting two vertices which are already connected, directly or indirectly in our tree already).
     *
     * Time:
     * Space:
     */

    /**
     * @param numberOfVertices Total number of nodes in the graph
     * @param weightedEdges Weighted edges in the form of (vertex1, vertex2, weight)
     * @return Minimum cost to form the tree
     * @Prints The edges of the minimum spanning tree
     */
    public static int minimumSpanningTree(int numberOfVertices, List<List<Integer>> weightedEdges) {
        weightedEdges.sort(Comparator.comparingInt(e -> e.get(2)));

        UnionFind uf = new UnionFind_Rank(numberOfVertices);

        /**
         * We can get both the cost to form the minimum spanning tree and the edges of the tree itself by tracking them
         * in a list.
         * Here we're only tracking the cost.
         *
         * We can traverse through the edges until all of them exhaust OR we can just traverse until the required number of
         * edges (n-1 to form a tree) are found.
         */

        int edgesCombined = 0;
        int cost = 0;
        int i = 0;
        while (edgesCombined < numberOfVertices - 1) {  // Because only n - 1 edges are need to form a tree with n nodes
            List<Integer> edge = weightedEdges.get(i);
            if (uf.union(edge.get(0), edge.get(1))) {
                ++edgesCombined;
                cost += edge.get(2);
            }
            i++;
        }

        return cost;
    }
}
