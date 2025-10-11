# Interval List Intersections

## Problem Statement

You are given two lists of closed intervals, `firstList` and `secondList`, where `firstList[i] = [starti, endi]` and `secondList[j] = [startj, endj]`. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval `[a, b]` (with `a <= b`) denotes the set of real numbers `x` with `a <= x <= b`.

The intersection of two closed intervals is a set of real numbers that are empty or represented as a closed interval. For example, the intersection of `[1, 3]` and `[2, 4]` is `[2, 3]`.

## Examples

**Example 1:**
```
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
```

## Approach

### Method 1: Two Pointers (Recommended)
1. Use two pointers to traverse both lists
2. Find intersection of current intervals
3. Move pointer of interval that ends first
4. Most efficient approach

**Time Complexity:** O(m + n) - Two pointers
**Space Complexity:** O(1) - In-place modification

### Method 2: Brute Force
1. Check all pairs of intervals
2. Less efficient than two pointers approach

**Time Complexity:** O(m * n) - Nested loops
**Space Complexity:** O(1) - No extra space

## Algorithm

```
1. Initialize i = 0, j = 0
2. While i < m and j < n:
   a. Find intersection of intervals[i] and intervals[j]
   b. If intersection exists: add to result
   c. Move pointer of interval that ends first
3. Return result
```

## Key Insights

- **Two Pointers**: Efficiently traverse both lists
- **Local Optimum**: Find intersection of current intervals
- **Global Optimum**: All intersections found
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Brute Force**: Check all pairs
2. **Sweep Line**: Use sweep line algorithm
3. **Binary Search**: Use binary search for efficiency

## Edge Cases

- Empty lists: Return empty list
- No intersections: Return empty list
- All intersections: Return all intervals
- Single intersection: Return that intersection

## Applications

- Interval algorithms
- Scheduling problems
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Two Pointers**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Linear Time**: O(m + n) time complexity
- **No Extra Space**: Use only necessary space
