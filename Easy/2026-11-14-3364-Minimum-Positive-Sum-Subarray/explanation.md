# Minimum Positive Sum Subarray  (Easy)

**Problem ID:** 3364  
**Date:** 2026-11-14  
**Link:** https://leetcode.com/problems/minimum-positive-sum-subarray/

## Approach

To solve the problem of finding the minimum positive sum of a subarray with a length between `l` and `r`, we can adopt a sliding window approach combined with a prefix sum technique. Here’s a concise breakdown of the approach:

### Main Idea:
1. **Prefix Sum Calculation**: We maintain a prefix sum array to efficiently compute the sum of any subarray. The prefix sum at index `i` represents the sum of elements from the start of the array up to index `i`.
2. **Sliding Window**: We iterate through the array while maintaining a window of valid subarray lengths (from `l` to `r`). For each possible subarray size, we calculate the sum using the prefix sum array and check if it is positive.
3. **Tracking Minimum Positive Sum**: As we compute the sums of the valid subarrays, we keep track of the minimum positive sum encountered.

### Steps:
1. **Compute Prefix Sums**: Create an array `prefix_sum` where `prefix_sum[i]` is the sum of the first `i` elements of `nums`.
2. **Iterate Over Possible Subarray Lengths**: For each starting index `i`, calculate the sums of subarrays of lengths from `l` to `r`. The sum of the subarray starting at index `i` and ending at index `j` can be computed as `prefix_sum[j] - prefix_sum[i-1]`.
3. **Check Conditions**: For each computed sum, check if it is greater than 0 and update the minimum positive sum if this sum is smaller than the current minimum.
4. **Return Result**: After checking all possible subarrays, return the minimum positive sum found, or `-1` if no valid subarray exists.

### Data Structures:
- **Prefix Sum Array**: To store cumulative sums for efficient range sum queries.
- **Variables**: To track the minimum positive sum.

### Complexity:
- **Time Complexity**: O(n * (r - l + 1)), where `n` is the length of the `nums` array. This is because for each starting index, we may check up to `r - l + 1` subarray lengths.
- **Space Complexity**: O(n) for storing the prefix sum array.

This approach efficiently narrows down the search for the minimum positive sum of subarrays within the specified constraints, ensuring that we consider only valid lengths and sums.
