# Maximum Total Subarray Value I (Medium)

**Problem ID:** 3689  
**Date:** 2026-06-09  
**Link:** https://leetcode.com/problems/maximum-total-subarray-value-i/

## Approach

To solve the problem of maximizing the total subarray value by selecting exactly `k` non-empty subarrays, we can break down the approach as follows:

### Main Idea:
The value of a subarray is defined as the difference between its maximum and minimum elements. To maximize the total value across `k` selections, we should focus on identifying the maximum possible difference for the entire array, as the same subarray can be chosen multiple times. 

### Steps:
1. **Calculate Global Maximum and Minimum**: First, compute the maximum (`max_val`) and minimum (`min_val`) of the entire array. This will help us determine the maximum possible value of any single subarray, which is `max_val - min_val`.

2. **Total Value Calculation**: Since we can choose the same subarray multiple times, the total maximum value when selecting `k` subarrays is simply `k * (max_val - min_val)`. This is because each selection will yield the same maximum difference.

### Data Structures:
- No complex data structures are necessary beyond basic variables to hold the maximum and minimum values. The algorithm primarily involves linear scans to find these values.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array `nums`. This is due to the need to traverse the array once to find the maximum and minimum values.
- **Space Complexity**: O(1), since we only use a fixed amount of extra space for the maximum and minimum values.

### Conclusion:
This approach efficiently computes the desired result by leveraging the properties of the subarray values and the ability to select overlapping subarrays. The key insight is recognizing that the maximum total value can be derived from the global maximum and minimum of the entire array, multiplied by the number of selections `k`.
