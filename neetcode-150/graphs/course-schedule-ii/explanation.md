# Course Schedule II

## Problem Statement

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you must take course `bi` first if you want to take course `ai`.

- For example, the pair `[0, 1]`, indicates that to take course `0` you have to first take course `1`.

Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

## Examples

**Example 1:**
```
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
```

## Approach

### Method 1: Topological Sort with BFS (Recommended)
1. Build adjacency list and calculate in-degree
2. Use BFS starting from vertices with in-degree 0
3. Add vertices to result as they are processed
4. Return result or empty array if cycle detected

**Time Complexity:** O(V + E) - V vertices, E edges
**Space Complexity:** O(V + E) - Adjacency list and queue

### Method 2: Topological Sort with DFS
1. Build adjacency list
2. Use DFS to find topological order
3. Add vertices to result in reverse order
4. Return result or empty array if cycle detected

**Time Complexity:** O(V + E) - V vertices, E edges
**Space Complexity:** O(V + E) - Adjacency list and recursion stack

## Algorithm

```
1. Build adjacency list from prerequisites
2. Calculate in-degree for each vertex
3. BFS approach:
   a. Start from vertices with in-degree 0
   b. Add vertices to result as processed
   c. Update in-degrees of neighbors
4. Return result if all vertices processed
```

## Key Insights

- **Topological Order**: Order courses such that prerequisites come first
- **In-degree**: Count incoming edges for BFS approach
- **Cycle Detection**: Return empty array if cycle exists
- **Result Building**: Add vertices to result as processed

## Alternative Approaches

1. **DFS**: Use DFS for topological sort
2. **Iterative**: Use iterative DFS
3. **Union Find**: Use disjoint set data structure

## Edge Cases

- No prerequisites: Return any order
- Single course: Return [0]
- Self-loop: Return empty array
- Multiple cycles: Return empty array

## Applications

- Course scheduling
- Task scheduling
- Dependency resolution
- Algorithm design patterns
- Interview preparation

## Optimization Opportunities

- **BFS**: Most intuitive approach
- **In-degree**: Efficient cycle detection
- **Single Pass**: O(V + E) time complexity
- **Memory Efficient**: O(V + E) space complexity
