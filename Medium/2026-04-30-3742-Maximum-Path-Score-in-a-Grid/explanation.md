# Maximum Path Score in a Grid (Medium)

**Problem ID:** 3742  
**Date:** 2026-04-30  
**Link:** https://leetcode.com/problems/maximum-path-score-in-a-grid/

## Approach

To solve the "Maximum Path Score in a Grid" problem, we can utilize a dynamic programming approach combined with a breadth-first search (BFS) strategy. The main idea is to explore all possible paths from the top-left corner to the bottom-right corner of the grid while keeping track of the accumulated score and cost.

### Approach:

1. **Data Structures**:
   - Use a 2D list `dp` where `dp[i][j]` represents the maximum score achievable when reaching cell `(i, j)` with a cost not exceeding `k`.
   - A queue (for BFS) to explore the cells in the grid, initialized with the starting cell `(0, 0)`.

2. **Initialization**:
   - Start by setting `dp[0][0]` to 0, as starting at the top-left corner incurs no cost and adds no score.
   - For all other cells, initialize `dp[i][j]` to -1 (indicating unreachable).

3. **BFS Exploration**:
   - While there are cells in the queue, pop the front cell `(i, j)` and explore its neighbors (right `(i, j+1)` and down `(i+1, j)`).
   - For each neighbor, calculate the new score and cost based on the value in the grid:
     - If the grid value is `0`, it adds `0` to the score and incurs `0` cost.
     - If the grid value is `1`, it adds `1` to the score and incurs `1` cost.
     - If the grid value is `2`, it adds `2` to the score and incurs `1` cost.
   - Check if the new cost exceeds `k`. If it does, skip that neighbor.
   - If the new score is greater than the current maximum score recorded in `dp` for that neighbor, update `dp` and add the neighbor to the queue for further exploration.

4. **Final Check**:
   - After exploring all possible paths, check the value in `dp[m-1][n-1]`. If it remains `-1`, return `-1` indicating no valid path exists. Otherwise, return the maximum score found.

### Complexity:
- **Time Complexity**: O(m * n), where m is the number of rows and n is the number of columns in the grid. Each cell is processed at most once.
- **Space Complexity**: O(m * n) for the `dp` array and O(m * n) for the queue in the worst case.

This approach ensures that we efficiently explore all valid paths while adhering to the constraints of the problem, ultimately leading to the maximum score achievable without exceeding the specified cost.
