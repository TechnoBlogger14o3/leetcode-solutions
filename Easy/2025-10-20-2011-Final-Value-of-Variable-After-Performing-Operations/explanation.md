# Final Value of Variable After Performing Operations (Easy)

**Problem ID:** 2011  
**Date:** 2025-10-20  
**Link:** https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

## Approach

To solve the problem of determining the final value of the variable \( X \) after executing a series of operations, we can adopt a straightforward approach that involves iterating through the list of operations and updating \( X \) based on the type of operation encountered.

### Main Idea:
1. **Initialization**: Start with \( X \) initialized to 0.
2. **Iterate through Operations**: For each operation in the input list:
   - If the operation is either "++X" or "X++", increment \( X \) by 1.
   - If the operation is either "--X" or "X--", decrement \( X \) by 1.
3. **Return the Result**: After processing all operations, the final value of \( X \) is returned.

### Data Structures:
- We only need a single integer variable \( X \) to keep track of the current value. The operations are stored in an array of strings, which we will iterate over.

### Complexity:
- **Time Complexity**: \( O(n) \), where \( n \) is the number of operations. We perform a constant-time operation (increment or decrement) for each operation in the list.
- **Space Complexity**: \( O(1) \), as we are using a fixed amount of space regardless of the input size (only one integer variable).

This approach is efficient given the constraints, and the logic is simple enough to ensure correctness while maintaining clarity. The operations are well-defined, and since we only have four possible strings to check, the solution is both optimal and easy to implement.
