# Smallest Missing Integer Greater Than Sequential Prefix Sum (Easy)

**Problem ID:** 2996  
**Date:** 2026-08-11  
**Link:** https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/

## Approach

To solve the problem of finding the smallest missing integer greater than the sum of the longest sequential prefix in the given array `nums`, we can follow these steps:

### Approach:

1. **Identify the Longest Sequential Prefix**:
   - Iterate through the array `nums` to identify the longest prefix where each element is exactly one greater than the previous element. This can be done by maintaining a counter that checks if the current element is equal to the previous element plus one.
   - Keep track of the length of this prefix and calculate its sum simultaneously.

2. **Calculate the Sum**:
   - As we identify the longest sequential prefix, we will also compute the sum of the elements in this prefix. This will help us determine the threshold value we need to consider for finding the smallest missing integer.

3. **Find the Smallest Missing Integer**:
   - Once we have the sum of the longest sequential prefix, we need to find the smallest integer `x` that is greater than or equal to this sum and is not present in the array `nums`.
   - To efficiently check for the presence of integers in `nums`, we can use a set data structure. This allows for O(1) average time complexity for membership checks.

4. **Iterate from the Sum**:
   - Start checking from the computed sum. Incrementally check each integer to see if it exists in the set. The first integer not found in the set will be our answer.

### Data Structures:
- Use a set to store the elements of `nums` for quick lookup.
- Use simple integer variables to track the current prefix sum and the longest sequential prefix length.

### Complexity:
- **Time Complexity**: O(n) for identifying the longest sequential prefix and O(m) for finding the smallest missing integer, where `m` is the range of integers we check starting from the sum. Given the constraints, this is efficient.
- **Space Complexity**: O(n) for storing the elements of `nums` in a set.

This approach ensures that we efficiently find the required integer while adhering to the problem constraints.
