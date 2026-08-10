# Stone Game IV (Hard)

**Problem ID:** 1510  
**Date:** 2026-08-10  
**Link:** https://leetcode.com/problems/stone-game-iv/

## Approach

To solve the "Stone Game IV" problem, we can use a dynamic programming approach. The main idea is to determine whether Alice can guarantee a win given `n` stones, assuming both players play optimally.

### Approach:

1. **Dynamic Programming Array**: 
   - We create a boolean array `dp` of size `n + 1`, where `dp[i]` indicates whether the player whose turn it is can win with `i` stones remaining.
   - Initialize `dp[0]` to `false` because if there are no stones left, the player loses.

2. **Iterate through Possible States**:
   - For each number of stones from `1` to `n`, check all possible square numbers that can be removed (i.e., `1, 4, 9, 16, ...` up to the largest square less than or equal to `i`).
   - For each square number `k^2` that can be removed, check if removing `k^2` stones leads to a state where the opponent loses (i.e., `dp[i - k^2]` is `false`). If such a move exists, set `dp[i]` to `true`.

3. **Winning Condition**:
   - After filling the `dp` array, the value of `dp[n]` will indicate whether Alice can win with `n` stones.

### Complexity:
- **Time Complexity**: The outer loop runs `O(n)` times, and for each `i`, we check up to `O(sqrt(n))` square numbers. Thus, the overall time complexity is `O(n * sqrt(n))`.
- **Space Complexity**: The space complexity is `O(n)` due to the `dp` array.

This approach effectively explores all possible game states and optimally determines the winning strategy for Alice based on the number of stones left.
