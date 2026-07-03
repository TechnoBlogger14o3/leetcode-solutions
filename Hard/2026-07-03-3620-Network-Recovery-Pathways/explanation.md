# Network Recovery Pathways (Hard)

**Problem ID:** 3620  
**Date:** 2026-07-03  
**Link:** https://leetcode.com/problems/network-recovery-pathways/

## Approach

To solve the "Network Recovery Pathways" problem, we can adopt a binary search approach combined with a graph traversal technique, such as Depth-First Search (DFS) or Breadth-First Search (BFS). The main idea is to find the maximum score (minimum edge cost) that allows for a valid path from node 0 to node n-1, given the constraints of online nodes and total recovery cost.

### Approach:

1. **Binary Search on Edge Cost**: 
   - We will perform a binary search on the possible values of the minimum edge cost, ranging from 0 to the maximum edge cost present in the graph. For each candidate minimum edge cost `mid`, we will check if there exists a valid path from node 0 to node n-1 that satisfies the conditions.

2. **Graph Representation**:
   - Use an adjacency list to represent the directed acyclic graph (DAG). Each node will have a list of its outgoing edges, along with their costs.

3. **Path Validation using DFS/BFS**:
   - For each value of `mid` during the binary search, we will use DFS or BFS to explore paths from node 0 to node n-1. 
   - During the traversal, we will only consider edges that have a cost greater than or equal to `mid` and ensure that all intermediate nodes are online.
   - Additionally, we will keep track of the total recovery cost along the path and ensure it does not exceed `k`.

4. **Result Compilation**:
   - If a valid path exists for a given `mid`, it means we can potentially increase the minimum edge cost, so we adjust our binary search range accordingly. If no path exists, we reduce the range.

5. **Complexity**:
   - The binary search will run in `O(log(max_cost))`, where `max_cost` is the maximum edge cost. For each mid value, the DFS/BFS traversal will take `O(V + E)` time, where `V` is the number of vertices and `E` is the number of edges. Thus, the overall complexity will be `O((V + E) * log(max_cost))`.

### Summary:
By combining binary search with graph traversal, we efficiently determine the maximum score of valid paths in the directed acyclic graph while adhering to the constraints of online nodes and total recovery costs. This structured approach ensures that we explore all potential paths without unnecessary computations, leading to an optimal solution.
