# Number of Sets of K Non-Overlapping Line Segments (Medium)

**Problem ID:** 1621  
**Date:** 2026-09-16  
**Link:** https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/

## Approach

To solve the problem of counting the number of ways to draw exactly \( k \) non-overlapping line segments from \( n \) points on a 1-D plane, we can use a dynamic programming approach.

### Problem Breakdown:
1. **Understanding Line Segments**: Each line segment must cover at least two points, meaning the minimum length of a segment is 1 (e.g., from point \( i \) to point \( j \) where \( j > i \)). The segments must not overlap, but they can share endpoints.

2. **Dynamic Programming Definition**:
   - Let \( dp[i][j] \) represent the number of ways to draw \( j \) non-overlapping segments using the first \( i \) points.
   - The goal is to compute \( dp[n][k] \).

3. **Base Cases**:
   - \( dp[0][0] = 1 \): There's one way to draw zero segments with zero points.
   - For any \( j > 0 \), \( dp[i][0] = 1 \) for all \( i \): There's one way to draw zero segments irrespective of the number of points.

4. **Transition**:
   - To fill \( dp[i][j] \), we consider all possible ways to end the last segment at position \( i-1 \) (the last point). The segment can start from any point \( p \) where \( 0 \leq p < i-1 \) (ensuring at least two points are covered).
   - For each valid starting point \( p \), the number of segments that can be formed is \( dp[p][j-1] \) (the number of ways to form \( j-1 \) segments from the first \( p \) points).
   - The transition can be expressed as:
     \[
     dp[i][j] = \sum_{p=0}^{i-2} dp[p][j-1]
     \]
   - This summation can be optimized using prefix sums to avoid recalculating sums repeatedly.

5. **Complexity**:
   - The time complexity of filling the DP table is \( O(n^2 \cdot k) \) since for each \( dp[i][j] \), we may need to sum up to \( i-2 \) previous states.
   - The space complexity is \( O(n \cdot k) \) for storing the DP table.

### Final Steps:
- After filling the DP table, return \( dp[n][k] \) modulo \( 10^9 + 7 \) to handle large numbers.

This approach efficiently computes the number of ways to draw the required segments while adhering to the constraints of non-overlapping and integral endpoints.
