package com.venuyeggadi.algorithms.graphs.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopologicalSort {
    public static void main(String[] args) {
        List<List<Integer>> adjList = Arrays.asList(
                List.of(1, 2),
                List.of(3),
                List.of(4),
                List.of(5),
                List.of(5),
                List.of(),
                List.of(7),
                List.of()
        );

        System.out.println(topSort(adjList, 8));
    }

    /**
     * Time: O(V + E)
     * Space: O(V)
     */
    public static List<Integer> topSort(List<List<Integer>> adjList, int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int v = 0; v < n; ++v) {
            dfs(v, adjList, list, visited);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; --i) {
            result.add(list.get(i));
        }

        return result;
    }

    private static void dfs(int v, List<List<Integer>> adjList, List<Integer> list, boolean[] visited) {
        if (visited[v])
            return;

        visited[v] = true;

        for (int nei : adjList.get(v)) {
            dfs(nei, adjList, list, visited);
        }

        list.add(v);
    }
}
