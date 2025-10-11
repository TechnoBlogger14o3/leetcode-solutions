# Maximum Total Damage With Spell Casting (Medium)

**Problem ID:** 3186  
**Date:** 2025-10-11  
**Link:** https://leetcode.com/problems/maximum-total-damage-with-spell-casting/

## Approach

To solve the problem of maximizing the total damage from spell casting, we can utilize a dynamic programming approach combined with frequency counting. The main idea is to avoid casting spells that are too close in damage value due to the given constraints.

### Approach:

1. **Frequency Count**: First, we create a frequency array to count how many spells have each unique damage value. This allows us to efficiently determine the total damage possible for each damage value.

2. **Dynamic Programming Array**: We define a dynamic programming array `dp` where `dp[i]` represents the maximum total damage that can be achieved using spells with damage values up to `i`.

3. **Transition Formula**: The transition between states in the `dp` array is based on whether we choose to cast the spell with damage `i` or not. The formula can be defined as:
   - If we cast the spell with damage `i`, we add the total damage from spells of this value (i.e., `i * frequency[i]`) to the maximum damage achievable from spells up to `i - 3` (to avoid the conflict with adjacent damage values).
   - If we do not cast the spell with damage `i`, we simply take the maximum damage achievable up to `i - 1`.

   Thus, the relation can be expressed as:
   \[
   dp[i] = \max(dp[i-1], dp[i-3] + i \times \text{frequency}[i])
   \]

4. **Initialization**: We initialize the `dp` array with base cases to handle the smallest indices, ensuring that we account for scenarios where no spells can be cast.

5. **Final Result**: The maximum total damage will be found in `dp[max_damage]`, where `max_damage` is the maximum damage value present in the input array.

### Data Structures:
- **Frequency Array**: To store the count of spells for each damage value.
- **Dynamic Programming Array**: To store the maximum damage achievable for each unique damage value.

### Complexity:
- **Time Complexity**: O(n + m), where n is the number of spells and m is the range of unique damage values (which can be up to 10^9 but is limited by the actual values present in the input).
- **Space Complexity**: O(m) for the frequency array and O(m) for the dp array, where m is the number of unique damage values.

This approach efficiently computes the maximum total damage while adhering to the constraints of spell casting, ensuring optimal performance even for larger input sizes.
