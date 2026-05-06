# Rotating the Box (Medium)

**Problem ID:** 1861  
**Date:** 2026-05-06  
**Link:** https://leetcode.com/problems/rotating-the-box/

## Approach

To solve the problem of rotating the box and simulating the effect of gravity on the stones, we can follow these steps:

### Main Idea
1. **Understanding Rotation**: When the box is rotated 90 degrees clockwise, the first row becomes the last column, the second row becomes the second last column, and so on. Therefore, for a given cell `(i, j)` in the original matrix, its new position after rotation will be `(j, m - 1 - i)` in the new matrix, where `m` is the number of rows in the original matrix.

2. **Gravity Simulation**: After rotation, we need to simulate the effect of gravity on the stones (`#`). This means that stones should fall downwards until they hit an obstacle (`*`), another stone, or the bottom of the box. We can achieve this by processing each column of the rotated matrix from bottom to top.

### Steps to Implement
1. **Create a New Matrix**: Initialize a new matrix of size `n x m` (where `n` is the number of columns in the original matrix and `m` is the number of rows) filled with empty cells (`.`).

2. **Fill the New Matrix**: For each column in the original matrix (processed from bottom to top):
   - Maintain a pointer for the position where the next stone should be placed in the new matrix.
   - For each cell in the column, check:
     - If it's a stone (`#`), place it in the current position of the pointer and move the pointer up (decrement).
     - If it's an obstacle (`*`), simply move the pointer to the row above it (decrement).
     - If it's empty (`.`), continue without any action.

3. **Return the New Matrix**: After processing all columns, the new matrix will represent the box after rotation and gravity simulation.

### Data Structures
- A 2D list (matrix) to hold the new configuration of the box after rotation and gravity simulation.

### Complexity
- **Time Complexity**: O(m * n), where `m` is the number of rows and `n` is the number of columns in the original matrix. We traverse each cell exactly once.
- **Space Complexity**: O(n * m) for the new matrix that stores the result.

This approach efficiently handles the rotation and gravity simulation in a straightforward manner, ensuring that we respect the constraints of the problem.
