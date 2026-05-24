# Jump Game V (Hard)

**Problem ID:** 1340  
**Date:** 2026-05-24  
**Link:** https://leetcode.com/problems/jump-game-v/

## Approach

To solve the "Jump Game V" problem, we can utilize a dynamic programming approach combined with a breadth-first search (BFS) or depth-first search (DFS) strategy. The main idea is to explore all possible jumps from each index while adhering to the constraints of the problem.

### Approach:

1. **Dynamic Programming Array**: 
   - Create an array `dp` where `dp[i]` represents the maximum number of indices that can be visited starting from index `i`.
   - Initialize `dp[i]` to 1 for all indices, since each index can at least visit itself.

2. **Iterate Over Indices**:
   - For each index `i` in the array, you will check possible jumps to the left and right within the bounds defined by `d`.
   - For jumps to the right, check indices from `i + 1` to `min(i + d, n - 1)`.
   - For jumps to the left, check indices from `max(i - d, 0)` to `i - 1`.

3. **Jump Validity Check**:
   - For each potential jump to index `j`, ensure that `arr[i] > arr[j]` and that all elements between `i` and `j` (exclusive) are less than `arr[i]`. This can be efficiently checked by maintaining a running minimum of the elements between the two indices.

4. **Update DP Values**:
   - If a valid jump is found, update `dp[j]` to be the maximum of its current value and `dp[i] + 1`. This signifies that starting from `i`, you can reach `j` and visit one more index.

5. **Result Calculation**:
   - The final result will be the maximum value in the `dp` array, which indicates the maximum number of indices that can be visited starting from any index.

### Data Structures:
- An array `dp` of size `n` (length of `arr`) to store the maximum indices visited from each starting point.
- Simple variables to track indices during the checking process.

### Complexity:
- **Time Complexity**: O(n * d) in the worst case, where `n` is the length of the array and `d` is the maximum jump distance. This is due to iterating over each index and checking up to `d` possible jumps.
- **Space Complexity**: O(n) for the `dp` array.

This approach efficiently explores the jumping possibilities while ensuring that all constraints are respected, leading to the correct maximum reachable indices from any starting point in the array.
