# Find Missing Elements (Easy)

**Problem ID:** 3731  
**Date:** 2026-08-04  
**Link:** https://leetcode.com/problems/find-missing-elements/

## Approach

To solve the problem of finding missing elements in a given array of unique integers, we can follow a systematic approach:

### Main Idea:
The goal is to identify all integers within the range defined by the minimum and maximum values of the input array that are not present in the array itself. We can achieve this by first determining the smallest and largest integers in the array, constructing a complete range of integers between these two bounds, and then identifying which integers from this range are missing.

### Steps:
1. **Identify Bounds**: Start by finding the minimum (`min_val`) and maximum (`max_val`) values in the input array `nums`. These values represent the boundaries of the complete range of integers we need to consider.

2. **Construct the Full Range**: Create a complete list of integers from `min_val` to `max_val`. This can be done using a simple loop or a range function.

3. **Check for Missing Integers**: Use a set to store the elements of `nums` for O(1) average-time complexity lookups. Iterate through the constructed full range and check which integers are not present in the set. Collect these missing integers into a result list.

4. **Return the Result**: Finally, return the list of missing integers, which will be sorted by default since we are iterating through the range in ascending order.

### Data Structures:
- A set is used to store the elements of `nums` for efficient membership testing.
- A list is used to collect the missing integers.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array `nums`. This accounts for the time taken to build the set and the time taken to check each integer in the range.
- **Space Complexity**: O(n) in the worst case for storing the elements of `nums` in a set, although the output list for missing integers can be smaller depending on the input.

This approach efficiently identifies the missing integers while ensuring clarity and simplicity in implementation.
