# Delete Columns to Make Sorted (Easy)

**Problem ID:** 944  
**Date:** 2025-12-20  
**Link:** https://leetcode.com/problems/delete-columns-to-make-sorted/

## Approach

To solve the problem of deleting columns to make the strings sorted lexicographically, we can follow a straightforward approach:

### Problem Understanding
We are given an array of strings of equal length, which can be visualized as a grid. Our goal is to identify and count the columns that are not sorted in lexicographical order when viewed top to bottom.

### Approach
1. **Iterate through Columns**: We will iterate through each column index from `0` to `m-1` (where `m` is the length of the strings).
  
2. **Check Column Order**: For each column, we will check if the characters are in non-decreasing order. This can be done by comparing each character in the current column with the character directly below it for all rows.

3. **Count Unsorted Columns**: If we find that a column is not sorted (i.e., any character in the column is greater than the character below it), we will increment a counter that keeps track of the number of unsorted columns.

### Data Structures
- We primarily use a simple integer counter to keep track of the number of columns to delete.
- The input strings can be treated as a 2D array conceptually, but we do not need to create any additional data structures beyond basic variables.

### Complexity
- **Time Complexity**: The solution will run in \(O(n \times m)\), where \(n\) is the number of strings (rows) and \(m\) is the length of each string (columns). This is because we check each column across all rows.
- **Space Complexity**: The space complexity is \(O(1)\) as we are using a constant amount of space for counters and indices, regardless of the input size.

### Summary
The main idea is to systematically check each column for order, counting how many columns are unsorted. This approach is efficient given the constraints and effectively solves the problem by leveraging simple iteration and comparisons.
