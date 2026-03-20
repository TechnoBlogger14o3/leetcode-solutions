# Minimum Absolute Difference in Sliding Submatrix (Medium)

**Problem ID:** 3567  
**Date:** 2026-03-20  
**Link:** https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/

## Approach

To solve the problem of finding the minimum absolute difference in each contiguous \( k \times k \) submatrix of a given matrix, we can follow a systematic approach that leverages efficient data structures for maintaining and querying values.

### Approach:

1. **Iterate Through Submatrices**: We need to slide a \( k \times k \) window across the matrix. This involves iterating through all possible top-left corners of the submatrices, which can be done using two nested loops, one for the rows and one for the columns. The number of such positions is \( (m - k + 1) \times (n - k + 1) \).

2. **Extract Distinct Values**: For each \( k \times k \) submatrix, we need to gather all distinct values. This can be efficiently done using a set to avoid duplicates.

3. **Calculate Minimum Absolute Difference**: Once we have the distinct values, we can sort them. The minimum absolute difference can then be found by comparing adjacent values in the sorted list. This is because the smallest difference will always occur between two closest numbers in a sorted array.

4. **Handle Edge Cases**: If all values in the submatrix are the same, the minimum absolute difference is 0. This can be easily checked by examining the size of the set of distinct values.

### Data Structures:

- **Set**: To collect distinct values from the \( k \times k \) submatrix.
- **List/Array**: To store the sorted distinct values for calculating differences.

### Complexity:

- **Time Complexity**: The overall complexity can be approximated as \( O((m - k + 1) \times (n - k + 1) \times k^2 \log k) \). The \( k^2 \) comes from extracting values from the submatrix, and \( \log k \) is from sorting the distinct values.
- **Space Complexity**: The space used is primarily for the set of distinct values, which can be at most \( O(k^2) \) in the worst case.

### Summary:

This approach efficiently computes the minimum absolute difference for each \( k \times k \) submatrix by leveraging sets for distinct value collection and sorting for difference calculation. The sliding window technique ensures that we cover all possible submatrices while keeping the operations manageable within the constraints provided.
