# Largest Magic Square (Medium)

**Problem ID:** 1895  
**Date:** 2026-01-18  
**Link:** https://leetcode.com/problems/largest-magic-square/

## Approach

To solve the problem of finding the largest magic square in a given grid, we can use a systematic approach that involves checking all possible sub-squares within the grid. Here’s a concise breakdown of the solution approach:

### Main Idea:
The main idea is to iterate through all possible top-left corners of potential k x k sub-squares in the grid and check if each sub-square is a magic square. A magic square is defined by the condition that all row sums, column sums, and both diagonal sums must be equal.

### Steps:
1. **Iterate Through Possible Sizes**: Start from the largest possible square size (min(m, n)) and decrease down to 1. This allows us to find the largest magic square first, thus we can return early when we find one.

2. **Check Each Sub-square**: For each potential top-left corner (i, j) of a k x k square, compute the sums of each row, column, and the two diagonals. 
   - If all sums are equal, then we have found a valid magic square of size k.

3. **Use Prefix Sums**: To efficiently calculate the sums of rows, columns, and diagonals, we can utilize prefix sums. This allows us to compute the sums in constant time after an initial preprocessing step.

4. **Return the Result**: As soon as we find a valid magic square of size k, we can return k as the result.

### Data Structures:
- **Prefix Sum Arrays**: To store cumulative sums for each row and column, which allows for quick sum calculations.
- **Variables for Sums**: To keep track of the individual sums of rows, columns, and diagonals.

### Complexity:
- **Time Complexity**: The worst-case scenario involves checking all possible k x k squares for all sizes, leading to a complexity of O(m * n * min(m, n)), where m is the number of rows and n is the number of columns. Each check involves O(k) operations for the sums.
- **Space Complexity**: O(m + n) for the prefix sum arrays.

This approach is efficient given the constraints (m, n ≤ 50), and ensures that we can find the largest magic square in a systematic manner.
