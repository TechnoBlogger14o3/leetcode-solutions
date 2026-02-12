# Longest Balanced Substring I (Medium)

**Problem ID:** 3713  
**Date:** 2026-02-12  
**Link:** https://leetcode.com/problems/longest-balanced-substring-i/

## Approach

To solve the problem of finding the longest balanced substring, we can adopt a systematic approach that leverages character frequency counting and the concept of sliding windows.

### Main Idea:
The central idea is to identify substrings where all distinct characters appear the same number of times. We can achieve this by iterating through all possible substring lengths and checking for balance by counting character occurrences.

### Approach:
1. **Iterate Over Substring Lengths**: For each possible number of distinct characters (from 1 to 26, since we only have lowercase English letters), we will check all possible substrings of that length.

2. **Character Frequency Count**: For each substring, maintain a frequency count of characters using a dictionary or a fixed-size array (since we know the character set). 

3. **Check for Balance**: For a substring to be balanced, all characters in the frequency count must have the same non-zero frequency. We can achieve this by:
   - Collecting the frequencies of the characters present in the substring.
   - Checking if all frequencies are the same.

4. **Sliding Window Technique**: To optimize the substring checking:
   - Use a sliding window to maintain the current substring's character counts. As you move the window (expand or contract), update the counts accordingly.
   - This avoids recalculating frequencies from scratch for overlapping substrings.

5. **Track Maximum Length**: Throughout the iterations, keep track of the maximum length of balanced substrings found.

### Data Structures:
- A frequency dictionary or an array (size 26) to count occurrences of characters.
- Variables to store the maximum length of balanced substrings found.

### Complexity:
- The time complexity is approximately O(n^2) in the worst case due to the nested iterations for substring lengths and the sliding window checks. However, since the maximum length of the string is 1000, this is manageable within typical competitive programming constraints.
- The space complexity is O(1) for the frequency array (constant space) since it only holds counts for 26 characters.

By implementing this approach, we can efficiently determine the length of the longest balanced substring in the given string.
