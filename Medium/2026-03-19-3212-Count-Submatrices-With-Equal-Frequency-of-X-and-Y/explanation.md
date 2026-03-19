# Count Submatrices With Equal Frequency of X and Y (Medium)

**Problem ID:** 3212  
**Date:** 2026-03-19  
**Link:** https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/

## Approach

To solve the problem of counting submatrices with equal frequencies of 'X' and 'Y', we can adopt the following approach:

### Main Idea:
The goal is to identify all submatrices that start from the top-left corner (0, 0) of the grid and contain an equal number of 'X' and 'Y', while ensuring that at least one 'X' is present in the submatrix. We can achieve this through a systematic exploration of all possible submatrices and maintaining the counts of 'X' and 'Y' within each submatrix.

### Steps to Approach:
1. **Iterate Over Possible Bottom-Right Corners**: For each cell in the grid, treat it as a potential bottom-right corner of a submatrix. The top-left corner is fixed at (0, 0).

2. **Count Characters**: As we extend the submatrix to include cells from (0, 0) to the current bottom-right corner (i, j), maintain a count of 'X' and 'Y'. This can be done using two variables, `countX` and `countY`.

3. **Check Conditions**: After updating the counts for each new cell included in the submatrix:
   - Check if `countX` is greater than 0 (to ensure at least one 'X' is present).
   - Check if `countX` equals `countY` (to ensure equal frequencies).

4. **Count Valid Submatrices**: For each valid configuration (where both conditions are satisfied), increment a counter that tracks the number of valid submatrices.

5. **Complexity Considerations**: 
   - The outer loops iterate over all possible bottom-right corners, leading to O(N^2) iterations, where N is the maximum dimension of the grid (up to 1000).
   - For each bottom-right corner, counting 'X' and 'Y' requires O(N) time in the worst case, leading to an overall complexity of O(N^4) in the naive implementation. However, optimizations can be made by using cumulative counts or prefix sums to reduce the time complexity.

### Data Structures:
- Two integer variables for counting 'X' and 'Y'.
- Optionally, a prefix sum array can be utilized to efficiently compute the counts of 'X' and 'Y' in any submatrix.

### Conclusion:
This approach leverages systematic enumeration of submatrices while maintaining counts of the required characters. By ensuring that we check for the conditions of presence and equality efficiently, we can derive the total number of valid submatrices that meet the problem's criteria.
