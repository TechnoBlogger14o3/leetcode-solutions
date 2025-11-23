# Greatest Sum Divisible by Three (Medium)

**Problem ID:** 1262  
**Date:** 2025-11-23  
**Link:** https://leetcode.com/problems/greatest-sum-divisible-by-three/

## Approach

To solve the problem of finding the greatest sum of elements in an array that is divisible by three, we can utilize a dynamic programming approach based on the properties of modular arithmetic.

### Main Idea:
The key insight is that the sum of numbers can be categorized based on their remainders when divided by three. Specifically, for any integer, it can yield a remainder of 0, 1, or 2 when divided by 3. By maintaining the maximum possible sums for each of these three categories, we can derive the maximum sum that is divisible by three.

### Approach:
1. **Initialization**: Start by initializing three variables (`max_rem0`, `max_rem1`, and `max_rem2`) to hold the maximum sums that yield remainders 0, 1, and 2, respectively. Set `max_rem0` to 0 (since a sum of 0 is divisible by 3) and the others to negative infinity (to represent that no valid sums have been found yet).

2. **Iterate through the array**: For each number in the input array:
   - Calculate the new potential sums for each remainder category by adding the current number to the existing sums:
     - For `max_rem0`, add the current number to `max_rem0`, `max_rem1`, and `max_rem2`, and update `max_rem0`, `max_rem1`, and `max_rem2` accordingly.
   - Update the maximum sums for each remainder category based on the new sums calculated.

3. **Final Result**: After processing all numbers, the value of `max_rem0` will represent the maximum sum of elements that is divisible by three.

### Data Structures:
- Simple integer variables to store the maximum sums for each of the three remainder categories. This requires constant space, O(1).

### Complexity:
- **Time Complexity**: O(n), where n is the number of elements in the input array, since we iterate through the array once.
- **Space Complexity**: O(1), as we only use a fixed number of additional variables regardless of the input size.

By following this structured approach, we efficiently compute the desired maximum sum that is divisible by three while keeping track of the necessary conditions using modular arithmetic.
