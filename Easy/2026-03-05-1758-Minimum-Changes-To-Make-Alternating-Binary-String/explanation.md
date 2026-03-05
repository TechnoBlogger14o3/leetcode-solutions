# Minimum Changes To Make Alternating Binary String (Easy)

**Problem ID:** 1758  
**Date:** 2026-03-05  
**Link:** https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/

## Approach

To solve the problem of converting a binary string into an alternating format with the minimum number of changes, we can follow a systematic approach:

### Approach:

1. **Understanding Alternating Patterns**:
   An alternating binary string can start with either '0' or '1'. Therefore, there are two possible valid patterns for a string of length `n`:
   - Pattern A: "010101..." (starts with '0')
   - Pattern B: "101010..." (starts with '1')

2. **Count Mismatches**:
   We will iterate through the given string `s` and compare each character to the expected character in both patterns (A and B). For each index `i`:
   - If `s[i]` does not match the expected character in Pattern A, we increment a mismatch counter for Pattern A.
   - Similarly, if `s[i]` does not match the expected character in Pattern B, we increment a mismatch counter for Pattern B.

3. **Calculate Minimum Changes**:
   After completing the iteration, we will have two counts:
   - `changesA`: Number of changes needed to convert `s` to Pattern A.
   - `changesB`: Number of changes needed to convert `s` to Pattern B.
   The result will be the minimum of these two counts, i.e., `min(changesA, changesB)`.

### Data Structures:
- We primarily use integer counters to keep track of mismatches for both patterns, which requires O(1) space. The iteration through the string requires O(n) time.

### Complexity:
- **Time Complexity**: O(n), where `n` is the length of the string `s`. We traverse the string once to count mismatches.
- **Space Complexity**: O(1), as we only use a fixed number of extra variables for counting.

This approach efficiently determines the minimum number of changes required to transform the input string into an alternating binary string by leveraging direct comparison to the expected patterns.
