# Distinct Subsequences (Hard)

**Problem ID:** 115  
**Date:** 2026-09-06  
**Link:** https://leetcode.com/problems/distinct-subsequences/

## Approach

To solve the "Distinct Subsequences" problem, we can utilize a dynamic programming approach, which efficiently counts the number of distinct subsequences of string `s` that match string `t`.

### Main Idea:
The core idea is to use a 2D dynamic programming (DP) table where `dp[i][j]` represents the number of distinct subsequences of the first `i` characters of `s` that match the first `j` characters of `t`. We will build this table iteratively based on the following rules:

1. **Base Case**:
   - If `t` is an empty string (`j = 0`), there is exactly one subsequence of `s` (the empty subsequence) that matches `t`. Thus, `dp[i][0] = 1` for all `i`.
   - If `s` is an empty string (`i = 0`) and `t` is not, then there are no subsequences, so `dp[0][j] = 0` for all `j > 0`.

2. **Filling the DP Table**:
   - For each character in `s` (indexed by `i`) and each character in `t` (indexed by `j`):
     - If `s[i-1] == t[j-1]`, we can either use this character from `s` to match the character from `t` or skip it:
       - Use it: `dp[i-1][j-1]` (matches the current characters)
       - Skip it: `dp[i-1][j]` (does not match)
       - Thus, the recurrence relation becomes: 
         \[
         dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
         \]
     - If `s[i-1] != t[j-1]`, we can only skip the character from `s`:
       \[
       dp[i][j] = dp[i-1][j]
       \]

3. **Final Result**:
   - The answer to the problem, which is the number of distinct subsequences of `s` that equal `t`, will be found in `dp[len(s)][len(t)]`.

### Data Structures:
- A 2D array `dp` of size `(len(s) + 1) x (len(t) + 1)` is used to store the counts of subsequences.

### Complexity:
- **Time Complexity**: O(m * n), where `m` is the length of string `s` and `n` is the length of string `t`. This is due to the nested loops filling the DP table.
- **Space Complexity**: O(m * n) for the DP table. However, it can be optimized to O(n) by using a single-dimensional array and updating it in reverse order.

This approach efficiently calculates the number of distinct subsequences by leveraging the properties of subsequences and the structure of dynamic programming.
