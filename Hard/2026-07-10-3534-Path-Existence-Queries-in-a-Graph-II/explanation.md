# Path Existence Queries in a Graph II (Hard)

**Problem ID:** 3534  
**Date:** 2026-07-10  
**Link:** https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/

## Approach

To solve the problem of finding the minimum distance between nodes in a graph defined by the absolute difference condition, we can follow a structured approach:

### Main Idea:
The key insight is to treat the nodes as part of a graph where edges exist based on the condition `|nums[i] - nums[j]| <= maxDiff`. Instead of constructing the graph explicitly, we can utilize a union-find (disjoint-set) data structure to efficiently manage connected components of nodes that can reach each other based on the given condition.

### Approach:
1. **Union-Find Data Structure**: Use a union-find (or disjoint-set) structure to group nodes that are connected. This allows us to efficiently merge sets of nodes and find the root of any node to determine connectivity.

2. **Sorting and Merging**:
   - Create a list of nodes indexed by their values from `nums`.
   - Sort this list based on the values in `nums`. This helps in efficiently finding which nodes can be connected based on the `maxDiff` condition.
   - Iterate through the sorted list and for each node, check its neighboring nodes (in terms of value) to see if they can be connected. If the difference between the current node and its neighbor is less than or equal to `maxDiff`, we union them in the union-find structure.

3. **Query Processing**:
   - For each query, check if the two nodes belong to the same connected component using the union-find structure. If they do, calculate the minimum distance using BFS or DFS to find the shortest path length between the two nodes.
   - If the nodes are not connected, return `-1`.

### Data Structures:
- **Union-Find**: To manage connected components and efficiently perform union and find operations.
- **Graph Representation**: While we don't explicitly build the graph, we conceptually treat the nodes as connected based on the union-find structure.

### Complexity:
- **Time Complexity**: The union-find operations are nearly constant time, specifically O(α(n)), where α is the inverse Ackermann function. Sorting the nodes takes O(n log n), and processing each query can take O(n) in the worst case if BFS/DFS is used. Thus, the overall complexity can be approximated as O(n log n + q * n), where q is the number of queries.
- **Space Complexity**: O(n) for storing the union-find parent and rank arrays.

This approach efficiently handles the constraints given in the problem, allowing us to answer the queries regarding path existence and minimum distance in the graph defined by the `maxDiff` condition.
