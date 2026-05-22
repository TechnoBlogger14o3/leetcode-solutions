# Search in Rotated Sorted Array (Medium)

**Problem ID:** 33  
**Date:** 2026-05-22  
**Link:** https://leetcode.com/problems/search-in-rotated-sorted-array/

## Approach

To solve the "Search in Rotated Sorted Array" problem, we can leverage a modified binary search approach due to the properties of the rotated sorted array. The main idea is to identify which part of the array is sorted and use that information to narrow down the search space effectively.

### Approach:

1. **Identify the Rotation Point**: The array is sorted but rotated, meaning that there are two sorted subarrays. We can determine which half of the array is sorted by comparing the middle element with the left and right boundaries.

2. **Binary Search Logic**:
   - Start with two pointers, `left` and `right`, initialized to the start and end of the array, respectively.
   - While `left` is less than or equal to `right`, compute the `mid` index.
   - Check if the `mid` element is the target. If it is, return the `mid` index.
   - Determine which half of the array is sorted:
     - If the left half (`nums[left]` to `nums[mid]`) is sorted:
       - Check if the target lies within this range. If it does, narrow the search to the left half by setting `right = mid - 1`. Otherwise, search the right half by setting `left = mid + 1`.
     - If the right half (`nums[mid]` to `nums[right]`) is sorted:
       - Similarly, check if the target is within this range. If it is, adjust `left` to `mid + 1`, otherwise adjust `right` to `mid - 1`.

3. **Termination**: The loop continues until the target is found or the search space is exhausted. If the target is not found, return -1.

### Data Structures:
- The primary data structure used is the array `nums`, along with two integer pointers (`left` and `right`) to manage the search space.

### Complexity:
- **Time Complexity**: O(log n), since we effectively halve the search space with each iteration of the binary search.
- **Space Complexity**: O(1), as we are using a constant amount of space for pointers and variables.

This approach efficiently finds the target in a rotated sorted array while adhering to the required time complexity constraints.
