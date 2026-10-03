# Longest Valid Parentheses (Hard)

**Problem ID:** 32  
**Date:** 2026-10-03  
**Link:** https://leetcode.com/problems/longest-valid-parentheses/

## Approach

To solve the "Longest Valid Parentheses" problem, we can use a stack-based approach or a dynamic programming approach. Here’s a concise explanation of both methods:

### Main Idea:
The goal is to find the length of the longest substring of valid parentheses. A valid substring is one where every opening parenthesis '(' has a corresponding closing parenthesis ')', and they are properly nested.

### Approach 1: Stack
1. **Data Structures**: Use a stack to keep track of indices of the characters in the string. Initialize the stack with a base value of `-1` to handle edge cases.
2. **Iterate through the string**: For each character:
   - If it’s an '(', push its index onto the stack.
   - If it’s a ')':
     - Pop the top of the stack. If the stack is not empty after popping, calculate the length of the valid substring by subtracting the current index from the index at the new top of the stack. Update the maximum length if this length is greater.
     - If the stack is empty after popping, push the current index onto the stack as a new base for future valid substrings.
3. **Complexity**: The time complexity is O(n), where n is the length of the string, as each character is processed once. The space complexity is O(n) in the worst case due to the stack.

### Approach 2: Dynamic Programming
1. **Data Structures**: Use a DP array where `dp[i]` represents the length of the longest valid parentheses substring ending at index `i`.
2. **Iterate through the string**: For each character starting from index 1:
   - If it’s a ')':
     - Check if the previous character is '('. If so, set `dp[i] = dp[i-2] + 2`.
     - If the previous character is ')', check if the character before the valid substring (i.e., `i - dp[i-1] - 1`) is '('. If it is, then set `dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2`.
3. **Calculate the maximum length**: Keep track of the maximum value in the DP array.
4. **Complexity**: The time complexity is O(n), and the space complexity is O(n) due to the DP array.

### Summary:
Both approaches effectively identify valid parentheses substrings, with the stack method being more space-efficient in practice due to its lower constant factors. The choice between them may depend on personal preference or specific constraints of the problem context.
