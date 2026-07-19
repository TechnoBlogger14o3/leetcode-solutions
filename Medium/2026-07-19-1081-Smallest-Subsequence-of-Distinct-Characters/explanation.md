# Smallest Subsequence of Distinct Characters (Medium)

**Problem ID:** 1081  
**Date:** 2026-07-19  
**Link:** https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

## Approach

To solve the problem of finding the lexicographically smallest subsequence of distinct characters from a given string, we can employ a greedy algorithm with the help of a stack and a few auxiliary data structures. Here's the approach:

### Main Idea:
1. **Character Frequency Count**: First, we need to determine the frequency of each character in the string. This helps us know how many times each character appears and when we might encounter them again as we build our result.

2. **Stack for Result Construction**: We use a stack to construct the resulting subsequence. The stack will help us maintain the order of characters while ensuring that we can easily backtrack if we find a smaller character that can replace the top of the stack.

3. **Set for Uniqueness**: A set is used to track characters that have already been added to the stack. This ensures that we only keep distinct characters in our result.

### Steps:
- Iterate through each character in the string.
- For each character:
  - Decrease its frequency count (indicating that we've seen it).
  - If the character is already in the result (tracked by the set), skip it.
  - While the stack is not empty and the top character of the stack is greater than the current character:
    - Check if the top character will appear later (using the frequency count). If it will, pop it from the stack and remove it from the set.
  - Push the current character onto the stack and mark it as seen in the set.
  
- After processing all characters, the stack will contain the characters of the smallest subsequence in the correct order. Convert the stack to a string and return it.

### Data Structures:
- **Frequency Array**: To count occurrences of each character (size 26 for lowercase letters).
- **Stack**: To build the resultant subsequence.
- **Set**: To keep track of characters already included in the stack.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. Each character is processed a constant number of times.
- **Space Complexity**: O(1) for the frequency array (constant space) and O(n) for the stack in the worst case (if all characters are distinct).

This approach efficiently constructs the required subsequence while ensuring it is lexicographically smallest by leveraging the properties of stacks and greedy choices.
