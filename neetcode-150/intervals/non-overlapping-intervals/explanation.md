# Non-overlapping Intervals

## Problem Statement

Given an array of intervals `intervals` where `intervals[i] = [starti, endi]`, return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

## Examples

**Example 1:**
```
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
```

## Approach

### Method 1: Greedy Algorithm (Recommended)
1. Sort intervals by end time
2. Use greedy approach to select non-overlapping intervals
3. Count removed intervals
4. Most efficient approach

**Time Complexity:** O(n log n) - Sorting
**Space Complexity:** O(1) - In-place modification

### Method 2: Dynamic Programming
1. Use DP to find maximum non-overlapping intervals
2. Return total - maximum
3. Less efficient than greedy approach

**Time Complexity:** O(n²) - Nested loops
**Space Complexity:** O(n) - DP array

## Algorithm

```
1. Sort intervals by end time
2. Initialize count = 0, end = intervals[0][1]
3. For i from 1 to n-1:
   a. If intervals[i][0] < end: count++
   b. Else: end = intervals[i][1]
4. Return count
```

## Key Insights

- **Greedy Choice**: Always select interval with earliest end time
- **Local Optimum**: Maximum non-overlapping intervals
- **Global Optimum**: Minimum intervals to remove
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Dynamic Programming**: Use DP for maximum intervals
2. **Sorting by Start**: Sort by start time and use different logic
3. **Brute Force**: Try all possible combinations

## Edge Cases

- Empty intervals: Return 0
- Single interval: Return 0
- No overlaps: Return 0
- All overlaps: Return n-1

## Applications

- Interval algorithms
- Scheduling problems
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Greedy Algorithm**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Logarithmic Time**: O(n log n) time complexity
- **No Extra Space**: Use only necessary space
