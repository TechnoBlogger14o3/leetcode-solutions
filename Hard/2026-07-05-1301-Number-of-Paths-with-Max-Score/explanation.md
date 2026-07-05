# Number of Paths with Max Score (Hard)

**Problem ID:** 1301  
**Date:** 2026-07-05  
**Link:** https://leetcode.com/problems/number-of-paths-with-max-score/

## Approach

To solve the problem of finding the number of paths with the maximum score from the bottom-right corner ('S') to the top-left corner ('E') on a given board, we can employ a dynamic programming approach. 

### Main Idea:
We need to traverse the board while keeping track of two key pieces of information at each cell:
1. The maximum score that can be collected when reaching that cell.
2. The number of distinct paths that yield that maximum score.

### Approach:
1. **Initialization**: Create a 2D array `dp` where `dp[i][j]` will store a tuple `(max_score, num_paths)` for the cell at position `(i, j)`. Initialize `dp` such that `dp[0][0]` (the starting point 'E') is set to `(0, 1)` (zero score and one path to itself).

2. **Traversal**: Iterate over the board in a bottom-up manner (from the bottom row to the top row, and from the rightmost column to the leftmost column). For each cell `(i, j)`, we can potentially move to it from three directions: down `(i+1, j)`, right `(i, j+1)`, and down-left `(i+1, j-1)`.

3. **Updating States**:
   - For each direction, check if the move is valid (i.e., within bounds and not an obstacle 'X').
   - If moving from a neighboring cell results in a higher score for the current cell, update the score and reset the path count to that of the neighbor.
   - If it results in the same maximum score, add to the path count from that neighbor.

4. **Final Result**: After processing the board, the value at `dp[n-1][n-1]` (where `n` is the size of the board) will give you the maximum score and the number of paths to reach 'S'. If the maximum score is still zero and no paths were found, return `[0, 0]`.

### Data Structures:
- A 2D list `dp` to store tuples of `(max_score, num_paths)`.
- The board itself is a list of strings representing the grid.

### Complexity:
- **Time Complexity**: O(n^2), where n is the size of the board (since we visit each cell once).
- **Space Complexity**: O(n^2) for the `dp` array.

This approach ensures that we efficiently compute the maximum score and the number of paths while adhering to the movement constraints on the board.
