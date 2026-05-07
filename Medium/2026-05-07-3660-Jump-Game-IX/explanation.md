# Jump Game IX (Medium)

**Problem ID:** 3660  
**Date:** 2026-05-07  
**Link:** https://leetcode.com/problems/jump-game-ix/

## Approach

To solve the "Jump Game IX" problem, we can utilize a combination of depth-first search (DFS) and memoization to efficiently explore the possible jumps from each index in the `nums` array. The main idea is to determine the maximum reachable value for each index by recursively exploring valid jumps while storing previously computed results to avoid redundant calculations.

### Approach:

1. **Understanding Valid Jumps**:
   - From an index `i`, we can jump to a higher index `j` only if `nums[j] < nums[i]`.
   - We can jump to a lower index `j` only if `nums[j] > nums[i]`.

2. **DFS with Memoization**:
   - We define a recursive function that takes an index `i` and returns the maximum value reachable from that index.
   - If we have already computed the maximum value for index `i`, we return that value (this is where memoization helps).
   - For each index `i`, we explore all possible jumps:
     - For forward jumps (to indices greater than `i`), we check if `nums[j] < nums[i]` and recursively call our function for `j`.
     - For backward jumps (to indices less than `i`), we check if `nums[j] > nums[i]` and recursively call our function for `j`.
   - Throughout this exploration, we keep track of the maximum value found.

3. **Iterating Over All Indices**:
   - We initialize an array `ans` of the same length as `nums` to store the maximum reachable values for each index.
   - We iterate through each index `i` in `nums`, invoking our DFS function to fill `ans[i]`.

### Data Structures:
- An array `ans` to store the results.
- A memoization dictionary or array to cache results of previously computed indices to speed up the process.

### Complexity:
- **Time Complexity**: O(n^2) in the worst case, where `n` is the length of `nums`, due to potentially exploring all pairs of indices. However, with memoization, the average case can be significantly improved.
- **Space Complexity**: O(n) for the memoization storage and the `ans` array.

By employing this approach, we ensure that we efficiently compute the maximum reachable values for all indices while adhering to the jump rules specified in the problem statement.
