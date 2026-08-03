# Stone Game III (Hard)

**Problem ID:** 1406  
**Date:** 2026-08-03  
**Link:** https://leetcode.com/problems/stone-game-iii/

## Approach

To solve the "Stone Game III" problem, we can utilize a dynamic programming approach. The main idea is to compute the maximum score difference Alice can achieve over Bob when starting from any given position in the `stoneValue` array, assuming both players play optimally.

### Approach:

1. **Dynamic Programming Array**: We define a DP array `dp` where `dp[i]` represents the maximum score difference (Alice's score - Bob's score) that Alice can achieve starting from the `i-th` stone to the end of the array. A positive value indicates Alice is winning, a negative value indicates Bob is winning, and zero indicates a tie.

2. **Base Case**: Initialize the DP array:
   - For the last stone, `dp[n-1] = stoneValue[n-1]` (only one stone left).
   - For the second last stone, `dp[n-2] = stoneValue[n-2] + stoneValue[n-1]` (two stones left).
   - For the third last stone, `dp[n-3] = stoneValue[n-3] + stoneValue[n-2] + stoneValue[n-1]` (three stones left).

3. **Recurrence Relation**: For each position `i` from `n-4` down to `0`, calculate `dp[i]` based on the possible moves (taking 1, 2, or 3 stones):
   - If Alice takes 1 stone: `score = stoneValue[i] - dp[i+1]`
   - If Alice takes 2 stones: `score = stoneValue[i] + stoneValue[i+1] - dp[i+2]`
   - If Alice takes 3 stones: `score = stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - dp[i+3]`
   - The value of `dp[i]` will be the maximum of these three scores.

4. **Final Decision**: After filling the `dp` array, the value `dp[0]` will represent the score difference starting from the first stone. Depending on the value of `dp[0]`:
   - If `dp[0] > 0`, Alice wins.
   - If `dp[0] < 0`, Bob wins.
   - If `dp[0] == 0`, it’s a tie.

### Data Structures:
- An array `dp` of size `n` (where `n` is the length of `stoneValue`) to store the maximum score differences.

### Complexity:
- **Time Complexity**: O(n), where `n` is the length of the `stoneValue` array, as we iterate through the array once to fill the DP table.
- **Space Complexity**: O(n) for the DP array. We can optimize this to O(1) by only storing the last three computed values since each state only depends on the next three states.

This approach efficiently determines the outcome of the game by leveraging dynamic programming to evaluate optimal plays at each stage.
