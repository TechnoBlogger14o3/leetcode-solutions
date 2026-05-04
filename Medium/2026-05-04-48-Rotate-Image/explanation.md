# Rotate Image (Medium)

**Problem ID:** 48  
**Date:** 2026-05-04  
**Link:** https://leetcode.com/problems/rotate-image/

## Approach

To solve the problem of rotating an n x n matrix (image) by 90 degrees clockwise in-place, we can break down the solution into two main steps: transposing the matrix and then reversing the rows.

### Approach:

1. **Transpose the Matrix**:
   - The first step is to transpose the matrix, which means converting rows into columns. For an element at position `(i, j)`, it will move to `(j, i)`. This can be done in-place by swapping elements symmetrically across the main diagonal (from top-left to bottom-right).
   - Specifically, for each element in the upper triangle of the matrix (where `i < j`), swap `matrix[i][j]` with `matrix[j][i]`.

2. **Reverse Each Row**:
   - After transposing the matrix, the next step is to reverse each row. This will effectively rotate the image by 90 degrees clockwise. For each row, swap the elements from the start and end moving towards the center.
   - This can be accomplished by iterating through each row and swapping elements at indices `j` and `n-1-j` for `j` from `0` to `n/2`.

### Data Structures:
- The solution operates directly on the input matrix, so no additional data structures are needed. We manipulate the matrix in-place, adhering to the problem's constraints.

### Complexity:
- **Time Complexity**: O(n^2) - Both the transposition and the row reversal involve iterating through all elements of the n x n matrix.
- **Space Complexity**: O(1) - Since we are modifying the matrix in-place, we do not use any extra space proportional to the input size.

This approach efficiently rotates the image while fulfilling the requirement to do so in-place, making it optimal for the problem constraints.
