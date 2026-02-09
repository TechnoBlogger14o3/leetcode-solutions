# Balance a Binary Search Tree (Medium)

**Problem ID:** 1382  
**Date:** 2026-02-09  
**Link:** https://leetcode.com/problems/balance-a-binary-search-tree/

## Approach

To solve the problem of balancing a binary search tree (BST), we can follow a structured approach that leverages the properties of BSTs and the concept of in-order traversal.

### Approach:

1. **In-Order Traversal**:
   - The first step is to perform an in-order traversal of the given BST. This traversal will yield the node values in sorted order because of the properties of BSTs. We can use a recursive or iterative approach to collect these values into a list.

2. **Construct a Balanced BST**:
   - Once we have the sorted list of node values, the next step is to construct a balanced BST. To achieve this, we can use a recursive function that takes the sorted list and builds the tree:
     - Select the middle element of the list as the root of the current subtree. This ensures that the tree remains balanced.
     - Recursively apply the same logic to the left half of the list to construct the left subtree and the right half for the right subtree.

### Data Structures:
- A list (or array) to store the values obtained from the in-order traversal.
- A recursive function to construct the balanced BST from the sorted list.

### Complexity:
- **Time Complexity**: The in-order traversal takes O(n) time, where n is the number of nodes in the tree. Constructing the balanced BST from the sorted list also takes O(n) time. Therefore, the overall time complexity is O(n).
- **Space Complexity**: The space complexity is O(n) due to the storage of the node values in the list and the recursion stack used during the tree construction.

### Summary:
This approach efficiently balances the BST by first obtaining a sorted list of values through in-order traversal and then recursively constructing a balanced tree using the middle elements of the list. This guarantees that the resulting tree meets the balance criteria specified in the problem statement.
