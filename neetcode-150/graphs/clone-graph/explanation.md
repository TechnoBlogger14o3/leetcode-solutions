# Clone Graph

## Problem Statement

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (`int`) and a list (`List[Node]`) of its neighbors.

## Examples

**Example 1:**
```
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
```

## Approach

### Method 1: DFS with HashMap (Recommended)
1. Use HashMap to store original -> cloned node mapping
2. Use DFS to traverse original graph
3. Create cloned nodes and their neighbors recursively
4. Return cloned node

**Time Complexity:** O(n) - Visit each node once
**Space Complexity:** O(n) - HashMap and recursion stack

### Method 2: BFS with HashMap
1. Use queue for BFS traversal
2. Use HashMap for node mapping
3. Create cloned nodes level by level

**Time Complexity:** O(n) - Visit each node once
**Space Complexity:** O(n) - HashMap and queue

## Algorithm

```
1. Initialize HashMap for node mapping
2. DFS function:
   a. If node already cloned: return cloned node
   b. Create new cloned node
   c. Add to HashMap
   d. Recursively clone all neighbors
   e. Return cloned node
```

## Key Insights

- **HashMap**: Store original -> cloned mapping
- **DFS**: Recursively clone neighbors
- **Cycle Handling**: Use HashMap to avoid infinite recursion
- **Deep Copy**: Create completely new nodes

## Alternative Approaches

1. **BFS**: Use queue for traversal
2. **Iterative**: Use stack for DFS
3. **Two Pass**: First create nodes, then connect

## Edge Cases

- Empty graph: Return null
- Single node: Return cloned node
- Self-loop: Handle appropriately
- Multiple cycles: Handle appropriately

## Applications

- Graph algorithms
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **DFS**: Most intuitive approach
- **HashMap**: Efficient cycle detection
- **Single Pass**: O(n) time complexity
- **Memory Efficient**: O(n) space complexity
