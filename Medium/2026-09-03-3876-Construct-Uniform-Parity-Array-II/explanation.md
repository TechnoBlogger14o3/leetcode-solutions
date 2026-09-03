# Construct Uniform Parity Array II (Medium)

**Problem ID:** 3876  
**Date:** 2026-09-03  
**Link:** https://leetcode.com/problems/construct-uniform-parity-array-ii/

## Approach

To solve the problem of constructing a uniform parity array `nums2` from the given array `nums1`, we can follow a systematic approach based on the properties of odd and even integers.

### Problem Breakdown:
1. **Understanding Parity**: An integer is either odd or even. The goal is to create an array `nums2` where all elements share the same parity (either all odd or all even).

2. **Element Selection**: For each element in `nums1`, we have two choices:
   - Directly use the element as is (`nums2[i] = nums1[i]`).
   - Modify the element by subtracting another distinct element from `nums1` (`nums2[i] = nums1[i] - nums1[j]`), ensuring the result is at least 1.

3. **Key Observations**:
   - If `nums1` contains both odd and even numbers, it is impossible to create a uniform parity array because any subtraction will not change the parity of the original number (odd - odd = even, even - even = even).
   - If all numbers in `nums1` are either odd or even, we can directly construct `nums2` using the elements of `nums1`.

### Solution Steps:
1. **Count Parities**: Iterate through `nums1` and count how many odd and even numbers there are.
2. **Decision Making**:
   - If there are both odd and even numbers (i.e., both counts are greater than zero), return `false`.
   - If all numbers are odd or all are even, return `true`.

### Data Structures:
- A simple integer counter for odd and even counts is sufficient. We do not need any complex data structures since we are only interested in the counts.

### Complexity Analysis:
- **Time Complexity**: O(n), where n is the length of `nums1`. We make a single pass through the array to count odd and even numbers.
- **Space Complexity**: O(1), as we only use a fixed number of counters regardless of the input size.

### Conclusion:
This approach effectively checks the conditions for constructing the desired array with a linear scan, ensuring efficiency even for the upper limit of constraints. By focusing on the parity counts, we can quickly determine the possibility of constructing `nums2`.
