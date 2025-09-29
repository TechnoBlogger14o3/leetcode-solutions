# Minimum Score Triangulation of Polygon (Medium)

**Problem ID:** 1039  
**Date:** 2025-09-29  
**Link:** https://leetcode.com/problems/minimum-score-triangulation-of-polygon/

## Approach

To solve the problem of finding the minimum score triangulation of a convex polygon, we can employ a dynamic programming approach. The main idea is to break down the problem into smaller subproblems by considering different ways to triangulate the polygon and calculating the scores for these triangulations.

### Approach:

1. **Dynamic Programming Table**: We define a 2D array `dp[i][j]` where `dp[i][j]` represents the minimum score of triangulating the polygon formed by vertices from index `i` to `j`. The size of this table will be `n x n`, where `n` is the number of vertices.

2. **Base Case**: For any segment with less than three vertices (i.e., when `j - i < 2`), the score is zero because no triangles can be formed. Thus, `dp[i][j]` is initialized to zero for these cases.

3. **Filling the DP Table**: For segments with three or more vertices, we iterate through all possible pairs of vertices `(i, j)` and consider every possible vertex `k` that can form a triangle with `i` and `j` (where `i < k < j`). The score for the triangle formed by vertices `i`, `j`, and `k` is calculated as `values[i] * values[j] * values[k]`. The optimal score for `dp[i][j]` can then be computed as:
   \[
   dp[i][j] = \min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[j] * values[k])
   \]
   This means we take the minimum of the current value of `dp[i][j]` and the sum of the scores from the two subproblems plus the score of the triangle formed by `i`, `j`, and `k`.

4. **Iterative Calculation**: We fill the `dp` table iteratively, starting from smaller segments and gradually increasing the size of the segments being considered until we cover the entire polygon.

5. **Final Result**: The minimum score triangulation of the entire polygon will be found in `dp[0][n-1]`, which corresponds to triangulating the polygon from the first to the last vertex.

### Data Structures:
- A 2D array `dp` to store the minimum scores for triangulations of various segments of the polygon.

### Time Complexity:
The time complexity of this approach is \(O(n^3)\) because we have three nested loops: one for choosing the starting vertex `i`, one for choosing the ending vertex `j`, and one for choosing the vertex `k` to form a triangle. Given the constraints (with \(n\) up to 50), this complexity is manageable.

### Space Complexity:
The space complexity is \(O(n^2)\) due to the storage required for the `dp` table.

In summary, by systematically breaking down the problem using dynamic programming, we can efficiently compute the minimum score for triangulating a convex polygon.
