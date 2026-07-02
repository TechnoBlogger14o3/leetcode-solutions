# Find a Safe Walk Through a Grid (Medium)

**Problem ID:** 3286  
**Date:** 2026-07-02  
**Link:** https://leetcode.com/problems/find-a-safe-walk-through-a-grid/

## Approach

To solve the problem of finding a safe walk through a grid, we can use a breadth-first search (BFS) or depth-first search (DFS) approach to explore all possible paths from the starting cell (0, 0) to the target cell (m-1, n-1). The main idea is to track the health points as we traverse the grid, ensuring that we do not step on too many unsafe cells (cells with a value of 1) that would reduce our health below 1.

### Approach:

1. **Initial Setup**:
   - Start from the top-left corner of the grid with the given health value.
   - Use a queue (for BFS) or a stack (for DFS) to manage the cells to explore, initialized with the starting cell and the initial health.

2. **Traversal**:
   - Explore adjacent cells (up, down, left, right) from the current cell.
   - For each adjacent cell:
     - Calculate the new health after moving to that cell. If the cell is safe (0), the health remains the same; if it is unsafe (1), the health decreases by 1.
     - Only proceed to the adjacent cell if the new health is greater than 0 and if that cell has not been visited with the same or more health (to avoid cycles and unnecessary exploration).

3. **Goal Check**:
   - If we reach the bottom-right corner (m-1, n-1) with health greater than or equal to 1, return true.
   - If the queue (or stack) is exhausted without reaching the target cell with sufficient health, return false.

### Data Structures:
- A queue (for BFS) or a stack (for DFS) to manage the cells to explore.
- A set or a 2D array to track visited cells along with the health points to prevent revisiting cells with lower health.

### Complexity:
- **Time Complexity**: O(m * n), where m is the number of rows and n is the number of columns. In the worst case, we may need to explore all cells in the grid.
- **Space Complexity**: O(m * n) for the visited set and the queue/stack, which can grow to the size of the grid in the worst case.

This approach efficiently explores all potential paths while keeping health management in check, ensuring we find a valid route to the target cell if one exists.
