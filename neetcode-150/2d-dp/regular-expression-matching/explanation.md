# Regular Expression Matching

## Problem Statement

Given an input string `s` and a pattern `p`, implement regular expression matching with support for `'.'` and `'*'` where:

- `'.'` Matches any single character
- `'*'` Matches zero or more of the preceding element

The matching should cover the entire input string (not partial).

## Examples

**Example 1:**
```
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP table to store matching results
2. dp[i][j] = true if s[0:i] matches p[0:j]
3. Handle '.' and '*' patterns
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
1. Initialize dp[0][0] = true
2. For i from 0 to m:
   For j from 1 to n:
     If p[j-1] == '*':
       dp[i][j] = dp[i][j-2] || (i > 0 && dp[i-1][j] && (s[i-1] == p[j-2] || p[j-2] == '.'))
     Else:
       dp[i][j] = i > 0 && dp[i-1][j-1] && (s[i-1] == p[j-1] || p[j-1] == '.')
3. Return dp[m][n]
```

## Key Insights

- **State Transition**: dp[i][j] = true if s[0:i] matches p[0:j]
- **Base Case**: dp[0][0] = true
- **Pattern Matching**: Handle '.' and '*' patterns
- **Space Optimization**: Use only two rows

## Alternative Approaches

1. **Recursion**: Use recursive approach with memoization
2. **Backtracking**: Use backtracking to explore all possibilities
3. **Iterative**: Use iterative approach

## Edge Cases

- Empty string and pattern: Return true
- Empty string, non-empty pattern: Handle appropriately
- Non-empty string, empty pattern: Return false
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
