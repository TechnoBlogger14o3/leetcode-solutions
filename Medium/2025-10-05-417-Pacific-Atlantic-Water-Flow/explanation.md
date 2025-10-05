# Pacific Atlantic Water Flow (Medium)

**Problem ID:** 417  
**Date:** 2025-10-05  
**Link:** https://leetcode.com/problems/pacific-atlantic-water-flow/

## Approach

To solve the "Pacific Atlantic Water Flow" problem, we can utilize a depth-first search (DFS) or breadth-first search (BFS) approach to explore the grid and determine which cells can flow to both oceans. The main idea is to perform two separate searches: one starting from the cells adjacent to the Pacific Ocean and another from the cells adjacent to the Atlantic Ocean. 

### Approach:

1. **Initialization**:
   - Create two boolean matrices, `pacific_reachable` and `atlantic_reachable`, both of the same dimensions as the input matrix. These will keep track of which cells can reach the Pacific and Atlantic oceans, respectively.

2. **DFS/BFS Traversal**:
   - For each ocean, start from the border cells that are adjacent to that ocean. For the Pacific Ocean, this includes the top row and the left column; for the Atlantic Ocean, this includes the bottom row and the right column.
   - Use a DFS or BFS to explore from these starting cells. During the traversal:
     - Mark the current cell as reachable for the corresponding ocean.
     - For each neighboring cell (up, down, left, right), check if it can be reached (i.e., its height is less than or equal to the current cell's height). If it can be reached and hasn't been visited yet, continue the search from that cell.

3. **Collect Results**:
   - After both searches are complete, iterate through the grid and collect the coordinates of cells that are marked as reachable in both `pacific_reachable` and `atlantic_reachable`.

### Data Structures:
- Two 2D boolean arrays for tracking reachability.
- A stack or queue for implementing the DFS or BFS.

### Complexity:
- **Time Complexity**: O(m * n), where m is the number of rows and n is the number of columns. Each cell is visited at most twice (once for each ocean).
- **Space Complexity**: O(m * n) for the two boolean matrices used to track reachability.

This approach efficiently determines the cells from which water can flow to both oceans by leveraging the properties of DFS/BFS to explore the grid based on height constraints.
