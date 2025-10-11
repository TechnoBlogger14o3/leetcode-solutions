# Max Area of Island

## Problem Statement

You are given an `m x n` binary matrix `grid`. An island is a group of `1`'s (representing land) connected 4-directionally (horizontal or vertical). You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value of `1` in the island.

Return the maximum area of an island in `grid`. If there is no island, return `0`.

## Examples

**Example 1:**
```
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
```

## Approach

### Method 1: DFS (Recommended)
1. Traverse grid and find land cells
2. Use DFS to calculate area of each island
3. Keep track of maximum area found
4. Mark visited cells to avoid revisiting

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(m*n) - Recursion stack in worst case

### Method 2: BFS
1. Use queue for BFS traversal
2. Calculate area during BFS
3. Track maximum area

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(min(m,n)) - Queue size

## Algorithm

```
1. For each cell in grid:
   a. If cell is land and not visited:
      - Calculate area using DFS
      - Update maximum area
2. DFS function:
   a. Mark current cell as visited
   b. Return 1 + sum of all 4 directions
```

## Key Insights

- **DFS**: Explore entire island and count cells
- **Area Calculation**: Count cells in each island
- **Maximum Tracking**: Keep track of largest area
- **Visited Marking**: Avoid revisiting cells

## Alternative Approaches

1. **BFS**: Use queue for traversal
2. **Union Find**: Use disjoint set data structure
3. **Iterative**: Use stack for DFS

## Edge Cases

- Empty grid: Return 0
- All water: Return 0
- All land: Return total cells
- Single cell: Return 1

## Applications

- Image processing
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **DFS**: Most intuitive approach
- **In-place**: Mark visited in original grid
- **Single Pass**: O(m*n) time complexity
- **Memory Efficient**: O(1) extra space
