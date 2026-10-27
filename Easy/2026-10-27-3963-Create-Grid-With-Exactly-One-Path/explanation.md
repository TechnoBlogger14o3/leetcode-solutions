# Create Grid With Exactly One Path (Easy)

**Problem ID:** 3963  
**Date:** 2026-10-27  
**Link:** https://leetcode.com/problems/create-grid-with-exactly-one-path/

## Approach

To solve the problem of creating an m x n grid with exactly one valid path from the top-left cell (0, 0) to the bottom-right cell (m - 1, n - 1), we can utilize a straightforward construction approach.

### Main Idea:
The key idea is to ensure that there is a single continuous path from the start to the end while filling the rest of the grid with obstacles ('#'). The valid path can be constructed by making a series of right and down moves, which will uniquely define the path.

### Approach:
1. **Grid Initialization**: Start by creating an m x n grid filled with obstacles ('#').
2. **Path Construction**:
   - Begin at the top-left corner (0, 0) and mark it as free ('.').
   - Move right until you reach the last column (if n > 1), marking each cell as free ('.').
   - If there are remaining rows (i.e., m > 1), move down to the last row and mark the last cell in that row as free ('.').
   - Finally, fill the remaining cells in the last column (if m > 1) with free cells ('.') until you reach the bottom-right corner (m - 1, n - 1).
3. **Final Touch**: Ensure that the bottom-right cell is also marked as free ('.') to complete the path.

### Data Structures:
- A 2D list (or array) to represent the grid, initialized with '#' characters.

### Complexity:
- **Time Complexity**: O(m * n) because we need to iterate through the grid to fill it with obstacles and then mark the path.
- **Space Complexity**: O(m * n) for storing the grid.

This approach guarantees that there is exactly one valid path from the top-left to the bottom-right corner, as the path is constructed in a deterministic manner without any branching.
