# Find All Possible Stable Binary Arrays II (Hard)

**Problem ID:** 3130  
**Date:** 2026-03-10  
**Link:** https://leetcode.com/problems/find-all-possible-stable-binary-arrays-ii/

## Approach

To solve the problem of finding all possible stable binary arrays given the constraints on the number of zeros, ones, and the limit on subarray sizes, we can utilize a dynamic programming (DP) approach. 

### Main Idea:
The core idea is to build valid binary arrays by considering the placement of zeros and ones while adhering to the stability condition. A stable binary array must have exactly one '1', and any subarray longer than the specified limit must include both '0' and '1'. 

### Dynamic Programming Approach:
1. **State Definition**:
   Define a DP table `dp[i][j]` where `i` represents the number of zeros used and `j` represents the number of ones used. The value `dp[i][j]` will store the number of valid stable binary arrays that can be formed with `i` zeros and `j` ones.

2. **Initialization**:
   Initialize `dp[0][1]` to 1, as the only stable array with no zeros and one '1' is `[1]`.

3. **Transition**:
   For each combination of zeros `i` and ones `j`, we can consider two cases:
   - **Adding a '1'**: If we add a '1', we can only do this if we have not exceeded the limit on the number of zeros that can precede it. This means we can add a '1' after a certain number of zeros.
   - **Adding a '0'**: When adding a '0', we need to ensure that it does not violate the stability condition. Specifically, if we add a '0', we must ensure that the last segment of the array (of size greater than the limit) contains at least one '1'.

   The transition can be calculated based on previously computed states, ensuring that we respect the limit condition. 

4. **Final Calculation**:
   The result will be the sum of all valid configurations stored in `dp[zero][1]` for varying numbers of zeros, ensuring that we only consider configurations that include the required number of zeros and exactly one '1'.

### Data Structures:
- A 2D list (or array) `dp` to store the number of valid configurations for different counts of zeros and ones.

### Complexity:
The time complexity of this approach is O(zero * one), where `zero` and `one` are the counts of zeros and ones respectively. This is due to the nested loops iterating through possible counts of zeros and ones. The space complexity is also O(zero * one) for storing the DP table.

### Conclusion:
By leveraging dynamic programming, we can efficiently count the number of valid stable binary arrays while adhering to the constraints provided. This method ensures that we explore all configurations systematically and avoids redundant calculations through memoization.
