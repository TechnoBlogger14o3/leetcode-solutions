# Insert Interval

## Problem Statement

You are given an array of non-overlapping intervals `intervals` where `intervals[i] = [starti, endi]` represent the start and the end of the `ith` interval and `intervals` is sorted in ascending order by `starti`. You are also given an interval `newInterval = [start, end]` that represents the start and end of another interval.

Insert `newInterval` into `intervals` such that the intervals are still sorted in ascending order by `starti` and `intervals` still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return `intervals` after the insertion.

## Examples

**Example 1:**
```
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
```

## Approach

### Method 1: Three Pass Algorithm (Recommended)
1. First pass: Add all intervals before newInterval
2. Second pass: Merge overlapping intervals with newInterval
3. Third pass: Add all intervals after newInterval
4. Most efficient approach

**Time Complexity:** O(n) - Three passes
**Space Complexity:** O(1) - In-place modification

### Method 2: Binary Search + Merge
1. Use binary search to find insertion point
2. Merge overlapping intervals
3. Less efficient than three pass approach

**Time Complexity:** O(n) - Merge operation
**Space Complexity:** O(1) - In-place modification

## Algorithm

```
1. Initialize result = []
2. Add all intervals before newInterval
3. Merge overlapping intervals with newInterval
4. Add all intervals after newInterval
5. Return result
```

## Key Insights

- **Three Passes**: Separate intervals into three categories
- **Local Optimum**: Merge overlapping intervals optimally
- **Global Optimum**: Maintain sorted order without overlaps
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Binary Search**: Use binary search for insertion point
2. **Single Pass**: Use single pass with complex logic
3. **Sorting**: Sort all intervals and merge

## Edge Cases

- Empty intervals: Return [newInterval]
- Single interval: Merge if overlapping
- No overlaps: Insert in correct position
- All overlaps: Merge into single interval

## Applications

- Interval algorithms
- Scheduling problems
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Three Pass Algorithm**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Linear Time**: O(n) time complexity
- **No Extra Space**: Use only necessary space
