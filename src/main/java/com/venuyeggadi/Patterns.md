# Index

### Java collections framework
* Frequently used constructors and methods of each data structure.

### Stack
* Monotonic Stack

### Binary Search ***

### Recursion

### Backtracking

### Trees


### Graphs
* DFS ***
* BFS ***
* Reachability
* Detect cycle in a graph
* Union Find ***
   * Cycle detection
   * Grouping
   * Number of connected components
* Topological Sort
* Dijkstra
* Bellman Ford
* Floyd Warshall
* Topological Sort
* Minimum Spanning Tree
  * Prim's 
    * Lazy Prim's
    * Eager Prim's
  * Kruskal's


### Dynamic Programming
* 1D Dynamic Programming
* 2D Dynamic Programming
* 0/1 Knapsack
* Unbounded Knapsack
* Least Common Subsequence (LCS)
* Palindromes


# Recursion
* One-branch recursion
  * Ex: Factorial
  * [Reverse Linked List](./problemsolving/leetcode/206.ReverseLinkedList.java)
* Two-branch recursion
  * Fibonacci
  * [Fibonacci Number](./problemsolving/leetcode/509.FibonacciNumber.java)
  * [Climbing Stairs](./problemsolving/leetcode/70.ClimbingStairs.java)

# Trees
* Form trees from traversals (pre-order, post-order, in-order)

# Backtracking
* Similar to DFS.
* [Template for backtracking](algorithms/backtracking/BackTrackingTemplate.java)
* Tree Maze
  * [Path exists from the root of the tree to a leaf node](algorithms/backtracking/PathFromRootToLeafOfATree.java)
  * Problems
    * [Path Sum](https://leetcode.com/problems/path-sum/) - [Solution](./problemsolving/leetcode/112.PathSum.java)
    * [Subsets](https://leetcode.com/problems/subsets/) - [Solution](./problemsolving/leetcode/78.Subsets.java)
    * [Combination Sum](https://leetcode.com/problems/combination-sum/) - [Solution](./problemsolving/leetcode/39.CombinationSum.java)
* Subsets
  * [All possible distinct subsets from a list of distinct elements](algorithms/backtracking/SubsetsOutOfDistinctElements.java)
  * [All possible distinct subsets from a list of distinct elements](algorithms/backtracking/SubsetsOutOfDuplicateElements.java)
  * Problems
    * [Subsets](https://leetcode.com/problems/subsets/) - [Solution](./problemsolving/leetcode/78.Subsets.java)
    * [Subsets II](https://leetcode.com/problems/subsets-ii) - [Solution]()
* Permutations
  * [All possible distinct permutations from a list of distinct elements](algorithms/backtracking/PermutationsOutOfDistinctElements.java)
  * Problems
    * 

# Graphs
* Representations
  * Matrix
  * Adjacency Matrix
  * Adjacency list
* [Adjacency list from Edge list](./algorithms/graphs/AdjacencyListFromEdges.java)

### DFS
* [DFS - Adjacency List](./algorithms/graphs/dfs/DFS_AdjacencyList.java)
* [DFS - Adjacency Matrix](./algorithms/graphs/dfs/DFS_AdjacencyMatrix.java)
* [Count Paths - Matrix](./algorithms/graphs/CountPaths_Matrix_DFS.java)
* [Count Paths - Adjacency List](./algorithms/graphs/CountPaths_AdjacencyList_DFS.java)

### BFS
* [BFS - Adjacency List](./algorithms/graphs/bfs/BFS_AdjacencyList.java)
* [BFS - Adjacency Matrix](./algorithms/graphs/bfs/BFS_AdjacencyMatrix.java)
* [Shortest Path - Matrix](./algorithms/graphs/ShortestPath_Matrix_BFS.java)
* [Shortest Path - Adjacency List](./algorithms/graphs/ShortestPath_AdjacencyList_BFS.java)

### Union Find
### When to use Union find over DFS/BFS?
In the case of a dynamic graph, i.e. the situation where we could add additional edges throughout the runtime of the program, 
the UnionFind approach is better. This is because the additional edge would simply incur one additional union O(α(n)) operation 
versus the BFS/DFS approach which would require the whole procedure to be recalculated in O(n^2
) time.


### Directed Acyclic Graphs (DAG)
Graphs with directed edges and no cycles
How to verify if a graph does not contain a directed cycle?
* DFS or Topological Sort (Kahn's algorithm) or Tarjan's strongly connected component algorithm.

### Topological Sort
Many real world situations can be modelled
as a graph with directed edges where some
events must occur before others.
* School class/ Course pre-requisites
* Program build dependencies
* Event scheduling
* Assembly instructions

A topological ordering is an ordering of the nodes in a directed graph where for each
directed edge from node A to node B, node A appears before node B in the ordering.  
The topological sort algorithm can find a topological ordering in O(V+E) time!  
NOTE: Topological orderings are NOT unique.
Only DAGs can have a topological ordering. A graph which contains a cycle cannot have a valid ordering.
By definition, all rooted trees have a topological ordering since they do not contain any cycles.
* [Topological Sort](./algorithms/graphs/topologicalsort/TopologicalSort.java)
* [Topological Sort Kahn's](./algorithms/graphs/topologicalsort/TopologicalSort_Kahns.java)


# Dynamic Programming
* Solving a problem as a result of the combination of sub-problems. Caching the results of the sub-problems
  so that they can be re-used for overlapping sub-problems.
* Top-down (memoization) -> Take a recursive solution and add caching to it.
* Bottom-up (tabulation) (sometimes referred to as true dynamic programming)
* 1D Dynamic Programming
  * [Fibonacci](https://leetcode.com/problems/fibonacci-number/) - [Solution](./problemsolving/leetcode/509.FibonacciNumber.java)
  * [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) - [Solution](./problemsolving/leetcode/70.ClimbingStairs.java)
  * [House Robber](https://leetcode.com/problems/house-robber/) - [Solution](./problemsolving/leetcode/198.HouseRobber.java)
  * Solutions are recursive most of the time.
    1. Come up with a Recursive solution, then
    2. Memoize (Top-down), then
    3. Tabulation (Bottom-up), then
    4. See if space can be optimized (may not always need all previous values, only last few values are enough for most of the problems)
* 2D Dynamic Programming
  * [Unique Paths](https://leetcode.com/problems/unique-paths/) - [Solution](./problemsolving/leetcode/62.UniquePaths.java)
  * [Unique Paths II](https://leetcode.com/problems/unique-paths-ii/) - [Solution](./problemsolving/leetcode/63.UniquePathsII.java)
  * [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) - [Solution](./problemsolving/leetcode/1143.LongestCommonSubsequence.java)
* 0/1 Knapsack
  * [Partition Equal Subset Sum](./problemsolving/leetcode/PartitionEqualSubsetSum.java)
  * [Target Sum](./problemsolving/leetcode/TargetSum.java)
  * [Ones and Zeroes](./problemsolving/leetcode/OnesAndZeroes.java)
  * [Last Stone Weight](./problemsolving/leetcode/LastStoneWeight.java)
* Unbounded Knapsack
  * [Coin Change](./problemsolving/leetcode/CoinChange.java)
  * [Coin Change II](./problemsolving/leetcode/CoinChangeII.java)
  * [Minimum Cost for Tickets](./problemsolving/leetcode/MinimumCostForTickets.java)
* Least Common Subsequence (LCS)
  * [Longest Common Subsequence](./problemsolving/leetcode/LongestCommonSubsequence.java)
  * [Edit Distance](./problemsolving/leetcode/EditDistance.java)
  * [Distinct Subsequences](./problemsolving/leetcode/DistinctSubsequences.java)
  * [Interleaving String](./problemsolving/leetcode/InterleavingString.java)
  * [ShortestCommonSupersequence](./problemsolving/leetcode/ShortestCommonSupersequence.java)
* Palindromes
  * [Longest Palindromic Substring](./problemsolving/leetcode/LongestPalindromicSubstring.java)
  * [Palindromic Substrings](./problemsolving/leetcode/PalindromicSubstrings.java)
  * [Longest Palindromic Subsequence](./problemsolving/leetcode/LongestPalindromicSubsequence.java)


# Math
* [Pow(x, n)](./problemsolving/leetcode/50.Pow_n_x.java)