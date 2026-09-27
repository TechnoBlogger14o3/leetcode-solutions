# Reverse Substrings Between Each Pair of Parentheses (Medium)

**Problem ID:** 1190  
**Date:** 2026-09-27  
**Link:** https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

## Approach

To solve the problem of reversing substrings between each pair of parentheses, we can utilize a stack data structure. The main idea is to process the string character by character, using the stack to manage the nested structure of parentheses.

### Approach:

1. **Initialization**: Create an empty stack to keep track of characters and substrings as we parse through the input string.

2. **Iterate through the string**: For each character in the string:
   - If the character is an opening parenthesis `'('`, push it onto the stack. This indicates the start of a new substring that needs to be reversed later.
   - If the character is a closing parenthesis `')'`, we need to reverse the substring that lies between the most recent matching pair of parentheses. To do this:
     - Pop characters from the stack until we encounter the opening parenthesis. This will give us the substring that needs to be reversed.
     - Reverse the collected substring and push it back onto the stack, effectively replacing the parentheses and the enclosed substring with the reversed version.
   - If the character is a lowercase letter, simply push it onto the stack.

3. **Final Assembly**: After processing all characters, the stack will contain all the characters in the correct order (with reversed substrings already handled). We can then concatenate the characters in the stack to form the final output string.

### Data Structures:
- **Stack**: Used to manage characters and substrings efficiently, allowing for easy access to the most recently added elements (LIFO behavior).

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input string. Each character is processed once.
- **Space Complexity**: O(n) in the worst case, where all characters are stored in the stack (e.g., a string with no parentheses).

This approach efficiently handles the nested structure of parentheses and ensures that all reversals are performed correctly, yielding the desired output without any brackets.
