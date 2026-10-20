# Sum of Sortable Integers (Hard)

**Problem ID:** 3886  
**Date:** 2026-10-20  
**Link:** https://leetcode.com/problems/sum-of-sortable-integers/

## Approach

To solve the problem of finding the sum of all sortable integers \( k \) for the given array \( nums \), we can follow a systematic approach:

### Main Idea:
The core idea is to determine which divisors \( k \) of the array length \( n \) allow the array to be sorted through cyclic rotations of its subarrays of length \( k \). A divisor \( k \) is sortable if, after partitioning the array into \( n/k \) subarrays of size \( k \), we can rearrange each subarray (via cyclic rotations) such that the entire array becomes sorted in non-decreasing order.

### Steps to Approach:

1. **Find Divisors**: Start by identifying all divisors of \( n \). This can be done efficiently by iterating up to the square root of \( n \) and checking for divisibility.

2. **Sort the Array**: Create a sorted version of the original array, which will serve as a reference for checking if the array can be sorted using cyclic rotations.

3. **Check Sortability for Each Divisor**:
   - For each divisor \( k \):
     - Partition the original array into \( n/k \) subarrays of length \( k \).
     - For each subarray, check if the elements can be rearranged (via cyclic rotations) to match the corresponding segment in the sorted array.
     - This can be done by verifying that the elements in each subarray can be matched with the elements in the sorted array segment.

4. **Cyclic Rotation Check**: To determine if two lists can be made identical through cyclic rotations, we can utilize the properties of concatenation. Specifically, if we concatenate a subarray with itself, any valid rotation of that subarray will appear as a contiguous segment within this concatenated array.

5. **Sum Valid Divisors**: Keep a running total of all valid \( k \) that can sort the array.

### Data Structures:
- An array to hold the original numbers and their sorted version.
- A list or set to store valid sortable integers \( k \).

### Complexity:
- Finding divisors takes \( O(\sqrt{n}) \).
- Sorting the array takes \( O(n \log n) \).
- Checking each divisor involves partitioning and validating cyclic rotations, which can be done in linear time relative to \( n \) for each divisor. Therefore, the overall complexity can be approximated as \( O(n \log n + d \cdot n) \), where \( d \) is the number of divisors, which is typically much smaller than \( n \).

By following this structured approach, we can efficiently determine the sum of all sortable integers \( k \) for the given array \( nums \).
