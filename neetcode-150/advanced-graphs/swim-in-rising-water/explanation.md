# Swim in Rising Water

## Problem Statement

You are given an `n x n` integer matrix `grid` where each value `grid[i][j]` represents the elevation at that point `(i, j)`.

The rain starts to fall. At time `t`, the depth of the water everywhere is `t`. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most `t`. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square `(n - 1, n - 1)` if you start at the top left square `(0, 0)`.

## Examples

**Example 1:**
```
Input: grid = [[0,2],[1,3]]
Output: 3
```

## Approach

### Method 1: Binary Search + DFS (Recommended)
1. Binary search on time values
2. For each time, check if path exists using DFS
3. Most efficient for this problem

**Time Complexity:** O(n² log(max(grid))) - Binary search + DFS
**Space Complexity:** O(n²) - Recursion stack

### Method 2: Dijkstra's Algorithm
1. Use Dijkstra's with modified edge weights
2. Edge weight is max of current and next cell
3. Less efficient than binary search

**Time Complexity:** O(n² log n) - Dijkstra's algorithm
**Space Complexity:** O(n²) - Priority queue

## Algorithm

```
1. Binary search on time values [0, max(grid)]
2. For each time t:
   a. DFS from (0,0) to (n-1,n-1)
   b. Only move to cells with elevation <= t
   c. If path exists: try smaller time
   d. Else: try larger time
3. Return minimum valid time
```

## Key Insights

- **Binary Search**: Search on time values
- **Path Existence**: Use DFS to check if path exists
- **Elevation Constraint**: Only move to cells with elevation <= t
- **Minimum Time**: Find minimum time for valid path

## Alternative Approaches

1. **Dijkstra's**: Use Dijkstra's with modified weights
2. **Union Find**: Use Union Find for connectivity
3. **BFS**: Use BFS for path finding

## Edge Cases

- Single cell: Return grid[0][0]
- 2x2 grid: Return max of start and end
- All same elevation: Return that elevation
- No path: Should not occur per problem statement

## Applications

- Pathfinding algorithms
- Graph algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Binary Search**: Most efficient approach
- **DFS**: O(n²) path checking
- **Logarithmic Search**: O(log(max)) binary search
- **Memory Efficient**: O(n²) space complexity
