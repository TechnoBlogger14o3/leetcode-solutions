# Max Dot Product of Two Subsequences (Hard)

**Problem ID:** 1458  
**Date:** 2026-01-08  
**Link:** https://leetcode.com/problems/max-dot-product-of-two-subsequences/

## Approach

To solve the problem of finding the maximum dot product of two non-empty subsequences from the given arrays `nums1` and `nums2`, we can employ a dynamic programming approach. Here’s a concise explanation of the solution:

### Main Idea
The objective is to compute the maximum dot product of subsequences of equal length from both arrays. The dot product of two sequences is defined as the sum of the products of their corresponding elements. To achieve this, we need to explore all possible subsequences while ensuring they are of the same length.

### Dynamic Programming Approach
1. **State Definition**: We define a 2D DP table `dp[i][j]` where `i` ranges over the indices of `nums1` and `j` ranges over the indices of `nums2`. The value `dp[i][j]` represents the maximum dot product obtainable using the first `i` elements of `nums1` and the first `j` elements of `nums2`.

2. **Base Case**: Initialize `dp[0][0]` to 0, as the dot product of two empty subsequences is 0. However, since we need non-empty subsequences, we will later handle the cases where we take the first elements of either sequence.

3. **Recurrence Relation**:
   - For each pair of indices `(i, j)`, we have several choices:
     - **Skip the current element of `nums1`**: This leads to `dp[i-1][j]`.
     - **Skip the current element of `nums2`**: This leads to `dp[i][j-1]`.
     - **Take both current elements**: This contributes `nums1[i-1] * nums2[j-1]` plus the maximum dot product of the previous elements, which gives us `dp[i-1][j-1] + nums1[i-1] * nums2[j-1]`.
   - Thus, the recurrence relation can be expressed as:
     ```
     dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1] + nums1[i-1] * nums2[j-1])
     ```

4. **Final Result**: The maximum dot product will be found in the last cell of the DP table, `dp[len(nums1)][len(nums2)]`.

### Data Structures
- A 2D list (array) `dp` of size `(len(nums1) + 1) x (len(nums2) + 1)` is used to store intermediate results.

### Complexity
- **Time Complexity**: O(m * n), where `m` is the length of `nums1` and `n` is the length of `nums2`. This is due to the nested loops iterating through both dimensions of the DP table.
- **Space Complexity**: O(m * n) for the DP table. However, if space optimization is needed, we can reduce this to O(min(m, n)) by using only two rows (current and previous).

This approach effectively computes the maximum dot product of non-empty subsequences with the same length while maintaining efficient time and space complexity.
