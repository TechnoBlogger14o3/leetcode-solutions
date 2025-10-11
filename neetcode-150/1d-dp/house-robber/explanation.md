# House Robber

## Problem Statement

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
```

## Approach

### Method 1: Dynamic Programming (Recommended)
1. Use DP to store maximum money at each house
2. dp[i] = max(dp[i-1], dp[i-2] + nums[i])
3. Either rob current house or skip it
4. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(n) - DP array

### Method 2: Space-Optimized DP
1. Use only two variables instead of array
2. Track previous two maximum values
3. Most memory efficient

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - Two variables

## Algorithm

```
1. Initialize dp[0] = nums[0], dp[1] = max(nums[0], nums[1])
2. For i from 2 to n-1:
   dp[i] = max(dp[i-1], dp[i-2] + nums[i])
3. Return dp[n-1]
```

## Key Insights

- **State Transition**: dp[i] = max(dp[i-1], dp[i-2] + nums[i])
- **Decision Making**: Either rob current house or skip it
- **Adjacent Constraint**: Cannot rob adjacent houses
- **Space Optimization**: Use only two variables

## Alternative Approaches

1. **Recursion**: Use recursive approach with memoization
2. **Greedy**: Not applicable due to constraints
3. **Backtracking**: Less efficient than DP

## Edge Cases

- Empty array: Return 0
- Single house: Return nums[0]
- Two houses: Return max(nums[0], nums[1])
- All same values: Handle appropriately

## Applications

- Dynamic programming patterns
- Optimization problems
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Space Optimization**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **No Recursion**: Avoid stack overflow
- **Memory Efficient**: Use only two variables
