# Trionic Array I (Easy)

**Problem ID:** 3637  
**Date:** 2026-02-03  
**Link:** https://leetcode.com/problems/trionic-array-i/

## Approach

To solve the "Trionic Array I" problem, we need to determine if there exist indices \( p \) and \( q \) such that the array can be divided into three segments: a strictly increasing segment from the start to \( p \), a strictly decreasing segment from \( p \) to \( q \), and another strictly increasing segment from \( q \) to the end.

### Approach:

1. **Iterate through possible indices for \( p \)**:
   - Start with \( p = 1 \) and iterate up to \( n - 2 \) (since \( p \) must be less than \( q \) and both must be within bounds).

2. **Check for strictly increasing segment**:
   - For each \( p \), check if the segment \( nums[0...p] \) is strictly increasing. This can be done by comparing each element with the next one in the segment.

3. **Iterate through possible indices for \( q \)**:
   - After confirming a valid \( p \), set \( q \) to \( p + 1 \) and iterate up to \( n - 1 \) (since \( q \) must be less than \( n \)).
   
4. **Check for strictly decreasing segment**:
   - For each \( q \), check if the segment \( nums[p...q] \) is strictly decreasing.

5. **Check for strictly increasing segment**:
   - Finally, if both previous segments are valid, check if the segment \( nums[q...n-1] \) is strictly increasing.

6. **Return result**:
   - If any combination of \( p \) and \( q \) satisfies the conditions, return true. If no such combination is found after all iterations, return false.

### Data Structures:
- The solution primarily uses simple integer variables for indices and a few boolean checks, so no complex data structures are necessary.

### Complexity:
- The time complexity is \( O(n^2) \) in the worst case, as we potentially check all pairs of \( p \) and \( q \) in a nested loop. The space complexity is \( O(1) \) since we only use a fixed amount of additional space regardless of the input size.

This approach is efficient given the constraints (with \( n \) up to 100) and allows us to systematically check the conditions for a trionic array.
