# Check if Array Is Sorted and Rotated (Easy)

**Problem ID:** 1752  
**Date:** 2026-05-23  
**Link:** https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

## Approach

To solve the problem of checking if an array is sorted and rotated, we can follow a straightforward approach based on identifying the number of "drops" in the array. A "drop" occurs when an element is greater than the subsequent element, indicating a potential rotation point.

### Approach:

1. **Count Drops**: Iterate through the array and count how many times the current element is greater than the next element. This can be done in a single pass by checking the condition `nums[i] > nums[i + 1]` for each index `i`, and considering the circular nature of the array by also checking the last element against the first one.

2. **Evaluate Conditions**:
   - If there are **more than one drop**, the array cannot be sorted and rotated, so return `false`.
   - If there are **zero drops**, the array is already sorted, hence return `true`.
   - If there is **exactly one drop**, check if the last element is less than or equal to the first element to ensure continuity after the rotation.

### Data Structures:
- We only need a few variables to keep track of the count of drops and the length of the array, making this approach space-efficient.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the array. We make a single pass through the array.
- **Space Complexity**: O(1), as we are using a constant amount of extra space.

This approach efficiently determines whether the array can be considered as sorted and rotated by leveraging the properties of sorted arrays and their rotations.
