# Stone Game V (Hard)

**Problem ID:** 1563  
**Date:** 2026-08-17  
**Link:** https://leetcode.com/problems/stone-game-v/

## Approach

To solve the "Stone Game V" problem, we can employ a dynamic programming approach that efficiently computes the maximum score Alice can achieve by strategically dividing the stones into two non-empty rows.

### Main Idea:
The core idea is to use a dynamic programming (DP) table where `dp[i][j]` represents the maximum score Alice can obtain from the subarray `stoneValue[i]` to `stoneValue[j]`. The goal is to fill this DP table by considering all possible divisions of the stones and calculating the resulting scores based on Bob's decision-making.

### Steps:
1. **Prefix Sum Calculation**: First, compute a prefix sum array that allows for quick calculation of the sum of any subarray. This helps in determining the values of the left and right rows quickly.

2. **Dynamic Programming Table Initialization**: Initialize a DP table where `dp[i][j]` is set to 0 for all `i` and `j` where `i == j`, since if there’s only one stone, Alice cannot score anything.

3. **Iterate Over Subarrays**: For each possible subarray length from 2 to the length of `stoneValue`, and for each starting index `i`, calculate the ending index `j`. For each pair `(i, j)`, consider all possible split points `k` between `i` and `j`.

4. **Score Calculation**: For each split point `k`, calculate the sums of the left and right rows:
   - Left sum: `sum(i, k)`
   - Right sum: `sum(k+1, j)`
   Based on these sums, determine which row Bob would discard and update Alice's score accordingly. The score Alice can achieve from this split is the sum of the remaining row plus the best score from the subproblems defined by the new ranges.

5. **Maximize the Score**: Update `dp[i][j]` with the maximum score obtainable from all possible splits.

6. **Final Result**: The value in `dp[0][n-1]` (where `n` is the length of `stoneValue`) will give the maximum score Alice can achieve for the entire array.

### Data Structures:
- A 2D list (or array) for the DP table `dp` to store the maximum scores for subarrays.
- A 1D list for the prefix sum to efficiently calculate the sums of any subarray.

### Complexity:
- **Time Complexity**: O(n^3), where `n` is the length of the `stoneValue` array. This arises from the nested loops for subarray lengths, starting indices, and split points.
- **Space Complexity**: O(n^2) for the DP table.

By following this structured approach, we can efficiently compute the maximum score for Alice in the Stone Game V problem.
