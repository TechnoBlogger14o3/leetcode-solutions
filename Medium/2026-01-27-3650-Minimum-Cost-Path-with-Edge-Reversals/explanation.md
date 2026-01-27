# Minimum Cost Path with Edge Reversals (Medium)

**Problem ID:** 3650  
**Date:** 2026-01-27  
**Link:** https://leetcode.com/problems/minimum-cost-path-with-edge-reversals/

## Approach

To solve the problem of finding the minimum cost path from node 0 to node n-1 in a directed, weighted graph with the option to reverse edges at certain costs, we can use a modified Dijkstra's algorithm. The main idea is to treat the graph as a weighted graph where we can also consider the cost of reversing edges.

### Approach:

1. **Graph Representation**: 
   - Represent the graph using an adjacency list to store the directed edges along with their weights. Additionally, maintain a reverse mapping for each edge to facilitate the edge reversal operation.

2. **Priority Queue**:
   - Use a priority queue (min-heap) to efficiently get the node with the current minimum cost during the traversal. Each entry in the priority queue will store a tuple of (current_cost, current_node, used_switch), where `used_switch` indicates whether the switch at the current node has been activated.

3. **Cost Calculation**:
   - Start from node 0 with a cost of 0 and mark it as not using the switch. As we explore each node:
     - Traverse outgoing edges normally, adding their weights to the current cost.
     - If we haven't used the switch at the current node, consider reversing each incoming edge to the current node, adding the cost of reversing (2 * weight of the edge) to the current cost.

4. **Visited Tracking**:
   - Maintain a 2D array or dictionary to track the minimum cost to reach each node with and without using the switch. This helps prevent unnecessary revisits and ensures we only explore paths that could lead to a lower cost.

5. **Termination**:
   - The algorithm continues until we either find the minimum cost to reach node n-1 or exhaust all possible paths. If we reach node n-1, return the cost; otherwise, return -1 if it's unreachable.

### Complexity:
- **Time Complexity**: O((E + V) log V), where E is the number of edges and V is the number of vertices. This accounts for processing each edge and vertex in the priority queue.
- **Space Complexity**: O(V + E) for storing the graph and the cost tracking structures.

This approach effectively balances the exploration of direct paths and the potential benefits of edge reversals, ensuring we find the optimal cost path from the start to the destination node.
