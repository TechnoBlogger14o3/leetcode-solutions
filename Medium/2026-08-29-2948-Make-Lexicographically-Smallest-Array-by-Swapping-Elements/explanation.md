# Make Lexicographically Smallest Array by Swapping Elements (Medium)

**Problem ID:** 2948  
**Date:** 2026-08-29  
**Link:** https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/

## Approach

To solve the problem of making the array lexicographically smallest by swapping elements under a specified limit, we can utilize a graph-based approach combined with a union-find data structure (also known as disjoint-set).

### Main Idea:
The key insight is to treat the array elements as nodes in a graph, where an edge exists between two nodes if the absolute difference between their values is less than or equal to the given limit. By identifying connected components within this graph, we can determine which elements can be swapped freely among themselves. The goal is to sort each connected component independently to achieve the smallest possible arrangement.

### Steps to Approach:
1. **Graph Construction**: Iterate through the array and create edges between indices \(i\) and \(j\) whenever \(|nums[i] - nums[j]| \leq \text{limit}\). This can be efficiently managed using a union-find structure.

2. **Union-Find Data Structure**: Implement union-find to group indices into connected components. Each component will represent a subset of indices where elements can be swapped. The union operation will connect two indices, while the find operation will help identify the root of each component.

3. **Component Sorting**: Once all indices are grouped into components, extract the values corresponding to each component, sort them, and place them back into their respective indices in the original array. This ensures that within each component, the smallest possible arrangement is achieved.

4. **Final Assembly**: After sorting the values in each component, reconstruct the final array by placing the sorted values back into their original indices.

### Data Structures:
- **Union-Find**: To efficiently manage and merge connected components.
- **List or Array**: To store the values of each component for sorting.

### Complexity:
- **Time Complexity**: The overall complexity is \(O(n \log n)\) due to sorting the components, where \(n\) is the length of the input array. The union-find operations are nearly constant time, making them efficient for this problem.
- **Space Complexity**: The space complexity is \(O(n)\) for storing the union-find structure and the components.

This approach effectively leverages the properties of connected components to ensure that we can achieve the lexicographically smallest array by sorting within the constraints of the allowed swaps.
