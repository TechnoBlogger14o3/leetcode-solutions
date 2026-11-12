# Longest Strictly Increasing or Strictly Decreasing Subarray (Easy)

**Problem ID:** 3105  
**Date:** 2026-11-12  
**Link:** https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/

## Approach

To solve the problem of finding the length of the longest strictly increasing or strictly decreasing subarray in a given array of integers, we can utilize a linear traversal approach. Here's the step-by-step breakdown of the solution:

### Main Idea
The core idea is to iterate through the array while maintaining two counters: one for the length of the current strictly increasing subarray and another for the current strictly decreasing subarray. As we traverse the array, we compare each element with the previous one to determine whether the current sequence is increasing, decreasing, or neither.

### Approach
1. **Initialization**: Start with two counters (`increasing_length` and `decreasing_length`) initialized to 1 (since a single element is a valid subarray). Also, maintain a variable (`max_length`) to keep track of the maximum length found.

2. **Iteration**: Loop through the array starting from the second element (index 1):
   - If the current element is greater than the previous element, increment the `increasing_length` counter and reset the `decreasing_length` to 1.
   - If the current element is less than the previous element, increment the `decreasing_length` counter and reset the `increasing_length` to 1.
   - If the current element is equal to the previous element, reset both counters to 1, as neither increasing nor decreasing conditions are satisfied.

3. **Update Maximum Length**: After each comparison, update the `max_length` to be the maximum of its current value, `increasing_length`, and `decreasing_length`.

4. **Return Result**: After completing the iteration, return the `max_length` as the result.

### Data Structures
- **Counters**: Use simple integer variables to track the lengths of the increasing and decreasing subarrays.
- **Variable for Maximum Length**: A single integer variable to store the maximum length found during the traversal.

### Complexity
- **Time Complexity**: O(n), where n is the length of the input array. This is because we make a single pass through the array.
- **Space Complexity**: O(1), as we are using a constant amount of extra space for the counters and the maximum length variable.

This approach efficiently finds the longest strictly increasing or decreasing subarray in a straightforward manner, leveraging a single traversal of the input array.
