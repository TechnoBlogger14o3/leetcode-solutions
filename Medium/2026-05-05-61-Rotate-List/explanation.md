# Rotate List (Medium)

**Problem ID:** 61  
**Date:** 2026-05-05  
**Link:** https://leetcode.com/problems/rotate-list/

## Approach

To solve the "Rotate List" problem, we can follow a systematic approach that involves understanding the structure of the linked list and how rotation affects its nodes.

### Main Idea:
The primary goal is to rotate the linked list to the right by `k` positions. This can be visualized as moving the last `k` nodes to the front of the list. However, since `k` can be larger than the length of the list, we need to adjust `k` to be within the bounds of the list's length.

### Steps to Approach:
1. **Calculate the Length**: First, traverse the linked list to determine its length (`n`). This is essential because rotating by `k` where `k >= n` results in the same list as rotating by `k % n`.

2. **Adjust `k`**: Compute the effective rotation using `k = k % n`. If `k` is `0` after this calculation, the list remains unchanged, and we can return the original head.

3. **Find the New Tail and Head**: 
   - Traverse the list again to find the new tail, which will be the `(n - k - 1)`-th node from the head. 
   - The new head will be the `(n - k)`-th node.
   - To achieve this, maintain a pointer that moves through the list until reaching the new tail.

4. **Rearrange Pointers**: 
   - Set the next pointer of the new tail to `null` to terminate the list.
   - Connect the original tail (the last node of the list) to the original head, effectively linking the end of the list back to the start.

5. **Return the New Head**: Finally, return the new head of the rotated list.

### Data Structures:
- A singly linked list is used to represent the nodes, where each node contains a value and a pointer to the next node.

### Complexity:
- **Time Complexity**: O(n), where `n` is the number of nodes in the linked list. We traverse the list a couple of times, but each traversal is linear.
- **Space Complexity**: O(1), since we are only using a constant amount of extra space for pointers, regardless of the input size.

By following these steps, we can efficiently rotate the linked list as required by the problem statement.
