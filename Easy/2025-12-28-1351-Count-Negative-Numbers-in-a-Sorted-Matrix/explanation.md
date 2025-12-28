# Count Negative Numbers in a Sorted Matrix (Easy)

**Problem ID:** 1351  
**Date:** 2025-12-28  
**Link:** https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

## Approach

To solve the problem of counting negative numbers in a sorted matrix, we can leverage the properties of the matrix's sorted order. The matrix is sorted in non-increasing order both row-wise and column-wise, which means that as we move right in a row or down in a column, the values do not increase.

### Approach:

1. **Start from the Bottom-Left Corner**: 
   - Begin at the bottom-left corner of the matrix (i.e., the last row and the first column). This position allows us to efficiently navigate the matrix based on the values we encounter.

2. **Traverse the Matrix**:
   - If the current number is negative, all numbers above it in the same column will also be negative (due to the sorted property). Therefore, we can count all the remaining elements in that column as negative and move one step to the right to check the next column.
   - If the current number is non-negative, it indicates that all numbers to the left in the same row are also non-negative. Thus, we move one step up to check the next row.

3. **Count Negatives**:
   - Maintain a counter to keep track of the total number of negative numbers encountered during the traversal.

### Data Structures:
- A simple integer counter to keep track of the count of negative numbers.
- No additional data structures are needed since we are iterating through the matrix directly.

### Complexity:
- **Time Complexity**: O(n + m), where n is the number of rows and m is the number of columns. In the worst case, we traverse each row and column once.
- **Space Complexity**: O(1), as we are using only a fixed amount of space for the counter and no additional data structures.

This approach efficiently counts the negative numbers while taking full advantage of the matrix's sorted properties, ensuring that we meet the follow-up requirement of achieving O(n + m) time complexity.
