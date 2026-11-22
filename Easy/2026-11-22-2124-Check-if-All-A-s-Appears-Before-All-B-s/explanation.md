# Check if All A's Appears Before All B's (Easy)

**Problem ID:** 2124  
**Date:** 2026-11-22  
**Link:** https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/

## Approach

To solve the problem of checking if all 'a's appear before all 'b's in a given string, we can adopt a straightforward linear scan approach. The main idea is to traverse the string from left to right and ensure that we never encounter a 'b' after having seen an 'a'. 

### Approach:

1. **Initialization**: Start with a boolean flag (or a simple state variable) to indicate whether we have encountered a 'b' yet.

2. **Traversal**: Iterate through each character of the string:
   - If you encounter an 'a', check the state:
     - If we have previously encountered a 'b', it means that an 'a' has appeared after a 'b', which violates the condition. In this case, return `false`.
   - If you encounter a 'b', set the state to indicate that we have seen a 'b'.

3. **Completion**: If the loop completes without finding any violations, return `true`.

### Data Structures:
- We only need a few variables (e.g., a boolean for the state), so no complex data structures are required. The solution operates in constant space, O(1).

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. This is because we make a single pass through the string.
- **Space Complexity**: O(1), as we are using a fixed amount of extra space regardless of the input size.

This approach is efficient and straightforward, leveraging a single traversal to ensure the order of 'a's and 'b's meets the specified condition.
