# Count Nodes Equal to Average of Subtree (Medium)

**Problem ID:** 2265  
**Date:** 2026-09-10  
**Link:** https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/

## Approach

To solve the problem of counting nodes in a binary tree that are equal to the average of their subtree, we can adopt a recursive approach utilizing depth-first search (DFS). Here's a concise explanation of the approach:

### Main Idea:
The core idea is to traverse the binary tree and, for each node, calculate the sum of values and the count of nodes in its subtree. Once we have these two values, we can compute the average (using integer division for flooring) and check if it matches the node's value. If it does, we increment our count.

### Approach:
1. **Recursive DFS Function**: We define a recursive function that takes a node as input and returns two values: the sum of the values in the subtree rooted at that node and the count of nodes in that subtree.
   
2. **Base Case**: If the current node is `null`, return a sum of `0` and a count of `0`.

3. **Recursive Case**:
   - Recursively call the function for the left and right children of the node to get their respective sums and counts.
   - Calculate the total sum and count for the current node by adding the node's value to the sums of the left and right subtrees and incrementing the count by `1` (for the current node).
   - Compute the average of the subtree using integer division (sum // count).
   - Compare this average with the current node's value. If they are equal, increment a global or non-local count.

4. **Final Count**: After the traversal is complete, the count of nodes that meet the condition is returned.

### Data Structures:
- We primarily use a binary tree structure, where each node contains a value and pointers to its left and right children.

### Complexity:
- **Time Complexity**: O(N), where N is the number of nodes in the tree, since we visit each node exactly once.
- **Space Complexity**: O(H), where H is the height of the tree, due to the recursion stack. In the worst case (a skewed tree), this can be O(N), but in a balanced tree, it would be O(log N).

This approach efficiently counts the nodes that satisfy the average condition while ensuring that we only traverse the tree once, making it optimal for the problem constraints.
