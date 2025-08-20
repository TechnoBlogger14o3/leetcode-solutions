# Count Square Submatrices with All Ones

## Problem Description
Given a 2D binary matrix filled with 0's and 1's, return the number of square submatrices with all ones. A square submatrix is a submatrix with an equal number of rows and columns.

## Approach
This is a dynamic programming problem that requires understanding how to count squares of different sizes. The key insight is that if a cell can form a square of size k, it can also form squares of sizes 1, 2, ..., k-1.

## Algorithm
1. **Initialize DP table**: Create a 2D array `dp` where `dp[i][j]` represents the size of the largest square ending at position `(i,j)`
2. **Fill first row and column**: Copy values from the input matrix
3. **Fill rest of the table**: For each cell `(i,j)` with value 1:
   - `dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1`
4. **Count all squares**: Sum up all values in the DP table

## Dynamic Programming Formula
```
dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
```

This formula works because:
- A square of size k at `(i,j)` requires squares of size k-1 at `(i-1,j)`, `(i,j-1)`, and `(i-1,j-1)`
- The minimum of these three values determines the maximum possible square size
- Adding 1 accounts for the current cell

## Implementation Details
- **Base Cases**: Handle first row and column separately
- **Matrix Traversal**: Process from top-left to bottom-right
- **Conditional Update**: Only update DP table when matrix value is 1
- **Accumulative Counting**: Add each DP value to the total count

## Time Complexity
- **Time**: O(m × n) where m and n are the dimensions of the matrix
- **Space**: O(m × n) for the DP table

## Example
- Input: [[1,1,1], [1,1,1], [1,1,1]]
- Process: 
  - dp[0][0] = 1, dp[0][1] = 1, dp[0][2] = 1
  - dp[1][0] = 1, dp[1][1] = 2, dp[1][2] = 2
  - dp[2][0] = 1, dp[2][1] = 2, dp[2][2] = 3
- Output: 14 (1+1+1+1+2+2+1+2+3 = 14)

## Key Insights
- **Square Property**: A square of size k contains squares of all smaller sizes
- **Neighbor Dependency**: Each cell depends on three neighboring cells
- **Incremental Counting**: Count squares of all sizes simultaneously
- **Matrix Traversal Order**: Process cells in a specific order to ensure dependencies are met

## Alternative Approaches
- **Brute Force**: Check all possible square submatrices (O(m³n³))
- **Prefix Sums**: Use 2D prefix sums to check square validity
- **Sliding Window**: Expand window for each position
- **Recursive**: Use recursion with memoization

## Edge Cases
- **Empty Matrix**: Return 0
- **Single Element**: Handle 1×1 matrices
- **All Zeros**: Return 0
- **All Ones**: Maximum possible squares
- **Irregular Shapes**: Handle non-square matrices

## Applications
- **Image Processing**: Count objects or patterns
- **Computer Vision**: Detect squares or rectangles
- **Data Analysis**: Find clusters or patterns in binary data
- **Game Development**: Count valid game board positions
