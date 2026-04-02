# Maximum Amount of Money Robot Can Earn (Medium)

**Problem ID:** 3418  
**Date:** 2026-04-02  
**Link:** https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/

## Approach

To solve the problem of maximizing the amount of money the robot can earn while navigating through the grid, we can use a dynamic programming approach. 

### Main Idea:
The key is to maintain a dynamic programming table that tracks the maximum coins the robot can collect at each cell while considering the possibility of neutralizing up to 2 robbers. We will utilize a 3D DP array where `dp[i][j][k]` represents the maximum coins collected when reaching cell `(i, j)` with `k` neutralizations used (where `k` can be 0, 1, or 2).

### Approach:
1. **Initialization**: Start by initializing the DP table. The robot starts at `(0, 0)`, so set `dp[0][0][0]` to `coins[0][0]` if it's non-negative, or to `-inf` if it's negative (indicating an impossible state without neutralization).

2. **Filling the DP Table**:
   - Iterate through each cell `(i, j)` in the grid.
   - For each cell, calculate the maximum coins collectible from the top `(i-1, j)` and left `(i, j-1)` cells for each neutralization state `k`.
   - Depending on the value in `coins[i][j]`:
     - If it's positive, simply add it to the maximum coins from the previous cells.
     - If it's negative, check if neutralization is possible:
       - If `k` is 0, the robot cannot neutralize, so the value is subtracted from the total.
       - If `k` is 1 or 2, calculate the maximum coins by neutralizing the robbery (i.e., treat the negative value as 0 for that cell).

3. **Final Result**: The result will be the maximum value found in the last cell `(m-1, n-1)` across all neutralization states (0, 1, and 2).

### Data Structures:
- A 3D array `dp[m][n][3]` to keep track of the maximum coins collected at each cell with different states of neutralization.

### Complexity:
- **Time Complexity**: O(m * n), as we iterate through each cell and perform constant-time operations for each of the three neutralization states.
- **Space Complexity**: O(m * n), for storing the DP table.

By following this structured approach, we ensure that we explore all potential paths the robot can take while maximizing the coins collected, effectively handling the constraints of robbers and neutralizations.
