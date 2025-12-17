# Best Time to Buy and Sell Stock V (Medium)

**Problem ID:** 3573  
**Date:** 2025-12-17  
**Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v/

## Approach

To solve the "Best Time to Buy and Sell Stock V" problem, we can use a dynamic programming approach. The main idea is to maintain a DP table that tracks the maximum profit achievable with a given number of transactions up to each day.

### Approach:

1. **Define the DP Table**:
   - Let `dp[t][d]` represent the maximum profit achievable with `t` transactions by the end of day `d`.
   - We need to fill this table for `t` ranging from `0` to `k` and `d` ranging from `0` to `n-1` (where `n` is the length of the prices array).

2. **Base Cases**:
   - If `t = 0` (no transactions), then `dp[0][d] = 0` for all `d` since no profit can be made.
   - If `d = 0` (only the first day), then `dp[t][0] = 0` for all `t` since no transactions can occur.

3. **Transition**:
   - For each transaction `t` from `1` to `k`, and for each day `d` from `1` to `n-1`, we need to compute `dp[t][d]`.
   - The maximum profit can be computed as:
     \[
     dp[t][d] = \max(dp[t][d-1], prices[d] - prices[m] + dp[t-1][m])
     \]
     where `m` ranges from `0` to `d-1`. This considers two scenarios: not making a transaction on day `d` (thus taking the value from the previous day) and making a transaction by selling on day `d` after buying on any previous day `m`.

4. **Optimization**:
   - To optimize the inner computation of the maximum profit when making a transaction, we can maintain a variable `max_diff` that stores the maximum value of `dp[t-1][m] - prices[m]` as we iterate through days. This allows us to avoid the nested loop for `m`, reducing the time complexity.

5. **Final Result**:
   - The result will be found in `dp[k][n-1]`, which gives the maximum profit achievable with at most `k` transactions by the end of the last day.

### Data Structures:
- A 2D array `dp` of size `(k+1) x n` to store the maximum profits.

### Complexity:
- **Time Complexity**: O(k * n), where `k` is the number of transactions and `n` is the number of days (length of the prices array).
- **Space Complexity**: O(k * n) for the DP table. However, this can be optimized to O(n) by only keeping track of the previous transaction results.

This structured approach effectively utilizes dynamic programming to solve the problem while managing the complexities of both buying and selling transactions.
