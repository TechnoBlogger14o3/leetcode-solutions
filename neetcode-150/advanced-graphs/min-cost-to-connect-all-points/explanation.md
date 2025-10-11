# Min Cost to Connect All Points

## Problem Statement

You are given an array `points` representing integer coordinates of some points on a 2D-plane, where `points[i] = [xi, yi]`.

The cost of connecting two points `[xi, yi]` and `[xj, yj]` is the manhattan distance between them: `|xi - xj| + |yi - yj|`, where `|val|` denotes the absolute value of `val`.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

## Examples

**Example 1:**
```
Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
```

## Approach

### Method 1: Kruskal's Algorithm (Recommended)
1. Calculate all edge weights (Manhattan distances)
2. Sort edges by weight
3. Use Union Find to detect cycles
4. Add edges until all points connected
5. Most efficient for this problem

**Time Complexity:** O(n² log n) - n² edges, sorting
**Space Complexity:** O(n²) - Edge list

### Method 2: Prim's Algorithm
1. Start from any point
2. Use min-heap to find minimum weight edge
3. Add edges greedily
4. Less efficient than Kruskal's

**Time Complexity:** O(n² log n) - n² edges, heap operations
**Space Complexity:** O(n²) - Adjacency list

## Algorithm

```
1. Calculate Manhattan distance between all point pairs
2. Sort edges by weight
3. Initialize Union Find with n points
4. For each edge in sorted order:
   a. If adding edge doesn't create cycle: add to MST
   b. If MST has n-1 edges: return total cost
```

## Key Insights

- **Minimum Spanning Tree**: Connect all points with minimum cost
- **Manhattan Distance**: |x1-x2| + |y1-y2|
- **Kruskal's Algorithm**: Sort edges, use Union Find
- **Cycle Detection**: Use Union Find to avoid cycles

## Alternative Approaches

1. **Prim's Algorithm**: Use min-heap for greedy selection
2. **Boruvka's Algorithm**: Use Union Find with edge contraction
3. **Brute Force**: Try all possible spanning trees

## Edge Cases

- Single point: Return 0
- Two points: Return Manhattan distance
- Collinear points: Handle appropriately
- Duplicate points: Handle appropriately

## Applications

- Network design
- Graph algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Kruskal's Algorithm**: Most efficient approach
- **Union Find**: Efficient cycle detection
- **Edge Sorting**: O(n² log n) sorting
- **Memory Efficient**: O(n²) space complexity
