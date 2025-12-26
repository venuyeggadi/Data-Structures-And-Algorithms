package com.venuyeggadi.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListFromEdges {
    public static void main(String[] args) {
        String[][] edges = new String[][] {{"A", "B"}, {"B", "C"}, {"B", "E"}, {"C", "E"}, {"E", "D"}};

        Map<String, List<String>> adjacencyList = buildAdjacencyList(edges);

        System.out.println(adjacencyList);
    }

    private static Map<String, List<String>> buildAdjacencyList(String[][] edges) {
        Map<String, List<String>> adjacencyList = new HashMap<>();

        for (String[] edge : edges) {
            String s = edge[0], d = edge[1];
            adjacencyList.putIfAbsent(s, new ArrayList<>());
            adjacencyList.putIfAbsent(d, new ArrayList<>());

            adjacencyList.get(s).add(d);
            adjacencyList.get(d).add(s); /** if the graph is undirected */
        }

        return adjacencyList;
    }
}
