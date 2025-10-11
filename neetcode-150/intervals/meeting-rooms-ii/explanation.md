# Meeting Rooms II

## Problem Statement

Given an array of meeting time intervals `intervals` where `intervals[i] = [starti, endi]`, return the minimum number of conference rooms required.

## Examples

**Example 1:**
```
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
```

## Approach

### Method 1: Min Heap (Recommended)
1. Sort intervals by start time
2. Use min heap to track end times
3. Remove rooms when meetings end
4. Most efficient approach

**Time Complexity:** O(n log n) - Sorting + Heap operations
**Space Complexity:** O(n) - Heap

### Method 2: Sweep Line Algorithm
1. Use sweep line to process events
2. Track maximum concurrent meetings
3. Less efficient than min heap approach

**Time Complexity:** O(n log n) - Sorting events
**Space Complexity:** O(n) - Event list

## Algorithm

```
1. Sort intervals by start time
2. Initialize min heap
3. For each interval:
   a. Remove rooms that have ended
   b. Add current meeting to heap
   c. Update maximum rooms needed
4. Return maximum rooms
```

## Key Insights

- **Min Heap**: Track end times efficiently
- **Local Optimum**: Remove rooms when meetings end
- **Global Optimum**: Minimum number of rooms needed
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Sweep Line**: Use sweep line algorithm
2. **Two Pointers**: Use two pointers technique
3. **Brute Force**: Check all possible room assignments

## Edge Cases

- Empty intervals: Return 0
- Single interval: Return 1
- No overlaps: Return 1
- All overlaps: Return n

## Applications

- Interval algorithms
- Scheduling problems
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Min Heap**: Most efficient approach
- **Space Optimization**: O(n) space complexity
- **Logarithmic Time**: O(n log n) time complexity
- **No Extra Space**: Use only necessary space
