package com.venuyeggadi.problemsolving.leetcode;

import java.util.*;

/**
 * DFS
 * Intuition:
 *      Form a graph using the emails in a group. Connect the side by side emails with edges. While doing so, two groups
 *      having the same email will be connected with an edge automatically.
 *          For example, when edges (considered as different groups), [1, 2] and [2, 3] are connected,
 *          it will form a connected graph 1 <--> 2 <--> 3 because 2 is common in both.
 *      So by starting at particular email belonging
 *      to a particular account, we can visit all the emails belonging to that account (as they're connected now) using
 *      DFS or BFS. Apply DFS or BFS on each node to all the nodes connected to it, and they belong to the same account.
 *      Keep a track of the visited nodes in order not to duplicate the result.
 *
 *  Time: nk * log nk
 *  Space: nk
 *
 *  * n - number of accounts
 *  * k - average account length
 */
class AccountsMerge_Solution1 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToAccountIndex = new HashMap<>();
        Map<String, List<String>> adj = new HashMap<>();

        for (int accountIndex = 0; accountIndex < accounts.size(); accountIndex++) {
            List<String> account = accounts.get(accountIndex);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                emailToAccountIndex.putIfAbsent(email, accountIndex);
                adj.putIfAbsent(email, new ArrayList<>());
            }
        }

        for (List<String> account : accounts) {
            for (int i = 2; i < account.size(); i++) {
                String email1 = account.get(i - 1), email2 = account.get(i);
                adj.get(email1).add(email2);
                adj.get(email2).add(email1);
            }
        }

        Map<Integer, List<String>> groupedEmails = new HashMap<>();
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, Integer> entry : emailToAccountIndex.entrySet()) {
            String email = entry.getKey();
            int accountIndex = entry.getValue();
            dfs(adj, email, accountIndex, visited, groupedEmails);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> group : groupedEmails.entrySet()) {
            List<String> merged = group.getValue();
            Collections.sort(merged);
            List<String> list = new ArrayList<>();
            list.add(accounts.get(group.getKey()).get(0));
            list.addAll(merged);
            result.add(list);
        }

        return result;
    }

    private void dfs(Map<String, List<String>> adj, String node, int accountIndex, Set<String> visited, Map<Integer, List<String>> groupedEmails) {
        if (visited.contains(node))
            return;

        groupedEmails.putIfAbsent(accountIndex, new ArrayList<String>());

        visited.add(node);
        groupedEmails.get(accountIndex).add(node);

        for (String neighbor : adj.get(node)) {
            dfs(adj, neighbor, accountIndex, visited, groupedEmails);
        }
    }
}

/**
 * DFS
 *      Same as above but first map all the emails to integers and work with them. Then map them back emails while returning
 *      result. Here we have two-way mapping emailToVertex and vertexTo email for easy access conversion from one to another.
 *
 *      DFS function is written in a cleaner, modular way.
 *
 * Time: nk * log nk
 *      3 * nk -> for forming the emailToVertex, vertexToEmail and vertexToAccountIndex
 *      2 * nk -> for forming the adjacency list
 *      n * k for dfs
 *      nk * log nk for forming the result
 * Space: nk
 *
 *  * n - number of accounts
 *  * k - average account length
 */
class AccountsMerge_Solution1Way1_Better {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToVertex = new HashMap<>();
        List<String> vertexToEmail = new ArrayList<>();
        Map<Integer, Integer> vertexToAccountIndex = new HashMap<>();

        int vertex = 0;
        for (int accountIndex = 0; accountIndex < accounts.size(); accountIndex++) {
            List<String> account = accounts.get(accountIndex);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailToVertex.containsKey(email)) {
                    emailToVertex.put(email, vertex);
                    vertexToEmail.add(email);
                    vertexToAccountIndex.putIfAbsent(vertex, accountIndex);
                    ++vertex;
                }
            }
        }

        int numberOfEmails = emailToVertex.size();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numberOfEmails; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<String> account : accounts) {
            for (int i = 2; i < account.size(); i++) {
                String email1 = account.get(i - 1), email2 = account.get(i);
                int v1 = emailToVertex.get(email1), v2 = emailToVertex.get(email2);
                adj.get(v1).add(v2);
                adj.get(v2).add(v1);
            }
        }

        Map<Integer, List<Integer>> groupedEmails = new HashMap<>();
        boolean[] visited = new boolean[numberOfEmails];
        for (int v = 0; v < numberOfEmails; v++) {
            if (visited[v])
                continue;
            int accountIndex = vertexToAccountIndex.get(v);
            List<Integer> allConnectedEmails = new ArrayList<>();
            dfs(adj, v, visited, allConnectedEmails);
            groupedEmails.put(accountIndex, allConnectedEmails);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> group : groupedEmails.entrySet()) {
            List<Integer> merged = group.getValue();
            List<String> emails = new ArrayList<>();
            for (int v : merged)
                emails.add(vertexToEmail.get(v));
            Collections.sort(emails);
            List<String> list = new ArrayList<>();
            list.add(accounts.get(group.getKey()).get(0));
            list.addAll(emails);
            result.add(list);
        }

        return result;
    }

    private void dfs(List<List<Integer>> adj, int node, boolean[] visited, List<Integer> connectedEmails) {
        if (visited[node])
            return;

        visited[node] = true;
        connectedEmails.add(node);

        for (int neighbor : adj.get(node)) {
            dfs(adj, neighbor, visited, connectedEmails);
        }
    }
}


/**
 * BFS
 * Intuition: Same as the solution one but visiting the nodes is done with BFS
 *
 * Time: nk * log nk
 * Space: nk
 *
 *  * n - number of accounts
 *  * k - average account length
 */
class AccountsMerge_Solution2 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToVertex = new HashMap<>();
        List<String> vertexToEmail = new ArrayList<>();
        Map<Integer, Integer> vertexToAccountIndex = new HashMap<>();

        int vertex = 0;
        for (int accountIndex = 0; accountIndex < accounts.size(); accountIndex++) {
            List<String> account = accounts.get(accountIndex);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailToVertex.containsKey(email)) {
                    emailToVertex.put(email, vertex);
                    vertexToEmail.add(email);
                    vertexToAccountIndex.putIfAbsent(vertex, accountIndex);
                    ++vertex;
                }
            }
        }

        int numberOfEmails = emailToVertex.size();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numberOfEmails; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<String> account : accounts) {
            for (int i = 2; i < account.size(); i++) {
                String email1 = account.get(i - 1), email2 = account.get(i);
                int v1 = emailToVertex.get(email1), v2 = emailToVertex.get(email2);
                adj.get(v1).add(v2);
                adj.get(v2).add(v1);
            }
        }

        Map<Integer, List<Integer>> groupedEmails = new HashMap<>();
        boolean[] visited = new boolean[numberOfEmails];
        for (int v = 0; v < numberOfEmails; v++) {
            if (visited[v])
                continue;
            int accountIndex = vertexToAccountIndex.get(v);
            List<Integer> allConnectedEmails = new ArrayList<>();
            bfs1(adj, v, visited, allConnectedEmails);
            groupedEmails.put(accountIndex, allConnectedEmails);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> group : groupedEmails.entrySet()) {
            List<Integer> merged = group.getValue();
            List<String> emails = new ArrayList<>();
            for (int v : merged)
                emails.add(vertexToEmail.get(v));
            Collections.sort(emails);
            List<String> list = new ArrayList<>();
            list.add(accounts.get(group.getKey()).get(0));
            list.addAll(emails);
            result.add(list);
        }

        return result;
    }

    /**
     * BFS - Processing the node after getting from the queue
     */
    private void bfs1(List<List<Integer>> adj, int node, boolean[] visited, List<Integer> connectedEmails) {
        if (visited[node])
            return;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            connectedEmails.add(n);
            for (int neighbor : adj.get(n)) {
                if (visited[neighbor])
                    continue;
                queue.offer(neighbor);
                visited[neighbor] = true;
            }
        }
    }

    /**
     * BFS - Processing the node before adding to the queue.
     */
    private void bfs2(List<List<Integer>> adj, int node, boolean[] visited, List<Integer> connectedEmails) {
        if (visited[node])
            return;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        connectedEmails.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int neighbor : adj.get(n)) {
                if (visited[neighbor])
                    continue;
                connectedEmails.add(neighbor);
                queue.offer(neighbor);
                visited[neighbor] = true;
            }
        }
    }
}


/**
 * Disjoint Set / Union Find
 * Intuition:
 *      Consider each account as node for the UnionFind structure. Form a UnionFind with account indexes as nodes.
 *      Now, by going through each account and emails within them, if two accounts have the same email, they can be
 *      connected (union). At the end, all the accounts will be grouped and each group will have one of the account
 *      as a parent.
 *      Now we can form the result by going through each account and adding its emails to the parent account. By the end
 *      all the emails in the connected accounts will be grouped under the parent account.
 *
 * Time: O(nk * log nk + nk * a(n)) => nk * log nk
 *      n * k * a(n) -> For doing union for all the emails (n * k) in the worst case where all the accounts belong to same person
 *      n * k * a(n) -> Ror finding each ones parent and grouping
 *      nk * log nk + nk -> for forming the result by sorting
 *          average: when there are n accounts with k emails each
 *              n * (k log k + k) => nk * log k for forming the result, because it includes sorting as well
 *          worst: when all the emails (nk) belong to the same person
 *              nk * log nk + nk
 *      here, union and find operations will take a(n) if both path compression and union by rank are implemented
 *      and will take log(n) if only union by rank is implemented.
 *
 * Space: (n + 2 * n * k) => O(n * k)
 *      n -> For UnionFind
 *      n * k -> for emailToAccountIndex
 *      n * k -> groupedEmails
 *
 * n - number of accounts
 * k - average account length
 */
class AccountsMerge_Solution3 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind unionFind = new UnionFind(accounts.size());

        Map<String, Integer> emailToAccountIndex = new HashMap<>();
        for (int accountIndex = 0; accountIndex < accounts.size(); accountIndex++) {
            List<String> emails = accounts.get(accountIndex);
            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                if (emailToAccountIndex.containsKey(email)) {
                    unionFind.union(emailToAccountIndex.get(email), accountIndex);
                } else {
                    emailToAccountIndex.put(email, accountIndex);
                }
            }
        }

        Map<Integer, List<String>> groupedEmails = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailToAccountIndex.entrySet()) {
            int parent = unionFind.find(entry.getValue());
            groupedEmails.putIfAbsent(parent, new ArrayList<>());
            groupedEmails.get(parent).add(entry.getKey());
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> group : groupedEmails.entrySet()) {
            List<String> merged = group.getValue();
            Collections.sort(merged);
            List<String> list = new ArrayList<>();
            list.add(accounts.get(group.getKey()).get(0));
            list.addAll(merged);
            result.add(list);
        }

        return result;
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

            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else if (rank[p2] > rank[p1]) {
                parent[p1] = p2;
            } else {
                parent[p1] = p2;
                ++rank[p2];
            }

            return true;
        }
    }
}