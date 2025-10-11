# Cheapest Flights Within K Stops

## Problem Statement

There are `n` cities connected by some number of flights. You are given an array `flights` where `flights[i] = [fromi, toi, pricei]` indicates that there is a flight from city `fromi` to city `toi` with cost `pricei`.

You are also given three integers `src`, `dst`, and `k`, return the cheapest price from `src` to `dst` with at most `k` stops. If there is no such route, return `-1`.

## Examples

**Example 1:**
```
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
```

## Approach

### Method 1: Modified Dijkstra's Algorithm (Recommended)
1. Use Dijkstra's with stops constraint
2. Track (city, stops) pairs in priority queue
3. Stop when destination reached or stops exceeded
4. Most efficient for this problem

**Time Complexity:** O(E + V log V) - E edges, V vertices
**Space Complexity:** O(V) - Priority queue and distances

### Method 2: Bellman-Ford Algorithm
1. Use Bellman-Ford with stops constraint
2. Relax edges k+1 times
3. Less efficient than Dijkstra's

**Time Complexity:** O(k * E) - k stops, E edges
**Space Complexity:** O(V) - Distance arrays

## Algorithm

```
1. Build adjacency list from flights
2. Use priority queue with (cost, city, stops)
3. Dijkstra's with stops constraint:
   a. Extract minimum cost (city, stops)
   b. If city is destination: return cost
   c. If stops > k: skip
   d. Relax all outgoing edges
4. Return -1 if not found
```

## Key Insights

- **Modified Dijkstra's**: Add stops constraint to Dijkstra's
- **Priority Queue**: Use (cost, city, stops) tuples
- **Stops Constraint**: Stop when stops > k
- **Early Termination**: Return when destination reached

## Alternative Approaches

1. **Bellman-Ford**: Use Bellman-Ford with stops
2. **BFS**: Use BFS with cost tracking
3. **DFS**: Use DFS with memoization

## Edge Cases

- No flights: Return -1
- Direct flight: Return flight cost
- No path within k stops: Return -1
- Same source and destination: Return 0

## Applications

- Flight booking systems
- Graph algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Modified Dijkstra's**: Most efficient approach
- **Priority Queue**: O(log V) operations
- **Early Termination**: Stop when destination reached
- **Memory Efficient**: O(V) space complexity
