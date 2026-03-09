# Find All Possible Stable Binary Arrays I (Medium)

**Problem ID:** 3129  
**Date:** 2026-03-09  
**Link:** https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/

## Approach

To solve the problem of finding all possible stable binary arrays given the constraints on the number of zeros, ones, and the subarray limit, we can use a combinatorial dynamic programming approach.

### Main Idea:
The key observation is that a stable binary array must have exactly one '1' and the rest '0's, and any subarray longer than the specified limit must contain at least one '0' and one '1'. This leads us to consider the placement of '1's and the arrangement of '0's around them.

### Approach:
1. **Dynamic Programming Table**: We can define a dynamic programming table `dp[i][j]` where `i` represents the number of zeros used and `j` represents the number of ones placed. The value of `dp[i][j]` will store the number of valid stable binary arrays that can be formed with `i` zeros and `j` ones.

2. **Base Case**: Initialize `dp[0][1] = 1` since there is only one way to arrange one '1' with zero '0's.

3. **Transition**: For each state `dp[i][j]`, we can derive the next states based on the following:
   - If we place a '1', we can place it in various positions relative to the zeros. The placement must ensure that any segment of the array longer than `limit` contains both '0' and '1'.
   - We can iterate through possible placements of '1's and count how many zeros can be placed before and after each '1', ensuring that we respect the `limit` constraint.

4. **Count Valid Configurations**: For each placement of '1's, calculate how many zeros can be placed such that the resulting segments do not violate the stability condition. This involves checking segments of zeros that can be placed between the '1's and ensuring that segments longer than `limit` are avoided.

5. **Final Count**: The final answer will be the sum of all configurations stored in `dp[zero][1]` after processing all placements.

### Data Structures:
- A 2D array `dp` to store the number of valid configurations for different counts of zeros and ones.
- Additional variables may be needed to track the current counts and placements during the transitions.

### Complexity:
- **Time Complexity**: The approach involves filling out a DP table of size `(zero + 1) x (one + 1)`, leading to a time complexity of O(zero * one).
- **Space Complexity**: The space complexity is also O(zero * one) due to the DP table.

This method efficiently counts valid configurations while adhering to the constraints, allowing us to compute the result even for larger inputs within the specified limits.
