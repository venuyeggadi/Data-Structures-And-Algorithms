package com.venuyeggadi.problemsolving.leetcode;

import java.util.*;

/**
 * DFS
 * For each of the courses, see if all of its pre-requisites can be visited, without getting into a cycle.
 * Time: O(V + E)
 *      Running DFS (isCyclic) on each vertex -> V
 *      Each DFS call explores all its neighbors -> Total work across all adjacency lists = total number of edges = O(E).
 * Space: O(V + E)
 *      To represent in adjacency list format -> V + E
 *      visited set -> V
 *      recursion stack -> V at max at any point
 */

class CourseSchedule_Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : prerequisites) {
            int src = edge[0], dst = edge[1];
            if (adj.get(src) == null)
                adj.put(src, new ArrayList<>());
            if (adj.get(dst) == null)
                adj.put(dst, new ArrayList<>());
            adj.get(src).add(dst);
        }

        Set<Integer> nonCycles = new HashSet<>();
        for (Integer startNode : adj.keySet()) {
            Set<Integer> visited = new HashSet<>();
            if (isCyclic(adj, startNode, visited, nonCycles))
                return false;
        }

        return true;
    }

    private boolean isCyclic(Map<Integer, List<Integer>> adj, int startNode, Set<Integer> visited, Set<Integer> nonCycles) {
        if (nonCycles.contains(startNode))
            return false;
        if (visited.contains(startNode))
            return true;

        visited.add(startNode);
        for (Integer neighbor : adj.get(startNode)) {
            if (isCyclic(adj, neighbor, visited, nonCycles))
                return true;
            else nonCycles.add(neighbor);
        }
        visited.remove(startNode);

        return false;
    }
}

class CourseSchedule_Solution1Way2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < numCourses; i++)
            adj.put(i, new ArrayList<>());

        for (int[] edge : prerequisites) {
            int src = edge[0], dst = edge[1];
            adj.get(src).add(dst);
        }

        for (Integer startNode : adj.keySet()) {
            Set<Integer> visited = new HashSet<>();
            if (isCyclic(adj, startNode, visited))
                return false;
        }

        return true;
    }

    private boolean isCyclic(Map<Integer, List<Integer>> adj, int startNode, Set<Integer> visited) {
        if (adj.get(startNode).isEmpty())
            return false;
        if (visited.contains(startNode))
            return true;

        visited.add(startNode);
        for (Integer neighbor : adj.get(startNode)) {
            if (isCyclic(adj, neighbor, visited))
                return true;
            else adj.put(neighbor, new ArrayList<>());
        }
        visited.remove(startNode);

        return false;
    }
}


/**
 * Topological Sort (Kahn's Algorithm)
 * Time: O(V + E)
 * Space: O(V + E)
 */
class Solution_Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; ++i)
            adjList.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            adjList.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int v = 0; v < numCourses; ++v) {
            if (inDegree[v] == 0)
                queue.offer(v);
        }

        int finishedCourses = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ++finishedCourses;
            for (int nei : adjList.get(node)) {
                if (--inDegree[nei] == 0)
                    queue.offer(nei);
            }
        }

        return finishedCourses == numCourses;
    }
}
