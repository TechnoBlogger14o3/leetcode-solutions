# Maximum Subarray

## Problem Statement

Given an integer array `nums`, find the subarray with the largest sum, and return its sum.

## Examples

**Example 1:**
```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
```

## Approach

### Method 1: Kadane's Algorithm (Recommended)
1. Use greedy approach to track maximum sum ending at each position
2. If current sum becomes negative, reset to 0
3. Keep track of maximum sum seen so far
4. Most efficient approach

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(1) - Two variables

### Method 2: Dynamic Programming
1. Use DP to store maximum sum ending at each position
2. dp[i] = max(nums[i], dp[i-1] + nums[i])
3. Less efficient than Kadane's algorithm

**Time Complexity:** O(n) - Single pass
**Space Complexity:** O(n) - DP array

## Algorithm

```
1. Initialize maxSum = nums[0], currentSum = nums[0]
2. For i from 1 to n-1:
   a. currentSum = max(nums[i], currentSum + nums[i])
   b. maxSum = max(maxSum, currentSum)
3. Return maxSum
```

## Key Insights

- **Greedy Choice**: If current sum becomes negative, reset to 0
- **Local Optimum**: Maximum sum ending at each position
- **Global Optimum**: Maximum sum seen so far
- **Space Optimization**: Use only two variables

## Alternative Approaches

1. **Dynamic Programming**: Use DP array
2. **Divide and Conquer**: Use divide and conquer approach
3. **Brute Force**: Check all subarrays

## Edge Cases

- Single element: Return that element
- All negative: Return maximum element
- All positive: Return sum of all elements
- Mixed: Handle appropriately

## Applications

- Greedy algorithms
- Dynamic programming patterns
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Kadane's Algorithm**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Single Pass**: O(n) time complexity
- **No Extra Space**: Use only two variables
