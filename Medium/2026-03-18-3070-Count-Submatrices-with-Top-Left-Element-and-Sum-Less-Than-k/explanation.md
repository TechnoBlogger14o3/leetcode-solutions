# Count Submatrices with Top-Left Element and Sum Less Than k (Medium)

**Problem ID:** 3070  
**Date:** 2026-03-18  
**Link:** https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/

## Approach

To solve the problem of counting submatrices with the top-left element and a sum less than or equal to `k`, we can leverage a systematic approach that involves prefix sums and efficient counting techniques.

### Approach:

1. **Understanding Submatrices**: 
   We need to count all possible submatrices that start from the top-left corner (0,0) of the grid. A submatrix is defined by its bottom-right corner, which can vary from (0,0) to (m-1,n-1) where `m` is the number of rows and `n` is the number of columns.

2. **Prefix Sum Calculation**:
   To efficiently compute the sum of any submatrix, we can use a prefix sum array. The prefix sum at position `(i, j)` will store the sum of all elements from the top-left corner `(0, 0)` to `(i, j)`. This allows us to compute the sum of any submatrix in constant time.

3. **Iterate Over Possible Bottom-Right Corners**:
   For each possible bottom-right corner `(i, j)` of the submatrix, we will calculate the sum of the submatrix defined from `(0, 0)` to `(i, j)` using the prefix sum array.

4. **Count Valid Submatrices**:
   If the sum of the current submatrix is less than or equal to `k`, we increment our count. This involves checking each possible bottom-right corner and using the prefix sum to determine the sum efficiently.

5. **Complexity**:
   - The time complexity is O(m * n), where `m` is the number of rows and `n` is the number of columns. This is because we are iterating through each cell in the grid once to compute the prefix sums and then again to count valid submatrices.
   - The space complexity is O(m * n) for storing the prefix sums.

### Data Structures:
- A 2D array for the prefix sums to store cumulative sums.
- Simple integer variables to keep track of the count of valid submatrices.

### Summary:
By using prefix sums, we can efficiently calculate the sum of submatrices originating from the top-left corner of the grid. The overall approach is straightforward, leveraging cumulative sums to reduce the complexity of sum calculations, allowing us to focus on counting the valid configurations that meet the criteria of having a sum less than or equal to `k`.
