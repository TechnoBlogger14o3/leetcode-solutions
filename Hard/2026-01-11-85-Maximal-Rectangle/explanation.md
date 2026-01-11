# Maximal Rectangle (Hard)

**Problem ID:** 85  
**Date:** 2026-01-11  
**Link:** https://leetcode.com/problems/maximal-rectangle/

## Approach

To solve the "Maximal Rectangle" problem, we can leverage a dynamic programming approach combined with the concept of the largest rectangle in a histogram. The main idea is to treat each row of the binary matrix as the base of a histogram where the height of each column represents the number of consecutive '1's up to that row.

### Approach:

1. **Transform the Matrix**: 
   - Create an auxiliary array `heights` of size equal to the number of columns in the matrix. This array will store the heights of '1's for each column as we iterate through each row of the matrix.
   - For each cell in the matrix, if the cell contains '1', increment the corresponding height in `heights` by 1; if it contains '0', reset that height to 0.

2. **Calculate Maximum Rectangle for Each Row**:
   - For each row in the matrix, after updating the `heights` array, treat `heights` as a histogram and compute the largest rectangle that can be formed using the heights. This can be efficiently done using a stack-based approach which allows us to find the largest rectangle area in O(cols) time.

3. **Iterate Through Rows**:
   - Repeat the process for each row in the matrix, updating the `heights` and calculating the maximum rectangle area for each updated histogram.

4. **Track the Maximum Area**:
   - Maintain a variable to track the maximum area encountered during these calculations.

### Data Structures:
- An array `heights` to store the heights of '1's in each column.
- A stack to efficiently compute the largest rectangle area in the histogram.

### Complexity:
- **Time Complexity**: O(rows * cols), where `rows` is the number of rows and `cols` is the number of columns in the matrix. This is because we process each cell once and compute the histogram area in linear time for each row.
- **Space Complexity**: O(cols) for the `heights` array and O(cols) for the stack, leading to an overall space complexity of O(cols).

This approach effectively reduces the problem of finding the maximal rectangle in a binary matrix to a series of histogram problems, allowing us to solve it efficiently.
