# Find Minimum in Rotated Sorted Array II (Hard)

**Problem ID:** 154  
**Date:** 2026-05-16  
**Link:** https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

## Approach

To solve the problem of finding the minimum in a rotated sorted array that may contain duplicates, we can utilize a modified binary search approach. The key steps in the solution are as follows:

1. **Understanding the Problem**: The input array is sorted and then rotated, which means there are two sorted subarrays. The minimum element will be the point where the order breaks. However, duplicates complicate the identification of the pivot point.

2. **Binary Search Approach**: We will employ a binary search to efficiently locate the minimum element. The main idea is to maintain two pointers, `left` and `right`, which represent the current search boundaries.

3. **Conditions to Check**:
   - Calculate the middle index `mid` as `(left + right) // 2`.
   - Compare the middle element `nums[mid]` with the elements at the `left` and `right` pointers.
     - If `nums[mid]` is greater than `nums[left]`, it indicates that the left half is sorted, and the minimum must be in the right half (i.e., set `left = mid + 1`).
     - If `nums[mid]` is less than `nums[right]`, it indicates that the right half is sorted, and the minimum must be in the left half (i.e., set `right = mid`).
     - If `nums[mid]` is equal to `nums[left]` or `nums[right]`, we cannot determine which side is sorted, so we can safely increment `left` or decrement `right` to narrow down the search space. This step handles the duplicates.

4. **Termination**: The loop continues until `left` equals `right`, at which point the minimum element will be found at `nums[left]`.

5. **Time Complexity**: In the worst case, due to the presence of duplicates, the time complexity can degrade to O(n), where n is the number of elements in the array. However, on average, the complexity remains O(log n) when the array has fewer duplicates.

6. **Space Complexity**: The space complexity is O(1) since we are using a constant amount of extra space regardless of the input size.

By following this approach, we efficiently find the minimum element in the rotated sorted array while effectively handling duplicates.
