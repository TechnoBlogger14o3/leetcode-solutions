# Smallest Missing Multiple of K (Easy)

**Problem ID:** 3718  
**Date:** 2026-08-25  
**Link:** https://leetcode.com/problems/smallest-missing-multiple-of-k/

## Approach

To solve the problem of finding the smallest missing positive multiple of \( k \) from the given array \( nums \), we can follow these steps:

### Approach:

1. **Understanding Multiples of \( k \)**: 
   A multiple of \( k \) can be expressed as \( k, 2k, 3k, \ldots \). We need to find the smallest multiple of \( k \) that is not present in the array \( nums \).

2. **Using a Set for Fast Lookup**:
   To efficiently check if a number is present in \( nums \), we can utilize a set data structure. We will convert the array \( nums \) into a set called `num_set`. This allows for \( O(1) \) average time complexity for membership checks.

3. **Iterating Through Multiples of \( k \)**:
   We start checking from the first multiple of \( k \) (i.e., \( k \)) and continue checking \( k, 2k, 3k, \ldots \) until we find a multiple that is not in `num_set`. 

4. **Stopping Condition**:
   We can stop our search as soon as we find the first multiple of \( k \) that isn't in the set. Given the constraints (with \( k \) and elements of \( nums \) both being at most 100), this approach is efficient.

### Data Structures:
- A set (`num_set`) to store the elements of the array \( nums \) for quick lookup.

### Complexity:
- **Time Complexity**: The time complexity is \( O(n + m) \), where \( n \) is the length of the array \( nums \) (for converting to a set) and \( m \) is the number of multiples of \( k \) we check until we find a missing one. In the worst case, \( m \) can be bounded by \( O(100) \) due to constraints.
- **Space Complexity**: The space complexity is \( O(n) \) for storing the elements in the set.

By following this approach, we can efficiently determine the smallest missing positive multiple of \( k \) from the array \( nums \).
