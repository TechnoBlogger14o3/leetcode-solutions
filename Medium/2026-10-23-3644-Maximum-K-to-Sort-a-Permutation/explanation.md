# Maximum K to Sort a Permutation (Medium)

**Problem ID:** 3644  
**Date:** 2026-10-23  
**Link:** https://leetcode.com/problems/maximum-k-to-sort-a-permutation/

## Approach

To solve the problem of finding the maximum value of \( k \) such that a given permutation can be sorted using swaps defined by the condition \( \text{nums}[i] \text{ AND } \text{nums}[j] = k \), we can follow a systematic approach:

### Problem Breakdown
1. **Understanding the Swap Condition**: The condition \( \text{nums}[i] \text{ AND } \text{nums}[j] = k \) implies that both numbers must have certain bits set in common. This means that for each potential \( k \), we need to identify pairs of indices that can be swapped based on this condition.

2. **Identifying Maximum \( k \)**: The goal is to maximize \( k \) while ensuring that all elements can be rearranged to form a sorted array. If \( k \) is too high, fewer pairs will satisfy the swap condition, potentially preventing sorting.

### Approach
1. **Initial Check for Sorted Array**: First, check if the array is already sorted. If it is, return \( 0 \) immediately.

2. **Iterate Over Possible Values of \( k \)**: We can iterate through possible values of \( k \) from the maximum possible value down to \( 0 \). This is efficient because if we find a valid \( k \), we can stop further checks.

3. **Graph Representation**: For each \( k \):
   - Construct a graph where each index in the array is a node, and an edge exists between nodes \( i \) and \( j \) if \( \text{nums}[i] \text{ AND } \text{nums}[j] = k \).
   - This graph will help us identify connected components, which represent groups of indices that can be rearranged among themselves.

4. **Connected Components**: Use a graph traversal technique (like DFS or BFS) to find all connected components in the graph. For each component, check if the numbers can be sorted within that component. If all components can be sorted, then \( k \) is valid.

5. **Return the Maximum \( k \)**: The first valid \( k \) found during the iteration from maximum to minimum is the answer.

### Data Structures
- **Graph Representation**: An adjacency list or matrix to represent the connections based on the AND condition.
- **Visited Array**: To keep track of which indices have been processed during the component search.

### Complexity
- **Time Complexity**: The overall complexity is \( O(n \cdot \log(n)) \) in the worst case, where \( n \) is the length of the input array. This accounts for iterating through potential \( k \) values and performing graph traversals.
- **Space Complexity**: \( O(n) \) for storing the graph and visited states.

This structured approach ensures that we efficiently explore the conditions under which the array can be sorted while maximizing \( k \).
