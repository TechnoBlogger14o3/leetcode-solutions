# Pacific Atlantic Water Flow

## Problem Statement

There is an `m x n` rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an `m x n` integer matrix `heights` where `heights[i][j]` represents the height above sea level of the cell at coordinate `(i, j)`.

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates `result` where `result[i] = [ri, ci]` denotes that rain water can flow from cell `(ri, ci)` to both the Pacific and Atlantic oceans.

## Examples

**Example 1:**
```
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
```

## Approach

### Method 1: DFS from Ocean Boundaries (Recommended)
1. Start DFS from Pacific Ocean boundaries (left and top)
2. Start DFS from Atlantic Ocean boundaries (right and bottom)
3. Find cells reachable from both oceans
4. Return intersection of both sets

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(m*n) - Visited arrays

### Method 2: BFS from Ocean Boundaries
1. Use queue for BFS from ocean boundaries
2. Mark reachable cells
3. Find intersection

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(m*n) - Visited arrays

## Algorithm

```
1. Initialize visited arrays for Pacific and Atlantic
2. DFS from Pacific boundaries (left and top edges)
3. DFS from Atlantic boundaries (right and bottom edges)
4. Find cells reachable from both oceans
5. Return intersection
```

## Key Insights

- **Ocean Boundaries**: Start from edges
- **Water Flow**: Higher to lower or equal height
- **Two Oceans**: Must reach both Pacific and Atlantic
- **Intersection**: Find cells reachable from both

## Alternative Approaches

1. **BFS**: Use queue for traversal
2. **Union Find**: Use disjoint set data structure
3. **Reverse Flow**: Start from ocean and flow inward

## Edge Cases

- Single cell: Return that cell
- All same height: Return all cells
- No flow: Return empty list
- Edge cells: Handle appropriately

## Applications

- Hydrology modeling
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **DFS**: Most intuitive approach
- **Boundary Start**: Start from ocean edges
- **Single Pass**: O(m*n) time complexity
- **Memory Efficient**: O(m*n) space complexity
