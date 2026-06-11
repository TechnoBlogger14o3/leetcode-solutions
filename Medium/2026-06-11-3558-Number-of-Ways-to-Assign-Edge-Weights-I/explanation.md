# Number of Ways to Assign Edge Weights I (Medium)

**Problem ID:** 3558  
**Date:** 2026-06-11  
**Link:** https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/

## Approach

To solve the problem of determining the number of ways to assign edge weights in a tree such that the total cost of the path from the root node (node 1) to the maximum depth node is odd, we can follow these steps:

### Approach:

1. **Tree Representation**: Use an adjacency list to represent the tree structure from the given edges. This allows easy traversal of the tree.

2. **Depth-First Search (DFS)**: Perform a DFS starting from the root node (node 1) to determine the maximum depth of the tree and to identify all nodes at that maximum depth. During the DFS, keep track of the depth of each node and the number of edges encountered along the path from the root to each node.

3. **Count Edges**: For each node at maximum depth, count the total number of edges (or weights) in the path from the root to that node. Let this count be `d`.

4. **Determine Weight Assignments**:
   - If `d` (the number of edges) is even, the total weight can be made odd by assigning an odd number of weights (1s) along the path. This can be achieved by assigning weights as follows:
     - Assign 1 to an odd number of edges and 2 to the rest. The number of valid combinations is given by choosing any odd number of weights from `d` edges.
   - If `d` is odd, the total weight can be made odd by assigning an even number of weights (1s). The number of valid combinations is given by choosing any even number of weights from `d` edges.

5. **Combinatorial Counting**: Use combinatorial mathematics to calculate the number of ways to assign the weights based on the parity of `d`:
   - For even `d`: Count combinations of choosing odd numbers from `d`.
   - For odd `d`: Count combinations of choosing even numbers from `d`.

6. **Modulo Operation**: Since the answer can be large, ensure all calculations are performed modulo \(10^9 + 7\).

### Data Structures:
- An adjacency list (array of lists) to represent the tree.
- A stack or recursion for DFS traversal.

### Complexity:
- **Time Complexity**: O(n), where n is the number of nodes, since we traverse each edge once during the DFS.
- **Space Complexity**: O(n) for storing the adjacency list and the recursion stack.

By following this structured approach, we can efficiently determine the number of valid edge weight assignments that yield an odd total cost for the path from the root to any maximum depth node in the tree.
