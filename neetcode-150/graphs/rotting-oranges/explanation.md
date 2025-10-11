# Rotting Oranges

## Problem Statement

You are given an `m x n` grid where each cell can have one of three values:

- `0` representing an empty cell,
- `1` representing a fresh orange, or
- `2` representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return `-1`.

## Examples

**Example 1:**
```
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
```

## Approach

### Method 1: BFS (Recommended)
1. Use BFS to simulate the rotting process
2. Start with all rotten oranges in queue
3. Process level by level (minute by minute)
4. Return minutes or -1 if impossible

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(m*n) - Queue size in worst case

### Method 2: DFS
1. Use DFS to find rotting time
2. Less intuitive for this problem
3. More complex implementation

**Time Complexity:** O(m*n) - Visit each cell once
**Space Complexity:** O(m*n) - Recursion stack

## Algorithm

```
1. Add all rotten oranges to queue
2. BFS level by level:
   a. Process all oranges in current level
   b. Add newly rotten oranges to next level
   c. Increment minute counter
3. Check if all oranges are rotten
```

## Key Insights

- **BFS**: Simulate rotting process level by level
- **Level Processing**: Each level represents one minute
- **Fresh Count**: Track remaining fresh oranges
- **Impossible Case**: Return -1 if fresh oranges remain

## Alternative Approaches

1. **DFS**: Use DFS for rotting simulation
2. **Multi-source BFS**: Start from multiple sources
3. **Iterative**: Use iterative approach

## Edge Cases

- No fresh oranges: Return 0
- No rotten oranges: Return -1
- All rotten: Return 0
- Impossible to rot all: Return -1

## Applications

- Simulation problems
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **BFS**: Most intuitive approach
- **Level Processing**: Process level by level
- **Single Pass**: O(m*n) time complexity
- **Memory Efficient**: O(m*n) space complexity
