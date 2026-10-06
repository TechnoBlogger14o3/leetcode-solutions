# Minimum Add to Make Parentheses Valid (Medium)

**Problem ID:** 921  
**Date:** 2026-10-06  
**Link:** https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

## Approach

To solve the problem of finding the minimum number of parentheses that need to be added to make a given string valid, we can employ a simple counting approach using two counters.

### Problem-Solving Approach:

1. **Understanding Valid Parentheses**: A valid parentheses string must have matching opening and closing parentheses. For every opening parenthesis '(', there should be a corresponding closing parenthesis ')'.

2. **Counters**: We will use two counters:
   - `open_needed`: This counts the number of unmatched opening parentheses that we need to balance.
   - `close_needed`: This counts the number of unmatched closing parentheses that we need to balance.

3. **Iterate Through the String**: We will traverse each character in the string:
   - If we encounter an opening parenthesis '(', we increment the `open_needed` counter.
   - If we encounter a closing parenthesis ')':
     - If there are unmatched opening parentheses (i.e., `open_needed > 0`), we decrement `open_needed` because this closing parenthesis can match with one of the unmatched openings.
     - If there are no unmatched openings (`open_needed == 0`), we increment the `close_needed` counter because this closing parenthesis needs an opening to match with.

4. **Calculate the Result**: After processing the entire string, the total number of parentheses that need to be added to make the string valid will be the sum of `open_needed` and `close_needed`. This is because:
   - `open_needed` represents how many opening parentheses we need to add to balance the unmatched closing parentheses.
   - `close_needed` represents how many closing parentheses we need to add to balance the unmatched opening parentheses.

### Complexity Analysis:
- **Time Complexity**: O(n), where n is the length of the string. We make a single pass through the string.
- **Space Complexity**: O(1), as we only use a fixed amount of extra space for the counters.

This approach effectively counts the necessary additions in a single traversal, ensuring an efficient solution to the problem.
