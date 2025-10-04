# Container With Most Water (Medium)

**Problem ID:** 11  
**Date:** 2025-10-04  
**Link:** https://leetcode.com/problems/container-with-most-water/

## Approach

To solve the "Container With Most Water" problem, we can utilize a two-pointer approach, which is efficient and optimal for this scenario.

### Problem Understanding:
The goal is to find two vertical lines from the given array that, together with the x-axis, form a container that can hold the maximum amount of water. The water held by the container is determined by the shorter of the two lines and the distance between them.

### Approach:
1. **Two-Pointer Technique**: 
   - Initialize two pointers: `left` at the beginning (index 0) and `right` at the end (index n-1) of the array.
   - Calculate the area formed by the lines at these two pointers. The area can be computed using the formula:
     \[
     \text{Area} = \text{min}(height[left], height[right]) \times (right - left)
     \]
   - Keep track of the maximum area encountered.

2. **Pointer Adjustment**:
   - To potentially find a larger area, we need to adjust the pointers:
     - If the height at the `left` pointer is less than the height at the `right` pointer, increment the `left` pointer (move it to the right).
     - Otherwise, decrement the `right` pointer (move it to the left).
   - This adjustment is based on the fact that moving the pointer pointing to the shorter line might lead to a taller line, which could increase the area.

3. **Iteration**:
   - Continue this process until the two pointers meet. During each iteration, update the maximum area if the current area is greater than the previously recorded maximum.

### Data Structures:
- The primary data structure used is the integer array `height`, which stores the heights of the vertical lines.
- Two integer variables are used for the pointers (`left` and `right`) and one for tracking the maximum area.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the `height` array. Each element is processed at most twice (once by each pointer).
- **Space Complexity**: O(1), as we are using a constant amount of extra space regardless of the input size.

This two-pointer approach efficiently narrows down the potential maximum area without needing to check every possible pair of lines, making it suitable for the constraints provided in the problem.
