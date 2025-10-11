# Decode Ways

## Problem Statement

A message containing letters from `A-Z` can be encoded into numbers using the following mapping:

```
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
```

To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, `"11106"` can be mapped into:

- `"AAJF"` with the grouping `(1 1 10 6)`
- `"KJF"` with the grouping `(11 10 6)`

Note that the grouping `(1 11 06)` is invalid because `"06"` cannot be mapped into `'F'` since `"6"` is different from `"06"`.

Given a string `s` containing only digits, return the number of ways to decode it.

## Examples

**Example 1:**
```
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP to store number of ways to decode each position
2. dp[i] = dp[i-1] + dp[i-2] (if valid)
3. Handle single and double digit cases
4. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(n) - DP array

### Method 2: Space-Optimized DP
1. Use only two variables instead of array
2. Track previous two values
3. Most memory efficient

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - Two variables

## Algorithm

```
1. Initialize dp[0] = 1, dp[1] = 1 (if valid)
2. For i from 2 to n:
   a. If single digit valid: dp[i] += dp[i-1]
   b. If double digit valid: dp[i] += dp[i-2]
3. Return dp[n]
```

## Key Insights

- **State Transition**: dp[i] = dp[i-1] + dp[i-2] (if valid)
- **Single Digit**: Check if s[i] is valid (1-9)
- **Double Digit**: Check if s[i-1:i] is valid (10-26)
- **Space Optimization**: Use only two variables

## Alternative Approaches

1. **Recursion**: Use recursive approach with memoization
2. **Backtracking**: Use backtracking to explore all ways
3. **Iterative**: Use iterative approach

## Edge Cases

- Empty string: Return 0
- Single digit: Return 1 (if valid)
- Leading zero: Return 0
- Invalid characters: Return 0

## Applications

- Dynamic programming patterns
- String processing
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Space Optimization**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **No Recursion**: Avoid stack overflow
- **Memory Efficient**: Use only two variables
