# Find Minimum in Rotated Sorted Array (Medium)

**Problem ID:** 153  
**Date:** 2026-05-15  
**Link:** https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

## Approach

To solve the problem of finding the minimum in a rotated sorted array, we can leverage a binary search approach, which allows us to achieve the required O(log n) time complexity. 

### Main Idea:
The key insight is to utilize the properties of the rotated sorted array. In such an array, there are two sorted subarrays: one that contains elements greater than the pivot (the largest element) and one that contains elements less than the pivot (the smallest element). The minimum element will always be found in the subarray that is not sorted.

### Approach:
1. **Initialization**: Start with two pointers, `left` and `right`, initialized to the start and end of the array, respectively.

2. **Binary Search**:
   - While `left` is less than `right`, calculate the middle index `mid`.
   - Compare the middle element `nums[mid]` with the element at the `right` pointer `nums[right]`.
     - If `nums[mid]` is greater than `nums[right]`, it indicates that the minimum value must be in the right half of the array (i.e., between `mid + 1` and `right`). Thus, update `left` to `mid + 1`.
     - If `nums[mid]` is less than or equal to `nums[right]`, it indicates that the minimum value is in the left half (including `mid`), so update `right` to `mid`.

3. **Termination**: The loop continues until `left` equals `right`, at which point `left` (or `right`) will point to the minimum element in the array.

### Data Structures:
- The algorithm primarily utilizes the input array `nums` and two integer variables (`left` and `right`) to track the search space.

### Complexity:
- **Time Complexity**: O(log n) due to the binary search mechanism, which effectively halves the search space with each iteration.
- **Space Complexity**: O(1) as it uses a constant amount of extra space.

This approach efficiently narrows down the search for the minimum element by exploiting the properties of the rotated sorted array, ensuring optimal performance.
