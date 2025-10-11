# Interleaving String

## Problem Statement

Given strings `s1`, `s2`, and `s3`, find whether `s3` is formed by an interleaving of `s1` and `s2`.

An interleaving of two strings `s` and `t` is a configuration where `s` and `t` are divided into `n` and `m` non-empty substrings respectively, such that:

- `s = s1 + s2 + ... + sn`
- `t = t1 + t2 + ... + tm`
- `|n - m| <= 1`
- The interleaving is `s1 + t1 + s2 + t2 + ...` or `t1 + s1 + t2 + s2 + ...`

## Examples

**Example 1:**
```
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP table to store if s3[0:i+j] can be formed by interleaving s1[0:i] and s2[0:j]
2. dp[i][j] = true if s3[i+j-1] matches s1[i-1] or s2[j-1]
3. Fill DP table bottom-up
4. Most efficient approach

**Time Complexity:** O(m * n) - Fill DP table
**Space Complexity:** O(m * n) - DP table

### Method 2: Space-Optimized DP
1. Use only one row instead of full table
2. Update row iteratively
3. Most memory efficient

**Time Complexity:** O(m * n) - Fill DP table
**Space Complexity:** O(n) - One row

## Algorithm

```
1. Initialize dp[0][0] = true
2. For i from 0 to m:
   For j from 0 to n:
     If i > 0 and s1[i-1] == s3[i+j-1]:
       dp[i][j] = dp[i][j] || dp[i-1][j]
     If j > 0 and s2[j-1] == s3[i+j-1]:
       dp[i][j] = dp[i][j] || dp[i][j-1]
3. Return dp[m][n]
```

## Key Insights

- **State Transition**: dp[i][j] = true if s3[0:i+j] can be formed by interleaving s1[0:i] and s2[0:j]
- **Base Case**: dp[0][0] = true
- **Character Matching**: Check if characters match
- **Space Optimization**: Use only one row

## Alternative Approaches

1. **Recursion**: Use recursive approach with memoization
2. **Backtracking**: Use backtracking to explore all possibilities
3. **Iterative**: Use iterative approach

## Edge Cases

- Empty strings: Handle appropriately
- Length mismatch: Return false
- No interleaving: Return false
- Single character: Handle appropriately

## Applications

- Dynamic programming patterns
- String algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Space Optimization**: O(n) space complexity
- **Single Pass**: O(m * n) time complexity
- **Memory Efficient**: Use only one row
- **No Recursion**: Avoid stack overflow
