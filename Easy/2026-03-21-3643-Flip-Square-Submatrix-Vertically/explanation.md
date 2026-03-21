# Flip Square Submatrix Vertically (Easy)

**Problem ID:** 3643  
**Date:** 2026-03-21  
**Link:** https://leetcode.com/problems/flip-square-submatrix-vertically/

## Approach

To solve the problem of flipping a square submatrix vertically in a given grid, we can follow a straightforward approach:

### Main Idea:
The goal is to reverse the order of the rows within a specified square submatrix defined by its top-left corner (x, y) and its size (k). This involves swapping the rows of the submatrix from the top to the bottom.

### Steps:
1. **Identify the Submatrix**: Determine the rows and columns that make up the square submatrix using the parameters x, y, and k. The submatrix will span from `grid[x][y]` to `grid[x + k - 1][y + k - 1]`.

2. **Row Swapping**: Iterate through the first half of the rows in the submatrix (from x to x + k/2). For each row in this range, swap it with its corresponding row from the bottom half of the submatrix. Specifically, swap `grid[i][y:y+k]` with `grid[x + k - 1 - (i - x)][y:y+k]` for each row index `i`.

3. **Update the Grid**: As you perform the swaps, the grid will be updated directly.

### Data Structures:
- The primary data structure used is the 2D list (matrix) `grid`, which holds the integer values. No additional complex data structures are required since we are modifying the grid in place.

### Complexity:
- **Time Complexity**: The time complexity is O(k), where k is the size of the side of the square submatrix. This is because we are performing a constant-time operation (swapping rows) for each of the k rows in the submatrix.
- **Space Complexity**: The space complexity is O(1) since we are not using any extra space that scales with the input size, just a few variables for indexing.

In summary, the approach leverages direct row manipulation within the specified submatrix, ensuring an efficient and clear solution to the problem.
