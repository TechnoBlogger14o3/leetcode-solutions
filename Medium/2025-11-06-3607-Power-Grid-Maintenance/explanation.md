# Power Grid Maintenance (Medium)

**Problem ID:** 3607  
**Date:** 2025-11-06  
**Link:** https://leetcode.com/problems/power-grid-maintenance/

## Approach

To solve the "Power Grid Maintenance" problem, we can follow these steps:

### Approach:

1. **Graph Representation**:
   - Represent the power stations and their connections as an undirected graph using an adjacency list. This allows us to efficiently traverse the connections between stations.

2. **Connected Components**:
   - Use a graph traversal technique (like Depth-First Search or Breadth-First Search) to identify connected components in the graph. Each connected component represents a power grid. Store the stations in each component in a list, and maintain a mapping from each station to its component.

3. **Data Structures**:
   - Use a list to hold the operational status of each station (online/offline).
   - Maintain a minimum heap (or a sorted list) for each connected component that tracks the operational stations. This allows us to quickly retrieve the station with the smallest ID when needed.

4. **Processing Queries**:
   - For each query:
     - If it's of type `[1, x]` (maintenance check):
       - Check if station `x` is online. If it is, return `x`.
       - If it's offline, retrieve the smallest operational station from the corresponding component using the minimum heap. If no operational station exists, return -1.
     - If it's of type `[2, x]` (station goes offline):
       - Mark station `x` as offline and remove it from the minimum heap of its component. This may involve re-balancing the heap to maintain its properties.

5. **Efficiency**:
   - The initial setup (building the graph and identifying components) takes O(c + n) time, where `c` is the number of stations and `n` is the number of connections.
   - Each query can be processed in O(log k) time, where `k` is the number of operational stations in the component. Given the constraints, this approach is efficient and should handle the upper limits comfortably.

### Complexity:
- **Time Complexity**: O(c + n + q log k), where `q` is the number of queries and `k` is the maximum number of operational stations in any component.
- **Space Complexity**: O(c + n) for storing the graph and operational status.

This structured approach ensures that we can efficiently handle the maintenance checks and updates to the operational status of the stations while maintaining the integrity of the power grid structure.
