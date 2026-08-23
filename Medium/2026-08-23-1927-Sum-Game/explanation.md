# Sum Game (Medium)

**Problem ID:** 1927  
**Date:** 2026-08-23  
**Link:** https://leetcode.com/problems/sum-game/

## Approach

To solve the "Sum Game" problem, we need to determine whether Alice can guarantee a win given that both players play optimally. The key steps in the approach are as follows:

1. **Divide the String**: Split the input string `num` into two halves. This will allow us to separately calculate the digit sums for Alice's and Bob's respective halves.

2. **Calculate Fixed Sums and Count `?`**: For each half, compute the sum of the known digits and count the number of `?` characters. Let’s denote:
   - `sum1` as the sum of digits in the first half,
   - `sum2` as the sum of digits in the second half,
   - `count1` as the number of `?` in the first half,
   - `count2` as the number of `?` in the second half.

3. **Determine the Range of Possible Sums**: Since Alice and Bob can replace `?` with any digit from `0` to `9`, calculate the minimum and maximum possible sums for both halves:
   - The maximum possible sum for the first half can be calculated as `sum1 + count1 * 9`.
   - The minimum possible sum for the first half is simply `sum1` (if all `?` are replaced with `0`).
   - Similarly, calculate the maximum and minimum for the second half.

4. **Evaluate Winning Conditions**: 
   - For Alice to win, the maximum possible sum of the first half must be less than the minimum possible sum of the second half, or vice versa. This means:
     - `sum1 + count1 * 9 < sum2` (Alice can make the first half smaller than the second)
     - or `sum2 + count2 * 9 < sum1` (Alice can make the second half smaller than the first).
   - If neither condition holds, Bob can always adjust his moves to equalize the sums.

5. **Return the Result**: Based on the evaluations in the previous step, return `true` if Alice can guarantee a win, and `false` otherwise.

### Data Structures:
- Simple integer variables to store sums and counts.
- No complex data structures are needed since we are primarily working with integers and basic arithmetic.

### Complexity:
- The time complexity is O(n), where n is the length of the input string. This is due to the need to iterate through the string to calculate sums and counts.
- The space complexity is O(1) since we only use a fixed amount of additional space for storing sums and counts, regardless of the input size.

This approach efficiently determines the outcome of the game based on the initial configuration of digits and `?`, ensuring that we account for all possible optimal moves by both players.
