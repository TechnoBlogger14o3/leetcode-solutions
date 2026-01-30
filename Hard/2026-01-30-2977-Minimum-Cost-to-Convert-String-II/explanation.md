# Minimum Cost to Convert String II (Hard)

**Problem ID:** 2977  
**Date:** 2026-01-30  
**Link:** https://leetcode.com/problems/minimum-cost-to-convert-string-ii/

## Approach

To solve the problem of converting the `source` string into the `target` string at the minimum cost, we can adopt a dynamic programming (DP) approach combined with a graph-like representation of substring transformations.

### Approach:

1. **Character Mapping**: 
   - Create a mapping from each character in `original` to its possible transformations in `changed`, along with their associated costs. This allows us to efficiently look up possible transformations for any character in the `source` string.

2. **Dynamic Programming Table**:
   - Define a DP array `dp[i]` where `dp[i]` represents the minimum cost to convert the substring `source[0..i]` to `target[0..i]`. Initialize `dp[0]` to 0 (no cost to convert an empty substring) and other entries to infinity (as we want to find the minimum).
   
3. **Iterate Through the Source and Target**:
   - For each position `i` in the `source` string, check if the character matches the corresponding character in the `target`. If they match, set `dp[i] = dp[i-1]` (no cost).
   - If they do not match, explore the possible transformations:
     - For each substring `source[j..i]`, check if it can be transformed into `target[j..i]` using the mappings. If a valid transformation exists, update `dp[i]` with the minimum cost found by adding the transformation cost to `dp[j-1]`.
     - Ensure that the substrings being transformed do not overlap, adhering to the problem's constraints.

4. **Final Result**:
   - The value `dp[n-1]` (where `n` is the length of the strings) will give the minimum cost to transform the entire `source` into `target`. If it remains infinity, return -1 indicating that the transformation is impossible.

### Data Structures:
- A dictionary to map each substring in `original` to a list of tuples containing corresponding `changed` strings and their costs.
- A DP array of size `n` to track the minimum costs.

### Complexity:
- The time complexity is O(n^2 * m), where `n` is the length of the `source` and `target`, and `m` is the number of transformations (size of `original`). This is due to the nested loops for each character position and the potential substring checks.
- The space complexity is O(n + m) for the DP array and the transformation mapping.

This structured approach efficiently computes the minimum cost while respecting the transformation rules and constraints laid out in the problem statement.
