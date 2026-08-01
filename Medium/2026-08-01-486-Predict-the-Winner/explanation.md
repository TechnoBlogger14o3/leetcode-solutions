# Predict the Winner (Medium)

**Problem ID:** 486  
**Date:** 2026-08-01  
**Link:** https://leetcode.com/problems/predict-the-winner/

## Approach

To solve the "Predict the Winner" problem, we can employ a dynamic programming approach that leverages the concept of optimal play by both players. The main idea is to use a 2D array to keep track of the maximum score difference that player 1 can achieve over player 2 for any subarray of `nums`.

### Approach:

1. **Dynamic Programming Table**: 
   We define a 2D array `dp[i][j]` where `i` and `j` represent the indices of the subarray `nums[i...j]`. The value `dp[i][j]` will store the maximum score difference that the current player (player 1 if it's their turn) can achieve over the opponent when playing optimally from the subarray `nums[i...j]`.

2. **Base Case**: 
   If there is only one element in the subarray (i.e., when `i == j`), the current player will take that element, resulting in a score difference equal to that element itself:
   \[
   dp[i][i] = nums[i]
   \]

3. **Recurrence Relation**: 
   For larger subarrays, the current player has two choices: either take the leftmost element `nums[i]` or the rightmost element `nums[j]`. The score difference can be computed as follows:
   - If the current player takes `nums[i]`, the opponent will then play optimally on the subarray `nums[i+1...j]`. The score difference is then:
     \[
     dp[i][j] = nums[i] - dp[i+1][j]
     \]
   - If the current player takes `nums[j]`, the opponent will play optimally on the subarray `nums[i...j-1]`. The score difference is then:
     \[
     dp[i][j] = nums[j] - dp[i][j-1]
     \]
   Therefore, the formula for `dp[i][j]` becomes:
   \[
   dp[i][j] = \max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])
   \]

4. **Filling the DP Table**: 
   We fill the `dp` table in a bottom-up manner, starting from smaller subarrays and building up to the full array. This requires iterating over all possible lengths of subarrays and their starting indices.

5. **Final Decision**: 
   After populating the DP table, the result can be determined by checking the value of `dp[0][n-1]`, where `n` is the length of `nums`. If `dp[0][n-1]` is greater than or equal to 0, it means player 1 can either win or tie, hence we return `true`. Otherwise, we return `false`.

### Data Structures:
- A 2D array `dp` of size `n x n` to store the score differences.

### Complexity:
- **Time Complexity**: O(n^2), where n is the length of the `nums` array, due to the nested loops for filling the DP table.
- **Space Complexity**: O(n^2) for the DP table.

This approach efficiently determines whether player 1 can guarantee a win against player 2 by considering all possible game scenarios and leveraging optimal strategies for both players.
