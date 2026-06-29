# Number of Strings That Appear as Substrings in Word (Easy)

**Problem ID:** 1967  
**Date:** 2026-06-29  
**Link:** https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/

## Approach

To solve the problem of counting how many strings from the `patterns` array appear as substrings in the `word`, we can adopt a straightforward approach that leverages string searching.

### Approach:

1. **Initialization**: Start by initializing a counter to keep track of how many patterns are found as substrings in the word.

2. **Iterate through Patterns**: Loop through each string in the `patterns` array.

3. **Substring Check**: For each pattern, check if it exists as a substring in the `word`. This can be efficiently done using Python's `in` keyword, which checks for substring presence.

4. **Count Matches**: If a pattern is found in the `word`, increment the counter.

5. **Return Result**: After checking all patterns, return the counter as the result.

### Data Structures:
- We primarily use a list (or array) for the `patterns`, and a string for the `word`. The main data structure involved for counting is an integer variable (the counter).

### Complexity:
- **Time Complexity**: The overall complexity is O(n * m), where `n` is the number of patterns (up to 100) and `m` is the length of the longest pattern (up to 100). In the worst case, each pattern could be checked against the `word`, which has a maximum length of 100.
  
- **Space Complexity**: The space complexity is O(1) for the counter, as we are not using any additional data structures that grow with input size.

This approach is efficient given the problem constraints and straightforward to implement, making it suitable for the easy difficulty level of the problem.
