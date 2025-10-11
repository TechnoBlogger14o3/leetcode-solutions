# Reconstruct Itinerary

## Problem Statement

You are given a list of airline tickets where `tickets[i] = [fromi, toi]` represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from `"JFK"`, thus, the itinerary must begin with `"JFK"`. If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

- For example, the itinerary `["JFK", "LGA"]` has a smaller lexical order than `["JFK", "LGB"]`.

You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

## Examples

**Example 1:**
```
Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
```

## Approach

### Method 1: Hierholzer's Algorithm (Recommended)
1. Build adjacency list with sorted destinations
2. Use DFS to traverse the graph
3. Remove edges as they are used
4. Add vertices to result in reverse order
5. Most efficient for Eulerian path

**Time Complexity:** O(E log E) - E edges, sorting
**Space Complexity:** O(E) - Adjacency list

### Method 2: DFS with Backtracking
1. Build adjacency list
2. Use DFS with backtracking
3. Try all possible paths
4. Return first valid path

**Time Complexity:** O(E!) - Exponential worst case
**Space Complexity:** O(E) - Recursion stack

## Algorithm

```
1. Build adjacency list with sorted destinations
2. DFS from "JFK":
   a. While current vertex has neighbors:
      - Remove first neighbor
      - DFS to that neighbor
   b. Add current vertex to result
3. Reverse result to get correct order
```

## Key Insights

- **Eulerian Path**: Use all edges exactly once
- **Lexicographical Order**: Sort destinations for each airport
- **Hierholzer's Algorithm**: Efficient for Eulerian paths
- **Reverse Order**: Add vertices in reverse DFS order

## Alternative Approaches

1. **Backtracking**: Use DFS with backtracking
2. **Iterative**: Use stack for iterative DFS
3. **Greedy**: Always choose lexicographically smallest

## Edge Cases

- Single ticket: Return [from, to]
- Multiple tickets from same airport: Choose lexicographically smallest
- Cycle in graph: Handle appropriately
- No valid path: Should not occur per problem statement

## Applications

- Route planning
- Graph algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Hierholzer's Algorithm**: Most efficient approach
- **Sorted Adjacency**: O(E log E) sorting
- **Single Pass**: O(E) traversal
- **Memory Efficient**: O(E) space complexity
