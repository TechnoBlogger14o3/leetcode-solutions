# Largest Perimeter Triangle (Easy)

**Problem ID:** 976  
**Date:** 2025-09-28  
**Link:** https://leetcode.com/problems/largest-perimeter-triangle/

## Approach

To solve the problem of finding the largest perimeter of a triangle that can be formed from three lengths in the given array, we can utilize the triangle inequality theorem. The theorem states that for any three lengths \(a\), \(b\), and \(c\) to form a triangle, the following conditions must hold:

1. \(a + b > c\)
2. \(a + c > b\)
3. \(b + c > a\)

However, if we sort the lengths in non-decreasing order, we only need to check the first condition for the three largest lengths, as the other two will inherently be satisfied. This leads to a more efficient approach.

### Approach:

1. **Sort the Array**: Start by sorting the array `nums` in non-decreasing order. This allows us to easily access the largest lengths and check the triangle inequality.

2. **Check Triples from Largest to Smallest**: Iterate through the sorted array from the end (largest elements) to the beginning, checking every triplet of consecutive lengths:
   - For each triplet \( (nums[i-2], nums[i-1], nums[i]) \), check if \( nums[i-2] + nums[i-1] > nums[i] \).
   - If this condition is satisfied, we have found a valid triangle, and we can compute its perimeter as \( nums[i-2] + nums[i-1] + nums[i] \).

3. **Return the Largest Perimeter**: As soon as we find a valid triplet, we can return the computed perimeter. If we finish checking all possible triplets without finding a valid triangle, return 0.

### Data Structures:
- An array (list) to hold the lengths of the triangle sides.

### Complexity:
- **Time Complexity**: \(O(n \log n)\) due to the sorting step, where \(n\) is the number of elements in the input array.
- **Space Complexity**: \(O(1)\) if we sort in place, or \(O(n)\) if we consider the space used for sorting (noting that Python's sort is stable and can be done in place).

This approach efficiently finds the largest perimeter triangle or determines that none can be formed, adhering to the constraints provided.
