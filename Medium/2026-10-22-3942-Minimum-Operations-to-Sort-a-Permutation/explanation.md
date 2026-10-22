# Minimum Operations to Sort a Permutation (Medium)

**Problem ID:** 3942  
**Date:** 2026-10-22  
**Link:** https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/

## Approach

To solve the problem of determining the minimum operations required to sort a permutation of integers using only the specified operations (reverse and rotate left), we can follow a systematic approach:

### Main Idea
The core idea is to analyze the structure of the permutation and identify how far it is from being sorted. The operations allowed (reverse and rotate left) can be used strategically to rearrange the elements into a sorted order. The key insight is to recognize that the permutation can be decomposed into cycles, which can help in understanding how to manipulate the elements effectively.

### Steps to Approach
1. **Identify Cycles**: Each element in the permutation can be thought of as part of a cycle. For example, if an element at index `i` should be at index `j`, we can trace this to form a cycle. The number of cycles in the permutation will influence the number of operations required.

2. **Count Cycles**: Iterate through the permutation and count the number of cycles. A cycle is formed when you start from an index and keep following the indices until you return to the starting index. Mark elements as visited to avoid recounting.

3. **Calculate Operations**:
   - If there are `k` cycles, the minimum operations required to sort the permutation can be derived from the following:
     - For each cycle, you can sort it using a combination of operations.
     - The total number of operations needed is `k + (length of the cycle - 1)` for each cycle.
   - However, the operations can be optimized based on the number of cycles. The overall minimum operations can generally be expressed as `n - k`, where `n` is the length of the permutation and `k` is the number of cycles.

4. **Check for Impossibility**: If any cycle contains elements that cannot be rearranged into a sorted position using the allowed operations, we should return -1. This typically happens when the permutation has certain structural properties that prevent it from being sorted.

### Data Structures
- An array or list to store the permutation.
- A boolean array to keep track of visited indices while identifying cycles.

### Complexity
- **Time Complexity**: O(n), where n is the length of the permutation. This is due to the single pass required to identify cycles.
- **Space Complexity**: O(n) in the worst case for the visited array.

By following this structured approach, we can efficiently determine the minimum number of operations needed to sort the permutation or conclude that sorting is impossible.
