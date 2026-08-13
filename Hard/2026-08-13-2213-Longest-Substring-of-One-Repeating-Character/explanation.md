# Longest Substring of One Repeating Character (Hard)

**Problem ID:** 2213  
**Date:** 2026-08-13  
**Link:** https://leetcode.com/problems/longest-substring-of-one-repeating-character/

## Approach

To solve the problem of finding the longest substring of one repeating character after a series of character updates in a given string, we can adopt an efficient approach leveraging a combination of data structures and careful tracking of substring lengths.

### Problem-Solving Approach:

1. **Initial Analysis**:
   - The goal is to determine the length of the longest contiguous substring of identical characters after each update to the string.
   - Given the constraints, a naive approach that recalculates the longest substring after each update would be inefficient, leading to a time complexity of O(k * n) in the worst case.

2. **Data Structures**:
   - Use a list or array to store the lengths of contiguous segments of identical characters in the string.
   - Maintain a variable to track the current maximum length of these segments.

3. **Preprocessing**:
   - Before processing the queries, traverse the string once to create a list of segments that records the character and its length. For example, for the string "babacc", we would have segments like `[(b, 1), (a, 1), (b, 1), (a, 2), (c, 1)]`.
   - Calculate the initial maximum length of contiguous characters from these segments.

4. **Handling Updates**:
   - For each query, update the character at the specified index.
   - Check the character before and after the update to determine if merging of segments occurs:
     - If the updated character matches the previous character, extend the length of that segment.
     - If it matches the next character, extend that segment as well.
     - If merging occurs (i.e., the updated character connects two segments), adjust the lengths accordingly.
   - After each update, recalculate the maximum length of contiguous characters efficiently by checking only the affected segments (the one being updated and its immediate neighbors).

5. **Complexity**:
   - The preprocessing step takes O(n) time.
   - Each query update can be handled in O(1) time on average if we only check adjacent segments.
   - Thus, the overall time complexity is O(n + k), which is efficient given the constraints.

### Summary:
By preprocessing the string to identify segments of contiguous characters and then efficiently updating these segments during each query, we can maintain the maximum length of repeating characters without needing to re-evaluate the entire string after every update. This approach balances efficiency and clarity, ensuring that we stay within acceptable time limits for large inputs.
