# Increment Submatrices by One (Medium)

**Problem ID:** 2536  
**Date:** 2025-11-14  
**Link:** https://leetcode.com/problems/increment-submatrices-by-one/

## Approach

To solve the problem of incrementing submatrices efficiently, we can utilize a technique known as the "2D difference array" approach. This method allows us to perform range updates in constant time, which is crucial given the constraints of the problem.

### Approach:

1. **Initialize a 2D Difference Array**:
   - Create a 2D array `diff` of size `(n+1) x (n+1)` initialized to zero. This extra row and column help handle boundary conditions easily.

2. **Process Each Query**:
   - For each query defined by `query[i] = [row1, col1, row2, col2]`, we will update the `diff` array to mark the increments:
     - Increment `diff[row1][col1]` by 1 to start adding 1 from the top-left corner of the submatrix.
     - Decrement `diff[row1][col2 + 1]` by 1 to stop adding 1 after reaching the right edge of the submatrix.
     - Decrement `diff[row2 + 1][col1]` by 1 to stop adding 1 after reaching the bottom edge of the submatrix.
     - Increment `diff[row2 + 1][col2 + 1]` by 1 to correct the area that was double subtracted.

3. **Build the Final Matrix**:
   - After processing all queries, construct the resulting matrix `mat` from the `diff` array:
     - Use a nested loop to calculate the prefix sums. The value at each position `(i, j)` in `mat` can be derived from the `diff` array by adding the current cell value and the values from the left and above cells in the `diff` array.

### Data Structures:
- A 2D difference array `diff` of size `(n+1) x (n+1)` is used to efficiently mark the increments.
- The final result matrix `mat` of size `n x n` is constructed from the `diff` array.

### Complexity:
- **Time Complexity**: The time complexity for processing all queries is O(q), where q is the number of queries (up to 10,000). Constructing the final matrix takes O(n^2), leading to an overall complexity of O(n^2 + q).
- **Space Complexity**: The space complexity is O(n^2) for the `diff` array and the resulting matrix `mat`.

This approach ensures that we efficiently handle potentially large numbers of updates to the matrix without directly iterating through the submatrices for each query, which would be computationally expensive.
