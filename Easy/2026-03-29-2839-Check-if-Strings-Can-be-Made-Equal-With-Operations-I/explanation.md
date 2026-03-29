# Check if Strings Can be Made Equal With Operations I (Easy)

**Problem ID:** 2839  
**Date:** 2026-03-29  
**Link:** https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/

## Approach

To solve the problem of determining if two strings `s1` and `s2` of length 4 can be made equal through a series of defined operations, we can leverage the properties of the allowed swaps.

### Approach:

1. **Understanding the Swap Operation**:
   The operation allows us to swap characters at indices `i` and `j` such that `j - i = 2`. For a string of length 4, this means we can swap:
   - Characters at indices (0, 2)
   - Characters at indices (1, 3)

   This effectively means that:
   - The characters at even indices (0 and 2) can be rearranged among themselves.
   - The characters at odd indices (1 and 3) can also be rearranged among themselves.

2. **Grouping Characters**:
   Given the above, we can group the characters of both strings based on their indices:
   - For `s1`, we can create two groups: 
     - `even_group1 = (s1[0], s1[2])`
     - `odd_group1 = (s1[1], s1[3])`
   - Similarly, for `s2`:
     - `even_group2 = (s2[0], s2[2])`
     - `odd_group2 = (s2[1], s2[3])`

3. **Checking for Equality**:
   To determine if the strings can be made equal, we need to check if:
   - The characters in `even_group1` can be rearranged to match `even_group2`.
   - The characters in `odd_group1` can be rearranged to match `odd_group2`.

   This can be efficiently checked by sorting both groups and comparing them:
   - `sorted(even_group1) == sorted(even_group2)`
   - `sorted(odd_group1) == sorted(odd_group2)`

4. **Final Decision**:
   If both conditions are satisfied, we return `true`; otherwise, we return `false`.

### Complexity:
- **Time Complexity**: The sorting of two groups of size 2 takes constant time, O(1), since the size is fixed and small.
- **Space Complexity**: We use a constant amount of space, O(1), for storing the groups.

### Summary:
By grouping the characters based on their indices and checking if these groups can be rearranged to match each other, we can efficiently determine if `s1` can be transformed into `s2` using the allowed operations.
