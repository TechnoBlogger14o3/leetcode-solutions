# Sum of Root To Leaf Binary Numbers (Easy)

**Problem ID:** 1022  
**Date:** 2026-02-24  
**Link:** https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

## Approach

To solve the problem of calculating the sum of root-to-leaf binary numbers represented by a binary tree, we can utilize a depth-first search (DFS) approach. Here’s a concise explanation of the problem-solving strategy:

### Main Idea:
The key idea is to traverse the binary tree from the root to each leaf node while constructing the binary number represented by the path taken. At each node, we build the binary number by shifting the current accumulated value to the left (equivalent to multiplying by 2) and adding the current node's value (0 or 1). When we reach a leaf node, we add the constructed binary number to a cumulative sum.

### Data Structures:
- A binary tree structure is used, where each node contains a value (0 or 1) and pointers to its left and right children.
- An integer variable is used to keep track of the cumulative sum of all binary numbers formed from root to leaf paths.

### Approach:
1. **DFS Traversal**: Start from the root node and use a recursive function to traverse the tree.
2. **Path Construction**: At each node, update the current binary number by performing:
   - `current_value = (current_value << 1) | node.val`
   This operation shifts the current value left by one bit (to make space for the new bit) and adds the current node's value.
3. **Leaf Check**: When a leaf node is reached (both left and right children are null), add the current binary number to the cumulative sum.
4. **Backtrack**: Continue the traversal until all paths from root to leaf have been explored.

### Complexity:
- **Time Complexity**: O(N), where N is the number of nodes in the tree. Each node is visited exactly once.
- **Space Complexity**: O(H), where H is the height of the tree. This accounts for the recursion stack in the worst case (for a skewed tree).

This approach efficiently computes the sum of all root-to-leaf binary numbers by leveraging the properties of binary representation and tree traversal techniques.
