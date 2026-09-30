# Maximum Nesting Depth of Two Valid Parentheses Strings (Medium)

**Problem ID:** 1111  
**Date:** 2026-09-30  
**Link:** https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/

## Approach

To solve the problem of splitting a valid parentheses string (VPS) into two disjoint subsequences A and B while minimizing the maximum nesting depth of both subsequences, we can adopt the following approach:

### Main Idea:
The key insight is to alternate the assignment of parentheses to subsequences A and B based on their nesting levels. By doing so, we can ensure that both subsequences maintain valid structures while balancing their depths.

### Approach:
1. **Initialization**: Start with an empty result array of the same length as the input string `seq`. This array will hold the values 0 or 1, indicating whether each character belongs to subsequence A or B.

2. **Depth Tracking**: Use a variable to keep track of the current depth of nesting as you iterate through the string. Each time you encounter an opening parenthesis '(', increment the depth; for a closing parenthesis ')', decrement the depth.

3. **Assignment Logic**:
   - When you encounter an opening parenthesis '(', check the current depth:
     - If the depth is even, assign it to A (set the corresponding index in the result to 0).
     - If the depth is odd, assign it to B (set the corresponding index in the result to 1).
   - For a closing parenthesis ')', perform the same check based on the depth before decrementing it.

4. **Final Output**: Once you have processed all characters in `seq`, the result array will represent a valid split of the VPS into subsequences A and B, with minimized maximum nesting depth.

### Data Structures:
- An array to store the result, initialized to the same length as the input string.
- A single integer variable to track the current depth of nesting.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input string `seq`, as we perform a single pass through the string.
- **Space Complexity**: O(n) for the result array, which is required to store the output.

This approach effectively balances the nesting depth of the two subsequences by leveraging the properties of even and odd depths in the structure of valid parentheses, ensuring both subsequences remain valid while minimizing the maximum depth.
