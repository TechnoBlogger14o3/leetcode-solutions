# Count Binary Substrings (Easy)

**Problem ID:** 696  
**Date:** 2026-02-19  
**Link:** https://leetcode.com/problems/count-binary-substrings/

## Approach

To solve the problem of counting binary substrings with equal numbers of consecutive '0's and '1's, we can employ a systematic approach that leverages the concept of grouping consecutive characters.

### Main Idea:
The core idea is to first identify and count groups of consecutive '0's and '1's in the binary string. Once we have these groups, we can determine how many valid substrings can be formed by comparing adjacent groups.

### Steps to Solve the Problem:

1. **Group Counting**:
   - Traverse the binary string and create a list that counts the lengths of consecutive '0's and '1's. For example, for the string "00110011", the counts would be `[2, 2, 2]` corresponding to two '0's, two '1's, and two '0's again.

2. **Calculate Valid Substrings**:
   - Iterate through the list of group counts. For each pair of adjacent groups (i.e., group[i] and group[i+1]), the number of valid substrings that can be formed is the minimum of the two counts. This is because a valid substring requires equal numbers of '0's and '1's, and the limiting factor will be the smaller group.
   - Sum these minimum values to get the total count of valid substrings.

### Data Structures:
- A simple list (or array) is used to store the counts of consecutive '0's and '1's. This allows efficient access and iteration through the groups.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input string. The string is traversed once to create the groups and once more to count valid substrings.
- **Space Complexity**: O(k), where k is the number of groups formed, which in the worst case is O(n) (if the string alternates between '0's and '1's).

By following this approach, we can efficiently count the number of valid binary substrings in the given binary string.
