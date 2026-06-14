# Maximum Twin Sum of a Linked List (Medium)

**Problem ID:** 2130  
**Date:** 2026-06-14  
**Link:** https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

## Approach

To solve the problem of finding the maximum twin sum of a linked list, we can follow a systematic approach that leverages the properties of the linked list structure.

### Approach:

1. **Understanding Twin Nodes**: Each node in the first half of the linked list has a corresponding twin node in the second half. For a linked list of size `n`, the twin of the `i-th` node is the `(n-1-i)-th` node.

2. **Two-Pass Strategy**:
   - **First Pass**: Traverse the linked list to determine its length `n` and store the values of the first half of the list in an array (or list). This allows us to easily access the values of the first half nodes by their indices.
   - **Second Pass**: Traverse the linked list again to compute the twin sums. For each node in the first half, calculate the sum with its corresponding twin node from the second half (which can be accessed using the stored values from the first pass). Keep track of the maximum twin sum encountered during this traversal.

3. **Data Structures**: 
   - Use an array (or list) to store the values of the first half of the linked list. This allows O(1) access to these values when calculating the twin sums in the second pass.

4. **Complexity**:
   - **Time Complexity**: O(n), where `n` is the number of nodes in the linked list. We make two passes over the list.
   - **Space Complexity**: O(n/2) = O(n), for storing the values of the first half of the linked list.

### Summary:
By using a two-pass approach—first to store the values of the first half of the list and second to compute the twin sums—we can efficiently determine the maximum twin sum in linear time while utilizing additional space for storing half the list's values. This method is optimal given the constraints of the problem.
