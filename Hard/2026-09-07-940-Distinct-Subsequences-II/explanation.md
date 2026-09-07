# Distinct Subsequences II (Hard)

**Problem ID:** 940  
**Date:** 2026-09-07  
**Link:** https://leetcode.com/problems/distinct-subsequences-ii/

## Approach

To solve the problem of counting distinct non-empty subsequences of a string `s`, we can utilize a dynamic programming approach combined with a technique to handle duplicate characters efficiently.

### Main Idea:
The core idea is to maintain a dynamic programming array `dp` where `dp[i]` represents the number of distinct subsequences that can be formed using the first `i` characters of the string `s`. The relationship between the subsequences can be understood as follows:

1. For each character at position `i`, we can either include it in our subsequences or exclude it. 
2. If we include the character, it can form new subsequences by appending it to all existing subsequences formed from the first `i-1` characters.
3. If we exclude the character, the count remains the same as `dp[i-1]`.

Thus, the recurrence relation can be expressed as:
\[ dp[i] = 2 \times dp[i-1] \]

However, to avoid counting duplicate subsequences created by repeated characters, we need to subtract the subsequences that were counted in previous occurrences of the same character.

### Handling Duplicates:
To efficiently track the last occurrence of each character, we can use a dictionary (or array) `last` where `last[c]` stores the last index where character `c` appeared. When processing the current character `s[i-1]`, if it has appeared before at index `j`, we need to subtract the subsequences counted up to `j` from our current count to avoid duplicates:
\[ dp[i] = 2 \times dp[i-1] - dp[j-1] \]

If the character has not appeared before, we simply use:
\[ dp[i] = 2 \times dp[i-1] \]

### Base Case:
- Initialize `dp[0] = 1` to represent the empty subsequence.

### Final Count:
The result will be `dp[n] - 1` (subtracting 1 to exclude the empty subsequence).

### Complexity:
- **Time Complexity**: O(n), where `n` is the length of the string, as we process each character once.
- **Space Complexity**: O(n) for the `dp` array and O(1) for the `last` array (constant size for 26 lowercase letters).

In summary, the dynamic programming approach efficiently counts distinct subsequences while managing duplicates through the use of a last occurrence tracker, ensuring that we can handle the problem within the constraints provided.
