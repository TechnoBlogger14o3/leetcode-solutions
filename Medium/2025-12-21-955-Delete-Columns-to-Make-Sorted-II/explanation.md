# Delete Columns to Make Sorted II (Medium)

**Problem ID:** 955  
**Date:** 2025-12-21  
**Link:** https://leetcode.com/problems/delete-columns-to-make-sorted-ii/

## Approach

To solve the problem "Delete Columns to Make Sorted II," we need to ensure that the strings in the given array are in lexicographic order after potentially deleting some columns. The key insight is to focus on the columns themselves rather than the individual characters in the strings.

### Approach:

1. **Initialization**: Start by defining a variable to keep track of the number of columns we need to delete. We also need a boolean array to mark which columns are valid (i.e., which columns can be kept without violating the lexicographic order).

2. **Iterate Over Columns**: For each column, check if it maintains the lexicographic order when compared to the previous column. If the current column is lexicographically less than the previous column, it must be deleted.

3. **Handling Equal Columns**: If the current column is equal to the previous column, we need to check if we have already marked any previous columns for deletion. If so, we can keep the current column; if not, we may need to mark it for deletion as well.

4. **Marking Deletions**: Use a set or a boolean array to keep track of which columns have been marked for deletion. This helps avoid double counting columns that need to be deleted.

5. **Count Deletions**: After processing all columns, the total number of deletions required will be the size of the set or the count of true values in the boolean array that indicates marked columns.

### Data Structures:
- A boolean array (or set) to track columns that need to be deleted.
- Simple integer counters to keep track of the number of deletions.

### Complexity:
- **Time Complexity**: O(n * m), where n is the number of strings and m is the length of each string. We iterate through each column and compare it with the previous one.
- **Space Complexity**: O(m) for the boolean array or set used to track deletions.

This approach efficiently determines the minimum number of columns to delete while ensuring that the remaining strings are in the required order. By focusing on the relationships between columns rather than individual characters, we can simplify the problem and reach a solution effectively.
