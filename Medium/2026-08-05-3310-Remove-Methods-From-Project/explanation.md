# Remove Methods From Project (Medium)

**Problem ID:** 3310  
**Date:** 2026-08-05  
**Link:** https://leetcode.com/problems/remove-methods-from-project/

## Approach

To solve the problem of removing suspicious methods from a project, we can break down the approach into several clear steps:

### Main Idea:
The goal is to identify all methods that are either directly or indirectly invoked by a known buggy method (method `k`). Once we identify these suspicious methods, we need to determine if they can be removed based on whether they are invoked by any non-suspicious methods. If any suspicious method is invoked by a non-suspicious method, we cannot remove them.

### Steps to Solve the Problem:

1. **Graph Representation**:
   - Represent the methods and their invocations as a directed graph where each method is a node and each invocation is a directed edge from one method to another. This can be done using an adjacency list.

2. **Identify Suspicious Methods**:
   - Use Depth-First Search (DFS) or Breadth-First Search (BFS) starting from method `k` to find all methods that can be reached (i.e., invoked) from `k`. This will give us a set of suspicious methods.

3. **Check for Invocation from Non-Suspicious Methods**:
   - Create an additional structure to keep track of which methods invoke the suspicious methods. This can be done using an inverse adjacency list (or a reverse graph).
   - Traverse this inverse graph to check if any non-suspicious method invokes any of the suspicious methods. If such an invocation exists, we cannot remove the suspicious methods.

4. **Construct the Result**:
   - If no non-suspicious methods invoke any suspicious methods, return the list of methods that are not in the set of suspicious methods. If removal is not possible, return an empty list.

### Data Structures:
- **Adjacency List**: To represent the graph of method invocations.
- **Set or List**: To keep track of suspicious methods found through DFS/BFS.
- **Inverse Adjacency List**: To track which methods invoke suspicious methods for the validation step.

### Complexity:
- **Time Complexity**: The overall time complexity is O(n + m), where `n` is the number of methods and `m` is the number of invocations. This accounts for the graph traversal to identify suspicious methods and checking for invocations from non-suspicious methods.
- **Space Complexity**: O(n + m) for storing the adjacency list and the inverse adjacency list.

By following this structured approach, we can efficiently determine which methods can be safely removed from the project while adhering to the constraints provided.
