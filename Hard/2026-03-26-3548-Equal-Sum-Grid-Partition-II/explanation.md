# Equal Sum Grid Partition II (Hard)

**Problem ID:** 3548  
**Date:** 2026-03-26  
**Link:** https://leetcode.com/problems/equal-sum-grid-partition-ii/

## Approach

To solve the "Equal Sum Grid Partition II" problem, we need to determine if we can make a horizontal or vertical cut in the given grid such that the sums of the resulting sections are equal or can be made equal by discounting at most one cell.

### Approach:

1. **Calculate Total Sums**:
   - First, compute the total sum of all elements in the grid. This will help us determine the target sums for the two sections after a cut.

2. **Prefix Sums**:
   - For both horizontal and vertical cuts, we will maintain prefix sums to efficiently calculate the sum of elements in each section.
   - For horizontal cuts, compute the cumulative sum of rows. For vertical cuts, compute the cumulative sum of columns.

3. **Check Conditions for Cuts**:
   - For each potential horizontal cut (between rows), calculate the sum of the top section and the bottom section.
     - If the sums are equal, return `true`.
     - If they are not equal, check if discounting one cell from either section can equalize the sums.
   - For each potential vertical cut (between columns), perform a similar check.

4. **Discounting Logic**:
   - When checking if discounting a cell can make the sums equal, ensure that the cell being discounted is part of the section being adjusted. This requires careful tracking of the cells in each section.

5. **Complexity**:
   - The algorithm primarily involves calculating prefix sums and iterating through possible cuts, resulting in a time complexity of O(m + n), where m is the number of rows and n is the number of columns. Given the constraints, this is efficient.

### Data Structures:
- Use arrays to store prefix sums for rows and columns.
- Maintain variables to keep track of current sums during iteration.

### Conclusion:
By leveraging prefix sums and systematically checking possible cuts, we can efficiently determine if a valid partition exists that meets the problem's criteria. The key is to ensure that the sections remain connected and that we handle the discounting of cells correctly.
