# Number of Closed Islands (Medium)

**Problem ID:** 1254  
**Date:** 2026-10-25  
**Link:** https://leetcode.com/problems/number-of-closed-islands/

## Approach

To solve the problem of counting the number of closed islands in a 2D grid, we can use a depth-first search (DFS) or breadth-first search (BFS) approach to traverse the grid. Here's a concise explanation of the approach:

### Main Idea
The main idea is to identify and count the closed islands, which are defined as groups of connected 0s (land) that are completely surrounded by 1s (water). We will perform a search for each unvisited land cell, marking the cells we visit to avoid counting them multiple times.

### Steps
1. **Boundary Check**: Before starting the search, we should ensure that any island we explore does not touch the grid's boundary. If it does, it cannot be a closed island.

2. **Traversal**: For each cell in the grid:
   - If the cell is a 0 (land) and has not been visited, initiate a DFS/BFS from that cell.
   - During the traversal, check if any part of the island touches the grid's boundary. If it does, mark the island as not closed.
   - If the traversal completes without touching the boundary, increment the closed island count.

3. **Marking Visited Cells**: Use a data structure (like modifying the grid itself or using a separate visited array) to mark cells as visited to prevent counting them again.

### Data Structures
- A 2D grid to represent the input.
- A stack (for DFS) or queue (for BFS) to manage the cells to be explored.
- Optionally, a visited array or modify the grid to mark cells as visited.

### Complexity
- **Time Complexity**: O(m * n), where m is the number of rows and n is the number of columns in the grid. Each cell is visited once.
- **Space Complexity**: O(m * n) in the worst case for the recursion stack in DFS or for the queue in BFS, though this can be reduced to O(1) if we modify the grid in place.

By following this approach, we can efficiently count the number of closed islands in the given grid.
