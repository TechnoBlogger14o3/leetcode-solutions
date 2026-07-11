# Count the Number of Complete Components (Medium)

**Problem ID:** 2685  
**Date:** 2026-07-11  
**Link:** https://leetcode.com/problems/count-the-number-of-complete-components/

## Approach

To solve the problem of counting the number of complete connected components in an undirected graph, we can follow a systematic approach:

### Main Idea:
1. **Graph Representation**: Represent the graph using an adjacency list or matrix to efficiently store and access the connections between vertices.
2. **Connected Components Identification**: Use Depth-First Search (DFS) or Breadth-First Search (BFS) to explore the graph and identify connected components.
3. **Completeness Check**: For each connected component found, check if it is complete, meaning every vertex in the component is connected to every other vertex.

### Steps:
1. **Graph Construction**: Create an adjacency list from the given edges. This allows for efficient traversal of the graph.
2. **DFS/BFS Traversal**: Initialize a visited array to keep track of which vertices have been explored. For each unvisited vertex, start a DFS/BFS to explore the entire connected component.
3. **Count Vertices and Edges**: While traversing a component, count the number of vertices and edges. For a component with `k` vertices, a complete component should have exactly `k * (k - 1) / 2` edges (the formula for the number of edges in a complete graph).
4. **Check Completeness**: After traversing, compare the actual number of edges counted during the traversal to the expected number of edges for completeness.
5. **Count Complete Components**: Maintain a counter to track how many complete components are found during the exploration of the graph.

### Data Structures:
- **Adjacency List**: A list of lists or a dictionary to represent the graph.
- **Visited Array**: A boolean array to keep track of which vertices have been visited during the traversal.

### Complexity:
- **Time Complexity**: O(n + m), where `n` is the number of vertices and `m` is the number of edges. This accounts for the graph traversal and edge counting.
- **Space Complexity**: O(n + m) for the adjacency list and the visited array.

By following this structured approach, we can efficiently determine the number of complete connected components in the graph.
