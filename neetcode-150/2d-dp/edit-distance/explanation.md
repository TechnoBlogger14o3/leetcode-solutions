# Edit Distance

## Problem Statement

Given two strings `word1` and `word2`, return the minimum number of operations required to convert `word1` to `word2`.

You have the following three operations permitted on a word:
- Insert a character
- Delete a character
- Replace a character

## Examples

**Example 1:**
```
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP table to store minimum operations
2. dp[i][j] = min operations to convert word1[0:i] to word2[0:j]
3. Handle insert, delete, replace operations
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
1. Initialize dp[0][j] = j and dp[i][0] = i
2. For i from 1 to m:
   For j from 1 to n:
     If word1[i-1] == word2[j-1]:
       dp[i][j] = dp[i-1][j-1]
     Else:
       dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
3. Return dp[m][n]
```

## Key Insights

- **State Transition**: dp[i][j] = min operations to convert word1[0:i] to word2[0:j]
- **Base Cases**: dp[0][j] = j, dp[i][0] = i
- **Three Operations**: Insert, delete, replace
- **Space Optimization**: Use only two rows

## Alternative Approaches

1. **Recursion**: Use recursive approach with memoization
2. **Backtracking**: Use backtracking to find actual operations
3. **Iterative**: Use iterative approach

## Edge Cases

- Empty strings: Return length of non-empty string
- Identical strings: Return 0
- Single character: Handle appropriately
- No common characters: Return max length

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
