# Stone Game VIII (Hard)

**Problem ID:** 1872  
**Date:** 2026-08-24  
**Link:** https://leetcode.com/problems/stone-game-viii/

## Approach

To solve the "Stone Game VIII" problem, we need to determine the optimal score difference between Alice and Bob when both play optimally. The game mechanics allow players to remove a number of stones from the left and add their sum as a new stone on the left, which affects future moves.

### Problem Breakdown:
1. **Game Dynamics**: Alice and Bob take turns removing stones, and each player aims to maximize their score difference. The game continues until only one stone remains.
2. **Optimal Moves**: Each player will always make the move that maximizes their advantage or minimizes their disadvantage based on the current state of the game.

### Approach:
1. **Prefix Sum Calculation**: 
   - First, compute the prefix sums of the stones array. This helps in quickly calculating the sum of the first `x` stones for any valid `x`.
   - The prefix sum for the stones array can be defined as `prefix[i] = stones[0] + stones[1] + ... + stones[i]`.

2. **Iterate from the End**: 
   - Start from the last stone and move towards the first stone, maintaining a running total of the sum of the stones that have been removed.
   - For each position, calculate the potential score difference if Alice removes the first `x` stones.

3. **Score Difference Calculation**:
   - Maintain a variable to track the maximum score difference. For each stone position, update this variable based on the current prefix sum and the previously calculated maximum difference.
   - The formula for the score difference can be expressed as:
     \[
     \text{score\_difference} = \text{max\_difference} = \max(\text{max\_difference}, \text{current\_sum} - \text{previous\_max})
     \]
   - Here, `current_sum` is the sum of stones removed, and `previous_max` is the maximum score difference calculated so far.

### Data Structures:
- An array to store the prefix sums.
- Simple variables to keep track of the current sum and maximum score difference.

### Complexity:
- **Time Complexity**: O(n), where n is the number of stones. We make a single pass through the stones to compute prefix sums and another pass to compute the score difference.
- **Space Complexity**: O(1) for the extra variables used (excluding the input array), as we only need a few variables to track sums and differences.

### Conclusion:
By leveraging prefix sums and iterating through the stones from the end to the beginning, we can efficiently calculate the optimal score difference between Alice and Bob. This approach ensures that both players' optimal strategies are accounted for while maintaining linear time complexity.
