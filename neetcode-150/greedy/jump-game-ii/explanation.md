# Jump Game II

## Problem Statement

You are given a 0-indexed integer array `nums` of length `n`. You are initially positioned at `nums[0]`.

Each element `nums[i]` represents the maximum jump length at that position.

Return the minimum number of jumps to reach `nums[n - 1]`. The test cases are generated such that you can reach `nums[n - 1]`.

## Examples

**Example 1:**
```
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

## Approach

### Method 1: Greedy Algorithm (Recommended)
1. Track the farthest position we can reach with current jumps
2. Track the farthest position we can reach with next jump
3. When we reach the end of current jump range, increment jump count
4. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - Two variables

### Method 2: Dynamic Programming
1. Use DP to store minimum jumps to reach each position
2. dp[i] = minimum jumps to reach position i
3. Less efficient than greedy approach

**Time Complexity:** O(n²) - Nested loops
**Space Complexity:** O(n) - DP array

## Algorithm

```
1. Initialize jumps = 0, currentEnd = 0, farthest = 0
2. For i from 0 to n-2:
   a. farthest = max(farthest, i + nums[i])
   b. If i == currentEnd:
      c. jumps++
      d. currentEnd = farthest
3. Return jumps
```

## Key Insights

- **Greedy Choice**: Always try to reach the farthest position with minimum jumps
- **Local Optimum**: Maximum reachable position with current jumps
- **Global Optimum**: Minimum number of jumps to reach last index
- **Space Optimization**: Use only two variables

## Alternative Approaches

1. **Dynamic Programming**: Use DP array
2. **BFS**: Use BFS to find shortest path
3. **Backtracking**: Use backtracking to explore all paths

## Edge Cases

- Single element: Return 0
- Two elements: Return 1
- All ones: Return n-1
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
- **No Extra Space**: Use only two variables
