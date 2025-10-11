# Merge Intervals

## Problem Statement

Given an array of `intervals` where `intervals[i] = [starti, endi]`, merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

## Examples

**Example 1:**
```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
```

## Approach

### Method 1: Sorting + Merge (Recommended)
1. Sort intervals by start time
2. Merge overlapping intervals
3. Most efficient approach

**Time Complexity:** O(n log n) - Sorting
**Space Complexity:** O(1) - In-place modification

### Method 2: Sweep Line Algorithm
1. Use sweep line to process events
2. Less efficient than sorting approach
3. More complex implementation

**Time Complexity:** O(n log n) - Sorting events
**Space Complexity:** O(n) - Event list

## Algorithm

```
1. Sort intervals by start time
2. Initialize result with first interval
3. For each remaining interval:
   a. If overlaps with last interval: merge
   b. Else: add to result
4. Return result
```

## Key Insights

- **Sorting**: Sort by start time for efficient merging
- **Local Optimum**: Merge overlapping intervals optimally
- **Global Optimum**: Minimize number of intervals
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Sweep Line**: Use sweep line algorithm
2. **Graph**: Use graph-based approach
3. **Brute Force**: Check all pairs

## Edge Cases

- Empty intervals: Return empty array
- Single interval: Return that interval
- No overlaps: Return original intervals
- All overlaps: Return single interval

## Applications

- Interval algorithms
- Scheduling problems
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Sorting Algorithm**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Logarithmic Time**: O(n log n) time complexity
- **No Extra Space**: Use only necessary space
