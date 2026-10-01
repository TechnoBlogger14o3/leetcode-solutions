# Valid Parentheses (Easy)

**Problem ID:** 20  
**Date:** 2026-10-01  
**Link:** https://leetcode.com/problems/valid-parentheses/

## Approach

To solve the "Valid Parentheses" problem, we can use a stack data structure to efficiently track the opening brackets as we iterate through the string. The main idea is to ensure that every closing bracket encountered corresponds to the most recent unmatched opening bracket.

### Approach:

1. **Initialize a Stack**: Create an empty stack to hold opening brackets as we encounter them in the string.

2. **Mapping of Brackets**: Use a dictionary to map each closing bracket to its corresponding opening bracket. This helps in quickly checking if a closing bracket matches the expected opening bracket.

3. **Iterate Through the String**: Loop through each character in the input string:
   - If the character is an opening bracket (`'('`, `'{'`, `'['`), push it onto the stack.
   - If it is a closing bracket (`')'`, `'}'`, `']'`):
     - Check if the stack is empty. If it is, this means there is no corresponding opening bracket, and we can return `false`.
     - Otherwise, pop the top element from the stack and check if it matches the expected opening bracket using the mapping. If it does not match, return `false`.

4. **Final Check**: After processing all characters, if the stack is empty, it indicates that all opening brackets had matching closing brackets in the correct order, so return `true`. If there are still unmatched opening brackets in the stack, return `false`.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. Each character is processed once.
- **Space Complexity**: O(n) in the worst case, where all characters are opening brackets, and they are stored in the stack.

This approach effectively ensures that the input string has valid parentheses by leveraging the stack to enforce the correct order and matching of brackets.
