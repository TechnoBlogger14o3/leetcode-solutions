# Determine Whether Matrix Can Be Obtained By Rotation (Easy)

**Problem ID:** 1886  
**Date:** 2026-03-22  
**Link:** https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

## Approach

To solve the problem of determining whether the matrix `mat` can be transformed into the matrix `target` through 90-degree rotations, we can follow a straightforward approach based on matrix manipulation.

### Main Idea:
The core idea is to generate all possible rotations of the matrix `mat` (0, 90, 180, and 270 degrees) and check if any of these rotations match the `target` matrix. 

### Steps:
1. **Rotation Function**: Create a helper function that takes a matrix and returns its 90-degree clockwise rotation. This can be achieved by rearranging the elements such that the first row of the original matrix becomes the last column of the rotated matrix, the second row becomes the second last column, and so forth.

2. **Generate Rotations**: Start with the original matrix `mat` and iteratively apply the rotation function to generate the rotated versions:
   - The first rotation is the original matrix.
   - The second rotation is obtained by rotating the first rotation.
   - The third rotation is obtained by rotating the second rotation.
   - The fourth rotation is obtained by rotating the third rotation.

3. **Comparison**: After generating the four possible matrices (original and three rotations), compare each of them with the `target` matrix. If any of the matrices match `target`, return `true`. If none match after all rotations, return `false`.

### Data Structures:
- A 2D list (matrix) to represent both `mat` and `target`.
- A temporary matrix to hold the rotated version during the rotation process.

### Complexity:
- **Time Complexity**: The rotation operation involves iterating through the matrix elements, which is O(n^2) for each rotation. Since we perform this operation four times (for 0, 90, 180, and 270 degrees), the overall time complexity is O(4 * n^2) = O(n^2).
- **Space Complexity**: The space used for the temporary rotated matrix is O(n^2) as well, leading to an overall space complexity of O(n^2).

This approach is efficient given the constraints (1 ≤ n ≤ 10), making it feasible to check all rotations directly.
