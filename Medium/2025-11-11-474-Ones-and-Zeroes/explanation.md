# Ones and Zeroes (Medium)

**Problem ID:** 474  
**Date:** 2025-11-11  
**Link:** https://leetcode.com/problems/ones-and-zeroes/

## Approach

To solve the "Ones and Zeroes" problem, we can utilize a dynamic programming approach similar to the "0/1 Knapsack" problem. The main idea is to maintain a 2D DP table that keeps track of the maximum size of the subset of binary strings that can be formed with a given number of zeros and ones.

### Approach:

1. **Count Zeros and Ones**: For each binary string in the input array, count the number of zeros and ones. This can be done using simple iteration over each string.

2. **Dynamic Programming Table**: Create a 2D DP array `dp` where `dp[i][j]` represents the maximum size of the subset that can be formed with at most `i` zeros and `j` ones.

3. **Initialization**: Initialize the DP table with zeros. The base case is `dp[0][0] = 0`, meaning with zero zeros and zero ones, the maximum subset size is zero.

4. **Filling the DP Table**:
   - Iterate over each string and its corresponding count of zeros (`zero_count`) and ones (`one_count`).
   - Update the DP table in reverse order (from `m` to `zero_count` and from `n` to `one_count`). This prevents overwriting results of the current iteration.
   - For each valid combination of zeros and ones, update the DP value as follows:
     ```
     dp[i][j] = max(dp[i][j], dp[i - zero_count][j - one_count] + 1)
     ```
   - This means we can either choose to include the current string (hence the `+1`) or not include it.

5. **Result Extraction**: The result will be found at `dp[m][n]`, which gives the size of the largest subset that can be formed with at most `m` zeros and `n` ones.

### Data Structures:
- A 2D list (or array) for the DP table, where dimensions are `(m + 1) x (n + 1)`.

### Complexity:
- **Time Complexity**: O(S * m * n), where `S` is the number of strings in `strs`. This is due to iterating through each string and updating the DP table.
- **Space Complexity**: O(m * n) for the DP table.

This approach efficiently computes the maximum subset size while adhering to the constraints on the number of zeros and ones, leveraging the principles of dynamic programming to build up solutions from smaller subproblems.
