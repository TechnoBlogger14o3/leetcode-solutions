# Closest Equal Element Queries (Medium)

**Problem ID:** 3488  
**Date:** 2026-04-16  
**Link:** https://leetcode.com/problems/closest-equal-element-queries/

## Approach

To solve the problem of finding the minimum distance between a queried index in a circular array and any other index with the same value, we can adopt a systematic approach that leverages efficient data structures and algorithms.

### Main Idea:
The main idea is to preprocess the input array `nums` to store the indices of each unique value. This allows us to quickly retrieve all positions of a queried value and compute the minimum distance in constant time.

### Steps to Approach:

1. **Index Mapping**:
   - Create a dictionary (or hashmap) where the keys are the unique values from `nums`, and the values are lists of indices where each unique value occurs. This will help us quickly access all indices for any queried value.

2. **Circular Distance Calculation**:
   - For each query, retrieve the value at the queried index and check if it exists in the dictionary.
   - If the value is not present, append `-1` to the results.
   - If the value exists, compute the distances to all other indices where this value occurs. Since the array is circular, for each index `j`, the distance can be calculated as:
     - `distance = abs(i - j)` for linear distance, and
     - `circular_distance = len(nums) - distance` for the wrap-around distance.
   - The effective distance is the minimum of these two values.

3. **Efficient Calculation**:
   - Instead of iterating through all indices for each query, use the pre-stored indices to calculate the minimum distance efficiently. This can be done in linear time relative to the number of occurrences of the queried value.

### Data Structures:
- A dictionary to map values to their indices.
- An array to store the results for each query.

### Complexity:
- **Time Complexity**: 
  - Preprocessing the array `nums` takes O(n), where n is the length of `nums`.
  - Each query can be processed in O(k), where k is the number of occurrences of the queried value. In the worst case, if all values are the same, this could lead to O(n) for each query, but typically, k will be much smaller.
- **Space Complexity**: O(n) for storing the indices in the dictionary.

This approach ensures that we efficiently handle multiple queries against the circular array while minimizing redundant calculations, making it suitable for the given constraints.
