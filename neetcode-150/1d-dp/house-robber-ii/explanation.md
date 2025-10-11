# House Robber II

## Problem Statement

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

## Examples

**Example 1:**
```
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
```

## Approach

### Method 1: Dynamic Programming with Circular Constraint (Recommended)
1. Handle circular constraint by considering two cases:
   - Rob houses 0 to n-2 (exclude last house)
   - Rob houses 1 to n-1 (exclude first house)
2. Use House Robber I solution for each case
3. Return maximum of both cases

**Time Complexity:** O(n) - Two passes
**Space Complexity:** O(1) - Two variables

### Method 2: Space-Optimized DP
1. Use helper function for linear robbery
2. Call helper twice with different ranges
3. Most memory efficient

**Time Complexity:** O(n) - Two passes
**Space Complexity:** O(1) - Two variables

## Algorithm

```
1. If single house: return nums[0]
2. Case 1: Rob houses 0 to n-2 (exclude last)
3. Case 2: Rob houses 1 to n-1 (exclude first)
4. Return max(case1, case2)
```

## Key Insights

- **Circular Constraint**: First and last houses are adjacent
- **Two Cases**: Exclude first or last house
- **Linear DP**: Use House Robber I for each case
- **Maximum**: Return maximum of both cases

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
- Circular array problems
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Space Optimization**: O(1) space complexity
- **Two Passes**: O(n) time complexity
- **No Recursion**: Avoid stack overflow
- **Memory Efficient**: Use only two variables
