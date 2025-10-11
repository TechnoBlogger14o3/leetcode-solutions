# Minimum Number of Arrows to Burst Balloons

## Problem Statement

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D array `points` where `points[i] = [xstart, xend]` denotes a horizontal diameter of the balloon at `xstart` and `xend`. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with `xstart` and `xend` is burst by an arrow shot at x if `xstart <= x <= xend`. There is no limit to the number of arrows you can shoot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array `points`, return the minimum number of arrows that must be shot to burst all balloons.

## Examples

**Example 1:**
```
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
```

## Approach

### Method 1: Greedy Algorithm (Recommended)
1. Sort balloons by end position
2. Use greedy approach to shoot arrows
3. Shoot arrow at end of first balloon
4. Most efficient approach

**Time Complexity:** O(n log n) - Sorting
**Space Complexity:** O(1) - In-place modification

### Method 2: Sorting by Start Position
1. Sort balloons by start position
2. Use different greedy logic
3. Less efficient than sorting by end position

**Time Complexity:** O(n log n) - Sorting
**Space Complexity:** O(1) - In-place modification

## Algorithm

```
1. Sort balloons by end position
2. Initialize arrows = 1, end = points[0][1]
3. For i from 1 to n-1:
   a. If points[i][0] > end: arrows++, end = points[i][1]
4. Return arrows
```

## Key Insights

- **Greedy Choice**: Always shoot arrow at end of first balloon
- **Local Optimum**: Maximum balloons burst per arrow
- **Global Optimum**: Minimum number of arrows needed
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Sorting by Start**: Sort by start position
2. **Sweep Line**: Use sweep line algorithm
3. **Brute Force**: Try all possible arrow positions

## Edge Cases

- Empty balloons: Return 0
- Single balloon: Return 1
- No overlaps: Return n
- All overlaps: Return 1

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
