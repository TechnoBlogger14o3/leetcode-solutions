# Combination Sum IV

## Problem Statement

Given an array of distinct integers `nums` and a target integer `target`, return the number of possible combinations that add up to `target`.

The test cases are generated so that the answer can fit in a 32-bit integer.

## Examples

**Example 1:**
```
Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP to store number of ways to reach each target
2. dp[i] = sum of dp[i-num] for all nums
3. Initialize dp[0] = 1
4. Most efficient approach

**Time Complexity:** O(target * nums.length)
**Space Complexity:** O(target) - DP array

### Method 2: Recursion with Memoization
1. Use recursive approach with memoization
2. Explore all possible combinations
3. Less efficient than DP

**Time Complexity:** O(target * nums.length)
**Space Complexity:** O(target) - Recursion stack

## Algorithm

```
1. Initialize dp[0] = 1
2. For i from 1 to target:
   a. For each num in nums:
      b. If num <= i: dp[i] += dp[i-num]
3. Return dp[target]
```

## Key Insights

- **State Transition**: dp[i] = sum of dp[i-num] for all nums
- **Order Matters**: (1,2) and (2,1) are different
- **Base Case**: dp[0] = 1 (one way to make 0)
- **Space Optimization**: Use DP array

## Alternative Approaches

1. **Recursion**: Use recursive approach with memoization
2. **Backtracking**: Use backtracking to explore combinations
3. **Iterative**: Use iterative approach

## Edge Cases

- Empty nums: Return 0
- Target = 0: Return 1
- No solution: Return 0
- Single number: Handle appropriately

## Applications

- Dynamic programming patterns
- Combination problems
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Dynamic Programming**: Most efficient approach
- **Single Pass**: O(target * nums) time complexity
- **Space Efficient**: O(target) space complexity
- **No Recursion**: Avoid stack overflow
