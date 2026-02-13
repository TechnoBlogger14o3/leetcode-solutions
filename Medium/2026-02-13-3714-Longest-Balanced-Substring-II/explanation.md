# Longest Balanced Substring II (Medium)

**Problem ID:** 3714  
**Date:** 2026-02-13  
**Link:** https://leetcode.com/problems/longest-balanced-substring-ii/

## Approach

To solve the problem of finding the longest balanced substring in a string consisting of characters 'a', 'b', and 'c', we can utilize a sliding window approach combined with frequency counting. Here's a concise breakdown of the approach:

### Main Idea:
The goal is to identify substrings where all distinct characters appear the same number of times. Given that there are only three distinct characters, we can leverage this limited set to efficiently check for balance.

### Approach:
1. **Sliding Window Technique**: Use two pointers (`left` and `right`) to represent the current substring. Expand the `right` pointer to include characters until a balanced condition is violated, then move the `left` pointer to restore balance.

2. **Frequency Count**: Maintain a frequency count of characters within the current window using a dictionary or array. This will help in checking if the substring is balanced.

3. **Balance Check**: For a substring to be balanced:
   - Count the occurrences of each character ('a', 'b', 'c').
   - Determine the minimum frequency among the characters that are present in the substring.
   - Check if all characters have the same frequency (equal to the minimum frequency).

4. **Iterate through the string**: Move the `right` pointer to expand the window and check for balance. If the substring becomes unbalanced, increment the `left` pointer to shrink the window until balance is restored.

5. **Track Maximum Length**: Throughout the process, keep track of the maximum length of any balanced substring found.

### Data Structures:
- A frequency dictionary or array to count occurrences of 'a', 'b', and 'c'.
- Two pointers (`left` and `right`) to manage the current window of the substring.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. Each character is processed at most twice (once by the `right` pointer and once by the `left` pointer).
- **Space Complexity**: O(1) for the frequency count, as we only need a fixed number of counters for the three characters.

This approach efficiently identifies the longest balanced substring by dynamically adjusting the window size and checking balance conditions, ensuring optimal performance even for larger strings.
