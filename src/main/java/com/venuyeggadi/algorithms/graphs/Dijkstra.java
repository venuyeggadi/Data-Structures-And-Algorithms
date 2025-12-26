package com.venuyeggadi.algorithms.graphs;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        List<int[]> edgeList = new ArrayList<>(List.of(
                new int[]{0, 1, 4},
                new int[]{0, 2, 1},
                new int[]{1, 3, 1},
                new int[]{2, 1, 2},
                new int[]{2, 3, 5},
                new int[]{3, 4, 3}
        ));
        int n = 5;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edgeList) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        int[] shortestPaths = shortestPaths(adj, 0);
        System.out.println(Arrays.toString(shortestPaths));



        int[][] edgeList1 = new int[][]
        {
            new int[]{0, 1, 4},
            new int[]{0, 2, 1},
            new int[]{1, 3, 1},
            new int[]{2, 1, 2},
            new int[]{2, 3, 5},
            new int[]{3, 4, 3}
        };

        System.out.println(shortestPaths1(edgeList1, 5, 0));
    }

    public static int[] shortestPaths(List<List<int[]>> adj, int sourceNode) {
        int n = adj.size();
        int[] distanceFromSource = new int[n];
        for (int i = 0; i < n; i++) {
            distanceFromSource[i] = Integer.MAX_VALUE;
        }
        distanceFromSource[sourceNode] = 0;

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[n];
        pq.offer(new int[]{sourceNode, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int node = edge[0], distance = edge[1];
            visited[node] = true;
            for (int[] neighbor : adj.get(node)) {
                int neighborNode = neighbor[0], neighborDistance = neighbor[1];
                if (visited[neighborNode])
                    continue;
                int distanceFromSourceToNeighbor = distanceFromSource[node] + neighborDistance;
                if (distanceFromSourceToNeighbor < distanceFromSource[neighborNode]) {
                    distanceFromSource[neighborNode] = distanceFromSourceToNeighbor;
                    pq.offer(new int[]{neighborNode, distanceFromSourceToNeighbor});
                }
            }
        }

        return distanceFromSource;
    }

    public static Map<Integer, Integer> shortestPaths1(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : times) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});
        Map<Integer, Integer> distances = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int node = edge[0], time = edge[1];
            if (distances.containsKey(node))
                continue;
            distances.put(node, time);
            for (int[] neighborEdge : adj.get(node)) {
                int neighbor = neighborEdge[0], neighborTime = neighborEdge[1];
                if (distances.containsKey(neighbor))
                    continue;
                pq.offer(new int[]{neighbor, time + neighborTime});
            }
        }

        return distances;
    }
}
