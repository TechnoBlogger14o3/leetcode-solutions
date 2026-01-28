# Minimum Cost Path with Teleportations (Hard)

**Problem ID:** 3651  
**Date:** 2026-01-28  
**Link:** https://leetcode.com/problems/minimum-cost-path-with-teleportations/

## Approach

To solve the problem of finding the minimum cost path in a grid with teleportation options, we can use a modified Dijkstra's algorithm approach, treating the grid as a weighted graph where each cell represents a node. The main idea is to explore all possible paths to the bottom-right cell while considering both normal moves and teleportation options.

### Approach:

1. **Graph Representation**: Each cell `(i, j)` in the grid corresponds to a node in a graph. The edges represent the possible moves (right or down) and teleportations.

2. **Priority Queue**: Use a priority queue (min-heap) to always expand the least costly path first. Each entry in the queue will store the current cost, the cell coordinates `(i, j)`, and the number of teleportations used so far.

3. **Cost Calculation**:
   - For normal moves, the cost to move to `(i, j+1)` or `(i+1, j)` is the value of the destination cell.
   - For teleportation, we can teleport to any cell `(x, y)` where `grid[x][y] <= grid[i][j]` at no cost, but we must ensure we do not exceed the allowed `k` teleportations.

4. **Visited States**: Maintain a 3D array `visited[i][j][t]` to track the minimum cost to reach cell `(i, j)` using `t` teleportations. This helps avoid reprocessing states that have already been found with a lower cost.

5. **Algorithm Steps**:
   - Initialize the priority queue with the starting cell `(0, 0)` with a cost of `0` and `0` teleportations used.
   - While the queue is not empty, extract the cell with the minimum cost.
   - For each cell, explore the right and down moves, updating costs and pushing new states into the queue if they yield a lower cost.
   - For teleportation, iterate through all cells to find potential teleportation targets that meet the cost criteria and push them into the queue if they improve the cost.

6. **Termination**: The process continues until the bottom-right cell `(m-1, n-1)` is reached with the minimum cost, considering all possible paths and teleportations.

### Complexity:
- **Time Complexity**: The time complexity is influenced by the number of cells and the number of teleportations. In the worst case, we may need to check all cells for teleportation for each cell, leading to a complexity of `O(m * n * (m * n + k))`, where `m` and `n` are the dimensions of the grid.
- **Space Complexity**: The space complexity is `O(m * n * (k + 1))` due to the visited states and the priority queue.

This approach effectively balances the exploration of normal moves and the flexibility of teleportation, ensuring that we find the minimum cost path efficiently.
