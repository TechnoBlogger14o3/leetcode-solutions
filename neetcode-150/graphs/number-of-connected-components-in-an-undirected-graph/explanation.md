# Number of Connected Components in an Undirected Graph

## Problem Statement

You have a graph of `n` nodes labeled from `0` to `n - 1`. You are given an integer `n` and an array `edges` where `edges[i] = [ai, bi]` indicates that there is an undirected edge between nodes `ai` and `bi` in the graph.

Return the number of connected components in the graph.

## Examples

**Example 1:**
```
Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
```

## Approach

### Method 1: Union Find (Recommended)
1. Use Union Find to group connected nodes
2. Count number of distinct roots
3. Most efficient for this problem

**Time Complexity:** O(n + m) - n nodes, m edges
**Space Complexity:** O(n) - Union Find data structure

### Method 2: DFS
1. Build adjacency list
2. Use DFS to visit all connected nodes
3. Count number of DFS calls
4. Less efficient than Union Find

**Time Complexity:** O(n + m) - n nodes, m edges
**Space Complexity:** O(n + m) - Adjacency list

## Algorithm

```
1. Initialize Union Find with n nodes
2. For each edge: union the two nodes
3. Count number of distinct roots
4. Return count
```

## Key Insights

- **Connected Components**: Groups of nodes connected by edges
- **Union Find**: Efficiently group connected nodes
- **Root Counting**: Count distinct roots to get component count
- **Undirected Graph**: Edges are bidirectional

## Alternative Approaches

1. **DFS**: Use DFS to visit connected components
2. **BFS**: Use BFS to visit connected components
3. **Iterative**: Use iterative approach

## Edge Cases

- No edges: Return n (each node is separate component)
- Single edge: Return n-1
- All connected: Return 1
- Empty graph: Return 0

## Applications

- Graph algorithms
- Network analysis
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Union Find**: Most efficient approach
- **Root Counting**: O(n) time complexity
- **Single Pass**: Process edges once
- **Memory Efficient**: O(n) space complexity
