# Minimum Absolute Difference (Easy)

**Problem ID:** 1200  
**Date:** 2026-01-26  
**Link:** https://leetcode.com/problems/minimum-absolute-difference/

## Approach

To solve the problem of finding all pairs of elements with the minimum absolute difference in a given array of distinct integers, we can follow a systematic approach:

### Main Idea:
1. **Sorting**: The first step is to sort the array. This allows us to easily compute the absolute differences between adjacent elements, which will yield the minimum differences due to the properties of sorted arrays.
  
2. **Finding Minimum Difference**: After sorting, iterate through the array and calculate the absolute differences between consecutive pairs. Keep track of the minimum difference encountered during this iteration.

3. **Collecting Pairs**: In a second pass through the sorted array, collect all pairs of elements that have the absolute difference equal to the minimum difference found in the previous step.

### Data Structures:
- **Array**: The input is an array of integers, which will be sorted.
- **List of Pairs**: To store the resulting pairs that meet the criteria, we can use a list or an array of arrays.

### Complexity:
- **Time Complexity**: The sorting step takes \(O(n \log n)\), where \(n\) is the length of the array. The subsequent linear scans to find the minimum difference and to collect pairs both take \(O(n)\). Thus, the overall time complexity is \(O(n \log n)\).
  
- **Space Complexity**: The space complexity is \(O(n)\) in the worst case for storing the output pairs, but the sorting operation may also require additional space depending on the sorting algorithm used.

### Summary:
1. Sort the array.
2. Compute the minimum absolute difference by checking adjacent elements.
3. Collect and return all pairs that have this minimum difference, ensuring they are in ascending order.

This approach is efficient and leverages sorting to simplify the problem of finding pairs with minimum differences.
