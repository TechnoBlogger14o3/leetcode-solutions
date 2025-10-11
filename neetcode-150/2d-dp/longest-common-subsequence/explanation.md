# Longest Common Subsequence

## Problem Statement

Given two strings `text1` and `text2`, return the length of their longest common subsequence. If there is no common subsequence, return `0`.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

## Examples

**Example 1:**
```
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP table to store LCS length
2. dp[i][j] = dp[i-1][j-1] + 1 if chars match, else max(dp[i-1][j], dp[i][j-1])
3. Fill DP table bottom-up
4. Most efficient approach

**Time Complexity:** O(m * n) - Fill DP table
**Space Complexity:** O(m * n) - DP table

### Method 2: Space-Optimized DP
1. Use only two rows instead of full table
2. Alternate between current and previous row
3. Most memory efficient

**Time Complexity:** O(m * n) - Fill DP table
**Space Complexity:** O(min(m, n)) - Two rows

## Algorithm

```
1. Initialize dp[0][j] = 0 and dp[i][0] = 0
2. For i from 1 to m:
   For j from 1 to n:
     If text1[i-1] == text2[j-1]:
       dp[i][j] = dp[i-1][j-1] + 1
     Else:
       dp[i][j] = max(dp[i-1][j], dp[i][j-1])
3. Return dp[m][n]
```

## Key Insights

- **State Transition**: dp[i][j] = dp[i-1][j-1] + 1 if match, else max(dp[i-1][j], dp[i][j-1])
- **Base Cases**: First row and column = 0
- **Character Matching**: Check if characters match
- **Space Optimization**: Use only two rows

## Alternative Approaches

1. **Recursion**: Use recursive approach with memoization
2. **Backtracking**: Use backtracking to find actual LCS
3. **Iterative**: Use iterative approach

## Edge Cases

- Empty strings: Return 0
- No common subsequence: Return 0
- Identical strings: Return length
- Single character: Handle appropriately

## Applications

- Dynamic programming patterns
- String algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Space Optimization**: O(min(m, n)) space complexity
- **Single Pass**: O(m * n) time complexity
- **Memory Efficient**: Use only two rows
- **No Recursion**: Avoid stack overflow
