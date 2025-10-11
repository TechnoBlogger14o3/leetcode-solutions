# Surrounded Regions

## Problem Statement

Given an `m x n` matrix `board` containing `'X'` and `'O'`, capture all regions that are 4-directionally surrounded by `'X'`.

A region is captured by flipping all `'O'`s into `'X'`s in that surrounded region.

## Examples

**Example 1:**
```
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
```

## Approach

### Method 1: DFS from Boundaries (Recommended)
1. Start DFS from boundary cells with 'O'
2. Mark all 'O's connected to boundaries as 'T'
3. Convert remaining 'O's to 'X'
4. Convert 'T's back to 'O'

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(m*n) - Recursion stack in worst case

### Method 2: BFS from Boundaries
1. Use queue for BFS from boundary cells
2. Mark connected 'O's as 'T'
3. Convert remaining 'O's to 'X'
4. Convert 'T's back to 'O'

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(min(m,n)) - Queue size

## Algorithm

```
1. DFS from all boundary cells with 'O'
2. Mark connected 'O's as 'T' (temporary)
3. Convert all remaining 'O's to 'X'
4. Convert all 'T's back to 'O'
```

## Key Insights

- **Boundary Start**: Start from edges
- **Temporary Marking**: Use 'T' to mark safe 'O's
- **Two Pass**: First mark safe, then convert
- **Reverse Thinking**: Find unsafe regions

## Alternative Approaches

1. **BFS**: Use queue for traversal
2. **Union Find**: Use disjoint set data structure
3. **Iterative**: Use stack for DFS

## Edge Cases

- Empty board: Return empty board
- All 'X': Return same board
- All 'O': Return all 'X'
- Single cell: Handle appropriately

## Applications

- Image processing
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **DFS**: Most intuitive approach
- **Boundary Start**: Start from edges
- **Single Pass**: O(m*n) time complexity
- **Memory Efficient**: O(1) extra space
