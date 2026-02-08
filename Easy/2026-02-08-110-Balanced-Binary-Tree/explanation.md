# Balanced Binary Tree (Easy)

**Problem ID:** 110  
**Date:** 2026-02-08  
**Link:** https://leetcode.com/problems/balanced-binary-tree/

## Approach

To determine if a binary tree is height-balanced, we need to ensure that for every node in the tree, the height difference between its left and right subtrees does not exceed 1. 

### Approach:

1. **Recursive Depth-First Search (DFS):** 
   - We can use a recursive function to traverse the tree. The function will return two pieces of information: whether the subtree rooted at the current node is balanced, and its height.
  
2. **Base Case:**
   - If the current node is `null`, it is considered balanced, and its height is `0`.

3. **Recursive Case:**
   - For each node, recursively check the left and right subtrees.
   - After obtaining the balance status and heights of the left and right subtrees, determine:
     - If both subtrees are balanced.
     - If the height difference between the left and right subtrees is at most 1.
   - If both conditions are met, the current subtree is balanced, and we return `true` along with its height (which is `1 + max(left_height, right_height)`).

4. **Final Decision:**
   - The overall tree is balanced if the root node's recursive function indicates it is balanced.

### Data Structures:
- The primary data structure used is the binary tree itself, represented through nodes with pointers to left and right children.

### Complexity:
- **Time Complexity:** O(N), where N is the number of nodes in the tree. Each node is visited once.
- **Space Complexity:** O(H), where H is the height of the tree, due to the recursive call stack. In the worst case (unbalanced tree), this can be O(N), but in a balanced tree, it will be O(log N).

This approach efficiently checks the balance of the tree while calculating heights in a single traversal, making it optimal for the problem at hand.
