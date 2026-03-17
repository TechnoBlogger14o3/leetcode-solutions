# Largest Submatrix With Rearrangements (Medium)

**Problem ID:** 1727  
**Date:** 2026-03-17  
**Link:** https://leetcode.com/problems/largest-submatrix-with-rearrangements/

## Approach

To solve the problem of finding the largest submatrix with all 1s after rearranging the columns of a binary matrix, we can follow a systematic approach that leverages the properties of histograms and sorting.

### Main Idea:
The primary insight is that by rearranging the columns, we can treat each row of the matrix as the base of a histogram where the height of each column represents the number of consecutive 1s up to that row. By calculating the heights for each row, we can then find the maximum area of rectangles that can be formed using these heights.

### Steps:
1. **Calculate Heights**: 
   - Create an auxiliary array `heights` of size `n` (number of columns) to store the height of 1s for each column. For each cell in the matrix, if the cell is 1, increment the corresponding height; if it is 0, reset the height to 0.

2. **Sort Heights**:
   - For each row, after updating the `heights`, sort this array. Sorting allows us to efficiently calculate the maximum area for the current row by treating the sorted heights as potential heights of rectangles.

3. **Calculate Maximum Area**:
   - For each height in the sorted `heights` array, compute the area of the rectangle that can be formed using that height. The width of the rectangle is determined by the index of the height in the sorted array (i.e., `i + 1`, where `i` is the index). The area for each height can be calculated as `height * width`.

4. **Track Maximum Area**:
   - Maintain a variable to track the maximum area encountered during the iterations through the rows.

### Data Structures:
- An array `heights` to store the heights of 1s for each column.
- Sorting can be done using a built-in sort function, which typically has a time complexity of O(n log n).

### Complexity:
- The time complexity is O(m * n log n) in the worst case, where `m` is the number of rows and `n` is the number of columns. This is due to the need to sort the heights for each row.
- The space complexity is O(n) for the `heights` array.

By following this approach, we can efficiently compute the area of the largest submatrix filled with 1s after optimally rearranging the columns of the binary matrix.
