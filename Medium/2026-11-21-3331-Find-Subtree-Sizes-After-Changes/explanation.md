# Find Subtree Sizes After Changes (Medium)

**Problem ID:** 3331  
**Date:** 2026-11-21  
**Link:** https://leetcode.com/problems/find-subtree-sizes-after-changes/

## Approach

To solve the problem of finding subtree sizes after changes in the tree structure based on character matching, we can follow a systematic approach:

### Problem Breakdown

1. **Tree Representation**: The tree is represented using a parent array, where each node has a reference to its parent. This allows us to easily traverse the tree and find ancestors.

2. **Character Matching**: For each node \( x \) (from 1 to \( n-1 \)), we need to find the closest ancestor \( y \) such that \( s[x] == s[y] \). If such an ancestor exists, we will change the parent of \( x \) to \( y \).

3. **Subtree Size Calculation**: After making the changes to the tree structure, we need to compute the size of the subtree rooted at each node.

### Approach

1. **Build the Tree**: First, construct an adjacency list representation of the tree using the parent array. This will help in traversing the tree and finding child nodes efficiently.

2. **Depth-First Search (DFS) for Subtree Sizes**: 
   - Perform a DFS traversal starting from the root (node 0) to calculate the initial sizes of the subtrees. This will give us a baseline size for each node before any changes are made.
   - During this traversal, maintain a mapping of characters to the most recent node encountered with that character. This will help in quickly identifying the closest ancestor with the same character.

3. **Process Changes**: 
   - For each node \( x \) (from 1 to \( n-1 \)), check the character mapping to find the closest ancestor \( y \).
   - If \( y \) is found, update the tree structure by removing the current parent of \( x \) and adding \( y \) as the new parent. Adjust the subtree sizes accordingly:
     - Decrease the size of the original parent’s subtree.
     - Increase the size of \( y \)’s subtree to account for the newly added child \( x \).

4. **Final Subtree Size Calculation**: After processing all changes, iterate through the nodes to finalize the subtree sizes based on the updated tree structure.

### Data Structures

- **Adjacency List**: For representing the tree and its edges.
- **Array or Map**: To keep track of the most recent node for each character during DFS traversal.
- **Array for Subtree Sizes**: To store the size of the subtree for each node.

### Complexity

- **Time Complexity**: The overall complexity is \( O(n) \). Building the tree and performing the DFS traversal both take linear time. Each node is processed a limited number of times during the character matching and subtree size adjustments.
- **Space Complexity**: The space used is \( O(n) \) for the adjacency list and additional storage for character mapping and subtree sizes.

This structured approach ensures that we efficiently handle the tree modifications and compute the required subtree sizes, adhering to the constraints provided.
