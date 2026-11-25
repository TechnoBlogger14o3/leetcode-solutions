# Smallest Unique Subarray (Hard)

**Problem ID:** 3934  
**Date:** 2026-11-25  
**Link:** https://leetcode.com/problems/smallest-unique-subarray/

## Approach

To solve the problem of finding the smallest unique subarray in an integer array `nums`, we can adopt a systematic approach using a combination of a sliding window technique and a hash map (or dictionary) to track subarray occurrences.

### Approach:

1. **Subarray Generation**: The goal is to identify all possible subarrays and determine their uniqueness. A naive approach would involve generating all subarrays and counting their occurrences, but this is inefficient given the constraints.

2. **Sliding Window Technique**: Instead of generating all subarrays explicitly, we can use a sliding window approach to dynamically track subarrays of varying lengths. This involves expanding and contracting a window over the array to capture different subarrays.

3. **Hash Map for Counting**: We maintain a hash map to count occurrences of each subarray. The key can be a tuple representing the subarray (to ensure immutability), and the value is the count of how many times that subarray appears in `nums`.

4. **Iterate with Two Pointers**: Use two pointers to define the current subarray:
   - The outer loop iterates over the starting index of the subarray.
   - The inner loop expands the subarray by moving the end pointer and updates the hash map with the current subarray representation.

5. **Check for Uniqueness**: After updating the hash map with a new subarray, check if its count is exactly one. If so, record its length and compare it with the minimum length found so far.

6. **Final Result**: After processing all possible subarrays, the smallest length recorded for a unique subarray is our answer.

### Data Structures:
- **Hash Map**: To store subarrays and their counts.
- **List/Array**: To track the lengths of unique subarrays.

### Complexity:
- **Time Complexity**: The approach has a time complexity of O(n^2) in the worst case due to the nested loops for generating subarrays. However, practical optimizations using the sliding window can reduce the average case.
- **Space Complexity**: O(n) for storing the subarrays in the hash map, where n is the length of `nums`.

This method efficiently narrows down the search for the smallest unique subarray by leveraging the properties of hash maps for counting and the sliding window technique for dynamic subarray generation.
