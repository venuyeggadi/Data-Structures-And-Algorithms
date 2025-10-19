package com.venuyeggadi.problemsolving.leetcode;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


/**
 * DFS
 * Time: O(V+E)
 * Space: O(V)
 */
class CloneGraph_Solution1Way1 {
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> result = new HashMap();
        Set<String> visited = new HashSet<>();

        dfs(node, visited, result);

        return result.getOrDefault(1, null);
    }

    private void dfs(Node node, Set<String> visited, HashMap<Integer, Node> result) {
        if (node == null)
            return;

        if (!result.containsKey(node.val))
            result.put(node.val, new Node(node.val, new ArrayList<Node>()));

        Node copy = result.get(node.val);

        for (Node neighbor : node.neighbors) {
            if (!result.containsKey(neighbor.val))
                result.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));

            if (!visited.contains(edgeToString(node.val, neighbor.val))) {
                copy.neighbors.add(result.get(neighbor.val));
                visited.add(edgeToString(node.val, neighbor.val));
                dfs(neighbor, visited, result);
            }
        }
    }

    private String edgeToString(int s, int d) {
        return new StringBuilder().append(s).append(",").append(d).toString();
    }
}

/**
 * DFS
 * Time: O(V+E)
 * Space: O(V)
 */
class CloneGraph_Solution1Way2 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();

        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        if (node == null)
            return null;

        if (oldToNew.containsKey(node))
            return oldToNew.get(node);

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for (Node neighbor : node.neighbors)
            copy.neighbors.add(dfs(neighbor, oldToNew));

        return copy;
    }
}

/**
 * BFS
 * Time: O(V+E)
 * Space: O(V)
 */
class CloneGraph_Solution2 {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Queue<Node> queue = new ArrayDeque<>();
        Map<Node, Node> oldToNew = new HashMap<>();
        queue.offer(node);
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            Node c = oldToNew.get(n);
            for (Node neighbor : n.neighbors) {
                if (!oldToNew.containsKey(neighbor)) {
                    oldToNew.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                c.neighbors.add(oldToNew.get(neighbor));
            }
        }

        return copy;
    }
}
