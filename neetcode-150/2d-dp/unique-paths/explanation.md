# Unique Paths

## Problem Statement

There is a robot on an `m x n` grid. The robot is initially located at the top-left corner (i.e., `grid[0][0]`). The robot tries to move to the bottom-right corner (i.e., `grid[m - 1][n - 1]`). The robot can only move either down or right at any point in time.

Given the two integers `m` and `n`, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

## Examples

**Example 1:**
```
Input: m = 3, n = 7
Output: 28
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP table to store number of paths to each cell
2. dp[i][j] = dp[i-1][j] + dp[i][j-1]
3. Initialize first row and column to 1
4. Most efficient approach

**Time Complexity:** O(m * n) - Fill DP table
**Space Complexity:** O(m * n) - DP table

### Method 2: Space-Optimized DP
1. Use only one row instead of full table
2. Update row iteratively
3. Most memory efficient

**Time Complexity:** O(m * n) - Fill DP table
**Space Complexity:** O(n) - One row

## Algorithm

```
1. Initialize dp[0][j] = 1 for all j
2. Initialize dp[i][0] = 1 for all i
3. For i from 1 to m-1:
   For j from 1 to n-1:
     dp[i][j] = dp[i-1][j] + dp[i][j-1]
4. Return dp[m-1][n-1]
```

## Key Insights

- **State Transition**: dp[i][j] = dp[i-1][j] + dp[i][j-1]
- **Base Cases**: First row and column = 1
- **Movement Constraints**: Only down or right
- **Space Optimization**: Use only one row

## Alternative Approaches

1. **Mathematical**: Use combination formula C(m+n-2, m-1)
2. **Recursion**: Use recursive approach with memoization
3. **Backtracking**: Less efficient than DP

## Edge Cases

- m = 1 or n = 1: Return 1
- m = n = 1: Return 1
- Large values: Handle overflow

## Applications

- Dynamic programming patterns
- Grid traversal problems
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Space Optimization**: O(n) space complexity
- **Mathematical Formula**: O(1) space complexity
- **Single Pass**: O(m * n) time complexity
- **Memory Efficient**: Use only one row
