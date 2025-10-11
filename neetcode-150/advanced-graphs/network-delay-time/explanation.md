# Network Delay Time

## Problem Statement

You are given a network of `n` nodes, labeled from `1` to `n`. You are also given `times`, a list of travel times as directed edges `times[i] = (ui, vi, wi)`, where `ui` is the source node, `vi` is the target node, and `wi` is the time it takes for a signal to travel from source to target.

We will send a signal from a given node `k`. Return the minimum time it takes for the signal to reach all nodes. If it is impossible for the signal to reach all nodes, return `-1`.

## Examples

**Example 1:**
```
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
```

## Approach

### Method 1: Dijkstra's Algorithm (Recommended)
1. Build adjacency list from times
2. Use Dijkstra's algorithm to find shortest paths
3. Use min-heap for efficient node selection
4. Return maximum distance or -1 if unreachable

**Time Complexity:** O((V + E) log V) - V vertices, E edges
**Space Complexity:** O(V + E) - Adjacency list and heap

### Method 2: Bellman-Ford Algorithm
1. Use Bellman-Ford for shortest paths
2. Handle negative weights
3. Less efficient than Dijkstra's

**Time Complexity:** O(VE) - V vertices, E edges
**Space Complexity:** O(V) - Distance array

## Algorithm

```
1. Build adjacency list from times
2. Initialize distances to infinity
3. Set distance of source node k to 0
4. Use min-heap for Dijkstra's:
   a. Extract minimum distance node
   b. Relax all outgoing edges
   c. Update distances if shorter path found
5. Return maximum distance or -1
```

## Key Insights

- **Shortest Path**: Use Dijkstra's algorithm
- **Min-Heap**: Efficiently select minimum distance node
- **Relaxation**: Update distances if shorter path found
- **Maximum Distance**: Signal reaches all nodes when max distance is found

## Alternative Approaches

1. **Bellman-Ford**: Use Bellman-Ford algorithm
2. **Floyd-Warshall**: Use all-pairs shortest path
3. **BFS**: Use BFS for unweighted graphs

## Edge Cases

- Single node: Return 0
- No edges: Return -1
- Unreachable nodes: Return -1
- Self-loops: Handle appropriately

## Applications

- Network routing
- Graph algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Dijkstra's Algorithm**: Most efficient approach
- **Min-Heap**: O(log V) operations
- **Single Source**: O((V + E) log V) time complexity
- **Memory Efficient**: O(V + E) space complexity
