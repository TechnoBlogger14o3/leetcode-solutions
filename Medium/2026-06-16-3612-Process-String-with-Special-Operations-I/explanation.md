# Process String with Special Operations I (Medium)

**Problem ID:** 3612  
**Date:** 2026-06-16  
**Link:** https://leetcode.com/problems/process-string-with-special-operations-i/

## Approach

To solve the problem of processing a string with special operations, we can adopt a straightforward approach using a list to build the resultant string. The main idea is to iterate through each character of the input string and apply the specified operations based on the character encountered.

### Approach:

1. **Data Structure**: Use a list to efficiently handle string modifications. Lists allow for O(1) time complexity for appending and removing elements, which is beneficial given the operations we need to perform.

2. **Iteration**: Traverse the string character by character:
   - If the character is a lowercase letter (a-z), append it to the list.
   - If the character is `*`, check if the list is non-empty and remove the last character (if it exists).
   - If the character is `#`, duplicate the current list by extending it with a copy of itself.
   - If the character is `%`, reverse the current list.

3. **Final Output**: After processing all characters, convert the list back to a string using the `join` method.

### Complexity:
- **Time Complexity**: O(n) where n is the length of the input string. Each operation (append, remove, duplicate, reverse) is handled in constant time, and the overall traversal of the string is linear.
- **Space Complexity**: O(n) in the worst case, as we may need to store up to twice the length of the input string due to the duplication operation.

This approach efficiently handles the operations while maintaining clarity and simplicity in implementation.
