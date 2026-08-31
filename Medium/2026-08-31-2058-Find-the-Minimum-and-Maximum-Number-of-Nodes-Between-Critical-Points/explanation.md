# Find the Minimum and Maximum Number of Nodes Between Critical Points (Medium)

**Problem ID:** 2058  
**Date:** 2026-08-31  
**Link:** https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

## Approach

To solve the problem of finding the minimum and maximum number of nodes between critical points in a linked list, we can follow these steps:

### Approach:

1. **Understanding Critical Points**: 
   - A critical point is defined as a local maxima or minima. We need to identify nodes that are either greater than their neighbors (local maxima) or less than their neighbors (local minima).
   - A node can only be a critical point if it has both a previous and a next node.

2. **Iterate Through the Linked List**:
   - Traverse the linked list while keeping track of the current node, the previous node, and the next node.
   - For each node (starting from the second node and ending at the second-to-last node), check if it qualifies as a local maxima or minima by comparing it with its adjacent nodes.

3. **Store Critical Points**:
   - Maintain a list to store the indices (or positions) of the critical points found during the traversal.

4. **Calculate Distances**:
   - If fewer than two critical points are found, return `[-1, -1]`.
   - If two or more critical points are found, compute the minimum distance as the smallest difference between consecutive critical point indices and the maximum distance as the difference between the first and last critical point indices.

### Data Structures:
- A simple list (or array) can be used to store the indices of the critical points.
- Variables to keep track of the previous, current, and next nodes during the traversal.

### Complexity:
- **Time Complexity**: O(n), where n is the number of nodes in the linked list. We make a single pass through the list to identify critical points.
- **Space Complexity**: O(k), where k is the number of critical points stored, which in the worst case could be O(n) if all nodes are critical points, but typically it will be much smaller.

By following this structured approach, we can efficiently determine the required distances between critical points in the linked list.
