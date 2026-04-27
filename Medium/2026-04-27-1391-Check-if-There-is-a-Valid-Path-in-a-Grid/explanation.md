# Check if There is a Valid Path in a Grid (Medium)

**Problem ID:** 1391  
**Date:** 2026-04-27  
**Link:** https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/

## Approach

To solve the problem of checking if there is a valid path in the grid, we can utilize a graph traversal approach, specifically Depth-First Search (DFS) or Breadth-First Search (BFS). The main idea is to explore the grid starting from the upper-left cell (0, 0) and determine if we can reach the bottom-right cell (m - 1, n - 1) by following the connections defined by the street types in each cell.

### Approach:

1. **Understanding Connections**: Each cell in the grid has a specific type (from 1 to 6), which defines how it connects to its neighboring cells:
   - Type 1 connects left and right.
   - Type 2 connects up and down.
   - Type 3 connects left and down.
   - Type 4 connects right and down.
   - Type 5 connects left and up.
   - Type 6 connects right and up.
   
   We need to define the valid movements based on these types. For example, if we are at cell (i, j) with type 1, we can move to (i, j-1) or (i, j+1) if those indices are valid.

2. **Traversal Strategy**: We can use either DFS or BFS to explore the grid. We maintain a set or a boolean matrix to keep track of visited cells to avoid cycles and unnecessary revisits.

3. **Starting Point**: Begin the traversal from the cell (0, 0). Check the possible movements based on the street type and move to the adjacent cells if they are valid and not visited.

4. **Termination Condition**: The traversal continues until we either reach the target cell (m - 1, n - 1) or exhaust all possible paths. If we reach the target cell, we return `true`. If we finish exploring without reaching the target, we return `false`.

### Data Structures:
- A stack (for DFS) or a queue (for BFS) to manage the cells to be explored.
- A set or a 2D boolean array to track visited cells.

### Complexity:
- **Time Complexity**: O(m * n), where m is the number of rows and n is the number of columns in the grid. In the worst case, we may visit every cell once.
- **Space Complexity**: O(m * n) for the visited structure and the stack/queue used for traversal.

This approach efficiently checks for a valid path by leveraging the connections defined by the street types, ensuring that all potential routes are explored systematically.
