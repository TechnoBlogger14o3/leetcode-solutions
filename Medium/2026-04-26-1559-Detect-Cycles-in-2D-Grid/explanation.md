# Detect Cycles in 2D Grid (Medium)

**Problem ID:** 1559  
**Date:** 2026-04-26  
**Link:** https://leetcode.com/problems/detect-cycles-in-2d-grid/

## Approach

To solve the problem of detecting cycles in a 2D grid of characters, we can use a Depth-First Search (DFS) approach. The main idea is to traverse the grid and explore all possible paths starting from each cell, while keeping track of visited cells to identify cycles.

### Approach:

1. **DFS Traversal**: For each cell in the grid, initiate a DFS traversal if it hasn't been visited yet. The DFS will explore all four possible directions (up, down, left, right) from the current cell.

2. **Cycle Detection**: During the DFS, we need to check for cycles. A cycle is detected if we revisit a cell that is not the immediate predecessor (the last visited cell). To facilitate this, we can pass the previous cell's coordinates as an additional parameter to the DFS function.

3. **Visited Tracking**: Maintain a 2D array `visited` to keep track of which cells have been explored. This prevents revisiting cells unnecessarily and helps in detecting cycles accurately.

4. **Character Matching**: While traversing, ensure that we only move to adjacent cells that contain the same character as the current cell. This is essential to form valid cycles.

5. **Early Exit**: If a cycle is detected during any of the DFS calls, we can immediately return `true`. If we finish exploring all cells without finding a cycle, we return `false`.

### Data Structures:
- A 2D list for the grid.
- A 2D boolean array for tracking visited cells.
- Stack or recursion for the DFS traversal.

### Complexity:
- **Time Complexity**: O(m * n), where m is the number of rows and n is the number of columns. In the worst case, we may visit every cell once.
- **Space Complexity**: O(m * n) for the visited array and the recursion stack in the case of deep recursion.

This approach efficiently checks for cycles in the grid while adhering to the constraints provided, ensuring that we only explore valid paths and detect cycles correctly.
