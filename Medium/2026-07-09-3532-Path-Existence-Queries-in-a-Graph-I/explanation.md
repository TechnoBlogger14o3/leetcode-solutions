# Path Existence Queries in a Graph I (Medium)

**Problem ID:** 3532  
**Date:** 2026-07-09  
**Link:** https://leetcode.com/problems/path-existence-queries-in-a-graph-i/

## Approach

To solve the problem of determining path existence in a graph defined by the absolute differences between nodes, we can leverage the properties of the sorted array `nums` and utilize a union-find (disjoint-set) data structure for efficient connectivity checks.

### Main Idea:
1. **Graph Representation**: The undirected graph is defined such that an edge exists between nodes `i` and `j` if the absolute difference `|nums[i] - nums[j]|` is less than or equal to `maxDiff`. Given that `nums` is sorted, if `nums[i]` and `nums[j]` are within `maxDiff`, then all intermediate nodes between `i` and `j` that also satisfy this condition can be connected.

2. **Union-Find Structure**: We can use a union-find data structure to dynamically connect nodes that can reach each other based on the defined edge condition. This allows us to efficiently group nodes into connected components.

3. **Two-Pointer Technique**: Since `nums` is sorted, we can use a two-pointer technique to iterate through the array and connect nodes. For each node `i`, we can find the maximum index `j` such that `nums[j] - nums[i] <= maxDiff`. We union all nodes from `i` to `j`, effectively connecting them.

4. **Answering Queries**: After processing the connections, each query can be answered in constant time by checking if the two nodes belong to the same connected component using the union-find structure.

### Data Structures:
- **Union-Find**: To manage and find connected components efficiently.
- **Array/List**: To store the parent and rank of each node for the union-find operations.

### Complexity:
- **Time Complexity**: 
  - The union-find operations (union and find) are nearly constant time, amortized to O(α(n)), where α is the inverse Ackermann function.
  - The two-pointer traversal through the `nums` array takes O(n) time.
  - Each query can be answered in O(1) time.
  - Overall complexity is O(n + q), where q is the number of queries.

- **Space Complexity**: O(n) for the union-find structure.

In summary, the approach efficiently connects nodes based on their values and answers path existence queries using a union-find structure, leveraging the sorted nature of the input array to minimize unnecessary comparisons.
