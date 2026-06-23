# Number of ZigZag Arrays I (Hard)

**Problem ID:** 3699  
**Date:** 2026-06-23  
**Link:** https://leetcode.com/problems/number-of-zigzag-arrays-i/

## Approach

To solve the problem of counting valid ZigZag arrays of length `n` within the range `[l, r]`, we can use dynamic programming (DP) to systematically build up the solution.

### Approach:

1. **Define the State**:
   We will maintain a DP table `dp[i][j][k]` where:
   - `i` represents the current length of the array being constructed (from `1` to `n`).
   - `j` represents the last element of the array (values from `l` to `r`).
   - `k` indicates the trend of the last two elements: 
     - `0` for "last was increasing"
     - `1` for "last was decreasing"
     - `2` for "last was neutral" (i.e., equal)

2. **Base Case**:
   For arrays of length `1`, we can initialize `dp[1][j][2] = 1` for all `j` in the range `[l, r]`, since any single element is trivially valid.

3. **Transition**:
   For each length `i` from `2` to `n`, and for each possible last element `j` in `[l, r]`:
   - If the last two elements are increasing (`k = 0`), the current element can be any value less than `j` (to maintain the ZigZag property). This means we can sum up all valid configurations from the previous length where the last element was less than `j`.
   - If the last two elements are decreasing (`k = 1`), the current element can be any value greater than `j`.
   - If the last two elements are neutral (`k = 2`), the current element can be any value that is not equal to `j`.

4. **Final Count**:
   The final answer will be the sum of all valid configurations for arrays of length `n`, across all possible last elements and trends.

### Data Structures:
- A 3D DP array `dp` to store the counts of valid configurations.
- Additional variables to manage the summation of valid previous states efficiently.

### Complexity:
- **Time Complexity**: The approach runs in `O(n * (r - l + 1)^2)`, which is feasible within the provided constraints (with `n` up to `2000` and `r-l` also up to `2000`).
- **Space Complexity**: The space complexity is `O(n * (r - l + 1) * 3)` due to the DP table.

By using this structured approach, we can efficiently count the number of valid ZigZag arrays while adhering to the constraints provided in the problem.
