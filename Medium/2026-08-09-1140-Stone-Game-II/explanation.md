# Stone Game II (Medium)

**Problem ID:** 1140  
**Date:** 2026-08-09  
**Link:** https://leetcode.com/problems/stone-game-ii/

## Approach

To solve the "Stone Game II" problem, we can employ a dynamic programming approach. The main idea is to maximize the number of stones Alice can collect while considering that both players play optimally.

### Problem Breakdown:
1. **Game Dynamics**: Alice and Bob take turns picking stones. Alice starts first, and on her turn, she can take stones from the first `X` piles, where `1 <= X <= 2M`. After her turn, `M` is updated to the maximum of its current value and `X`. The goal is to determine how many stones Alice can collect by the end of the game.

2. **Dynamic Programming State**: We define a DP table `dp[i][m]`, where `i` is the index of the current pile Alice is considering, and `m` is the current value of `M`. The value `dp[i][m]` represents the maximum number of stones Alice can collect starting from pile `i` with the current `M` value.

3. **Transition**: For each state `dp[i][m]`, we simulate Alice's choices:
   - Alice can take `X` piles where `X` ranges from `1` to `min(2m, n - i)` (where `n` is the total number of piles). After taking `X` piles, we calculate the total stones Alice collects and then evaluate Bob's optimal response.
   - Bob will also play optimally, so we need to minimize Alice's future gains by considering the remaining piles after Alice's choice.

4. **Base Case**: If `i` exceeds the number of piles, Alice cannot collect any more stones, so `dp[i][m] = 0`.

5. **Memoization**: To avoid recalculating results for the same state, we can use memoization to store the results of `dp[i][m]`.

### Data Structures:
- A 2D array (or dictionary) to store the DP states.
- A prefix sum array to efficiently calculate the total stones in any range of piles.

### Complexity:
- **Time Complexity**: The approach runs in O(n^2) since for each pile `i`, we evaluate up to `2M` choices, leading to a nested loop structure. Given that `M` can be at most `n`, this results in O(n^2) overall.
- **Space Complexity**: O(n) for the DP table and O(n) for the prefix sum array, leading to a total space complexity of O(n).

### Conclusion:
By carefully structuring our dynamic programming solution, we can efficiently determine the maximum number of stones Alice can collect while accounting for optimal play from both players. The key is to use a DP table to explore all possible choices and outcomes, ensuring that we capture the best possible scenario for Alice.
