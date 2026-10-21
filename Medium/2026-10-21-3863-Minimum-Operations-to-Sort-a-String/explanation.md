# Minimum Operations to Sort a String (Medium)

**Problem ID:** 3863  
**Date:** 2026-10-21  
**Link:** https://leetcode.com/problems/minimum-operations-to-sort-a-string/

## Approach

To solve the problem of determining the minimum operations required to sort a string `s` using the specified substring sorting operation, we can follow a systematic approach:

### Problem Breakdown
1. **Understanding Sorting Constraints**: We can only sort substrings that are not the entire string. If the string is already sorted, no operations are needed. If the string cannot be sorted into a non-descending order through the allowed operations, we should return -1.

2. **Identifying Sorted Segments**: The key observation is to identify segments of the string that are already sorted. A sorted segment can be defined as a contiguous subsequence where each character is less than or equal to the next. 

3. **Counting Unsorted Segments**: By iterating through the string, we can count how many segments are out of order. Specifically, we can track the transitions between characters where the order breaks (i.e., when `s[i] > s[i+1]`). Each such transition indicates a point where a sorting operation would be necessary.

### Approach
1. **Count the Number of Unsorted Segments**:
   - Traverse the string and count the number of times the order breaks (i.e., `s[i] > s[i+1]`). Each break represents a point where a sorting operation would be needed.

2. **Determine Feasibility**:
   - If the string contains characters that cannot be sorted into a non-descending order (for instance, if the largest character appears before the smallest character in a way that prevents sorting), we should return -1. This can be checked by ensuring that the maximum character seen so far does not exceed the minimum character seen in the remaining part of the string.

3. **Calculate Operations**:
   - The minimum number of operations required to sort the string will be equal to the number of unsorted segments counted. If there are no breaks, the string is already sorted, and thus 0 operations are needed.

### Data Structures
- A simple integer counter can be used to track the number of unsorted segments.
- We may also use variables to keep track of the maximum and minimum characters encountered during the traversal for feasibility checks.

### Complexity
- **Time Complexity**: O(n), where n is the length of the string. We only need a single pass through the string to count the transitions and check feasibility.
- **Space Complexity**: O(1), as we are only using a constant amount of extra space for counters and variables.

### Conclusion
By counting the number of unsorted segments and checking the feasibility of sorting the string, we can efficiently determine the minimum number of operations required to sort the string or conclude that it is impossible to do so.
