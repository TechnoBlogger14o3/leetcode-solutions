# Delete Columns to Make Sorted III (Hard)

**Problem ID:** 960  
**Date:** 2025-12-22  
**Link:** https://leetcode.com/problems/delete-columns-to-make-sorted-iii/

## Approach

To solve the problem of deleting columns to make the rows of strings lexicographically sorted, we can employ a dynamic programming approach. The main idea is to determine the minimum number of columns that need to be deleted such that each string in the array is sorted.

### Approach:

1. **Dynamic Programming Table**: We will maintain a DP array `dp` where `dp[i]` represents the minimum number of columns to delete to ensure that the first `i` strings are sorted lexicographically.

2. **Column Comparison**: For each column, we will check how it affects the lexicographic order of the strings. Specifically, we will iterate through each column and compare the characters of the strings in that column. If the characters in that column are not sorted, we will consider deleting that column.

3. **State Transition**: For each string, we will maintain a state that reflects the last position where a character was added to the sorted order. If the current column maintains the order for all strings compared to their previous valid positions, we can update our DP state accordingly.

4. **Iterate Over Columns**: We will iterate through each column and update our DP array based on whether the current column can be retained or must be deleted.

5. **Result Calculation**: The final answer will be the total number of columns minus the maximum number of columns that can be retained while keeping the strings sorted.

### Data Structures:
- **DP Array**: To keep track of the minimum deletions needed for the first `i` strings.
- **Set or List**: To keep track of the last valid positions for each string to facilitate comparisons.

### Complexity:
- **Time Complexity**: O(n * m^2), where `n` is the number of strings and `m` is the length of each string. This is due to the nested iteration over the columns and the strings for comparisons.
- **Space Complexity**: O(n), for the DP array.

This approach efficiently determines the minimum number of deletions required to achieve the desired ordering of strings while leveraging the properties of dynamic programming to build up solutions based on previous states.
