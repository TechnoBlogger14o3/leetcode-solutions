# Find the Minimum Amount of Time to Brew Potions (Medium)

**Problem ID:** 3494  
**Date:** 2025-10-09  
**Link:** https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/

## Approach

To solve the problem of finding the minimum amount of time required for wizards to brew potions, we can adopt a systematic approach based on dynamic programming.

### Main Idea:
The brewing process is sequential, where each wizard must complete their work on a potion before passing it to the next. The time taken by each wizard to brew a potion is determined by their skill level and the mana required for that potion. The challenge is to synchronize the start times of each wizard for each potion to minimize the total brewing time.

### Approach:
1. **Dynamic Programming Table**: We will maintain a 2D DP table `dp[i][j]` where `dp[i][j]` represents the time at which the `i-th` wizard finishes brewing the `j-th` potion.

2. **Initialization**: 
   - For the first potion (j = 0), the time for each wizard can be computed directly as `dp[i][0] = skill[i] * mana[0]` for all wizards `i`.

3. **Filling the DP Table**:
   - For each subsequent potion (j > 0), we need to consider two factors:
     - The time when the previous wizard finishes the current potion.
     - The time when the current wizard finishes the previous potion.
   - The formula to compute the finish time for each wizard on the current potion is:
     ```
     dp[i][j] = max(dp[i][j-1], dp[i-1][j]) + skill[i] * mana[j]
     ```
   Here, `dp[i][j-1]` represents the time the current wizard finishes the previous potion, and `dp[i-1][j]` represents the time the previous wizard finishes the current potion.

4. **Final Result**: The answer will be the time at which the last wizard finishes the last potion, which can be found at `dp[n-1][m-1]`.

### Data Structures:
- A 2D array (or list) `dp` of size `n x m` will be used to store the finish times for each wizard and potion combination.

### Complexity:
- **Time Complexity**: O(n * m), where `n` is the number of wizards and `m` is the number of potions. This is because we fill an n x m table, with each entry computed in constant time.
- **Space Complexity**: O(n * m) for the DP table. However, since we only need the current and previous potion's results, we can optimize the space to O(n) by using two 1D arrays.

This approach efficiently computes the minimum time required to brew all potions while respecting the sequential processing constraints of the wizards.
