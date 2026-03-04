# Special Positions in a Binary Matrix (Easy)

**Problem ID:** 1582  
**Date:** 2026-03-04  
**Link:** https://leetcode.com/problems/special-positions-in-a-binary-matrix/

## Approach

To solve the problem of counting special positions in a binary matrix, we can follow these steps:

### Problem Understanding
A position (i, j) in the matrix is considered "special" if:
1. The value at that position is 1 (`mat[i][j] == 1`).
2. All other elements in the same row (i) and the same column (j) are 0.

### Approach
1. **Count Row and Column Sums**: First, we need to calculate the sum of each row and each column. This will allow us to quickly determine if a position is special without needing to check all elements in the row and column repeatedly.
   - Create two arrays: `rowSum` of size `m` (number of rows) and `colSum` of size `n` (number of columns).
   - Traverse the matrix once to populate these arrays. For each element `mat[i][j]`, if it's 1, increment `rowSum[i]` and `colSum[j]`.

2. **Check for Special Positions**: After populating the sums, iterate through the matrix again to count the special positions.
   - For each position `(i, j)`, check if `mat[i][j] == 1` and if `rowSum[i] == 1` (indicating that it's the only 1 in that row) and `colSum[j] == 1` (indicating that it's the only 1 in that column).
   - If both conditions are satisfied, increment the count of special positions.

### Data Structures
- Two arrays (`rowSum` and `colSum`) to store the count of 1s in each row and column, respectively.

### Complexity
- **Time Complexity**: O(m * n), where m is the number of rows and n is the number of columns. This is because we traverse the matrix twice: once for counting and once for checking.
- **Space Complexity**: O(m + n) for the two arrays used to store the row and column sums.

This approach efficiently counts the special positions while minimizing redundant checks, making it suitable for the problem's constraints.
