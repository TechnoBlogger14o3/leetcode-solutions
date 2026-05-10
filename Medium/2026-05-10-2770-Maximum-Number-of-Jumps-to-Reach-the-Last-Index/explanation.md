# Maximum Number of Jumps to Reach the Last Index (Medium)

**Problem ID:** 2770  
**Date:** 2026-05-10  
**Link:** https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/

## Approach

To solve the problem of finding the maximum number of jumps to reach the last index in the given array, we can utilize a breadth-first search (BFS) approach combined with dynamic programming principles.

### Main Idea:
The goal is to explore all possible jumps from the current index while adhering to the jump constraints defined by the `target` value. We need to keep track of the maximum number of jumps taken to reach each index and ensure that we explore all valid indices that can be reached from the current position.

### Approach:
1. **Initialization**: Create an array `dp` where `dp[i]` represents the maximum number of jumps needed to reach index `i`. Initialize `dp[0]` to `0` (starting point) and all other indices to `-1` (indicating they are initially unreachable).

2. **BFS Exploration**: Use a queue to facilitate the BFS. Start by enqueueing the first index (0). For each index `i` dequeued:
   - Explore all subsequent indices `j` (where `i < j < n`) and check if the jump from `i` to `j` is valid based on the condition `-target <= nums[j] - nums[i] <= target`.
   - If the jump is valid and `dp[j]` is still `-1`, update `dp[j]` to `dp[i] + 1` (indicating one more jump) and enqueue `j`.

3. **Termination**: The BFS continues until all reachable indices are processed. Finally, check the value of `dp[n-1]`. If it remains `-1`, it indicates that the last index is unreachable. Otherwise, return `dp[n-1]` as the result.

### Data Structures:
- An array `dp` of size `n` to store the maximum jumps to each index.
- A queue to facilitate the BFS traversal of indices.

### Complexity:
- **Time Complexity**: O(n^2) in the worst case, as for each index, we may potentially check all subsequent indices.
- **Space Complexity**: O(n) for the `dp` array and the queue.

This approach effectively explores all valid jumping paths while keeping track of the maximum jumps, ensuring an optimal solution to the problem.
