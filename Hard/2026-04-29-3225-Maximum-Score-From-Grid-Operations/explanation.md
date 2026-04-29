# Maximum Score From Grid Operations (Hard)

**Problem ID:** 3225  
**Date:** 2026-04-29  
**Link:** https://leetcode.com/problems/maximum-score-from-grid-operations/

## Approach

To solve the problem of maximizing the score from grid operations, we can adopt a strategic approach that focuses on the relationship between the operations we perform and the resulting score.

### Main Idea:
The key insight is to recognize that the score is derived from the sum of values in the grid that are adjacent to black cells. Thus, our goal is to maximize the number of white cells that can be adjacent to black cells after performing a series of operations.

### Approach:
1. **Understanding Operations**: Each operation colors all cells in a selected column from the top down to a specified row. This means that for any column, if we decide to color it down to a certain row, all cells above that row in that column will also be black.

2. **Column-wise Contribution**: For each column, we can determine the maximum score contribution if we choose to color down to each possible row. This means iterating through each column and calculating the potential score contribution for each row down to which we might color.

3. **Dynamic Programming Array**: We can maintain a dynamic programming array (`max_score`) where `max_score[j]` keeps track of the maximum score achievable from column `j` based on the rows we have considered so far.

4. **Iterate and Update**: For each column, iterate through the rows from the bottom to the top. For each cell, if it is white and adjacent to a black cell (which can be determined based on the previous operations), we add its value to the `max_score` for that column.

5. **Final Calculation**: After processing all columns, the final score is the sum of the maximum contributions from each column.

### Data Structures:
- A 1D array (`max_score`) to store the maximum score contributions for each column.
- A nested loop structure to iterate through the grid efficiently.

### Complexity:
- **Time Complexity**: O(n^2), where n is the dimension of the grid. This is due to the double iteration over the grid (once for columns and once for rows).
- **Space Complexity**: O(n), for the `max_score` array.

This approach ensures that we systematically evaluate the best possible operations to maximize the score based on the grid's structure, leading to an optimal solution.
