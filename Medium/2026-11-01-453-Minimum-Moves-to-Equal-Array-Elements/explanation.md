# Minimum Moves to Equal Array Elements (Medium)

**Problem ID:** 453  
**Date:** 2026-11-01  
**Link:** https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

## Approach

To solve the problem of finding the minimum moves required to make all elements of the array equal, we can leverage a strategic observation about the nature of the operations allowed.

### Main Idea:
The key insight is that instead of thinking about incrementing `n - 1` elements, we can reframe the problem to focus on the number of moves needed to bring all elements up to the level of the maximum element in the array. This is because incrementing `n - 1` elements is equivalent to decrementing one element (the one not incremented) in terms of achieving equality.

### Steps to Solve:
1. **Identify the Minimum Value**: Determine the minimum value in the array, `min_val`.
2. **Calculate Moves**: The total number of moves required to make all elements equal to this minimum value can be calculated as the sum of the differences between each element and `min_val`. Specifically, for each element `num` in the array, compute `num - min_val` and sum these values.
3. **Result**: The result will be the total sum calculated in the previous step, which represents the number of moves needed.

### Data Structures:
- A simple integer array to hold the input values.
- Variables to store the minimum value and the cumulative sum of differences.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array. We need to iterate through the array to find the minimum value and then again to compute the total moves.
- **Space Complexity**: O(1), as we are using a constant amount of extra space regardless of the input size.

This approach is efficient and straightforward, providing a clear path to the solution while minimizing computational overhead.
