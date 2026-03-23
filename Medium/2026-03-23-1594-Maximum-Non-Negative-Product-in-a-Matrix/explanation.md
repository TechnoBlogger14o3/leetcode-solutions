# Maximum Non Negative Product in a Matrix (Medium)

**Problem ID:** 1594  
**Date:** 2026-03-23  
**Link:** https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/

## Approach

To solve the problem of finding the maximum non-negative product in a matrix while only moving right or down, we can use a dynamic programming approach. Here’s a concise explanation of the solution approach:

### Main Idea:
We will maintain two dynamic programming tables:
1. **max_product[i][j]**: Stores the maximum non-negative product that can be obtained from the top-left corner (0, 0) to the cell (i, j).
2. **min_product[i][j]**: Stores the minimum product (which could be negative) that can be obtained from the top-left corner to the cell (i, j). This is necessary because a negative product can become positive if multiplied by another negative number.

### Approach:
1. **Initialization**: Start by initializing `max_product[0][0]` and `min_product[0][0]` with the value of `grid[0][0]`. If this value is negative, we can set `max_product[0][0]` to -1 to indicate an invalid path.

2. **Filling the DP Tables**:
   - Iterate through each cell in the grid.
   - For each cell (i, j), calculate the potential maximum and minimum products coming from the top (i-1, j) and left (i, j-1) cells.
   - If moving from the top or left results in a valid product (not -1 for max), update `max_product[i][j]` and `min_product[i][j]` accordingly:
     - `max_product[i][j]` will be the maximum of the products derived from the top and left cells, considering both maximum and minimum products.
     - `min_product[i][j]` will be updated similarly, keeping track of the minimum product.

3. **Final Result**:
   - After filling the tables, the result will be in `max_product[m-1][n-1]`.
   - If `max_product[m-1][n-1]` is negative, return -1. Otherwise, return `max_product[m-1][n-1] % (10^9 + 7)`.

### Data Structures:
- Two 2D arrays (or matrices) for `max_product` and `min_product` of size `m x n`.

### Complexity:
- **Time Complexity**: O(m * n), where m and n are the dimensions of the grid, since we are iterating through each cell once.
- **Space Complexity**: O(m * n) for storing the two DP tables.

This approach efficiently calculates the maximum non-negative product while taking into account the effects of negative numbers through the use of both maximum and minimum tracking.
