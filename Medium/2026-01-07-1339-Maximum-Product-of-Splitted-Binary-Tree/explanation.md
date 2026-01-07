# Maximum Product of Splitted Binary Tree (Medium)

**Problem ID:** 1339  
**Date:** 2026-01-07  
**Link:** https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

## Approach

To solve the problem of maximizing the product of the sums of two subtrees obtained by splitting a binary tree, we can follow a systematic approach:

### Problem Breakdown
1. **Understanding the Tree Structure**: We need to consider how splitting the tree at various edges affects the sums of the resulting subtrees. Each edge can be thought of as a potential split point.

2. **Sum Calculation**: The first step is to calculate the total sum of all node values in the tree. This will help us determine the sum of one subtree once we know the sum of the other subtree (since the total sum is constant).

3. **DFS for Subtree Sums**: We can perform a Depth-First Search (DFS) traversal to calculate the sum of each subtree rooted at every node. During this traversal:
   - For each node, compute the sum of its subtree.
   - Store the subtree sums in a list or variable.

4. **Maximizing the Product**: As we compute the subtree sums, we can calculate the product of the sum of the current subtree with the sum of the remaining tree (which is the total sum minus the current subtree sum). Specifically, for a subtree sum `subtree_sum`, the product can be calculated as:
   \[
   \text{product} = \text{subtree\_sum} \times (\text{total\_sum} - \text{subtree\_sum})
   \]
   We need to keep track of the maximum product encountered during this process.

5. **Modulo Operation**: Since the result can be very large, we will take the product modulo \(10^9 + 7\) at the end.

### Data Structures
- A binary tree structure to represent the nodes.
- Variables to store the total sum of the tree and the maximum product found.

### Complexity
- **Time Complexity**: The algorithm primarily consists of a single DFS traversal of the tree, which takes \(O(N)\) time, where \(N\) is the number of nodes in the tree.
- **Space Complexity**: The space complexity is \(O(H)\) for the recursion stack, where \(H\) is the height of the tree. In the worst case (for a skewed tree), this could be \(O(N)\), but for a balanced tree, it would be \(O(\log N)\).

### Summary
By leveraging a DFS to calculate subtree sums and simultaneously compute the maximum product of the sums of the two resulting subtrees, we can efficiently solve the problem. The key is to maintain the total sum and use it to derive the product for each potential split point, ensuring we take the result modulo \(10^9 + 7\) before returning it.
