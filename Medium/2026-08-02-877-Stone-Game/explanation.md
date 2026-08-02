# Stone Game (Medium)

**Problem ID:** 877  
**Date:** 2026-08-02  
**Link:** https://leetcode.com/problems/stone-game/

## Approach

To solve the "Stone Game" problem, we can utilize a dynamic programming approach that focuses on maximizing the score difference between Alice and Bob, given that both players play optimally.

### Problem Breakdown:
1. **Game Dynamics**: Alice and Bob alternately pick stones from either end of a row of piles. Alice aims to maximize her score, while Bob aims to minimize Alice's score (which indirectly maximizes his own score).

2. **Optimal Strategy**: Since both players play optimally, the decision made by one player affects the choices available to the other. Thus, we need to evaluate the outcomes based on the choices made at each turn.

### Dynamic Programming Approach:
1. **State Representation**: We define a 2D DP array `dp[i][j]` where `dp[i][j]` represents the maximum score difference Alice can achieve over Bob when considering the subarray of piles from index `i` to `j`.

2. **Base Case**: If there is only one pile (i.e., when `i == j`), then `dp[i][j] = piles[i]`, since Alice will take the only available pile.

3. **Transition**:
   - When Alice picks the left pile (`piles[i]`), the score difference becomes `piles[i] - dp[i+1][j]` (Bob will then play optimally on the remaining piles).
   - When Alice picks the right pile (`piles[j]`), the score difference becomes `piles[j] - dp[i][j-1]`.
   - Thus, we have:
     \[
     dp[i][j] = \max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])
     \]

4. **Final Decision**: After filling the DP table, `dp[0][n-1]` will give us the maximum score difference Alice can achieve over Bob when considering the entire array. If this value is greater than 0, Alice wins.

### Complexity:
- **Time Complexity**: O(n^2), where n is the number of piles. This is due to the nested loops needed to fill the DP table.
- **Space Complexity**: O(n^2) for the DP table, although this can be optimized to O(n) by only storing the last computed row and the current row.

### Summary:
By leveraging dynamic programming, we can efficiently determine whether Alice can secure a win against Bob by calculating the maximum score difference she can achieve, given both players play optimally. The approach ensures that we explore all possible outcomes while maintaining optimal substructure properties of the game.
