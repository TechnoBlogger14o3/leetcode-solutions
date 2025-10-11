# Climbing Stairs

## Problem Statement

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?

## Examples

**Example 1:**
```
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP to store number of ways to reach each step
2. dp[i] = dp[i-1] + dp[i-2]
3. Similar to Fibonacci sequence
4. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(n) - DP array

### Method 2: Space-Optimized DP
1. Use only two variables instead of array
2. Update variables iteratively
3. Most memory efficient

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - Two variables

## Algorithm

```
1. Initialize dp[0] = 1, dp[1] = 1
2. For i from 2 to n:
   dp[i] = dp[i-1] + dp[i-2]
3. Return dp[n]
```

## Key Insights

- **Fibonacci Pattern**: Same as Fibonacci sequence
- **State Transition**: dp[i] = dp[i-1] + dp[i-2]
- **Base Cases**: dp[0] = 1, dp[1] = 1
- **Space Optimization**: Use only two variables

## Alternative Approaches

1. **Recursion**: Use recursive approach with memoization
2. **Matrix Exponentiation**: Use matrix power for O(log n)
3. **Mathematical Formula**: Use Binet's formula

## Edge Cases

- n = 0: Return 1
- n = 1: Return 1
- n = 2: Return 2
- Large n: Handle overflow

## Applications

- Fibonacci sequence
- Dynamic programming patterns
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Space Optimization**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **No Recursion**: Avoid stack overflow
- **Memory Efficient**: Use only two variables
