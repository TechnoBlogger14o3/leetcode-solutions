# Minimize Hamming Distance After Swap Operations (Medium)

**Problem ID:** 1722  
**Date:** 2026-04-21  
**Link:** https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/

## Approach

To solve the problem of minimizing the Hamming distance between the `source` and `target` arrays after performing allowed swap operations, we can approach it using graph theory and union-find (disjoint set union, DSU) data structures.

### Main Idea:
The core idea is to treat the allowed swaps as edges in a graph where each index of the `source` array represents a node. If two indices can be swapped, they form a connected component in this graph. Within each connected component, we can rearrange the elements of `source` freely. Thus, the goal becomes to determine how many elements in each connected component can match their corresponding elements in `target`.

### Steps:
1. **Graph Construction**: 
   - Use the `allowedSwaps` to build a graph where each index is a node and each swap operation represents an undirected edge between two nodes.

2. **Find Connected Components**:
   - Utilize the union-find data structure to identify connected components in the graph. Each connected component will allow us to group indices that can be freely rearranged.

3. **Count Matches**:
   - For each connected component, gather the elements from `source` and their corresponding indices in `target`. 
   - Count the occurrences of each value in both `source` and `target` for the indices in the component.
   - The number of matches (elements that can be made equal) is determined by taking the minimum count of each unique element from both arrays.

4. **Calculate Hamming Distance**:
   - For each component, the Hamming distance can be calculated as the total number of indices in the component minus the number of matches. 
   - Sum the Hamming distances from all components to get the final result.

### Data Structures:
- **Union-Find (DSU)**: To efficiently manage and find connected components.
- **Hash Map**: To count occurrences of elements in `source` and `target` for each component.

### Complexity:
- **Time Complexity**: O(n + m), where n is the length of the arrays and m is the number of allowed swaps. The union-find operations are nearly constant time due to path compression and union by rank.
- **Space Complexity**: O(n) for the union-find structure and additional space for counting elements in each component.

By following this approach, we can efficiently minimize the Hamming distance between the `source` and `target` arrays after performing the allowed swap operations.
