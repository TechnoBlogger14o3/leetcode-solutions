# Magic Squares In Grid (Medium)

**Problem ID:** 840  
**Date:** 2025-12-30  
**Link:** https://leetcode.com/problems/magic-squares-in-grid/

## Approach

To solve the problem of counting 3x3 magic square subgrids in a given grid, we can follow a structured approach:

### Main Idea
A 3x3 magic square must contain distinct integers from 1 to 9, and each row, column, and both diagonals must sum to the same value, which is 15 for a 3x3 magic square. Therefore, our goal is to identify all possible 3x3 subgrids within the given grid and check if they satisfy the conditions of a magic square.

### Steps to Solve the Problem
1. **Iterate Through Possible Subgrids**: Since the grid can have dimensions up to 10x10, we can iterate through all possible top-left corners of 3x3 subgrids. The top-left corner can range from `(0, 0)` to `(row-3, col-3)`.

2. **Extract Subgrid**: For each position `(i, j)`, extract the 3x3 subgrid starting from that position. This involves collecting the elements in the range `grid[i][j]` to `grid[i+2][j+2]`.

3. **Check for Distinct Numbers**: Verify that all numbers in the extracted subgrid are distinct and fall within the range of 1 to 9. This can be efficiently done using a set to track the numbers.

4. **Calculate Sums**: If the numbers are valid, calculate the sums of each row, each column, and the two diagonals. All these sums should equal 15 for the subgrid to be a magic square.

5. **Count Valid Magic Squares**: Maintain a count of how many valid magic squares are found during the iteration.

### Data Structures
- A set can be used to check for distinct numbers efficiently.
- Simple integer variables can be used to store sums for rows, columns, and diagonals.

### Complexity
- **Time Complexity**: The algorithm runs in O((row-2) * (col-2) * 1) = O(row * col) for iterating through subgrids and checking conditions, which is efficient given the constraints.
- **Space Complexity**: The space complexity is O(1) for the counting variables and O(1) for the set used to check distinct numbers (since it can only hold up to 9 elements).

By following this approach, we can systematically determine the number of 3x3 magic squares in the given grid while adhering to the constraints and properties of magic squares.
