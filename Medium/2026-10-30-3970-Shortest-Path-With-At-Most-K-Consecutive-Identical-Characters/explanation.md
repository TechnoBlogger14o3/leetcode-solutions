# Shortest Path With At Most K Consecutive Identical Characters (Medium)

**Problem ID:** 3970  
**Date:** 2026-10-30  
**Link:** https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/

## Approach

To solve the problem of finding the shortest path from node 0 to node n-1 in a directed weighted graph while ensuring that the concatenation of labels along the path contains at most k consecutive identical characters, we can employ a modified Dijkstra's algorithm. Here’s the structured approach:

### Main Idea
The goal is to traverse the graph while keeping track of the cumulative edge weights and the count of consecutive identical characters in the labels. The challenge lies in ensuring that we do not exceed the limit of k consecutive identical characters while exploring paths.

### Approach
1. **Graph Representation**: Represent the graph as an adjacency list from the given edges, where each entry contains the destination node and the corresponding edge weight.

2. **State Representation**: Use a priority queue (min-heap) to manage the states during traversal. Each state can be represented as a tuple containing:
   - Current node
   - Total weight of the path taken to reach this node
   - Count of consecutive identical characters
   - The last character encountered

3. **Initialization**: Start from node 0 with an initial weight of 0, a consecutive character count of 0, and the last character as `None`.

4. **Traversal**:
   - Use a priority queue to explore the least costly paths first.
   - For each node, check all possible outgoing edges.
   - Update the state based on whether the next node's label is the same as the last character:
     - If it is the same, increment the consecutive count.
     - If it is different, reset the consecutive count to 1.
   - If the consecutive count exceeds k, skip that path.
   - If a valid state is reached (i.e., not exceeding k consecutive characters), push it onto the priority queue.

5. **Termination**: The process continues until the priority queue is empty or the destination node n-1 is reached. If n-1 is reached, return the total weight of the path. If the queue is exhausted and n-1 is not reached, return -1.

### Data Structures
- **Priority Queue**: To efficiently retrieve the next state with the minimum weight.
- **Adjacency List**: To represent the graph for quick access to neighbors.
- **Visited Set**: To keep track of visited states, ensuring that we do not process the same node with the same or worse conditions repeatedly.

### Complexity
- **Time Complexity**: O(E log E) where E is the number of edges. Each edge is processed at most once, and the priority queue operations take logarithmic time relative to the number of edges.
- **Space Complexity**: O(E + N) where N is the number of nodes, accounting for the graph representation and the priority queue.

This approach efficiently finds the shortest path while adhering to the constraints on consecutive identical characters, leveraging graph traversal techniques and priority queue management.
