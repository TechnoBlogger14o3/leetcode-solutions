# Distinct Subsequences

## Problem Statement

Given two strings `s` and `t`, return the number of distinct subsequences of `s` which equals `t`.

The test cases are generated so that the answer fits in a 32-bit signed integer.

## Examples

**Example 1:**
```
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP table to store number of distinct subsequences
2. dp[i][j] = number of ways to form t[0:j] from s[0:i]
3. Handle character matching and skipping
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
1. Initialize dp[0][j] = 1 for all j (empty string)
2. For i from 1 to m:
   For j from 1 to n:
     If s[i-1] == t[j-1]:
       dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
     Else:
       dp[i][j] = dp[i-1][j]
3. Return dp[m][n]
```

## Key Insights

- **State Transition**: dp[i][j] = dp[i-1][j-1] + dp[i-1][j] if match, else dp[i-1][j]
- **Base Case**: dp[0][j] = 1 (empty string can form empty target)
- **Character Matching**: Check if characters match
- **Space Optimization**: Use only two rows

## Alternative Approaches

1. **Recursion**: Use recursive approach with memoization
2. **Backtracking**: Use backtracking to explore all possibilities
3. **Iterative**: Use iterative approach

## Edge Cases

- Empty strings: Return 1
- No subsequence: Return 0
- Single character: Handle appropriately
- Identical strings: Return 1

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
