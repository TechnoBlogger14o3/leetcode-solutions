# Minimum Removals to Balance Array (Medium)

**Problem ID:** 3634  
**Date:** 2026-02-06  
**Link:** https://leetcode.com/problems/minimum-removals-to-balance-array/

## Approach

To solve the "Minimum Removals to Balance Array" problem, we can leverage a two-pointer technique after sorting the input array. The main idea is to identify the longest contiguous subarray where the maximum element is at most \( k \) times the minimum element. This approach allows us to minimize the number of removals required to achieve a balanced array.

### Approach:

1. **Sorting**: First, sort the array `nums`. This ensures that for any subarray, the minimum element is at the start and the maximum element is at the end, simplifying the comparison.

2. **Two-Pointer Technique**: Use two pointers, `left` and `right`, to explore the array:
   - Initialize `left` at the start of the array and `right` also at the start.
   - Increment `right` to expand the window while checking the condition \( \text{nums[right]} \leq k \times \text{nums[left]} \).
   - If the condition is violated (i.e., \( \text{nums[right]} > k \times \text{nums[left]} \)), increment `left` to shrink the window from the left until the condition holds again.

3. **Tracking Maximum Length**: Throughout this process, keep track of the maximum length of the valid subarray found. The number of removals required will be the total number of elements minus the length of this longest valid subarray.

4. **Edge Cases**: Handle cases where the array has only one element, as it is inherently balanced.

### Data Structures:
- An array to hold the input numbers.
- Two integer pointers (`left` and `right`) to manage the current window of examination.

### Complexity:
- **Time Complexity**: \( O(n \log n) \) due to the sorting step, where \( n \) is the length of the array. The two-pointer traversal is \( O(n) \), but the sorting dominates the overall complexity.
- **Space Complexity**: \( O(1) \) additional space if we consider the input array as part of the input space, or \( O(n) \) for the sorted array if we count the sorting space.

This approach efficiently finds the minimum number of removals required to balance the array while ensuring that we only traverse the array a limited number of times.
