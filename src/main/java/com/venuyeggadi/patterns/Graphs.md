# Graphs

## Representations
  * Matrix
  * Adjacency Matrix
  * Adjacency list
  * [Adjacency list from Edge list](./algorithms/graphs/AdjacencyListFromEdges.java)

## DFS
* [DFS - Adjacency List](./algorithms/graphs/dfs/DFS_AdjacencyList.java)
* [DFS - Adjacency Matrix](./algorithms/graphs/dfs/DFS_AdjacencyMatrix.java)
* [Count Paths - Matrix](./algorithms/graphs/CountPaths_Matrix_DFS.java)
* [Count Paths - Adjacency List](./algorithms/graphs/CountPaths_AdjacencyList_DFS.java)

## BFS
* [BFS - Adjacency List](./algorithms/graphs/bfs/BFS_AdjacencyList.java)
* [BFS - Adjacency Matrix](./algorithms/graphs/bfs/BFS_AdjacencyMatrix.java)
* [Shortest Path - Matrix](./algorithms/graphs/ShortestPath_Matrix_BFS.java)
* [Shortest Path - Adjacency List](./algorithms/graphs/ShortestPath_AdjacencyList_BFS.java)



## Union Find
#### When to use Union find over DFS/BFS?
In the case of a dynamic graph, i.e. the situation where we could add additional edges throughout the runtime of the program,
the UnionFind approach is better. This is because the additional edge would simply incur one additional union O(α(n)) operation
versus the BFS/DFS approach which would require the whole procedure to be recalculated in O(n^2) time.


## Dijkstra's shortest path algorithm


## Minimum Spanning Trees

### Prim's 

### Kruskal's



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
