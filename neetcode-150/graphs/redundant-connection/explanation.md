# Redundant Connection

## Problem Statement

In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with `n` nodes labeled from `1` to `n`, with one additional edge added. The added edge has two different vertices chosen from `1` to `n`, and was not an edge that already existed.

The graph is represented as an array `edges` of length `n` where `edges[i] = [ai, bi]` indicates that there is an undirected edge between nodes `ai` and `bi` in the graph.

Return an edge that can be removed so that the resulting graph is a tree of `n` nodes. If there are multiple answers, return the answer that occurs last in the input.

## Examples

**Example 1:**
```
Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
```

## Approach

### Method 1: Union Find (Recommended)
1. Use Union Find to detect cycles
2. Process edges in order
3. If adding an edge creates a cycle, return that edge
4. Most efficient for this problem

**Time Complexity:** O(n) - n edges
**Space Complexity:** O(n) - Union Find data structure

### Method 2: DFS
1. Build adjacency list
2. Use DFS to detect cycles
3. Return the edge that creates cycle
4. Less efficient than Union Find

**Time Complexity:** O(n²) - n edges, each DFS O(n)
**Space Complexity:** O(n) - Adjacency list

## Algorithm

```
1. Initialize Union Find with n nodes
2. For each edge:
   a. If adding edge creates cycle: return edge
   b. Otherwise: union the two nodes
3. Return last edge (should not reach here)
```

## Key Insights

- **Cycle Detection**: Use Union Find to detect cycles
- **Edge Order**: Process edges in given order
- **Last Edge**: Return last edge that creates cycle
- **Tree Property**: Tree has n-1 edges, no cycles

## Alternative Approaches

1. **DFS**: Use DFS for cycle detection
2. **BFS**: Use BFS for cycle detection
3. **Iterative**: Use iterative approach

## Edge Cases

- Single edge: Return that edge
- Two edges: Return second edge
- All edges form cycle: Return last edge
- No cycle: Return last edge

## Applications

- Graph algorithms
- Cycle detection
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Union Find**: Most efficient approach
- **Cycle Detection**: O(n) time complexity
- **Single Pass**: Process edges once
- **Memory Efficient**: O(n) space complexity
