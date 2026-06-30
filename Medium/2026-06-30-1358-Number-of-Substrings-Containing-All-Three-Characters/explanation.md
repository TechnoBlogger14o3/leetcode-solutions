# Number of Substrings Containing All Three Characters (Medium)

**Problem ID:** 1358  
**Date:** 2026-06-30  
**Link:** https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

## Approach

To solve the problem of counting the number of substrings containing at least one occurrence of the characters 'a', 'b', and 'c', we can utilize a sliding window approach combined with a frequency count.

### Approach:

1. **Sliding Window Technique**: We maintain a window defined by two pointers (let's call them `left` and `right`) that will traverse the string. The `right` pointer expands the window by moving to the right, while the `left` pointer contracts the window from the left when necessary.

2. **Character Frequency Count**: We maintain a count of the characters 'a', 'b', and 'c' within the current window using a simple array or dictionary. This helps us quickly check whether our current window contains all three characters.

3. **Validating the Window**: As we expand the `right` pointer, we check if our current window contains at least one of each character. If it does, we can count how many valid substrings can be formed with the current `right` position:
   - All substrings starting from indices `left` to `right` are valid. The number of such substrings is `len(s) - right`, where `len(s)` is the length of the string. This is because for each valid starting position from `left` to `right`, we can extend the substring to the end of the string.

4. **Contracting the Window**: Once we have counted the valid substrings for a given `right`, we increment the `left` pointer to potentially find new valid substrings, updating our character frequency count accordingly.

5. **Repeat**: We continue this process until the `right` pointer has traversed the entire string.

### Complexity:

- **Time Complexity**: O(n), where n is the length of the string. Each character is processed at most twice (once by the `right` pointer and once by the `left` pointer).
- **Space Complexity**: O(1), as we are using a fixed-size array (or dictionary) to count the occurrences of 'a', 'b', and 'c'.

This approach efficiently counts the required substrings without needing to generate all possible substrings explicitly, making it suitable for the input size constraints.
