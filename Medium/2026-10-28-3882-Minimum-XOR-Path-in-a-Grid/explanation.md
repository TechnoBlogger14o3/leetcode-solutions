# Minimum XOR Path in a Grid (Medium)

**Problem ID:** 3882  
**Date:** 2026-10-28  
**Link:** https://leetcode.com/problems/minimum-xor-path-in-a-grid/

## Approach

To solve the "Minimum XOR Path in a Grid" problem, we can use a dynamic programming approach. The main idea is to maintain a 2D array `dp` where `dp[i][j]` represents the minimum XOR value obtainable from the top-left corner (0, 0) to the cell (i, j).

### Approach:

1. **Initialization**:
   - Start by initializing the `dp` array with the same dimensions as the grid. Set `dp[0][0]` to the value of `grid[0][0]`, as this is the starting point.

2. **Dynamic Programming Transition**:
   - Iterate through each cell in the grid. For each cell `(i, j)`, calculate the minimum XOR value to reach that cell from either the top `(i-1, j)` or the left `(i, j-1)`:
     - If coming from the top: `dp[i][j] = dp[i-1][j] XOR grid[i][j]`
     - If coming from the left: `dp[i][j] = dp[i][j-1] XOR grid[i][j]`
   - The value of `dp[i][j]` will be the minimum of the two possible XOR values.

3. **Boundary Conditions**:
   - Handle the edges of the grid separately since they only have one valid direction of approach (either from the top for the first column or from the left for the first row).

4. **Final Result**:
   - The desired minimum XOR path value will be found in `dp[m-1][n-1]`, which represents the minimum XOR value to reach the bottom-right corner of the grid.

### Data Structures:
- A 2D list (or array) `dp` to store the minimum XOR values for each cell.

### Complexity:
- **Time Complexity**: O(m * n), where `m` is the number of rows and `n` is the number of columns in the grid. We iterate through each cell once.
- **Space Complexity**: O(m * n) for the `dp` array. However, if we optimize the space by using a single array to store only the current and previous rows, we can reduce the space complexity to O(n).

This approach efficiently computes the minimum XOR path while adhering to the movement constraints of the problem.
