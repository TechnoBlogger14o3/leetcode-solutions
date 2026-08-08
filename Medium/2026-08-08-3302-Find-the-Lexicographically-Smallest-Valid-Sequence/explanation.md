# Find the Lexicographically Smallest Valid Sequence (Medium)

**Problem ID:** 3302  
**Date:** 2026-08-08  
**Link:** https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/

## Approach

To solve the problem of finding the lexicographically smallest valid sequence of indices from `word1` that can be transformed into `word2` with at most one character change, we can follow a systematic approach:

### Approach:

1. **Two-Pointer Technique**: We will use two pointers, one iterating through `word1` and the other through `word2`. This allows us to efficiently check for matches and track the indices.

2. **Character Matching**: As we iterate, we will try to match characters from `word1` to `word2`. If the characters match, we simply move both pointers forward. If they do not match, we need to consider changing the character in `word1` to match the one in `word2`.

3. **Tracking Changes**: We need to ensure that we only allow one character change:
   - If we encounter a mismatch, we check if we have already made a change. If we have, we cannot proceed further.
   - If we haven't made a change yet, we can "pretend" to change the current character in `word1` to match the current character in `word2`, and then move both pointers forward.

4. **Index Collection**: Throughout the process, we will collect the indices of the characters from `word1` that contribute to forming `word2`. We need to ensure that these indices are sorted, which is naturally handled by the two-pointer approach.

5. **Lexicographical Order**: Since we are iterating through `word1` from left to right, the first valid sequence we find will inherently be the lexicographically smallest one.

6. **Edge Cases**: After the loop, we need to check if we have successfully matched all characters of `word2`. If not, we return an empty array, indicating that no valid sequence exists.

### Data Structures:
- Two pointers (or indices) for `word1` and `word2`.
- A list to store the valid indices from `word1`.

### Complexity:
- **Time Complexity**: O(n), where n is the length of `word1`. We traverse `word1` and `word2` at most once.
- **Space Complexity**: O(m), where m is the length of `word2`, for storing the result indices.

This approach efficiently finds the required indices while ensuring the constraints of the problem are met, resulting in a clear and optimal solution.
