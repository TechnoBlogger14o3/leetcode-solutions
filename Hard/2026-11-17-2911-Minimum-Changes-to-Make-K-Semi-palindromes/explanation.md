# Minimum Changes to Make K Semi-palindromes (Hard)

**Problem ID:** 2911  
**Date:** 2026-11-17  
**Link:** https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/

## Approach

To solve the problem of determining the minimum number of letter changes required to partition a string `s` into `k` semi-palindromic substrings, we can employ a dynamic programming approach combined with precomputation of the costs to convert substrings into semi-palindromes.

### Approach:

1. **Understanding Semi-palindromes**: A substring is a semi-palindrome if it can be divided into groups based on a divisor `d` of its length, where each group forms a palindrome. We need to calculate the number of changes required to convert a substring into a semi-palindrome for each valid divisor.

2. **Precomputation of Costs**: 
   - For each possible substring of `s`, we will compute the minimum number of changes required to make it a semi-palindrome for all valid divisors `d`.
   - This involves iterating through each divisor `d` and grouping characters based on their positions. For each group, we will count character frequencies and determine the number of changes needed to make that group a palindrome.
   - Store these costs in a 2D array `cost[i][j]`, where `i` is the starting index and `j` is the ending index of the substring. This will allow us to quickly retrieve the cost of converting any substring `s[i:j]` into a semi-palindrome.

3. **Dynamic Programming Setup**:
   - Define a DP array `dp[i][j]` where `i` is the number of substrings and `j` is the length of the substring considered. The value `dp[i][j]` represents the minimum changes needed to partition the first `j` characters of `s` into `i` semi-palindromic substrings.
   - Initialize `dp[0][0] = 0` (zero changes for zero substrings) and set all other values to infinity initially.

4. **Filling the DP Table**:
   - For each possible number of substrings `i` from 1 to `k`, and for each length `j` from 1 to the length of `s`, calculate the minimum changes by considering all possible partitions:
     - For each possible split point `p`, update `dp[i][j]` as `dp[i-1][p] + cost[p+1][j]`, where `cost[p+1][j]` is the precomputed cost of converting the substring from `p+1` to `j` into a semi-palindrome.

5. **Final Result**: The answer will be found in `dp[k][n]`, where `n` is the length of `s`, representing the minimum changes required to partition the entire string into `k` semi-palindromic substrings.

### Complexity:
- **Time Complexity**: The precomputation of costs for all substrings takes O(n^3) in the worst case (due to iterating over all substrings and their divisors). The DP filling takes O(k * n^2), leading to an overall complexity of O(n^3 + k * n^2).
- **Space Complexity**: O(n^2) for storing the cost array and O(k * n) for the DP table.

This approach efficiently combines precomputation with dynamic programming to solve the problem within the given constraints.
