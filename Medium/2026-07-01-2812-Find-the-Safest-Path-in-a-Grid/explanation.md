# Find the Safest Path in a Grid (Medium)

**Problem ID:** 2812  
**Date:** 2026-07-01  
**Link:** https://leetcode.com/problems/find-the-safest-path-in-a-grid/

## Approach

To solve the problem of finding the safest path in a grid, we can utilize a combination of breadth-first search (BFS) and binary search to efficiently determine the maximum safeness factor.

### Main Idea:
The core idea is to identify the maximum minimum distance (safeness factor) from any cell in the path to the nearest thief. We can achieve this by first calculating the minimum distance from each cell in the grid to the nearest thief using a multi-source BFS. Then, we can use binary search to find the maximum safeness factor that allows a valid path from the starting cell (0, 0) to the destination cell (n-1, n-1).

### Steps:
1. **Multi-source BFS for Distance Calculation**:
   - Initialize a queue with all the thief positions in the grid.
   - Perform BFS to calculate the minimum distance from each cell to the nearest thief. This will fill a distance matrix where each cell contains the distance to the closest thief.

2. **Binary Search on Safeness Factor**:
   - Define the search space for the safeness factor, ranging from 0 to the maximum possible distance in the grid (which is `2 * (n - 1)`).
   - For each mid-point in the binary search, check if there exists a valid path from (0, 0) to (n-1, n-1) such that all cells in the path have a distance to the nearest thief that is at least `mid`.
   - This can be done using BFS or DFS, where we only traverse cells that meet the distance condition.

3. **Path Validation**:
   - During the BFS/DFS for path validation, ensure that you only enqueue cells that are within bounds, not previously visited, and have a distance to the nearest thief greater than or equal to the current `mid` value.

### Data Structures:
- A queue for BFS.
- A 2D array (matrix) to store the distances from each cell to the nearest thief.
- A set or 2D boolean array to track visited cells during path validation.

### Complexity:
- The BFS to calculate distances runs in O(n^2) time, as each cell is processed once.
- The binary search runs in O(log(max_distance)) iterations, and each iteration involves a BFS that can also run in O(n^2) in the worst case.
- Thus, the overall time complexity is O(n^2 * log(max_distance)), where `max_distance` is at most `2 * (n - 1)`.

This approach ensures that we efficiently find the safest path while adhering to the constraints of the problem.
