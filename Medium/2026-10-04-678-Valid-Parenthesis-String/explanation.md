# Valid Parenthesis String (Medium)

**Problem ID:** 678  
**Date:** 2026-10-04  
**Link:** https://leetcode.com/problems/valid-parenthesis-string/

## Approach

To solve the "Valid Parenthesis String" problem, we can utilize a greedy approach combined with a counting mechanism to track the balance of parentheses while considering the flexibility of the '*' character.

### Main Idea:
The main idea is to maintain two counters: one for the minimum possible balance of parentheses (`min_open`) and another for the maximum possible balance (`max_open`). The `min_open` counter represents the minimum number of unmatched '(' parentheses we can have at any point, while the `max_open` counter represents the maximum number of unmatched '(' parentheses we can have, assuming '*' can be treated as a '('.

### Approach:
1. **Initialization**: Start with both `min_open` and `max_open` set to 0.
  
2. **Iterate through the string**:
   - For each character in the string:
     - If the character is '(': Increment both `min_open` and `max_open` by 1.
     - If the character is ')': Decrement both `min_open` and `max_open` by 1.
     - If the character is '*': Decrement `min_open` (treating '*' as ')') and increment `max_open` (treating '*' as '('). This means `min_open` can potentially go down to zero if we treat '*' optimally.
  
3. **Adjust for Negative Values**: Ensure `min_open` does not go below zero, as this would imply an excess of ')' that cannot be matched. If `min_open` goes negative, reset it to zero.

4. **Final Check**: At the end of the iteration, if `max_open` is zero, it means all parentheses can be matched correctly, and we return true. If `max_open` is greater than zero, it indicates unmatched '(', and we return false.

### Data Structures:
- Two integer counters (`min_open` and `max_open`) are sufficient to keep track of the balance of parentheses.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. We traverse the string once.
- **Space Complexity**: O(1), as we are using a constant amount of space for the counters.

This approach efficiently determines whether the string can represent a valid sequence of parentheses, taking into account the flexible nature of the '*' character.
