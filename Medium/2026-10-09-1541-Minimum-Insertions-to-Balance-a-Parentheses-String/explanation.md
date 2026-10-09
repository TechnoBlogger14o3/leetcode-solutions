# Minimum Insertions to Balance a Parentheses String (Medium)

**Problem ID:** 1541  
**Date:** 2026-10-09  
**Link:** https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/

## Approach

To solve the problem of finding the minimum insertions needed to balance a parentheses string where each '(' must correspond to two consecutive ')' (i.e., '))'), we can use a straightforward approach that involves a single pass through the string while maintaining counters for unmatched opening and closing parentheses.

### Approach:

1. **Initialization**: Start with two counters:
   - `open_needed`: This keeps track of how many opening parentheses '(' are needed.
   - `close_needed`: This counts how many closing parentheses '))' are needed for the unmatched '('.

2. **Iterate through the string**: Loop through each character in the string:
   - If the character is '(': Increment `close_needed` by 2 because each '(' needs two ')' to be balanced.
   - If the character is ')':
     - If `close_needed` is greater than 0, it means there are unmatched '(' that can be matched with this ')'. Thus, decrement `close_needed` by 1.
     - If `close_needed` is 0, it means this ')' does not have a matching '(' and should be accounted for. In this case, increment `open_needed` by 1 to signify that we need an additional '(' to balance this unmatched ')'.

3. **Final Calculation**: After processing the entire string, the total number of insertions required to balance the string will be the sum of `open_needed` (for unmatched ')') and `close_needed` (for unmatched '(').

### Data Structures:
- Two integer variables (`open_needed` and `close_needed`) are sufficient for this approach, so no additional complex data structures are needed.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. We make a single pass through the string.
- **Space Complexity**: O(1), as we only use a constant amount of space for the counters.

This efficient approach ensures that we can handle the maximum constraints of the problem seamlessly while accurately determining the minimum insertions required to balance the parentheses string.
