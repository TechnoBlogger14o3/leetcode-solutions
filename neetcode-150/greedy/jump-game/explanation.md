# Jump Game

## Problem Statement

You are given an integer array `nums`. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return `true` if you can reach the last index, or `false` otherwise.

## Examples

**Example 1:**
```
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

## Approach

### Method 1: Greedy Algorithm (Recommended)
1. Track the farthest position we can reach
2. Update farthest position at each step
3. If farthest position >= last index, return true
4. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - One variable

### Method 2: Dynamic Programming
1. Use DP to store if each position is reachable
2. dp[i] = true if position i is reachable
3. Less efficient than greedy approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(n) - DP array

## Algorithm

```
1. Initialize farthest = 0
2. For i from 0 to n-1:
   a. If i > farthest: return false
   b. farthest = max(farthest, i + nums[i])
3. Return farthest >= n-1
```

## Key Insights

- **Greedy Choice**: Always try to reach the farthest position
- **Local Optimum**: Maximum reachable position at each step
- **Global Optimum**: Can reach the last index
- **Space Optimization**: Use only one variable

## Alternative Approaches

1. **Dynamic Programming**: Use DP array
2. **Backtracking**: Use backtracking to explore all paths
3. **BFS**: Use BFS to find shortest path

## Edge Cases

- Single element: Return true
- All zeros: Return false (except last element)
- All ones: Return true
- Large jumps: Handle appropriately

## Applications

- Greedy algorithms
- Dynamic programming patterns
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Greedy Algorithm**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **No Extra Space**: Use only one variable
