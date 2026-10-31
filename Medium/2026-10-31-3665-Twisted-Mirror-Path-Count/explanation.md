# Twisted Mirror Path Count (Medium)

**Problem ID:** 3665  
**Date:** 2026-10-31  
**Link:** https://leetcode.com/problems/twisted-mirror-path-count/

## Approach

To solve the "Twisted Mirror Path Count" problem, we can utilize a dynamic programming (DP) approach to efficiently count the number of unique valid paths from the top-left corner to the bottom-right corner of the grid, while accounting for the reflections caused by mirrors.

### Approach:

1. **Dynamic Programming Table**: We will create a 2D DP table `dp[i][j]` where `dp[i][j]` represents the number of unique paths to reach cell `(i, j)` from `(0, 0)`.

2. **Base Case**: Initialize `dp[0][0] = 1`, as there is one way to be at the starting position.

3. **Filling the DP Table**:
   - Iterate through each cell in the grid.
   - For each cell `(i, j)`, check if it is a mirror (`grid[i][j] == 1`). If it is:
     - If coming from the left (`dp[i][j-1]`), the robot is reflected down to `(i+1, j)`, so we add paths from `dp[i][j-1]` to `dp[i+1][j]` if `i+1` is within bounds.
     - If coming from above (`dp[i-1][j]`), the robot is reflected right to `(i, j+1)`, so we add paths from `dp[i-1][j]` to `dp[i][j+1]` if `j+1` is within bounds.
   - If the cell is not a mirror (`grid[i][j] == 0`), simply add paths from the top and left: 
     - `dp[i][j] += dp[i-1][j]` if `i > 0`
     - `dp[i][j] += dp[i][j-1]` if `j > 0`

4. **Boundary Conditions**: Ensure that any reflections do not cause the robot to move out of the grid boundaries. If a reflection would go out of bounds, that path is invalid and should not be counted.

5. **Result**: The final answer will be stored in `dp[m-1][n-1]`, which represents the number of unique paths to reach the bottom-right corner.

### Complexity:
- **Time Complexity**: O(m * n), where `m` is the number of rows and `n` is the number of columns in the grid. Each cell is processed once.
- **Space Complexity**: O(m * n) for the DP table, which can be optimized to O(n) if we only keep track of the current and previous rows.

### Conclusion:
This approach effectively counts the paths while handling the reflections caused by mirrors through careful updates of the DP table. By systematically iterating through the grid and applying the rules for movement and reflection, we ensure all valid paths are accounted for.
