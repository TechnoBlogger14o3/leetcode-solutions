# Left and Right Sum Differences (Easy)

**Problem ID:** 2574  
**Date:** 2026-06-06  
**Link:** https://leetcode.com/problems/left-and-right-sum-differences/

## Approach

To solve the problem of calculating the left and right sum differences for each index in the given array `nums`, we can follow a systematic approach:

### Approach:

1. **Understanding Left and Right Sums**:
   - For each index `i`, `leftSum[i]` is the sum of all elements before `i`, and `rightSum[i]` is the sum of all elements after `i`.
   - The goal is to compute the absolute difference between these two sums for each index.

2. **Using Prefix Sums**:
   - Instead of explicitly creating two separate arrays for `leftSum` and `rightSum`, we can compute the sums in a single pass.
   - We can maintain a running total for `leftSum` as we iterate through the array. This will allow us to calculate `rightSum` on-the-fly by subtracting the current element and the accumulated `leftSum` from the total sum of the array.

3. **Steps**:
   - First, calculate the total sum of the array `nums`.
   - Initialize `leftSum` to 0 and create an empty result array `answer`.
   - Loop through each element in `nums`:
     - Compute `rightSum` as `total_sum - leftSum - nums[i]`.
     - Calculate the absolute difference `|leftSum - rightSum|` and append it to `answer`.
     - Update `leftSum` by adding the current element `nums[i]` to it.

4. **Data Structures**:
   - An integer variable for `total_sum`, `leftSum`, and an array `answer` to store the results.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array `nums`. We make a single pass to compute the total sum and another pass to compute the differences.
- **Space Complexity**: O(n) for the output array `answer`. We use a constant amount of extra space for variables.

This approach efficiently computes the required differences without the need for additional storage for `leftSum` and `rightSum`, making it both time-efficient and space-efficient.
