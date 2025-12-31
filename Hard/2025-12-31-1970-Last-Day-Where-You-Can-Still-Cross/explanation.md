# Last Day Where You Can Still Cross (Hard)

**Problem ID:** 1970  
**Date:** 2025-12-31  
**Link:** https://leetcode.com/problems/last-day-where-you-can-still-cross/

## Approach

To solve the problem of determining the last day where it is possible to walk from the top to the bottom of a binary matrix as cells become flooded, we can utilize a binary search approach combined with a flood-fill algorithm (such as BFS or DFS). Here's a concise explanation of the approach:

### Main Idea
The key idea is to use binary search to efficiently find the last day where a path exists from the top row to the bottom row of the matrix. For each day in the binary search, we simulate the flooding of cells and check if a path can still be traversed.

### Steps
1. **Binary Search Setup**: 
   - Initialize two pointers: `left` at 0 (the first day) and `right` at `len(cells) - 1` (the last day).
   - The goal is to find the maximum day where crossing is still possible.

2. **Flooding Simulation**:
   - For a mid-point day in the binary search, create a matrix representation of the flooded state based on the `cells` array up to that day.
   - Mark the cells that have been flooded (set them to 1).

3. **Pathfinding**:
   - Use a flood-fill algorithm (BFS or DFS) to check if there exists a path from any cell in the top row (first row) to any cell in the bottom row (last row) using only the land cells (0s).
   - Start the search from all land cells in the top row and explore downwards, marking visited cells to avoid cycles.

4. **Adjusting Binary Search**:
   - If a path exists for the current mid-day, it means we can potentially find a later day, so move the `left` pointer to `mid + 1`.
   - If no path exists, it means we need to check earlier days, so move the `right` pointer to `mid - 1`.

5. **Result**:
   - The last valid day where a path exists will be stored in `right` after the binary search concludes.

### Data Structures
- **Matrix**: A 2D array to represent the flooded state of the grid.
- **Queue/Stack**: For BFS or DFS to explore the matrix and find paths.

### Complexity
- **Time Complexity**: O((row * col) * log(days)), where `days` is the number of days (length of `cells`). Each day requires a flood-fill operation which takes O(row * col) time.
- **Space Complexity**: O(row * col) for the matrix and additional space for the queue/stack used in the flood-fill.

This approach efficiently narrows down the search space while ensuring that we accurately check the connectivity of land cells in the matrix as it changes over the days.
