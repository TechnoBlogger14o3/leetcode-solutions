# Smallest Stable Index II (Medium)

**Problem ID:** 3904  
**Date:** 2026-09-05  
**Link:** https://leetcode.com/problems/smallest-stable-index-ii/

## Approach

To solve the "Smallest Stable Index II" problem, we need to efficiently compute the instability score for each index in the given array `nums` and determine the smallest index where the score is less than or equal to `k`.

### Approach:

1. **Understanding Instability Score**:
   The instability score for an index `i` is defined as:
   \[
   \text{instability\_score}(i) = \max(nums[0..i]) - \min(nums[i..n-1])
   \]
   This means we need to find the maximum value from the start of the array up to index `i`, and the minimum value from index `i` to the end of the array.

2. **Pre-computation of Maximums and Minimums**:
   - We can precompute the maximum values for each index `i` in a single pass from left to right. This gives us an array `max_left` where `max_left[i]` holds the maximum value from `nums[0]` to `nums[i]`.
   - Similarly, we can precompute the minimum values for each index `i` in a single pass from right to left. This gives us an array `min_right` where `min_right[i]` holds the minimum value from `nums[i]` to `nums[n-1]`.

3. **Iterate to Find the Smallest Stable Index**:
   - With the `max_left` and `min_right` arrays ready, we can iterate through each index `i` to compute the instability score:
   \[
   \text{instability\_score}(i) = \text{max\_left}[i] - \text{min\_right}[i]
   \]
   - If this score is less than or equal to `k`, we check if it's the smallest index found so far.

4. **Return Result**:
   - If we find a stable index, we return the smallest one. If no such index exists after checking all indices, we return -1.

### Data Structures:
- Two arrays (`max_left` and `min_right`) of size `n` are used to store the computed maximum and minimum values.

### Complexity:
- **Time Complexity**: O(n), where `n` is the length of the input array. This is because we make three passes over the array: one for `max_left`, one for `min_right`, and one for checking the instability scores.
- **Space Complexity**: O(n) for storing the `max_left` and `min_right` arrays.

This approach ensures that we efficiently compute the required values without redundant calculations, making it suitable for the problem's constraints.
