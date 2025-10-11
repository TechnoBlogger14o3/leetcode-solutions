# Course Schedule

## Problem Statement

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you must take course `bi` first if you want to take course `ai`.

- For example, the pair `[0, 1]`, indicates that to take course `0` you have to first take course `1`.

Return `true` if you can finish all courses. Otherwise, return `false`.

## Examples

**Example 1:**
```
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
```

## Approach

### Method 1: Topological Sort with DFS (Recommended)
1. Build adjacency list from prerequisites
2. Use DFS to detect cycles
3. Use three states: unvisited, visiting, visited
4. Return false if cycle detected

**Time Complexity:** O(V + E) - V vertices, E edges
**Space Complexity:** O(V + E) - Adjacency list and recursion stack

### Method 2: Topological Sort with BFS (Kahn's Algorithm)
1. Calculate in-degree for each vertex
2. Use BFS starting from vertices with in-degree 0
3. Remove vertices and update in-degrees
4. Return true if all vertices processed

**Time Complexity:** O(V + E) - V vertices, E edges
**Space Complexity:** O(V + E) - Adjacency list and queue

## Algorithm

```
1. Build adjacency list from prerequisites
2. DFS approach:
   a. Use three states: 0 (unvisited), 1 (visiting), 2 (visited)
   b. If neighbor is visiting: cycle detected
   c. If neighbor is unvisited: continue DFS
3. BFS approach:
   a. Calculate in-degree for each vertex
   b. Start from vertices with in-degree 0
   c. Remove vertices and update in-degrees
```

## Key Insights

- **Cycle Detection**: Course schedule is impossible if cycle exists
- **Topological Sort**: Order courses such that prerequisites come first
- **DFS States**: Use three states for cycle detection
- **In-degree**: Count incoming edges for BFS approach

## Alternative Approaches

1. **BFS**: Use Kahn's algorithm
2. **Union Find**: Use disjoint set data structure
3. **Iterative**: Use iterative DFS

## Edge Cases

- No prerequisites: Return true
- Single course: Return true
- Self-loop: Return false
- Multiple cycles: Return false

## Applications

- Course scheduling
- Task scheduling
- Dependency resolution
- Algorithm design patterns
- Interview preparation

## Optimization Opportunities

- **DFS**: Most intuitive approach
- **Cycle Detection**: Use three states
- **Single Pass**: O(V + E) time complexity
- **Memory Efficient**: O(V + E) space complexity
