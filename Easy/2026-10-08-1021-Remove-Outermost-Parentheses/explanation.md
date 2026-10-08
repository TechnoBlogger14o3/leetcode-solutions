# Remove Outermost Parentheses (Easy)

**Problem ID:** 1021  
**Date:** 2026-10-08  
**Link:** https://leetcode.com/problems/remove-outermost-parentheses/

## Approach

To solve the problem of removing the outermost parentheses from a valid parentheses string, we can utilize a straightforward approach that involves iterating through the string while maintaining a counter to track the depth of nested parentheses.

### Approach:

1. **Initialization**: Start with an empty result string to store the final output and a counter initialized to zero to keep track of the depth of parentheses.

2. **Iterate through the String**: Loop through each character in the string:
   - If the character is an opening parenthesis `'('`, increment the depth counter.
   - If the character is a closing parenthesis `')'`, decrement the depth counter.

3. **Build the Result**:
   - For each character, check the depth:
     - If the depth is greater than 1 (meaning we are inside a primitive string), append the character to the result. This effectively skips the outermost parentheses.
     - If the depth is exactly 1, it indicates that the current character is part of the outermost parentheses, so we do not add it to the result.

4. **Return the Result**: After processing all characters, the result string will contain the modified parentheses string with the outermost parentheses removed.

### Data Structures:
- A simple string (or a list for efficient concatenation) is used to build the result.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input string. We traverse the string once, performing constant-time operations for each character.
- **Space Complexity**: O(n) in the worst case for the result string, although the space used for the counter is O(1).

This approach efficiently handles the problem by leveraging the properties of valid parentheses and ensures that we only keep the necessary characters in the output.
