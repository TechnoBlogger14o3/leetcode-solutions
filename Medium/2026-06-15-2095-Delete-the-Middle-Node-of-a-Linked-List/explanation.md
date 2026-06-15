# Delete the Middle Node of a Linked List (Medium)

**Problem ID:** 2095  
**Date:** 2026-06-15  
**Link:** https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

## Approach

To solve the problem of deleting the middle node from a linked list, we can follow a systematic approach that involves determining the middle node's position and then adjusting the pointers accordingly to remove it.

### Approach:

1. **Determine the Length of the Linked List**: 
   - First, we traverse the linked list to calculate its total length `n`. This allows us to identify the index of the middle node, which is given by `floor(n / 2)`.

2. **Identify the Middle Node**:
   - Once we have the length, we can compute the index of the middle node. For an even-length list, the middle node is defined as the node at index `n / 2` (0-based indexing).

3. **Traverse to the Node Before the Middle Node**:
   - We need to keep track of the node just before the middle node. This can be done by iterating through the list again, stopping at the node at index `middle_index - 1`.

4. **Delete the Middle Node**:
   - To remove the middle node, we adjust the `next` pointer of the node before the middle node to skip the middle node and point to the node after it. If the middle node is the head (in cases where `n = 1`), we simply return `null` or the next node as the new head.

### Data Structures:
- We use a singly linked list structure, which consists of nodes with a value and a pointer to the next node.

### Complexity:
- **Time Complexity**: O(n), where `n` is the number of nodes in the linked list. This is due to the need to traverse the list twice: once to calculate the length and once to find the node before the middle node.
- **Space Complexity**: O(1), as we are only using a constant amount of extra space for pointers and counters, regardless of the input size.

This approach efficiently handles the problem within the constraints provided, ensuring that we can operate on linked lists of significant size without excessive resource consumption.
