# Maximum Nesting Depth of the Parentheses (Easy)

**Problem ID:** 1614  
**Date:** 2026-09-28  
**Link:** https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

## Approach

To solve the problem of finding the maximum nesting depth of parentheses in a valid parentheses string, we can utilize a simple iterative approach. The main idea is to traverse the string character by character while maintaining a counter to track the current depth of nested parentheses.

### Approach:

1. **Initialization**: Start with two variables: 
   - `max_depth` to keep track of the maximum depth encountered during the traversal, initialized to 0.
   - `current_depth` to track the current depth of nested parentheses, also initialized to 0.

2. **Traversal**: Iterate through each character in the string:
   - When encountering an opening parenthesis `(`, increment the `current_depth` by 1. After incrementing, check if `current_depth` exceeds `max_depth`. If it does, update `max_depth`.
   - When encountering a closing parenthesis `)`, decrement the `current_depth` by 1.

3. **Return Result**: After processing all characters, `max_depth` will contain the maximum nesting depth of the parentheses.

### Data Structures:
- We only use integer variables (`max_depth` and `current_depth`), so no additional data structures like stacks or arrays are required.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. We make a single pass through the string.
- **Space Complexity**: O(1), as we are using a constant amount of space regardless of the input size.

This approach efficiently calculates the maximum nesting depth in a straightforward manner, leveraging the properties of valid parentheses strings.
