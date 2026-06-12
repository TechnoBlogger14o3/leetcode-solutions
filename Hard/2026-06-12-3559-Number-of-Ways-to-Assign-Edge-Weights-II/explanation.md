# Number of Ways to Assign Edge Weights II (Hard)

**Problem ID:** 3559  
**Date:** 2026-06-12  
**Link:** https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/

## Approach

To solve the problem of determining the number of ways to assign weights to edges in a tree such that the cost of the path between two nodes is odd, we can follow a structured approach:

### Main Idea
The key observation is that the cost of a path between two nodes will be odd if and only if the number of edges with weight 1 in that path is odd. Given that each edge can either be assigned a weight of 1 or 2, we can derive the number of valid assignments based on the parity of the total number of edges in the path.

### Steps to Approach

1. **Tree Representation**: 
   - Use an adjacency list to represent the tree from the given edges. This allows efficient traversal of the tree.

2. **Depth-First Search (DFS)**:
   - Perform a DFS from the root (node 1) to compute the depth of each node and maintain the parent-child relationships. This will help in efficiently finding the path between any two nodes.

3. **Lowest Common Ancestor (LCA)**:
   - To find the path between two nodes \( u \) and \( v \), we can utilize the concept of the Lowest Common Ancestor (LCA). The path can be divided into two segments: from \( u \) to LCA and from \( v \) to LCA.
   - The total number of edges in the path from \( u \) to \( v \) can be calculated as:
     \[
     \text{edges\_count} = \text{depth}[u] + \text{depth}[v] - 2 \times \text{depth}[\text{LCA}(u, v)]
     \]

4. **Count Valid Assignments**:
   - If the total number of edges in the path is \( k \):
     - If \( k \) is even, the number of ways to assign weights such that the total weight is odd is \( 0 \) (since we cannot have an odd count of edges with weight 1).
     - If \( k \) is odd, the number of valid assignments is \( 2^{(k-1)} \) (since we can choose any combination of \( k-1 \) edges to be weight 1, and the last edge must be weight 1 to ensure the total is odd).

5. **Precomputation for Efficiency**:
   - Precompute powers of 2 modulo \( 10^9 + 7 \) up to the maximum possible number of edges to efficiently answer each query.

### Data Structures
- **Adjacency List**: For tree representation.
- **Depth Array**: To store the depth of each node.
- **Parent Array**: To facilitate LCA computation (can be done using binary lifting or simple parent tracking).

### Complexity
- **Time Complexity**:
  - DFS traversal takes \( O(n) \).
  - Each query can be answered in \( O(\log n) \) for LCA computation, leading to a total of \( O(q \log n) \) for \( q \) queries.
- **Space Complexity**:
  - \( O(n) \) for the adjacency list and additional arrays for depth and parent tracking.

By combining these steps, we can efficiently determine the number of valid edge weight assignments for each query in the given tree structure.
