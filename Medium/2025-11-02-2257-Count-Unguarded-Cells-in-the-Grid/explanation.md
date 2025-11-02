# Count Unguarded Cells in the Grid (Medium)

**Problem ID:** 2257  
**Date:** 2025-11-02  
**Link:** https://leetcode.com/problems/count-unguarded-cells-in-the-grid/

## Approach

To solve the problem of counting unguarded cells in a grid, we can adopt the following approach:

### Main Idea:
The primary goal is to determine which cells in the grid are guarded by at least one guard and then count the remaining unguarded cells. A guard can see in four cardinal directions (up, down, left, right) until blocked by a wall or another guard. 

### Approach:
1. **Grid Representation**: 
   - We will use a 2D grid to represent the cells, but given the constraints, we can optimize by using a set to track the positions of guards and walls.

2. **Marking Guarded Cells**:
   - For each guard, we will check in all four directions (up, down, left, right) to mark the cells that can be seen by the guard:
     - Start from the guard's position and move in the direction until we hit a wall or another guard.
     - For each cell that is not a wall or guard, mark it as guarded (using a set to avoid duplicates).

3. **Counting Unguarded Cells**:
   - After marking all guarded cells, we can calculate the total number of unguarded cells by:
     - Starting with the total number of cells in the grid (`m * n`).
     - Subtracting the number of cells that are either guarded or occupied by guards or walls.

### Data Structures:
- **Set**: To keep track of the positions of guarded cells. This allows O(1) average time complexity for insertions and checks.
- **List or Array**: To store the positions of guards and walls for easy iteration.

### Complexity:
- **Time Complexity**: O(m * n) in the worst case, as we may need to check each cell in the grid. However, since the total number of guards and walls is limited to `5 * 10^4`, the actual operations performed will be significantly less than this in practice.
- **Space Complexity**: O(m * n) in the worst case for the set storing guarded cells, but it will be limited by the number of guards and walls in practical scenarios.

### Summary:
By efficiently marking the cells that are guarded based on the positions of guards and walls, we can quickly compute the number of unguarded cells in the grid. This approach leverages sets for efficient membership checking and ensures we respect the constraints of the problem.
