# Find Two Non-overlapping Sub-arrays Each With Target Sum (Medium)

**Problem ID:** 1477  
**Date:** 2026-09-17  
**Link:** https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/

## Approach

To solve the problem of finding two non-overlapping sub-arrays each with a target sum, we can follow a structured approach that leverages prefix sums and a hash map to efficiently track potential sub-array lengths.

### Main Idea:
1. **Identify Sub-arrays with Target Sum**: First, we need to determine all possible sub-arrays that sum up to the target. We can do this using a sliding window or prefix sum approach to maintain the current sum and check for matches with the target.

2. **Store Minimum Lengths**: As we identify sub-arrays with the target sum, we will store their lengths in a list or array. Additionally, we will maintain a running minimum length of valid sub-arrays that can be used for pairing.

3. **Check for Non-overlapping Conditions**: For each identified sub-array, we need to check if it can be paired with previously found sub-arrays without overlapping. This can be done by ensuring that the end index of the first sub-array is less than the start index of the second sub-array.

4. **Calculate Minimum Length**: As we iterate through the identified sub-arrays, we will keep track of the minimum sum of lengths of two non-overlapping sub-arrays.

### Data Structures:
- **List/Array**: To store the lengths of valid sub-arrays that sum to the target.
- **Hash Map**: To store the last seen index of sub-arrays for quick access and to avoid overlaps.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array. We traverse the array to find sub-arrays and then perform a linear scan to check for valid pairs.
- **Space Complexity**: O(n) in the worst case for storing lengths and indices of sub-arrays.

### Steps:
1. Traverse the array to find all sub-arrays with the target sum and store their lengths.
2. For each sub-array found, check against previously stored lengths to find the minimum sum of lengths of two non-overlapping sub-arrays.
3. Return the minimum sum found, or -1 if no valid pairs exist.

This approach ensures that we efficiently find the required sub-arrays while adhering to the constraints of non-overlapping conditions.
