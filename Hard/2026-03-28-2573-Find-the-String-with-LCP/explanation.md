# Find the String with LCP (Hard)

**Problem ID:** 2573  
**Date:** 2026-03-28  
**Link:** https://leetcode.com/problems/find-the-string-with-lcp/

## Approach

To solve the problem of reconstructing the lexicographically smallest string from the given LCP matrix, we can follow a systematic approach:

### Main Idea:
The core idea is to construct a string `word` such that the longest common prefix (LCP) conditions specified in the matrix are satisfied. Each entry `lcp[i][j]` indicates the length of the longest common prefix between the suffixes starting from indices `i` and `j` in the string. 

### Steps to Approach:

1. **Initialization**: Start by initializing an array `word` of length `n` to store the characters of the resulting string.

2. **Character Assignment**:
   - For each index `i` in the string, determine the character to assign based on the LCP values with previously assigned characters.
   - If `lcp[i][j] > 0`, it implies that the characters at indices `i` and `j` must be the same for the prefix to be valid. This creates a dependency between characters.
   - Use a greedy approach to assign characters starting from the smallest possible character ('a') while ensuring that all dependencies are respected.

3. **Validation**:
   - After assigning characters, validate the constructed string against the LCP matrix. For each pair `(i, j)`, check if the length of the common prefix derived from the constructed string matches `lcp[i][j]`.
   - If any mismatch is found, return an empty string as it indicates that no valid string can be constructed.

4. **Lexicographical Order**:
   - By always trying to assign the smallest available character that satisfies the LCP constraints, we ensure that the resulting string is lexicographically smallest.

### Data Structures:
- An array `word` of size `n` to hold the characters of the resulting string.
- A set or a simple character tracking mechanism to ensure that we are assigning the smallest character available.

### Complexity:
- The overall complexity is O(n^2) due to the nested loops required to validate the LCP conditions for each pair of indices in the matrix. This is efficient enough given the constraints (with `n` up to 1000).

### Conclusion:
By carefully assigning characters based on the LCP matrix and validating the result, we can reconstruct the desired string efficiently while ensuring it is the lexicographically smallest possible string that meets the criteria outlined in the problem statement.
