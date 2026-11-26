# Stone Removal Game (Easy)

**Problem ID:** 3360  
**Date:** 2026-11-26  
**Link:** https://leetcode.com/problems/stone-removal-game/

## Approach

To solve the "Stone Removal Game" problem, we need to analyze the game mechanics and determine the winning conditions for Alice based on the initial number of stones, `n`.

### Problem Breakdown:
1. **Game Rules**: 
   - Alice always starts by removing exactly 10 stones.
   - After Alice's turn, Bob will remove 1 stone fewer than Alice did in her previous turn.
   - This pattern continues until a player cannot make a valid move (i.e., they cannot remove the required number of stones).

2. **Winning Condition**:
   - Alice wins if Bob cannot make a valid move after her first turn.

### Key Observations:
- If `n < 10`, Alice cannot make her first move, and she loses immediately.
- If `n >= 10`, Alice removes 10 stones, leaving `n - 10` stones for Bob.
- Bob's turn will require him to remove 9 stones. If `n - 10 < 9`, Bob cannot make a valid move, and Alice wins.
- Thus, the critical condition for Alice to win is when `n - 10 < 9`, which simplifies to `n < 19`.

### Solution Approach:
1. **Direct Evaluation**:
   - Check the value of `n`:
     - If `n < 10`: Return `false` (Alice loses).
     - If `n >= 10` and `n < 19`: Return `true` (Alice wins).
     - If `n >= 19`: Bob can always respond with a valid move, leading to a situation where he can eventually win.

### Complexity:
- **Time Complexity**: O(1) since we are performing a constant number of comparisons.
- **Space Complexity**: O(1) as we are using a fixed amount of space for the variables.

In conclusion, the solution hinges on a simple comparison of `n` to determine the outcome of the game based on the rules provided. The winning strategy for Alice can be succinctly derived from the number of stones available after her first move.
