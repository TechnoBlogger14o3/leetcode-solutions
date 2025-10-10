# Taking Maximum Energy From the Mystic Dungeon (Medium)

**Problem ID:** 3147  
**Date:** 2025-10-10  
**Link:** https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/

## Approach

To solve the problem of maximizing energy absorption from the magicians in the mystic dungeon, we can utilize a dynamic programming approach. Here's a concise explanation of the solution strategy:

### Main Idea
The key idea is to calculate the maximum energy that can be obtained starting from each magician, considering the teleportation effect after absorbing energy from a magician. We will keep track of the maximum energy obtainable from each starting position using a dynamic programming array.

### Approach
1. **Dynamic Programming Array**: Create an array `dp` where `dp[i]` represents the maximum energy that can be gained starting from magician `i`.

2. **Base Case**: Initialize the last `k` positions in the `dp` array, as they will have no further jumps possible beyond their index. For these positions, `dp[i] = energy[i]`.

3. **Backward Calculation**: Iterate from the second last magician towards the first:
   - For each magician `i`, calculate the energy gained by absorbing energy from magician `i` and then jumping to magician `i + k`. The formula will be:
     \[
     dp[i] = energy[i] + dp[i + k] \quad \text{if } i + k < n
     \]
   - If `i + k` exceeds the bounds of the array, simply set `dp[i] = energy[i]`.

4. **Result Extraction**: The final result will be the maximum value in the `dp` array, as it represents the maximum energy that can be gained starting from any magician.

### Data Structures
- **Array**: A single-dimensional array `dp` of size `n` to store the maximum energy obtainable from each magician.

### Complexity
- **Time Complexity**: O(n), where `n` is the length of the `energy` array, since we iterate through the array once.
- **Space Complexity**: O(n) for the `dp` array.

This approach efficiently calculates the maximum energy that can be absorbed by leveraging dynamic programming, ensuring that we consider all possible starting positions while adhering to the constraints of teleportation.
