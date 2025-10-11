# Meeting Rooms

## Problem Statement

Given an array of meeting time intervals `intervals` where `intervals[i] = [starti, endi]`, determine if a person could attend all meetings.

## Examples

**Example 1:**
```
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
```

## Approach

### Method 1: Sorting + Check (Recommended)
1. Sort intervals by start time
2. Check if any interval overlaps with the next
3. Most efficient approach

**Time Complexity:** O(n log n) - Sorting
**Space Complexity:** O(1) - In-place modification

### Method 2: Brute Force
1. Check all pairs of intervals for overlap
2. Less efficient than sorting approach

**Time Complexity:** O(n²) - Nested loops
**Space Complexity:** O(1) - No extra space

## Algorithm

```
1. Sort intervals by start time
2. For i from 0 to n-2:
   a. If intervals[i][1] > intervals[i+1][0]: return false
3. Return true
```

## Key Insights

- **Sorting**: Sort by start time for efficient checking
- **Local Optimum**: Check adjacent intervals for overlap
- **Global Optimum**: No overlapping intervals
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Brute Force**: Check all pairs
2. **Sweep Line**: Use sweep line algorithm
3. **Hash Set**: Use hash set for time slots

## Edge Cases

- Empty intervals: Return true
- Single interval: Return true
- No overlaps: Return true
- All overlaps: Return false

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
