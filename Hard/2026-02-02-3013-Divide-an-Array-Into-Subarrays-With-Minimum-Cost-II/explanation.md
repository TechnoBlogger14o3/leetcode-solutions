# Divide an Array Into Subarrays With Minimum Cost II (Hard)

**Problem ID:** 3013  
**Date:** 2026-02-02  
**Link:** https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/

## Approach

To solve the problem of dividing an array into subarrays with minimum cost, we can employ a dynamic programming approach combined with a sliding window technique. Here's a concise breakdown of the solution:

### Problem Breakdown
1. **Understanding Cost**: The cost of a subarray is defined as the first element of that subarray. Therefore, our goal is to minimize the sum of the first elements of the chosen subarrays.

2. **Dynamic Programming State**: We define a DP array `dp[i][j]` where `i` represents the number of subarrays formed up to index `j` in `nums`. The value `dp[i][j]` will store the minimum cost to divide the first `j` elements into `i` subarrays.

3. **Transition**: To fill `dp[i][j]`, we need to consider all possible starting points for the last subarray, which can start from any index `p` such that `j - p <= dist`. This means we can only consider the last subarray starting from the indices that are within the range defined by `dist`.

4. **Sliding Window**: To efficiently compute the minimum cost while considering the constraints, we can maintain a sliding window of potential starting points for the last subarray. This allows us to quickly find the minimum cost of forming `i-1` subarrays up to index `p-1` and add the cost of the new subarray starting from `p`.

5. **Initialization**: The base case is `dp[0][0] = 0` (cost of zero subarrays) and `dp[i][0] = ∞` for all `i > 0` since we cannot form subarrays without elements.

6. **Final Result**: The answer will be found in `dp[k][j]` for all valid `j`, where `k` is the number of required subarrays.

### Complexity
- **Time Complexity**: The overall time complexity is O(n * k) due to the nested loops for filling the DP table, where `n` is the length of `nums` and `k` is the number of subarrays. The sliding window helps reduce redundant calculations.
- **Space Complexity**: The space complexity is O(n * k) for the DP table. However, we can optimize this to O(k) by only keeping track of the last row of the DP table at any time.

### Summary
In summary, the approach leverages dynamic programming to systematically explore the different ways to divide the array while ensuring the constraints on indices are respected. The sliding window technique optimizes the search for minimum costs, making the solution efficient enough to handle the upper limits of the problem's constraints.
