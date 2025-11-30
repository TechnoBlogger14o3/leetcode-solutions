# Make Sum Divisible by P (Medium)

**Problem ID:** 1590  
**Date:** 2025-11-30  
**Link:** https://leetcode.com/problems/make-sum-divisible-by-p/

## Approach

To solve the problem of finding the smallest subarray to remove such that the sum of the remaining elements is divisible by `p`, we can follow these steps:

### Main Idea:
1. **Calculate Total Sum**: First, compute the total sum of the array `nums`. If this sum is already divisible by `p`, then no removal is needed, and we can return `0`.
  
2. **Determine Remainder**: If the total sum is not divisible by `p`, calculate the remainder when the total sum is divided by `p`. This remainder indicates how much we need to adjust the sum to make it divisible by `p`.

3. **Use Prefix Sums and HashMap**: To efficiently find the smallest subarray that can be removed:
   - Maintain a running prefix sum while iterating through the array.
   - Store the indices of the prefix sums modulo `p` in a HashMap. This allows us to quickly find the last occurrence of a specific remainder.
   - For each element, check if removing a subarray that leads to the desired adjustment (i.e., the prefix sum modulo `p` matching the required remainder) can yield a valid solution.

4. **Calculate Minimum Length**: For each valid prefix sum that can help achieve the desired sum, calculate the length of the subarray that would need to be removed. Keep track of the minimum length found.

### Data Structures:
- An integer variable to store the total sum of the array.
- A HashMap (or dictionary) to store the last seen index of each prefix sum modulo `p`.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array. We make a single pass through the array to compute the total sum and another pass to find the minimum removable subarray.
- **Space Complexity**: O(p) in the worst case, due to storing the indices of prefix sums in the HashMap.

### Edge Cases:
- If the total sum is less than `p`, check if removing any single element can achieve the desired condition.
- If no valid subarray can be found, return `-1`.

By following this structured approach, we can efficiently determine the length of the smallest subarray to remove, ensuring that the solution is both optimal and clear.
