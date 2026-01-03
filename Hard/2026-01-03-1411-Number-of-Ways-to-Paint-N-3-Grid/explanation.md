# Number of Ways to Paint N × 3 Grid (Hard)

**Problem ID:** 1411  
**Date:** 2026-01-03  
**Link:** https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/

## Approach

To solve the problem of counting the number of ways to paint an n × 3 grid with the constraint that no two adjacent cells share the same color, we can use a dynamic programming approach.

### Main Idea:
The core idea is to define a state that captures the valid configurations of painting the grid rows while adhering to the coloring constraints. We can represent the configurations of the last row using a state that reflects the colors of the three cells in that row.

### State Representation:
1. **State Definition**: Let `dp[i]` represent the number of ways to paint the first `i` rows of the grid.
2. **Transition**: To compute `dp[i]`, we consider the valid colorings of the `i-th` row based on the configurations of the `(i-1)-th` row. 
   - If we denote the number of ways to paint the last row with a certain configuration, we can determine the number of valid configurations for the next row.
   - For each configuration of the last row, there are specific ways to paint the next row that respect the adjacency rule.

### Recurrence Relation:
- The number of ways to paint a row can be derived from the previous row. For each cell in the current row, we have 3 choices of colors, but we must ensure that adjacent cells do not share the same color.
- The transitions can be calculated based on:
  - The number of ways to paint the previous row (with no restrictions on the same color).
  - The restrictions imposed by the colors chosen in the previous row.

### Base Case:
- For `n = 1`, we can directly calculate the number of ways to paint a single row of three cells, which is `12` (since there are 3 choices for the first cell and 2 choices for the second and third cells).

### Complexity:
- The time complexity of this approach is O(n) since we compute each `dp[i]` based on the previous state, and space complexity can be reduced to O(1) by only storing the last two states (current and previous).

### Final Calculation:
- The final answer will be `dp[n]`, which gives the number of valid ways to paint the entire grid modulo \(10^9 + 7\).

In summary, the problem can be efficiently solved using dynamic programming by defining a state that captures the valid configurations of the last row and using recurrence relations to build up to the solution for `n` rows.
