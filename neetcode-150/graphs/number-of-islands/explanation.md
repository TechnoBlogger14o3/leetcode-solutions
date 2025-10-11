# Number of Islands

## Problem Statement

Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

## Examples

**Example 1:**
```
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```

## Approach

### Method 1: DFS (Recommended)
1. Traverse grid and find land cells
2. Use DFS to mark entire island as visited
3. Count number of DFS calls (islands)
4. Mark visited cells to avoid revisiting

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(m*n) - Recursion stack in worst case

### Method 2: BFS
1. Use queue for BFS traversal
2. Mark visited cells
3. Count number of BFS calls

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(min(m,n)) - Queue size

## Algorithm

```
1. For each cell in grid:
   a. If cell is land and not visited:
      - Increment island count
      - DFS to mark entire island
2. DFS function:
   a. Mark current cell as visited
   b. Recursively visit all 4 directions
```

## Key Insights

- **DFS**: Explore entire island from one cell
- **Visited Marking**: Avoid revisiting cells
- **Four Directions**: Check up, down, left, right
- **Island Counting**: Count DFS calls

## Alternative Approaches

1. **BFS**: Use queue for traversal
2. **Union Find**: Use disjoint set data structure
3. **Iterative**: Use stack for DFS

## Edge Cases

- Empty grid: Return 0
- All water: Return 0
- All land: Return 1
- Single cell: Handle appropriately

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
