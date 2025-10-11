# Graph Valid Tree

## Problem Statement

Given `n` nodes labeled from `0` to `n - 1` and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

## Examples

**Example 1:**
```
Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: false
```

## Approach

### Method 1: Union Find (Recommended)
1. Use Union Find to detect cycles
2. Check if all nodes are connected
3. Tree has n-1 edges and no cycles
4. Most efficient for this problem

**Time Complexity:** O(n + m) - n nodes, m edges
**Space Complexity:** O(n) - Union Find data structure

### Method 2: DFS
1. Build adjacency list
2. Use DFS to detect cycles
3. Check if all nodes are visited
4. Less efficient than Union Find

**Time Complexity:** O(n + m) - n nodes, m edges
**Space Complexity:** O(n + m) - Adjacency list

## Algorithm

```
1. Check if number of edges equals n-1
2. Initialize Union Find with n nodes
3. For each edge:
   a. If adding edge creates cycle: return false
   b. Otherwise: union the two nodes
4. Check if all nodes are connected
```

## Key Insights

- **Tree Properties**: n-1 edges, no cycles, connected
- **Cycle Detection**: Use Union Find to detect cycles
- **Connectivity**: Check if all nodes are connected
- **Edge Count**: Tree must have exactly n-1 edges

## Alternative Approaches

1. **DFS**: Use DFS for cycle detection
2. **BFS**: Use BFS for cycle detection
3. **Iterative**: Use iterative approach

## Edge Cases

- No edges: Return false (not connected)
- Single node: Return true
- Self-loop: Return false
- Multiple cycles: Return false

## Applications

- Graph algorithms
- Tree validation
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Union Find**: Most efficient approach
- **Cycle Detection**: O(n + m) time complexity
- **Single Pass**: Process edges once
- **Memory Efficient**: O(n) space complexity
