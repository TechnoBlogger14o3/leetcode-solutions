# Delete Nodes From Linked List Present in Array (Medium)

**Problem ID:** 3217  
**Date:** 2025-11-01  
**Link:** https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/

## Approach

To solve the problem of deleting nodes from a linked list that have values present in a given array, we can follow a systematic approach:

### Main Idea:
The core idea is to traverse the linked list while maintaining a reference to the previous node. For each node, we check if its value exists in the provided array. If it does, we skip that node by adjusting the `next` pointer of the previous node. If it doesn't, we simply move the previous pointer to the current node. This way, we effectively remove nodes from the linked list without needing to create a new list.

### Data Structures:
1. **Linked List**: We are given a singly linked list where each node contains a value and a pointer to the next node.
2. **Set**: To efficiently check if a node's value exists in the array `nums`, we can convert `nums` into a set. This allows for O(1) average time complexity for lookups.

### Steps:
1. Convert the input array `nums` into a set for fast membership checking.
2. Initialize a dummy node that points to the head of the linked list. This helps simplify edge cases, such as removing the head node.
3. Use two pointers: one (`prev`) to track the last node that was kept and another (`current`) to traverse the linked list.
4. Iterate through the linked list:
   - If the value of the `current` node is in the set, skip this node by setting `prev.next` to `current.next`.
   - If the value is not in the set, move the `prev` pointer to `current`.
5. Move the `current` pointer to the next node in each iteration.
6. Finally, return the modified list starting from the node next to the dummy node.

### Complexity:
- **Time Complexity**: O(n + m), where n is the number of nodes in the linked list and m is the number of elements in the array `nums`. Creating the set takes O(m) time, and traversing the linked list takes O(n) time.
- **Space Complexity**: O(m) for storing the elements of `nums` in a set.

This approach efficiently modifies the linked list in a single pass while ensuring that we handle all edge cases, such as the removal of the head node or consecutive nodes with values in `nums`.
