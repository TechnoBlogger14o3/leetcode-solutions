# Find Triangular Sum of an Array (Medium)

**Problem ID:** 2221  
**Date:** 2025-09-30  
**Link:** https://leetcode.com/problems/find-triangular-sum-of-an-array/

## Approach

To solve the problem of finding the triangular sum of an array, we can adopt a straightforward iterative approach that simulates the described process of reducing the array until only one element remains.

### Main Idea:
The process involves repeatedly transforming the input array `nums` into a new array `newNums`, where each element is computed as the sum of consecutive elements from `nums`, taken modulo 10. This continues until `nums` is reduced to a single element, which is the desired triangular sum.

### Steps:
1. **Initialization**: Start with the given array `nums`.
2. **Iteration**: While the length of `nums` is greater than 1:
   - Create a new array `newNums` of size `n - 1` (where `n` is the current length of `nums`).
   - Populate `newNums` by iterating through `nums` and calculating each element as `(nums[i] + nums[i+1]) % 10`.
   - Replace `nums` with `newNums`.
3. **Termination**: Once `nums` has only one element, return that element as the triangular sum.

### Data Structures:
- We primarily use a list (or array) to hold the current state of `nums` and the newly computed `newNums`. The size of `newNums` decreases with each iteration until we reach the final result.

### Complexity:
- **Time Complexity**: The outer loop runs until the array is reduced to one element, which takes `O(n)` iterations for the initial array of size `n`. In each iteration, we perform `O(n)` operations to construct `newNums`. Thus, the total time complexity is `O(n^2)`, where `n` is the initial length of the array.
- **Space Complexity**: The space complexity is `O(n)` for storing the new array in each iteration.

This approach efficiently simulates the transformation process, ensuring that we derive the triangular sum as specified in the problem statement.
