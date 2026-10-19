# Find Target Indices After Sorting Array (Easy)

**Problem ID:** 2089  
**Date:** 2026-10-19  
**Link:** https://leetcode.com/problems/find-target-indices-after-sorting-array/

## Approach

To solve the problem of finding target indices after sorting an array, we can follow a straightforward approach:

### Main Idea
1. **Sorting the Array**: First, we need to sort the input array `nums` in non-decreasing order. This will allow us to easily identify the positions of the target element.
  
2. **Finding Target Indices**: After sorting, we will iterate through the sorted array to collect the indices where the elements equal the given `target`.

### Steps
1. **Sort the Array**: Use a sorting algorithm (like Timsort, which is used in Python's built-in sort) to sort the array. This will rearrange the elements in non-decreasing order.

2. **Collect Indices**: Initialize an empty list to store the indices. As we traverse the sorted array, whenever we find an element that matches the `target`, we append its index (from the sorted array) to our list.

3. **Return Result**: Finally, return the list of indices. If no indices are found, return an empty list.

### Data Structures
- **List**: We will use a list to store the indices of the target elements found in the sorted array.

### Complexity
- **Time Complexity**: The sorting operation takes \(O(n \log n)\), where \(n\) is the length of the array. The subsequent traversal to find the target indices takes \(O(n)\). Thus, the overall time complexity is \(O(n \log n)\).
  
- **Space Complexity**: The space complexity is \(O(n)\) due to the storage of the sorted array and the list of indices.

This approach is efficient given the constraints, and it ensures that we return the indices in sorted order as required by the problem statement.
