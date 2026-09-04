# Smallest Stable Index I (Easy)

**Problem ID:** 3903  
**Date:** 2026-09-04  
**Link:** https://leetcode.com/problems/smallest-stable-index-i/

## Approach

To solve the problem of finding the smallest stable index in the given array `nums`, we can adopt the following approach:

### Problem Breakdown
1. **Understanding Instability Score**: For each index `i`, the instability score is defined as:
   \[
   \text{instability\_score}(i) = \max(nums[0..i]) - \min(nums[i..n-1])
   \]
   We need to compute this score for each index and check if it is less than or equal to `k`.

2. **Stable Index Definition**: An index `i` is stable if its instability score is less than or equal to `k`. Our goal is to find the smallest such index.

### Approach
1. **Precomputation**:
   - **Max Array**: Create an array `max_left` where `max_left[i]` holds the maximum value from the start of the array up to index `i`. This can be built in a single pass through the array.
   - **Min Array**: Create an array `min_right` where `min_right[i]` holds the minimum value from index `i` to the end of the array. This can also be built in a single pass, but in reverse.

2. **Calculate Instability Scores**:
   - Iterate through each index `i` from `0` to `n-1`, and for each index, compute the instability score using the precomputed `max_left` and `min_right` arrays:
   \[
   \text{instability\_score}(i) = \max\_left[i] - \min\_right[i]
   \]

3. **Check Stability**:
   - During the iteration, check if the instability score is less than or equal to `k`. If it is, return the current index `i` as the smallest stable index.

4. **Return Result**:
   - If no stable index is found after checking all indices, return `-1`.

### Data Structures
- Two arrays (`max_left` and `min_right`) of length `n` are used to store the maximum and minimum values respectively, which allows for efficient computation of instability scores.

### Complexity Analysis
- **Time Complexity**: The solution runs in O(n) time due to the linear passes to compute `max_left`, `min_right`, and to check instability scores.
- **Space Complexity**: The space complexity is O(n) for storing the `max_left` and `min_right` arrays.

This approach efficiently computes the required instability scores and checks for stability, ensuring that we find the smallest stable index or determine that none exists.
