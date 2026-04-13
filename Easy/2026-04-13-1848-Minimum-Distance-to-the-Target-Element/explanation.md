# Minimum Distance to the Target Element (Easy)

**Problem ID:** 1848  
**Date:** 2026-04-13  
**Link:** https://leetcode.com/problems/minimum-distance-to-the-target-element/

## Approach

To solve the problem of finding the minimum distance to a target element in an array, we can adopt a straightforward approach that leverages a linear search.

### Main Idea:
The goal is to find the index `i` where `nums[i]` equals `target` and minimize the absolute difference `abs(i - start)`. Since the problem guarantees that the target exists in the array, we can iterate through the array to locate all occurrences of the target and compute the distances.

### Approach:
1. **Initialization**: Start by initializing a variable to hold the minimum distance found, which can be set to a large value (e.g., the length of the array).
  
2. **Linear Search**: Iterate through the array `nums` using a loop. For each index `i`, check if `nums[i]` is equal to `target`.
   - If it is, calculate the distance `abs(i - start)`.
   - Update the minimum distance if the calculated distance is smaller than the current minimum.

3. **Return Result**: After completing the iteration, return the minimum distance found.

### Data Structures:
- A simple integer variable to keep track of the minimum distance.
- The input array `nums` is used directly without any additional data structures since we only need to traverse it once.

### Complexity:
- **Time Complexity**: O(n), where `n` is the length of the input array `nums`. We traverse the array once to find the target indices.
- **Space Complexity**: O(1), as we only use a fixed amount of extra space regardless of the input size.

This approach is efficient given the constraints, and it effectively finds the minimum distance to the target element in a single pass through the array.
