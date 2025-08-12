# Ways to Express an Integer as Sum of Powers

## Problem Description
Given two integers `n` and `x`, return the number of ways to express `n` as the sum of unique powers of `x`. Since the answer can be very large, return it modulo `10^9 + 7`.

## Approach
This is a classic dynamic programming problem where we need to find all possible combinations of powers that sum to `n`.

### Key Insights
1. **Power Generation**: We need to consider all possible bases from 1 to n, raised to the power x
2. **Unique Powers**: Each power can only be used once in a combination
3. **Dynamic Programming**: Use a 2D DP array where `dp[i][j]` represents the number of ways to express sum `i` using powers up to base `j^x`

### Algorithm
1. **Initialize DP Array**: Create a 2D array `dp[n+1][n+1]` initialized to 0
2. **Base Case**: `dp[0][0] = 1` (one way to express 0 - empty sum)
3. **Fill DP Array**:
   - For each sum from 0 to n
   - For each base from 1 to n
   - Calculate `power = base^x`
   - If `power > sum`: can't use this power, copy from previous base
   - If `power <= sum`: can either use or not use this power
     - Not use: `dp[sum][base-1]`
     - Use: `dp[sum-power][base-1]`
4. **Return Result**: `dp[n][n]` gives the final answer

### Time Complexity
- **Time**: O(n²) - we fill a 2D DP array of size n×n
- **Space**: O(n²) - for the DP array

### Space Optimization
We can optimize space to O(n) by using only 1D arrays since we only need the previous row to compute the current row.

## Example
For `n = 4, x = 2`:
- Powers available: 1²=1, 2²=4, 3²=9, 4²=16
- Ways to express 4:
  1. 4 (using 2²)
  2. 1 + 1 + 1 + 1 (using four 1²)
  3. 1 + 1 + 2 (using two 1² and one 2²)
- Total: 3 ways

## Code Structure
The solution uses a bottom-up DP approach with clear separation of concerns:
1. Power calculation
2. DP array filling
3. Result computation

This approach ensures we don't miss any valid combinations and handles the modulo arithmetic correctly.
