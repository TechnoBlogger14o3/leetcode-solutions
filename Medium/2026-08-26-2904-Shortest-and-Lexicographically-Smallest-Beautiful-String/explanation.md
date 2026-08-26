# Shortest and Lexicographically Smallest Beautiful String (Medium)

**Problem ID:** 2904  
**Date:** 2026-08-26  
**Link:** https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/

## Approach

To solve the problem of finding the shortest and lexicographically smallest beautiful substring from a given binary string `s` with exactly `k` ones, we can adopt the following approach:

### Approach:

1. **Sliding Window Technique**: 
   - Use a sliding window to efficiently find substrings that contain exactly `k` ones. This involves maintaining two pointers (start and end) to represent the current substring and a counter to track the number of ones within this window.

2. **Count Ones**:
   - As we expand the end pointer, we incrementally count the number of ones. When the count exceeds `k`, we increment the start pointer to reduce the count back to `k`.

3. **Store Valid Substrings**:
   - Whenever we find a substring that contains exactly `k` ones, we check its length. If it is shorter than the previously found substrings, we update our record of the shortest substring. If it is of the same length, we compare it lexicographically to keep the smallest one.

4. **Edge Cases**:
   - If no valid substring is found after processing the entire string, return an empty string.

### Data Structures:
- **Variables**: Use simple integer counters for tracking the number of ones and indices for the sliding window.
- **String Storage**: Maintain a variable to store the current best substring found, which will be updated based on length and lexicographic comparisons.

### Complexity:
- **Time Complexity**: The approach operates in O(n) time complexity, where n is the length of the string `s`. This is because each character is processed at most twice (once by the end pointer and once by the start pointer).
- **Space Complexity**: O(1) for the counters and pointers, and O(m) for storing the resultant substring, where m is the length of the shortest beautiful substring.

By following this method, we efficiently find the desired substring while ensuring that we meet the problem's constraints and requirements.
