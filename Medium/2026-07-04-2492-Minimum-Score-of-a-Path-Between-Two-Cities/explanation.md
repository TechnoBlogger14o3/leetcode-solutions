# Minimum Score of a Path Between Two Cities (Medium)

**Problem ID:** 2492  
**Date:** 2026-07-04  
**Link:** https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/

## Approach

To solve the problem of finding the minimum score of a path between two cities in a graph represented by roads, we can utilize a graph traversal approach, specifically Depth-First Search (DFS) or Breadth-First Search (BFS). Here’s a concise explanation of the approach:

### Main Idea:
The goal is to determine the minimum distance of any road present in a path from city 1 to city n. The score of a path is defined as the minimum distance of the roads included in that path. Since we can traverse the graph multiple times and revisit cities, we can explore all paths from city 1 to city n while keeping track of the minimum road distance encountered.

### Data Structures:
1. **Graph Representation**: Use an adjacency list to represent the graph, where each city points to a list of tuples containing neighboring cities and the corresponding road distances.
2. **Visited Set**: To avoid revisiting cities unnecessarily during the traversal, maintain a set of visited cities.
3. **Queue (for BFS)**: If using BFS, a queue will help manage the cities to be explored next.

### Steps:
1. **Build the Graph**: Construct the adjacency list from the given roads data.
2. **Graph Traversal**: Start from city 1 and perform a BFS or DFS:
   - For each city, explore its neighbors and update the minimum road distance encountered on the path.
   - If reaching city n, compare the current minimum distance with the overall minimum and update if necessary.
3. **Return Result**: After completing the traversal, the recorded minimum distance will be the answer.

### Complexity:
- **Time Complexity**: O(V + E), where V is the number of cities (vertices) and E is the number of roads (edges). This is efficient given the constraints, as we visit each city and road at most once.
- **Space Complexity**: O(V + E) for the graph representation and O(V) for the visited set in the worst case.

This approach ensures that we efficiently find the minimum score of a path between the two cities while adhering to the problem's constraints.
