# Walls and Gates

## Problem Statement

You are given an `m x n` grid `rooms` initialized with these three possible values:

- `-1` A wall or an obstacle.
- `0` A gate.
- `INF` Infinity means an empty room. We use the value `2^31 - 1 = 2147483647` to represent `INF` as you may assume that the distance to a gate is less than `2147483647`.

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should remain `INF`.

## Examples

**Example 1:**
```
Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
```

## Approach

### Method 1: BFS from Gates (Recommended)
1. Use BFS starting from all gates simultaneously
2. Update distances level by level
3. Skip walls and already visited rooms
4. More efficient than DFS

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(m*n) - Queue size in worst case

### Method 2: DFS from Gates
1. Use DFS starting from each gate
2. Update distances recursively
3. Less efficient than BFS

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(m*n) - Recursion stack

## Algorithm

```
1. Add all gates to queue
2. BFS level by level:
   a. Process all rooms in current level
   b. Update distances for adjacent rooms
   c. Add newly updated rooms to next level
```

## Key Insights

- **Multi-source BFS**: Start from all gates
- **Level Processing**: Each level represents distance + 1
- **Distance Update**: Update only if new distance is smaller
- **Wall Handling**: Skip walls during traversal

## Alternative Approaches

1. **DFS**: Use DFS from each gate
2. **Single-source BFS**: BFS from each gate separately
3. **Iterative**: Use iterative approach

## Edge Cases

- No gates: All rooms remain INF
- All walls: No updates needed
- Single gate: Update all reachable rooms
- No empty rooms: No updates needed

## Applications

- Pathfinding algorithms
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Multi-source BFS**: Most efficient approach
- **Level Processing**: Process level by level
- **Single Pass**: O(m*n) time complexity
- **Memory Efficient**: O(m*n) space complexity
