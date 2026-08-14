# Maximum Length Substring With Two Occurrences (Easy)

**Problem ID:** 3090  
**Date:** 2026-08-14  
**Link:** https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/

## Approach

To solve the problem of finding the maximum length of a substring that contains at most two occurrences of each character, we can utilize a sliding window approach combined with a frequency map.

### Approach:

1. **Sliding Window Technique**: We maintain a window defined by two pointers, `left` and `right`, which represent the current substring we are evaluating. The `right` pointer expands the window by moving to the right, while the `left` pointer contracts the window when the substring exceeds the allowed character frequency.

2. **Frequency Map**: We use a dictionary (or hashmap) to track the frequency of each character within the current window. This allows us to quickly check how many times each character appears.

3. **Expand and Contract**:
   - Start with both pointers at the beginning of the string. Incrementally move the `right` pointer to include more characters into the window.
   - For each character added, update its count in the frequency map.
   - If any character's count exceeds 2, increment the `left` pointer to reduce the window size from the left until all characters in the window have counts of at most 2.

4. **Calculate Maximum Length**: During the process, keep track of the maximum length of valid substrings encountered. This can be done by calculating the length of the current window (`right - left + 1`) whenever the window is valid.

### Data Structures:
- A hashmap (or dictionary) to store character frequencies.
- Two integer pointers for the sliding window (`left` and `right`).

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. Each character is processed at most twice (once by the `right` pointer and once by the `left` pointer).
- **Space Complexity**: O(1) in terms of character storage, as the frequency map will store at most 26 entries (for lowercase English letters).

This approach efficiently finds the maximum length of the desired substring by leveraging the properties of the sliding window and maintaining a count of character occurrences, ensuring that we stay within the constraints of the problem.
