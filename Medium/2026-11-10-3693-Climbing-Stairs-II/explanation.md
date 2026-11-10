# Climbing Stairs II (Medium)

**Problem ID:** 3693  
**Date:** 2026-11-10  
**Link:** https://leetcode.com/problems/climbing-stairs-ii/

## Approach

To solve the "Climbing Stairs II" problem, we can utilize a dynamic programming approach. The main idea is to maintain an array `dp` where `dp[i]` represents the minimum cost to reach step `i`. 

### Approach:
1. **Initialization**: Start by initializing `dp[0]` to 0, as the cost to start at step 0 is zero. For other steps, initialize `dp[i]` to a large value (infinity) since we will be calculating the minimum cost.

2. **State Transition**: For each step `i` from 0 to `n`, calculate the cost to reach the next steps (i + 1, i + 2, i + 3) if they are within bounds. The cost to jump from step `i` to step `j` (where `j` can be `i + 1`, `i + 2`, or `i + 3`) is given by:
   \[
   \text{cost}(i, j) = \text{costs}[j] + (j - i)^2
   \]
   Update the `dp[j]` as follows:
   \[
   dp[j] = \min(dp[j], dp[i] + \text{cost}(i, j))
   \]

3. **Final Result**: The answer will be found in `dp[n]`, which gives the minimum cost to reach the last step.

### Data Structures:
- An array `dp` of size `n + 1` to store the minimum costs for each step.

### Complexity:
- **Time Complexity**: O(n), since we iterate through each step and perform a constant amount of work for each of the next three possible jumps.
- **Space Complexity**: O(n), due to the storage of the `dp` array.

This approach efficiently calculates the minimum cost to reach the top of the staircase while adhering to the jump constraints and cost calculations defined in the problem statement.
